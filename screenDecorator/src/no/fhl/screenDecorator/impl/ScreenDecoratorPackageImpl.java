/**
 */
package no.fhl.screenDecorator.impl;

import com.wireframesketcher.model.ModelPackage;

import com.wireframesketcher.model.story.StoryPackage;

import no.fhl.screenDecorator.AbstractDecorator;
import no.fhl.screenDecorator.Action;
import no.fhl.screenDecorator.BehaviorProperties;
import no.fhl.screenDecorator.DataProperties;
import no.fhl.screenDecorator.DecoratorModel;
import no.fhl.screenDecorator.EventScriptAction;
import no.fhl.screenDecorator.ScreenDecoratorFactory;
import no.fhl.screenDecorator.ScreenDecoratorPackage;
import no.fhl.screenDecorator.ScriptAction;
import no.fhl.screenDecorator.StateAction;
import no.fhl.screenDecorator.StateMutator;
import no.fhl.screenDecorator.StoryboardDecorator;
import no.fhl.screenDecorator.ViewProperties;
import no.fhl.screenDecorator.ViewRule;
import no.fhl.screenDecorator.WidgetContainerDecorator;
import no.fhl.screenDecorator.WidgetDecorator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ScreenDecoratorPackageImpl extends EPackageImpl implements ScreenDecoratorPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractDecoratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass widgetDecoratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass widgetContainerDecoratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass storyboardDecoratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateMutatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scriptActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventScriptActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass decoratorModelEClass = null;

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
	 * @see no.fhl.screenDecorator.ScreenDecoratorPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ScreenDecoratorPackageImpl() {
		super(eNS_URI, ScreenDecoratorFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ScreenDecoratorPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ScreenDecoratorPackage init() {
		if (isInited) return (ScreenDecoratorPackage)EPackage.Registry.INSTANCE.getEPackage(ScreenDecoratorPackage.eNS_URI);

		// Obtain or create and register package
		ScreenDecoratorPackageImpl theScreenDecoratorPackage = (ScreenDecoratorPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ScreenDecoratorPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ScreenDecoratorPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		ModelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theScreenDecoratorPackage.createPackageContents();

		// Initialize created meta-data
		theScreenDecoratorPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theScreenDecoratorPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ScreenDecoratorPackage.eNS_URI, theScreenDecoratorPackage);
		return theScreenDecoratorPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractDecorator() {
		return abstractDecoratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWidgetDecorator() {
		return widgetDecoratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWidgetDecorator_Widget() {
		return (EReference)widgetDecoratorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWidgetContainerDecorator() {
		return widgetContainerDecoratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWidgetContainerDecorator_WidgetContainer() {
		return (EReference)widgetContainerDecoratorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStoryboardDecorator() {
		return storyboardDecoratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStoryboardDecorator_Storyboard() {
		return (EReference)storyboardDecoratorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAction() {
		return actionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStateAction() {
		return stateActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateAction_StateMutators() {
		return (EReference)stateActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStateMutator() {
		return stateMutatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateMutator_StateFeature() {
		return (EReference)stateMutatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStateMutator_StateFeatureValue() {
		return (EAttribute)stateMutatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScriptAction() {
		return scriptActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScriptAction_Script() {
		return (EAttribute)scriptActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventScriptAction() {
		return eventScriptActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEventScriptAction_EventName() {
		return (EAttribute)eventScriptActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorProperties() {
		return behaviorPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorProperties_Actions() {
		return (EReference)behaviorPropertiesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getViewRule() {
		return viewRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getViewRule_StateFeature() {
		return (EReference)viewRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getViewRule_StateFeatureValue() {
		return (EAttribute)viewRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getViewRule_ViewProperty() {
		return (EAttribute)viewRuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getViewRule_ViewPropertyType() {
		return (EReference)viewRuleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getViewRule_ViewPropertyValue() {
		return (EAttribute)viewRuleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getViewProperties() {
		return viewPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getViewProperties_ViewRules() {
		return (EReference)viewPropertiesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataProperties() {
		return dataPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataProperties_Model() {
		return (EReference)dataPropertiesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDecoratorModel() {
		return decoratorModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDecoratorModel_Decorators() {
		return (EReference)decoratorModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScreenDecoratorFactory getScreenDecoratorFactory() {
		return (ScreenDecoratorFactory)getEFactoryInstance();
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

		// Create classes and their features
		abstractDecoratorEClass = createEClass(ABSTRACT_DECORATOR);

		widgetDecoratorEClass = createEClass(WIDGET_DECORATOR);
		createEReference(widgetDecoratorEClass, WIDGET_DECORATOR__WIDGET);

		widgetContainerDecoratorEClass = createEClass(WIDGET_CONTAINER_DECORATOR);
		createEReference(widgetContainerDecoratorEClass, WIDGET_CONTAINER_DECORATOR__WIDGET_CONTAINER);

		storyboardDecoratorEClass = createEClass(STORYBOARD_DECORATOR);
		createEReference(storyboardDecoratorEClass, STORYBOARD_DECORATOR__STORYBOARD);

		actionEClass = createEClass(ACTION);

		stateActionEClass = createEClass(STATE_ACTION);
		createEReference(stateActionEClass, STATE_ACTION__STATE_MUTATORS);

		stateMutatorEClass = createEClass(STATE_MUTATOR);
		createEReference(stateMutatorEClass, STATE_MUTATOR__STATE_FEATURE);
		createEAttribute(stateMutatorEClass, STATE_MUTATOR__STATE_FEATURE_VALUE);

		scriptActionEClass = createEClass(SCRIPT_ACTION);
		createEAttribute(scriptActionEClass, SCRIPT_ACTION__SCRIPT);

		eventScriptActionEClass = createEClass(EVENT_SCRIPT_ACTION);
		createEAttribute(eventScriptActionEClass, EVENT_SCRIPT_ACTION__EVENT_NAME);

		behaviorPropertiesEClass = createEClass(BEHAVIOR_PROPERTIES);
		createEReference(behaviorPropertiesEClass, BEHAVIOR_PROPERTIES__ACTIONS);

		viewRuleEClass = createEClass(VIEW_RULE);
		createEReference(viewRuleEClass, VIEW_RULE__STATE_FEATURE);
		createEAttribute(viewRuleEClass, VIEW_RULE__STATE_FEATURE_VALUE);
		createEAttribute(viewRuleEClass, VIEW_RULE__VIEW_PROPERTY);
		createEReference(viewRuleEClass, VIEW_RULE__VIEW_PROPERTY_TYPE);
		createEAttribute(viewRuleEClass, VIEW_RULE__VIEW_PROPERTY_VALUE);

		viewPropertiesEClass = createEClass(VIEW_PROPERTIES);
		createEReference(viewPropertiesEClass, VIEW_PROPERTIES__VIEW_RULES);

		dataPropertiesEClass = createEClass(DATA_PROPERTIES);
		createEReference(dataPropertiesEClass, DATA_PROPERTIES__MODEL);

		decoratorModelEClass = createEClass(DECORATOR_MODEL);
		createEReference(decoratorModelEClass, DECORATOR_MODEL__DECORATORS);
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

		// Obtain other dependent packages
		ModelPackage theModelPackage = (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);
		StoryPackage theStoryPackage = (StoryPackage)EPackage.Registry.INSTANCE.getEPackage(StoryPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		abstractDecoratorEClass.getESuperTypes().add(this.getBehaviorProperties());
		abstractDecoratorEClass.getESuperTypes().add(this.getDataProperties());
		abstractDecoratorEClass.getESuperTypes().add(this.getViewProperties());
		widgetDecoratorEClass.getESuperTypes().add(this.getAbstractDecorator());
		widgetContainerDecoratorEClass.getESuperTypes().add(this.getAbstractDecorator());
		storyboardDecoratorEClass.getESuperTypes().add(this.getAbstractDecorator());
		scriptActionEClass.getESuperTypes().add(this.getAction());
		eventScriptActionEClass.getESuperTypes().add(this.getScriptAction());

		// Initialize classes, features, and operations; add parameters
		initEClass(abstractDecoratorEClass, AbstractDecorator.class, "AbstractDecorator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(widgetDecoratorEClass, WidgetDecorator.class, "WidgetDecorator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWidgetDecorator_Widget(), theModelPackage.getWidget(), null, "widget", null, 0, 1, WidgetDecorator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(widgetContainerDecoratorEClass, WidgetContainerDecorator.class, "WidgetContainerDecorator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWidgetContainerDecorator_WidgetContainer(), theModelPackage.getWidgetContainer(), null, "widgetContainer", null, 0, 1, WidgetContainerDecorator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(storyboardDecoratorEClass, StoryboardDecorator.class, "StoryboardDecorator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStoryboardDecorator_Storyboard(), theStoryPackage.getStoryboard(), null, "storyboard", null, 0, 1, StoryboardDecorator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionEClass, Action.class, "Action", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stateActionEClass, StateAction.class, "StateAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStateAction_StateMutators(), this.getStateMutator(), null, "stateMutators", null, 0, -1, StateAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stateMutatorEClass, StateMutator.class, "StateMutator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStateMutator_StateFeature(), theEcorePackage.getEAttribute(), null, "stateFeature", null, 0, 1, StateMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStateMutator_StateFeatureValue(), ecorePackage.getEString(), "stateFeatureValue", null, 0, 1, StateMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scriptActionEClass, ScriptAction.class, "ScriptAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getScriptAction_Script(), ecorePackage.getEString(), "script", null, 0, 1, ScriptAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventScriptActionEClass, EventScriptAction.class, "EventScriptAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEventScriptAction_EventName(), ecorePackage.getEString(), "eventName", null, 0, 1, EventScriptAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(behaviorPropertiesEClass, BehaviorProperties.class, "BehaviorProperties", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBehaviorProperties_Actions(), this.getAction(), null, "actions", null, 0, -1, BehaviorProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(viewRuleEClass, ViewRule.class, "ViewRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getViewRule_StateFeature(), theEcorePackage.getEAttribute(), null, "stateFeature", null, 0, 1, ViewRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getViewRule_StateFeatureValue(), ecorePackage.getEString(), "stateFeatureValue", null, 0, 1, ViewRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getViewRule_ViewProperty(), ecorePackage.getEString(), "viewProperty", null, 0, 1, ViewRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getViewRule_ViewPropertyType(), theEcorePackage.getEDataType(), null, "viewPropertyType", null, 0, 1, ViewRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getViewRule_ViewPropertyValue(), ecorePackage.getEString(), "viewPropertyValue", null, 0, 1, ViewRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(viewPropertiesEClass, ViewProperties.class, "ViewProperties", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getViewProperties_ViewRules(), this.getViewRule(), null, "viewRules", null, 0, -1, ViewProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataPropertiesEClass, DataProperties.class, "DataProperties", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataProperties_Model(), theEcorePackage.getEClass(), null, "model", null, 0, 1, DataProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(decoratorModelEClass, DecoratorModel.class, "DecoratorModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDecoratorModel_Decorators(), this.getAbstractDecorator(), null, "decorators", null, 0, -1, DecoratorModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ScreenDecoratorPackageImpl
