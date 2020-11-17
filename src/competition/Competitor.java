package competition;

/**

 * @author Ghelani Akram
 * @version 1.0
 */

public class Competitor {

	
	
	private int nbOfPoints;
	private final String lastName;
	private final String name;
	
	public Competitor(String name, String lastName)
	{
		this.name = name;
		this.lastName = lastName;
		this.nbOfPoints = 0;
	}
	public Competitor(String name)
	{
		this.name = name;
		this.lastName = null;
		this.nbOfPoints =0;
	}
	
	
	/**
	 * Adds an amount of points to the competitor
	 * @param amount amount of points to add
	 */
	public void addPoints(int amount)
	{
		if(amount >= 0)
			this.nbOfPoints += amount;
	}
	
	/**
	 * Reset the competitor points to 0
	 */
	public void resetPoints()
	{
		this.nbOfPoints = 0;
	}
	
	/**
	 * Stringify the competitor (name + last name)
	 */
	public String toString()
	{
		return this.name + this.lastName;
	}
	
	/**
	 * Returns the number of points of the competitor
	 * @return le nombre de points du competiteur
	 */
	public int getPoints()
	{
		return this.nbOfPoints;
	}
	
	
	/**
	 * Returns the name of the competitor
	 * @return  the name of the competitor
	 */
	public String getName()
	{
		return this.name;
	}
	
	
	/**
	 * Returns the lastname of the competitor
	 * @return the lastname of the competitor
	 */
	public String getLastName()
	{
		return this.lastName;
	}
}
