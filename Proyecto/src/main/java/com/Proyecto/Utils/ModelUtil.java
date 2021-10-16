package com.Proyecto.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModelUtil {
	public static boolean verificarCadenaVacio(String cadena) {
		return cadena.isEmpty();
	}

	public static boolean validarCedula(String cedula) {
		byte sum = 0;
		try {
			if (cedula.trim().length() != 10)
				return false;
			String[] data = cedula.split("");
			byte verifier = Byte.parseByte(data[0] + data[1]);
			if (verifier < 1 || verifier > 24)
				return false;
			byte[] digits = new byte[data.length];
			for (byte i = 0; i < digits.length; i++)
				digits[i] = Byte.parseByte(data[i]);
			if (digits[2] > 6)
				return false;
			for (byte i = 0; i < digits.length - 1; i++) {
				if (i % 2 == 0) {
					verifier = (byte) (digits[i] * 2);
					if (verifier > 9)
						verifier = (byte) (verifier - 9);
				} else
					verifier = (byte) (digits[i] * 1);
				sum = (byte) (sum + verifier);
			}
			if ((sum - (sum % 10) + 10 - sum) == digits[9])
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean validacionSoloLetras(String cadena) {

		for (int i = 0; i < cadena.length(); i++) {
			char caracter = cadena.toUpperCase().charAt(i);
			int valorASCII = (int) caracter;
			if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90))
				return false;
		}

		return true;
	}

	public static boolean validacionSoloNumeros(String cadena) {

		for (int i = 0; i < cadena.length(); i++) {
			char caracter = cadena.charAt(i);
			int valorASCII = (int) caracter;
			if (valorASCII < 48 || valorASCII > 57)
				return false;
		}

		return true;
	}

	public static boolean ValidarMail(String email) {

		Pattern pattern = Pattern
				.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		Matcher mather = pattern.matcher(email);
		return mather.find();
	}

}
