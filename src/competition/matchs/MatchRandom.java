package competition.matchs;

import competition.Competitor;

/**
 
 * @author Ghelani Akram
 * @version 1.0
 */

public class MatchRandom extends Match{

	
	/**
	 * 
	 * @param earn The amount of points that a match makes earn to a competitors
	 */
	public MatchRandom(int earn)
	{
		super(earn);
	}
	
	public MatchRandom()
	{
		super();
	}
	
	
	/**
	 * Plays the match and returns the winner 
	 * @param c1 A competitor
	 * @param c2 the other competitor
	 * @return winner of the match
	 */
	public Competitor getWinner(Competitor c1, Competitor c2)
	{
		int rand = (int) (Math.random()*2);
		
		if(rand==0)		
			return c1;
		else 
			return c2;	
		
	}
	
	
	
	
}
