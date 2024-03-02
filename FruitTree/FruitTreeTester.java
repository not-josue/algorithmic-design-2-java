/*
 * A program that reads a Fruit database, then prints the database in 
 * Pre-Order, In-Order, and Post-Order formats. The program can also 
 * delete a Fruit, which is then verified through In-Order printing.
 * Written By: Josue
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class FruitTreeTester
{
	// constants

	public static final Fruit DELETE_TESTER = new Fruit(
			"Apple", 0.4859853412170728);
	public static final String DELIM = "\t";
	public static final int BODY_FIELD_AMT = 2;

	// variables

	public static Scanner keyboard;
	private LinkedBST<Fruit> myTree = new LinkedBST<Fruit>();

	public static void main(String[] args)
	{
		FruitTreeTester tester = new FruitTreeTester();
		tester.printGreeting();
		tester.getInput();
		tester.print();
		tester.delete();
	}

	/**
	 * Prints the greeting message.
	 */
	public void printGreeting()
	{
		System.out.println("Welcome to the fruit tree!\n");
	}

	/**
	 * Prompts the user for a String that represents a file name, then calls a
	 * method to read the file.
	 */
	public void getInput()
	{
		keyboard = new Scanner(System.in);
		System.out.println(
				"Please enter a Fruit File Name (include the file extension):");
		String filename = keyboard.nextLine();
		keyboard.close();
		this.readDB(filename);
	}

	/**
	 * Prints the tree In Order, Pre-Order, and Post Order.
	 */
	public void print()
	{
		System.out.println("\nPrinting In-Order\n");
		myTree.printInOrder();
		System.out.println("\nPrinting Pre-Order\n");
		myTree.printPreOrder();
		System.out.println("\nPrinting Post-Order\n");
		myTree.printPostOrder();
	}

	/**
	 * Removes a Fruit constant from the tree.
	 */
	public void delete()
	{
		System.out.println(
				"\nDeleting... " + DELETE_TESTER + "\n");
		myTree.remove(DELETE_TESTER);
		System.out.println("Printing In-Order\n");
		myTree.printInOrder();
	}

	/**
	 * Reads a given file, and adds correctly formatted lines to the tree. If a
	 * file does not exist, a message is printed and no further action is taken.
	 * 
	 * @param filename
	 *            the name of the file to read
	 */
	private void readDB(String filename)
	{
		File aFile = new File(filename);

		// file not found
		if (!aFile.exists())
		{
			System.out.println(
					"Sorry that file was not found...");
			return;
		}

		System.out.println("Populating tee file...");

		try (Scanner fileScanner = new Scanner(aFile))
		{
			while (fileScanner.hasNextLine())
			{
				// set current line
				String fileLine = fileScanner.nextLine();

				// split
				String[] split = fileLine.split(DELIM);

				// check formatting <type> \t <weight>
				if (split.length == BODY_FIELD_AMT)
				{
					// check that weight is a value
					if (this.tryDouble(split[1]))
					{
						Fruit aFruit = new Fruit(split[0],
								Double.valueOf(split[1]));
						myTree.add(aFruit);
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

	/**
	 * Attempts to convert a String to a Double.
	 * 
	 * @param aValue
	 *            the String to check
	 * @return true if the given String can be converted to a Double, false
	 *         otherwise
	 */
	private boolean tryDouble(String aValue)
	{
		try
		{
			Double.valueOf(aValue);
			return true;
		}
		catch (NumberFormatException e)
		{
			e.printStackTrace();
		}

		return false;
	}

}
