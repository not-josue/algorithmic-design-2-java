/*
 * A tester class to test different methods
 * Written By: Josue
 */

public class Tester
{

	public static void main(String[] args)
	{
		// default Pokemon
		Pokemon p1 = new Pokemon();

		// custom pokemon

		String[] types = {"Fire"};
		String[] moves = {"Flare Blitz", "Wild Charge",
				"Close Combat"};

		int[] ivs = {31, 31, 31, 31, 31, 31};
		int[] evs = {0, 252, 4, 0, 0, 252};

		Pokemon p2 = new Pokemon("Arcanine", "Choice Band",
				"Male", "Adamant", types, moves, ivs, evs);

		System.out.println(p1.toString() + "\n");
		System.out.println(p2.toString());

		// equals test

		Pokemon p3 = p2;
		Pokemon p4 = new Pokemon("Arcanine", "Choice Band",
				"Male", "Adamant", types, moves, ivs, evs);

		System.out.println(p2.equals(p3));
		System.out.println(p2.equals(p4));

		// box tests

		Box box = new Box();
		box.addPokemon(p1);
		box.addPokemon(p2);
		box.addPokemon(p3); // duplicate test

		box.print();

		box.removePokemon("MissingNo");
		box.removePokemon("Ditto"); // not in list

		box.print();

		Box box2 = new Box();
		box2.addPokemon(p4);

		// equals test
		System.out.println(box.equals(box2));

		// pc tests

		PC myPC = new PC();

		myPC.addBox(box2);
		myPC.renameBox("Box 0", "Fire Pokemon");
		myPC.addBox(box); // duplicate
	}

}
