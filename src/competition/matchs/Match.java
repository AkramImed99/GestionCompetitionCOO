package competition.matchs;

import competition.Competitor;

/**
 
 * @author Ghelani Akram
 * @version 1.0
 */

public abstract class Match {

	
	protected final int pointsToEarn;
	
	/**
	 * 
	 * @param earn The amount of points that a match makes earn to a competitors
	 */
	public Match(int earn)
	{
		this.pointsToEarn = earn;
	}
	
	
	
	/**
	 * By default each won match makes earn 1 point to the competitor 
	 */
	public Match()
	{
		this.pointsToEarn = 1;
	}
	
	
	
	/**
	 * Plays the match and returns the winner 
	 * @param c1 A competitor
	 * @param c2 the other competitor
	 * @return winner of the match
	 */
	public abstract Competitor getWinner(Competitor c1, Competitor c2);
	
	
	
	/**
	 * Returns the number of points that a match makes earn
	 * @return the number of points that a match makes earn
	 */
	public int getPointsToEarn()
	{
		return this.pointsToEarn;
	}
	
	
}
