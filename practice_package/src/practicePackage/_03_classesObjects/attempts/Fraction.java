package practicePackage._03_classesObjects.attempts;

/**
 * 
 * a fraction is a number of the form num/den where num and den are integers
 * and den cannot be zero.
 * examples: 5/12, -7/2, 0/20
 *
 */
public class Fraction {
	public int num; //can be anything
	public int den; //cannot be zero
	


	/**
	 * May be helpful for other methods
	 * 
	 * constructor: assign the parameters to corresponding instance variables
	 * @param n: value for num
	 * @param d: value for den (if d is 0, den should become 1)
	 */
	public Fraction(int n, int d) {
	}

	//DEFAULT CONSTRUCTOR, Do not modify
	public Fraction() {
		//DO NOT MODIFY!
		num = 0;
		den = 1;
	}

	
	public Fraction multiply(Fraction other) {
		return null;
	}
}