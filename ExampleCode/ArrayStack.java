/*
 * An example of a Generic Array Stack.
 * Written By: Josue
 */
public class ArrayStack<T> implements StackI<T>
{
	// attributes

	private T[] stack;
	private int head; // first null element

	public static final int DEF_SIZE = 100;

	// constructors

	public ArrayStack()
	{
		init(DEF_SIZE);
	}

	public ArrayStack(int size)
	{
		init(size);
	}

	/**
	 * Initializes the array Stack. If the given integer is at least 1, the
	 * Stack size is set to the given integer, otherwise the Stack size is set
	 * to a default size.
	 * 
	 * @param size
	 *            the length of the array Stack
	 */
	public void init(int size)
	{
		if (size >= 1) stack = (T[]) (new Object[size]);
		else stack = (T[]) (new Object[DEF_SIZE]);
	}

	// methods

	/**
	 * Adds data to the array Stack by setting the given data as the head, and
	 * then updating head reference to null. If the array Stack is full, no
	 * action is taken.
	 */
	public void push(T aData)
	{
		// full array
		if (head >= stack.length) return;
		stack[head] = aData;
		head++;
	}

	/**
	 * "Removes" an element by setting the head reference to it which represents
	 * an out of bounds element.
	 * 
	 * @return the last element in the array Stack or null if the array Stack is
	 *         empty
	 */
	public T pop()
	{
		// empty array
		if (head == 0) return null;
		T ret = stack[head - 1];
		head--;
		return ret;
	}

	/**
	 * Retrieves the last element in the array Stack.
	 * 
	 * @return the last element in the array Stack or null if the array Stack is
	 *         empty
	 */
	public T peek()
	{
		// empty list
		if (head == 0) return null;
		return stack[head - 1];
	}

	/**
	 * Iterates and prints all elements in the array Stack.
	 */
	public void print()
	{
		for (int i = head - 1; i >= 0; i--)
			System.out.println(stack[i]);
	}
}
