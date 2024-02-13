/*
 * 
 * A class that defines a Process Scheduler which is a Linked List <Process>
 * Written By: Josue
 */
public class ProcessScheduler
{
	// attributes

	private LLQueue<Process> processes;
	private Process currentProcess;

	// constructor

	public ProcessScheduler()
	{
		processes = new LLQueue<Process>();
		currentProcess = null;
	}

	// methods

	/**
	 * Retrieves the current running Process in the Process Scheduler.
	 * 
	 * @return the Process that is currently running
	 */
	public Process getCurrentProcess()
	{
		return this.currentProcess;
	}

	/**
	 * Adds a given Process to the Process Scheduler. If the current Process is
	 * null, the current Process is set to the given Process, and does not add
	 * it to the Process Scheduler.
	 * 
	 * @param aProcess
	 *            a Process to either add to the Process Scheduler, or set as
	 *            the current Process
	 */
	public void addProcess(Process aProcess)
	{
		if (currentProcess == null)
			this.currentProcess = aProcess;
		else
			processes.enqueue(aProcess);
	}

	/**
	 * Removes a Process from the Process Scheduler and sets that Process as the
	 * current Process.
	 */
	public void runNextProcess()
	{
		this.currentProcess = processes.dequeue();
	}

	/**
	 * Sets the current Process to the first element of the Process Scheduler,
	 * and then removes that Process from the Process Scheduler.
	 */
	public void cancelCurrentProcess()
	{
		this.currentProcess = processes.peek();
		processes.dequeue();
	}

	/**
	 * Prints the entire Process Scheduler.
	 */
	public void printProcessQueue()
	{
		processes.print();
	}
}
