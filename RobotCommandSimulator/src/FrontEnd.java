/**
 * A program that simulates a Maze Game. The program reads a file that contains
 * how the maze is configured, and reads a file that contains commands to
 * navigate through the maze. 
 * Written By: Josue
 */
import java.util.Scanner;
public class FrontEnd
{

	// constants and variables

	public static Scanner keyboard = new Scanner(System.in);
	public static Game game;

	public static void main(String[] args)
	{
		printGreeting();

		boolean playGame = true;

		while (playGame)
		{
			// initialize or reset game
			game = new Game();

			setFiles();
			runCommands();

			playGame = newGame();
		}

		// end program
		System.out.println("Goodbye!");
		keyboard.close();
		System.exit(0);
	}

	/**
	 * Prints the program's greeting message.
	 */
	static void printGreeting()
	{
		System.out.println(
				"Welcome to the Robot Simulator\n");
	}

	/**
	 * Prompts the user for the file to create the maze, and the file to run
	 * movement commands.
	 */
	static void setFiles()
	{
		setBoard();
		setCommands();
		System.out.println(); // aesthetics
	}

	/**
	 * Prompts the user for the file to create the maze.
	 */
	static void setBoard()
	{
		System.out.println(
				"Enter the file for the Board (with the file extension):");
		String input = keyboard.nextLine();
		game.setMaze(input);
	}

	/**
	 * Prompts the user for the file to run movement commands.
	 */
	static void setCommands()
	{
		System.out.println(
				"Enter the file for the Robot Commands (with the file extension):");
		String input = keyboard.nextLine();
		game.setCommands(input);
	}

	/**
	 * Prompts the user if they would like to restart the program.
	 * 
	 * @return true if the user's input is y, false otherwise
	 */
	static boolean newGame()
	{
		System.out.println(
				"Would you like to run another simulation? Enter \"y\" to restart:");
		String input = keyboard.nextLine();

		return input.equalsIgnoreCase("y") ? true : false;
	}

	/**
	 * Iterates, executes, and prints the game board after each command.
	 */
	static void runCommands()
	{
		int size = game.getCommands().getSize();

		System.out.println("Base Game\n");
		game.printMaze();

		for (int i = 0; i < size; i++)
		{
			System.out.println("Command Number: " + (i + 1)
					+ "\nCommand: "
					+ game.getCommands().peek() + "\n");
			if (!game.move(game.getCommands().dequeue()))
				break;
		}
	}

}
