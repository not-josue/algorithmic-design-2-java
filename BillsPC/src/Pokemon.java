/*
 * A class that defines a Pokemon Object
 * Written By: Josue
 */
import java.util.LinkedHashMap;
public class Pokemon
{
	// constants
	public static final int MAX_MOVES = 4;
	public static final int STAT_TYPES = 6;
	public static final int MAX_IVS = 31;
	public static final int MAX_EVS_TOTAL = 510;
	public static final int MAX_EV = 252;

	// attributes

	private String name;
	private String item;
	private Gender gender;
	private Nature nature;
	private String ability;
	private GenLL<Type> types;
	private String[] moves;
	private LinkedHashMap<Stats, Integer> ivs;
	private LinkedHashMap<Stats, Integer> evs;

	// constructors

	public Pokemon()
	{
		this.name = "Missingno";
		this.item = "None";
		this.gender = Gender.None;
		this.nature = Nature.None;
		this.ability = "None";
		this.initTypes();
		this.initMoves();
		this.initIVs();
		this.initEVs();
	}

	public Pokemon(String aName, String anItem,
			String aGender, String aNature,
			String anAbility, String[] typeArr,
			String[] moveArr, int[] ivValues,
			int[] evValues)
	{
		this.setName(aName);
		this.setItem(anItem);
		this.setGender(aGender);
		this.setNature(aNature);
		this.setAbility(anAbility);
		this.setTypes(typeArr);
		this.setMoves(moveArr);
		this.setIVs(ivValues);
		this.setEvs(evValues);
	}

	/**
	 * Initializes the types Type array
	 */
	private void initTypes()
	{
		types = new GenLL<Type>();
		types.add(Type.None);
	}

	/**
	 * Initializes the moves String array
	 */
	private void initMoves()
	{
		moves = new String[MAX_MOVES];

		for (int i = 0; i < moves.length; i++)
			moves[i] = "None";
	}

	/**
	 * Initializes ivs Linked HashMap <Stats, Integer>
	 */
	private void initIVs()
	{
		ivs = new LinkedHashMap<Stats, Integer>(STAT_TYPES);

		ivs.put(Stats.HP, 0);
		ivs.put(Stats.Attack, 0);
		ivs.put(Stats.Defense, 0);
		ivs.put(Stats.Special_Atk, 0);
		ivs.put(Stats.Special_Def, 0);
		ivs.put(Stats.Speed, 0);
	}

	/**
	 * Initializes evs Linked HashMap <Stats, Integer>
	 */
	private void initEVs()
	{
		evs = new LinkedHashMap<Stats, Integer>(STAT_TYPES);

		evs.put(Stats.HP, 0);
		evs.put(Stats.Attack, 0);
		evs.put(Stats.Defense, 0);
		evs.put(Stats.Special_Atk, 0);
		evs.put(Stats.Special_Def, 0);
		evs.put(Stats.Speed, 0);

	}

	// getters

	public String getName()
	{
		return this.name;
	}

	public String getItem()
	{
		return this.item;
	}

	public Gender getGender()
	{
		return this.gender;
	}

	public Nature getNature()
	{
		return this.nature;
	}

	public String getAbility()
	{
		return this.ability;
	}

	public GenLL<Type> getTypes()
	{
		return this.types;
	}

	public String[] getMoves()
	{
		return this.moves;
	}

	public LinkedHashMap<Stats, Integer> getIVs()
	{
		return this.ivs;
	}

	public LinkedHashMap<Stats, Integer> getEVs()
	{
		return this.evs;
	}

	// setters

	public void setName(String aName)
	{
		if (aName != null) this.name = aName;
		else this.name = "Missingno";
	}

	public void setItem(String anItem)
	{
		if (anItem != null) this.item = anItem;
		else this.item = "None";
	}

	public void setGender(String aGender)
	{
		if (aGender != null)
		{
			this.gender = aGender.equalsIgnoreCase("Male")
					? Gender.Male
					: aGender.equalsIgnoreCase("Female")
							? Gender.Female
							: aGender.equalsIgnoreCase(
									"Genderless")
											? Gender.Genderless
											: Gender.None;
		}
		else this.gender = Gender.None;

	}

	public void setNature(String aNature)
	{
		if (aNature != null)
		{
			String lowerCaseNature = aNature.toLowerCase();

			switch (lowerCaseNature)
			{
				case "adamant" :
					this.nature = Nature.Adamant;
					break;
				case "bashful" :
					this.nature = Nature.Bashful;
					break;
				case "bold" :
					this.nature = Nature.Bold;
					break;
				case "brave" :
					this.nature = Nature.Brave;
					break;
				case "calm" :
					this.nature = Nature.Calm;
					break;
				case "careful" :
					this.nature = Nature.Careful;
					break;
				case "docile" :
					this.nature = Nature.Docile;
					break;
				case "gentle" :
					this.nature = Nature.Gentle;
					break;
				case "hardy" :
					this.nature = Nature.Hardy;
					break;
				case "hasty" :
					this.nature = Nature.Hasty;
					break;
				case "impish" :
					this.nature = Nature.Impish;
					break;
				case "jolly" :
					this.nature = Nature.Jolly;
					break;
				case "lax" :
					this.nature = Nature.Lax;
					break;
				case "lonely" :
					this.nature = Nature.Lonely;
					break;
				case "mild" :
					this.nature = Nature.Mild;
					break;
				case "modest" :
					this.nature = Nature.Modest;
					break;
				case "naive" :
					this.nature = Nature.Naive;
					break;
				case "naughty" :
					this.nature = Nature.Naughty;
					break;
				case "quiet" :
					this.nature = Nature.Quiet;
					break;
				case "quirky" :
					this.nature = Nature.Quirky;
					break;
				case "rash" :
					this.nature = Nature.Rash;
					break;
				case "relaxed" :
					this.nature = Nature.Relaxed;
					break;
				case "sassy" :
					this.nature = Nature.Sassy;
					break;
				case "serious" :
					this.nature = Nature.Serious;
					break;
				case "timid" :
					this.nature = Nature.Timid;
					break;
				default :
					this.nature = Nature.None;
			}
		}
		else this.nature = Nature.None;

	}

	public void setAbility(String anAbility)
	{
		if (anAbility != null) this.ability = anAbility;
		else this.ability = "None";
	}

	public void setTypes(String[] arr)
	{
		types = new GenLL<Type>();

		for (int i = 0; i < arr.length; i++)
		{
			Type aType = setType(arr[i]);
			types.add(aType);
		}
	}

	/**
	 * Auxiliary method to check a String and match it to a Type, called by the
	 * setTypes method, handles null errors
	 * 
	 * @param aType
	 *            a given String that is evaluated
	 * @return a Type that matches the given String, or None if no matches are
	 *         found
	 */
	private Type setType(String aType)
	{
		if (aType != null)
		{
			String lowerCaseType = aType.toLowerCase();

			switch (lowerCaseType)
			{
				case "normal" :
					return Type.Normal;
				case "fire" :
					return Type.Fire;
				case "water" :
					return Type.Water;
				case "electric" :
					return Type.Electric;
				case "grass" :
					return Type.Grass;
				case "ice" :
					return Type.Ice;
				case "fighting" :
					return Type.Fighting;
				case "poison" :
					return Type.Poison;
				case "ground" :
					return Type.Ground;
				case "flying" :
					return Type.Flying;
				case "psychic" :
					return Type.Psychic;
				case "bug" :
					return Type.Bug;
				case "rock" :
					return Type.Rock;
				case "ghost" :
					return Type.Ghost;
				case "dragon" :
					return Type.Dragon;
				case "dark" :
					return Type.Dark;
				case "steel" :
					return Type.Steel;
				case "fairy" :
					return Type.Fairy;
				default :
					return Type.None;
			}
		}
		else return Type.None;
	}

	public void setMoves(String[] arr)
	{
		moves = new String[MAX_MOVES];

		if (moves.length == arr.length)
		{
			for (int i = 0; i < moves.length; i++)
				moves[i] = this.setMove(arr[i]);
		}
		// less than max moves
		else if (moves.length > arr.length)
		{
			// set given moves
			for (int i = 0; i < arr.length; i++)
				moves[i] = arr[i];

			// set the rest to default value
			for (int i = arr.length; i < moves.length; i++)
				moves[i] = "None";
		}
		// greater than max moves
		else
		{
			for (int i = 0; i < moves.length; i++)
				moves[i] = "None";
		}
	}

	/**
	 * Auxiliary method to check if a given String is not null, called by the
	 * setMoves method
	 * 
	 * @param aMove
	 *            the given String to be evaluated
	 * @return the String if not null, None otherwise
	 */
	private String setMove(String aMove)
	{
		if (aMove != null) return aMove;
		else return "None";
	}

	public void setIVs(int[] arr)
	{
		if (arr.length == STAT_TYPES)
		{
			ivs = new LinkedHashMap<Stats, Integer>(
					STAT_TYPES);

			ivs.put(Stats.HP, this.setIV(arr[0]));
			ivs.put(Stats.Attack, this.setIV(arr[1]));
			ivs.put(Stats.Defense, this.setIV(arr[2]));
			ivs.put(Stats.Special_Atk, this.setIV(arr[3]));
			ivs.put(Stats.Special_Def, this.setIV(arr[4]));
			ivs.put(Stats.Speed, this.setIV(arr[5]));
		}
		else this.initIVs();
	}

	private int setIV(int value)
	{
		if (value >= 0 && value <= MAX_IVS) return value;
		else return 0;
	}

	public void setEvs(int[] arr)
	{
		// check length
		if (arr.length == STAT_TYPES)
		{
			// check total effort value integers
			if (!this.overEVs(arr))
			{
				evs = new LinkedHashMap<Stats, Integer>(
						STAT_TYPES);

				evs.put(Stats.HP, this.setEV(arr[0]));
				evs.put(Stats.Attack, this.setEV(arr[1]));
				evs.put(Stats.Defense, this.setEV(arr[2]));
				evs.put(Stats.Special_Atk,
						this.setEV(arr[3]));
				evs.put(Stats.Special_Def,
						this.setEV(arr[4]));
				evs.put(Stats.Speed, this.setEV(arr[5]));
			}
			else this.initEVs();
		}
		else this.initEVs();
	}

	private boolean overEVs(int[] arr)
	{
		int sum = 0;

		for (int value : arr)
			sum += value;

		return sum >= MAX_EVS_TOTAL;
	}

	private int setEV(int value)
	{
		if (value >= 0 && value <= MAX_EV) return value;
		else return 0;
	}

	// other methods

	@Override
	public String toString()
	{
		return "Name: " + this.name + "\nItem: " + this.item
				+ "\nGender: " + this.gender + "\nNature: "
				+ this.nature + "\nAbility: " + this.ability
				+ "\nType(s): "
				+ PokemonUtils.printTypes(this.types)
				+ "\nMoves: "
				+ PokemonUtils.printMoves(this.moves)
				+ "\nIVs: "
				+ PokemonUtils.printStats(this.ivs)
				+ "\nEVs: "
				+ PokemonUtils.printStats(this.evs);
	}

	public boolean equals(Pokemon aPokemon)
	{

		return aPokemon != null
				&& this.name.equalsIgnoreCase(
						aPokemon.getName())
				&& this.item.equalsIgnoreCase(
						aPokemon.getItem())
				&& this.gender == aPokemon.getGender()
				&& this.nature == aPokemon.getNature()
				&& this.ability.equalsIgnoreCase(
						aPokemon.getAbility())
				&& PokemonUtils.compareTypes(this.types,
						aPokemon.getTypes())
				&& PokemonUtils.compareMoves(this.moves,
						aPokemon.getMoves())
				&& PokemonUtils.compareStats(this.ivs,
						aPokemon.getIVs())
				&& PokemonUtils.compareStats(this.evs,
						aPokemon.getEVs());
	}

}
