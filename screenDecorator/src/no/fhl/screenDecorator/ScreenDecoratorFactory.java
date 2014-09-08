/**
 */
package no.fhl.screenDecorator;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see no.fhl.screenDecorator.ScreenDecoratorPackage
 * @generated
 */
public interface ScreenDecoratorFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ScreenDecoratorFactory eINSTANCE = no.fhl.screenDecorator.impl.ScreenDecoratorFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Widget Decorator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Widget Decorator</em>'.
	 * @generated
	 */
	WidgetDecorator createWidgetDecorator();

	/**
	 * Returns a new object of class '<em>Widget Container Decorator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Widget Container Decorator</em>'.
	 * @generated
	 */
	WidgetContainerDecorator createWidgetContainerDecorator();

	/**
	 * Returns a new object of class '<em>Storyboard Decorator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Storyboard Decorator</em>'.
	 * @generated
	 */
	StoryboardDecorator createStoryboardDecorator();

	/**
	 * Returns a new object of class '<em>State Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Action</em>'.
	 * @generated
	 */
	StateAction createStateAction();

	/**
	 * Returns a new object of class '<em>State Mutator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Mutator</em>'.
	 * @generated
	 */
	StateMutator createStateMutator();

	/**
	 * Returns a new object of class '<em>Script Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Script Action</em>'.
	 * @generated
	 */
	ScriptAction createScriptAction();

	/**
	 * Returns a new object of class '<em>Event Script Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Script Action</em>'.
	 * @generated
	 */
	EventScriptAction createEventScriptAction();

	/**
	 * Returns a new object of class '<em>Behavior Properties</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Behavior Properties</em>'.
	 * @generated
	 */
	BehaviorProperties createBehaviorProperties();

	/**
	 * Returns a new object of class '<em>View Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>View Rule</em>'.
	 * @generated
	 */
	ViewRule createViewRule();

	/**
	 * Returns a new object of class '<em>View Properties</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>View Properties</em>'.
	 * @generated
	 */
	ViewProperties createViewProperties();

	/**
	 * Returns a new object of class '<em>Data Properties</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Properties</em>'.
	 * @generated
	 */
	DataProperties createDataProperties();

	/**
	 * Returns a new object of class '<em>Decorator Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Decorator Model</em>'.
	 * @generated
	 */
	DecoratorModel createDecoratorModel();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ScreenDecoratorPackage getScreenDecoratorPackage();

} //ScreenDecoratorFactory
