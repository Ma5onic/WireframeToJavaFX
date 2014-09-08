/**
 */
package no.fhl.screenDecorator.impl;

import com.wireframesketcher.model.WidgetContainer;

import no.fhl.screenDecorator.ScreenDecoratorPackage;
import no.fhl.screenDecorator.WidgetContainerDecorator;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Widget Container Decorator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.fhl.screenDecorator.impl.WidgetContainerDecoratorImpl#getWidgetContainer <em>Widget Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WidgetContainerDecoratorImpl extends AbstractDecoratorImpl implements WidgetContainerDecorator {
	/**
	 * The cached value of the '{@link #getWidgetContainer() <em>Widget Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidgetContainer()
	 * @generated
	 * @ordered
	 */
	protected WidgetContainer widgetContainer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WidgetContainerDecoratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScreenDecoratorPackage.Literals.WIDGET_CONTAINER_DECORATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WidgetContainer getWidgetContainer() {
		if (widgetContainer != null && widgetContainer.eIsProxy()) {
			InternalEObject oldWidgetContainer = (InternalEObject)widgetContainer;
			widgetContainer = (WidgetContainer)eResolveProxy(oldWidgetContainer);
			if (widgetContainer != oldWidgetContainer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScreenDecoratorPackage.WIDGET_CONTAINER_DECORATOR__WIDGET_CONTAINER, oldWidgetContainer, widgetContainer));
			}
		}
		return widgetContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WidgetContainer basicGetWidgetContainer() {
		return widgetContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidgetContainer(WidgetContainer newWidgetContainer) {
		WidgetContainer oldWidgetContainer = widgetContainer;
		widgetContainer = newWidgetContainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScreenDecoratorPackage.WIDGET_CONTAINER_DECORATOR__WIDGET_CONTAINER, oldWidgetContainer, widgetContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ScreenDecoratorPackage.WIDGET_CONTAINER_DECORATOR__WIDGET_CONTAINER:
				if (resolve) return getWidgetContainer();
				return basicGetWidgetContainer();
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
			case ScreenDecoratorPackage.WIDGET_CONTAINER_DECORATOR__WIDGET_CONTAINER:
				setWidgetContainer((WidgetContainer)newValue);
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
			case ScreenDecoratorPackage.WIDGET_CONTAINER_DECORATOR__WIDGET_CONTAINER:
				setWidgetContainer((WidgetContainer)null);
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
			case ScreenDecoratorPackage.WIDGET_CONTAINER_DECORATOR__WIDGET_CONTAINER:
				return widgetContainer != null;
		}
		return super.eIsSet(featureID);
	}

} //WidgetContainerDecoratorImpl
