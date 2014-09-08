/**
 */
package no.fhl.screenDecorator;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.fhl.screenDecorator.StateAction#getStateMutators <em>State Mutators</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.fhl.screenDecorator.ScreenDecoratorPackage#getStateAction()
 * @model
 * @generated
 */
public interface StateAction extends EObject {
	/**
	 * Returns the value of the '<em><b>State Mutators</b></em>' containment reference list.
	 * The list contents are of type {@link no.fhl.screenDecorator.StateMutator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Mutators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Mutators</em>' containment reference list.
	 * @see no.fhl.screenDecorator.ScreenDecoratorPackage#getStateAction_StateMutators()
	 * @model containment="true"
	 * @generated
	 */
	EList<StateMutator> getStateMutators();

} // StateAction
