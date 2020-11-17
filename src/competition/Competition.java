package competition;
/**
 
 * @author Ghelani Akram
 * @version 2.0
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import competition.display.Displayer;
import competition.display.StdDisplayer;
import competition.matchs.Match;
import competition.matchs.MatchRandom;
import util.IncorrectListCardinalException;
import util.MapUtil;



public abstract class Competition {

	protected  Match match;
	protected final List<Competitor> competitors;
	protected  Displayer displayer;
	
	
	
	/**
	 * 
	 * @param competitorsList List of competitors
	 * @param match Type of match (Child of Match abstract class)
	 * @param displayer The displayer of the competition 
	 * @throws IncorrectListCardinalException If the size of the list is less than 2 
	 */
	public Competition(List<Competitor> competitorsList, Match match, Displayer displayer) throws IncorrectListCardinalException 
	{
		if(competitorsList.size() < 2)
			throw new IncorrectListCardinalException("Pas assez de competiteurs (au moins 2)");
		
		this.competitors = new ArrayList<>(competitorsList);
		
		
		if(match==null)
			this.match = new MatchRandom();
		else
			this.match = match;
		
			
		if(displayer == null)
			this.displayer= new StdDisplayer();
		else
			this.displayer = displayer;
		
		
		
		
		this.resetPlayersPoints();
		

	}
	
	
	/**
	 * Play the game into the end of competition
	 */
	public void play()
	{
		
		this.displayWelcome(); // On affiche le message de bienvenue
		
		this.playAllMatchs(); //On joue et on affiche les matchs joués
		
		this.displayRanking(); // On affiche la table des scores
		
	}
	
	/**
	 * Displays a welcome message of the competition
	 */
	protected abstract void displayWelcome();
	
	/**
	 * Plays all matchs between competitors 
	 */
	public abstract void playAllMatchs();
	
	
	/**
	 * Plays a match between two competitors and adds a point to the winner
	 * @param c1  a competitor
	 * @param c2 a competitor
	 * @return the winner of the match
	 */
	protected Competitor playMatch(Competitor c1, Competitor c2)
	{
		Competitor winner = match.getWinner(c1, c2);
		winner.addPoints(match.getPointsToEarn());
		
		
		return winner;
	}
	
	/**
	 * Creates a Map with competitors and their score ordered by descending values
	 * @return a Map with competitors and their score ordered by descending values
	 */
	public Map<Competitor, Integer> ranking()
	{
		Map<Competitor, Integer> resultCompetition = new HashMap<>();
		
		for(Competitor c : competitors)
		{
			resultCompetition.put( c, c.getPoints());
		}
		
		return MapUtil.sortByDescendingValue(resultCompetition);
		
		
	}
	
	/**
	 * Returns the list of competitors
	 * @return competitors
	 */
	public List<Competitor> getCompetitors()
	{
		return this.competitors;
	}
	
	/**
	 * Reset the points to 0 for all competitors
	 */
	private void resetPlayersPoints() {
		for(Competitor c : this.competitors)
		{
			c.resetPoints();
		}
	}
	
	/**
	 * Displays the competition ranking
	 */
	public void displayRanking()
	{
		displayer.displayTitle("Ranking");
		displayer.displayRank( this.ranking());
	}
	
	
	/** Returns the type of played match
	 * @return the type of match played
	 */
	public Match getMatch()
	{
		return this.match;
	}
	
	/**
	 * Returns the type of displayer 
	 * @return  the type of displayer of the competition
	 */
	public Displayer getDisplayer()
	{
		return this.displayer;
	}
	
	/**
	 * 
	 */
	public void setMatch(Match match)
	{
		this.match = match;
	}
	
	/**
	 * 
	 */
	public void setDisplayer(Displayer displayer)
	{
		this.displayer = displayer;
	}
	
}
