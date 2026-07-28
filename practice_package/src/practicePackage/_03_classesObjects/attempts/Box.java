package practicePackage._03_classesObjects.attempts;

/**
 * 
 * @author gauravgupta
 * Box represents a three dimensional cuboid. We use the front perspective
 * such that 
 * the side from front to back is depth
 * the side from top to bottom is height
 * the side from left to right is width
 * 
 * IMPORTANT: Do NOT override equals()
 */
public class Box {
	public int depth, height, width;
	
	


	/**
	 * May be helpful for other methods
	 * 
	 * NOTE: if any of the values are less than 1, they should be made 1 before copying into 
	 * corresponding instance variable
	 * @param d (for depth)
	 * @param h (for height)
	 * @param w (for width)
	 */
	public Box(int d, int h, int w) {
	}

	/**
	 * May be helpful for other methods
	 * 
	 * copy constructor to create an instance copy of the passed object
	 * @param original
	 */
	public Box(Box original) {
	}

	/**
	 * May be helpful for other methods
	 * 
	 * @return the volume of the box
	 */
	public int volume() {
		return 0;
	}

	/**
	 * May be helpful for other methods
	 * 
	 * @param other
	 * @return 1 if calling object is "more than" parameter object
	 * -1 if calling object is "less than" parameter object
	 * 0 if calling object is "equal to" parameter object
	 * comparison criteria: volume -> surface area
	 *
	 */
	public int compareTo(Box other) { //volume -> surface area
		return 0;
	}

	/**
	 * May be helpful for other methods
	 * 
	 * HD
	 * @param other
	 * @return 1 if calling object is "more than" parameter object
	 * -1 if calling object is "less than" parameter object
	 * 0 if calling object is "equal to" parameter object
	 * comparison criteria: volume -> surface area -> longest sides -> second longest sides -> shortest side
	 */
	public int compareToAdvanced(Box other) { 
		return 0;
	}

	/**
	 * 
	 * @return the longest side of the box
	 */
	public int longestSide() {
		return 0;
	}

	/**
	 * 
	 * @return area of the front (or the back face)
	 */
	public int frontArea() {
		return 0;
	}

	/**
	 * 
	 * @return the surface area of the box
	 */
	public int surfaceArea() {
		return 0; 
	}

	/**
	 * D
	 * @param b
	 * @return true if the box represented by the calling object
	 * can fit inside the box represented by the parameter object, false otherwise.
	 * Note that a box cannot fit inside the box of the same dimension.
	 */
	public boolean canFitInside(Box b) {
		return true;
	}
}