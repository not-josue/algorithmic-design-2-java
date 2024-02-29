/*
 * Defines printing methods for the Front End.
 */
public class FrontEndPrinter
{
	/**
	 * Prints greeting message.
	 */
	public static void printGreeting()
	{
		System.out.println(
				"Logged into Bill's PC\nA Box has been created for you..\n");
	}

	/**
	 * Prints the categories of operations.
	 */
	public static void printOperations()
	{
		System.out.println("1. Box Operations"
				+ "\n2. PC Operations" + "\n0. Quit");
	}

	/**
	 * Prints the options for Box operations.
	 */
	public static void printBoxOperations()
	{
		System.out.println("1. Add a Pokemon to the Box"
				+ "\n2. Remove a Pokemon in the Box"
				+ "\n3. Export Current Box"
				+ "\n4. Append Current Box"
				+ "\n5. Rename Current Box"
				+ "\n6. Print Current Box"
				+ "\n7. Move to the Next Box"
				+ "\n8. Move to the Previous Box"
				+ "\n9. Clear Box" + "\n10. Go Back"
				+ "\n0. Quit");
	}

	/**
	 * Prints the options for PC operations.
	 */
	public static void printPCOperations()
	{
		System.out.println("1. Create a new Box"
				+ "\n2. Remove a Box"
				+ "\n3. Export all Boxes"
				+ "\n4. Print the Pokemon in all Boxes"
				+ "\n5. Clear all Boxes" + "\n6. Go Back"
				+ "\n0. Quit");
	}

}
