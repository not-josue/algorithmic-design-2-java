/*
 * Stores various Pokemon in a Linked List.
 * Written By: Josue
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class Box
{
	// attributes

	private GenLL<Pokemon> list;
	private String name;

	// constructors

	public Box()
	{
		list = new GenLL<Pokemon>();
		this.name = "Generic Box";
	}

	public Box(String aName)
	{
		list = new GenLL<Pokemon>();
		this.setName(aName);
	}

	// getters

	public String getName()
	{
		return this.name;
	}

	/**
	 * Retrieves the size of the list.
	 * 
	 * @return the size of the list
	 */
	public int getSize()
	{
		return list.getSize();
	}

	// setters

	public void setName(String aName)
	{
		if (aName != null) this.name = aName;
		else this.name = "Generic Box";
	}

	// methods

	/**
	 * Removes all Pokemon from the list.
	 */
	public void clearBox()
	{
		this.list = new GenLL<Pokemon>();
	}

	/**
	 * Prints all Pokemon in the list. If the list is empty a message is printed
	 * and no further action is taken.
	 */
	public void print()
	{
		if (this.list.getSize() == 0)
		{
			System.out.println(
					this.name + " is currently empty...");
			return;
		}
		else
		{
			System.out.println(
					"Box Name: " + this.name + "\n");
			this.list.print();
		}
	}

	/**
	 * Adds a given Pokemon to the list. If the size of the list is greater than
	 * 1, the list is sorted. If the given Pokemon is null, no action is taken.
	 * 
	 * @param aPokemon
	 *            the Pokemon to add to the list
	 */
	public void addPokemon(Pokemon aPokemon)
	{
		if (aPokemon != null)
		{
			list.add(aPokemon);

			if (this.list.getSize() > 1)
				this.mergeSort(this.list);
		}

		else return;
	}

	/**
	 * Removes a given Pokemon from the list. A message is given if removal was
	 * successful or if removal was unsuccessful.
	 * 
	 * @param aName
	 *            the name of the Pokemon to remove from the list
	 */
	public void removePokemon(String aName)
	{
		// reset current
		list.reset();

		// iterate
		while (list.hasMore())
		{
			// update current
			String current = list.getCurrent().getName();

			if (current.equalsIgnoreCase(aName))
			{
				list.removeCurrent();
				System.out.println(aName
						+ " has been successfully removed\n");
				return;
			}

			list.goToNext();
		}
		// Pokemon not found
		System.out.println(aName + " was not found...\n");
	}

	/**
	 * Iterates the list and writes each Pokemon to a given file. If the list is
	 * empty, a message is printed and no further action is taken.
	 * 
	 * @param filename
	 *            the name of the file to create / overwrite
	 */
	public void exportBox(String filename)
	{
		if (list.getSize() == 0)
		{
			System.out.println(
					this.name + " is currently empty...\n");
			return;
		}

		try (PrintWriter fileWriter = new PrintWriter(
				new FileOutputStream(filename)))
		{
			// reset current
			list.reset();

			while (list.hasMore())
			{
				// get current
				Pokemon aPokemon = list.getCurrent();

				fileWriter.println(aPokemon + "\n");

				// update current
				list.goToNext();
			}
			System.out.println(this.name
					+ " has been successfully EXPORTED to "
					+ filename + "!!!");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Adds the list's content to an existing given file. If the list is empty,
	 * a message is printed and no further action is taken. If the file does not
	 * exist a message is printed and no further action is taken.
	 * 
	 * @param filename
	 *            the name of an existing file
	 */
	public void appendBox(String filename)
	{
		if (list.getSize() == 0)
		{
			System.out.println(
					this.name + " is currently empty...\n");
			return;
		}

		try
		{
			File file = new File(filename);

			if (!file.exists())
			{
				System.out.println("File not found...\n");
				return;
			}

			try (PrintWriter printWriter = new PrintWriter(
					new BufferedWriter(
							new FileWriter(file, true))))
			{
				list.reset();

				while (list.hasMore())
				{
					Pokemon aPokemon = list.getCurrent();
					printWriter.println(aPokemon + "\n");

					list.goToNext();
				}

				System.out.println(this.name
						+ " has been successfully APPENDED to "
						+ filename + "\n");
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Utilizes the merge sort algorithm to recursively sort the list in
	 * ascending order by each Pokemon's name.
	 * 
	 * @param list
	 *            the list to sort
	 */
	private void mergeSort(GenLL<Pokemon> list)
	{
		int size = list.getSize();
		if (size <= 1) return; // list has been halved to single elements

		// calculate mid
		int mid = size / 2;

		// initialize sub lists
		GenLL<Pokemon> left = new GenLL<Pokemon>();
		GenLL<Pokemon> right = new GenLL<Pokemon>();

		// populate left list
		for (int i = 0; i < mid; i++)
		{
			Pokemon current = list.getAt(i);
			left.add(current);
		}

		// populate right list
		for (int i = mid; i < size; i++)
		{
			Pokemon current = list.getAt(i);
			right.add(current);
		}

		// recursive call to halve the lists
		mergeSort(left);
		mergeSort(right);

		// merge to a single list
		merge(left, right, list);

	}

	/**
	 * Merges two given sub lists to a bigger list in ascending order.
	 * 
	 * @param left
	 *            a sub list
	 * @param right
	 *            a sub list
	 * @param list
	 *            the list to merge into
	 */
	private void merge(GenLL<Pokemon> left,
			GenLL<Pokemon> right, GenLL<Pokemon> list)
	{
		int leftSize = left.getSize();
		int rightSize = right.getSize();

		int i = 0; // left pointer
		int j = 0; // right pointer
		int k = 0; // merged list pointer

		// compare and add the smaller value
		while (i < leftSize && j < rightSize)
		{
			Pokemon leftPokemon = left.getAt(i);
			Pokemon rightPokemon = right.getAt(j);

			// left is smaller
			if (leftPokemon.getName().compareToIgnoreCase(
					rightPokemon.getName()) < 0)
			{
				list.setAt(k, leftPokemon);
				i++;
				k++;
			}
			// right is smaller
			else
			{
				list.setAt(k, rightPokemon);
				j++;
				k++;
			}
		}

		// add the remaining left elements
		while (i < leftSize)
		{
			list.setAt(k, left.getAt(i));
			i++;
			k++;
		}

		// add the remaining right elements
		while (j < rightSize)
		{
			list.setAt(k, right.getAt(j));
			j++;
			k++;
		}
	}

	/**
	 * Resets the current pointer to the head of the list.
	 */
	public void reset()
	{
		list.reset();
	}

	/**
	 * Checks if the current Pokemon is null.
	 * 
	 * @return true if the current Pokemon is null, false otherwise
	 */
	public boolean hasMore()
	{
		return list.hasMore();
	}

	/**
	 * Retrieves the current Pokemon.
	 * 
	 * @return the current Pokemon or null
	 */
	public Pokemon getCurrent()
	{
		return list.getCurrent();
	}

	/**
	 * Moves the current pointer to the next Pokemon.
	 */
	public void goToNext()
	{
		list.goToNext();
	}

	@Override
	public String toString()
	{
		return "Box Name: " + this.name;
	}

}
