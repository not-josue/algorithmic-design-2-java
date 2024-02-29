
public class TesterCircular
{

	public static void main(String[] args)
	{
		GenCircularLL<Integer> list = new GenCircularLL<Integer>();

		for (int i = 0; i < 10; i++)
			list.add(i);

		list.print();
		System.out.println();

		System.out.println("Head: " + list.getCurrent());
		list.goToPrev();
		System.out.println(
				"Tail: " + list.getCurrent() + "\n");

		list.remove(0);
		list.remove(9);
		list.print();

	}

}
