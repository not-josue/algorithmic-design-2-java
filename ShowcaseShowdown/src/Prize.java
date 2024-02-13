/*
 * A class that defines what a Prize object is
 * Written By: Josue
 */
public class Prize
{
	// variables

	private String name;
	private double price;

	// constructor

	public Prize(String aName, double aPrice)
	{
		this.setName(aName);
		this.setPrice(aPrice);
	}

	// getters

	public String getName()
	{
		return this.name;
	}

	public double getPrice()
	{
		return this.price;
	}

	// mutators

	public void setName(String aName)
	{
		if (aName != null) this.name = aName;
		else this.name = "none";
	}

	public void setPrice(double aPrice)
	{
		if (aPrice >= 0) this.price = aPrice;
		else this.price = 0.0;
	}

	// other methods

	public String toString()
	{
		return "Name: " + this.name + " Price: " + this.price;
	}
}
