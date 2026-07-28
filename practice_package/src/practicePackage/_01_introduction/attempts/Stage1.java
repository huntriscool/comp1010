package practicePackage._01_introduction.attempts;

public class Stage1 {


	/**
	 * 
	 * @param n
	 * @return the cube of n
	 */
	public static int cube(int n) {
		return n*n*n; //to be completed
	}

	/**
	 * 
	 * @param n (assume n >= 0)
	 * @return the last digit of the number n
	 */
	public static int lastDigit(int n) {
		return n%10; 
	}

	/**
	 * 
	 * @param n
	 * @return true if n is even (divisible by 2), false otherwise
	 */
	public static boolean isEven(int n) {
		if(n%2==0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * assumption: one of the two values passed is even, other is odd
	 * 
	 * @param a
	 * @param b
	 * @return the value that is even
	 */
	public static int evenOne(int a, int b) {
		if(a%2==0) {
			return a;
		}
		else {
			return b;
		}
	}

	/**
	 * DO NOT use Math library
	 * @param a
	 * @param b
	 * @param c
	 * @return the highest of the three integers passed
	 */
	public static int highest(int a, int b, int c) {
		if (a >= b && a >= c) {
			return a;
		}
		else if (b >= a && b >= c) {
			return b;
		}
		else {
			return c;
		}
	}
}