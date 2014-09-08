/**
 */
package no.fhl.screenDecorator;

import com.wireframesketcher.model.WidgetContainer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Widget Container Decorator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.fhl.screenDecorator.WidgetContainerDecorator#getWidgetContainer <em>Widget Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.fhl.screenDecorator.ScreenDecoratorPackage#getWidgetContainerDecorator()
 * @model
 * @generated
 */
public interface WidgetContainerDecorator extends AbstractDecorator {
	/**
	 * Returns the value of the '<em><b>Widget Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Widget Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Widget Container</em>' reference.
	 * @see #setWidgetContainer(WidgetContainer)
	 * @see no.fhl.screenDecorator.ScreenDecoratorPackage#getWidgetContainerDecorator_WidgetContainer()
	 * @model
	 * @generated
	 */
	WidgetContainer getWidgetContainer();

	/**
	 * Sets the value of the '{@link no.fhl.screenDecorator.WidgetContainerDecorator#getWidgetContainer <em>Widget Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Widget Container</em>' reference.
	 * @see #getWidgetContainer()
	 * @generated
	 */
	void setWidgetContainer(WidgetContainer value);

} // WidgetContainerDecorator
