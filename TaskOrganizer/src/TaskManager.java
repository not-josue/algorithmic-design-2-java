/*
 * A class that defines an array of Linked Lists of type Task
 * Written By: Josue
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
public class TaskManager
{
	// variables and constants

	private GenLL<Task>[] manager;

	public static final int SIZE = 5;
	public static final int BODY_FIELD_AMT = 2;
	public static final String DELIM = "\t";

	// constructor

	public TaskManager()
	{
		init();
	}

	/**
	 * Initializes an array to a default size, and creates a Linked List at each
	 * index.
	 */
	private void init()
	{
		// construct the array
		manager = new GenLL[SIZE];

		// construct the Linked Lists
		for (int i = 0; i < manager.length; i++)
			manager[i] = new GenLL<Task>();
	}

	/**
	 * Adds a given Task to a Linked List in the array based on its priority if
	 * it is not a duplicate. If the given Task is a duplicate, a message is
	 * printed, and no further action is taken.
	 * 
	 * @param aTask
	 *            the task to add to a Linked List
	 */
	public void addTask(Task aTask)
	{
		// get the Task's priority
		int priority = aTask.getPriority();

		if (isDuplicate(manager[priority], aTask))
		{
			System.out.println("\n" + aTask
					+ " is already in the list so was not added\n");
			return;
		}

		manager[priority].add(aTask);
	}

	/**
	 * Checks if an occurrence of a given Task is found in a given Linked List.
	 * 
	 * @param list
	 *            the Linked List to iterate
	 * @param aTask
	 *            the Task to compare
	 * @return true if the Linked List contains the given Task, false otherwise
	 */
	private boolean isDuplicate(GenLL<Task> list,
			Task aTask)
	{
		for (int i = 0; i < list.getSize(); i++)
		{
			if (list.getAt(i).equals(aTask)) return true;
		}

		return false;
	}

	/**
	 * Removes a given Task based on its priority from a Linked List. If the
	 * Linked List is empty, a message is printed, and no further action is
	 * taken.
	 * 
	 * @param aTask
	 *            the Task to remove
	 */
	public void removeTask(Task aTask)
	{
		// get the Task's priority
		int priority = aTask.getPriority();

		// check for empty list
		if (manager[priority].getSize() == 0)
		{
			System.out.println("\nThe list is empty");
			return;
		}

		removeFromList(manager[priority], aTask);

	}

	/**
	 * Iterates a given Linked List and removes a given Task if an occurrence of
	 * the Task is found. If an occurrence of the given Task is not found, a
	 * message is printed.
	 * 
	 * @param list
	 *            the Linked List to search
	 * @param aTask
	 *            the Task to remove
	 */
	private void removeFromList(GenLL<Task> list,
			Task aTask)
	{
		// reset current
		list.reset();

		// iterate
		while (list.hasMore())
		{
			// check current node
			if (list.getCurrent().equals(aTask))
			{
				list.removeCurrent();
				return;
			}
			// update current
			list.goToNext();
		}

		System.out.println("\n" + aTask
				+ " was not found so was not removed");
	}

	/**
	 * Prints all Linked Lists in the array. If the array is empty, a message is
	 * printed and no further action is taken.
	 */
	public void printAll()
	{
		if (emptyManager())
		{
			System.out.println("\nThe manager is empty");
			return;
		}

		for (GenLL<Task> list : manager)
			list.print();
	}

	/**
	 * Reads a given file and populates the array. If the array is not empty, it
	 * is first emptied.
	 * 
	 * @param fileName
	 *            the file to read
	 */
	public void readTaskDB(String fileName)
	{
		// empty the manager
		if (!emptyManager()) this.init();

		try
		{
			// read file
			Scanner fileScanner = new Scanner(
					new File(fileName));

			// read every line
			while (fileScanner.hasNextLine())
			{
				// current line
				String fileLine = fileScanner.nextLine();

				// parse line
				String[] parse = fileLine.split(DELIM);

				// check for proper formatting
				if (parse.length == BODY_FIELD_AMT)
				{
					// check if String can be converted to an integer
					if (tryInt(parse[0]))
					{
						// initialize Task attributes
						int priority = Integer
								.parseInt(parse[0]);
						String action = parse[1];

						// construct a Task Object
						Task newTask = new Task(action,
								priority);

						// add to the manager
						this.addTask(newTask);
					}
				}
			}
			// close steam
			fileScanner.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println(
					"\nSorry the file was not found\n");
			// e.printStackTrace();
		}
	}

	/**
	 * Writes data from the array to a given file.
	 * 
	 * @param fileName
	 *            the name of the file to create / overwrite
	 */
	public void writeTaskDB(String fileName)
	{
		if (emptyManager())
		{
			System.out.println(
					"\nThe manager is currently empty"
							+ "\nThe file was not created...");
			return;
		}

		try
		{
			PrintWriter fileWriter = new PrintWriter(
					new FileOutputStream(fileName));

			// iterate array
			for (GenLL<Task> list : manager)
			{
				// iterate list
				for (int i = 0; i < list.getSize(); i++)
				{
					// construct a Task Object
					Task newTask = list.getAt(i);

					// write to DB
					fileWriter.println(newTask.getPriority()
							+ DELIM + newTask.getAction());

				}
			}
			// close steam
			fileWriter.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Attempts to parse a given String into an integer.
	 * 
	 * @param str
	 *            the String to parse
	 * @return true if the String can be parsed into an integer, false otherwise
	 */
	private boolean tryInt(String str)
	{
		try
		{
			int test = Integer.parseInt(str);
		}
		catch (InputMismatchException e)
		{
			return false;
		}
		return true;
	}

	/**
	 * Checks if all Linked Lists in the array are empty.
	 * 
	 * @return true if all Linked Lists in the array are empty, false otherwise
	 */
	private boolean emptyManager()
	{
		return manager[0].getSize() == 0
				&& manager[1].getSize() == 0
				&& manager[2].getSize() == 0
				&& manager[3].getSize() == 0
				&& manager[4].getSize() == 0;
	}

}
