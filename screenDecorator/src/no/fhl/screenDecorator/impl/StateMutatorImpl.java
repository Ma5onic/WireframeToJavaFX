/**
 */
package no.fhl.screenDecorator.impl;

import no.fhl.screenDecorator.ScreenDecoratorPackage;
import no.fhl.screenDecorator.StateMutator;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State Mutator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.fhl.screenDecorator.impl.StateMutatorImpl#getStateFeature <em>State Feature</em>}</li>
 *   <li>{@link no.fhl.screenDecorator.impl.StateMutatorImpl#getStateFeatureValue <em>State Feature Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateMutatorImpl extends MinimalEObjectImpl.Container implements StateMutator {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateMutatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScreenDecoratorPackage.Literals.STATE_MUTATOR;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScreenDecoratorPackage.STATE_MUTATOR__STATE_FEATURE, oldStateFeature, stateFeature));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ScreenDecoratorPackage.STATE_MUTATOR__STATE_FEATURE, oldStateFeature, stateFeature));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ScreenDecoratorPackage.STATE_MUTATOR__STATE_FEATURE_VALUE, oldStateFeatureValue, stateFeatureValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ScreenDecoratorPackage.STATE_MUTATOR__STATE_FEATURE:
				if (resolve) return getStateFeature();
				return basicGetStateFeature();
			case ScreenDecoratorPackage.STATE_MUTATOR__STATE_FEATURE_VALUE:
				return getStateFeatureValue();
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
			case ScreenDecoratorPackage.STATE_MUTATOR__STATE_FEATURE:
				setStateFeature((EAttribute)newValue);
				return;
			case ScreenDecoratorPackage.STATE_MUTATOR__STATE_FEATURE_VALUE:
				setStateFeatureValue((String)newValue);
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
			case ScreenDecoratorPackage.STATE_MUTATOR__STATE_FEATURE:
				setStateFeature((EAttribute)null);
				return;
			case ScreenDecoratorPackage.STATE_MUTATOR__STATE_FEATURE_VALUE:
				setStateFeatureValue(STATE_FEATURE_VALUE_EDEFAULT);
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
			case ScreenDecoratorPackage.STATE_MUTATOR__STATE_FEATURE:
				return stateFeature != null;
			case ScreenDecoratorPackage.STATE_MUTATOR__STATE_FEATURE_VALUE:
				return STATE_FEATURE_VALUE_EDEFAULT == null ? stateFeatureValue != null : !STATE_FEATURE_VALUE_EDEFAULT.equals(stateFeatureValue);
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
		result.append(')');
		return result.toString();
	}

} //StateMutatorImpl
