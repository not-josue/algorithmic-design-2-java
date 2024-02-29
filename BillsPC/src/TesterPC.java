
public class TesterPC
{

	public static PC myPC = new PC();

	public static void main(String[] args)
	{
		// add

		Box box1 = new Box();

		Box box2 = new Box("Fire");
		Box box3 = new Box("Water");
		Box box4 = new Box("Dragon");

		myPC.add(box1);
		myPC.add(box2);
		myPC.add(box3);
		myPC.add(box4);

		// current

		System.out.println("Current Tester\n");
		System.out.println(myPC.currentBox());
		myPC.prevBox();
		System.out.println(myPC.currentBox());
		myPC.nextBox();
		System.out.println(myPC.currentBox());
		myPC.nextBox();
		System.out.println(myPC.currentBox());
		System.out.println("\nEnd Current Tester\n");

		// print

		myPC.printBoxNames();
		myPC.printBoxes();

		// remove

		myPC.remove(box1.getName());
		myPC.printBoxNames();

		// printing boxes with Pokemon

		Pokemon missingno = new Pokemon();
		box2.addPokemon(missingno);
		box3.addPokemon(missingno);
		box4.addPokemon(missingno);

		myPC.printBoxes();

		// export

		myPC.exportBoxes("BoxTester.txt");

	}

}
