/**
 */
package no.fhl.screenDecorator;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.fhl.screenDecorator.ViewProperties#getViewRules <em>View Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.fhl.screenDecorator.ScreenDecoratorPackage#getViewProperties()
 * @model
 * @generated
 */
public interface ViewProperties extends EObject {
	/**
	 * Returns the value of the '<em><b>View Rules</b></em>' containment reference list.
	 * The list contents are of type {@link no.fhl.screenDecorator.ViewRule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>View Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>View Rules</em>' containment reference list.
	 * @see no.fhl.screenDecorator.ScreenDecoratorPackage#getViewProperties_ViewRules()
	 * @model containment="true"
	 * @generated
	 */
	EList<ViewRule> getViewRules();

} // ViewProperties
