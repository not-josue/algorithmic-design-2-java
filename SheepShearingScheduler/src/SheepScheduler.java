/*
 * Defines a type SheepScheduler which uses a Min Heap to schedule 
 * Sheep for based on their shearing time.
 * Written By: Josue
 */
public class SheepScheduler
{
	// attributes

	private MinHeap<Sheep> heap;
	private Sheep currentSheep;

	// constructor

	public SheepScheduler()
	{
		heap = new MinHeap<Sheep>();
		this.currentSheep = null;
	}

	// methods

	/**
	 * Adds a Sheep to the heap if the current Sheep is not null.
	 * 
	 * @param aSheep
	 *            the Sheep to add to the heap
	 */
	public void addSheep(Sheep aSheep)
	{
		if (this.currentSheep == null)
			this.currentSheep = aSheep;
		else
			heap.add(aSheep);
	}

	/**
	 * Checks if the current Sheep is null.
	 * 
	 * @return true if the current Sheep is null, false otherwise
	 */
	public boolean isDone()
	{
		return this.currentSheep == null;
	}

	/**
	 * Shears the current Sheep for a minute. If the current Sheep is done, the
	 * current Sheep is printed, and replaced with the next Sheep in the heap.
	 */
	public void advanceOneMinute()
	{
		currentSheep.shearForOneMinute();

		if (currentSheep.isDone())
		{
			System.out.println(this.currentSheep);
			currentSheep = heap.remove();
		}
	}

}
