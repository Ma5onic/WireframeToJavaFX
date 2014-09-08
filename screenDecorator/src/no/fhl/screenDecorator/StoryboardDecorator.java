/**
 */
package no.fhl.screenDecorator;

import com.wireframesketcher.model.story.Storyboard;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Storyboard Decorator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.fhl.screenDecorator.StoryboardDecorator#getStoryboard <em>Storyboard</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.fhl.screenDecorator.ScreenDecoratorPackage#getStoryboardDecorator()
 * @model
 * @generated
 */
public interface StoryboardDecorator extends AbstractDecorator {
	/**
	 * Returns the value of the '<em><b>Storyboard</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Storyboard</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Storyboard</em>' reference.
	 * @see #setStoryboard(Storyboard)
	 * @see no.fhl.screenDecorator.ScreenDecoratorPackage#getStoryboardDecorator_Storyboard()
	 * @model
	 * @generated
	 */
	Storyboard getStoryboard();

	/**
	 * Sets the value of the '{@link no.fhl.screenDecorator.StoryboardDecorator#getStoryboard <em>Storyboard</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Storyboard</em>' reference.
	 * @see #getStoryboard()
	 * @generated
	 */
	void setStoryboard(Storyboard value);

} // StoryboardDecorator
