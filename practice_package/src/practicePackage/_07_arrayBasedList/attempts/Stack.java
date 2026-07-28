package practicePackage._07_arrayBasedList.attempts;

public class Stack {
	public int size;
	public String[] items;
	


	/**
	 * May be helpful for other methods
	 * 
	 * initialize array to an empty array and size to 0
	 */
	public Stack() {
	}

	/**
	 * May be helpful for other methods
	 * 
	 * add an item on "top" of the stack.
	 * For example, if the array is of length 10 and there are 7 items on the stack,
	 * the item passed is added as the 8th item, and now the stack size is 8.
	 * Note that nothing should be done if the passed String is null.
	 * @param s
	 */
	public void push(String s) {
	}

	/**
	 * 
	 * @return if no more items can be added to the stack.
	 * That is, the stack is at capacity
	 */
	public boolean isFull() {
		return false;
	}

	/**
	 * 
	 * @return the top item (and remove it) from the stack.
	 * return null if stack is empty.
	 */
	public String pop() {
		return null;
	}

	/**
	 * @param idx: index of item to be removed
	 * @return the item at index idx from the stack. Assume that the index of the "bottom"
	 * item is 0, and the top item is size-1.
	 * return null if there is no item at passed index.
	 */
	public String get(int idx) {
		return null;
	}
}