package it.engineering.web.test.verificator;

public class Validator {

	public static boolean isAllDigitString(String data) {
		for (char c : data.toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isLength(String data, int length) {
		return data.length() == length;
	}

	public static boolean isMaxLength(String data, int length) {
		return data.length() <= length;
	}

	public static boolean isEmpty(String data) {
		return data.length() == 0;
	}
	
	
}
