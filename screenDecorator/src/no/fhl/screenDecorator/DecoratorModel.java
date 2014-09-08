/**
 */
package no.fhl.screenDecorator;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Decorator Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.fhl.screenDecorator.DecoratorModel#getDecorators <em>Decorators</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.fhl.screenDecorator.ScreenDecoratorPackage#getDecoratorModel()
 * @model
 * @generated
 */
public interface DecoratorModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Decorators</b></em>' containment reference list.
	 * The list contents are of type {@link no.fhl.screenDecorator.AbstractDecorator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Decorators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Decorators</em>' containment reference list.
	 * @see no.fhl.screenDecorator.ScreenDecoratorPackage#getDecoratorModel_Decorators()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractDecorator> getDecorators();

} // DecoratorModel
