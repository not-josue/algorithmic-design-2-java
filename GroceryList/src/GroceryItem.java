/*
 * A class that defines a GroceryItem Object
 * Written By: Josue
 */
public class GroceryItem
{
	// attributes

	private String name;
	private double value;

	// constructors

	public GroceryItem()
	{
		this.name = "none";
		this.value = 0;
	}

	public GroceryItem(String aName, double aValue)
	{
		this.setName(aName);
		this.setValue(aValue);
	}

	// getters

	public String getName()
	{
		return this.name;
	}

	public double getValue()
	{
		return this.value;
	}

	// setters

	public void setName(String aName)
	{
		if (aName != null) this.name = aName;
		else this.name = "none";
	}

	public void setValue(double aValue)
	{
		if (aValue > 0) this.value = aValue;
		else this.value = 0;
	}

	// other methods

	public String toString()
	{
		return "Grocery Item Name: " + this.name + " Value: " + this.value;
	}

	public boolean equals(GroceryItem object)
	{
		return object != null && this.name.equals(object.getName())
				&& this.value == object.getValue();
	}
}
