/**
 */
package no.fhl.screenDecorator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.fhl.screenDecorator.ViewRule#getStateFeature <em>State Feature</em>}</li>
 *   <li>{@link no.fhl.screenDecorator.ViewRule#getStateFeatureValue <em>State Feature Value</em>}</li>
 *   <li>{@link no.fhl.screenDecorator.ViewRule#getViewProperty <em>View Property</em>}</li>
 *   <li>{@link no.fhl.screenDecorator.ViewRule#getViewPropertyType <em>View Property Type</em>}</li>
 *   <li>{@link no.fhl.screenDecorator.ViewRule#getViewPropertyValue <em>View Property Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.fhl.screenDecorator.ScreenDecoratorPackage#getViewRule()
 * @model
 * @generated
 */
public interface ViewRule extends EObject {
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
	 * @see no.fhl.screenDecorator.ScreenDecoratorPackage#getViewRule_StateFeature()
	 * @model
	 * @generated
	 */
	EAttribute getStateFeature();

	/**
	 * Sets the value of the '{@link no.fhl.screenDecorator.ViewRule#getStateFeature <em>State Feature</em>}' reference.
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
	 * @see no.fhl.screenDecorator.ScreenDecoratorPackage#getViewRule_StateFeatureValue()
	 * @model
	 * @generated
	 */
	String getStateFeatureValue();

	/**
	 * Sets the value of the '{@link no.fhl.screenDecorator.ViewRule#getStateFeatureValue <em>State Feature Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Feature Value</em>' attribute.
	 * @see #getStateFeatureValue()
	 * @generated
	 */
	void setStateFeatureValue(String value);

	/**
	 * Returns the value of the '<em><b>View Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>View Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>View Property</em>' attribute.
	 * @see #setViewProperty(String)
	 * @see no.fhl.screenDecorator.ScreenDecoratorPackage#getViewRule_ViewProperty()
	 * @model
	 * @generated
	 */
	String getViewProperty();

	/**
	 * Sets the value of the '{@link no.fhl.screenDecorator.ViewRule#getViewProperty <em>View Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>View Property</em>' attribute.
	 * @see #getViewProperty()
	 * @generated
	 */
	void setViewProperty(String value);

	/**
	 * Returns the value of the '<em><b>View Property Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>View Property Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>View Property Type</em>' reference.
	 * @see #setViewPropertyType(EDataType)
	 * @see no.fhl.screenDecorator.ScreenDecoratorPackage#getViewRule_ViewPropertyType()
	 * @model
	 * @generated
	 */
	EDataType getViewPropertyType();

	/**
	 * Sets the value of the '{@link no.fhl.screenDecorator.ViewRule#getViewPropertyType <em>View Property Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>View Property Type</em>' reference.
	 * @see #getViewPropertyType()
	 * @generated
	 */
	void setViewPropertyType(EDataType value);

	/**
	 * Returns the value of the '<em><b>View Property Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>View Property Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>View Property Value</em>' attribute.
	 * @see #setViewPropertyValue(String)
	 * @see no.fhl.screenDecorator.ScreenDecoratorPackage#getViewRule_ViewPropertyValue()
	 * @model
	 * @generated
	 */
	String getViewPropertyValue();

	/**
	 * Sets the value of the '{@link no.fhl.screenDecorator.ViewRule#getViewPropertyValue <em>View Property Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>View Property Value</em>' attribute.
	 * @see #getViewPropertyValue()
	 * @generated
	 */
	void setViewPropertyValue(String value);

} // ViewRule
