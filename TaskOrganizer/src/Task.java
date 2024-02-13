/*
 * A class that defines a Task Object
 * Written By: Josue
 */
public class Task
{
	// attributes

	String action;
	int priority;

	// constructors

	public Task()
	{
		this.action = "none";
		this.priority = 4;
	}

	public Task(String anAction, int aPriority)
	{
		this.setAction(anAction);
		this.setPriority(aPriority);
	}

	// getters

	public String getAction()
	{
		return this.action;
	}

	public int getPriority()
	{
		return this.priority;
	}

	// setters

	public void setAction(String anAction)
	{
		if (anAction == null) this.action = "none";
		else this.action = anAction;
	}

	public void setPriority(int aPriority)
	{
		if (aPriority < 0 || aPriority > 4) this.priority = 4;
		else this.priority = aPriority;
	}

	// other methods

	public String toString()
	{
		return "[TASK] Priority: " + this.priority + " Task: " + this.action;
	}

	public boolean equals(Task object)
	{
		return object != null
				&& this.action.equalsIgnoreCase(object.getAction())
				&& this.priority == object.getPriority();
	}

}
