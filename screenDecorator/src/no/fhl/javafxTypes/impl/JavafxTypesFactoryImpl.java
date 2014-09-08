/**
 */
package no.fhl.javafxTypes.impl;

import javafx.scene.paint.Color;
import no.fhl.javafxTypes.*;
import no.fhl.javafxTypes.JavafxTypesFactory;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JavafxTypesFactoryImpl extends EFactoryImpl implements JavafxTypesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JavafxTypesFactory init() {
		try {
			JavafxTypesFactory theJavafxTypesFactory = (JavafxTypesFactory)EPackage.Registry.INSTANCE.getEFactory(JavafxTypesPackage.eNS_URI);
			if (theJavafxTypesFactory != null) {
				return theJavafxTypesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new JavafxTypesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavafxTypesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case JavafxTypesPackage.FX_COLOR:
				return createFXColorFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case JavafxTypesPackage.FX_COLOR:
				return convertFXColorToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @NOT generated
	 */
	public Color createFXColorFromString(EDataType eDataType, String initialValue) {
		Color color = null;
		try {
			color = Color.valueOf(initialValue);
			System.out.println("color = Color.valueOf(initialValue) => "+ initialValue);
		} catch (Exception e) {
			System.out.println("Failed trying to convert String to FXColor");
		}
		try {
			if (color == null) {
				String[] tokens = initialValue.split(",");
				double[] values = new double[tokens.length];
				for (int i = 0; i < tokens.length; i++) {
					values[i] = Double.valueOf(tokens[i]);
				}
				color = new Color(doubleValue(values, 0, 0.0), doubleValue(values, 1, 0.0), doubleValue(values, 2, 0.0), doubleValue(values, 3, 0.0));
			}
		} catch (NumberFormatException e) {
		}
		return (color != null ? color : Color.BLACK);
	}

	private double doubleValue(double[] values, int num, double def) {
		return values.length > num ? values[num] : def;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @NOT generated
	 */
	public String convertFXColorToString(EDataType eDataType, Object instanceValue) {
		Color color = (Color)instanceValue;
		return color.getRed() + "," + color.getGreen() + "," + color.getBlue() + "," + color.getOpacity();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavafxTypesPackage getJavafxTypesPackage() {
		return (JavafxTypesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static JavafxTypesPackage getPackage() {
		return JavafxTypesPackage.eINSTANCE;
	}

} //JavafxTypesFactoryImpl
