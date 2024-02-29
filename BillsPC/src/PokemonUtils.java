/*
 * A class that defines a utility methods for a Pokemon Object
 * Written By: Josue
 */
import java.util.LinkedHashMap;
public class PokemonUtils
{
	// print methods

	/**
	 * Prints a Type array
	 * 
	 * @param arr
	 *            the Type array to be printed
	 */
	public static String printTypes(GenLL<Type> list)
	{
		// check for empty arr
		if (list.getSize() == 0) return "";

		// check if for only 1 type
		if (list.getSize() == 1)
			return "" + list.getCurrent();

		StringBuilder ret = new StringBuilder();

		for (int i = 0; i < list.getSize(); i++)
		{
			// last element
			if (i == list.getSize() - 1)
				ret.append(list.getAt(i));
			else
				ret.append(list.getAt(i) + "/");
		}

		return ret.toString();
	}

	/**
	 * Print a String array that contains a Pokemon Object's moves
	 * 
	 * @param arr
	 *            the String array to be printed
	 */
	public static String printMoves(String[] arr)
	{
		// check for empty arr
		if (arr.length == 0) return "";

		StringBuilder ret = new StringBuilder();

		for (int i = 0; i < arr.length; i++)
		{
			// last element
			if (i == arr.length - 1) ret.append(arr[i]);
			else ret.append(arr[i] + ", ");
		}

		return ret.toString();
	}

	/**
	 * Prints a HashMap<Stats, Integer> of a Pokemon Objects IVs or EVs
	 * 
	 * @param map
	 *            the HashMap<Stats, Integer> to print
	 */
	public static String printStats(
			LinkedHashMap<Stats, Integer> map)
	{
		// check for empty map
		if (map.size() == 0) return "";

		StringBuilder ret = new StringBuilder();

		// initialize a size and counter variable to iterate
		int size = map.size();
		int counter = 0;

		for (Stats stat : map.keySet())
		{
			// last element
			if (counter == size - 1)
				ret.append(stat + ": " + map.get(stat));
			else
				ret.append(
						stat + ": " + map.get(stat) + " ");
			counter++;
		}

		return ret.toString();
	}

	// equals methods

	/**
	 * Compares 2 GenLL<Type> to each other
	 * 
	 * @param list1
	 *            the first GenLL<Type> you want to compare
	 * @param list2
	 *            the second GenLL<Type> you want to compare
	 * @return true if all Objects in the lists are the same, false otherwise
	 */
	public static boolean compareTypes(GenLL<Type> list1,
			GenLL<Type> list2)
	{
		// check for same size
		if (list1.getSize() != list2.getSize())
			return false;

		// iterate and compare
		for (int i = 0; i < list1.getSize(); i++)
		{
			if (list1.getAt(i) != list2.getAt(i))
				return false;
		}

		return true;
	}

	/**
	 * Compares 2 String arrays to each other
	 * 
	 * @param arr1
	 *            the first String array you want to compare
	 * @param arr2
	 *            the second String array you want to compare
	 * @return true if all Strings in the arrays are the same, false otherwise
	 */
	public static boolean compareMoves(String[] arr1,
			String[] arr2)
	{
		// check for same size
		if (arr1.length != arr2.length) return false;

		// iterate and compare
		for (int i = 0; i < arr1.length; i++)
		{
			if (!arr1[i].equalsIgnoreCase(arr2[i]))
				return false;
		}

		return true;
	}

	/**
	 * Compares 2 Linked Hash Maps <Stats, Integer>
	 * 
	 * @param map1
	 *            the first Linked Hash Map to compare
	 * @param map2
	 *            the second Linked Hash Map to compare
	 * @return true if the integer value of the same Stats are equal, false
	 *         otherwise
	 */
	public static boolean compareStats(
			LinkedHashMap<Stats, Integer> map1,
			LinkedHashMap<Stats, Integer> map2)
	{
		// check for same size
		if (map1.size() != map2.size()) return false;

		// iterate and check
		for (Stats stat : map1.keySet())
		{
			int first = map1.get(stat);
			int second = map2.get(stat);
			if (first != second) return false;
			// this does not work for evs
			// if (map1.get(stat) != map2.get(stat)) return false;
		}

		return true;
	}

}
