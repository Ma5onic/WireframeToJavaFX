/**
 */
package no.fhl.screenDecorator;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Script Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.fhl.screenDecorator.EventScriptAction#getEventName <em>Event Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.fhl.screenDecorator.ScreenDecoratorPackage#getEventScriptAction()
 * @model
 * @generated
 */
public interface EventScriptAction extends ScriptAction {
	/**
	 * Returns the value of the '<em><b>Event Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Name</em>' attribute.
	 * @see #setEventName(String)
	 * @see no.fhl.screenDecorator.ScreenDecoratorPackage#getEventScriptAction_EventName()
	 * @model
	 * @generated
	 */
	String getEventName();

	/**
	 * Sets the value of the '{@link no.fhl.screenDecorator.EventScriptAction#getEventName <em>Event Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Name</em>' attribute.
	 * @see #getEventName()
	 * @generated
	 */
	void setEventName(String value);

} // EventScriptAction
