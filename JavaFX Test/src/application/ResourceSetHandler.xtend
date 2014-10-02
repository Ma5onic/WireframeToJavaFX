package application

import com.wireframesketcher.model.ModelPackage
import java.io.File
import java.util.ArrayList
import java.util.HashMap
import no.fhl.screenDecorator.AbstractDecorator
import no.fhl.screenDecorator.DecoratorModel
import no.fhl.screenDecorator.ScreenDecoratorPackage
import no.fhl.screenDecorator.StoryboardDecorator
import no.fhl.screenDecorator.WidgetContainerDecorator
import no.fhl.screenDecorator.WidgetDecorator
import org.apache.commons.io.FilenameUtils
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.xmi.XMLResource
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl

/** A singleton class that handles all resources, including files of type story, screen, screendecorator and ecore  
 *  @author Fredrik Haugen Larsen
 */
class ResourceSetHandler {

	// Singleton instance
	private static ResourceSetHandler instance = null

	ResourceSet resSet

	/** Get the populated resource set */
	def getResourceSet() {
		resSet
	}

	private ArrayList<String> ecorePathFileList
	/** A list of all ecore files that should have an XMI file instance */
	def getEcorePathFileList() {
		ecorePathFileList
	}

	/** Returns the singleton object of a resource set with all of the following files:
	 * story, screen, screendecorator, ecore. <br>
	 * Directories are taken from the Constants class */
	def static ResourceSetHandler getInstance() {
		if (instance == null) {
			instance = new ResourceSetHandler
		}
		instance
	}

	private def hasXMIInstanceForDecorator(AbstractDecorator decorator) {
		val xmiFile = XMIFile
		// Load the contents of the XMI file into the resource set
		val resource = resSet.getResource(URI.createFileURI(xmiFile.path), true)

		val model = decorator.model
		val ePackage = model.eContainer as EPackage
		val eClassifier = ePackage.getEClassifier(model.name)
		for (eObject : resource.contents) {
			// If the class is found in the contents of the resource
			if (eObject.eClass.name == eClassifier.name) {
				return true
			}
		}
		return false
	}
	
	def createXMIInstances(){
		// Get the XMI file and create the class
			val xmiFile = XMIFile
			
			// Load the xmi resource
			val xmiResource = resSet.getResource(URI.createFileURI(xmiFile.path), true)
			// Empty the file
			xmiResource.contents.clear
			// last inn alle ecore-klassene sånn at man kan lage de 
			
			for (ecoreFilePath : ecorePathFileList){
				var Resource ecoreResource = null 
				var file = new File(ecoreFilePath)
				if(file.exists){
					ecoreResource = resSet.getResource(URI.createFileURI(file.path), true)
					val ePackage = ecoreResource.contents.get(0) as EPackage
					// Allow the XMI editor to open the files
					ePackage.nsURI = "File://" + ecoreResource.URI.path
					val eClass = ePackage.eContents.get(0) as EClass
					var eFactory = ePackage.EFactoryInstance
					val instance = eFactory.create(eClass)
					// Create default values for each feature
					eClass.EStructuralFeatures.forEach[
						if (it.EType == EcorePackage.eINSTANCE.EString){
							// Set the value to an empty string
							instance.eSet(it, "")
						} else if (it.EType == EcorePackage.eINSTANCE.EBoolean){
							instance.eSet(it, false)
						} else if (it.EType == EcorePackage.eINSTANCE.EInt){
							instance.eSet(it, 0)
						}
					]
					
					// Add the instances 
					xmiResource.contents.add(instance)
				}	
			}
			// Use the Schema Location save option so the editor 
			// can handle XMI files 
			var saveOptions = new HashMap() 
			saveOptions.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE) 
			
			xmiResource.save(saveOptions)
	}
	
	def createXMIInstanceForDecorator(AbstractDecorator decorator){
		if (decorator == null){
			println("Cannot create XMI instance for null decorator")
			return 
		} 
		if (decorator.model == null){
			println("Cannot create XMI instance for null decorator.model")
			return 
		}
		if ( hasXMIInstanceForDecorator(decorator) == true){
			// This decorator model instance already exist
			return 
		} else {
			// Get the XMI file and create the class
			val xmiFile = XMIFile
			
			// Load the xmi resource
			val resource = resSet.getResource(URI.createFileURI(xmiFile.path), true)
			var model = decorator.model
			val ePackage = model.eContainer as EPackage
			
			var eFactory = ePackage.EFactoryInstance
			// Get the classifier for this decorator model
			val eClassifier = ePackage.getEClassifier(model.name)
			// create class instance 
			val instance = eFactory.create(eClassifier as EClass)
			// Create default values for each feature
			model.EStructuralFeatures.forEach[
				if (it.EType == EcorePackage.eINSTANCE.EString){
					instance.eSet(it, "default")
				} else if (it.EType == EcorePackage.eINSTANCE.EBoolean){
					instance.eSet(it, false)
				}
			]
			
			// Add the instances and save the XMI file with schema information
			resource.contents.add(instance)
		
			// Use the Schema Location save option so the editor 
			// can handle XMI files 
			var saveOptions = new HashMap (1) 
			saveOptions.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE) 
			resource.save(saveOptions)
			
		}
	}
	def getXMIFile() {
		val directory = Constants.PROJECT_DIR + Constants.SUB_PROJECT_NAME + "/"
		val xmiFile = new File(directory + Constants.SUB_PROJECT_NAME + ".xmi");

		if (xmiFile.exists) {
			return xmiFile
		} else {

			Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("xmi", new XMIResourceFactoryImpl)

			// Create the XMI file		
			var instanceResource = resourceSet.createResource(
				URI.createFileURI(xmiFile.path)
			)

			// Use the Schema Location save option so the editor can handle XMI files 
			var saveOptions = new HashMap(1)
			saveOptions.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE)
			instanceResource.save(saveOptions)
			val savedFile = new File(instanceResource.URI.path)
			if (savedFile.exists == false) {
				println("Error: Unable to create XMI file: " + savedFile)
			}
			return savedFile
		}

	}
	private Resource storyboardResource
	def getStoryboardResource(){
		storyboardResource
	}
	def setStorybardResource(Resource newStoryboard){
		storyboardResource = newStoryboard
	}
	/** Creates a new resource set with all of the following files:
	 * story, screen, screendecorator, ecore. <br>
	 * Directories are taken from the Constants class */
	private new() {

		// Create a resource set and all all relevant files into it.
		// This eliminates different instances of the same files		
		resSet = new ResourceSetImpl
		resSet.packageRegistry.put(ScreenDecoratorPackage.eNS_URI, ScreenDecoratorPackage.eINSTANCE)
		resSet.packageRegistry.put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE)
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("story", new XMIResourceFactoryImpl)
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("screen", new XMIResourceFactoryImpl)
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("screendecorator", new XMIResourceFactoryImpl)
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("ecore", new EcoreResourceFactoryImpl)
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("xmi", new XMIResourceFactoryImpl)

		val directory = new File(Constants.PROJECT_DIR + Constants.SUB_PROJECT_NAME + "/");

		/* Load the .story file and parse which screen files and decorators files apply. 
		 * Load everything in the same resource set - eliminate proxies */
		// Get relevant screen files from the *.story file
		// Should handle several story files in the future, but now only parse the first one found
		
		var didFindStoryfile = false
		for (File fileEntry : directory.listFiles()) {
			if (!fileEntry.isDirectory() && !didFindStoryfile) {
				if (fileEntry.name.endsWith(".story")) {
					didFindStoryfile = true
					val fileName = fileEntry.name.subSequence(0, fileEntry.name.length - ".story".length) as String
					var res = resSet.getResource(
						URI.createFileURI(directory.absolutePath + "/" + fileName + ".story"), true)
					println("Parsing " + directory.absolutePath + "/" + fileName + ".story")
					storybardResource = res
					
					// Resolve the proxies (e.g screen files) in order to load all objects in the same resource set
					EcoreUtil.resolveAll(resSet)
					// Each panel has a screen file - assuming just one Storyboard
					// Subtract the storyboard file
					val numberOfScreenFiles = resSet.resources.size - 1
//					val numberOfScreenFiles = res.contents.filter(Storyboard).get(0).panels.length
					
					/* This includes any assets (Asset.screen) that are used. 
					 * We do want to resolve them into the reosurce set
					 * but not generate fxml from them. The generator should handle this. */
					
					println("Found " + numberOfScreenFiles + " screen files.")
				}
			}
		}
		if (!didFindStoryfile) {
			println("Error: No story file found in " + directory.absolutePath + "/")
			return
		}
		
		

		// Add decorator files to the resource set, but in order to
		// avoid ConcurrentModificationException do it in two steps
		val decoratorFileList = <File>newArrayList()

		resSet.resources.forEach [
			val name = FilenameUtils.getBaseName(it.URI.path)
			val fileExtension = "screendecorator"
			// Check if there is a corrosponding screendecorator file 
			val file = new File(directory + "/" + name + "." + fileExtension)
			// There is a screendecorator
			if (file.exists) {
				decoratorFileList.add(file)

			}
		]

		// Add decorator files to the resource set
		decoratorFileList.forEach [
			println("Loading screendecorator file " + directory + "/" + it.name)
			val fileURI = URI.createFileURI(it.path)
			resSet.getResource(fileURI, true)
		]

		// Load any ecore files and add them to a list 	
		// Build a list of the ecore files which should have corrosponding XMI files
		ecorePathFileList = <String>newArrayList()
		for (File fileEntry : directory.listFiles()) {
			if (!fileEntry.isDirectory()) {
				if (fileEntry.name.endsWith(".ecore")) {

					// Add the file path to list a list used for XMI resources 
					ecorePathFileList.add(fileEntry.path)

					// Add ecore files to the resource set and resolve
					var resource = resSet.getResource(URI.createFileURI(fileEntry.absolutePath), true)

					// Register the package of each resource in the 
					// PackageRegistry of the resource set  
					val eObject = resource.contents.get(0)
					if (eObject instanceof EPackage) {
						val ePackage = eObject as EPackage
						resSet.packageRegistry.put(ePackage.nsURI, ePackage)
					}
				}
			}
		}

		// Resolve the proxies, if there are any. 
		// F.i in case muniapp.ecore has a reference to another /otherPath/file.ecore.
		EcoreUtil.resolveAll(resSet)

		println("Resource set populated.")

	}
	

	/** Traverses the resources and populates the decorator map with 
	 * widgets and their corrosponding widget decorator */
	def getDecoratorMap() {
		val decoratorMap = <Object, AbstractDecorator>newHashMap()
		resSet.resources.forEach [
			it.contents.filter(DecoratorModel).forEach [
				it.decorators.forEach [
					switch (it) {
						WidgetDecorator: decoratorMap.put(widget, it)
						WidgetContainerDecorator: decoratorMap.put(widgetContainer, it)
						StoryboardDecorator: decoratorMap.put(storyboard, it)
					}
				]
			]
		]

		decoratorMap
	}

}
