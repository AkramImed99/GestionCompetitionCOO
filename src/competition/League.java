package competition;

/**
 
 * @author Ghelani Akram
 * @version 1.1
 */

import java.util.List;

import competition.display.Displayer;
import competition.matchs.Match;
import util.IncorrectListCardinalException;

public class League extends Competition {

	
	/**
	 * 
	 * @param competitorsList A list of Competitors with a size that is a power of two number
	 * @param match The kind of match to play
	 * @param displayer The displayer of the competition
	 * @throws IncorrectListCardinalException size of list of Competitors must be at least 2
	 */
	public League(List<Competitor> competitorsList, Match match, Displayer displayer) throws IncorrectListCardinalException {
		super(competitorsList, match, displayer);
	}
	
	
	
	
	
	public void playAllMatchs()
	{
		for(int i = 0; i < 2;i++) // Chaque joueur affronte 2 fois chaque autre joueur
		{
			
			for(int n=0; n<competitors.size()-1;n++)   //Chaque joueur va affronter tous les autres joueurs
			{
					
				for(int j=n+1; j<competitors.size(); j++)
				{
					Competitor c1 = competitors.get(n);
					Competitor c2 = competitors.get(j);
					
					Competitor winner = this.playMatch(c1, c2);
					displayer.displayMatch(c1, c2, winner); //On affiche le match
					
				}
					
			}
	}
		
		
	}
	

	protected void displayWelcome()
	{
		displayer.displayTitle("Welcome to the LEAGUE !");
	}
	
}


