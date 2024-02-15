/*
 * Examples of different sorting algorithms.
 * Written By: Josue
 */
public class SortAlgorithms
{

	public static void main(String[] args)
	{
		int[] array = {7, 8, 5, 4, 35, 2, 11, 9, 22, 1, 12,
				3, 6};

		// selectionSort(array);
		// bubbleSort(array);
		// mergeSort(array);
		quickSort(array);

		printArray(array);
	}

	/**
	 * Sorts a given integer array in ascending order by iterating the array and
	 * comparing one value at an index with every other value remaining in the
	 * given integer array. Time Complexity: O(n^2)
	 * 
	 * @param array
	 *            an integer array to sort
	 */
	static void selectionSort(int[] array)
	{
		for (int i = 0; i < array.length - 1; i++)
		{
			// set the current index as the smallest value's index
			int smallestIndex = i;

			// compare with the remaining values
			for (int j = i + 1; j < array.length; j++)
			{
				if (array[j] < array[smallestIndex])
					smallestIndex = j;
			}
			// swap if the smallest value's index has changed
			if (smallestIndex != i)
				swap(array, i, smallestIndex);
		}
	}

	/**
	 * Sorts a given integer array in ascending order by comparing all elements
	 * with the following element, and swapping them. The array is continuously
	 * iterated until no swaps are made. Time Complexity: O(n^2)
	 * 
	 * @param array
	 *            an integer array to sort
	 */
	static void bubbleSort(int[] array)
	{
		// boolean to iterate and check if any elements have swapped
		boolean hasSwapped = true;
		/*
		 * Since the algorithm finds the highest values first, we can
		 * progressively update the last index to check
		 */
		int endIndex = array.length - 1;

		// iterate until no swaps are made
		while (hasSwapped)
		{
			// update the boolean in case the array is already sorted
			hasSwapped = false;

			for (int i = 0; i < endIndex; i++)
			{
				if (array[i] > array[i + 1])
				{
					swap(array, i, i + 1);
					// update the boolean
					hasSwapped = true;
				}
			}
			// update end index
			endIndex--;
		}
	}

	/**
	 * Sorts a given integer array in ascending order by recursively halving the
	 * array to various sub arrays until single elements remain and then merging
	 * all the sub arrays into a bigger array until a single array is reached.
	 * Time Complexity: O(n log(n))
	 * 
	 * @param array
	 *            an integer array to sort
	 */
	static void mergeSort(int[] array)
	{
		// check if the array has one element
		int size = array.length;
		if (size < 2) return;

		// calculate middle index
		int mid = size / 2;

		// determine sizes of left and right sub arrays
		int leftSize = mid;
		int rightSize = size - mid;

		// create left and right sub arrays
		int[] left = new int[leftSize];
		int[] right = new int[rightSize];

		// populate left sub array
		for (int i = 0; i < mid; i++)
			left[i] = array[i];

		// populate right sub array
		for (int i = mid; i < size; i++)
			right[i - mid] = array[i];

		// recursively create smaller sub arrays
		mergeSort(left);
		mergeSort(right);

		// merge sub arrays
		merge(left, right, array);

	}

	/**
	 * Merges two give smaller arrays into a bigger array in ascending order.
	 * 
	 * @param left
	 *            a sub array
	 * @param right
	 *            a sub array
	 * @param array
	 *            the array to merge into
	 */
	static void merge(int[] left, int[] right, int[] array)
	{
		// sizes of left and right sub arrays
		int leftSize = left.length;
		int rightSize = right.length;

		// pointers for left, right, and merged arrays
		int i = 0; // left array index
		int j = 0; // right array index
		int k = 0; // merged array's index

		// merge elements into the array in sorted order
		while (i < leftSize && j < rightSize)
		{
			// compare elements from left and right sub arrays
			if (left[i] <= right[j])
			{
				array[k] = left[i];
				i++;
				k++;
			}
			else
			{
				array[k] = right[j];
				j++;
				k++;
			}
		}

		// copy remaining elements from left sub array
		while (i < leftSize)
		{
			array[k] = left[i];
			i++;
			k++;
		}

		// copy remaining elements from right sub array
		while (j < rightSize)
		{
			array[k] = right[j];
			j++;
			k++;
		}
	}

	/**
	 * Sorts an integer array in ascending order by using the QuickSort
	 * algorithm. Time Complexities: Worst = O(n^2) Average = O(n log(n))
	 * 
	 * @param array
	 *            an integer array
	 */
	static void quickSort(int[] array)
	{
		quickSort(array, 0, array.length - 1);
	}

	/**
	 * Sorts an array of integers in ascending order using the QuickSort
	 * algorithm. Works by partitioning the array around a pivot element, then
	 * recursively sorting the sub arrays to the left and right of the pivot.
	 * 
	 * @param array
	 *            the array of integers to be sorted
	 * @param startIndex
	 *            the index of the first element of the sub array to be sorted
	 * @param endIndex
	 *            the index of the last element of the sub array to be sorted
	 */
	static void quickSort(int[] array, int startIndex,
			int endIndex)
	{
		// check if array is sorted
		if (startIndex >= endIndex) return;

		// get the pivot element's index
		int pivot = partition(array, startIndex, endIndex);

		quickSort(array, startIndex, pivot - 1); // left
		quickSort(array, pivot + 1, endIndex); // right
	}

	/**
	 * Partitions an array of integers based on a pivot element. This method
	 * selects the last element of the array as the pivot element and rearranges
	 * the elements in such a way that elements smaller than the pivot are moved
	 * to its left, and elements greater than or equal to the pivot are moved to
	 * its right.
	 * 
	 * @param array
	 *            the array of integers to be partitioned
	 * @param startIndex
	 *            the index of the first element of the sub array to be
	 *            partitioned
	 * @param endIndex
	 *            the index of the last element of the sub array to be
	 *            partitioned
	 * @return the index of the pivot element after partitioning
	 */
	static int partition(int[] array, int startIndex,
			int endIndex)
	{
		// select the last element as the pivot
		int pivot = array[endIndex];
		int i = startIndex;

		// iterate and move elements smaller than the pivot to the left
		for (int j = startIndex; j <= endIndex; j++)
		{
			if (array[j] < pivot)
			{
				swap(array, i, j);
				i++;
			}
		}

		// swap the pivot element with the element at index i
		swap(array, i, endIndex);
		return i; // where the pivot is
	}

	/**
	 * Swaps an element of a given index, with another element of a given index
	 * in a given integer array.
	 * 
	 * @param array
	 *            the array which contains the elements to swap
	 * @param firstIndex
	 *            the index of the first element
	 * @param secondIndex
	 *            the index of the second element
	 */
	static void swap(int[] array, int firstIndex,
			int secondIndex)
	{
		int temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = temp;
	}

	/**
	 * Iterates and prints each value of a given integer array.
	 * 
	 * @param array
	 *            an integer array
	 */
	static void printArray(int[] array)
	{
		for (int value : array)
			System.out.println(value);
	}

}
