/**
 */
package no.fhl.screenDecorator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see no.fhl.screenDecorator.ScreenDecoratorFactory
 * @model kind="package"
 * @generated
 */
public interface ScreenDecoratorPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "screenDecorator";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "no.hal.screenDecorator";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "screenDecorator";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ScreenDecoratorPackage eINSTANCE = no.fhl.screenDecorator.impl.ScreenDecoratorPackageImpl.init();

	/**
	 * The meta object id for the '{@link no.fhl.screenDecorator.impl.BehaviorPropertiesImpl <em>Behavior Properties</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.fhl.screenDecorator.impl.BehaviorPropertiesImpl
	 * @see no.fhl.screenDecorator.impl.ScreenDecoratorPackageImpl#getBehaviorProperties()
	 * @generated
	 */
	int BEHAVIOR_PROPERTIES = 9;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_PROPERTIES__ACTIONS = 0;

	/**
	 * The number of structural features of the '<em>Behavior Properties</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_PROPERTIES_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Behavior Properties</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_PROPERTIES_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link no.fhl.screenDecorator.impl.AbstractDecoratorImpl <em>Abstract Decorator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.fhl.screenDecorator.impl.AbstractDecoratorImpl
	 * @see no.fhl.screenDecorator.impl.ScreenDecoratorPackageImpl#getAbstractDecorator()
	 * @generated
	 */
	int ABSTRACT_DECORATOR = 0;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DECORATOR__ACTIONS = BEHAVIOR_PROPERTIES__ACTIONS;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DECORATOR__MODEL = BEHAVIOR_PROPERTIES_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>View Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DECORATOR__VIEW_RULES = BEHAVIOR_PROPERTIES_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Abstract Decorator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DECORATOR_FEATURE_COUNT = BEHAVIOR_PROPERTIES_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Abstract Decorator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DECORATOR_OPERATION_COUNT = BEHAVIOR_PROPERTIES_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link no.fhl.screenDecorator.impl.WidgetDecoratorImpl <em>Widget Decorator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.fhl.screenDecorator.impl.WidgetDecoratorImpl
	 * @see no.fhl.screenDecorator.impl.ScreenDecoratorPackageImpl#getWidgetDecorator()
	 * @generated
	 */
	int WIDGET_DECORATOR = 1;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_DECORATOR__ACTIONS = ABSTRACT_DECORATOR__ACTIONS;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_DECORATOR__MODEL = ABSTRACT_DECORATOR__MODEL;

	/**
	 * The feature id for the '<em><b>View Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_DECORATOR__VIEW_RULES = ABSTRACT_DECORATOR__VIEW_RULES;

	/**
	 * The feature id for the '<em><b>Widget</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_DECORATOR__WIDGET = ABSTRACT_DECORATOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Widget Decorator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_DECORATOR_FEATURE_COUNT = ABSTRACT_DECORATOR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Widget Decorator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_DECORATOR_OPERATION_COUNT = ABSTRACT_DECORATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link no.fhl.screenDecorator.impl.WidgetContainerDecoratorImpl <em>Widget Container Decorator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.fhl.screenDecorator.impl.WidgetContainerDecoratorImpl
	 * @see no.fhl.screenDecorator.impl.ScreenDecoratorPackageImpl#getWidgetContainerDecorator()
	 * @generated
	 */
	int WIDGET_CONTAINER_DECORATOR = 2;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_CONTAINER_DECORATOR__ACTIONS = ABSTRACT_DECORATOR__ACTIONS;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_CONTAINER_DECORATOR__MODEL = ABSTRACT_DECORATOR__MODEL;

	/**
	 * The feature id for the '<em><b>View Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_CONTAINER_DECORATOR__VIEW_RULES = ABSTRACT_DECORATOR__VIEW_RULES;

	/**
	 * The feature id for the '<em><b>Widget Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_CONTAINER_DECORATOR__WIDGET_CONTAINER = ABSTRACT_DECORATOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Widget Container Decorator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_CONTAINER_DECORATOR_FEATURE_COUNT = ABSTRACT_DECORATOR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Widget Container Decorator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_CONTAINER_DECORATOR_OPERATION_COUNT = ABSTRACT_DECORATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link no.fhl.screenDecorator.impl.StoryboardDecoratorImpl <em>Storyboard Decorator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.fhl.screenDecorator.impl.StoryboardDecoratorImpl
	 * @see no.fhl.screenDecorator.impl.ScreenDecoratorPackageImpl#getStoryboardDecorator()
	 * @generated
	 */
	int STORYBOARD_DECORATOR = 3;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORYBOARD_DECORATOR__ACTIONS = ABSTRACT_DECORATOR__ACTIONS;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORYBOARD_DECORATOR__MODEL = ABSTRACT_DECORATOR__MODEL;

	/**
	 * The feature id for the '<em><b>View Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORYBOARD_DECORATOR__VIEW_RULES = ABSTRACT_DECORATOR__VIEW_RULES;

	/**
	 * The feature id for the '<em><b>Storyboard</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORYBOARD_DECORATOR__STORYBOARD = ABSTRACT_DECORATOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Storyboard Decorator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORYBOARD_DECORATOR_FEATURE_COUNT = ABSTRACT_DECORATOR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Storyboard Decorator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORYBOARD_DECORATOR_OPERATION_COUNT = ABSTRACT_DECORATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link no.fhl.screenDecorator.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.fhl.screenDecorator.impl.ActionImpl
	 * @see no.fhl.screenDecorator.impl.ScreenDecoratorPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 4;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link no.fhl.screenDecorator.impl.StateActionImpl <em>State Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.fhl.screenDecorator.impl.StateActionImpl
	 * @see no.fhl.screenDecorator.impl.ScreenDecoratorPackageImpl#getStateAction()
	 * @generated
	 */
	int STATE_ACTION = 5;

	/**
	 * The feature id for the '<em><b>State Mutators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_ACTION__STATE_MUTATORS = 0;

	/**
	 * The number of structural features of the '<em>State Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_ACTION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>State Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_ACTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link no.fhl.screenDecorator.impl.StateMutatorImpl <em>State Mutator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.fhl.screenDecorator.impl.StateMutatorImpl
	 * @see no.fhl.screenDecorator.impl.ScreenDecoratorPackageImpl#getStateMutator()
	 * @generated
	 */
	int STATE_MUTATOR = 6;

	/**
	 * The feature id for the '<em><b>State Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MUTATOR__STATE_FEATURE = 0;

	/**
	 * The feature id for the '<em><b>State Feature Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MUTATOR__STATE_FEATURE_VALUE = 1;

	/**
	 * The number of structural features of the '<em>State Mutator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MUTATOR_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>State Mutator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MUTATOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link no.fhl.screenDecorator.impl.ScriptActionImpl <em>Script Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.fhl.screenDecorator.impl.ScriptActionImpl
	 * @see no.fhl.screenDecorator.impl.ScreenDecoratorPackageImpl#getScriptAction()
	 * @generated
	 */
	int SCRIPT_ACTION = 7;

	/**
	 * The feature id for the '<em><b>Script</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_ACTION__SCRIPT = ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Script Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_ACTION_FEATURE_COUNT = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Script Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_ACTION_OPERATION_COUNT = ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link no.fhl.screenDecorator.impl.EventScriptActionImpl <em>Event Script Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.fhl.screenDecorator.impl.EventScriptActionImpl
	 * @see no.fhl.screenDecorator.impl.ScreenDecoratorPackageImpl#getEventScriptAction()
	 * @generated
	 */
	int EVENT_SCRIPT_ACTION = 8;

	/**
	 * The feature id for the '<em><b>Script</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_SCRIPT_ACTION__SCRIPT = SCRIPT_ACTION__SCRIPT;

	/**
	 * The feature id for the '<em><b>Event Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_SCRIPT_ACTION__EVENT_NAME = SCRIPT_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Event Script Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_SCRIPT_ACTION_FEATURE_COUNT = SCRIPT_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Event Script Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_SCRIPT_ACTION_OPERATION_COUNT = SCRIPT_ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link no.fhl.screenDecorator.impl.ViewRuleImpl <em>View Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.fhl.screenDecorator.impl.ViewRuleImpl
	 * @see no.fhl.screenDecorator.impl.ScreenDecoratorPackageImpl#getViewRule()
	 * @generated
	 */
	int VIEW_RULE = 10;

	/**
	 * The feature id for the '<em><b>State Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_RULE__STATE_FEATURE = 0;

	/**
	 * The feature id for the '<em><b>State Feature Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_RULE__STATE_FEATURE_VALUE = 1;

	/**
	 * The feature id for the '<em><b>View Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_RULE__VIEW_PROPERTY = 2;

	/**
	 * The feature id for the '<em><b>View Property Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_RULE__VIEW_PROPERTY_TYPE = 3;

	/**
	 * The feature id for the '<em><b>View Property Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_RULE__VIEW_PROPERTY_VALUE = 4;

	/**
	 * The number of structural features of the '<em>View Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_RULE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>View Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_RULE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link no.fhl.screenDecorator.impl.ViewPropertiesImpl <em>View Properties</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.fhl.screenDecorator.impl.ViewPropertiesImpl
	 * @see no.fhl.screenDecorator.impl.ScreenDecoratorPackageImpl#getViewProperties()
	 * @generated
	 */
	int VIEW_PROPERTIES = 11;

	/**
	 * The feature id for the '<em><b>View Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_PROPERTIES__VIEW_RULES = 0;

	/**
	 * The number of structural features of the '<em>View Properties</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_PROPERTIES_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>View Properties</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_PROPERTIES_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link no.fhl.screenDecorator.impl.DataPropertiesImpl <em>Data Properties</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.fhl.screenDecorator.impl.DataPropertiesImpl
	 * @see no.fhl.screenDecorator.impl.ScreenDecoratorPackageImpl#getDataProperties()
	 * @generated
	 */
	int DATA_PROPERTIES = 12;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROPERTIES__MODEL = 0;

	/**
	 * The number of structural features of the '<em>Data Properties</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROPERTIES_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Data Properties</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROPERTIES_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link no.fhl.screenDecorator.impl.DecoratorModelImpl <em>Decorator Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.fhl.screenDecorator.impl.DecoratorModelImpl
	 * @see no.fhl.screenDecorator.impl.ScreenDecoratorPackageImpl#getDecoratorModel()
	 * @generated
	 */
	int DECORATOR_MODEL = 13;

	/**
	 * The feature id for the '<em><b>Decorators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECORATOR_MODEL__DECORATORS = 0;

	/**
	 * The number of structural features of the '<em>Decorator Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECORATOR_MODEL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Decorator Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECORATOR_MODEL_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link no.fhl.screenDecorator.AbstractDecorator <em>Abstract Decorator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Decorator</em>'.
	 * @see no.fhl.screenDecorator.AbstractDecorator
	 * @generated
	 */
	EClass getAbstractDecorator();

	/**
	 * Returns the meta object for class '{@link no.fhl.screenDecorator.WidgetDecorator <em>Widget Decorator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Widget Decorator</em>'.
	 * @see no.fhl.screenDecorator.WidgetDecorator
	 * @generated
	 */
	EClass getWidgetDecorator();

	/**
	 * Returns the meta object for the reference '{@link no.fhl.screenDecorator.WidgetDecorator#getWidget <em>Widget</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Widget</em>'.
	 * @see no.fhl.screenDecorator.WidgetDecorator#getWidget()
	 * @see #getWidgetDecorator()
	 * @generated
	 */
	EReference getWidgetDecorator_Widget();

	/**
	 * Returns the meta object for class '{@link no.fhl.screenDecorator.WidgetContainerDecorator <em>Widget Container Decorator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Widget Container Decorator</em>'.
	 * @see no.fhl.screenDecorator.WidgetContainerDecorator
	 * @generated
	 */
	EClass getWidgetContainerDecorator();

	/**
	 * Returns the meta object for the reference '{@link no.fhl.screenDecorator.WidgetContainerDecorator#getWidgetContainer <em>Widget Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Widget Container</em>'.
	 * @see no.fhl.screenDecorator.WidgetContainerDecorator#getWidgetContainer()
	 * @see #getWidgetContainerDecorator()
	 * @generated
	 */
	EReference getWidgetContainerDecorator_WidgetContainer();

	/**
	 * Returns the meta object for class '{@link no.fhl.screenDecorator.StoryboardDecorator <em>Storyboard Decorator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Storyboard Decorator</em>'.
	 * @see no.fhl.screenDecorator.StoryboardDecorator
	 * @generated
	 */
	EClass getStoryboardDecorator();

	/**
	 * Returns the meta object for the reference '{@link no.fhl.screenDecorator.StoryboardDecorator#getStoryboard <em>Storyboard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Storyboard</em>'.
	 * @see no.fhl.screenDecorator.StoryboardDecorator#getStoryboard()
	 * @see #getStoryboardDecorator()
	 * @generated
	 */
	EReference getStoryboardDecorator_Storyboard();

	/**
	 * Returns the meta object for class '{@link no.fhl.screenDecorator.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see no.fhl.screenDecorator.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for class '{@link no.fhl.screenDecorator.StateAction <em>State Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Action</em>'.
	 * @see no.fhl.screenDecorator.StateAction
	 * @generated
	 */
	EClass getStateAction();

	/**
	 * Returns the meta object for the containment reference list '{@link no.fhl.screenDecorator.StateAction#getStateMutators <em>State Mutators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>State Mutators</em>'.
	 * @see no.fhl.screenDecorator.StateAction#getStateMutators()
	 * @see #getStateAction()
	 * @generated
	 */
	EReference getStateAction_StateMutators();

	/**
	 * Returns the meta object for class '{@link no.fhl.screenDecorator.StateMutator <em>State Mutator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Mutator</em>'.
	 * @see no.fhl.screenDecorator.StateMutator
	 * @generated
	 */
	EClass getStateMutator();

	/**
	 * Returns the meta object for the reference '{@link no.fhl.screenDecorator.StateMutator#getStateFeature <em>State Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>State Feature</em>'.
	 * @see no.fhl.screenDecorator.StateMutator#getStateFeature()
	 * @see #getStateMutator()
	 * @generated
	 */
	EReference getStateMutator_StateFeature();

	/**
	 * Returns the meta object for the attribute '{@link no.fhl.screenDecorator.StateMutator#getStateFeatureValue <em>State Feature Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State Feature Value</em>'.
	 * @see no.fhl.screenDecorator.StateMutator#getStateFeatureValue()
	 * @see #getStateMutator()
	 * @generated
	 */
	EAttribute getStateMutator_StateFeatureValue();

	/**
	 * Returns the meta object for class '{@link no.fhl.screenDecorator.ScriptAction <em>Script Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Script Action</em>'.
	 * @see no.fhl.screenDecorator.ScriptAction
	 * @generated
	 */
	EClass getScriptAction();

	/**
	 * Returns the meta object for the attribute '{@link no.fhl.screenDecorator.ScriptAction#getScript <em>Script</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Script</em>'.
	 * @see no.fhl.screenDecorator.ScriptAction#getScript()
	 * @see #getScriptAction()
	 * @generated
	 */
	EAttribute getScriptAction_Script();

	/**
	 * Returns the meta object for class '{@link no.fhl.screenDecorator.EventScriptAction <em>Event Script Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Script Action</em>'.
	 * @see no.fhl.screenDecorator.EventScriptAction
	 * @generated
	 */
	EClass getEventScriptAction();

	/**
	 * Returns the meta object for the attribute '{@link no.fhl.screenDecorator.EventScriptAction#getEventName <em>Event Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Event Name</em>'.
	 * @see no.fhl.screenDecorator.EventScriptAction#getEventName()
	 * @see #getEventScriptAction()
	 * @generated
	 */
	EAttribute getEventScriptAction_EventName();

	/**
	 * Returns the meta object for class '{@link no.fhl.screenDecorator.BehaviorProperties <em>Behavior Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior Properties</em>'.
	 * @see no.fhl.screenDecorator.BehaviorProperties
	 * @generated
	 */
	EClass getBehaviorProperties();

	/**
	 * Returns the meta object for the containment reference list '{@link no.fhl.screenDecorator.BehaviorProperties#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see no.fhl.screenDecorator.BehaviorProperties#getActions()
	 * @see #getBehaviorProperties()
	 * @generated
	 */
	EReference getBehaviorProperties_Actions();

	/**
	 * Returns the meta object for class '{@link no.fhl.screenDecorator.ViewRule <em>View Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>View Rule</em>'.
	 * @see no.fhl.screenDecorator.ViewRule
	 * @generated
	 */
	EClass getViewRule();

	/**
	 * Returns the meta object for the reference '{@link no.fhl.screenDecorator.ViewRule#getStateFeature <em>State Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>State Feature</em>'.
	 * @see no.fhl.screenDecorator.ViewRule#getStateFeature()
	 * @see #getViewRule()
	 * @generated
	 */
	EReference getViewRule_StateFeature();

	/**
	 * Returns the meta object for the attribute '{@link no.fhl.screenDecorator.ViewRule#getStateFeatureValue <em>State Feature Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State Feature Value</em>'.
	 * @see no.fhl.screenDecorator.ViewRule#getStateFeatureValue()
	 * @see #getViewRule()
	 * @generated
	 */
	EAttribute getViewRule_StateFeatureValue();

	/**
	 * Returns the meta object for the attribute '{@link no.fhl.screenDecorator.ViewRule#getViewProperty <em>View Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>View Property</em>'.
	 * @see no.fhl.screenDecorator.ViewRule#getViewProperty()
	 * @see #getViewRule()
	 * @generated
	 */
	EAttribute getViewRule_ViewProperty();

	/**
	 * Returns the meta object for the reference '{@link no.fhl.screenDecorator.ViewRule#getViewPropertyType <em>View Property Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>View Property Type</em>'.
	 * @see no.fhl.screenDecorator.ViewRule#getViewPropertyType()
	 * @see #getViewRule()
	 * @generated
	 */
	EReference getViewRule_ViewPropertyType();

	/**
	 * Returns the meta object for the attribute '{@link no.fhl.screenDecorator.ViewRule#getViewPropertyValue <em>View Property Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>View Property Value</em>'.
	 * @see no.fhl.screenDecorator.ViewRule#getViewPropertyValue()
	 * @see #getViewRule()
	 * @generated
	 */
	EAttribute getViewRule_ViewPropertyValue();

	/**
	 * Returns the meta object for class '{@link no.fhl.screenDecorator.ViewProperties <em>View Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>View Properties</em>'.
	 * @see no.fhl.screenDecorator.ViewProperties
	 * @generated
	 */
	EClass getViewProperties();

	/**
	 * Returns the meta object for the containment reference list '{@link no.fhl.screenDecorator.ViewProperties#getViewRules <em>View Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>View Rules</em>'.
	 * @see no.fhl.screenDecorator.ViewProperties#getViewRules()
	 * @see #getViewProperties()
	 * @generated
	 */
	EReference getViewProperties_ViewRules();

	/**
	 * Returns the meta object for class '{@link no.fhl.screenDecorator.DataProperties <em>Data Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Properties</em>'.
	 * @see no.fhl.screenDecorator.DataProperties
	 * @generated
	 */
	EClass getDataProperties();

	/**
	 * Returns the meta object for the reference '{@link no.fhl.screenDecorator.DataProperties#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model</em>'.
	 * @see no.fhl.screenDecorator.DataProperties#getModel()
	 * @see #getDataProperties()
	 * @generated
	 */
	EReference getDataProperties_Model();

	/**
	 * Returns the meta object for class '{@link no.fhl.screenDecorator.DecoratorModel <em>Decorator Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Decorator Model</em>'.
	 * @see no.fhl.screenDecorator.DecoratorModel
	 * @generated
	 */
	EClass getDecoratorModel();

	/**
	 * Returns the meta object for the containment reference list '{@link no.fhl.screenDecorator.DecoratorModel#getDecorators <em>Decorators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Decorators</em>'.
	 * @see no.fhl.screenDecorator.DecoratorModel#getDecorators()
	 * @see #getDecoratorModel()
	 * @generated
	 */
	EReference getDecoratorModel_Decorators();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ScreenDecoratorFactory getScreenDecoratorFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link no.fhl.screenDecorator.impl.AbstractDecoratorImpl <em>Abstract Decorator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.fhl.screenDecorator.impl.AbstractDecoratorImpl
		 * @see no.fhl.screenDecorator.impl.ScreenDecoratorPackageImpl#getAbstractDecorator()
		 * @generated
		 */
		EClass ABSTRACT_DECORATOR = eINSTANCE.getAbstractDecorator();

		/**
		 * The meta object literal for the '{@link no.fhl.screenDecorator.impl.WidgetDecoratorImpl <em>Widget Decorator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.fhl.screenDecorator.impl.WidgetDecoratorImpl
		 * @see no.fhl.screenDecorator.impl.ScreenDecoratorPackageImpl#getWidgetDecorator()
		 * @generated
		 */
		EClass WIDGET_DECORATOR = eINSTANCE.getWidgetDecorator();

		/**
		 * The meta object literal for the '<em><b>Widget</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIDGET_DECORATOR__WIDGET = eINSTANCE.getWidgetDecorator_Widget();

		/**
		 * The meta object literal for the '{@link no.fhl.screenDecorator.impl.WidgetContainerDecoratorImpl <em>Widget Container Decorator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.fhl.screenDecorator.impl.WidgetContainerDecoratorImpl
		 * @see no.fhl.screenDecorator.impl.ScreenDecoratorPackageImpl#getWidgetContainerDecorator()
		 * @generated
		 */
		EClass WIDGET_CONTAINER_DECORATOR = eINSTANCE.getWidgetContainerDecorator();

		/**
		 * The meta object literal for the '<em><b>Widget Container</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIDGET_CONTAINER_DECORATOR__WIDGET_CONTAINER = eINSTANCE.getWidgetContainerDecorator_WidgetContainer();

		/**
		 * The meta object literal for the '{@link no.fhl.screenDecorator.impl.StoryboardDecoratorImpl <em>Storyboard Decorator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.fhl.screenDecorator.impl.StoryboardDecoratorImpl
		 * @see no.fhl.screenDecorator.impl.ScreenDecoratorPackageImpl#getStoryboardDecorator()
		 * @generated
		 */
		EClass STORYBOARD_DECORATOR = eINSTANCE.getStoryboardDecorator();

		/**
		 * The meta object literal for the '<em><b>Storyboard</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORYBOARD_DECORATOR__STORYBOARD = eINSTANCE.getStoryboardDecorator_Storyboard();

		/**
		 * The meta object literal for the '{@link no.fhl.screenDecorator.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.fhl.screenDecorator.impl.ActionImpl
		 * @see no.fhl.screenDecorator.impl.ScreenDecoratorPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '{@link no.fhl.screenDecorator.impl.StateActionImpl <em>State Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.fhl.screenDecorator.impl.StateActionImpl
		 * @see no.fhl.screenDecorator.impl.ScreenDecoratorPackageImpl#getStateAction()
		 * @generated
		 */
		EClass STATE_ACTION = eINSTANCE.getStateAction();

		/**
		 * The meta object literal for the '<em><b>State Mutators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_ACTION__STATE_MUTATORS = eINSTANCE.getStateAction_StateMutators();

		/**
		 * The meta object literal for the '{@link no.fhl.screenDecorator.impl.StateMutatorImpl <em>State Mutator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.fhl.screenDecorator.impl.StateMutatorImpl
		 * @see no.fhl.screenDecorator.impl.ScreenDecoratorPackageImpl#getStateMutator()
		 * @generated
		 */
		EClass STATE_MUTATOR = eINSTANCE.getStateMutator();

		/**
		 * The meta object literal for the '<em><b>State Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MUTATOR__STATE_FEATURE = eINSTANCE.getStateMutator_StateFeature();

		/**
		 * The meta object literal for the '<em><b>State Feature Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE_MUTATOR__STATE_FEATURE_VALUE = eINSTANCE.getStateMutator_StateFeatureValue();

		/**
		 * The meta object literal for the '{@link no.fhl.screenDecorator.impl.ScriptActionImpl <em>Script Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.fhl.screenDecorator.impl.ScriptActionImpl
		 * @see no.fhl.screenDecorator.impl.ScreenDecoratorPackageImpl#getScriptAction()
		 * @generated
		 */
		EClass SCRIPT_ACTION = eINSTANCE.getScriptAction();

		/**
		 * The meta object literal for the '<em><b>Script</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCRIPT_ACTION__SCRIPT = eINSTANCE.getScriptAction_Script();

		/**
		 * The meta object literal for the '{@link no.fhl.screenDecorator.impl.EventScriptActionImpl <em>Event Script Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.fhl.screenDecorator.impl.EventScriptActionImpl
		 * @see no.fhl.screenDecorator.impl.ScreenDecoratorPackageImpl#getEventScriptAction()
		 * @generated
		 */
		EClass EVENT_SCRIPT_ACTION = eINSTANCE.getEventScriptAction();

		/**
		 * The meta object literal for the '<em><b>Event Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_SCRIPT_ACTION__EVENT_NAME = eINSTANCE.getEventScriptAction_EventName();

		/**
		 * The meta object literal for the '{@link no.fhl.screenDecorator.impl.BehaviorPropertiesImpl <em>Behavior Properties</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.fhl.screenDecorator.impl.BehaviorPropertiesImpl
		 * @see no.fhl.screenDecorator.impl.ScreenDecoratorPackageImpl#getBehaviorProperties()
		 * @generated
		 */
		EClass BEHAVIOR_PROPERTIES = eINSTANCE.getBehaviorProperties();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_PROPERTIES__ACTIONS = eINSTANCE.getBehaviorProperties_Actions();

		/**
		 * The meta object literal for the '{@link no.fhl.screenDecorator.impl.ViewRuleImpl <em>View Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.fhl.screenDecorator.impl.ViewRuleImpl
		 * @see no.fhl.screenDecorator.impl.ScreenDecoratorPackageImpl#getViewRule()
		 * @generated
		 */
		EClass VIEW_RULE = eINSTANCE.getViewRule();

		/**
		 * The meta object literal for the '<em><b>State Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW_RULE__STATE_FEATURE = eINSTANCE.getViewRule_StateFeature();

		/**
		 * The meta object literal for the '<em><b>State Feature Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEW_RULE__STATE_FEATURE_VALUE = eINSTANCE.getViewRule_StateFeatureValue();

		/**
		 * The meta object literal for the '<em><b>View Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEW_RULE__VIEW_PROPERTY = eINSTANCE.getViewRule_ViewProperty();

		/**
		 * The meta object literal for the '<em><b>View Property Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW_RULE__VIEW_PROPERTY_TYPE = eINSTANCE.getViewRule_ViewPropertyType();

		/**
		 * The meta object literal for the '<em><b>View Property Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEW_RULE__VIEW_PROPERTY_VALUE = eINSTANCE.getViewRule_ViewPropertyValue();

		/**
		 * The meta object literal for the '{@link no.fhl.screenDecorator.impl.ViewPropertiesImpl <em>View Properties</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.fhl.screenDecorator.impl.ViewPropertiesImpl
		 * @see no.fhl.screenDecorator.impl.ScreenDecoratorPackageImpl#getViewProperties()
		 * @generated
		 */
		EClass VIEW_PROPERTIES = eINSTANCE.getViewProperties();

		/**
		 * The meta object literal for the '<em><b>View Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW_PROPERTIES__VIEW_RULES = eINSTANCE.getViewProperties_ViewRules();

		/**
		 * The meta object literal for the '{@link no.fhl.screenDecorator.impl.DataPropertiesImpl <em>Data Properties</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.fhl.screenDecorator.impl.DataPropertiesImpl
		 * @see no.fhl.screenDecorator.impl.ScreenDecoratorPackageImpl#getDataProperties()
		 * @generated
		 */
		EClass DATA_PROPERTIES = eINSTANCE.getDataProperties();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_PROPERTIES__MODEL = eINSTANCE.getDataProperties_Model();

		/**
		 * The meta object literal for the '{@link no.fhl.screenDecorator.impl.DecoratorModelImpl <em>Decorator Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.fhl.screenDecorator.impl.DecoratorModelImpl
		 * @see no.fhl.screenDecorator.impl.ScreenDecoratorPackageImpl#getDecoratorModel()
		 * @generated
		 */
		EClass DECORATOR_MODEL = eINSTANCE.getDecoratorModel();

		/**
		 * The meta object literal for the '<em><b>Decorators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECORATOR_MODEL__DECORATORS = eINSTANCE.getDecoratorModel_Decorators();

	}

} //ScreenDecoratorPackage
