/**
 */
package no.fhl.javafxTypes.impl;

import javafx.scene.paint.Color;
import no.fhl.javafxTypes.JavafxTypesFactory;
import no.fhl.javafxTypes.JavafxTypesPackage;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JavafxTypesPackageImpl extends EPackageImpl implements JavafxTypesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType fxColorEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see no.fhl.javafxTypes.JavafxTypesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private JavafxTypesPackageImpl() {
		super(eNS_URI, JavafxTypesFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link JavafxTypesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static JavafxTypesPackage init() {
		if (isInited) return (JavafxTypesPackage)EPackage.Registry.INSTANCE.getEPackage(JavafxTypesPackage.eNS_URI);

		// Obtain or create and register package
		JavafxTypesPackageImpl theJavafxTypesPackage = (JavafxTypesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof JavafxTypesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new JavafxTypesPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theJavafxTypesPackage.createPackageContents();

		// Initialize created meta-data
		theJavafxTypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theJavafxTypesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(JavafxTypesPackage.eNS_URI, theJavafxTypesPackage);
		return theJavafxTypesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getFXColor() {
		return fxColorEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavafxTypesFactory getJavafxTypesFactory() {
		return (JavafxTypesFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create data types
		fxColorEDataType = createEDataType(FX_COLOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Initialize data types
		initEDataType(fxColorEDataType, Color.class, "FXColor", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //JavafxTypesPackageImpl
