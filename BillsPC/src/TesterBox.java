
public class TesterBox
{
	public static Box box1 = new Box();

	public static final int[] PERFECT_IVS = {31, 31, 31, 31,
			31, 31};
	public static final String[] FIRE_TYPE = {"Fire"};

	public static final Pokemon missingno = new Pokemon();

	public static void main(String[] args)
	{
		// empty box
		box1.print();

		// to String
		System.out.println(box1 + "\n");

		box1.addPokemon(missingno);
		box1.print();
		box1.removePokemon("Missingno");
		box1.print();

		box1.addPokemon(createArcanine());
		box1.addPokemon(createHitmontop());
		box1.addPokemon(createCinderace());
		box1.addPokemon(createSceptile());

		// check sorting
		box1.print();

		// export
		box1.exportBox("Export.txt");

		// append
		box1.exportBox("Append.txt");
		box1.appendBox("Append.txt");
	}

	static Pokemon createArcanine()
	{
		String[] arcanineMoves = {"Flare Blitz",
				"Wild Charge", "Close Combat",
				"Extremespeed"};

		int[] arcanineEvs = {0, 252, 4, 0, 0, 252};

		Pokemon arcanine = new Pokemon("Arcanine",
				"Assault Vest", "Male", "Jolly",
				"Intimidate", FIRE_TYPE, arcanineMoves,
				PERFECT_IVS, arcanineEvs);

		return arcanine;
	}

	static Pokemon createHitmontop()
	{
		// hitmontop

		String[] fightingType = {"Fighting"};
		String[] hitmontopMoves = {"Fake Out", "Mach Punch",
				"Bullet Punch", "Sucker Punch"};
		int[] hitmontopEvs = {252, 252, 4, 0, 0, 0};

		Pokemon hitmontop = new Pokemon("Hitmontop",
				"Assault Vest", "Male", "Adamant",
				"Technician", fightingType, hitmontopMoves,
				PERFECT_IVS, hitmontopEvs);

		return hitmontop;
	}

	static Pokemon createCinderace()
	{
		String[] cinderaceMoves = {"Pyro Ball",
				"High Jump Kick", "Sucker Punch", "U-turn"};

		int[] cinderaceEvs = {0, 252, 4, 0, 0, 252};

		Pokemon cinderace = new Pokemon("Cinderace",
				"Heavy-Duty Boots", "Female", "Jolly",
				"Libero", FIRE_TYPE, cinderaceMoves,
				PERFECT_IVS, cinderaceEvs);

		return cinderace;
	}

	static Pokemon createSceptile()
	{
		String[] grassType = {"Grass"};
		String[] sceptileMoves = {"Leaf Storm",
				"Dragon Pulse", "Leech Seed",
				"Hidden Power: Ice"};

		int[] sceptileEvs = {0, 0, 0, 252, 4, 252};

		Pokemon sceptile = new Pokemon("Sceptile",
				"Sceptilite", "Female", "Timid", "Overgrow",
				grassType, sceptileMoves, PERFECT_IVS,
				sceptileEvs);

		return sceptile;
	}

}
