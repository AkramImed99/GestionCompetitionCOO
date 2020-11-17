package general;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import competition.Competition;
import competition.Competitor;
import competition.matchs.Match;
import util.MapUtil;


public abstract class CompetitionTest { 

	protected Competition competition;
	protected List<Competitor> competitors;
	
	
	
	public abstract Competition createCompetition(); // The factory method that creates that right instance
	

	@Test
	public void MoreThanOneCompetitorList_launchExceptionTest() 
	{
		competitors = new ArrayList<>();
		competition = this.createCompetition();
		
		assertNull(competition);
		
		competitors.add(new Competitor("jean", "pierre"));
		competition = this.createCompetition();
		
		//Si on a qu'un competiteur qui participe a la competition, on a une erreur
		assertNull(competition);
		
	}
	
	
	

	
	@Test
	public void ranking_returnsOrderedMapOfCompetitorsList() 
	{
		Competitor c1 = new Competitor("jean", "pierre");
		Competitor c2 = new Competitor("marie", "dupont");
		Competitor c3 = new Competitor("maxence", "begg");
		Competitor c4 = new Competitor("manon", "lafeuille");
		
		competitors = new ArrayList<>();
		competitors.add(c1);
		competitors.add(c2);
		competitors.add(c3);
		competitors.add(c4);
		
		
		competition = this.createCompetition();
		c1.addPoints(1);
		
		
		Map<Competitor, Integer> myMap = new HashMap<>();
		myMap.put(c1, 1);
		myMap.put(c2, 0);
		myMap.put(c3, 0);
		myMap.put(c4, 0);
		
		myMap = MapUtil.sortByDescendingValue(myMap);
		
		
		assertEquals(myMap, competition.ranking()); //La table des noms et score doit  etre la meme (bonne ordre)
		
		
		
	}
	
}













