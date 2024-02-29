
public class TesterPokemon
{

	public static final int[] PERFECT_IVS = {31, 31, 31, 31,
			31, 31};
	public static final String[] FIRE_TYPE = {"Fire"};
	public static final String[] GRASS_POISON_TYPE = {
			"Grass", "Poison"};

	public static void main(String[] args)
	{
		// default Pokemon
		Pokemon missingno = new Pokemon();

		System.out.println(missingno + "\n");

		// arcanine

		String[] arcanineMoves = {"Flare Blitz",
				"Wild Charge", "Close Combat",
				"Extremespeed"};

		int[] arcanineEvs = {0, 252, 4, 0, 0, 252};

		Pokemon arcanine = new Pokemon("Arcanine",
				"Assault Vest", "Male", "Jolly",
				"Intimidate", FIRE_TYPE, arcanineMoves,
				PERFECT_IVS, arcanineEvs);

		Pokemon arcanineClone = new Pokemon("arcanine",
				"assault vest", "male", "jolly",
				"intimidate", FIRE_TYPE, arcanineMoves,
				PERFECT_IVS, arcanineEvs);

		System.out.println(arcanine + "\n");

		// venusaur

		String[] venusaurMoves = {"Growth", "Giga Drain",
				"Weather Ball", "Sludge Bomb"};

		int[] venusaurEvs = {0, 0, 0, 252, 4, 252};

		Pokemon venusaur = new Pokemon();
		venusaur.setName("Venusaur");
		venusaur.setItem("Life Orb");
		venusaur.setGender("Female");
		venusaur.setNature("Modest");
		venusaur.setAbility("Chlorophyll");
		venusaur.setTypes(GRASS_POISON_TYPE);
		venusaur.setMoves(venusaurMoves);
		venusaur.setIVs(PERFECT_IVS);
		venusaur.setEvs(venusaurEvs);

		System.out.println(venusaur + "\n");

		// equals test

		System.out.println(arcanine.equals(arcanineClone));
		System.out.println(arcanine.equals(venusaur));
	}

}
