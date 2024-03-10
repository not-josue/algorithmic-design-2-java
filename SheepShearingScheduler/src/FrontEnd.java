/*
 * A program that prompts the user for a file, and creates a schedule based on if the 
 * Sheep has arrived, and the shearing time of the Sheep.
 * Written By: Josue
 */
import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class FrontEnd
{
	// constants

	public static final String DELIM = "\t";
	public static final int BODY_AMOUNT = 3;

	// variables

	public static Sheep[] sheep;
	public static Scanner keyboard = new Scanner(System.in);
	public static SheepScheduler heap = new SheepScheduler();

	public static void main(String[] args)
	{
		FrontEndPrinter.printGreeting();

		while (true)
		{
			FrontEndPrinter.printOperations();
			int input = tryInt();

			switch (input)
			{
				case 1 :
					setSheep();
					break;
				case 2 :
					quit();
					break;
				default :
					System.out.println(
							"Invalid input, please try again...");
			}

		}

	}

	/**
	 * Checks if a Sheep's given arrival time is equal to the given minutes
	 * passed.
	 * 
	 * @param arrival
	 *            the time the Sheep arrives
	 * @param minutesPassed
	 *            the minutes passed
	 * @return true if the Sheep's arrival time is equal to the minutes passed,
	 *         false otherwise
	 */
	static boolean hasArrived(int arrival,
			int minutesPassed)
	{
		return arrival == minutesPassed;
	}

	/**
	 * Reads a given file, and counts all lines that are properly formatted.
	 * 
	 * @param filename
	 *            the name of the file to read
	 * @return the amount of lines formatted correctly
	 */
	static int numberOfSheep(String filename)
	{
		int count = 0; // return variable

		try (Scanner filereader = new Scanner(
				new File(filename)))
		{
			while (filereader.hasNextLine())
			{
				// parse line
				String fileline = filereader.nextLine();
				// split line
				String[] split = fileline.split(DELIM);

				// check format
				if (split.length == BODY_AMOUNT)
				{
					// check integer format
					if (isInt(split[1]) && isInt(split[2]))
						count++;
					else
						continue;
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return count;
	}

	/**
	 * Reads a given file twice, once to initiate the Sheep array with the
	 * amount of correctly formatted lines, and the other to fill the Sheep
	 * array. If more than 1 Sheep have been added to the Sheep array, the array
	 * is sorted by calling a quick sort method. If at least 1 Sheep has been
	 * added to the Sheep array, a schedule is created by calling a method.
	 * 
	 * @param filename
	 *            the name of the file to read
	 */
	static void addFile(String filename)
	{
		File file = new File(filename);

		if (!file.exists())
		{
			System.out.println("Sorry " + filename
					+ " was not found...");
			return;
		}
		else
		{
			try (Scanner filereader = new Scanner(file))
			{
				// initiate array with correct count
				sheep = new Sheep[numberOfSheep(filename)];
				int index = 0; // for adding to array

				while (filereader.hasNextLine())
				{
					// parse line
					String fileline = filereader.nextLine();
					// split line
					String[] split = fileline.split(DELIM);

					// check format
					if (split.length == BODY_AMOUNT)
					{
						// check integer format
						if (isInt(split[1])
								&& isInt(split[2]))
						{
							Sheep aSheep = new Sheep(
									split[0],
									Integer.valueOf(
											split[1]),
									Integer.valueOf(
											split[2]));

							sheep[index] = aSheep;
							index++;
						}
						else continue;
					}
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		// quicksort
		if (sheep.length > 1) quickSort(sheep);

		// create schedule
		if (sheep.length >= 1) createSchedule();
	}

	/**
	 * Checks if a given String can be converted to an Integer.
	 * 
	 * @param aValue
	 *            the String to try and convert
	 * @return true if the String can be converted to an Integer, false
	 *         otherwise
	 */
	static boolean isInt(String aValue)
	{
		try
		{
			Integer.valueOf(aValue);
			return true;
		}
		catch (NumberFormatException e)
		{
			return false;
		}
	}

	/**
	 * Sorts a given Sheep array in ascending order by using the QuickSort
	 * algorithm. Time Complexities: Worst = O(n^2) Average = O(n log(n))
	 * 
	 * @param array
	 *            a Sheep array
	 */
	static void quickSort(Sheep[] array)
	{
		quickSort(array, 0, array.length - 1);
	}

	/**
	 * Sorts an array of Sheep in ascending order using the QuickSort algorithm.
	 * Works by partitioning the array around a pivot element, then recursively
	 * sorting the sub arrays to the left and right of the pivot.
	 * 
	 * @param array
	 *            the array of Sheep to be sorted
	 * @param startIndex
	 *            the index of the first element of the sub array to be sorted
	 * @param endIndex
	 *            the index of the last element of the sub array to be sorted
	 */
	static void quickSort(Sheep[] array, int startIndex,
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
	 * Partitions an array of Sheep based on a pivot element. This method
	 * selects the last element of the array as the pivot element and rearranges
	 * the elements in such a way that elements smaller than the pivot are moved
	 * to its left, and elements greater than or equal to the pivot are moved to
	 * its right.
	 * 
	 * @param array
	 *            the array of Sheep to be partitioned
	 * @param startIndex
	 *            the index of the first element of the sub array to be
	 *            partitioned
	 * @param endIndex
	 *            the index of the last element of the sub array to be
	 *            partitioned
	 * @return the index of the pivot element after partitioning
	 */
	static int partition(Sheep[] array, int startIndex,
			int endIndex)
	{
		// select the last element as the pivot
		Sheep pivot = array[endIndex];
		int i = startIndex;

		// iterate and move elements smaller than the pivot to the left
		for (int j = startIndex; j <= endIndex; j++)
		{
			if (array[j].getArrivalTime() < pivot
					.getArrivalTime())
			{
				swap(array, i, j);
				i++;
			}
			// compare name if arrival times are the equal
			else
				if (array[j].getArrivalTime() == pivot
						.getArrivalTime())
			{
				if (array[j].getName()
						.compareTo(pivot.getName()) < 0)
				{
					swap(array, i, j);
					i++;
				}
			}
		}

		// swap the pivot element with the element at index i
		swap(array, i, endIndex);
		return i; // where the pivot is
	}

	/**
	 * Swaps an element of a given index, with another element of a given index
	 * in a given Sheep array.
	 * 
	 * @param array
	 *            the array which contains the elements to swap
	 * @param firstIndex
	 *            the index of the first element
	 * @param secondIndex
	 *            the index of the second element
	 */
	static void swap(Sheep[] array, int firstIndex,
			int secondIndex)
	{
		Sheep temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = temp;
	}

	/**
	 * Prompts for user input until an Integer is entered.
	 * 
	 * @return an Integer entered by the user
	 */
	static int tryInt()
	{
		while (true)
		{
			try
			{
				int input = keyboard.nextInt();
				keyboard.nextLine(); // fix-up
				return input;
			}
			catch (InputMismatchException e)
			{
				keyboard.nextLine(); // fix-up
				System.out.println(
						"Invalid input... try again!!!");
			}
		}
	}

	/**
	 * Prompts the user for a file name, and calls a method to read the file.
	 */
	static void setSheep()
	{
		System.out.println(
				"Enter the name of the Sheep file (include the file extension):");
		String filename = keyboard.nextLine();
		addFile(filename);
	}

	/**
	 * Uses a heap, and a sorted Sheep array to create a schedule based off
	 * arrival times, and shearing time.
	 */
	static void createSchedule()
	{
		System.out.println(
				"\n----------Start of Schedule----------\n");

		int minute = 0;
		int currOrder = 0;

		while (true)
		{
			// iterate the array as duplicate arrival times may occur
			for (int i = currOrder; i < sheep.length; i++)
			{
				// compare arrival time vs minutes passed
				if (hasArrived(sheep[i].getArrivalTime(),
						minute))
				{
					heap.addSheep(sheep[i]);
					// update current order
					currOrder++;
				}
			}

			// check if all sheep have been sheared
			if (heap.isDone()) break;

			// update shearing time left, and mintues passed
			heap.advanceOneMinute();
			minute++;
		}

		System.out.println(
				"\n---------End of Schedule---------");
	}

	/**
	 * Prints a message, closes the Scanner, and exits the program.
	 */
	static void quit()
	{
		System.out.println("Goodbye!!!");
		keyboard.close();
		System.exit(BODY_AMOUNT);
	}
}
