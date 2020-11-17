package general;

import static org.junit.Assert.*;

import org.junit.Test;

import competition.Competitor;


public class CompetitorTest {

	@Test
	public void addPoints_addsPointsToCompetitorTest()
	{
		Competitor c1 = new Competitor("jean", "pierre");
		
		assertEquals(0, c1.getPoints()); //Au depart il a 0 points
		c1.addPoints(1);
		assertEquals(1, c1.getPoints()); //On verifie que le point lui a été ajouté
	}
	
	@Test
	public void addPoints_doesntAddIfNegativeAmountTest()
	{
		Competitor c1 = new Competitor("jean", "pierre");
		
		assertEquals(0, c1.getPoints()); //Au depart, il a 0 points
		c1.addPoints(-1);
		assertEquals(0, c1.getPoints()); // On verifie que rien ne s'est passe si on a essaye d'ajouter une valeur négative
	}
	
	@Test
	public void resetPoint_resetsPointsToZeroTest()
	{
		Competitor c = new Competitor("jean", "pierre");
		
		assertEquals(0, c.getPoints());
		
		c.addPoints(10);
		assertEquals(10, c.getPoints());
		c.resetPoints();
		assertEquals(0, c.getPoints());
	}
	
}
