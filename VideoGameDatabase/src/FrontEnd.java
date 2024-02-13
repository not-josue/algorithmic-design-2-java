/*
 * A program that reads a Video Game Database, is able to sort by the Game's name and 
 * console, and is able to create a new database from a sorted list
 * Written By: Josue
 */
import java.util.InputMismatchException;
import java.util.Scanner;
public class FrontEnd
{
	// constants and variables
	public static final String BORDER_TYPE = "=";
	public static final int BORDER_LENGTH = 50;
	public static final String WILDCARD = "*";

	public static Scanner keyboard = new Scanner(System.in);
	public static GameManager database = new GameManager();
	public static GameManager exportList = new GameManager();
	public static GameManager searchResults = new GameManager();

	public static void main(String[] args)
	{
		printGreeting();

		// initialize a boolean to iterate
		boolean quit = false;

		// iterate
		while (!quit)
		{
			printOptions();
			int option = setOption();
			checkOption(option);
		}
	}

	/////////////////////////////////////
	// PRINTING METHODS
	/////////////////////////////////////

	/**
	 * Prints a greeting message.
	 */
	static void printGreeting()
	{
		System.out.println(
				"Welcome to the Video Game Database!\n");
	}

	/**
	 * Prints an aesthetic border.
	 */
	static void printBorder()
	{
		for (int i = 0; i < BORDER_LENGTH; i++)
			System.out.print(BORDER_TYPE);
		System.out.println();
	}

	/**
	 * Prints all available options for Game Manager operations.
	 */
	static void printOptions()
	{
		printBorder();
		System.out.println(
				"\nEnter 1 to load the video game database (only 1 can be loaded at a time)"
						+ "\nEnter 2 to search the database"
						+ "\nEnter 3 to print current search results to the console"
						+ "\nEnter 4 to add the current search results to an export list"
						+ "\nEnter 5 to print the current export list"
						+ "\nEnter 6 to clear the export list"
						+ "\nEnter 7 to write the export list to a file (overwrites existing files)"
						+ "\nEnter 0 to quit\n");
		printBorder();
	}

	/**
	 * Prints a given Game Manager if it is not empty. A message is generated
	 * based on the given operation (search or export). If the Game Manager is
	 * empty, that message is printed instead of the Game Manager.
	 * 
	 * @param aList
	 *            the Game Manager to print
	 * @param listType
	 *            the type of operation (search or export)
	 */
	static void printList(GameManager aList,
			String listType)
	{
		// initialize an output variable for an empty list
		String output = (listType.equals("search"))
				? "\nYou haven't had any successful searches...\n"
				: "\nYou haven't added anything to export...\n";

		// check if the list is empty
		if (aList.getSize() == 0)
		{
			System.out.println(output);
			return;
		}

		aList.print();
	}

	/////////////////////////////////////
	// SETTER METHODS
	/////////////////////////////////////

	/**
	 * Prompts the user for an Integer which represents a Game Manager
	 * operation.
	 * 
	 * @return an Integer representing a Game Manager operation
	 */
	static int setOption()
	{
		// initialize a boolean to iterate
		boolean correctInput = false;

		// initialize a return integer
		int input = -1;

		// iterate and check
		while (!correctInput)
		{
			try
			{
				input = keyboard.nextInt();
				keyboard.nextLine(); // fix-up
				correctInput = true;
			}
			catch (InputMismatchException e)
			{
				keyboard.nextLine(); // fix-up
				System.out.println(
						"\nInvalid input, enter an integer\n");
				printOptions();
				continue;
			}
		}

		return input;
	}

	/////////////////////////////////////
	// OPTIONS METHODS
	/////////////////////////////////////

	/**
	 * Takes action based on the given input. Calls to perform all Game Manager
	 * operations.
	 * 
	 * @param input
	 *            an Integer representing the user's selected Game Manager
	 *            operation
	 */
	static void checkOption(int input)
	{
		switch (input)
		{
			case 0 :
				System.out.println("\nGoodbye");
				keyboard.close();
				System.exit(0);
			case 1 :
				loadDB();
				break;
			case 2 :
				searchDB();
				break;
			case 3 :
				printList(searchResults, "search");
				break;
			case 4 :
				addToExport();
				break;
			case 5 :
				printList(exportList, "export");
				break;
			case 6 :
				clearExportList();
				break;
			case 7 :
				exportToFile();
				break;
			default :
				System.out.println("\nInvalid input...\n");
		}
	}

	/**
	 * Prompts the user to specify the filename (including the file extension)
	 * of a Game database to read. Invokes the method to read the given file.
	 */
	static void loadDB()
	{
		// clear database
		database.clearBox();

		// get input
		System.out.println(
				"\nWhat is the name of the file (include the file extension)?");
		String fileName = keyboard.nextLine();

		database.readGameDB(fileName);
	}

	/**
	 * Prompts the user for the name, and console to query from the currently
	 * loaded database. Prints the search results to the user if any results
	 * match, or a message if no matches were found. If the current database is
	 * empty, signaling that no database has been loaded, a message is printed
	 * and no further action is taken.
	 */
	static void searchDB()
	{
		// check if a database hasn't been loaded
		if (database.getSize() == 0)
		{
			System.out.println(
					"\nYou haven't loaded a database yet!!!\n");
			return;
		}

		// get name input
		System.out
				.println("\nEnter the name of the game or '"
						+ WILDCARD + "' for all");
		String input = keyboard.nextLine();

		// initialize a temp list
		GameManager nameTemp = new GameManager();

		// check input
		if (WILDCARD.equals(input)) nameTemp = database;
		else database.exportByName(nameTemp, input);

		// check if no matches were found
		if (nameTemp.getSize() == 0)
		{
			System.out.println(
					"\nNo games were found by the name "
							+ input + "\n");
			return;
		}

		// get console input
		System.out.println(
				"\nEnter the console of the game or '"
						+ WILDCARD + "' for all");
		input = keyboard.nextLine();

		// initialize another temp list and export
		GameManager consoleTemp = new GameManager();

		// check input
		if (WILDCARD.equals(input)) consoleTemp = nameTemp;
		else nameTemp.exportByConsole(consoleTemp, input);

		// check if not matches were found
		if (consoleTemp.getSize() == 0)
		{
			System.out.println(
					"\nNo games were found by the console "
							+ input + "\n");
			return;
		}

		// clear previous results
		if (searchResults.getSize() > 0)
			searchResults.clearBox();

		// update searchResults and sort by Name
		searchResults = consoleTemp;
		searchResults.sortByName();

		// print results
		searchResults.print();
	}

	/**
	 * Adds Games to an export list if any successful search results have
	 * occurred. If the search results Game Manager is empty, a message is
	 * printed and no further action is taken.
	 */
	static void addToExport()
	{
		// check for empty results
		if (searchResults.getSize() == 0)
		{
			System.out.println(
					"\nYou haven't had any successful searches...\n");
			return;
		}

		// update exportList and sort
		searchResults.exportGames(exportList);
		exportList.sortByName();

		exportListSize();
	}

	/**
	 * Removes all Nodes from the export Linked List. Prompts the user for
	 * confirmation before Node removal occurs. If the export Game Manager is
	 * empty, no action is taken.
	 */
	static void clearExportList()
	{
		// check if list is empty
		if (exportList.getSize() == 0)
		{
			System.out.println(
					"\nThe current export list is empty...\n");
			return;
		}

		// check if user meant to delete the list
		System.out.println(
				"\nAre you sure you sure you want to delete "
						+ exportList.getSize() + " entries?"
						+ "\nEnter \"yes\" to delete all entries:");

		// get input
		String input = keyboard.nextLine();

		// check input
		if ("yes".equalsIgnoreCase(input))
			exportList.clearBox();
		else
			System.out.println(
					"\nNo entries were deleted!!!");

		exportListSize();
	}

	/**
	 * Prompts the user for a filename (including file extension) to write a
	 * Game database file. Invokes the method to write a database file. If the
	 * export list is empty, a message is printed, and no further action is
	 * taken.
	 */
	static void exportToFile()
	{
		// check if list is empty
		if (exportList.getSize() == 0)
		{
			System.out.println(
					"\nThe current export list is empty...\n");
			return;
		}

		// get input
		System.out.println(
				"\nWhat would you like to call the file (include file extension)?");
		String input = keyboard.nextLine();

		exportList.writeGameDB(input);

		System.out.println("\nYou have successfully added "
				+ exportList.getSize() + " entries to "
				+ input + ".\n");
	}

	/////////////////////////////////////
	// AUXILIARY METHODS
	/////////////////////////////////////

	/**
	 * Prints the size of the export Game Manager.
	 */
	static void exportListSize()
	{
		System.out.println(
				"\nThe current export list contains "
						+ exportList.getSize()
						+ " entries\n");
	}

}
