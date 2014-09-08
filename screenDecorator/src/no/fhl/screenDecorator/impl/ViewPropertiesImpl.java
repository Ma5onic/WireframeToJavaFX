/**
 */
package no.fhl.screenDecorator.impl;

import java.util.Collection;

import no.fhl.screenDecorator.ScreenDecoratorPackage;
import no.fhl.screenDecorator.ViewProperties;
import no.fhl.screenDecorator.ViewRule;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.fhl.screenDecorator.impl.ViewPropertiesImpl#getViewRules <em>View Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ViewPropertiesImpl extends MinimalEObjectImpl.Container implements ViewProperties {
	/**
	 * The cached value of the '{@link #getViewRules() <em>View Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewRules()
	 * @generated
	 * @ordered
	 */
	protected EList<ViewRule> viewRules;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ViewPropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScreenDecoratorPackage.Literals.VIEW_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ViewRule> getViewRules() {
		if (viewRules == null) {
			viewRules = new EObjectContainmentEList<ViewRule>(ViewRule.class, this, ScreenDecoratorPackage.VIEW_PROPERTIES__VIEW_RULES);
		}
		return viewRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ScreenDecoratorPackage.VIEW_PROPERTIES__VIEW_RULES:
				return ((InternalEList<?>)getViewRules()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ScreenDecoratorPackage.VIEW_PROPERTIES__VIEW_RULES:
				return getViewRules();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ScreenDecoratorPackage.VIEW_PROPERTIES__VIEW_RULES:
				getViewRules().clear();
				getViewRules().addAll((Collection<? extends ViewRule>)newValue);
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
			case ScreenDecoratorPackage.VIEW_PROPERTIES__VIEW_RULES:
				getViewRules().clear();
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
			case ScreenDecoratorPackage.VIEW_PROPERTIES__VIEW_RULES:
				return viewRules != null && !viewRules.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ViewPropertiesImpl
