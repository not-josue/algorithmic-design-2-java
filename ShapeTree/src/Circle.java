/*
 * Defines a Circle class.
 * Written By: Josue
 */
public class Circle extends Shape
{
	// attributes

	private double radius;

	// constructors

	public Circle()
	{
		this.setName();
		this.radius = 1;
		this.setRadius(this.radius);
	}

	public Circle(double aRadius)
	{
		this.setName();
		this.setRadius(aRadius);
	}

	// accessor

	public double getRadius()
	{
		return this.radius;
	}

	// mutators

	private void setName()
	{
		super.setName("Circle");
	}

	public void setRadius(double aRadius)
	{
		if (aRadius >= 1.0)
		{
			this.radius = aRadius;
			this.setArea(); // update area
		}
		else
		{
			this.radius = 1.0;
			this.setArea(); // update area
		}
	}

	private void setArea()
	{
		// formula = radius^2 * PI
		super.setArea(this.square(this.radius) * Math.PI);
	}

	// other methods

	@Override
	public String toString()
	{
		return super.toString() + "Radius: " + this.radius
				+ " Area: " + super.getArea();
	}

	public boolean equals(Circle aCircle)
	{
		return super.equals(aCircle)
				&& this.radius == aCircle.getRadius();
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
		return super.export() + this.radius;
	}

	/**
	 * Squares a given Double.
	 * 
	 * @param x
	 *            the Double to square
	 * @return the given Double squared
	 */
	private double square(double x)
	{
		return x * x;
	}

}
