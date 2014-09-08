/**
 */
package no.fhl.screenDecorator.impl;

import java.util.Collection;

import no.fhl.screenDecorator.AbstractDecorator;
import no.fhl.screenDecorator.DataProperties;
import no.fhl.screenDecorator.ScreenDecoratorPackage;
import no.fhl.screenDecorator.ViewProperties;
import no.fhl.screenDecorator.ViewRule;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Decorator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.fhl.screenDecorator.impl.AbstractDecoratorImpl#getModel <em>Model</em>}</li>
 *   <li>{@link no.fhl.screenDecorator.impl.AbstractDecoratorImpl#getViewRules <em>View Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractDecoratorImpl extends BehaviorPropertiesImpl implements AbstractDecorator {
	/**
	 * The cached value of the '{@link #getModel() <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected EClass model;

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
	protected AbstractDecoratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScreenDecoratorPackage.Literals.ABSTRACT_DECORATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModel() {
		if (model != null && model.eIsProxy()) {
			InternalEObject oldModel = (InternalEObject)model;
			model = (EClass)eResolveProxy(oldModel);
			if (model != oldModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScreenDecoratorPackage.ABSTRACT_DECORATOR__MODEL, oldModel, model));
			}
		}
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetModel() {
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModel(EClass newModel) {
		EClass oldModel = model;
		model = newModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScreenDecoratorPackage.ABSTRACT_DECORATOR__MODEL, oldModel, model));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ViewRule> getViewRules() {
		if (viewRules == null) {
			viewRules = new EObjectContainmentEList<ViewRule>(ViewRule.class, this, ScreenDecoratorPackage.ABSTRACT_DECORATOR__VIEW_RULES);
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
			case ScreenDecoratorPackage.ABSTRACT_DECORATOR__VIEW_RULES:
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
			case ScreenDecoratorPackage.ABSTRACT_DECORATOR__MODEL:
				if (resolve) return getModel();
				return basicGetModel();
			case ScreenDecoratorPackage.ABSTRACT_DECORATOR__VIEW_RULES:
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
			case ScreenDecoratorPackage.ABSTRACT_DECORATOR__MODEL:
				setModel((EClass)newValue);
				return;
			case ScreenDecoratorPackage.ABSTRACT_DECORATOR__VIEW_RULES:
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
			case ScreenDecoratorPackage.ABSTRACT_DECORATOR__MODEL:
				setModel((EClass)null);
				return;
			case ScreenDecoratorPackage.ABSTRACT_DECORATOR__VIEW_RULES:
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
			case ScreenDecoratorPackage.ABSTRACT_DECORATOR__MODEL:
				return model != null;
			case ScreenDecoratorPackage.ABSTRACT_DECORATOR__VIEW_RULES:
				return viewRules != null && !viewRules.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == DataProperties.class) {
			switch (derivedFeatureID) {
				case ScreenDecoratorPackage.ABSTRACT_DECORATOR__MODEL: return ScreenDecoratorPackage.DATA_PROPERTIES__MODEL;
				default: return -1;
			}
		}
		if (baseClass == ViewProperties.class) {
			switch (derivedFeatureID) {
				case ScreenDecoratorPackage.ABSTRACT_DECORATOR__VIEW_RULES: return ScreenDecoratorPackage.VIEW_PROPERTIES__VIEW_RULES;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == DataProperties.class) {
			switch (baseFeatureID) {
				case ScreenDecoratorPackage.DATA_PROPERTIES__MODEL: return ScreenDecoratorPackage.ABSTRACT_DECORATOR__MODEL;
				default: return -1;
			}
		}
		if (baseClass == ViewProperties.class) {
			switch (baseFeatureID) {
				case ScreenDecoratorPackage.VIEW_PROPERTIES__VIEW_RULES: return ScreenDecoratorPackage.ABSTRACT_DECORATOR__VIEW_RULES;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //AbstractDecoratorImpl
