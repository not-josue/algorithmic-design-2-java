/*
 * A class that defines what a Process Object is
 * Written By: Josue
 */
public class Process
{
	// attributes

	private String name;
	private double completionTime;

	// constructor

	public Process()
	{
		this.name = "none";
		this.completionTime = 0.0;
	}

	public Process(String aName, double aTime)
	{
		this.setName(aName);
		this.setCompletionTime(aTime);
	}

	// accessors

	public String getName()
	{
		return this.name;
	}

	public double getCompletionTime()
	{
		return this.completionTime;
	}

	// mutators

	public void setName(String aName)
	{
		if (aName != null) this.name = aName;
		else this.name = "none";
	}

	public void setCompletionTime(double aTime)
	{
		if (aTime > 0.0) this.completionTime = aTime;
		else this.completionTime = 0.0;
	}

	// other methods

	public String toString()
	{
		return "Process Name: " + this.name
				+ " Completion Time: "
				+ this.completionTime;
	}

}
