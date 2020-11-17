package competition.selectors;
/**
 * @author LE GUENNEC YAAKOUB
 * @author Ghelani Akram
 * @version 1.0.0
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import competition.Competitor;

public abstract class FinalistsSelector {

	
	/**
	 * Returns the list of qualified competitors for the next stage of competition
	 * @param firstStageRankings The competition all groups rankings
	 * @return the list of qualified competitors for the next stage of competition
	 */
	public List<Competitor> getFinalists( List< Map<Competitor, Integer> > firstStageRankings ){
		
		List<Competitor> finalists = new ArrayList<>(); // La liste des finalistes pour la seconde partie de la competition
		
		for(Map<Competitor, Integer> rank : firstStageRankings) // On parcours les tables des scores de toutes les poules
		{
			List<Competitor> qualifiedCompetitors = getPoolFinalists(rank); // Pour chaque poule on selectionne les competiteurs qualifiés pour la seconde partie de la competition
			
			for(Competitor c : qualifiedCompetitors)
			{
				finalists.add(c); // On ajoute les competiteurs d'une poule qui sont qualfiés à la liste finale des finalistes
			}
		}
		
		return finalists;
	}
	
	/**
	 * Returns the list of qualified competitors of one group
	 * @param poolRanking the ranking of one group
	 * @return the list of qualified competitors of one group
	 */
	public abstract List<Competitor> getPoolFinalists( Map<Competitor, Integer> poolRanking);
	/**
	 * Returns the needed number of groups (to get a power of two number of qualified players)
	 * @param nbOfCompetitors the competition number of players
	 * @return the needed number of groups (to get a power of two number of qualified players)
	 */
	public abstract int getNbOfPools(int nbOfCompetitors);
}
