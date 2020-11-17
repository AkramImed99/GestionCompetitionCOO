package competition.selectors;
/**
 
 * @author Ghelani Akram
 * @version 1.0.0
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import competition.Competitor;

public class FirstBestPlayersSelector extends FinalistsSelector {

	
	public List<Competitor> getPoolFinalists(Map<Competitor, Integer> poolRanking) {
		
		List<Competitor> poolFinalists = new ArrayList<>();
		
		Map.Entry<Competitor, Integer> bestPlayer = poolRanking.entrySet().iterator().next();
		
		for(Map.Entry<Competitor, Integer> entree : poolRanking.entrySet())
		{
			if (entree.getValue() > bestPlayer.getValue())
			{
				bestPlayer = entree;
			}
		}
		
		poolFinalists.add(bestPlayer.getKey());
		return poolFinalists;
	}

	@Override
	public int getNbOfPools(int nbOfCompetitors) {
		
		int nbOfPools = 1;
		
		for(int i=2; i<128; i*=2)
		{
			int nbCompetitPerPool = nbOfCompetitors / i;
			
			if(i >= nbCompetitPerPool)
			{
				nbOfPools = i;
				break;
			}
		}
		
		return nbOfPools;
		
	}

}
