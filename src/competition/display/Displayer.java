package competition.display;

/**
 * @author LE GUENNEC YAAKOUB
 * @author Ghelani Akram
 * @version 1.0
 */

import java.util.Map;

import competition.Competitor;

public interface Displayer {
	
	/**
	 * 
	 * @param c1 A competitor
	 * @param c2  A competitor
	 * @param winner The winner of the match 
	 */
	public void displayMatch(Competitor c1, Competitor c2, Competitor winner);
	
	
	/**
	 * 
	 * @param rank The Competitors Map with their score
	 */
	public void displayRank(Map<Competitor, Integer>  rank);
	
	/**
	 * 
	 * @param msg The message to display
	 * 
	 */
	public void displayMessage(String msg);
	
	/**
	 * @param title The title to display
	 */
	public void displayTitle(String title);
	
	

}
