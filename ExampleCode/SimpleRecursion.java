/*
 * Examples of how recursion is used to solve algorithmic problems.
 * Written By: Josue
 */
public class SimpleRecursion
{

	public static void main(String[] args)
	{
		countDown(5);
		System.out.println("Factorial: " + factorial(3));
		System.out.println("GCD: " + gcd(3, 8));
		System.out
				.println("Fibonacci Sequence: " + fibo(8));
	}

	/**
	 * Prints integers in descending values starting from a given integer, to 0.
	 * If the given integer is less than 0, no action is taken.
	 * 
	 * @param i
	 *            an integer
	 */
	static void countDown(int i)
	{
		if (i < 0) return;
		System.out.println(i);
		countDown(i - 1);
	}

	/**
	 * Calculates the factorial of a given integer recursively.
	 * 
	 * @param number
	 *            an integer
	 * @return the factorial of a given integer, or 1 if the given integer is
	 *         less than or equal to 0
	 */
	static int factorial(int number)
	{
		if (number <= 0) return 1;
		else return number * factorial(number - 1);
	}

	/**
	 * Calculates the greatest common denominator of two given integers
	 * recursively.
	 * 
	 * @param a
	 *            the first integer
	 * @param b
	 *            the second integer
	 * @return the gcd of two given integers, or the first given integer if the
	 *         second given integer is 0
	 */
	static int gcd(int a, int b)
	{
		if (b == 0) return a;
		else return gcd(b, a % b);
	}

	/**
	 * Calculates the number in the fibonacci sequence recursively at a given
	 * index.
	 * 
	 * @param index
	 *            the index of the sequence
	 * @return an integer if the given index is greater than 2, 1 if the given
	 *         index is either 1 or 2
	 */
	static int fibo(int index)
	{
		if (index == 1 || index == 2) return 1;
		else return fibo(index - 1) + fibo(index - 2);
	}

}
