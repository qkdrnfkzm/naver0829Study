package main.validation;

public class Validation {

	public static void NumberCheck(String inputNumber) {
		boolean chkNum = inputNumber.matches("-?\\d+(\\.\\d+)?");

		if (chkNum && inputNumber.length() == 3) {
			return;
		}
		throw new IllegalArgumentException();
	}

}
