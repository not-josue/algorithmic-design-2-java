/*
 * An example of a Generic Circular Doubly Linked List.
 * Written By: Josue
 */

public class GenCircularLL<T>
{
	// private internal class

	private class ListNode
	{
		T data;
		ListNode next;
		ListNode prev;

		public ListNode(T aData, ListNode aNext,
				ListNode aPrev)
		{
			data = aData;
			next = aNext;
			prev = aPrev;
		}
	}

	// references

	ListNode head;
	ListNode tail;
	ListNode current;
	private int size;

	// constructor

	public GenCircularLL()
	{
		head = tail = current = null;
		this.size = 0;
	}

	// methods

	/**
	 * Retrieves the data of the current Node.
	 * 
	 * @return the current Node's data or null
	 */
	public T getCurrent()
	{
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
	 * Moves the current pointer to the next Node. If the current Node is null,
	 * no action is taken. If the current Node is the tail, current is changed
	 * to the head Node.
	 */
	public void goToNext()
	{
		if (current == null) return;

		if (current == tail) current = head;
		else current = current.next;
	}

	/**
	 * Moves the current pointer to the previous Node. If the current Node is
	 * null, no action is taken. If the current Node is the head, current is
	 * changed to the tail Node.
	 */
	public void goToPrev()
	{
		if (current == null) return;

		if (current == head) current = tail;
		else current = current.prev;
	}

	/**
	 * Checks if the current Node is not the head. Forces do while loop to
	 * traverse.
	 * 
	 * @return true if the current Node is not the head, false otherwise
	 */
	public boolean hasMore()
	{
		return current != head;
	}

	/**
	 * Moves the current pointer to the head.
	 */
	public void reset()
	{
		current = head;
	}

	/**
	 * Inserts given data at the end of the Linked List and updates the size of
	 * the Linked List. If the list is empty, the head, tail, and current
	 * references are updated to the new Node.
	 * 
	 * @param aData
	 *            the data to insert to the list
	 */
	public void add(T aData)
	{
		ListNode newNode = new ListNode(aData, head, tail);

		if (head == null)
		{
			head = tail = current = newNode;
			this.size = 1;
			return;
		}

		tail.next = newNode;
		tail = newNode;
		head.prev = tail;
		this.size++;
	}

	/**
	 * Iterates and removes the first occurrence of a Node which contains given
	 * data and updates the size of the Linked List. If the Node is the head or
	 * tail, the next and previous Nodes are updated accordingly.
	 * 
	 * @param aData
	 *            the Node's data to remove
	 */
	public void remove(T aData)
	{
		ListNode temp = head;

		for (int i = 0; i < this.size; i++)
		{
			if (temp.data == aData)
			{
				if (temp == head)
				{
					head.prev.next = head.next;
					head.next.prev = head.prev;
					head = head.next;
					size--;
					return;
				}
				else if (temp == tail)
				{
					tail.prev.next = head;
					head.prev = tail.prev;
					tail = tail.prev;
					size--;
					return;
				}
				else
				{
					temp.prev.next = temp.next;
					temp.next.prev = temp.prev;
					size--;
					return;
				}
			}

			temp = temp.next;
		}
	}

	/**
	 * Removes the current Node from the Linked List and updates the size of the
	 * Linked List. If the current pointer is at the head or tail, then next and
	 * previous Nodes are updated accordingly. If the current Node is null, no
	 * action is taken.
	 */
	public void removeCurrent()
	{
		if (current == null) return;

		if (current == head)
		{
			tail.next = head.next;
			head.next.prev = tail;
			head = current = head.next;
			this.size--;
		}
		else if (current == tail)
		{
			head.prev = tail.prev;
			tail.prev.next = head;
			tail = current = tail.prev;
			this.size--;
		}
		else
		{
			current.prev.next = current.next;
			current.next.prev = current.prev;
			this.size--;
		}
	}

	/**
	 * Iterates accordingly to the size of the Linked List and prints each
	 * Node's data.
	 */
	public void print()
	{
		ListNode temp = head;

		for (int i = 0; i < this.size; i++)
		{
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	/**
	 * Retrieves the data of a node at a chosen index.
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
			temp = temp.next;

		return temp.data;
	}

}
