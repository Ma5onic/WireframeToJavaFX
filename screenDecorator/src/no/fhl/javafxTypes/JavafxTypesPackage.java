/**
 */
package no.fhl.javafxTypes;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see no.fhl.javafxTypes.JavafxTypesFactory
 * @model kind="package"
 * @generated
 */
public interface JavafxTypesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "javafxTypes";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "javafx.types";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "javafxTypes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	JavafxTypesPackage eINSTANCE = no.fhl.javafxTypes.impl.JavafxTypesPackageImpl.init();

	/**
	 * The meta object id for the '<em>FX Color</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javafx.scene.paint.Color
	 * @see no.fhl.javafxTypes.impl.JavafxTypesPackageImpl#getFXColor()
	 * @generated
	 */
	int FX_COLOR = 0;


	/**
	 * Returns the meta object for data type '{@link javafx.scene.paint.Color <em>FX Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>FX Color</em>'.
	 * @see javafx.scene.paint.Color
	 * @model instanceClass="javafx.scene.paint.Color"
	 * @generated
	 */
	EDataType getFXColor();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	JavafxTypesFactory getJavafxTypesFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '<em>FX Color</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javafx.scene.paint.Color
		 * @see no.fhl.javafxTypes.impl.JavafxTypesPackageImpl#getFXColor()
		 * @generated
		 */
		EDataType FX_COLOR = eINSTANCE.getFXColor();

	}

} //JavafxTypesPackage
