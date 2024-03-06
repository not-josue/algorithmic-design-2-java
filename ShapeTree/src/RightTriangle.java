/*
 * Defines a Right Triangle class.
 * Written By: Josue
 */
public class RightTriangle extends Shape
{
	// attributes

	private double base;
	private double height;

	// constructors

	public RightTriangle()
	{
		this.setName();
		this.base = this.height = 1.0;
		this.setArea();
	}

	public RightTriangle(double aBase, double aHeight)
	{
		this.setName();
		this.setBase(aBase);
		this.setHeight(aHeight);
	}

	// accessors

	public double getBase()
	{
		return this.base;
	}

	public double getHeight()
	{
		return this.height;
	}

	// mutators

	private void setName()
	{
		super.setName("Right Triangle");
	}

	public void setBase(double aBase)
	{
		if (aBase >= 1.0) this.base = aBase;
		else this.base = 1.0;

		// check if height has been set
		if (this.height >= 1.0) this.setArea();
	}

	public void setHeight(double aHeight)
	{
		if (aHeight >= 1.0) this.height = aHeight;
		else this.height = 1.0;

		// check if base has been set
		if (this.base >= 1.0) this.setArea();
	}

	private void setArea()
	{
		// formula = 0.5 * base * height
		super.setArea(this.halve(this.base * this.height));
	}

	// other methods

	@Override
	public String toString()
	{
		return super.toString() + "Base: " + this.base
				+ " Height: " + this.height + " Area: "
				+ super.getArea();
	}

	public boolean equals(RightTriangle aTriangle)
	{
		return aTriangle != null && super.equals(aTriangle)
				&& this.base == aTriangle.getBase()
				&& this.height == aTriangle.getHeight();
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
		return super.export() + this.base + DELIM
				+ this.height;
	}

	/**
	 * Halves a given Double.
	 * 
	 * @param x
	 *            the Double to halve
	 * @return the given Double halved
	 */
	private double halve(double x)
	{
		return 0.5 * x;
	}
}
