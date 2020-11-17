package competition.display;
/**
 
 * @author Ghelani Akram
 * @version 1.0.1
 */

import java.util.Map;

import competition.Competitor;



public class StdDisplayer implements Displayer{
	
	
	
	@Override
	/**
	 * Displays the message in the console with the format "*****{msg}*****"
	 * @param msg Message to display
	 * 
	 */
	public void displayMessage(String msg) {
		System.out.println("\n***** " + msg + " *****\n");
	}
	
	
	public void displayTitle(String title)
	{
		System.out.println("\n-------------------- " + title.toUpperCase() + "\n");
	}
	
	
	@Override
	/**
	 * Displays the result of the match 
	 * @param c1 a competitor
	 * @param c2 the other competitor
	 * @param winner winner of match
	 */
	public void displayMatch(Competitor c1, Competitor c2, Competitor winner)
	{
		System.out.println("\t" + c1.getName() + " vs " + c2.getName() + " ---> " + winner.getName() + " wins!");
	}

	
	
	@Override
	/**
	 * Displays the score table of competitors
	 * @param rankmap ordered table of competitors and their score
	 * 
	 */
	public void displayRank(Map<Competitor, Integer>  rankmap){
		
		for (Map.Entry<Competitor, Integer> entry : rankmap.entrySet()) {
		    System.out.println(entry.getKey().getName() + "  -  " + entry.getValue().toString());
		}
	}

}
