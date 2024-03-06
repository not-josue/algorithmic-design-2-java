/*
 * A program that uses a Binary Search Tree, to add Shapes, read a Shape file, 
 * perform various printing traversals, and export the Binary Search Tree to a file.
 * More operations like removal, finding the Shape with the max area, and filtering 
 * based on a max area threshold are also possible.
 * Written By: Josue
 */
import java.util.InputMismatchException;
import java.util.Scanner;
public class FrontEnd
{
	public static Scanner keyboard = new Scanner(System.in);
	public static ShapeManager tree = new ShapeManager();

	public static void main(String[] args)
	{
		FrontEndPrinter.printGreeting();

		while (true)
		{
			// print options
			FrontEndPrinter.printMainOptions();
			// get input
			int input = tryInt();
			// perform operations
			runOperations(input);
		}
	}

	/**
	 * Checks if the entered value is an Integer.
	 * 
	 * @return an Integer entered by the user
	 */
	static int tryInt()
	{
		int value;

		while (true)
		{
			try
			{
				value = keyboard.nextInt();
				keyboard.nextLine(); // fix-up
				return value;
			}
			catch (InputMismatchException e)
			{
				keyboard.nextLine(); // fix-up
				System.out.println(
						"Invalid input, enter an Integer...");
			}

		}
	}

	/**
	 * Performs program operations based on a given Integer.
	 * 
	 * @param input
	 *            the operation to run
	 */
	static void runOperations(int input)
	{
		switch (input)
		{
			// import database
			case 1 :
				readDB();
				break;
			// print tree
			case 2 :
				printTree();
				break;
			// add shape
			case 3 :
				addShape();
				break;
			// remove shape
			case 4 :
				removeShape();
				break;
			// search for shape
			case 5 :
				search();
				break;
			// get max area
			case 6 :
				getMaxArea();
				break;
			// remove all shapes greater than x
			case 7 :
				removeGreaterThan();
				break;
			// export tree
			case 8 :
				exportDB();
				break;
			// quit
			case 0 :
				endProgram();
				// invalid input
			default :
				System.out.println(
						"Invalid input, enter a correct option...\n");
		}
	}

	/**
	 * Prompts the user for a file name, reads the file, and adds Shapes to the
	 * tree.
	 */
	static void readDB()
	{
		System.out.println(
				"Enter the name of the file, include the file extension:");
		// get input
		String input = keyboard.nextLine();
		tree.readDB(input);

		System.out.println(
				"\nNow printing transferred Shapes In-Order\n");
		// print tree
		tree.printInOrder();
	}

	/**
	 * Prompts the user for an Integer, and prints in the traversal of the
	 * user's choosing.
	 */
	static void printTree()
	{
		// print options
		FrontEndPrinter.printTraversalOptions();
		// get input
		int input = tryInt();

		switch (input)
		{
			// pre-order
			case 1 :
				System.out.println(
						"\nPrinting by Pre-Order traversal:\n");
				tree.printPreOrder();
				break;
			// in-order
			case 2 :
				System.out.println(
						"\nPrinting by In-Order traversal:\n");
				tree.printInOrder();
				break;
			// post-order
			case 3 :
				System.out.println(
						"\nPrinting by Post-Order traversal:\n");
				tree.printPostOrder();
				break;
			// invalid input
			default :
				System.out.println(
						"\nInvalid input, unable to print...\n");
		}
	}

	/**
	 * Prompts the user for the type of Shape to create, and goes through the
	 * process of creating then adding the Shape to the tree.
	 */
	static void addShape()
	{
		System.out.println(
				"What type of Shape would you like to create (circle, rectangle, right triangle)");
		String input = keyboard.nextLine();

		// check for invalid input
		if (input.equalsIgnoreCase("circle")
				|| input.equalsIgnoreCase("rectangle")
				|| input.equalsIgnoreCase("right triangle"))
			tree.addShape(ShapeCreator.createShape(input));

		else
			System.out
					.println("Invalid Shape, cannot create "
							+ input);
	}

	/**
	 * Prompts the user for the type of Shape to remove, and goes through the
	 * process of prompting the user for all its attributes (except area).
	 * Finally removes the Shape (if an occurrence is found) from the tree.
	 */
	static void removeShape()
	{
		System.out.println(
				"What type of Shape would you like to remove (circle, rectangle, right triangle)");
		String input = keyboard.nextLine();

		// check for invalid input
		if (input.equalsIgnoreCase("circle")
				|| input.equalsIgnoreCase("rectangle")
				|| input.equalsIgnoreCase("right triangle"))
			tree.removeShape(
					ShapeCreator.createShape(input));
		else
			System.out.println(
					input + " is not a valid Shape...");

	}

	/**
	 * Prompts the user for the type of Shape to search for, and goes through
	 * the process of prompting the user for all its attributes (except area).
	 * Finally prints a message showing if an occurrence was found.
	 */
	static void search()
	{
		System.out.println(
				"What type of Shape would you like to search for (circle, rectangle, right triangle)");
		String input = keyboard.nextLine();

		// check for invalid input
		if (input.equalsIgnoreCase("circle")
				|| input.equalsIgnoreCase("rectangle")
				|| input.equalsIgnoreCase("right triangle"))
		{
			boolean outcome = tree.search(
					ShapeCreator.createShape(input));
			System.out
					.println("Was the Shape in the tree??? "
							+ outcome);
		}
		else
			System.out.println(
					input + " is not a valid Shape...");
	}

	/**
	 * Prints a message of the Shape with the maximum area in the tree.
	 */
	static void getMaxArea()
	{
		System.out.println("The Shape with max are is:\n");
		System.out.println(tree.getMaxArea());
	}

	/**
	 * Prompts the user for a Integer that represents a maximum are threshold.
	 * Then removes all Shapes with an area greater than the Integer entered by
	 * the user.
	 */
	static void removeGreaterThan()
	{
		System.out.println("Enter the MAXIMUM AREA:");
		int threshold = tryInt();
		tree.removeGreaterThan(threshold);
	}

	/**
	 * Prompts the user for a file name, then creates/overwrites that file with
	 * Shapes in the tree.
	 */
	static void exportDB()
	{
		System.out.println(
				"Enter the name of the file (include the file extension)");
		String filename = keyboard.nextLine();
		tree.writeDB(filename);
	}

	/**
	 * Prints a message, closes the Scanner, and exits the program.
	 */
	static void endProgram()
	{
		System.out.println("Goodbye!!!");
		keyboard.close();
		System.exit(0);
	}

}
