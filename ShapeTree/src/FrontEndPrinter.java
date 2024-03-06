/*
 * Defines print methods for the Front End.
 * Written By: Josue
 */
public class FrontEndPrinter
{
	public static void printGreeting()
	{
		System.out.println("Welcome to the Shape Tree!");
	}

	public static void printMainOptions()
	{
		System.out.println(
				"\nEnter 1. To Read a Shape Tree from a File."
						+ "\nEnter 2. To Print a Tree Traversal to the Console"
						+ "\nEnter 3. To Add a Shape."
						+ "\nEnter 4. To Remove a Shape."
						+ "\nEnter 5. To Search for a Shape."
						+ "\nEnter 6. To Find the Shape with the Max Area."
						+ "\nEnter 7. To Remove All Shapes Greater than an Area."
						+ "\nEnter 8. To Print Shape Tree to File."
						+ "\nEnter 0. To Quit.");
	}

	public static void printTraversalOptions()
	{
		System.out.println("\nWhich traversal?"
				+ "\nEnter 1. For Pre-order."
				+ "\nEnter 2. For In-order"
				+ "\nEnter 3. For Post-order");
	}
}
