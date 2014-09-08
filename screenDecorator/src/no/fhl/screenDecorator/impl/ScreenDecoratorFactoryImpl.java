/**
 */
package no.fhl.screenDecorator.impl;

import no.fhl.screenDecorator.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ScreenDecoratorFactoryImpl extends EFactoryImpl implements ScreenDecoratorFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ScreenDecoratorFactory init() {
		try {
			ScreenDecoratorFactory theScreenDecoratorFactory = (ScreenDecoratorFactory)EPackage.Registry.INSTANCE.getEFactory(ScreenDecoratorPackage.eNS_URI);
			if (theScreenDecoratorFactory != null) {
				return theScreenDecoratorFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ScreenDecoratorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScreenDecoratorFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ScreenDecoratorPackage.WIDGET_DECORATOR: return createWidgetDecorator();
			case ScreenDecoratorPackage.WIDGET_CONTAINER_DECORATOR: return createWidgetContainerDecorator();
			case ScreenDecoratorPackage.STORYBOARD_DECORATOR: return createStoryboardDecorator();
			case ScreenDecoratorPackage.STATE_ACTION: return createStateAction();
			case ScreenDecoratorPackage.STATE_MUTATOR: return createStateMutator();
			case ScreenDecoratorPackage.SCRIPT_ACTION: return createScriptAction();
			case ScreenDecoratorPackage.EVENT_SCRIPT_ACTION: return createEventScriptAction();
			case ScreenDecoratorPackage.BEHAVIOR_PROPERTIES: return createBehaviorProperties();
			case ScreenDecoratorPackage.VIEW_RULE: return createViewRule();
			case ScreenDecoratorPackage.VIEW_PROPERTIES: return createViewProperties();
			case ScreenDecoratorPackage.DATA_PROPERTIES: return createDataProperties();
			case ScreenDecoratorPackage.DECORATOR_MODEL: return createDecoratorModel();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WidgetDecorator createWidgetDecorator() {
		WidgetDecoratorImpl widgetDecorator = new WidgetDecoratorImpl();
		return widgetDecorator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WidgetContainerDecorator createWidgetContainerDecorator() {
		WidgetContainerDecoratorImpl widgetContainerDecorator = new WidgetContainerDecoratorImpl();
		return widgetContainerDecorator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoryboardDecorator createStoryboardDecorator() {
		StoryboardDecoratorImpl storyboardDecorator = new StoryboardDecoratorImpl();
		return storyboardDecorator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateAction createStateAction() {
		StateActionImpl stateAction = new StateActionImpl();
		return stateAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateMutator createStateMutator() {
		StateMutatorImpl stateMutator = new StateMutatorImpl();
		return stateMutator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScriptAction createScriptAction() {
		ScriptActionImpl scriptAction = new ScriptActionImpl();
		return scriptAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventScriptAction createEventScriptAction() {
		EventScriptActionImpl eventScriptAction = new EventScriptActionImpl();
		return eventScriptAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorProperties createBehaviorProperties() {
		BehaviorPropertiesImpl behaviorProperties = new BehaviorPropertiesImpl();
		return behaviorProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ViewRule createViewRule() {
		ViewRuleImpl viewRule = new ViewRuleImpl();
		return viewRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ViewProperties createViewProperties() {
		ViewPropertiesImpl viewProperties = new ViewPropertiesImpl();
		return viewProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataProperties createDataProperties() {
		DataPropertiesImpl dataProperties = new DataPropertiesImpl();
		return dataProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DecoratorModel createDecoratorModel() {
		DecoratorModelImpl decoratorModel = new DecoratorModelImpl();
		return decoratorModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScreenDecoratorPackage getScreenDecoratorPackage() {
		return (ScreenDecoratorPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ScreenDecoratorPackage getPackage() {
		return ScreenDecoratorPackage.eINSTANCE;
	}

} //ScreenDecoratorFactoryImpl
