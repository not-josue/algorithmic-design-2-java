/*
 * An example of a Generic Linked List Stack.
 * Written By: Josue
 */
public class LLStack<T> implements StackI<T>
{
	// private internal class

	private class Node
	{
		T data;
		Node link;

		public Node(T aData, Node aLink)
		{
			data = aData;
			link = aLink;
		}
	}

	// reference

	private Node head;

	// constructor

	public LLStack()
	{
		head = null;
	}

	/**
	 * Adds a Node to the front of the Stack.
	 */
	public void push(T aData)
	{
		Node newNode = new Node(aData, head);
		head = newNode;
	}

	/**
	 * Removes the head Node in the Stack, and retrieves its data.
	 * 
	 * @return the head Node's data, or null if the head Node is null
	 */
	public T pop()
	{
		// empty list
		if (head == null) return null;
		T ret = head.data;
		head = head.link;
		return ret;
	}

	/**
	 * Retrieves the head Node's data
	 * 
	 * @return the head Node's data, or null if the head Node is null
	 */
	public T peek()
	{
		// empty list
		if (head == null) return null;
		return head.data;
	}

	/**
	 * Iterates and prints each element in the Stack.
	 */
	public void print()
	{
		for (Node temp = head; temp != null; temp = temp.link)
			System.out.println(temp.data);
	}
}
