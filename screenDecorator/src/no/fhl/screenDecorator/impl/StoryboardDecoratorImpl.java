/**
 */
package no.fhl.screenDecorator.impl;

import com.wireframesketcher.model.story.Storyboard;

import no.fhl.screenDecorator.ScreenDecoratorPackage;
import no.fhl.screenDecorator.StoryboardDecorator;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Storyboard Decorator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.fhl.screenDecorator.impl.StoryboardDecoratorImpl#getStoryboard <em>Storyboard</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StoryboardDecoratorImpl extends AbstractDecoratorImpl implements StoryboardDecorator {
	/**
	 * The cached value of the '{@link #getStoryboard() <em>Storyboard</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStoryboard()
	 * @generated
	 * @ordered
	 */
	protected Storyboard storyboard;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StoryboardDecoratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScreenDecoratorPackage.Literals.STORYBOARD_DECORATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Storyboard getStoryboard() {
		if (storyboard != null && storyboard.eIsProxy()) {
			InternalEObject oldStoryboard = (InternalEObject)storyboard;
			storyboard = (Storyboard)eResolveProxy(oldStoryboard);
			if (storyboard != oldStoryboard) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScreenDecoratorPackage.STORYBOARD_DECORATOR__STORYBOARD, oldStoryboard, storyboard));
			}
		}
		return storyboard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Storyboard basicGetStoryboard() {
		return storyboard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStoryboard(Storyboard newStoryboard) {
		Storyboard oldStoryboard = storyboard;
		storyboard = newStoryboard;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScreenDecoratorPackage.STORYBOARD_DECORATOR__STORYBOARD, oldStoryboard, storyboard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ScreenDecoratorPackage.STORYBOARD_DECORATOR__STORYBOARD:
				if (resolve) return getStoryboard();
				return basicGetStoryboard();
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
			case ScreenDecoratorPackage.STORYBOARD_DECORATOR__STORYBOARD:
				setStoryboard((Storyboard)newValue);
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
			case ScreenDecoratorPackage.STORYBOARD_DECORATOR__STORYBOARD:
				setStoryboard((Storyboard)null);
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
			case ScreenDecoratorPackage.STORYBOARD_DECORATOR__STORYBOARD:
				return storyboard != null;
		}
		return super.eIsSet(featureID);
	}

} //StoryboardDecoratorImpl
