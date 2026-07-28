package practicePackage._08_recursiveDataStructures.attempts;

import practicePackage._08_recursiveDataStructures.Node;

public class NodeService {


	//DO NOT MODIFY
	public static String toString(Node start) {
		return "["+ toStringSecondary(start);
	}

	// DO NOT MODIFY
	public static String toStringSecondary(Node start) {
		if(start == null) {
			return "]";
		}
		String sub = toStringSecondary(start.next);
		if(sub == "]") {
			return start.data + sub;
		}
		else {
			return start.data + ", " + sub;
		}
	}

	/**
	 * 
	 * @param start
	 * @return sum of all odd numbers
	 */
	public static int sumOdd(Node start) {
		return 0;
	}

	/**
	 * 
	 * @param start
	 * @return number of positive numbers
	 */
	public static int countPositives(Node start) {
		return 0;
	}

	/**
	 * 
	 * @param start
	 * @return the first Node starting at Node start
	 * containing a positive data value
	 * return null if no Node containing a positive data value
	 * 
	 * for example, if
	 * start represents [-5, 0, 6, 2, -8, 0]
	 * 
	 * and the Node returned is result, then
	 * result represents [6, 2, -8, 0]
	 */
	public static Node getFirstPositiveNode(Node start) {
		return null;
	}

	/**
	 * 
	 * @param start
	 * @param idx
	 * @return a reference to the node at index idx (if any) in the sequence
	 * of nodes starting at start. return null if an item doesn't exist at that index.
	 * Note: first item (start) is considered to be at index 0
	 */
	public static Node getItemAt(Node start, int idx) {
		return null;
	}

	/**
	 * 
	 * @param start
	 * @param val
	 * do nothing (and return false) if start is null.
	 * otherwise, add a node containing val at the end of the sequence
	 * of nodes starting at start, and return true.
	 */
	public static boolean append(Node start, int val) {
		return false;
	}

	/**
	 * 
	 * @param start1
	 * @param start2
	 * @return true if items starting at Nodes
	 * start1 and start2 are the same  
	 * (ok to be in different order)
	 * 
	 * FOR EXAMPLE,
	 *
	 * if 
	 * start1 represents [10, 70, 20, 90]
	 * start2 represents [90, 10, 20, 70]
	 * return true
	 *
	 * if 
	 * start1 represents [10, 60, 20, 90]
	 * start2 represents [90, 10, 20, 70]
	 * return false
	 * 
	 * if 
	 * start1 represents [10, 20, 90]
	 * start2 represents [90, 10, 20, 70]
	 * return false
	 * 
	 * if 
	 * start1 represents [10, 20, 90]
	 * start2 represents [10, 20]
	 * return false
	 */
	public static boolean same(Node start1, Node start2) {
		return false; //to be completed
	}

	/**
	 * sort the nodes starting at Node start
	 * in ascending order if asc = true,
	 * otherwise sort in descending order
	 * @param start
	 * @param asc
	 * @return reference to the first Node at which the sorted sequence starts
	 */
	public static Node sort(Node start, boolean asc) {
		return null; //to be completed
	}
}