/*
 * A program that prompts the user until "quit" is entered, then prints all Strings by 
 * the times the word sort occurs.
 * Written By: Josue
 */
import java.util.Scanner;
public class Program
{
	// constants

	public static final String TARGET_WORD = "sort";

	// variables

	public static GenLL<String> words;
	public static int[] counter;
	public static String[] sortedWords;
	public static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args)
	{
		boolean runProgram = true;

		while (runProgram)
		{
			promptToUser();
			getInput();
			initArrays();
			sortWordArray();
			printArray(sortedWords);
			quitProgram();
		}
	}

	/**
	 * Prompts instructions to the user about how the program works.
	 */
	static void promptToUser()
	{
		System.out.println(
				"Enter any number of strings and I will sort by SORT’s. "
						+ "\nOnce you’re done entering sentences enter “quit”.");
	}

	/**
	 * Adds user input to the Generic Linked List if it is not "quit".
	 */
	static void getInput()
	{
		// initialize the Generic Linked List
		words = new GenLL<String>();

		boolean quit = false;

		while (!quit)
		{
			String word = keyboard.nextLine();

			if (word.equalsIgnoreCase("quit")) break;
			else words.add(word);
		}
	}

	/**
	 * Initializes the integer and String arrays.
	 */
	static void initArrays()
	{
		initCounterArray();
		initWordArray();
	}

	/**
	 * Initializes the counter array which represents the number of times the
	 * word "sort" appeared in each String.
	 */
	static void initCounterArray()
	{
		// initialize the counter array
		counter = new int[words.getSize()];

		for (int i = 0; i < words.getSize(); i++)
		{
			counter[i] = countSort(words.getAt(i));
		}
	}

	/**
	 * Computes the number of times the word "sort" appeared in the given
	 * String.
	 * 
	 * @param aWord
	 *            the String to check
	 * @return a count of how many times the word "sort" appeared
	 */
	static int countSort(String aWord)
	{
		String lowercase = aWord.toLowerCase();
		int counter = 0;

		// check if the target word occurs at least 1 time
		int index = lowercase.indexOf(TARGET_WORD);

		while (index != -1)
		{
			counter++;
			index = lowercase.indexOf(TARGET_WORD,
					index + TARGET_WORD.length());
		}

		return counter;
	}

	/**
	 * Initializes the words array by filling it with all Strings in the Generic
	 * Linked List.
	 */
	static void initWordArray()
	{
		// initialize the words array
		sortedWords = new String[words.getSize()];

		for (int i = 0; i < words.getSize(); i++)
			sortedWords[i] = words.getAt(i);
	}

	/**
	 * Sorts the words array alongside the counter array by using the QuickSort
	 * algorithm.
	 */
	static void sortWordArray()
	{
		quickSort(counter, sortedWords, 0,
				counter.length - 1);
	}

	/**
	 * Sorts an integer, and String array by using the QuickSort algorithm.
	 * 
	 * @param array
	 *            the integer array which represents the count of each String
	 * @param strArray
	 *            the String array which represents the Strings entered by the
	 *            user
	 */
	static void quickSort(int[] array, String[] strArray)
	{
		quickSort(array, strArray, 0, array.length - 1);
	}

	/**
	 * Sorts an array of integers and a corresponding array of strings using the
	 * QuickSort algorithm. Works by partitioning the array around a pivot
	 * element, then recursively sorting the sub arrays to the left and right of
	 * the pivot.
	 * 
	 * @param array
	 *            the array of integers to be sorted
	 * @param strArray
	 *            the array of Strings to be sorted
	 * @param startIndex
	 *            the index of the first element of the sub array to be sorted
	 * @param endIndex
	 *            the index of the last element of the sub array to be sorted
	 */
	static void quickSort(int[] array, String[] strArray,
			int startIndex, int endIndex)
	{
		// check if array is sorted
		if (startIndex >= endIndex) return;

		// get the pivot element's index
		int pivot = partition(array, strArray, startIndex,
				endIndex);

		quickSort(array, strArray, startIndex, pivot - 1); // left
		quickSort(array, strArray, pivot + 1, endIndex); // right
	}

	/**
	 * Partitions an array of integers and a corresponding array of strings
	 * based on a pivot element. This method selects the last element of the
	 * array as the pivot element and rearranges the elements in such a way that
	 * elements smaller than the pivot are moved to its left, and elements
	 * greater than or equal to the pivot are moved to its right.
	 * 
	 * @param array
	 *            the array of integers to be partitioned
	 * @param strArray
	 *            the corresponding array of Strings to be partitioned alongside
	 *            the array of integers
	 * @param startIndex
	 *            the index of the first element of the subarray to be
	 *            partitioned
	 * @param endIndex
	 *            the index of the last element of the subarray to be
	 *            partitioned
	 * @return the index of the pivot element after partitioning
	 */
	static int partition(int[] array, String[] strArray,
			int startIndex, int endIndex)
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
				swap(strArray, i, j);
				i++;
			}
		}

		// swap the pivot element with the element at index i
		swap(array, i, endIndex);
		swap(strArray, i, endIndex);
		return i; // where the pivot is
	}

	/**
	 * Swaps an 2 elements of a given integer array.
	 * 
	 * @param array
	 *            an integer array
	 * @param firstIndex
	 *            the first index of the element to swap
	 * @param secondIndex
	 *            the second index of the element to swap
	 */
	static void swap(int[] array, int firstIndex,
			int secondIndex)
	{
		int temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = temp;
	}

	/**
	 * Swaps an 2 elements of a given String array.
	 * 
	 * @param array
	 *            a String array
	 * @param firstIndex
	 *            the first index of the element to swap
	 * @param secondIndex
	 *            the second index of the element to swap
	 */
	static void swap(String[] array, int firstIndex,
			int secondIndex)
	{
		String temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = temp;
	}

	/**
	 * Iterates and prints each String from a given String array.
	 * 
	 * @param array
	 *            the String array to print
	 */
	static void printArray(String[] array)
	{
		System.out.println("\nsort SORTED!\n");
		for (String word : array)
			System.out.println(word);
		System.out.println();
	}

	/**
	 * Prompts the user to see if they would like to quit the program.
	 */
	static void quitProgram()
	{
		System.out.println(
				"Would you like to sort more Strings?"
						+ "\nEnter \"no\" to quit");
		String input = keyboard.nextLine();

		if (input.equalsIgnoreCase("no"))
		{
			System.out.println("\nGoodbye!");
			keyboard.close();
			System.exit(0);
		}
		else
		{
			System.out.println(); // esthetics
		}
	}

}
