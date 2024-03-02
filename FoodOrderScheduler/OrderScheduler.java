/*
 * Defines a type OrderScheduler which uses a Min Heap to organize orders.
 * Written By: Josue
 */
public class OrderScheduler
{
	// attributes

	private MinHeap<Order> heap;
	private Order currentOrder;
	private int currentMinute;
	private int totalOrders;
	private int summedWaitingTimes;

	// constructor

	public OrderScheduler()
	{
		heap = new MinHeap<Order>();
		this.currentOrder = null;
		this.currentMinute = 0;
		this.totalOrders = 0;
		this.summedWaitingTimes = 0;
	}

	// methods

	public Order getCurrentOrder()
	{
		return this.currentOrder;
	}

	/**
	 * Adds a given Order to the Heap. If the current Order is null, the current
	 * Order is set to the given Order and is not added to the Heap. Updates the
	 * total Orders regardless of the outcome.
	 * 
	 * @param anOrder
	 *            the Order to add to the Heap
	 */
	public void addOrder(Order anOrder)
	{
		if (this.currentOrder == null)
			this.currentOrder = anOrder;
		else
			heap.add(anOrder);

		this.totalOrders++;
	}

	/**
	 * Checks if the current Order is null.
	 * 
	 * @return true if the current Order is null, false otherwise
	 */
	public boolean isDone()
	{
		return this.currentOrder == null;
	}

	/**
	 * Increments the current Minute, and cooks the current Order for 1 minute.
	 * If the current Order is done, the summed waiting times is incremented,
	 * and the current Order is to the Order removed from the Heap.
	 */
	public void advanceOneMinute()
	{
		this.currentMinute++;
		this.currentOrder.cookForOneMinute();

		if (this.currentOrder.isDone())
		{
			this.summedWaitingTimes += this.currentMinute
					- this.currentOrder.getArrivalTime();
			this.currentOrder = heap.remove();
		}
	}

	/**
	 * Calculates the average waiting time of an Order.
	 * 
	 * @return the average of the summed waiting time by the total orders
	 */
	public double getAverageWaitingTime()
	{
		return (double) this.summedWaitingTimes
				/ this.totalOrders;
	}

}
