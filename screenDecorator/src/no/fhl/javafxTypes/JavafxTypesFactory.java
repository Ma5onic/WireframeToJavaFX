/**
 */
package no.fhl.javafxTypes;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see no.fhl.javafxTypes.JavafxTypesPackage
 * @generated
 */
public interface JavafxTypesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	JavafxTypesFactory eINSTANCE = no.fhl.javafxTypes.impl.JavafxTypesFactoryImpl.init();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	JavafxTypesPackage getJavafxTypesPackage();

} //JavafxTypesFactory
