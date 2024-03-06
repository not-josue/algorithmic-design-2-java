/*
 * Defines a Rectangle class.
 * Written By: Josue
 */
public class Rectangle extends Shape
{
	// attributes

	private double length;
	private double width;

	// constructors

	public Rectangle()
	{
		this.setName();
		this.length = this.width = 1.0;
		this.setArea();
	}

	public Rectangle(double aLength, double aWidth)
	{
		this.setName();
		this.setLength(aLength);
		this.setWidth(aWidth);
	}

	// accessors

	public double getLength()
	{
		return this.length;
	}

	public double getWidth()
	{
		return this.width;
	}

	// mutators

	private void setName()
	{
		super.setName("Rectangle");
	}

	public void setLength(double aLength)
	{
		if (aLength >= 1.0) this.length = aLength;
		else this.length = 1.0;

		// check if width has already been set
		if (this.width >= 1.0) this.setArea(); // update area
	}

	public void setWidth(double aWidth)
	{
		if (aWidth >= 1.0) this.width = aWidth;

		else this.width = 1.0;

		// check if length has already been set
		if (this.length >= 1.0) this.setArea(); // update area
	}

	private void setArea()
	{
		// formula = length * width
		super.setArea(this.length * this.width);
	}

	// other method

	@Override
	public String toString()
	{
		return super.toString() + " Length: " + this.length
				+ " Width: " + this.width + " Area: "
				+ super.getArea();
	}

	public boolean equals(Rectangle aRectangle)
	{
		return super.equals(aRectangle)
				&& this.length == aRectangle.getLength()
				&& this.width == aRectangle.getWidth();
	}

	/**
	 * Retrieves data to export to a file in a specific format. Overrides Shapes
	 * method.
	 * 
	 * @return a String that represents data to export
	 */
	@Override
	public String export()
	{
		return super.export() + this.length + DELIM
				+ this.width;
	}
}
