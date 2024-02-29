/*
 * An example of a Generic Max Heap.
 * Written By: Josue
 */
public class MaxHeap<T extends Comparable<T>>
{
	// attributes

	private T[] heap;
	private int size; // first null element

	public static final int DEF_SIZE = 128;

	// constructors

	public MaxHeap()
	{
		init(DEF_SIZE);
	}

	public MaxHeap(int aSize)
	{
		init(aSize);
	}

	/**
	 * Initializes the array to a given value, and sets the size to 0. If the
	 * given value less than or equal to 0, the array is set to a default value.
	 * 
	 * @param aSize
	 *            the size of the array
	 */
	private void init(int aSize)
	{
		if (aSize <= 0)
		{
			init(DEF_SIZE);
			return;
		}
		heap = (T[]) (new Comparable[aSize]);
		size = 0;
	}

	/**
	 * Adds a value to the end of the array then calls a bubble up method to
	 * compare and swap values with the new insertion. If the array is full, no
	 * action is taken. Size is incremented if successful insertion occurs.
	 * 
	 * @param aData
	 *            the value to add to the array
	 */
	public void add(T aData)
	{
		// check if heap is full
		if (heap[heap.length - 1] != null) return;

		heap[size] = aData;
		bubbleUp();
		size++;
	}

	/**
	 * Compares an inserted value with its new parent and swaps them if the
	 * inserted value is greater than its parent to maintain Heap integrity. If
	 * the value is at the root no action is taken.
	 */
	private void bubbleUp()
	{
		int index = size; // start at the end

		// check that you are not at root, and that the parent value is not
		// greater than child value
		while (index > 0 && heap[(index - 1) / 2]
				.compareTo(heap[index]) < 0)
		{
			// swap
			T temp = heap[(index - 1) / 2]; // parent
			heap[(index - 1) / 2] = heap[index];
			heap[index] = temp;
			// update index to compare with new parent value
			index = (index - 1) / 2;
		}
	}

	/**
	 * Removes the root value and swaps it with the last value in the array.
	 * Decrements size after removal. Calls on a bubble down method to maintain
	 * Heap integrity.
	 * 
	 * @return the root value that is removed
	 */
	public T remove()
	{
		T ret = heap[0]; // removes from the root
		heap[0] = heap[size - 1]; // last element
		heap[size - 1] = null; // remove duplicate
		size--;
		bubbleDown();
		return ret;
	}

	/**
	 * Compares the value starting at the root with child values, and swaps them
	 * accordingly to maintain Heap integrity. Swapping continues (if necessary)
	 * until the bound of the array.
	 */
	private void bubbleDown()
	{
		int index = 0; // start at the root

		// check for left child
		while (index * 2 + 1 < size)
		{
			int bigIndex = index * 2 + 1;

			// check if right child exists and greater than the left
			if (index * 2 + 2 < size && heap[index * 2 + 1]
					.compareTo(heap[index * 2 + 2]) < 0)
				bigIndex = index * 2 + 2;

			// compare with parent value
			if (heap[index].compareTo(heap[bigIndex]) < 0)
			{
				// swap
				T temp = heap[index];
				heap[index] = heap[bigIndex];
				heap[bigIndex] = temp;
			}
			// parent is greater
			else break;

			index = bigIndex;
		}
	}

	/**
	 * Retrieves the first value in the array.
	 * 
	 * @return the first value in the array
	 */
	public T peek()
	{
		return heap[0];
	}

	/**
	 * Utilizes a breadth first approach to print all values in the array.
	 */
	public void print()
	{
		for (int i = 0; i < size; i++)
			System.out.println(heap[i]);
	}
}
