package practicePackage._04_recursion.attempts;

public class Stage5 {


	/**
	 * May be helpful for other methods
	 * 
	 * @param a: assume it's purely numerical
	 * @param b: assume it's purely numerical
	 * @return the result of a + b
	 */
	public static String addRecursive(String a, String b) {
		return ""; //to be completed
	}

	/**
	 * May be helpful for other methods
	 * 
	 * @param a: assume it's purely numerical
	 * @param b: assume it's purely numerical
	 * @return the result of a - b
	 */
	public static String subtractRecursive(String a, String b) {
		return ""; //to be completed
	}

	/**
	 * May be helpful for other methods
	 * 
	 * @param a: assume it's purely numerical
	 * @param b: assume it's purely numerical
	 * @return the result of a * b
	 */
	public static String multiplyRecursive(String a, String b) {
		return ""; //to be completed
	}

	/**
	 * May be helpful for other methods
	 * 
	 * @param a: assume it's purely numerical
	 * @param b: assume it's purely numerical
	 * @return the result of a % b
	 */
	public static String remainderRecursive(String a, String b) {
		return ""; //to be completed
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