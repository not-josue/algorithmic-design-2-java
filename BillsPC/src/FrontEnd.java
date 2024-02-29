/*
 * A program that acts like the PC in Pokemon games. Pokemon are created 
 * and added to a Box, an unlimited amount of Pokemon may be added to a Box, 
 * an unlimited amount of Boxes may be added to the PC.
 */
import java.util.InputMismatchException;
import java.util.Scanner;
public class FrontEnd
{
	// variables

	public static Scanner keyboard = new Scanner(System.in);
	public static PC myPC = new PC();

	public static void main(String[] args)
	{
		FrontEndPrinter.printGreeting();

		// start with a generic box
		addBox("Generic Box");

		boolean loggedIn = true;
		boolean performingOps = false;

		// main loop
		while (loggedIn)
		{
			FrontEndPrinter.printOperations();
			int input = tryInt();

			if (input == 0) logOff();

			performingOps = (input == 1 || input == 2)
					? true
					: false;

			// operations loop
			while (performingOps)
			{
				boolean boxOps, pcOps = false;

				switch (input)
				{
					// box operations
					case 1 :
						boxOps = true;
						while (boxOps)
						{
							// current box
							System.out.println(
									"===Current Box===\n"
											+ myPC.currentBox()
											+ "\nPokemon in Box: "
											+ myPC.currentBox()
													.getSize()
											+ "\n");
							// print options
							FrontEndPrinter
									.printBoxOperations();
							// get input
							int boxInput = tryInt();
							// check for go back
							if (boxInput == 10)
								performingOps = boxOps = false;
							// end program
							else
								if (boxInput == 0) logOff();
								// box operations
								else runBoxOps(boxInput);
						}
						break;
					// pc operations
					case 2 :
						pcOps = true;
						while (pcOps)
						{
							// boxes in the pc
							System.out.println(
									"\nTotal Boxes: ");
							myPC.printBoxNames();
							// print options
							FrontEndPrinter
									.printPCOperations();
							// get input
							int pcInput = tryInt();
							// check for go back
							if (pcInput == 6)
								performingOps = pcOps = false;
							// end program
							else
								if (pcInput == 0) logOff();
								// pc operations
								else runPCOps(pcInput);
						}
				}
			}
		}
	}

	/**
	 * Adds a Box to the PC.
	 * 
	 * @param aName
	 *            the name of the Box
	 */
	static void addBox(String aName)
	{
		Box aBox = new Box(aName);
		myPC.add(aBox);
	}

	/**
	 * Prompts the user for an integer and catches any input mismatch
	 * exceptions.
	 * 
	 * @return the integer the user entered or an integer with an arbitrary
	 *         value
	 */
	static int tryInt()
	{
		int input = -1;

		try
		{
			input = keyboard.nextInt();
			keyboard.nextLine();
		}
		catch (InputMismatchException e)
		{
			keyboard.nextLine();
			System.out.println("Invalid input...\n");
		}

		return input;
	}

	/**
	 * Performs different Box operations based on the given integer.
	 * 
	 * @param input
	 *            the Box opertaion to perform
	 */
	static void runBoxOps(int input)
	{
		switch (input)
		{
			// add Pokemon
			case 1 :
				Pokemon aPokemon = PokemonCreator
						.createPokemon();
				myPC.currentBox().addPokemon(aPokemon);
				break;
			// remove Pokemon
			case 2 :
				removePokemon();
				break;
			// export Box
			case 3 :
				exportBox();
				break;
			// append Box
			case 4 :
				appendBox();
				break;
			// rename Box
			case 5 :
				renameBox();
				break;
			// print current Box
			case 6 :
				myPC.currentBox().print();
				break;
			// move to next Box
			case 7 :
				myPC.nextBox();
				break;
			// move to previous Box
			case 8 :
				myPC.prevBox();
				break;
			// clear Box
			case 9 :
				myPC.currentBox().clearBox();
				break;
			default :
				System.out.println(
						"Invalid entry, try again...\n");
		}
	}

	/**
	 * Removes a Pokemon from the current Box. If the current Box is empty, a
	 * message is printed and no further action is taken.
	 */
	static void removePokemon()
	{
		if (myPC.getSize() == 0)
		{
			System.out.println(
					myPC.currentBox() + " is empty...");
			return;
		}
		System.out.println(
				"Enter the name of the Pokemon to remove:");
		String name = keyboard.nextLine();
		myPC.currentBox().removePokemon(name);
	}

	/**
	 * Creates or overwrites a file.
	 */
	static void exportBox()
	{
		System.out.println(
				"Enter the name of the file you would like to create/overwrite (include the file extension):");
		String filename = keyboard.nextLine();
		myPC.currentBox().exportBox(filename);
	}

	/**
	 * Appends a Box to a file.
	 */
	static void appendBox()
	{
		System.out.println(
				"Enter the name of the file you would like to append to (include the file extension):");
		String filename = keyboard.nextLine();
		myPC.currentBox().appendBox(filename);
	}

	/**
	 * Sets the name for the current Box.
	 */
	static void renameBox()
	{
		System.out.println("Enter the new name for "
				+ myPC.currentBox().getName());
		String boxName = keyboard.nextLine();
		myPC.currentBox().setName(boxName);
	}

	/**
	 * Performs various PC operations based on a given input.
	 * 
	 * @param input
	 *            the PC operation to perform
	 */
	static void runPCOps(int input)
	{
		switch (input)
		{
			// create a new box
			case 1 :
				newBox();
				break;
			// remove a box
			case 2 :
				removeBox();
				break;
			// export all boxes
			case 3 :
				exportAllBoxes();
				break;
			// print pokemon in all boxes
			case 4 :
				myPC.printBoxes();
				break;
			case 5 :
				myPC.clear();
				break;
			default :
				System.out.println(
						"Invalid input, please try again...");
		}
	}

	/**
	 * Prompts the user, and adds a Box to the PC.
	 */
	static void newBox()
	{
		System.out
				.println("Enter the name of the new Box:");
		String name = keyboard.nextLine();
		addBox(name);
	}

	/**
	 * Removes a Box from the PC. If there are no Boxes in the PC, a message is
	 * printed and no further action is taken.
	 */
	static void removeBox()
	{
		if (myPC.getSize() == 0)
		{
			System.out.println(
					"There are no Boxes to remove...");
			return;
		}

		System.out.println(
				"Enter the name of the Box you would like to remove:");
		String name = keyboard.nextLine();
		myPC.remove(name);
	}

	/**
	 * Prints all Boxes in the PC to a file.
	 */
	static void exportAllBoxes()
	{
		System.out.println(
				"Enter the name of the file you would like to create/overwrite (include the file extension)");
		String filename = keyboard.nextLine();
		myPC.exportBoxes(filename);
	}

	/**
	 * Prints a message, closes Scanner, and ends the program.
	 */
	static void logOff()
	{
		System.out.println(
				"You have successfully logged out of Bill's PC.");
		keyboard.close();
		System.exit(0);
	}

}
