/**
 */
package no.fhl.screenDecorator;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.fhl.screenDecorator.BehaviorProperties#getActions <em>Actions</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.fhl.screenDecorator.ScreenDecoratorPackage#getBehaviorProperties()
 * @model
 * @generated
 */
public interface BehaviorProperties extends EObject {
	/**
	 * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
	 * The list contents are of type {@link no.fhl.screenDecorator.Action}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' containment reference list.
	 * @see no.fhl.screenDecorator.ScreenDecoratorPackage#getBehaviorProperties_Actions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Action> getActions();

} // BehaviorProperties
