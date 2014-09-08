/**
 */
package no.fhl.screenDecorator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Mutator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.fhl.screenDecorator.StateMutator#getStateFeature <em>State Feature</em>}</li>
 *   <li>{@link no.fhl.screenDecorator.StateMutator#getStateFeatureValue <em>State Feature Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.fhl.screenDecorator.ScreenDecoratorPackage#getStateMutator()
 * @model
 * @generated
 */
public interface StateMutator extends EObject {
	/**
	 * Returns the value of the '<em><b>State Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Feature</em>' reference.
	 * @see #setStateFeature(EAttribute)
	 * @see no.fhl.screenDecorator.ScreenDecoratorPackage#getStateMutator_StateFeature()
	 * @model
	 * @generated
	 */
	EAttribute getStateFeature();

	/**
	 * Sets the value of the '{@link no.fhl.screenDecorator.StateMutator#getStateFeature <em>State Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Feature</em>' reference.
	 * @see #getStateFeature()
	 * @generated
	 */
	void setStateFeature(EAttribute value);

	/**
	 * Returns the value of the '<em><b>State Feature Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Feature Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Feature Value</em>' attribute.
	 * @see #setStateFeatureValue(String)
	 * @see no.fhl.screenDecorator.ScreenDecoratorPackage#getStateMutator_StateFeatureValue()
	 * @model
	 * @generated
	 */
	String getStateFeatureValue();

	/**
	 * Sets the value of the '{@link no.fhl.screenDecorator.StateMutator#getStateFeatureValue <em>State Feature Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Feature Value</em>' attribute.
	 * @see #getStateFeatureValue()
	 * @generated
	 */
	void setStateFeatureValue(String value);

} // StateMutator
