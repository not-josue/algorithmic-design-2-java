/*
 * Defines the Game class which is able to print the maze, update the player's location, 
 * read files, and calculate winning or losing conditions.
 * Written By: Josue
 */
import java.io.File;
import java.util.Scanner;
public class Game
{
	// constants

	public static final int MAZE_SIZE = 10;

	public static final char EMPTY = '_';
	public static final char OBST = 'X';
	public static final char ROBOT = 'R';
	public static final char GOAL = '!';

	public static final String UP = "Move Up";
	public static final String DOWN = "Move Down";
	public static final String LEFT = "Move Left";
	public static final String RIGHT = "Move Right";
	public static final String LOSE = "CRASH";

	// attributes

	private char[][] maze; // index 0 = y, index 1 = x
	private LLQueue<String> commands;
	private int[] currLoc; // index 0 = y, index 1 = x

	// constructor

	public Game()
	{
		this.init();
	}

	/**
	 * Initializes all attributes in the Game.
	 */
	private void init()
	{
		maze = new char[MAZE_SIZE][MAZE_SIZE];
		commands = new LLQueue<String>();
		currLoc = new int[]{0, 0};
	}

	// accessor

	/**
	 * Retrieves the Queue representing the robot commands.
	 * 
	 * @return a Queue <String>
	 */
	public LLQueue<String> getCommands()
	{
		return this.commands;
	}

	// methods

	/**
	 * Performs all movement operations in the maze for the robot. Checks which
	 * movement to perform through a given String that is dequeued from the
	 * commands Linked List, updates the current location in the maze, and
	 * finally prints the current state of the maze. If movement results in an
	 * out of bounds error or in the space of an obstacle, a message is printed
	 * and the method is ended before movement occurs.
	 * 
	 * @param dequeue
	 *            represents the movement of the robot (from the commands Queue)
	 * @return true if the movement is not out of bounds and not in the the
	 *         space of an obstacle, false otherwise
	 */
	public boolean move(String dequeue)
	{
		int currY = currLoc[0];
		int currX = currLoc[1];

		// Up
		if (dequeue.equalsIgnoreCase(UP))
		{
			if (isValid(currY - 1)
					&& maze[currY - 1][currX] != OBST)
			{
				// set current to empty
				maze[currY][currX] = EMPTY;
				// update y
				currLoc[0]--;
				// move robot
				maze[currLoc[0]][currLoc[1]] = ROBOT;
				// print
				printMaze();
			}
			else
			{
				System.out.println(LOSE);
				return false;
			}
		}

		// Down
		else if (dequeue.equalsIgnoreCase(DOWN))
		{
			if (isValid(currY + 1)
					&& maze[currY + 1][currX] != OBST)
			{
				// set current to empty
				maze[currY][currX] = EMPTY;
				// update y
				currLoc[0]++;
				// move robot
				maze[currLoc[0]][currLoc[1]] = ROBOT;
				// print
				printMaze();
			}
			else
			{
				System.out.println(LOSE);
				return false;
			}
		}

		// Right
		else if (dequeue.equalsIgnoreCase(RIGHT))
		{
			if (isValid(currX + 1)
					&& maze[currY][currX + 1] != OBST)
			{
				// set current to empty
				maze[currY][currX] = EMPTY;
				// update x
				currLoc[1]++;
				// move robot
				maze[currLoc[0]][currLoc[1]] = ROBOT;
				// print
				printMaze();
			}
			else
			{
				System.out.println(LOSE);
				return false;
			}
		}

		// Left
		else if (dequeue.equalsIgnoreCase(LEFT))
		{
			if (isValid(currX - 1)
					&& maze[currY][currX - 1] != OBST)
			{
				// set current to empty
				maze[currY][currX] = EMPTY;
				// update x
				currLoc[1]--;
				// move robot
				maze[currLoc[0]][currLoc[1]] = ROBOT;
				// print
				printMaze();
			}
			else
			{
				System.out.println(LOSE);
				return false;
			}
		}

		return true;
	}

	/**
	 * Reads a given and builds the game board from it. Sets the start position,
	 * and the winning location in the maze.
	 * 
	 * @param filename
	 *            the given file to read
	 */
	public void setMaze(String filename)
	{
		try
		{
			// read file
			Scanner fileScanner = new Scanner(
					new File(filename));

			// initialize a counter variable to move rows
			int counter = 0;

			// iterate
			while (fileScanner.hasNextLine())
			{
				// parse line
				String fileLine = fileScanner.nextLine();

				// check length
				if (fileLine.length() == MAZE_SIZE)
				{
					// check each char
					if (correctRow(fileLine))
					{
						updateMaze(counter, fileLine);
						counter++;
					}
					else continue;
				}
				else continue;
			}
			// set start location
			maze[0][0] = ROBOT;
			// set win location
			maze[MAZE_SIZE - 1][MAZE_SIZE - 1] = GOAL;
			// close stream
			fileScanner.close();
		}
		catch (Exception e)
		{
			System.out.println(
					"File Not Found, try again!!!");
			e.printStackTrace();
		}
	}

	/**
	 * Iterates a given String, which represents a line in the board file, and
	 * evaluates that each Character is a valid board symbol.
	 * 
	 * @param fileLine
	 *            the line of the file to check
	 * @return true if all Characters are valid board symbols, false otherwise
	 */
	private boolean correctRow(String fileLine)
	{
		for (int i = 0; i < fileLine.length(); i++)
		{
			if (!correctTile(fileLine.charAt(i)))
				return false;
		}

		return true;
	}

	/**
	 * Checks if a given Character, which represents a Character of a line in
	 * the board file, is either the empty symbol or the obstacle symbol.
	 * 
	 * @param tile
	 *            a Character in a line in the board file
	 * @return true if the Character is either the empty symbol, or obstacle
	 *         symbol, false otherwise
	 */
	private boolean correctTile(char tile)
	{
		return tile == EMPTY || tile == OBST;
	}

	/**
	 * Iterates and updates the maze by parsing each Character in a given
	 * String, which represents a line in the board file.
	 * 
	 * @param counter
	 *            an Integer to update the y-value in maze
	 * @param fileLine
	 *            a line in the board file
	 */
	private void updateMaze(int counter, String fileLine)
	{
		// only iterates once
		for (int i = counter; i < counter + 1; i++)
		{
			for (int j = 0; j < maze[i].length; j++)
			{
				maze[i][j] = fileLine.charAt(j);
			}
		}
	}

	/**
	 * Reads a given robot commands file, and enqueues correctly formatted lines
	 * to the commands Queue.
	 * 
	 * @param filename
	 *            the given file to read
	 */
	public void setCommands(String filename)
	{
		try
		{
			// read file
			Scanner fileScanner = new Scanner(
					new File(filename));

			// iterate
			while (fileScanner.hasNextLine())
			{
				// parse line
				String fileLine = fileScanner.nextLine();

				// check format
				if (correctCommand(fileLine))
					commands.enqueue(fileLine);
				else
					continue;
			}
			// close stream
			fileScanner.close();
		}
		catch (Exception e)
		{
			System.out.println(
					"File Not Found, try again!!!\n");
			e.printStackTrace();
		}
	}

	/**
	 * Checks if a given String, which is represented by a line in a robot
	 * commands text file, matches the the correct Strings for the up, down,
	 * left, and right commands.
	 * 
	 * @param aLine
	 *            the line in a commands text file
	 * @return true if the given String matches the correct command Strings,
	 *         false otherwise
	 */
	private boolean correctCommand(String aLine)
	{
		return aLine.equalsIgnoreCase(UP)
				|| aLine.equalsIgnoreCase(DOWN)
				|| aLine.equalsIgnoreCase(LEFT)
				|| aLine.equalsIgnoreCase(RIGHT);
	}

	/**
	 * Iterates and prints the entire maze array.
	 */
	public void printMaze()
	{
		for (int i = 0; i < maze.length; i++)
		{
			for (int j = 0; j < maze[i].length; j++)
			{
				System.out.print(maze[i][j]);
			}
			System.out.println();
		}
		System.out.println(); // aesthetics
	}

	/**
	 * Checks if a given Integer, represented by the result of the robot's
	 * commands, is a valid location in the maze array.
	 * 
	 * @param index
	 *            the result of a robot's command on an index in the maze array
	 * @return true if the index is within the bounds of the maze array, false
	 *         otherwise
	 */
	public boolean isValid(int index)
	{
		return index >= 0 && index < maze.length;
	}

}