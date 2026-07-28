package practicePackage._01_introduction.attempts;

public class Stage6 {
	/*
	 * VERY ADVANCED.
	 * 
	 * Relies on String manipulation and problem-solving.
	 * While you CAN use Integer.parseInt, it won't be enough, 
	 * because input data is hundreds of digits long, while
	 * Integer.parseInt can only handle 10 digits (or thereabouts)
	 */

	/**
	 * May be helpful for other methods
	 * 
	 * @param a: assume it's purely numerical
	 * @param b: assume it's purely numerical
	 * @return the result of a + b
	 */
	public static String add(String a, String b) {
		return "";
	}

	/**
	 * May be helpful for other methods
	 * 
	 * @param a: assume it's purely numerical
	 * @param b: assume it's purely numerical
	 * @return the result of a - b
	 */
	public static String subtract(String a, String b) {
		return "";
	}

	/**
	 * May be helpful for other methods
	 * 
	 * @param a: assume it's purely numerical
	 * @param b: assume it's purely numerical
	 * @return the result of a * b
	 */
	public static String multiply(String a, String b) {
		return "";
	}

	/**
	 * May be helpful for other methods
	 * 
	 * @param a: assume it's purely numerical
	 * @param b: assume it's purely numerical
	 * @return the result of a divided by b
	 */
	public static String divide(String a, String b) {
		return "";
	}

	/**
	 * May be helpful for other methods
	 * 
	 * @param a: assume it's purely numerical
	 * @param b: assume it's purely numerical
	 * @return the result of a % b
	 */
	public static String remainder(String a, String b) {
		return "";
	}

	// Do not modify
	public static String getRandomInteger(int minDigits, int maxDigits) {
		int n = (int)(Math.random()*(maxDigits - minDigits + 1)) + minDigits;
		String result = "";
		for(int i=0; i < n; i++) {
			result = result + (int)(Math.random()*10);
		}
		return result;
	}
}