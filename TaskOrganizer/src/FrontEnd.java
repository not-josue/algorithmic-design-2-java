/*
 * A program that manages a collection of tasks and groups them by priority, can also read  
 * and write a task database
 * Written By: Josue
 */
import java.util.InputMismatchException;
import java.util.Scanner;
public class FrontEnd
{
	// constants and variables

	public static Scanner keyboard = new Scanner(System.in);
	public static TaskManager manager = new TaskManager();

	public static final String BORDER_TYPE = "=";
	public static final int BORDER_LENGTH = 50;

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
			takeAction(option);
		}
	}

	////////////////////////////////////////////
	// PRINTING METHODS
	////////////////////////////////////////////

	/**
	 * Prints a greeting message.
	 */
	static void printGreeting()
	{
		System.out.println(
				"Welcome to the Task Organizer!\n");
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
	 * Prints all available options for managing Tasks.
	 */
	static void printOptions()
	{
		printBorder();
		System.out.println("\nEnter 1. To Add a Task"
				+ "\nEnter 2. To Remove a Task"
				+ "\nEnter 3. To Print Tasks To Console"
				+ "\nEnter 4. To Read from a Task File (Replaces current DB)"
				+ "\nEnter 5. To Write to a Task File"
				+ "\nEnter 0. To Quit");
		printBorder();
	}

	////////////////////////////////////////////
	// OPTIONS METHODS
	////////////////////////////////////////////

	/**
	 * Sets the user option for task management by taking user input.
	 * 
	 * @return an integer representing the user's selected option
	 */
	static int setOption()
	{
		// initialize a return integer
		int option = -1;

		// initialize a boolean to iterate
		boolean correctInput = false;

		// iterate
		while (!correctInput)
		{
			try
			{
				option = keyboard.nextInt();
				keyboard.nextLine(); // fix-up
				return option;
			}
			catch (InputMismatchException e)
			{
				System.out.println(
						"\nWrong input, try again");
				continue;
			}
		}

		return option;
	}

	/**
	 * Takes action based on the user's selected option. Different actions are
	 * taken based on the given option.
	 * 
	 * @param option
	 *            the integer representing the user's selected option
	 */
	static void takeAction(int option)
	{
		switch (option)
		{
			case 0 :
				System.out.println("\nGoodbye!");
				keyboard.close();
				System.exit(0);
			case 1 :
				addTask();
				break;
			case 2 :
				removeTask();
				break;
			case 3 :
				manager.printAll();
				break;
			case 4 :
				readDB();
				break;
			case 5 :
				writeDB();
				break;
			default :
				System.out.println(
						"\nInvalid input, please try again");

		}
	}

	/**
	 * Adds a Task to the Task Manager. Prompts the user for the Task's priority
	 * and action. Constructs a Task based on the user's input.
	 */
	static void addTask()
	{
		// set priority
		int priority = tryPriority();

		// set action
		System.out.println("\nEnter the task's action:");
		String action = keyboard.nextLine();

		// construct a new Task
		Task newTask = new Task(action, priority);

		// update manager
		manager.addTask(newTask);
	}

	/**
	 * Removes a Task from the Task Manager. Prompts the user for the Task's
	 * priority and action. Constructs a Task based on the user's input to
	 * search for.
	 */
	static void removeTask()
	{
		// set priority
		int priority = tryPriority();

		// set action
		System.out.println("\nEnter the task's action:");
		String action = keyboard.nextLine();

		// construct a new Task
		Task newTask = new Task(action, priority);

		// update manager
		manager.removeTask(newTask);
	}

	/**
	 * Sets the priority of a Task by taking the user's input.
	 * 
	 * @return an integer that represent's a Task's priority
	 */
	static int tryPriority()
	{
		// initialize a boolean to iterate
		boolean correctInput = false;

		// initialize a return variable
		int input = -1;

		// iterate
		while (!correctInput)
		{
			System.out.println(
					"\nEnter the task's priority:");

			try
			{
				input = keyboard.nextInt();
				keyboard.nextLine();
				return input;
			}
			catch (InputMismatchException e)
			{
				System.out.println(
						"\nWrong Input, try again");
				continue;
			}
		}

		return input;
	}

	/**
	 * Prompts the user to specify the filename (including the file extension)
	 * of the Task database they want to read. Invokes the method to read the
	 * given Task database file.
	 */
	static void readDB()
	{
		System.out.println(
				"\nEnter the name of the file you would like to read (include the file extension):");
		String fileName = keyboard.nextLine();

		manager.readTaskDB(fileName);
	}

	/**
	 * Prompts the user to specify a filename (including the file extension) and
	 * writes the Task database to the given file. Invokes the method to write
	 * the Task database to the given file.
	 */
	static void writeDB()
	{
		System.out.println(
				"\nWhat would you like to call the file (include the file extension)?");
		String fileName = keyboard.nextLine();

		manager.writeTaskDB(fileName);
	}

}
