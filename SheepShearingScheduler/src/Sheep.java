/*
 * Defines a Sheep class.
 * Written By: Josue
 */
public class Sheep implements Comparable<Sheep>
{
	// attributes

	private String name;
	private int shearingTime;
	private int arrivalTime;
	private int shearingTimeLeft;

	// constructors

	public Sheep()
	{
		this.name = "none";
		this.shearingTime = this.shearingTimeLeft = 1;
		this.arrivalTime = 0;
	}

	public Sheep(String aName, int aShearTime,
			int anArriveTime)
	{
		this.setName(aName);
		this.setShearingTime(aShearTime);
		this.setArrivalTime(anArriveTime);
	}

	// accessors

	public String getName()
	{
		return this.name;
	}

	public int getShearingTime()
	{
		return this.shearingTime;
	}

	public int getArrivalTime()
	{
		return this.arrivalTime;
	}

	public int getShearingTimeLeft()
	{
		return this.shearingTimeLeft;
	}

	// mutators

	public void setName(String aName)
	{
		if (aName != null) this.name = aName;
		else this.name = "none";
	}

	public void setShearingTime(int aShearTime)
	{
		if (aShearTime >= 1)
			this.shearingTime = this.shearingTimeLeft = aShearTime;
		else
			this.shearingTime = this.shearingTimeLeft = 1;
	}

	public void setArrivalTime(int anArriveTime)
	{
		if (anArriveTime >= 0)
			this.arrivalTime = anArriveTime;
		else
			this.arrivalTime = 0;
	}

	// other methods

	@Override
	public String toString()
	{
		return "Name: " + this.name + ", Shear Time: "
				+ this.shearingTime + ", Arrival Time: "
				+ this.arrivalTime;
	}

	@Override
	public int compareTo(Sheep aSheep)
	{
		if (aSheep == null) return -1;
		// this shearing time is greater
		if (this.shearingTime > aSheep.getShearingTime())
			return 1;
		// this shearing time is less
		else
			if (this.shearingTime < aSheep
					.getShearingTime())
				return -1;
			// equal shearing time
			else
				return this.name
						.compareTo(aSheep.getName());
	}

	/**
	 * Decrements the shearing time left by 1.
	 */
	public void shearForOneMinute()
	{
		this.shearingTimeLeft--;
	}

	/**
	 * Checks if the shearing time left is equal to 0.
	 * 
	 * @return true if the shearing time left is equal to 0, false otherwise
	 */
	public boolean isDone()
	{
		return this.shearingTimeLeft == 0;
	}
}
