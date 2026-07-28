package serviceClasses;

public class MathService {
	/**
	 * DO NOT MODIFY
	 * A number is prime numbers if it is more than 1 
	 * and divisible only by 1 and itself 
	 * @param n
	 * @return true if the integer passed is prime, 
	 * false otherwise
	 */
	public static boolean isPrime(int n) {
		if(n < 2)
			return false;
		for(int i=2; i*i <= n; i++) {
			if(n%i == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @param n
	 * @return true if n is a (perfect) square,
	 * that is square of an integer, false otherwise
	 */
	public static boolean isSquare(int n) {
		int root = (int)Math.sqrt(n);
		return root * root == n;
	}

	public static double max(double a, double b) {
		if(a > b) {
			return a;
		}
		return b;
	}

	public static double min(double a, double b) {
		if(a < b) {
			return a;
		}
		return b;
	}

	public static double abs(double a) {
		if(a > 0) {
			return a;
		}
		return -a;
	}

	public static double sqrt(double val) throws Exception {
		if(val < 0) {
			throw new Exception("Cannot calculate square root of negative values");
		}
		return sqrt(val, val/2, 0);
	}

	private static double sqrt(double val, double currentAnswer, double previousAnswer) {
		if(abs(currentAnswer - previousAnswer)<=0.0000001) {
			int i = (int)(currentAnswer+0.5); //to check perfect square, find rounded off value
			if(i*i == val) { //and see if squares to the original number
				return i;
			}
			return currentAnswer;
		}
		double d1 = val - currentAnswer * currentAnswer;
		double d2 = val - previousAnswer * previousAnswer;
		boolean currentGuesssOnLeft = d1 > 0;
		boolean currentGuesssOnRight = d1 <= 0;
		boolean previousGuesssOnLeft = d2 > 0;
		boolean previousGuesssOnRight = d2 <= 0;
		
		if(currentGuesssOnRight && previousGuesssOnLeft) {  //on opposite sides
			//System.out.println("right left");
			double avg = (currentAnswer + previousAnswer)/2;
			double d3 = val - (avg*avg);
			boolean newGuessOnLeft = d3 > 0;
			if(newGuessOnLeft) {
				return sqrt(val, avg, currentAnswer);
			}
			else {
				return sqrt(val, avg, previousAnswer);
			}
		}
		
		if(currentGuesssOnLeft && previousGuesssOnRight) {  //on opposite sides
			double avg = (currentAnswer + previousAnswer)/2;
			double d3 = val - (avg*avg);
			boolean newGuessOnLeft = d3 > 0;
			if(newGuessOnLeft) {
				return sqrt(val, avg, previousAnswer);
			}
			else {
				return sqrt(val, avg, currentAnswer);
			}
		}

		//both on right
		if(d1 > 0 && d2 > 0) {
			return sqrt(val, (max(currentAnswer, previousAnswer) + val)/2, max(currentAnswer, previousAnswer));
		}

		//both on left
		return sqrt(val, min(currentAnswer, previousAnswer)/2, min(currentAnswer, previousAnswer));
	}

	public static void main(String[] args) throws Exception {
		for(int i=1; i <= 10000000; i+=(int)(Math.random()*100)+1) {
			double ans = sqrt(i);
			//if(abs(ans*ans-i)>=0.1) {
				System.out.println(i+" "+ans+" "+ans*ans);
			//}
		}
	}
}