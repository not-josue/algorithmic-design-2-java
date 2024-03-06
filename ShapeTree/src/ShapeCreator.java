/*
 * Defines the processes for creating various Shapes by printing messages, 
 * and prompting the user for input.
 * Written By: Josue
 */

import java.util.InputMismatchException;
import java.util.Scanner;
public class ShapeCreator
{
	// constant

	public static Scanner keyboard = new Scanner(System.in);

	// methods

	/**
	 * Creates a type of Shape based on the given input.
	 * 
	 * @param input
	 *            the name of the Shape to create
	 * @return a Shape of type x
	 */
	public static Shape createShape(String input)
	{
		switch (input.toLowerCase())
		{
			case "circle" :
				return createCircle();
			case "rectangle" :
				return createRectangle();
			default :
				return createTriangle();

		}
	}

	/**
	 * Goes through the process of creating a Circle by messaging and prompting
	 * for input.
	 * 
	 * @return a Shape of type Circle
	 */
	private static Shape createCircle()
	{
		System.out
				.println("Enter the RADIUS of the Circle:");
		int input = tryInt();
		Shape aCircle = new Circle(input);
		return aCircle;
	}

	/**
	 * Goes through the process of creating a Rectangle by messaging and
	 * prompting for input.
	 * 
	 * @return a Shape of type Rectangle
	 */
	private static Shape createRectangle()
	{
		System.out.println(
				"Enter the LENGTH of the Rectangle:");
		int length = tryInt();
		System.out.println(
				"Enter the WIDTH of the Rectangle:");
		int width = tryInt();
		Shape aRectangle = new Rectangle(length, width);
		return aRectangle;
	}

	/**
	 * Goes through the process of creating a Right Triangle by messaging and
	 * prompting for input.
	 * 
	 * @return a Shape of type Right Triangle
	 */
	private static Shape createTriangle()
	{
		System.out
				.println("Enter the BASE of the Triangle:");
		int base = tryInt();
		System.out.println(
				"Enter the HEIGHT of the Triangle:");
		int height = tryInt();
		Shape aTriangle = new RightTriangle(base, height);
		return aTriangle;
	}

	/**
	 * Checks if the entered value is an Integer.
	 * 
	 * @return an Integer entered by the user
	 */
	private static int tryInt()
	{
		int value;

		while (true)
		{
			try
			{
				value = keyboard.nextInt();
				keyboard.nextLine(); // fix-up
				return value;
			}
			catch (InputMismatchException e)
			{
				keyboard.nextLine(); // fix-up
				System.out.println(
						"Invalid input, enter an Integer...");
			}

		}
	}
}
