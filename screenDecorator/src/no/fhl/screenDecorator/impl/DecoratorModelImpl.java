/**
 */
package no.fhl.screenDecorator.impl;

import java.util.Collection;

import no.fhl.screenDecorator.AbstractDecorator;
import no.fhl.screenDecorator.DecoratorModel;
import no.fhl.screenDecorator.ScreenDecoratorPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Decorator Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.fhl.screenDecorator.impl.DecoratorModelImpl#getDecorators <em>Decorators</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DecoratorModelImpl extends MinimalEObjectImpl.Container implements DecoratorModel {
	/**
	 * The cached value of the '{@link #getDecorators() <em>Decorators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDecorators()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractDecorator> decorators;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DecoratorModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScreenDecoratorPackage.Literals.DECORATOR_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractDecorator> getDecorators() {
		if (decorators == null) {
			decorators = new EObjectContainmentEList<AbstractDecorator>(AbstractDecorator.class, this, ScreenDecoratorPackage.DECORATOR_MODEL__DECORATORS);
		}
		return decorators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ScreenDecoratorPackage.DECORATOR_MODEL__DECORATORS:
				return ((InternalEList<?>)getDecorators()).basicRemove(otherEnd, msgs);
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
			case ScreenDecoratorPackage.DECORATOR_MODEL__DECORATORS:
				return getDecorators();
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
			case ScreenDecoratorPackage.DECORATOR_MODEL__DECORATORS:
				getDecorators().clear();
				getDecorators().addAll((Collection<? extends AbstractDecorator>)newValue);
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
			case ScreenDecoratorPackage.DECORATOR_MODEL__DECORATORS:
				getDecorators().clear();
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
			case ScreenDecoratorPackage.DECORATOR_MODEL__DECORATORS:
				return decorators != null && !decorators.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DecoratorModelImpl
