/*
 * Defines the processes for creating a Pokemon through 
 * printing messages and prompting the user for input.
 * Written By: Josue
 */
import java.util.InputMismatchException;
import java.util.Scanner;
public class PokemonCreator
{
	private static Pokemon aPokemon;
	public static Scanner keyboard = new Scanner(System.in);

	public static final int MAX_TYPES = 2;
	public static final int MAX_MOVES = 4;
	public static final String[] STATS = {"HP", "Attack",
			"Defense", "Special Attack", "Special Defense",
			"Speed"};
	public static final int[] MAX_STATS = {31, 31, 31, 31,
			31, 31};
	public static final int MAX_IVS = 31;
	public static final int MAX_EVS_TOTAL = 510;
	public static final int MAX_EV = 252;

	public static final int[] PHYSICAL_ATTACKER = {0, 252,
			4, 0, 0, 252};
	public static final int[] SPECIAL_ATTACKER = {0, 0, 0,
			252, 4, 252};
	public static final int[] PHYSICAL_DEFENDER = {252, 0,
			252, 0, 4, 0};
	public static final int[] SPECIAL_DEFENDER = {252, 0, 4,
			0, 252, 0};

	/**
	 * Creates a Pokemon by calling methods to set all attributes.
	 * 
	 * @return the created Pokemon
	 */
	public static Pokemon createPokemon()
	{
		aPokemon = new Pokemon();
		setName();
		setItem();
		setGender();
		setNature();
		setAbility();
		setTypes();
		setMoves();
		setIVs();
		setEVs();

		return aPokemon;
	}

	/**
	 * Sets the name of the Pokemon.
	 */
	private static void setName()
	{
		System.out
				.println("Enter the name of the Pokemon:");
		String name = keyboard.nextLine();
		aPokemon.setName(name);
	}

	/**
	 * Sets the item of the Pokemon.
	 */
	private static void setItem()
	{
		System.out.println("Enter the item held by "
				+ aPokemon.getName() + ":");
		String item = keyboard.nextLine();
		aPokemon.setItem(item);
	}

	/**
	 * Sets the gender of the Pokemon.
	 */
	private static void setGender()
	{
		System.out.println("Enter the gender of "
				+ aPokemon.getName() + ":");
		String gender = keyboard.nextLine();
		aPokemon.setGender(gender);
	}

	/**
	 * Sets the nature of the Pokemon.
	 */
	private static void setNature()
	{
		System.out.println("Enter the nature of "
				+ aPokemon.getName() + ":");
		String nature = keyboard.nextLine();
		aPokemon.setNature(nature);
	}

	/**
	 * Sets the ability of the Pokemon.
	 */
	private static void setAbility()
	{
		System.out.println("Enter the ability of "
				+ aPokemon.getName() + ":");
		String ability = keyboard.nextLine();
		aPokemon.setAbility(ability);
	}

	/**
	 * Sets the type of the Pokemon.
	 */
	private static void setTypes()
	{
		System.out.println("Enter the amount of types for "
				+ aPokemon.getName() + ":");
		int amountOfTypes = tryInt();

		if (amountOfTypes > MAX_TYPES)
		{
			System.out.println(
					"Invalid types amount, types has been set to "
							+ MAX_TYPES);
			amountOfTypes = 2;
		}

		String[] types = new String[amountOfTypes];

		for (int i = 0; i < types.length; i++)
		{
			System.out.println("Enter a type:");
			String type = keyboard.nextLine();
			types[i] = type;
		}

		aPokemon.setTypes(types);
	}

	/**
	 * Sets the moves of a Pokemon.
	 */
	private static void setMoves()
	{
		System.out.println("Enter the amount of moves "
				+ aPokemon.getName() + " has:");
		int amountOfMoves = tryInt();

		// cannot exceed max amount of moves
		if (amountOfMoves > MAX_MOVES)
		{
			System.out.println(
					"Invalid amount of moves, amount has been set to "
							+ MAX_MOVES);
			amountOfMoves = MAX_MOVES;
		}

		String[] moves = new String[amountOfMoves];

		for (int i = 0; i < moves.length; i++)
		{
			System.out
					.println("Enter move " + (i + 1) + ":");
			String aMove = keyboard.nextLine();
			moves[i] = aMove;
		}

		aPokemon.setMoves(moves);
	}

	/**
	 * Sets the IVs of the Pokemon.
	 */
	private static void setIVs()
	{
		System.out.println("Next we will set up the IVs of "
				+ aPokemon.getName() + "."
				+ "\nThe max IVs of each stat is " + MAX_IVS
				+ ", anything over will be set to a default value.\n");

		int[] ivs = new int[STATS.length];

		System.out.println("Would you like to set max IVs?"
				+ "\nEnter \"yes\" to assign " + MAX_IVS
				+ " in each Stat.");

		String input = keyboard.nextLine();

		// preset max ivs
		if (input.equalsIgnoreCase("yes"))
		{
			aPokemon.setIVs(MAX_STATS);
			System.out.println(aPokemon.getName()
					+ "'s IVs have been set to " + MAX_IVS);
		}
		// custom ivs
		else
		{
			for (int i = 0; i < ivs.length; i++)
			{
				System.out.println(
						"Enter the value for " + STATS[i]);
				int value = tryIntStats();
				ivs[i] = value;
			}

			aPokemon.setIVs(ivs);
		}
	}

	/**
	 * Sets the Evs of the Pokemon.
	 */
	private static void setEVs()
	{
		System.out.println(
				"Finally we will set up the EVs of "
						+ aPokemon.getName() + "."
						+ "\nThe max EVs a stat can have is "
						+ MAX_EV + "."
						+ "\nThe max total a Pokemon can have is "
						+ MAX_EVS_TOTAL + "."
						+ "\nAnything over will be set to a default value.\n");

		int[] evs = new int[STATS.length];

		// preset evs
		System.out.println(
				"Would you like to use a preset EV spread?"
						+ "\nPhysical Attacker: 252 Attack, 252 Speed, 4 Defense"
						+ "\nSpecial Attacker: 252 Special Attack, 252 Speed, 4 Special Defense"
						+ "\nPhysical Defender: 252 HP, 252 Defense, 4 Special Defense"
						+ "\nSpecial Defender: 252 HP, 252 Special Defense, 4 Defense"
						+ "\nEnter \"yes\" to use a preset EV spread.");

		String input = keyboard.nextLine();

		if (input.equalsIgnoreCase("yes"))
		{
			presetEVs();
		}
		else
		{
			for (int i = 0; i < evs.length; i++)
			{
				System.out.println(
						"Enter the value for " + STATS[i]);
				int value = tryIntStats();
				evs[i] = value;
			}

			aPokemon.setEvs(evs);
		}
	}

	/**
	 * Sets the Pokemon's EV spread to a preset array.
	 */
	private static void presetEVs()
	{
		int preset = tryIntPreset();

		switch (preset)
		{
			case 1 :
				aPokemon.setEvs(PHYSICAL_ATTACKER);
				System.out.println(aPokemon.getName()
						+ " has been set to a Physical Attacker!\n");
				break;
			case 2 :
				aPokemon.setEvs(SPECIAL_ATTACKER);
				System.out.println(aPokemon.getName()
						+ " has been set to a Special Attacker!\n");
				break;
			case 3 :
				aPokemon.setEvs(PHYSICAL_DEFENDER);
				System.out.println(aPokemon.getName()
						+ " has been set to a Physical Defender!\n");
				break;
			case 4 :
				aPokemon.setEvs(SPECIAL_DEFENDER);
				System.out.println(aPokemon.getName()
						+ " has been set to a Special Defender!\n");
		}
	}

	/**
	 * Prompts the user to pick a preset EV spread.
	 * 
	 * @return the preset build to set the Pokemon to
	 */
	private static int tryIntPreset()
	{
		int number = 0;

		while (number < 1 || number > 4)
		{
			try
			{
				System.out.println("1. Physical Attacker"
						+ "\n2. Special Attacker"
						+ "\n3. Physical Defender"
						+ "\n4. Special Defender");

				number = keyboard.nextInt();
				keyboard.nextLine();

				if (number < 1 || number > 4)
					System.out.println(
							"Invalid input, try again...");
			}
			catch (InputMismatchException e)
			{
				keyboard.nextLine();
				System.out.println(
						"Invalid input, try again...");
			}
		}

		return number;
	}

	/**
	 * Prompts the user for an integer and catches any input mismatch
	 * exceptions.
	 * 
	 * @return the integer the user entered
	 */
	private static int tryInt()
	{
		int number = 1;
		boolean correctInput = false;

		while (!correctInput)
		{
			try
			{
				number = keyboard.nextInt();
				keyboard.nextLine();

				if (number >= 1) correctInput = true;
				else
				{
					System.out.println(
							"Invalid input, try again...");
					continue;
				}
			}
			catch (InputMismatchException e)
			{
				keyboard.nextLine();
				System.out.println(
						"Invalid input, try again...");
			}
		}

		return number;
	}

	/**
	 * Prompts the user for an integer and catches any input mismatch
	 * exceptions.
	 * 
	 * @return the integer the user entered
	 */
	private static int tryIntStats()
	{
		int number = 0;
		boolean correctInput = false;

		while (!correctInput)
		{
			try
			{
				number = keyboard.nextInt();
				keyboard.nextLine();

				if (number >= 0) correctInput = true;
				else
				{
					System.out.println(
							"Invalid input, try again...");
					continue;
				}
			}
			catch (InputMismatchException e)
			{
				keyboard.nextLine();
				System.out.println(
						"Invalid input, try again...");
			}
		}

		return number;
	}

}
