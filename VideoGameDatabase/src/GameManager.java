/*
 * A class that defines a linked list of games
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
public class GameManager
{
	// constants and variables

	public static final String DELIM = "\t";
	public static final int BODY_FIELD_AMT = 2;

	private GenLL<Game> box;

	// constructor

	public GameManager()
	{
		box = new GenLL<Game>();
	}

	/**
	 * Prints all Games in the Linked List.
	 */
	public void print()
	{
		System.out.println();
		box.print();
		System.out.println();
	}

	/**
	 * Adds a given Game to the Linked List.
	 * 
	 * @param aGame
	 *            the Game to be added to the Linked List
	 */
	public void addGame(Game aGame)
	{
		// add the Game object
		box.add(aGame);
	}

	/**
	 * Sort the Linked List by using the Bubble Sort algorithm.
	 */
	public void sortByName()
	{
		// initialize a boolean to iterate
		boolean hasSwapped = true;

		while (hasSwapped)
		{
			// update boolean in case list is already sorted
			hasSwapped = false;

			for (int i = 0; i < box.getSize(); i++)
			{
				// check for end of list
				if (box.getAt(i + 1) == null) break;

				// current node
				String current = box.getAt(i).getName();
				// next node
				String next = box.getAt(i + 1).getName();

				// compare current with next node
				if (current.compareToIgnoreCase(next) > 0)
				{
					// swap current with next
					this.swap(i, i + 1);
					// update boolean
					hasSwapped = true;
				}
			}
		}
	}

	/**
	 * Swaps a Node's data from a given index to a Node of another given index.
	 * 
	 * @param current
	 *            the current index
	 * @param next
	 *            the next index
	 */
	private void swap(int current, int next)
	{
		Game temp = box.getAt(current);
		box.setAt(current, box.getAt(next));
		box.setAt(next, temp);
	}

	/**
	 * Writes content to a given file.
	 * 
	 * @param filename
	 *            the name of the file that will be created / overwritten
	 */
	public void writeGameDB(String filename)
	{
		try
		{
			PrintWriter filewriter = new PrintWriter(
					new FileOutputStream(filename));

			// reset current
			box.reset();

			// iterate
			while (box.hasMore())
			{
				// initialize a new game
				Game aGame = box.getCurrent();
				// write to database
				filewriter.println(aGame.getName() + DELIM
						+ aGame.getConsole());
				// update current
				box.goToNext();
			}
			// close stream
			filewriter.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Reads the content of a given file. Creates a Game for each file line, and
	 * adds it to the Game Manager.
	 * 
	 * @param filename
	 *            the name of the file to read
	 */
	public void readGameDB(String filename)
	{
		try
		{
			// read file
			Scanner fileScanner = new Scanner(
					new File(filename));

			// iterate every line
			while (fileScanner.hasNextLine())
			{
				// save line
				String fileLine = fileScanner.nextLine();
				// parse line
				String[] split = fileLine.split(DELIM);

				// check for proper formatting
				if (split.length == BODY_FIELD_AMT)
				{
					// parse attributes
					String name = split[0];
					String console = split[1];

					// create a Game object
					Game newGame = new Game(name, console);
					// add to array
					this.addGame(newGame);
				}
			}
			System.out.println("\n" + filename
					+ " has been loaded...\n"
					+ "The current database contains "
					+ box.getSize() + " entries.\n");
			// close stream
			fileScanner.close();
		}
		catch (Exception e)
		{
			System.out.println(
					"\nSorry the file was not found...\n");
			// e.printStackTrace();
		}
	}

	/**
	 * Retrieves the size of the Game Manager.
	 * 
	 * @return an Integer that represents the size of the Game Manager
	 */
	public int getSize()
	{
		return box.getSize();
	}

	/**
	 * Removes all Nodes in the Game Manager.
	 */
	public void clearBox()
	{
		this.box = new GenLL<Game>();
	}

	/**
	 * Adds Games that contain a given name from this Game Manager to a given
	 * Game Manager.
	 * 
	 * @param aBox
	 *            a Game Manager to add Games to
	 * @param aName
	 *            the name of the Game to match
	 */
	public void exportByName(GameManager aBox, String aName)
	{
		// convert parameter to lowercase
		String lowercase = aName.toLowerCase();

		for (int i = 0; i < box.getSize(); i++)
		{
			// current in lowercase
			String current = box.getAt(i).getName()
					.toLowerCase();

			// check, and add to box
			if (current.contains(lowercase))
				aBox.addGame(box.getAt(i));
		}
	}

	/**
	 * Adds Games that contain a given console from this Game Manager to a given
	 * Game Manager.
	 * 
	 * @param aBox
	 *            a Game Manager to add Games to
	 * @param aConsole
	 *            the console of the Game to match
	 */
	public void exportByConsole(GameManager aBox,
			String aConsole)
	{
		// convert parameter to lowercase
		String lowercase = aConsole.toLowerCase();

		for (int i = 0; i < box.getSize(); i++)
		{
			// current in lowercase
			String current = box.getAt(i).getConsole()
					.toLowerCase();

			// check , and add to box
			if (current.contains(lowercase))
				aBox.addGame(box.getAt(i));
		}
	}

	/**
	 * Adds Games from this Game Manager to a given Game Manager. If the given
	 * Game Manager already contains the Game, no action is taken.
	 * 
	 * @param aBox
	 *            the Game Manager to add Games to
	 */
	public void exportGames(GameManager aBox)
	{
		for (int i = 0; i < box.getSize(); i++)
		{
			Game current = box.getAt(i);

			if (!aBox.containsGame(box.getAt(i)))
				aBox.addGame(current);
		}
	}

	/**
	 * Checks if there is an occurrence of a given Game in the Game Manager.
	 * 
	 * @param aGame
	 *            the Game that is to be compared
	 * @return true if an occurrence of a given Game is found, false otherwise
	 */
	public boolean containsGame(Game aGame)
	{
		for (int i = 0; i < box.getSize(); i++)
		{
			if (box.getAt(i).equals(aGame)) return true;
		}

		return false;
	}

	/**
	 * Retrieves a Game from the Game Manager at a given index
	 * 
	 * @param index
	 *            the index to retrieve the Game from
	 * @return a Game at the given index
	 */
	public Game getCurrentGame(int index)
	{
		return box.getAt(index);
	}

}
