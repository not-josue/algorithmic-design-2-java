/*
 * An example of a Generic Linked List Queue.
 * Written By: Josue
 */
public class LLQueue<T> implements QueueI<T>
{
	// internal class

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

	// references

	private Node head;
	private Node tail;

	// constructor

	public LLQueue()
	{
		head = tail = null;
	}

	// methods

	/**
	 * Adds a Node to the end of the Queue. If the head Node is null, signaling
	 * an empty list, the head and tail references are updated accordingly.
	 */
	public void enqueue(T aData)
	{
		Node newNode = new Node(aData, null);

		// empty list
		if (head == null)
		{
			head = tail = newNode;
			return;
		}

		tail.link = newNode;
		tail = tail.link;
	}

	/**
	 * Removes the head Node from the Queue and retrieves its data. If the head
	 * Node is null, signaling an empty list, no action is taken.
	 * 
	 * @return the data of the head Node, or null if the head Node is null
	 */
	public T dequeue()
	{
		// empty list
		if (head == null) return null;

		T ret = head.data;
		head = head.link;
		return ret;
	}

	/**
	 * Retrieves the head Nodes data.
	 * 
	 * @return the data of the head Node, or null if the head Node is null
	 */
	public T peek()
	{
		if (head == null) return null;
		return head.data;
	}

	/**
	 * Iterates the Queue and prints all Nodes that are not null.
	 */
	public void print()
	{
		for (Node temp = head; temp != null; temp = temp.link)
			System.out.println(temp.data);
	}

}
