package practicePackage._05_arrayList.attempts;
import java.util.ArrayList;

import serviceClasses.Rectangle;

public class Stage1 {


	/**
	 * 
	 * @param list
	 * @return the sum of the first and last items
	 * return null if list is null or empty
	 * return the only value if list contains a single item
	 */
	public static Integer getSumFirstLastItems(ArrayList<Integer> list) {
		if (list == null || list.size() <= 0) {
			return null;
		} else if (list.size() == 1) {
			return list.get(0);
		} else {
			int a = list.get(0);
			int b = list.get(list.size() - 1);
			Integer c = a + b;
			return c;
		}
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @return true if the two lists are of the same size, false otherwise
	 * return false if EITHER list is null
	 */
	public static boolean sameSize(ArrayList<Integer> a, ArrayList<Integer> b) {
		if (a == null || b == null || (a.size() != b.size())) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param list - an arraylist of Rectangle objects
	 * @return the first item in the list.
	 * return null if list is null or empty
	 */
	public static Rectangle getFirstItem(ArrayList<Rectangle> list) {
		if(list == null || list.size() <= 0){
			return null;
		} else {
			return list.get(0);
		}
	}
}