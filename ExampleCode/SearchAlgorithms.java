/*
 * Examples of different searching algorithms.
 * Written By: Josue
 */
public class SearchAlgorithms
{

	public static void main(String[] args)
	{
		int[] array = {5, 6, 7, 8, 9, 10, 11, 12};

		// boolean result = linearSearch(array, 11);
		boolean result = binarySearch(array, 11, 0,
				array.length - 1);

		System.out.println(result);
	}

	/**
	 * Determines if there is an occurrence of a given integer in a given
	 * integer array by linearly iterating each element of the given integer
	 * array. Does not require the given integer array to be sorted.
	 * 
	 * @param array
	 *            the array to iterate
	 * @param target
	 *            the element to compare
	 * @return true if an instance if found, false otherwise
	 */
	static boolean linearSearch(int[] array, int target)
	{
		for (int value : array)
		{
			if (value == target) return true;
		}

		return false;
	}

	/**
	 * Determines if there is an occurrence of a given integer in a given
	 * integer array by comparing a midpoint to the given target, and
	 * recursively halving the integer array. Requires the given array to be
	 * sorted.
	 * 
	 * @param array
	 *            the integer array to search
	 * @param target
	 *            the integer to compare
	 * @param startIndex
	 *            the starting index
	 * @param endIndex
	 *            the ending index
	 * @return
	 */
	static boolean binarySearch(int[] array, int target,
			int startIndex, int endIndex)
	{
		if (startIndex > endIndex) return false;

		// calculate the midpoint
		int mid = (startIndex + endIndex) / 2;

		if (array[mid] == target) return true;
		// check to the left of the midpoint
		else
			if (array[mid] > target)
				return binarySearch(array, target, 0,
						mid - 1);
			// check to the right of the midpoint
			else
				return binarySearch(array, target, mid + 1,
						endIndex);
	}

}
