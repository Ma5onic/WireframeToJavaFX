/**
 */
package no.fhl.screenDecorator;

import com.wireframesketcher.model.Widget;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Widget Decorator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.fhl.screenDecorator.WidgetDecorator#getWidget <em>Widget</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.fhl.screenDecorator.ScreenDecoratorPackage#getWidgetDecorator()
 * @model
 * @generated
 */
public interface WidgetDecorator extends AbstractDecorator {
	/**
	 * Returns the value of the '<em><b>Widget</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Widget</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Widget</em>' reference.
	 * @see #setWidget(Widget)
	 * @see no.fhl.screenDecorator.ScreenDecoratorPackage#getWidgetDecorator_Widget()
	 * @model
	 * @generated
	 */
	Widget getWidget();

	/**
	 * Sets the value of the '{@link no.fhl.screenDecorator.WidgetDecorator#getWidget <em>Widget</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Widget</em>' reference.
	 * @see #getWidget()
	 * @generated
	 */
	void setWidget(Widget value);

} // WidgetDecorator
