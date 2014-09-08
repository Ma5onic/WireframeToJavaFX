/**
 */
package no.fhl.screenDecorator.impl;

import no.fhl.screenDecorator.ScreenDecoratorPackage;
import no.fhl.screenDecorator.ViewRule;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.fhl.screenDecorator.impl.ViewRuleImpl#getStateFeature <em>State Feature</em>}</li>
 *   <li>{@link no.fhl.screenDecorator.impl.ViewRuleImpl#getStateFeatureValue <em>State Feature Value</em>}</li>
 *   <li>{@link no.fhl.screenDecorator.impl.ViewRuleImpl#getViewProperty <em>View Property</em>}</li>
 *   <li>{@link no.fhl.screenDecorator.impl.ViewRuleImpl#getViewPropertyType <em>View Property Type</em>}</li>
 *   <li>{@link no.fhl.screenDecorator.impl.ViewRuleImpl#getViewPropertyValue <em>View Property Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ViewRuleImpl extends MinimalEObjectImpl.Container implements ViewRule {
	/**
	 * The cached value of the '{@link #getStateFeature() <em>State Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateFeature()
	 * @generated
	 * @ordered
	 */
	protected EAttribute stateFeature;

	/**
	 * The default value of the '{@link #getStateFeatureValue() <em>State Feature Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateFeatureValue()
	 * @generated
	 * @ordered
	 */
	protected static final String STATE_FEATURE_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStateFeatureValue() <em>State Feature Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateFeatureValue()
	 * @generated
	 * @ordered
	 */
	protected String stateFeatureValue = STATE_FEATURE_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getViewProperty() <em>View Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewProperty()
	 * @generated
	 * @ordered
	 */
	protected static final String VIEW_PROPERTY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getViewProperty() <em>View Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewProperty()
	 * @generated
	 * @ordered
	 */
	protected String viewProperty = VIEW_PROPERTY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getViewPropertyType() <em>View Property Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewPropertyType()
	 * @generated
	 * @ordered
	 */
	protected EDataType viewPropertyType;

	/**
	 * The default value of the '{@link #getViewPropertyValue() <em>View Property Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewPropertyValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VIEW_PROPERTY_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getViewPropertyValue() <em>View Property Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewPropertyValue()
	 * @generated
	 * @ordered
	 */
	protected String viewPropertyValue = VIEW_PROPERTY_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ViewRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScreenDecoratorPackage.Literals.VIEW_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStateFeature() {
		if (stateFeature != null && stateFeature.eIsProxy()) {
			InternalEObject oldStateFeature = (InternalEObject)stateFeature;
			stateFeature = (EAttribute)eResolveProxy(oldStateFeature);
			if (stateFeature != oldStateFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScreenDecoratorPackage.VIEW_RULE__STATE_FEATURE, oldStateFeature, stateFeature));
			}
		}
		return stateFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute basicGetStateFeature() {
		return stateFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStateFeature(EAttribute newStateFeature) {
		EAttribute oldStateFeature = stateFeature;
		stateFeature = newStateFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScreenDecoratorPackage.VIEW_RULE__STATE_FEATURE, oldStateFeature, stateFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStateFeatureValue() {
		return stateFeatureValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStateFeatureValue(String newStateFeatureValue) {
		String oldStateFeatureValue = stateFeatureValue;
		stateFeatureValue = newStateFeatureValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScreenDecoratorPackage.VIEW_RULE__STATE_FEATURE_VALUE, oldStateFeatureValue, stateFeatureValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getViewProperty() {
		return viewProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setViewProperty(String newViewProperty) {
		String oldViewProperty = viewProperty;
		viewProperty = newViewProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScreenDecoratorPackage.VIEW_RULE__VIEW_PROPERTY, oldViewProperty, viewProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getViewPropertyType() {
		if (viewPropertyType != null && viewPropertyType.eIsProxy()) {
			InternalEObject oldViewPropertyType = (InternalEObject)viewPropertyType;
			viewPropertyType = (EDataType)eResolveProxy(oldViewPropertyType);
			if (viewPropertyType != oldViewPropertyType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScreenDecoratorPackage.VIEW_RULE__VIEW_PROPERTY_TYPE, oldViewPropertyType, viewPropertyType));
			}
		}
		return viewPropertyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType basicGetViewPropertyType() {
		return viewPropertyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setViewPropertyType(EDataType newViewPropertyType) {
		EDataType oldViewPropertyType = viewPropertyType;
		viewPropertyType = newViewPropertyType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScreenDecoratorPackage.VIEW_RULE__VIEW_PROPERTY_TYPE, oldViewPropertyType, viewPropertyType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getViewPropertyValue() {
		return viewPropertyValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setViewPropertyValue(String newViewPropertyValue) {
		String oldViewPropertyValue = viewPropertyValue;
		viewPropertyValue = newViewPropertyValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScreenDecoratorPackage.VIEW_RULE__VIEW_PROPERTY_VALUE, oldViewPropertyValue, viewPropertyValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ScreenDecoratorPackage.VIEW_RULE__STATE_FEATURE:
				if (resolve) return getStateFeature();
				return basicGetStateFeature();
			case ScreenDecoratorPackage.VIEW_RULE__STATE_FEATURE_VALUE:
				return getStateFeatureValue();
			case ScreenDecoratorPackage.VIEW_RULE__VIEW_PROPERTY:
				return getViewProperty();
			case ScreenDecoratorPackage.VIEW_RULE__VIEW_PROPERTY_TYPE:
				if (resolve) return getViewPropertyType();
				return basicGetViewPropertyType();
			case ScreenDecoratorPackage.VIEW_RULE__VIEW_PROPERTY_VALUE:
				return getViewPropertyValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ScreenDecoratorPackage.VIEW_RULE__STATE_FEATURE:
				setStateFeature((EAttribute)newValue);
				return;
			case ScreenDecoratorPackage.VIEW_RULE__STATE_FEATURE_VALUE:
				setStateFeatureValue((String)newValue);
				return;
			case ScreenDecoratorPackage.VIEW_RULE__VIEW_PROPERTY:
				setViewProperty((String)newValue);
				return;
			case ScreenDecoratorPackage.VIEW_RULE__VIEW_PROPERTY_TYPE:
				setViewPropertyType((EDataType)newValue);
				return;
			case ScreenDecoratorPackage.VIEW_RULE__VIEW_PROPERTY_VALUE:
				setViewPropertyValue((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ScreenDecoratorPackage.VIEW_RULE__STATE_FEATURE:
				setStateFeature((EAttribute)null);
				return;
			case ScreenDecoratorPackage.VIEW_RULE__STATE_FEATURE_VALUE:
				setStateFeatureValue(STATE_FEATURE_VALUE_EDEFAULT);
				return;
			case ScreenDecoratorPackage.VIEW_RULE__VIEW_PROPERTY:
				setViewProperty(VIEW_PROPERTY_EDEFAULT);
				return;
			case ScreenDecoratorPackage.VIEW_RULE__VIEW_PROPERTY_TYPE:
				setViewPropertyType((EDataType)null);
				return;
			case ScreenDecoratorPackage.VIEW_RULE__VIEW_PROPERTY_VALUE:
				setViewPropertyValue(VIEW_PROPERTY_VALUE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ScreenDecoratorPackage.VIEW_RULE__STATE_FEATURE:
				return stateFeature != null;
			case ScreenDecoratorPackage.VIEW_RULE__STATE_FEATURE_VALUE:
				return STATE_FEATURE_VALUE_EDEFAULT == null ? stateFeatureValue != null : !STATE_FEATURE_VALUE_EDEFAULT.equals(stateFeatureValue);
			case ScreenDecoratorPackage.VIEW_RULE__VIEW_PROPERTY:
				return VIEW_PROPERTY_EDEFAULT == null ? viewProperty != null : !VIEW_PROPERTY_EDEFAULT.equals(viewProperty);
			case ScreenDecoratorPackage.VIEW_RULE__VIEW_PROPERTY_TYPE:
				return viewPropertyType != null;
			case ScreenDecoratorPackage.VIEW_RULE__VIEW_PROPERTY_VALUE:
				return VIEW_PROPERTY_VALUE_EDEFAULT == null ? viewPropertyValue != null : !VIEW_PROPERTY_VALUE_EDEFAULT.equals(viewPropertyValue);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (stateFeatureValue: ");
		result.append(stateFeatureValue);
		result.append(", viewProperty: ");
		result.append(viewProperty);
		result.append(", viewPropertyValue: ");
		result.append(viewPropertyValue);
		result.append(')');
		return result.toString();
	}

} //ViewRuleImpl
