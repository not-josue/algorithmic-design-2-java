/*
 * Stores various Boxes in a Circular Doubly Linked List.
 * Written By: Josue
 */
import java.io.FileOutputStream;
import java.io.PrintWriter;
public class PC
{
	// attributes

	private GenCircularLL<Box> list;

	// constructor

	public PC()
	{
		list = new GenCircularLL<Box>();
	}

	// methods

	/**
	 * Retrieves the size of the list.
	 * 
	 * @return size of the list
	 */
	public int getSize()
	{
		return this.list.getSize();
	}

	/**
	 * Inserts a given Box to the list.
	 * 
	 * @param aBox
	 *            the box to insert
	 */
	public void add(Box aBox)
	{
		list.add(aBox);
	}

	/**
	 * Iterates and removes a Box if the Box's name matches the given name. If
	 * the list is empty, a message is printed and no further action is taken.
	 * 
	 * @param aName
	 *            the name of the Box to remove
	 */
	public void remove(String aName)
	{
		if (list.getSize() <= 0)
		{
			System.out.println(
					"The PC is currently empty...");
			return;
		}

		list.reset();

		do
		{
			String current = list.getCurrent().getName();

			if (current.equalsIgnoreCase(aName))
			{
				list.removeCurrent();
				System.out.println(aName
						+ " has been successfully removed from the PC!!!");
				return;
			}

			list.goToNext();
		}
		while (list.hasMore());
		// box not found
		System.out.println(
				aName + " was not found in the PC...");
	}

	/**
	 * Retrieves the current Box.
	 * 
	 * @return the current Box
	 */
	public Box currentBox()
	{
		return list.getCurrent();
	}

	/**
	 * Moves the current pointer to the next Box. If the size of the list is 0
	 * or 1, a message is printed and no further action is taken.
	 */
	public void nextBox()
	{
		if (list.getSize() == 0)
		{
			System.out.println(
					"There are no Boxes in the PC...\n");
			return;
		}
		else if (list.getSize() == 1)
		{
			System.out.println(
					"There is only 1 Box in the PC...\n");
			return;
		}
		else list.goToNext();
	}

	/**
	 * Moves the current pointer to the previous Box. If the size of the list is
	 * 0 or 1, a message is printed and no further action is taken.
	 */
	public void prevBox()
	{
		if (list.getSize() == 0)
		{
			System.out.println(
					"There are no Boxes in the PC...\n");
			return;
		}
		else if (list.getSize() == 1)
		{
			System.out.println(
					"There is only 1 Box in the PC...\n");
			return;
		}
		else list.goToPrev();
	}

	/**
	 * Prints all Boxes in the list. If the list is empty, a message is printed
	 * and no further action is taken.
	 */
	public void printBoxes()
	{
		if (list.getSize() == 0)
		{
			System.out.println(
					"The PC is currently empty...\n");
			return;
		}
		else
		{
			for (int i = 0; i < list.getSize(); i++)
				list.getAt(i).print();
			System.out.println();
		}
	}

	/**
	 * Prints the name of all Boxes in the list. If the list is empty, a
	 * messages is printed and no further action is taken.
	 */
	public void printBoxNames()
	{
		if (list.getSize() == 0)
		{
			System.out.println(
					"The PC is currently empty...\n");
			return;
		}
		else
		{
			list.print();
			System.out.println();
		}
	}

	/**
	 * Removes all Boxes from the list.
	 */
	public void clear()
	{
		list = new GenCircularLL<Box>();
	}

	/**
	 * Iterates the list and writes each Box to a given file. If the list is
	 * empty, a message is printed and no further action is taken.
	 * 
	 * @param filename
	 *            the name of the file create / overwrite
	 */
	public void exportBoxes(String filename)
	{
		if (list.getSize() == 0)
		{
			System.out.println(
					"The PC is currently empty...");
			return;
		}

		try (PrintWriter fileWriter = new PrintWriter(
				new FileOutputStream(filename)))
		{

			// reset current
			list.reset();

			do
			{
				// get current
				Box aBox = this.list.getCurrent();

				fileWriter.println(aBox + "\n");

				// write pokemon

				aBox.reset();

				while (aBox.hasMore())
				{
					Pokemon aPokemon = aBox.getCurrent();
					fileWriter.println(aPokemon + "\n");

					aBox.goToNext();
				}

				// update current
				list.goToNext();
			}
			while (this.list.hasMore());
			System.out.println(
					"All Boxes have been successfully EXPORTED to "
							+ filename + "!!!");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
