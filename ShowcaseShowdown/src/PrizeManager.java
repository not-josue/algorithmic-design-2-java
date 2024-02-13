/*
 * A class that defines a Prize array
 * Written By: Josue
 */
import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;
public class PrizeManager
{
	// variables and constants

	private Prize[] prizes;

	public static final int DEF_SIZE = 100;
	public static final String DELIM = "\t";
	public static final int BODY_FIELD_AMT = 2;

	// constructors

	public PrizeManager()
	{
		init(DEF_SIZE);
	}

	public PrizeManager(int size)
	{
		init(size);
	}

	// other methods

	/**
	 * Initializes the size of an array to the given Integer. If the given
	 * Integer is less than 1, the size of the array is initialized to the
	 * default size.
	 * 
	 * @param size
	 *            the size of the array
	 */
	private void init(int size)
	{
		if (size >= 1) prizes = new Prize[size];
		else prizes = new Prize[DEF_SIZE];
	}

	/**
	 * Adds a Prize to the end of the array. If the array is full, no action is
	 * taken.
	 * 
	 * @param aPrize
	 *            the object to add to the array
	 */
	public void addPrize(Prize aPrize)
	{
		// check to see if the array is full
		if (prizes[prizes.length - 1] != null) return;

		// iterate
		for (int i = 0; i < prizes.length; i++)
		{
			// find the first null element, then break the loop
			if (prizes[i] == null)
			{
				prizes[i] = aPrize;
				break;
			}
		}
	}

	/**
	 * Reads the content of a given file and calculates how many lines are
	 * correctly formatted.
	 * 
	 * @param aName
	 *            the name of the file to read
	 * @return the amount of lines in the file that are correctly formatted
	 */
	public int setArraySize(String aName)
	{
		// initialize a return variable
		int size = 0;

		try
		{
			// read file
			Scanner fileScanner = new Scanner(
					new File(aName));

			// read body
			while (fileScanner.hasNextLine())
			{
				// initialize a String to read each line
				String fileLine = fileScanner.nextLine();
				// initialize a temp array to check formatting
				String[] splitLines = fileLine.split(DELIM);

				// check for correct formatting and update size
				if (splitLines.length == BODY_FIELD_AMT)
					size++;
			}
			// close the stream
			fileScanner.close();
			return size;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return size;
		}
	}

	/**
	 * Checks if a given String can be parsed into a Double.
	 * 
	 * @param input
	 *            a String to test
	 * @return true if the given String can be parsed into a Double, false
	 *         otherwise
	 */
	private boolean isDouble(String input)
	{
		try
		{
			double aDouble = Double.parseDouble(input);
			return true;
		}
		catch (InputMismatchException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Reads the content of a given file and adds correctly formatted lines to
	 * an array.
	 * 
	 * @param aName
	 *            the name of the file to read
	 */
	public void readPrizeFile(String aName)
	{
		// set the size of the array
		int size = this.setArraySize(aName);

		// handle a document that is not found or completely unformatted
		if (size == 0) return;
		else init(size);

		try
		{
			// read file
			Scanner fileScanner = new Scanner(
					new File(aName));

			// read body
			while (fileScanner.hasNextLine())
			{
				// initialize a String to read each line
				String fileLine = fileScanner.nextLine();
				// initialize a temp array to check formatting
				String[] splitLines = fileLine.split(DELIM);

				// check for proper formatting
				if (splitLines.length == BODY_FIELD_AMT)
				{
					String name = splitLines[0];
					// check if the second value is actually an integer, assign
					// an arbitrary value if not
					double price = (isDouble(splitLines[1]))
							? Double.parseDouble(
									splitLines[1])
							: 0;

					// check if price is a double
					if (price >= 1)
					{
						// create a Prize object, and add to the array
						Prize aPrize = new Prize(name,
								price);
						this.addPrize(aPrize);
					}
				}
			}
			// close the stream
			fileScanner.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Prints the name of a Prize at a given index in the array.
	 * 
	 * @param index
	 *            the index of the Prize whose name is to be printed
	 */
	public void printName(int index)
	{
		// check for out of bounds index
		if (index < 0 || index > this.prizes.length - 1)
			return;
		else
			System.out
					.println(this.prizes[index].getName());
	}

	/**
	 * Prints the Prize at a given index in the array.
	 * 
	 * @param index
	 *            the index of the Prize to be printed
	 */
	public void printIndex(int index)
	{
		if (index < 0 || index > this.prizes.length - 1)
			return;
		else
			System.out.println(this.prizes[index]);
	}

	/**
	 * Retrieves the price of a Prize at a given index in the array.
	 * 
	 * @param index
	 *            the index of the Prize whose price is to be retrieved
	 * @return the price of the Prize at a given index, or 0 if the given index
	 *         is out of bounds
	 */
	public double getPrice(int index)
	{
		// check for out of bounds index
		if (index < 0 || index > this.prizes.length - 1)
			return 0;
		else
			return this.prizes[index].getPrice();
	}

}
