/*
 * Defines a type Fruit.
 * Written By: Josue
 */
public class Fruit implements Comparable<Fruit>
{
	// attributes

	private String type;
	private double weight;

	// constructors

	public Fruit()
	{
		this.type = "apple";
		this.weight = 1.0;
	}

	public Fruit(String aType, double aWeight)
	{
		this.setType(aType);
		this.setWeight(aWeight);
	}

	// accessors

	public String getType()
	{
		return this.type;
	}

	public double getWeight()
	{
		return this.weight;
	}

	// mutators

	public void setType(String aType)
	{
		if (aType != null) this.type = aType;
		else this.type = "apple";
	}

	public void setWeight(double aWeight)
	{
		if (aWeight > 0.0) this.weight = aWeight;
		else this.weight = 1.0;
	}

	@Override
	public String toString()
	{
		return "Type: " + this.type + " Weight: "
				+ this.weight;
	}

	@Override
	public int compareTo(Fruit aFruit)
	{
		if (aFruit == null) return -1;
		// this Fruit weighs more
		if (this.weight > aFruit.getWeight()) return 1;
		// this Fruit weighs less
		else
			if (this.weight < aFruit.getWeight()) return -1;
			// even weight
			else
				return this.type
						.compareTo(aFruit.getType());
	}
}
