/*
 * A class that defines a Doubly Linked List of type Double
 */
public class DoubleDoubleLL<Double>
{
	// internal class

	private class Node
	{
		double data;
		Node prev;
		Node next;

		public Node(double aData, Node aPrev, Node aNext)
		{
			data = aData;
			prev = aPrev;
			next = aNext;
		}
	}

	// references

	Node head;
	Node tail;
	Node current;
	int size;

	// constructor

	public DoubleDoubleLL()
	{
		head = tail = current = null;
		size = 0;
	}

	// methods

	/**
	 * Moves the current pointer to the next Node. If the current pointer is
	 * null, no action is taken.
	 */
	public void gotoNext()
	{
		if (current == null) return;
		current = current.next;
	}

	/**
	 * Moves the current pointer to the previous Node. If the current pointer is
	 * null or at the head reference, no action is taken.
	 */
	public void gotoPrev()
	{
		if (current == null || current == head) return;
		current = current.prev;
	}

	/**
	 * Moves the current pointer to the head reference, which is the start of
	 * the Linked List.
	 */
	public void reset()
	{
		current = head;
	}

	/**
	 * Moves the current pointer to the tail reference, which is the end of the
	 * Linked List.
	 */
	public void gotoEnd()
	{
		current = tail;
	}

	/**
	 * Checks if there are more Nodes to traverse in the Linked List.
	 * 
	 * @return true if there are more Nodes to traverse, false otherwise
	 */
	public boolean hasMore()
	{
		return current != null;
	}

	/**
	 * Retrieves the current Node's data.
	 * 
	 * @return the current Node's data, or NaN if the current Node is null
	 */
	public double getCurrent()
	{
		if (current == null) return java.lang.Double.NaN;

		return current.data;
	}

	/**
	 * Changes the data of the current Node. If the current Node is null, no
	 * action is taken.
	 * 
	 * @param aData
	 *            the value to set as the data of the current Node
	 */
	public void setCurrent(double aData)
	{
		if (current == null) return;

		current.data = aData;
	}

	/**
	 * Adds a Node to the end of the Linked List. If the head is null, signaling
	 * an empty Linked List, references to head, current, and tail are updated
	 * accordingly. Size is incremented after addition.
	 * 
	 * @param aData
	 *            the data to be added to the Linked List
	 */
	public void add(double aData)
	{
		Node newNode = new Node(aData, tail, null);

		// check for empty list
		if (head == null)
		{
			head = current = tail = newNode;
			this.size = 1;
			return;
		}

		tail.next = newNode;
		tail = newNode;
		this.size++;
	}

	/**
	 * Adds a Node after where the current pointer is. Size is updated after
	 * addition. If the current Node is null, no action is taken.
	 * 
	 * @param aData
	 *            the data to be added to the Linked List
	 */
	public void addAfterCurrent(double aData)
	{
		if (current == null) return;

		Node newNode = new Node(aData, current,
				current.next);

		current.next.prev = newNode;
		current.next = newNode;
		size++;
	}

	/**
	 * Removes the first occurrence of the given data in the Linked List. If the
	 * given data is not found, no action is taken.
	 * 
	 * @param aData
	 *            the data to be removed from the Linked List
	 */
	public void remove(double aData)
	{
		Node temp = head;

		while (temp.next != null)
		{
			if (temp.data == aData)
			{
				temp.prev.next = temp.next;
				temp.next.prev = temp.prev;
				size--;
				return;
			}

			temp = temp.next;
		}
	}

	/**
	 * Removes current Node in the Linked List if it is not null. If the current
	 * Node is the head or the tail, the references are updated accordingly. The
	 * size of the Linked List is decremented after removal.
	 */
	public void removeCurrent()
	{
		if (current == null) return;

		// check if current is at head
		if (current == head)
		{
			head = current = current.next;
			head.prev = null;
			this.size--;
			return;
		}

		// check if current is at tail
		if (current == tail)
		{
			tail = current = current.prev;
			tail.next = null;
			this.size--;
			return;
		}

		current.prev.next = current.next;
		current.next.prev = current.prev;
		this.size--;
	}

	/**
	 * Prints all elements in the Linked List that are not null in their current
	 * order.
	 */
	public void print()
	{
		Node temp = head;

		while (temp != null)
		{
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	/**
	 * Checks if the Linked List contains given data.
	 * 
	 * @param aData
	 *            the data to search for in the Linked List
	 * @return true if an occurrence of the given data is found, false otherwise
	 */
	public boolean contains(double aData)
	{
		Node temp = head;

		while (temp != null)
		{
			if (temp.data == aData) return true;

			temp = temp.next;
		}

		return false;
	}

}