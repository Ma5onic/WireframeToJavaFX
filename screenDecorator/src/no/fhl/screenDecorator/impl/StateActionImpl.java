/**
 */
package no.fhl.screenDecorator.impl;

import java.util.Collection;

import no.fhl.screenDecorator.ScreenDecoratorPackage;
import no.fhl.screenDecorator.StateAction;
import no.fhl.screenDecorator.StateMutator;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.fhl.screenDecorator.impl.StateActionImpl#getStateMutators <em>State Mutators</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateActionImpl extends MinimalEObjectImpl.Container implements StateAction {
	/**
	 * The cached value of the '{@link #getStateMutators() <em>State Mutators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateMutators()
	 * @generated
	 * @ordered
	 */
	protected EList<StateMutator> stateMutators;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScreenDecoratorPackage.Literals.STATE_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StateMutator> getStateMutators() {
		if (stateMutators == null) {
			stateMutators = new EObjectContainmentEList<StateMutator>(StateMutator.class, this, ScreenDecoratorPackage.STATE_ACTION__STATE_MUTATORS);
		}
		return stateMutators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ScreenDecoratorPackage.STATE_ACTION__STATE_MUTATORS:
				return ((InternalEList<?>)getStateMutators()).basicRemove(otherEnd, msgs);
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
			case ScreenDecoratorPackage.STATE_ACTION__STATE_MUTATORS:
				return getStateMutators();
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
			case ScreenDecoratorPackage.STATE_ACTION__STATE_MUTATORS:
				getStateMutators().clear();
				getStateMutators().addAll((Collection<? extends StateMutator>)newValue);
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
			case ScreenDecoratorPackage.STATE_ACTION__STATE_MUTATORS:
				getStateMutators().clear();
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
			case ScreenDecoratorPackage.STATE_ACTION__STATE_MUTATORS:
				return stateMutators != null && !stateMutators.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StateActionImpl
