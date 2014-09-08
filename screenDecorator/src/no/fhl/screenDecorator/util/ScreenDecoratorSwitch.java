/**
 */
package no.fhl.screenDecorator.util;

import no.fhl.screenDecorator.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see no.fhl.screenDecorator.ScreenDecoratorPackage
 * @generated
 */
public class ScreenDecoratorSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ScreenDecoratorPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScreenDecoratorSwitch() {
		if (modelPackage == null) {
			modelPackage = ScreenDecoratorPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ScreenDecoratorPackage.ABSTRACT_DECORATOR: {
				AbstractDecorator abstractDecorator = (AbstractDecorator)theEObject;
				T result = caseAbstractDecorator(abstractDecorator);
				if (result == null) result = caseBehaviorProperties(abstractDecorator);
				if (result == null) result = caseDataProperties(abstractDecorator);
				if (result == null) result = caseViewProperties(abstractDecorator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScreenDecoratorPackage.WIDGET_DECORATOR: {
				WidgetDecorator widgetDecorator = (WidgetDecorator)theEObject;
				T result = caseWidgetDecorator(widgetDecorator);
				if (result == null) result = caseAbstractDecorator(widgetDecorator);
				if (result == null) result = caseBehaviorProperties(widgetDecorator);
				if (result == null) result = caseDataProperties(widgetDecorator);
				if (result == null) result = caseViewProperties(widgetDecorator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScreenDecoratorPackage.WIDGET_CONTAINER_DECORATOR: {
				WidgetContainerDecorator widgetContainerDecorator = (WidgetContainerDecorator)theEObject;
				T result = caseWidgetContainerDecorator(widgetContainerDecorator);
				if (result == null) result = caseAbstractDecorator(widgetContainerDecorator);
				if (result == null) result = caseBehaviorProperties(widgetContainerDecorator);
				if (result == null) result = caseDataProperties(widgetContainerDecorator);
				if (result == null) result = caseViewProperties(widgetContainerDecorator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScreenDecoratorPackage.STORYBOARD_DECORATOR: {
				StoryboardDecorator storyboardDecorator = (StoryboardDecorator)theEObject;
				T result = caseStoryboardDecorator(storyboardDecorator);
				if (result == null) result = caseAbstractDecorator(storyboardDecorator);
				if (result == null) result = caseBehaviorProperties(storyboardDecorator);
				if (result == null) result = caseDataProperties(storyboardDecorator);
				if (result == null) result = caseViewProperties(storyboardDecorator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScreenDecoratorPackage.ACTION: {
				Action action = (Action)theEObject;
				T result = caseAction(action);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScreenDecoratorPackage.STATE_ACTION: {
				StateAction stateAction = (StateAction)theEObject;
				T result = caseStateAction(stateAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScreenDecoratorPackage.STATE_MUTATOR: {
				StateMutator stateMutator = (StateMutator)theEObject;
				T result = caseStateMutator(stateMutator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScreenDecoratorPackage.SCRIPT_ACTION: {
				ScriptAction scriptAction = (ScriptAction)theEObject;
				T result = caseScriptAction(scriptAction);
				if (result == null) result = caseAction(scriptAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScreenDecoratorPackage.EVENT_SCRIPT_ACTION: {
				EventScriptAction eventScriptAction = (EventScriptAction)theEObject;
				T result = caseEventScriptAction(eventScriptAction);
				if (result == null) result = caseScriptAction(eventScriptAction);
				if (result == null) result = caseAction(eventScriptAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScreenDecoratorPackage.BEHAVIOR_PROPERTIES: {
				BehaviorProperties behaviorProperties = (BehaviorProperties)theEObject;
				T result = caseBehaviorProperties(behaviorProperties);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScreenDecoratorPackage.VIEW_RULE: {
				ViewRule viewRule = (ViewRule)theEObject;
				T result = caseViewRule(viewRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScreenDecoratorPackage.VIEW_PROPERTIES: {
				ViewProperties viewProperties = (ViewProperties)theEObject;
				T result = caseViewProperties(viewProperties);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScreenDecoratorPackage.DATA_PROPERTIES: {
				DataProperties dataProperties = (DataProperties)theEObject;
				T result = caseDataProperties(dataProperties);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScreenDecoratorPackage.DECORATOR_MODEL: {
				DecoratorModel decoratorModel = (DecoratorModel)theEObject;
				T result = caseDecoratorModel(decoratorModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Decorator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Decorator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractDecorator(AbstractDecorator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Widget Decorator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Widget Decorator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWidgetDecorator(WidgetDecorator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Widget Container Decorator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Widget Container Decorator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWidgetContainerDecorator(WidgetContainerDecorator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Storyboard Decorator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Storyboard Decorator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStoryboardDecorator(StoryboardDecorator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAction(Action object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateAction(StateAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Mutator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Mutator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateMutator(StateMutator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Script Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Script Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScriptAction(ScriptAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Script Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Script Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventScriptAction(EventScriptAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Behavior Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Behavior Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBehaviorProperties(BehaviorProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>View Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>View Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseViewRule(ViewRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>View Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>View Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseViewProperties(ViewProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataProperties(DataProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Decorator Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Decorator Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDecoratorModel(DecoratorModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ScreenDecoratorSwitch
