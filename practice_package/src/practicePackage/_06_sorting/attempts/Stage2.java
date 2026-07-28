package practicePackage._06_sorting.attempts;

public class Stage2 {


	/**
	 * @param data - assume data is sorted up to idx and all numbers in the sorted
	 *             part is smaller than in the unsorted part.
	 * @param idx
	 * @return the array after the next swap has occurred. For example [20, 70, 40,
	 *         90, 30, 80, 20] would swap 70 and 20.
	 */
	public static int[] swapToRightPlace(int[] data, int idx) {
		return null; //to be completed
	}

	/**
	 * 
	 * @param data
	 * @return the most common number in the sorted array. If there is a tie, select
	 *         the number that occurs first. If data is invalid or empty, return -1.
	 */
	public static int mostCommon(int[] data) {
		return -1; //to be completed
	}

	/**
	 * @param data
	 * @param val
	 * @return the array after val is inserted at the correct position. Assume data
	 *         is sorted is ascending order. If the array is invalid, return null.
	 */
	public static int[] insertAtRightPlace(int[] data, int val) {
		return null; //to be completed
	}

	/**
	 * ADVANCED: there exists an O(n*logn) solution using merge sort (which will be
	 * covered in 2010)
	 * 
	 * @param data
	 * @return the number of swaps needed to sort the array using bubble sort.
	 *         Return -1 if data is invalid.
	 */
	public static int bubbleSortCount(int[] data) {
		return -1; //to be completed
	}
}