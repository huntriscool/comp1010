package practicePackage._07_arrayBasedList.attempts;

public class Queue {
	public int size;
	public String[] items;
	


	/**
	 * May be helpful for other methods
	 * 
	 * initialize array to an empty array and size to 0
	 */
	public Queue() {
		// To be completed
	}

	/**
	 * May be helpful for other methods
	 * 
	 * add an item on "top" of the queue.
	 * For example, if the array is of length 10 and there are 7 items on the queue,
	 * the item passed is added as the 8th item, and now the queue size is 8.
	 * Note that nothing should be done if the passed String is null.
	 * @param s
	 */
	public void insert(String s) {
		return; //to be completed
	}

	/**
	 * 
	 * @return if no more items can be added to the queue.
	 * That is, the queue is at capacity
	 */
	public boolean isFull() {
		return false; //to be completed
	}

	/**
	 * 
	 * @return the front item (and remove it) from the queue.
	 * return null if queue is empty.
	 */
	public String remove() {
		return ""; //to be completed
	}

	/**
	 * @param idx: index of item to be removed
	 * @return the item at index idx from the queue. Assume that the index of the "bottom"
	 * item is 0, and the top item is size-1.
	 * return null if there is no item at passed index.
	 */
	public String get(int idx) {
		return ""; //to be completed
	}
}