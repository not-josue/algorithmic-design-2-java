/*
 * A class that defines a Singly Linked List of type GroceryItem
 * Written By: Josue
 */
public class GroceryList
{
	// internal class
	private class ListNode
	{
		// attributes

		GroceryItem data;
		ListNode link;

		// constructors

		public ListNode()
		{
			data = null;
			link = null;
		}

		public ListNode(GroceryItem item, ListNode aLink)
		{
			data = item;
			link = aLink;
		}
	}

	// attributes

	ListNode head;
	ListNode current;
	ListNode previous;

	// constructor

	public GroceryList()
	{
		head = current = previous = null;
	}

	// methods

	/**
	 * Moves the current pointer to the next Node. If the current Node is null,
	 * no action is taken.
	 */
	public void gotoNext()
	{
		if (current == null) return;

		previous = current;
		current = current.link;
	}

	/**
	 * Returns the data of current Node. If the current Node is null, no action
	 * is taken.
	 * 
	 * @return the data of the current Node, null if the current Node is null
	 */
	public GroceryItem getCurrent()
	{
		if (current == null) return null;

		return current.data;
	}

	/**
	 * Changes the data of the current Node. If the current Node is null, or the
	 * given Node is null, no action is taken.
	 * 
	 * @param item
	 *            the data to change the current Node to
	 */
	public void setCurrent(GroceryItem item)
	{
		if (current == null || item == null) return;

		current.data = item;
	}

	/**
	 * Adds a Node to the end of the Linked List. If the head reference is null,
	 * signaling an empty Linked List, the head and current references are
	 * updated accordingly. If the given Node is null, no action is taken.
	 * 
	 * @param item
	 *            the Node to add to the Linked List
	 */
	public void addItem(GroceryItem item)
	{
		if (item == null) return;

		// create a new Node
		ListNode newNode = new ListNode(item, null);

		// check if the list is empty
		if (head == null)
		{
			head = current = newNode;
			return;
		}

		// initialize a temp Node to iterate
		ListNode temp = head;

		// iterate
		while (temp.link != null)
			temp = temp.link;

		// update last node
		temp.link = newNode;
	}

	/**
	 * Adds a Node next to the current pointer. If the head is null, signaling
	 * an empty Linked List, no action is taken. If the given Node is null, no
	 * action is taken.
	 * 
	 * @param item
	 *            the Node to add to the Linked List
	 */
	public void addItemAfterCurrent(GroceryItem item)
	{
		// check for empty list
		if (head == null || item == null) return;

		// create a new Node
		ListNode newNode = new ListNode(item, current.link);

		// link current to the new Node
		current.link = newNode;
	}

	/**
	 * Removes the Node where the current pointer is. If the current pointer is
	 * at the head, the head reference is updated accordingly.
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
	}

	/**
	 * Traverses the Linked List and prints every Node that is not null.
	 */
	public void showList()
	{
		// initialize a temp Node to iterate
		ListNode temp = head;

		// iterate
		while (temp != null)
		{
			System.out.println(temp.data);
			temp = temp.link;
		}
	}

	/**
	 * Checks for an occurrence of a given Node in the Linked List.
	 * 
	 * @param item
	 *            the Node to search for in the Linked List
	 * @return true if an occurrence of a Node is found in the Linked List,
	 *         false otherwise
	 */
	public boolean contains(GroceryItem item)
	{
		// empty list
		if (head == null) return false;

		// initialize a temp Node to iterate
		ListNode temp = head;

		// iterate and check
		while (temp != null)
		{
			if (temp.data.equals(item)) return true;

			temp = temp.link;
		}

		return false;
	}

	/**
	 * Calculates the sum of all Nodes in the Linked List.
	 * 
	 * @return the sum of all the Nodes in the Linked List, 0 if the Linked List
	 *         is empty
	 */
	public double totalCost()
	{
		// empty list
		if (head == null) return 0;

		// initialize a sum variable
		double sum = 0;

		// initialize a temp Node to iterate
		ListNode temp = head;

		// iterate and update sum
		while (temp != null)
		{
			sum += temp.data.getValue();
			temp = temp.link;
		}

		return sum;
	}

}
