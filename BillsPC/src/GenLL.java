/*
 * An example of a Generic Singly Linked List.
 * Written By: Josue
 */
public class GenLL<T>
{
	// private internal class

	private class ListNode
	{
		T data;
		ListNode link;

		public ListNode(T aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}

	// references

	ListNode head;
	ListNode current;
	ListNode previous;
	private int size;

	// constructor

	public GenLL()
	{
		head = current = previous = null;
		this.size = 0;
	}

	// methods

	/**
	 * Retrieves the data of the current Node.
	 * 
	 * @return the current' Node's data or null
	 */
	public T getCurrent()
	{
		// empty list
		if (current == null) return null;

		return current.data;
	}

	/**
	 * Retrieves the size of the Linked List.
	 * 
	 * @return size of the Linked List
	 */
	public int getSize()
	{
		return this.size;
	}

	/**
	 * Adds a new node to the linked list and updates size
	 * 
	 * @param aData
	 *            the object that is added to the linked list
	 */
	public void add(T aData)
	{
		ListNode newNode = new ListNode(aData, null);

		// empty list
		if (head == null)
		{
			head = current = newNode;
			this.size = 1;
			return;
		}

		// find end of list
		ListNode temp = head;

		while (temp.link != null)
			temp = temp.link;

		temp.link = newNode;
		this.size++;
	}

	/**
	 * Prints the data of the node if it is not null
	 */
	public void print()
	{
		ListNode temp = head;

		while (temp != null)
		{
			System.out.println(temp.data + "\n");
			temp = temp.link;
		}
	}

	/**
	 * Adds a new node after the node that current is pointing to and updates
	 * size, handles an empty list by returning
	 * 
	 * @param aData
	 *            the object that is added to the linked list
	 */
	public void addAfterCurrent(T aData)
	{
		// empty list
		if (current == null) return;

		ListNode newNode = new ListNode(aData,
				current.link);

		current.link = newNode;
		this.size++;
	}

	/**
	 * Sets the data of the node current is pointer to if current is not null
	 * 
	 * @param aData
	 *            the object data that will replace the old object data
	 */
	public void setCurrent(T aData)
	{
		if (aData == null || current == null) return;

		current.data = aData;
	}

	/**
	 * Moves the current pointer to the next node and updates the previous
	 * pointer, returns if current is null
	 */
	public void goToNext()
	{
		if (current == null) return;

		previous = current;
		current = current.link;
	}

	/**
	 * Moves the current pointer to the head / first node and updates the
	 * previous pointer to null / last node.
	 */
	public void reset()
	{
		current = head;
		previous = null;
	}

	/**
	 * Checks if the current node is null.
	 * 
	 * @return true if the current node is not null, false otherwise
	 */
	public boolean hasMore()
	{
		return current != null;
	}

	/**
	 * Removes the current node and updates previous and size.
	 */
	public void removeCurrent()
	{
		// current is at head
		if (current == head)
		{
			head = head.link;
			current = head;
		}
		else
		{
			previous.link = current.link;
			current = current.link;
		}

		if (this.size > 0) size--;
	}

	/**
	 * Retrieves the data of a node at a chosen index, is a helper method for a
	 * Merge Sorting method, returns null if the index if out of bounds.
	 * 
	 * @param index
	 *            the location of the node where you want to traverse to
	 * @return the data of the node of a certain index
	 */
	public T getAt(int index)
	{
		if (index < 0 || index >= size) return null;

		ListNode temp = head;

		for (int i = 0; i < index; i++)
			temp = temp.link;

		return temp.data;
	}

	/**
	 * Updates the data of a node at a chosen index, is a helper method for a
	 * Bubble Sort method, return is the index is out of bounds
	 * 
	 * @param index
	 *            the location of the node where you want to traverse to
	 * @param aData
	 *            the new data that will replace the old data
	 */
	public void setAt(int index, T aData)
	{
		if (index < 0 || index >= size) return;

		ListNode temp = head;

		for (int i = 0; i < index; i++)
			temp = temp.link;

		temp.data = aData;
	}

}
