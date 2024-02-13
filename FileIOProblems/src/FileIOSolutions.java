/*
 * A class that defines methods for reading and writing files
 * Written By: Josue
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
public class FileIOSolutions
{
	// constants

	public static final int TUBE_BODY_FORMAT = 3;

	// methods

	/**
	 * Reads content from a given input file, converts verbs to their past tense
	 * forms, writes the modified content to a specified file.
	 * 
	 * @param oldFile
	 *            the name of the file to read the original content
	 * @param newFile
	 *            the name of the file to write the modified content to
	 */
	static void pastTense(String oldFile, String newFile)
	{
		try
		{
			// read file
			Scanner filescanner = new Scanner(
					new File(oldFile));
			// write to file
			PrintWriter filewriter = new PrintWriter(
					new FileOutputStream(newFile));

			// read body
			while (filescanner.hasNextLine())
			{
				// save line
				String fileline = filescanner.nextLine();
				// parse line into words by using a regex
				String[] split = fileline
						.split("[\\s|\\t]");

				// cleanse the split array
				String[] cleanse = cleanseArray(split);

				// iterate, check String, write to new file
				for (int i = 0; i < cleanse.length; i++)
				{
					// print to console
					System.out.println(cleanse[i]);
					// special case for last element
					if (i == cleanse.length - 1)
						filewriter.print(
								containsIs(cleanse[i])
										+ "\n");
					else
						filewriter.print(containsIs(
								cleanse[i] + "\s"));
				}
			}
			// close streams
			filescanner.close();
			filewriter.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Calculates the total volume of tubes by reading a given file.
	 * 
	 * @param file
	 *            the name of the file to be read
	 * @return the total volume of tubes found in a given file
	 */
	static double totalTubeVolume(String file)
	{
		// initialize a sum variable
		double sum = 0;
		try
		{
			// read file
			Scanner filescanner = new Scanner(
					new File(file));

			while (filescanner.hasNextLine())
			{
				// save line
				String fileline = filescanner.nextLine();
				// parse line by tab
				String[] split = fileline.split("\t");

				// check for proper formatting
				if (split.length != TUBE_BODY_FORMAT)
					continue;
				else
				{
					// check if values can be converted to doubles
					if (isDouble(split[1])
							&& isDouble(split[2]))
					{
						// store radius, and height
						double radius = Double
								.parseDouble(split[1]);
						double height = Double
								.parseDouble(split[2]);
						// update sum
						sum += calculateVolume(radius,
								height);
					}
					else continue;

				}
			}
			// close the stream
			filescanner.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return sum;
	}

	// auxiliary methods

	/**
	 * Iterates a String array and converts some words to their past tense form.
	 * 
	 * @param arr
	 *            an array of Strings to be converted
	 * @return an array of Strings after words have been converted
	 */
	private static String[] cleanseArray(String[] arr)
	{
		// initialize a return array
		String[] cleanse = new String[arr.length];

		// iterate, check and store
		for (int i = 0; i < arr.length; i++)
			cleanse[i] = containsIs(arr[i]);

		return cleanse;
	}

	/**
	 * Checks if a given String equals "Is", or "is" and converts it to its past
	 * tense form. Returns the String if it does not equal "Is", or "is".
	 * 
	 * @param word
	 *            the word to be checked and converted to its past tense form
	 * @return "Was" if the word equals "Is", "was" if the word equals "is",
	 *         otherwise the given String
	 */
	private static String containsIs(String word)
	{
		return (word.equals("is"))
				? "was"
				: word.equals("Is") ? "Was" : word;
	}

	/**
	 * Checks if a given String can be parsed into a Double.
	 * 
	 * @param str
	 *            a String to parse
	 * @return true if the given String can be parsed into a Double, false
	 *         otherwise
	 */
	private static boolean isDouble(String str)
	{
		try
		{
			double convert = Double.parseDouble(str);
			return true;
		}
		catch (InputMismatchException e)
		{
			return false;
		}
	}

	/**
	 * Squares a given Double.
	 * 
	 * @param x
	 *            a Double to be multiplied by itself
	 * @return the product of a given Double after it is multiplied by itself
	 */
	private static double square(double x)
	{
		return x * x;
	}

	/**
	 * Calculates the volume of a tube given its radius and height.
	 * 
	 * @param radius
	 *            the radius of a tube
	 * @param height
	 *            the height of a tube
	 * @return the volume of the tube
	 */
	private static double calculateVolume(double radius,
			double height)
	{
		return square(radius) * Math.PI * height;
	}

}
