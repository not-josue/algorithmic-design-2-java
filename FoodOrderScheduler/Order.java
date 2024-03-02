/*
 * Defines a type Order.
 * Written By: Josue
 */
public class Order implements Comparable<Order>
{
	// attributes

	private String customer;
	private String foodOrder;
	private int cookingTime;
	private int arrivalTime;
	private int cookingTimeLeft; // initially set = cooking time

	// constructors

	public Order()
	{
		this.customer = "none";
		this.foodOrder = "none";
		this.cookingTime = 1;
		this.arrivalTime = 0;
		this.cookingTimeLeft = this.cookingTime;
	}

	public Order(String aCustomer, String anOrder,
			int aCookTime, int anArriveTime)
	{
		this.setCustomer(aCustomer);
		this.setFoodOrder(anOrder);
		this.setCookingTime(aCookTime);
		this.setArrivalTime(anArriveTime);
	}

	// accessors

	public String getCustomer()
	{
		return this.customer;
	}

	public String getFoodOrder()
	{
		return this.foodOrder;
	}

	public int getCookingTime()
	{
		return this.cookingTime;
	}

	public int getArrivalTime()
	{
		return this.arrivalTime;
	}

	public int getCookingTimeLeft()
	{
		return this.cookingTimeLeft;
	}

	// mutators

	public void setCustomer(String aCustomer)
	{
		if (aCustomer != null) this.customer = aCustomer;
		else this.customer = "none";
	}

	public void setFoodOrder(String anOrder)
	{
		if (anOrder != null) this.foodOrder = anOrder;
		else this.foodOrder = "none";
	}

	public void setCookingTime(int aTime)
	{
		if (aTime >= 1)
		{
			// set both cooking time and cooking time left
			this.cookingTime = this.cookingTimeLeft = aTime;
		}
		// set both cooking time and cooking time left
		else this.cookingTime = this.cookingTimeLeft = 1;
	}

	public void setArrivalTime(int aTime)
	{
		if (aTime >= 1) this.arrivalTime = aTime;
		else this.arrivalTime = 0;
	}

	// other methods

	@Override
	public String toString()
	{
		return "Customer: " + this.customer + ", Order: "
				+ this.foodOrder + ", Cooking Time Left: "
				+ this.cookingTimeLeft;
	}

	@Override
	public int compareTo(Order anOrder)
	{
		if (anOrder == null) return -1;
		// this cooking time is greater
		if (this.cookingTime > anOrder.getCookingTime())
			return 1;
		// this cooking time is less
		else
			if (this.cookingTime < anOrder.getCookingTime())
				return -1;
			// same value
			else
				return this.foodOrder
						.compareTo(anOrder.getFoodOrder());
	}

	/**
	 * Decrements the cooking time left.
	 */
	public void cookForOneMinute()
	{
		this.cookingTimeLeft--;
	}

	/**
	 * Checks if the cooking time left is 0.
	 * 
	 * @return true if the cooking time left is 0, false otherwise
	 */
	public boolean isDone()
	{
		return this.cookingTimeLeft == 0;
	}

}
