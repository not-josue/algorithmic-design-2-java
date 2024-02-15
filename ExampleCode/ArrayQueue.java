/*
 * An example of a Generic Array Queue.
 * Written by: Josue
 */
public class ArrayQueue<T> implements QueueI<T>
{

	// instance variables

	private T[] queue;
	private int headIndex; // first element
	private int tailIndex; // first null element / 1 past the last element

	// constants

	public static final int DEF_SIZE = 100;

	// constructors

	public ArrayQueue()
	{
		init(DEF_SIZE);
	}

	public ArrayQueue(int size)
	{
		init(size);
	}

	/**
	 * Initializes the array Queue by updating the head and tail indices, and by
	 * setting the size of the array Queue to either a given size, if it is at
	 * least one, or to a default value.
	 * 
	 * @param size
	 *            the size of the array
	 */
	private void init(int size)
	{
		headIndex = tailIndex = 0;

		if (size >= 1) queue = (T[]) (new Object[size]);
		else queue = (T[]) (new Object[DEF_SIZE]);
	}

	/**
	 * Adds an element to the end of the array Queue and updates the tail
	 * reference accordingly. If the array Queue is full, no action is taken.
	 */
	public void enqueue(T aData)
	{
		// check if full
		if (queue[headIndex] != null
				&& headIndex == tailIndex)
			return;

		// update queue
		queue[tailIndex] = aData;
		tailIndex = (tailIndex + 1) % queue.length;
	}

	/**
	 * Removes the first element in the array Queue, and updates the head
	 * reference accordingly.
	 * 
	 * @return the element that was removed
	 */
	public T dequeue()
	{
		T ret = queue[headIndex];
		headIndex = (headIndex + 1) % queue.length;
		return ret;
	}

	/**
	 * Checks the first element in the array Queue.
	 * 
	 * @return the first element
	 */
	public T peek()
	{
		return queue[headIndex];
	}

	/**
	 * Prints all values of the array Queue by printing the first element, then
	 * iterating and printing the rest of the elements.
	 */
	public void print()
	{
		System.out.println(queue[headIndex]);
		for (int i = (headIndex + 1)
				% queue.length; i != tailIndex; i = (i + 1)
						% queue.length)
			System.out.println(queue[i]);
	}

}
