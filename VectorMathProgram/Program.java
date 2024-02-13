/*
 * A program that creates, adds, subtracts, and finds the magnitude of two vectors.
 * Written By: Josue
 */
import java.util.InputMismatchException;
import java.util.Scanner;
public class Program
{
	// constants

	public static final Scanner sc = new Scanner(System.in);

	public static final String BORDER = "=";
	public static final int BORDER_LENGTH = 42;

	public static void main(String[] args)
	{
		renderGreeting();

		// initialize boolean to start a while loop
		boolean quit = false;

		// iterate until the user decides to quit
		while (!quit)
		{
			renderInterface();

			int input = tryInt();

			switch (input)
			{
				case 1 :
					addOrSubtract("+");
					break;
				case 2 :
					addOrSubtract("-");
					break;
				case 3 :
					magnitude();
					break;
				case 9 :
					System.out.println("\nGoodbye");
					sc.close();
					System.exit(0);
				default :
					System.out.println(
							"\nPlease enter the correct input.");
					break;
			}

		}

	}

	/////////////////////////////////////
	// STYLING AND PRINTING
	////////////////////////////////////

	/**
	 * Prints a greeting message.
	 */
	private static void renderGreeting()
	{
		System.out.println(
				"Welcome to the Vector Operations Program!");
	}

	/**
	 * Prints an aesthetic border.
	 */
	private static void renderBorder()
	{
		System.out.println();

		for (int i = 0; i < BORDER_LENGTH; i++)
			System.out.print(BORDER);

		System.out.println("\n");
	}

	/**
	 * Prints the different options for vector operations.
	 */
	private static void renderInterface()
	{
		renderBorder();

		System.out.println("Enter 1: To Add Two Vectors\n"
				+ "Enter 2: To Subtract Two Vectors\n"
				+ "Enter 3: To Find the Magnitude of a Vector\n"
				+ "Enter 9: To Quit");

		renderBorder();

	}

	/**
	 * Iterates and prints the values of a given array.
	 * 
	 * @param arr
	 *            the array to iterate
	 */
	private static void printVector(double[] arr)
	{
		for (double value : arr)
			System.out.println(value);
	}

	/**
	 * Prints result of a vector operation.
	 * 
	 * @param arr
	 *            the first vector
	 * @param arr2
	 *            the second vector
	 * @param result
	 *            the result vector after a vector operation
	 * @param operation
	 *            a String representing which vector operation was performed
	 */
	private static void printResults(double[] arr,
			double[] arr2, double[] result,
			String operation)
	{
		System.out.println(); // aesthetic empty line
		printVector(arr);
		System.out.println(operation);
		printVector(arr2);
		System.out.println("=");
		printVector(result);
	}

	/**
	 * Performs addition or subtraction based on a given String representing
	 * which operation to take. Prompts the user for the size and values of each
	 * vector. If the vectors are not the same size, a message is printed and no
	 * further action is taken.
	 * 
	 * @param operation
	 *            a String representing which vector operation to perform
	 */
	private static void addOrSubtract(String operation)
	{
		// initialize the size and vector 1
		int size = setSize(1);
		double[] vector1 = createVector(size);

		// initialize the size and vector 2
		size = setSize(2);
		double[] vector2 = createVector(size);

		// check operation
		switch (operation)
		{
			case "+" :
			{
				// check if the vectors are the same size
				if (sameSize(vector1, vector2))
				{
					double[] result = add(vector1, vector2);
					printResults(vector1, vector2, result,
							"+");
				}
				else
					System.out.println(
							"Vectors must be the same size to add!!!");
				break;
			}
			case "-" :
			{
				if (sameSize(vector1, vector2))
				{
					double[] result = subtract(vector1,
							vector2);
					printResults(vector1, vector2, result,
							"-");
				}
				else
					System.out.println(
							"Vectors must be the same size to subtract!!!");
			}
		}

	}

	/**
	 * Prints a vectors magnitude. Prompts the user for the size and values in
	 * the vector.
	 */
	private static void magnitude()
	{
		// initialize a size for the vector
		int size = setSize(1);

		// generate a vector
		double[] vector = createVector(size);

		double magnitude = Math.sqrt(sumOfSquares(vector));

		System.out.println(
				"\nThe magnitude is: " + magnitude + "\n");

	}

	/////////////////////////////////////
	// CREATING VECTORS AND OTHER AUXILIARY METHODS
	////////////////////////////////////

	/**
	 * Creates an array based on a given size. Prompts the user for values at
	 * each index of the array.
	 * 
	 * @param size
	 *            the size of the array
	 */
	private static double[] createVector(int size)
	{
		// initiate an double array based on the size the user enters
		double[] vector = new double[size];

		// iterate and update
		for (int i = 0; i < size; i++)
		{
			System.out.println(
					"Enter the numeral " + (i + 1));
			vector[i] = tryDouble();
		}

		return vector;
	}

	/**
	 * Sets the size of the array by prompting the user for an Integer.
	 * 
	 * @param n
	 *            an Integer representing which vector they are currently
	 *            creating (first or second)
	 * @return an Integer that represents the size of a vector
	 */
	private static int setSize(int n)
	{
		// initialize an int to return the desired size of the vector
		int size = 0;

		// initialize a boolean to check for input
		boolean correctInput = false;

		// iterate until proper input is entered
		while (!correctInput)
		{
			System.out.println("What size is Vector " + n
					+ " (Must be greater than or equal to 1)");
			size = tryInt();
			if (size >= 1) correctInput = true;
			else
				System.out.println(
						"Vector must be greater than or equal to 1");
		}

		return size;
	}

	/**
	 * Checks if two given arrays are the same length.
	 * 
	 * @param arr
	 *            the first vector
	 * @param arr2
	 *            the second vector
	 * @return true if the arrays are the same size, false otherwise
	 */
	private static boolean sameSize(double[] arr,
			double[] arr2)
	{
		return arr.length == arr2.length;
	}

	/**
	 * Prompts the user to input an Integer.
	 * 
	 * @return the Integer the user enters, a zero if the user doesn't enter an
	 *         integer otherwise
	 */
	private static int tryInt()
	{
		int input;
		try
		{
			input = sc.nextInt();
		}
		catch (InputMismatchException e)
		{
			input = 0;
		}
		sc.nextLine(); // fix-up
		return input;
	}

	/**
	 * Prompts the user to enter a Double.
	 * 
	 * @return a Double entered by the user, a message and a 0 if the user
	 *         doesn't enter a Double
	 */
	private static double tryDouble()
	{
		// initialize a double for output
		double input;

		try
		{
			input = sc.nextDouble();
			sc.nextLine(); // fix-up
		}
		catch (InputMismatchException e)
		{
			sc.nextLine(); // fix-up
			System.out.println(
					"Invalid input, value has been set to 0.");
			input = 0;
		}
		return input;
	}

	/////////////////////////////////////
	// MATHEMATICAL CALCULATIONS
	////////////////////////////////////

	/**
	 * Creates a vector by adding the values of two given arrays.
	 * 
	 * @param arr
	 *            the first vector
	 * @param arr2
	 *            the second vector
	 * @return a vector representing the sum of two given arrays
	 */
	private static double[] add(double[] arr, double[] arr2)
	{
		// initialize an array for output
		double[] result = new double[arr.length];

		// iterate and calculate
		for (int i = 0; i < arr.length; i++)
			result[i] = arr[i] + arr2[i];

		return result;
	}

	/**
	 * Creates a vector by subtracting the values of two given arrays.
	 * 
	 * @param arr
	 *            the first vector
	 * @param arr2
	 *            the second vector
	 * @return a vector representing the difference of two given arrays
	 */
	private static double[] subtract(double[] arr,
			double[] arr2)
	{
		// initialize an array for output
		double[] result = new double[arr.length];

		// iterate and calculate
		for (int i = 0; i < arr.length; i++)
			result[i] = arr[i] - arr2[i];

		return result;
	}

	/**
	 * Squares a given Double.
	 * 
	 * @param x
	 *            a Double to square
	 * @return the product of a given Double
	 */
	private static double square(double x)
	{
		return x * x;
	}

	/**
	 * Sums the square of each value in a given vector.
	 * 
	 * @param arr
	 *            a vector
	 * @return the sum of each value being squared
	 */
	private static double sumOfSquares(double[] arr)
	{
		// initialize a result variable
		double sum = 0;

		// iterate and update
		for (double value : arr)
			sum += square(value);

		return sum;
	}

}
