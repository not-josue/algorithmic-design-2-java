/*
 * A Generic Stack interface.
 * Written By: Josue
 */
public interface StackI<T>
{
	public void push(T aData);
	public T pop();
	public T peek();
	public void print();
}
