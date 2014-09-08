/**
 */
package no.fhl.screenDecorator.util;

import no.fhl.screenDecorator.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see no.fhl.screenDecorator.ScreenDecoratorPackage
 * @generated
 */
public class ScreenDecoratorAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ScreenDecoratorPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScreenDecoratorAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ScreenDecoratorPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScreenDecoratorSwitch<Adapter> modelSwitch =
		new ScreenDecoratorSwitch<Adapter>() {
			@Override
			public Adapter caseAbstractDecorator(AbstractDecorator object) {
				return createAbstractDecoratorAdapter();
			}
			@Override
			public Adapter caseWidgetDecorator(WidgetDecorator object) {
				return createWidgetDecoratorAdapter();
			}
			@Override
			public Adapter caseWidgetContainerDecorator(WidgetContainerDecorator object) {
				return createWidgetContainerDecoratorAdapter();
			}
			@Override
			public Adapter caseStoryboardDecorator(StoryboardDecorator object) {
				return createStoryboardDecoratorAdapter();
			}
			@Override
			public Adapter caseAction(Action object) {
				return createActionAdapter();
			}
			@Override
			public Adapter caseStateAction(StateAction object) {
				return createStateActionAdapter();
			}
			@Override
			public Adapter caseStateMutator(StateMutator object) {
				return createStateMutatorAdapter();
			}
			@Override
			public Adapter caseScriptAction(ScriptAction object) {
				return createScriptActionAdapter();
			}
			@Override
			public Adapter caseEventScriptAction(EventScriptAction object) {
				return createEventScriptActionAdapter();
			}
			@Override
			public Adapter caseBehaviorProperties(BehaviorProperties object) {
				return createBehaviorPropertiesAdapter();
			}
			@Override
			public Adapter caseViewRule(ViewRule object) {
				return createViewRuleAdapter();
			}
			@Override
			public Adapter caseViewProperties(ViewProperties object) {
				return createViewPropertiesAdapter();
			}
			@Override
			public Adapter caseDataProperties(DataProperties object) {
				return createDataPropertiesAdapter();
			}
			@Override
			public Adapter caseDecoratorModel(DecoratorModel object) {
				return createDecoratorModelAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link no.fhl.screenDecorator.AbstractDecorator <em>Abstract Decorator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.fhl.screenDecorator.AbstractDecorator
	 * @generated
	 */
	public Adapter createAbstractDecoratorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.fhl.screenDecorator.WidgetDecorator <em>Widget Decorator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.fhl.screenDecorator.WidgetDecorator
	 * @generated
	 */
	public Adapter createWidgetDecoratorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.fhl.screenDecorator.WidgetContainerDecorator <em>Widget Container Decorator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.fhl.screenDecorator.WidgetContainerDecorator
	 * @generated
	 */
	public Adapter createWidgetContainerDecoratorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.fhl.screenDecorator.StoryboardDecorator <em>Storyboard Decorator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.fhl.screenDecorator.StoryboardDecorator
	 * @generated
	 */
	public Adapter createStoryboardDecoratorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.fhl.screenDecorator.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.fhl.screenDecorator.Action
	 * @generated
	 */
	public Adapter createActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.fhl.screenDecorator.StateAction <em>State Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.fhl.screenDecorator.StateAction
	 * @generated
	 */
	public Adapter createStateActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.fhl.screenDecorator.StateMutator <em>State Mutator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.fhl.screenDecorator.StateMutator
	 * @generated
	 */
	public Adapter createStateMutatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.fhl.screenDecorator.ScriptAction <em>Script Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.fhl.screenDecorator.ScriptAction
	 * @generated
	 */
	public Adapter createScriptActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.fhl.screenDecorator.EventScriptAction <em>Event Script Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.fhl.screenDecorator.EventScriptAction
	 * @generated
	 */
	public Adapter createEventScriptActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.fhl.screenDecorator.BehaviorProperties <em>Behavior Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.fhl.screenDecorator.BehaviorProperties
	 * @generated
	 */
	public Adapter createBehaviorPropertiesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.fhl.screenDecorator.ViewRule <em>View Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.fhl.screenDecorator.ViewRule
	 * @generated
	 */
	public Adapter createViewRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.fhl.screenDecorator.ViewProperties <em>View Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.fhl.screenDecorator.ViewProperties
	 * @generated
	 */
	public Adapter createViewPropertiesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.fhl.screenDecorator.DataProperties <em>Data Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.fhl.screenDecorator.DataProperties
	 * @generated
	 */
	public Adapter createDataPropertiesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.fhl.screenDecorator.DecoratorModel <em>Decorator Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.fhl.screenDecorator.DecoratorModel
	 * @generated
	 */
	public Adapter createDecoratorModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ScreenDecoratorAdapterFactory
