package practicePackage._05_arrayList.attempts;
import java.util.ArrayList;

import serviceClasses.MathService;
import serviceClasses.Rectangle;

@SuppressWarnings("unused")
public class Stage3 {


	/**
	 * 
	 * @param list
	 * @param target
	 * @return the SECOND-LAST index at which target exists in the list passed.
	 * return -1 if list is null or target doesn't exist TWICE in the list.
	 */
	public static int secondLastIndexOf(ArrayList<Integer> list, int target) {
		return 0; //to be completed
	}

	/**
	 * Remove all negative items from the list
	 * @param list
	 * 
	 * For example,
	 * 
	 * if list = [2, 4, 0, -1, -2, -3, 0, 4, -8, 3, 0, -1, -1], 
	 * it should become [2, 4, 0, 0, 4, 3, 0]
	 * 
	 * TIP: use remove method and use the debugger to ensure that the right item is being removed
	 */
	public static void removeNegatives(ArrayList<Integer> list) {
		//to be completed
	}

	/**
	 * 
	 * @param list
	 * @return true if the list contains three instances of target in a row, false otherwise.
	 * return false if list is null or if it contains less than 3 items
	 */
	public static boolean threeInARow(ArrayList<Integer> list, int target) {
		return false; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @return true if every item in the list occurs only once, false otherwise.
	 * return true if list is empty, false if the list is null
	 * 
	 * TIP: use of methods indexOf and lastIndexOf will make your life oh-so-easy
	 */
	public static boolean allUnique(ArrayList<Integer> list) {
		return false; //to be completed
	}

	/**
	 * 
	 * @param n
	 * @param init
	 * @param inc
	 * @return an list containing n items such that the first item is init, 
	 * and each item is inc more than the previous item.
	 * return null if n is less than 0
	 * 
	 * NOTE 1: take special care when n = 0, the method should return the list {}
	 * NOTE 2: inc can be negative too :)
	 */
	public static ArrayList<Integer> generatePatternedArray(int n, int init, int inc) {
		return null; //to be completed
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @return true if a and b have the same items in the same order,
	 * false otherwise 
	 * return false if either of list passed is null
	 */
	public static boolean identical(ArrayList<Integer> a, ArrayList<Integer> b) {
		return false; //to be completed
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @return true if a and b have the same items but not necessarily in the same order,
	 * false otherwise 
	 * return false if either of list passed is null
	 */
	public static boolean same(ArrayList<Integer> a, ArrayList<Integer> b) {
		return false; //to be completed
	}

	/**
	 * 
	 * @param n
	 * @return an list containing items {1, 2, ..., n-1, n}
	 * return null if n is less than 0
	 */
	public static ArrayList<Integer> generate(int n) {
		return null; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @return an list containing the numbers of occurrences of all distinct items in list
	 * return null if the list is null.
	 */
	public static ArrayList<ArrayList<Integer>> getFrequencyTable(ArrayList<Integer> list) {
		return null; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @return the item that appears most in the list,
	 * or the first item that does so in case of a tie
	 * You may assume that list passed is NOT null
	 */
	public static int getMostFrequentItem(ArrayList<Integer> list) {
		return 0; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @param end
	 * @return a sublist of list from the start of the list to index end (inclusive),
	 * return null if list is null or empty or end is invalid
	 */
	public static ArrayList<Integer> sublistUptoIndex(ArrayList<Integer> list, int end) {
		return null; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @return an list containing all negative items of list,
	 * return null if list passed is null,
	 * return an empty list if list passed is empty
	 */
	public static ArrayList<Integer> getNegatives(ArrayList<Integer> list) {
		return null; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @return an list containing all items of list that are prime numbers,
	 * return null if list passed is null,
	 * return an empty list if list passed is empty
	 * 
	 * TIP: Use isPrime from MathService class as:
	 * MathService.isPrime(number to check)
	 */
	public static ArrayList<Integer> getPrimes(ArrayList<Integer> list) {
		return null; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @return an list containing all non-positive items of list,
	 * return null if list passed is null,
	 * return an empty list if list passed is empty
	 */
	public static ArrayList<Integer> getWithoutPositives(ArrayList<Integer> list) {
		return null; //to be completed
	}

	/**
	 * 
	 * @param list: a list of lists
	 * @return a copy of the list passed as parameter (not the same reference),
	 * return null if list passed is null,
	 * return an empty list if list passed is empty
	 * 
	 * TIP: use method getCopy from Stage2
	 */
	public static ArrayList<ArrayList<Integer>> getCopy(ArrayList<ArrayList<Integer>> list) {
		return null; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @param sub
	 * @return the last index at which sub starts in list
	 * return -1 if sub has a higher length than list or there is no such sub found in list
	 */
	public static int lastIndexOf(ArrayList<Integer> list, ArrayList<Integer> sub) {
		return 0; //to be completed
	}

	/**
	 * 
	 * @param list: a list of lists
	 * @return the total number of even items in non-null sublists of list,
	 * return 0 if list is null or empty
	 */
	public static int totalNumberOfEvenItems(ArrayList<ArrayList<Integer>> list) {
		return 0; //to be completed
	}

	/**
	 * 
	 * @param list: a list of lists
	 * @return the total number of positive items in non-null sublists of list,
	 * return 0 if list is null or empty
	 */
	public static int totalNumberOfPositiveItems(ArrayList<ArrayList<Integer>> list) {
		return 0; //to be completed
	}

	/**
	 * 
	 * @param list: a list of lists
	 * @return the total number of unique items (items existing only once) within a non-null sublist of list,
	 * return 0 if list is null or empty
	 */
	public static int totalNumberOfUniqueItems(ArrayList<ArrayList<Integer>> list) {
		return 0; //to be completed
	}

	/**
	 * 
	 * @param list: a list of lists
	 * @return the number of non-null sublists in list,
	 * return 0 if list is null or empty
	 */
	public static int countNonNullSublists(ArrayList<ArrayList<Integer>> list) {
		return 0; //to be completed
	}
}