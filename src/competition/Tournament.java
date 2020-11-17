package competition;

/**
 * @author LE GUENNEC YAAKOUB
 * @author Ghelani Akram
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import competition.display.Displayer;
import competition.matchs.Match;
import util.IncorrectListCardinalException;



public class Tournament extends Competition{

	
	/**
	 * 
	 * @param competitorsList A list of competitors
	 * @param match The kind of match played
	 * @param displayer displayer of the competition
	 * @throws IncorrectListCardinalException list of Competitors must be with a size that is a power of two number
	 */
	public Tournament(List<Competitor> competitorsList, Match match, Displayer displayer) throws IncorrectListCardinalException
	{
		super(competitorsList, match, displayer);
		this.checkNumberIsPowerTwo(competitorsList.size());
	}
	
	
	
	
	public void playAllMatchs()
	{
		List<Competitor> currentTurnPlayers = new ArrayList<>(this.competitors); //Contient les competiteurs du tour actuel
		List<Competitor> nextTurnPlayers = new ArrayList<>(); //Contient les competiteurs qualifi�s pour le tour suivant
		
		while(currentTurnPlayers.size() > 1) //On s'arrete quand il ne reste plus qu'un competiteur au tour actuel
		{
			 //On prend les joueurs par pairs successives
			for(int n=0; n < currentTurnPlayers.size() -1; n+=2)
			{
				Competitor c1 = currentTurnPlayers.get(n);
				Competitor c2 = currentTurnPlayers.get(n+1);
				
				Competitor winner = this.playMatch(c1, c2);
				nextTurnPlayers.add(winner); //Le joueur est qualifi� au tour suivant
				
				displayer.displayMatch(c1, c2, winner); //On affiche le match
							
			}
			
			currentTurnPlayers = List.copyOf(nextTurnPlayers); //Les joueurs qualifi�s vont jouer le prochain tour
			nextTurnPlayers.clear(); //On vide la liste des joueurs qualifi�s du tour prochain
		}
	}
	
	protected void displayWelcome()
	{
		displayer.displayTitle("Welcome to the TOURNAMENT !");
	}
	

	/**
	 * Rises an exception of the nulber is not a power of two number
	 * @param number a number
	 * @throws IncorrectListCardinalException not a power of two
	 */
	protected void checkNumberIsPowerTwo(int number) throws IncorrectListCardinalException
	{
		if( (number & (number-1)) != 0)
		{
			throw new IncorrectListCardinalException("List cardinal must be a power of 2");
		}
	}
	
	
	

}
