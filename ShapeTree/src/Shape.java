/*
 * Defines a Shape class.
 * Written By: Josue
 */
public class Shape implements Comparable<Shape>
{
	// constant

	public static final String DELIM = "\t";

	// attributes

	private String name;
	private double area;

	// constructors

	public Shape()
	{
		this.name = "none";
		this.area = 1.0;
	}

	public Shape(String aName, double anArea)
	{
		this.setName(aName);
		this.setArea(anArea);
	}

	// accessors

	public String getName()
	{
		return this.name;
	}

	public double getArea()
	{
		return this.area;
	}

	// mutators

	public void setName(String aName)
	{
		if (aName != null) this.name = aName;
		else this.name = "none";
	}

	public void setArea(double anArea)
	{
		if (anArea > 0.0) this.area = anArea;
		else this.area = 1.0;
	}

	// other methods

	@Override
	public String toString()
	{
		return this.name + " ";
	}

	public boolean equals(Shape aShape)
	{
		return aShape != null
				&& this.name
						.equalsIgnoreCase(aShape.getName())
				&& this.area == aShape.getArea();
	}

	@Override
	public int compareTo(Shape aShape)
	{
		if (aShape == null) return -1;
		// this area is greater
		if (this.area > aShape.getArea()) return 1;
		// this area is less
		else if (this.area < aShape.getArea()) return -1;
		// areas are equal
		else return this.name.compareTo(aShape.getName());
	}

	/**
	 * Retrieves data to export to a file in a specific format.
	 * 
	 * @return a String that represents data to export
	 */
	public String export()
	{
		return this.name + DELIM;
	}
}
