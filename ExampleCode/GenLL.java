/*
 * An example of a Generic Singly Linked List
 * Written By: Josue
 */

public class GenLL<T>
{
	// private nodes

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

	// accessors

	/**
	 * Retrieves the current Node's data. If the current Node is null, no action
	 * is taken.
	 * 
	 * @return the data of the current Node or nothing if the current Node is
	 *         null
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
	 * @return the size of the Linked List
	 */
	public int getSize()
	{
		return this.size;
	}

	// other methods

	/**
	 * Adds a Node to the end of the Linked List based on given data. If the
	 * head reference is null, signaling an empty list, the head and current
	 * reference is updated accordingly. Size is incremented after addition.
	 * 
	 * @param aData
	 *            the data to be added to the Linked List
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
	 * Traverses the Linked List and prints each Node that is not null.
	 */
	public void print()
	{
		ListNode temp = head;

		while (temp != null)
		{
			System.out.println(temp.data);
			temp = temp.link;
		}
	}

	/**
	 * Adds a Node after where the current pointer is. Size is updated after
	 * addition. If the current Node is null, no action is taken.
	 * 
	 * @param aData
	 *            the data to be added to the Linked List
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
	 * Sets the data of the current Node to the given data. If the given data is
	 * null, or the current Node is null, no action is taken.
	 * 
	 * @param aData
	 *            the value to set as the data of the current Node
	 */
	public void setCurrent(T aData)
	{
		if (aData == null || current == null) return;

		current.data = aData;
	}

	/**
	 * Moves the current pointer to the next Node. If the current Node is null,
	 * no action is taken.
	 */
	public void goToNext()
	{
		if (current == null) return;

		previous = current;
		current = current.link;
	}

	/**
	 * Moves the current pointer to the head reference, which signals the start
	 * of the Linked List.
	 */
	public void reset()
	{
		current = head;
		previous = null;
	}

	/**
	 * Checks if the current Node is not null.
	 * 
	 * @return true if the current Node is not null, false otherwise
	 */
	public boolean hasMore()
	{
		return current != null;
	}

	/**
	 * Removes the Node where the current pointer is referencing. If the current
	 * pointer is referencing the head, the head and current references are
	 * updated accordingly. Size is decremented if the size of the Linked List
	 * is greater than 0.
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
	 * Retrieves the data of a Node in the Linked List at a given index. If the
	 * given index is out of bounds, null is returned.
	 * 
	 * @param index
	 *            the index of the Linked List to retrieve data from
	 * @return the data of the node of a given index, or null if the given index
	 *         is out of bounds
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
	 * Sets the data of a Node in the Linked List at a given index. If the given
	 * index is out of bounds, no action is taken.
	 * 
	 * @param index
	 *            the index to set data at in the Linked List
	 * @param aData
	 *            the value to set the Node's data to
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
