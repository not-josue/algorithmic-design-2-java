/*
 * A class that defines what a Game object is
 * Written By: Josue
 */
public class Game
{
	// attributes

	String name;
	String console;

	// constructors

	public Game()
	{
		this.name = "none";
		this.console = "none";
	}

	public Game(String aName, String aConsole)
	{
		this.setName(aName);
		this.setConsole(aConsole);
	}

	// getters

	public String getName()
	{
		return this.name;
	}

	public String getConsole()
	{
		return this.console;
	}

	// setters

	public void setName(String aName)
	{
		if (aName != null) this.name = aName;
		else this.name = "none";
	}

	public void setConsole(String aConsole)
	{
		if (aConsole != null) this.console = aConsole;
		else this.console = "none";
	}

	// other methods

	@Override
	public String toString()
	{
		return "Name: " + this.name + " Console: "
				+ this.console;
	}

	public boolean equals(Game aGame)
	{
		return aGame != null
				&& this.name.equals(aGame.getName())
				&& this.console.equals(aGame.getConsole());
	}
}
