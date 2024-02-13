/*
 * A class that sorts words by various properties like consonants, vowels, and length
 * Written By: Josue
 */
public class WordHelper
{
	// main sorting methods

	/**
	 * Generates an array of Strings sorted by the amount of vowels each String
	 * contains in ascending order from a given array.
	 * 
	 * @param arr
	 *            an array of Strings to be iterated
	 * @return an array sorted in ascending order by the amount of vowels each
	 *         String contains
	 */
	static String[] sortByVowels(String[] arr)
	{
		// make a copy of the input
		String[] copy = arr.clone();

		// initialize an empty array to store vowel counts
		int[] vowelCounts = new int[copy.length];

		// iterate and update int array
		for (int i = 0; i < copy.length; i++)
		{
			int count = 0;
			for (int j = 0; j < copy[i].length(); j++)
			{
				if (isVowel(arr[i].charAt(j))) count++;
			}
			vowelCounts[i] = count;
		}

		bubbleSort(vowelCounts, copy);

		return copy;
	}

	/**
	 * Generates an array of Strings sorted by the amount of consonants each
	 * String contains in ascending order from a given array.
	 * 
	 * @param arr
	 *            the array to be iterated
	 * @return an array sorted in ascending order by the amount of consonants
	 *         each String contains
	 */
	static String[] sortByConsonants(String[] arr)
	{
		// make a copy of the input
		String[] copy = arr.clone();

		// initialize an empty array to store consonant counts
		int[] consonantCounts = new int[copy.length];

		// iterate and update int array
		for (int i = 0; i < copy.length; i++)
		{
			int count = 0;
			for (int j = 0; j < copy[i].length(); j++)
			{
				if (!isVowel(arr[i].charAt(j))) count++;
			}
			consonantCounts[i] = count;
		}

		bubbleSort(consonantCounts, copy);

		return copy;
	}

	/**
	 * Generates an array Strings sorted in ascending order by the length of
	 * each String from a given array.
	 * 
	 * @param arr
	 *            the array to be iterated
	 * @return an array sorted in ascending order by the length of each String
	 */
	static String[] sortByLength(String[] arr)
	{
		// make a copy of the input
		String[] copy = arr.clone();

		// initialize an empty array to store length counts
		int[] lengthCounts = new int[copy.length];

		// iterate and update int array
		for (int i = 0; i < copy.length; i++)
		{
			lengthCounts[i] = copy[i].length();
		}

		bubbleSort(lengthCounts, copy);

		return copy;
	}

	// auxiliary methods

	/**
	 * Generates a boolean after checking if the given char is a vowel.
	 * 
	 * @param letter
	 *            the char to be compared
	 * @return true if the given char is a vowel, false otherwise
	 */
	private static boolean isVowel(char letter)
	{
		char lowercase = Character.toLowerCase(letter);

		return lowercase == 'a' || lowercase == 'e'
				|| lowercase == 'i' || lowercase == 'o'
				|| lowercase == 'u' || lowercase == 'y';
	}

	/**
	 * Sorts two arrays concurrently using the Bubble Sort algorithm.
	 * 
	 * @param count
	 *            the integer array that contains the numerical value of how the
	 *            String array should be sorted
	 * @param strArray
	 *            the String array to be sorted
	 */
	private static void bubbleSort(int[] count,
			String[] strArray)
	{
		boolean hasSwapped = true;

		while (hasSwapped)
		{
			hasSwapped = false;

			for (int i = 0; i < count.length - 1; i++)
			{
				if (count[i] > count[i + 1])
				{
					// swap String array
					String strTemp = strArray[i];
					strArray[i] = strArray[i + 1];
					strArray[i + 1] = strTemp;
					// swap Integer array
					int temp = count[i];
					count[i] = count[i + 1];
					count[i + 1] = temp;
					// update boolean
					hasSwapped = true;
				}
			}
		}
	}

}
