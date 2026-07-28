package practicePackage._04_recursion.attempts;

public class Stage4 {


	/** 
	 * Do not modify
	 * helper for getPermutation
	 * n = 5 -> return 120
	 * n = 7 -> return 5040
	 */
	public static int factorial(int n) {
		if(n <= 1)
			return 1;
		return n*factorial(n-1);
	}

	/** 
	 * Do not modify
	 * helper for getPermutation
	 * n = 5 -> return "12345"
	 * n = 3 -> return "123"
	 */
	public static String getString(int n) {
		if(n==1) {
			return "1";
		}
		else {
			return getString(n-1) + n;
		}
	}

	/**
	 * 
	 * @param x
	 * @param n
	 * @return x to the power of n. 
	 * should have O(log n) complexity, not O(n) complexity
	 */
	public static int fastPower(int x, int n) {
		return 0;
	}

	/**
	 * 
	 * @param n
	 * @param k
	 * @return (better explained with an example)
	 * return null if n is 0 or k is less than 0 or k is more than or equal to factorial(n)
	 * Say n = 5
	 * Create a String "12345" (using helper getString)
	 * The list of permutations in lexicographic order are:
	 * 
	 * "12345" (k=0)
	 * "12354" (k=1)
	 * "12435" (k=2)
	 * "12453" (k=3)
	 * "12534" (k=4)
	 * "12543" (k=5)
	 * "13245" (k=6)
	 * ...
	 * 
	 * return the permutation at index k
	 */
	public static String getPermutation(int n, int k) {
		return null; //to be completed
	}

	/**
	 * 
	 * @param data
	 * @param start
	 * @param target
	 * @return true if some of the items of data, starting at index start,
	 * not necessarily next to each other, add up to target, false otherwise.
	 * if data = {10,70,20,90}, start = 0, target = 30, return true (10+20 = 30)
	 * if data = {10,70,20,90}, start = 0, target = 60, return false
	 */
	public static boolean addsUpTo(int[] data, int start, int target) {
		return false;
	}

	/**
	 * 
	 * @param data
	 * @param start
	 * @param target
	 * @param count
	 * @return the number of ways in which you can construct target by adding
	 * the items of data, starting at index start
	 * 
	 *  for example, 
	 *  if data = {10,70,20,90}, start = 0, target = 100
	 *  then return 2 (10+70+20 = 100, 10+90 = 100)
	 *  if data = {10,70,20,90,30}, start = 0, target = 100
	 *  then return 3 (10+70+20 = 100, 10+90 = 100, 70+30 = 100)
	 *  if data = {10,20,30,40,50,60}, start = 0, target = 100
	 *  then return 4 (10+20+30+40 = 100, 10+30+60 = 100, 20+30+50 = 100, 40+60 = 100)
	 *  
	 *  You CAN create a helper method
	 */
	public static int waysAddsUpTo(int[] data, int start, int target) {
		return 0;
	}

	/**
	 * @return index of the first item that is more than or equal to
	 * both it's neighbours (or the only neighbour in case it's the
	 * first or last item of the array).
	 * return -1 if no such item exists
	 * O(log n) complexity in best and worst cases for extra points
	 */
	public static int firstPeak(int[] data) {
		return -1;
	}

	/**
	 * 
	 * @param data
	 * @return the longest ascending subsequence (not necessarily consecutive).
	 * for example, if data = {10, 70, 20, 90, 20, 80}, return 4 
	 * since {10, 20, 20, 80} of length 4 is the longest ascending subsequence.
	 * 
	 * TEST NOT PROVIDED
	 */
	public static int longestAscendingSubsequence(int[] data) {
		return 0;
	}
}