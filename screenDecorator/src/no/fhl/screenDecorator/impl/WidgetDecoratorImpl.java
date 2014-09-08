/**
 */
package no.fhl.screenDecorator.impl;

import com.wireframesketcher.model.Widget;

import no.fhl.screenDecorator.ScreenDecoratorPackage;
import no.fhl.screenDecorator.WidgetDecorator;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Widget Decorator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.fhl.screenDecorator.impl.WidgetDecoratorImpl#getWidget <em>Widget</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WidgetDecoratorImpl extends AbstractDecoratorImpl implements WidgetDecorator {
	/**
	 * The cached value of the '{@link #getWidget() <em>Widget</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidget()
	 * @generated
	 * @ordered
	 */
	protected Widget widget;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WidgetDecoratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScreenDecoratorPackage.Literals.WIDGET_DECORATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Widget getWidget() {
		if (widget != null && widget.eIsProxy()) {
			InternalEObject oldWidget = (InternalEObject)widget;
			widget = (Widget)eResolveProxy(oldWidget);
			if (widget != oldWidget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScreenDecoratorPackage.WIDGET_DECORATOR__WIDGET, oldWidget, widget));
			}
		}
		return widget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Widget basicGetWidget() {
		return widget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidget(Widget newWidget) {
		Widget oldWidget = widget;
		widget = newWidget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScreenDecoratorPackage.WIDGET_DECORATOR__WIDGET, oldWidget, widget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ScreenDecoratorPackage.WIDGET_DECORATOR__WIDGET:
				if (resolve) return getWidget();
				return basicGetWidget();
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
			case ScreenDecoratorPackage.WIDGET_DECORATOR__WIDGET:
				setWidget((Widget)newValue);
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
			case ScreenDecoratorPackage.WIDGET_DECORATOR__WIDGET:
				setWidget((Widget)null);
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
			case ScreenDecoratorPackage.WIDGET_DECORATOR__WIDGET:
				return widget != null;
		}
		return super.eIsSet(featureID);
	}

} //WidgetDecoratorImpl
