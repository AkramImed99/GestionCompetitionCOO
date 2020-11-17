package competition;
/**
 
 * @author Ghelani Akram
 * @version 1.0.0
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import competition.display.*;
import competition.matchs.*;
import competition.selectors.*;
import util.IncorrectListCardinalException;

public class Master extends Competition{

	private FinalistsSelector fs;
	private List<Map<Competitor, Integer>> firstStageRankings;
	private Map<Competitor, Integer> secondStageRanking;
	
	
	/**
	 * 
	 * @param competitorsList A list of competitors
	 * @param fselec Defines the way we choose qualified players for the 2nd stage of the competition
	 * @param match The kind of match played
	 * @param displayer displayer of the competition
	 * @throws IncorrectListCardinalException size of list of Competitors must be at least 4
	 */
	public Master(List<Competitor> competitorsList, FinalistsSelector fselec, Match match, Displayer displayer ) throws IncorrectListCardinalException {
		super(competitorsList, match, displayer);
		
		this.checkEnoughtPlayers();
		
		if(fselec == null)
			this.fs = new FirstBestPlayersSelector();
		
		this.fs = fselec;
		this.firstStageRankings = new ArrayList<>();
		this.secondStageRanking = new HashMap<>();
		
	}
	
	
	
	
	
	public void playAllMatchs()
	{
		
		// PREMIERE PHASE DU MASTER (matchs de poule) ***************
		
		int nbOfPools = fs.getNbOfPools(this.competitors.size());
		List< List<Competitor> > pools = this.createPools(nbOfPools); //split to pools (list of lists)
		int i = 0;
		
		displayer.displayTitle("First Stage"); 
		
		for(List<Competitor> pool : pools) // Pour chaque poule on joue une league(matchs de la poule)
		{
			
			displayer.displayMessage("Group " + (char)(65 + i));
				
			CompetitionBuilder cf = new CompetitionBuilder();
				
			Competition comp = cf.setPlayers(pool).build(CompetitionBuilder.TYPE_LEAGUE); // on creer une competition de type league
						
			comp.playAllMatchs();
				
			Map<Competitor, Integer> rankOfPool = comp.ranking();
			this.firstStageRankings.add(rankOfPool); // On ajoute la table des scores de la poule qui a fini de jouer
			
			i = (i+1)%26; // Chaque poule est identifié par une lettre de l'alphabet
		}
		
		
		// DEUXIEME PHASE DU MASTER (tournois) *************
		
		List<Competitor> finalists = fs.getFinalists(this.firstStageRankings);// On récupere la liste des competetiteurs selectionnés pour la seconde phase de la competition
		
		displayer.displayTitle("Second Stage");
		
			
		CompetitionBuilder cf = new CompetitionBuilder();
		Competition compTourn = cf.setPlayers(finalists).build(CompetitionBuilder.TYPE_TOURNAMENT); // on creer une competition de type league
			
		compTourn.playAllMatchs();
		this.secondStageRanking = compTourn.ranking(); // Le classement de la deuxieme phase du tournois
		
		
		
	}

	/**
	 * Returns the competitors list split by groups (list of competitor list)
	 * @param nbOfPools The number of groups (pool) 
	 * @return the competition competitors list split by groups (list of competitor list)
	 */
	protected List< List<Competitor>> createPools(int nbOfPools)
	{
		List< List<Competitor> > pools = new ArrayList<>();
		
		for(int i=0; i < nbOfPools; i++)
		{
			pools.add( new ArrayList<Competitor>());
		}
		
		int i =0;
		for(Competitor c : this.competitors) // Tous les competiteurs sont placés dans les poules créées
		{
			if (i >= nbOfPools)
			{
					i=0;
			}
			
			pools.get(i).add(c); // On ajoute un competiteur dans une poule
			i++;
		}
		
		return pools;
	}
	
	
	public void displayRanking()
	{
		
		
		displayer.displayTitle("Master ranking");
		displayer.displayMessage("First Stage ranking");
		
		// Affichage tables des scores de la premiere phase de la competition
		int i =0; // Correspond au nom de la poule (lettre)
		
		for(Map<Competitor, Integer> groupRanking : this.firstStageRankings) // On affiche les tables des scores de toutes les poules 
		{
			
			displayer.displayMessage("Group " + (char)(65 + i));
			displayer.displayRank(groupRanking);
			
			i = (i+1)%26; // Chaque poule est identifié par une lettre de l'alphabet
		}
		
		// Affichage tables des scores de la deuxieme phase de la competition
		displayer.displayMessage("Second Stage ranking");
		displayer.displayRank(this.secondStageRanking);
	}
	
	
	protected void displayWelcome()
	{
		displayer.displayTitle("Welcome to the MASTER !");
	}
	
	/**
	 * Checks if the size of the list of competitors is at least 4 (minimum of players)
	 * @throws IncorrectListCardinalException
	 */
	protected void checkEnoughtPlayers() throws IncorrectListCardinalException
	{
		if(this.competitors.size() < 4)
			throw new IncorrectListCardinalException("At Least 4 players to play a Master !");
	}
}
