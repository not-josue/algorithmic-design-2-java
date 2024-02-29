/*
 * An example of a Generic Min Heap.
 * Written By: Josue
 */
public class MinHeap<T extends Comparable<T>>
{
	// attributes

	private T[] heap;
	private int lastIndex; // first null element

	public static final int DEF_SIZE = 128;

	// constructors

	public MinHeap()
	{
		init(DEF_SIZE);
	}

	public MinHeap(int size)
	{
		init(size);
	}

	/**
	 * Initializes the array to a given size if it is greater than 0, or a
	 * default size otherwise.
	 * 
	 * @param size
	 *            the size of the array
	 */
	public void init(int size)
	{
		if (size > 0)
		{
			heap = (T[]) (new Comparable[size]);
			lastIndex = 0;
		}
		else init(DEF_SIZE);
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
		// check if array is full
		if (lastIndex >= heap.length) return;
		heap[lastIndex] = aData;
		bubbleUp();
		lastIndex++;
	}

	/**
	 * Compares an inserted value with its new parent and swaps them if the
	 * inserted value is less than its parent to maintain Heap integrity. If the
	 * value is at the root no action is taken.
	 */
	private void bubbleUp()
	{
		int index = lastIndex; // where data was added

		while (index > 0 && heap[(index - 1) / 2]
				.compareTo(heap[index]) > 0)
		{
			// swap
			T temp = heap[(index - 1) / 2];
			heap[(index - 1) / 2] = heap[index];
			heap[index] = temp;
			// update parent
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
		// empty array
		if (lastIndex == 0) return null;

		T ret = heap[0]; // remove from root
		heap[0] = heap[lastIndex - 1];
		heap[lastIndex - 1] = null;
		lastIndex--;
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
		int index = 0;

		// iterate until the bound of the array
		while (index * 2 + 1 < lastIndex)
		{
			// assume the left child is the smallest
			int smallIndex = index * 2 + 1;

			// check if right child exists and is the smallest
			if (index * 2 + 2 < lastIndex
					&& heap[index * 2 + 1].compareTo(
							heap[index * 2 + 2]) > 0)
				smallIndex = index * 2 + 2;

			// check if parent is greater than smallest child
			if (heap[index].compareTo(heap[smallIndex]) > 0)
			{
				// swap
				T temp = heap[index];
				heap[index] = heap[smallIndex];
				heap[smallIndex] = temp;
			}
			// parent is smaller
			else break;

			// update next index to check
			index = smallIndex;
		}
	}

	/**
	 * Utilizes a breadth first approach to print all values in the array.
	 */
	public void print()
	{
		for (T value : heap)
		{
			if (value == null) break;
			System.out.println(value);
		}
	}

	/**
	 * Iterates and adds all elements in the given array to an instance of a Min
	 * Heap, then iterates and removes all elements from the Min Heap into the
	 * given array. If the given array is null, no action is taken.
	 * 
	 * @param array
	 *            the array to sort
	 */
	public void heapSort(T[] array)
	{
		// empty array
		if (array == null) return;

		// create an instance of a Min Heap
		MinHeap<T> mHeap = new MinHeap<T>(array.length);

		for (int i = 0; i < array.length; i++)
			mHeap.add(array[i]);

		for (int i = 0; i < array.length; i++)
			array[i] = mHeap.remove();
	}
}
