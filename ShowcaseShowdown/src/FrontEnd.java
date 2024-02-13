/*
 * A program that simulates a game show where the user is given 5 items, and has to estimate 
 * the total cost of the items, a threshold of less than $1300 is given for a correct answer
 * Written By: Josue
 */
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class FrontEnd
{

	// constants and variables

	public static final double THRESHOLD = 1300.0;
	public static final String DATABASE = "prizesdb.txt";
	public static final int AMT_OF_PRIZES = 5;

	public static Scanner keyboard = new Scanner(System.in);
	public static PrizeManager prizes = new PrizeManager();
	public static Random aRandom = new Random();

	public static void main(String[] args)
	{
		greeting();
		prizes.readPrizeFile(DATABASE);

		// initialize a boolean to exit the program
		boolean quit = false;

		// start program
		while (!quit)
		{
			// initialize an array to pick random prizes
			int[] randomArr = setRandomArr();
			printPrizeNames(randomArr);

			// get user input for price guess
			double guess = setGuess();
			// initialize a variable for the actual price
			double actualPrice = setTotalPrice(randomArr);

			// print actual prize prices and the sum
			printPrizes(randomArr);
			printTotalPrice(actualPrice);

			// compare the guess and actual price and initialize an output
			// variable
			String output = setOutput(guess, actualPrice);
			System.out.println(output);

			// check if the user wants to start a new game
			newGame();
		}

	}

	/////////////////////////////////////////////////////////
	// PRINT METHODS
	/////////////////////////////////////////////////////////

	/*
	 * Prints the program's greeting message.
	 */
	static void greeting()
	{
		System.out.println(
				"Welcome to the showcase show down!\n");
	}

	/**
	 * Prints the name of Prizes in a given array.
	 * 
	 * @param indexArr
	 *            an array that contains Prizes
	 */
	static void printPrizeNames(int[] indexArr)
	{
		System.out.println("Your prizes are:");
		for (int i = 0; i < indexArr.length; i++)
			prizes.printName(indexArr[i]);
	}

	/**
	 * Prints the Prizes of a given array.
	 * 
	 * @param indexArr
	 *            an array that contains Prizes
	 */
	static void printPrizes(int[] indexArr)
	{
		System.out.println(
				"\nThese are the actual costs for all prizes:\n");
		for (int i = 0; i < indexArr.length; i++)
			prizes.printIndex(indexArr[i]);
	}

	/**
	 * Prints a given double.
	 * 
	 * @param sum
	 *            the double to print
	 */
	static void printTotalPrice(double sum)
	{
		System.out.println("Total: " + sum);
	}

	/**
	 * Starts a new game and prompts the user to quit the program. If the user
	 * enters "yes", the program terminates. If the user enters anything else, a
	 * new game starts.
	 */
	static void newGame()
	{
		System.out.println(
				"\nWould you like to quit? Enter \"yes\" to quit:");

		String input = keyboard.nextLine();

		if (input.equalsIgnoreCase("yes"))
		{
			System.out.println("\nThanks for playing!!!");
			keyboard.close();
			System.exit(0);
		}
		else
			System.out.println(
					"\nLets start a new game!!!\n");
	}

	/////////////////////////////////////////////////////////
	// SETTER METHODS
	/////////////////////////////////////////////////////////

	/**
	 * Generates an array of random numbers representing indices for selecting
	 * prizes. Each number in the array is unique and falls within the range of
	 * available prizes.
	 * 
	 * @return an array that contains a unique set of randomly generated
	 *         integers
	 */
	static int[] setRandomArr()
	{
		// initialize an array to hold random numbers
		int[] indexArr = new int[AMT_OF_PRIZES];

		// iterate
		for (int i = 0; i < indexArr.length; i++)
		{
			int number = aRandom
					.nextInt(prizes.setArraySize(DATABASE));

			if (contains(indexArr, number)) continue;
			else
			{
				// check for out of bounds error
				if (number == prizes.setArraySize(DATABASE))
					indexArr[i] = number - 1;
				else
					indexArr[i] = number;
			}

		}

		return indexArr;
	}

	/**
	 * Gets a user's input for a guess of the total price for all Prizes.
	 * 
	 * @return the user's input which represents a guess of the total price
	 */
	static double setGuess()
	{
		// initialize a return variable with an arbitrary value
		double input = -1;
		// initialize a boolean to loop until a correct input is entered
		boolean correctInput = false;

		while (!correctInput)
		{
			System.out.println(
					"\nYou must guess the total cost of the prizes!\n"
							+ "Your guess must within $"
							+ THRESHOLD
							+ " without going over of its actual price!\n"
							+ "Enter your guess:");
			try
			{
				input = keyboard.nextDouble();
				keyboard.nextLine(); // fix-up
				correctInput = true;
			}
			catch (InputMismatchException e)
			{
				keyboard.nextLine(); // fix-up
				continue;
			}
		}

		return input;
	}

	/**
	 * Computes the total price of all Prizes in a Prize array.
	 * 
	 * @param array
	 *            an array that contains the integers of the Prizes to choose
	 * @return the sum of the prices of all Prizes
	 */
	static double setTotalPrice(int[] array)
	{
		// initialize a sum variable to return
		double sum = 0;

		// iterate and update
		for (int i = 0; i < array.length; i++)
			sum += prizes.getPrice(array[i]);

		return sum;
	}

	/**
	 * Generates a message based on the comparison between a user's guess, and
	 * the actual price of Prizes.
	 * 
	 * @param guess
	 *            the user's guess
	 * @param actualPrice
	 *            the sum of all prizes
	 * @return depending on how close the user's guess is, a win statement, or a
	 *         lose statement
	 */
	static String setOutput(double guess,
			double actualPrice)
	{
		return (guess > actualPrice)
				? "\nYour guess was over the actual amount. You lose!!!"
				: (guess < actualPrice - THRESHOLD)
						? "\nYour guess was under the alloted threshold. You lose!!!"
						: (guess == actualPrice)
								? "\nYour guess was PERFECT. You win!!!"
								: "\nYour guess was within the alloted threshold. You win!!!";
	}

	/////////////////////////////////////////////////////////
	// AUXILLARY METHODS
	/////////////////////////////////////////////////////////

	/**
	 * Checks if there is an occurrence of a given number in a given array.
	 * 
	 * @param array
	 *            the array that will be iterated
	 * @param number
	 *            the number to compare with a value in the array
	 * @return true if the number is found in the array, false if the array is
	 *         empty or if the number is not found
	 */
	static boolean contains(int[] array, int number)
	{
		// check if array is empty
		if (array.length == 0) return false;

		// iterate and compare each index
		for (int i = 0; i < array.length; i++)
		{
			if (array[i] == number) return true;
		}
		return false;
	}

}
