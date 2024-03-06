/*
 * Utilizes a Generic Linked BST to store, and perform operations on Shapes.
 * Written By: Josue
 */
import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class ShapeManager
{
	// constant

	public static final String DELIM = "\t";
	public static final int CIRCLE_SPLIT = 2;
	public static final int RECT_SPLIT = 3;
	public static final int TRI_SPLIT = 3;

	// attributes

	private LinkedBST<Shape> tree;

	// constructor

	public ShapeManager()
	{
		tree = new LinkedBST<Shape>();
	}

	// methods

	/**
	 * Adds a given Shape to the tree.
	 * 
	 * @param aShape
	 *            the Shape to add to the tree
	 */
	public void addShape(Shape aShape)
	{
		tree.add(aShape);
	}

	/**
	 * Removes a given Shape from the tree.
	 * 
	 * @param aShape
	 *            the Shape to remove from the tree
	 */
	public void removeShape(Shape aShape)
	{
		tree.remove(aShape);
	}

	/**
	 * Searches for a given Shape in the tree.
	 * 
	 * @param aShape
	 *            the Shape to find for in the tree
	 * @return true if the Shape is found, false otherwise
	 */
	public boolean search(Shape aShape)
	{
		return tree.search(aShape);
	}

	/**
	 * Retrieves the largest area in the tree.
	 * 
	 * @return the largest area
	 */
	public Shape getMaxArea()
	{
		return tree.getMax();
	}

	/**
	 * Removes Shapes whose area are greater than the given area.
	 * 
	 * @param anArea
	 *            the threshold / max range of the tree
	 */
	public void removeGreaterThan(double anArea)
	{
		Shape temp = new Shape("temp", anArea);
		tree.removeGreaterThan(temp);
	}

	/**
	 * Reads a given file, tries to find the file, checks for formatting, and
	 * adds Shapes to the tree. If the file is not found, a message is printed
	 * and no further action is taken.
	 * 
	 * @param filename
	 *            the file to read
	 */
	public void readDB(String filename)
	{
		File file = new File(filename);

		// file not found
		if (!file.exists())
			System.out.println("Sorry, " + filename
					+ " was not found...\n");
		else
		{
			try (Scanner sc = new Scanner(file))
			{
				while (sc.hasNextLine())
				{
					String fileline = sc.nextLine();

					// check for shape name

					// circle
					if (fileline.toLowerCase()
							.startsWith("circle"))
					{
						// split by delim
						String split[] = fileline
								.split(DELIM);
						// check format
						if (split.length == CIRCLE_SPLIT
								&& isInt(split[1]))
						{
							// create and add
							Shape aCircle = parseCircle(
									split);
							tree.add(aCircle);
						}
						else continue;
					}
					// rectangle
					else
						if (fileline.toLowerCase()
								.startsWith("rectangle"))
					{
						// split by delim
						String split[] = fileline
								.split(DELIM);
						// check format
						if (split.length == RECT_SPLIT
								&& isInt(split[1])
								&& isInt(split[2]))
						{
							// create and add
							Shape aRectangle = parseRectangle(
									split);
							tree.add(aRectangle);
						}
						else continue;
					}
						// right triangle
						else
							if (fileline.toLowerCase()
									.startsWith(
											"right triangle"))
					{
						// split by delim
						String split[] = fileline
								.split(DELIM);
						// check format
						if (split.length == TRI_SPLIT
								&& isInt(split[1])
								&& isInt(split[2]))
						{
							// create and add
							Shape aTriangle = parseTriangle(
									split);
							tree.add(aTriangle);
						}
						else continue;
					}
							else continue;
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * Creates an instance of a Circle from a given String array.
	 * 
	 * @param array
	 *            an array which contains the radius at index 1
	 * @return a Shape to add to the tree
	 */
	private Shape parseCircle(String[] array)
	{
		Shape aCircle = new Circle(
				Integer.valueOf(array[1]));
		return aCircle;
	}

	/**
	 * Creates an instance of a Rectangle from a given String array.
	 * 
	 * @param array
	 *            an array which contains the length at index 1, and the width
	 *            at index 2
	 * @return a Shape to add to the tree
	 */
	private Shape parseRectangle(String[] array)
	{
		Shape aRect = new Rectangle(
				Integer.valueOf(array[1]),
				Integer.valueOf(array[2]));
		return aRect;
	}

	/**
	 * Creates an instance of Right Triangle from a given String array.
	 * 
	 * @param array
	 *            an array which contains the base at index 1, and the height at
	 *            index 2
	 * @return a Shape to add to the tree
	 */
	private Shape parseTriangle(String[] array)
	{
		Shape aTri = new RightTriangle(
				Integer.valueOf(array[1]),
				Integer.valueOf(array[2]));
		return aTri;
	}

	/**
	 * Attempts to convert a given String to an Integer.
	 * 
	 * @param value
	 *            a String to attempt to convert
	 * @return true if the given String can be converted to an Integer, false
	 *         otherwise
	 */
	private boolean isInt(String value)
	{
		try
		{
			Integer.valueOf(value);
		}
		catch (InputMismatchException e)
		{
			return false;
		}

		return true;
	}

	/**
	 * Creates/overwrites a file using a given file name and exports the tree.
	 * 
	 * @param filename
	 *            the name of the file to create/overwrite
	 */
	public void writeDB(String filename)
	{
		tree.exportTree(filename);

	}

	/**
	 * Prints the Shapes in the tree using the In-Order algorithm.
	 */
	public void printInOrder()
	{
		tree.printInorder();
	}

	/**
	 * Prints the Shapes in the tree using the Pre-Order algorithm.
	 */
	public void printPreOrder()
	{
		tree.printPreorder();
	}

	/*
	 * Prints the Shapes in the tree using the Post-Order algorithm.
	 */
	public void printPostOrder()
	{
		tree.printPostOrder();
	}

}
