package selectors;

import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

import competition.Competitor;
import competition.selectors.FinalistsSelector;
import competition.selectors.FirstBestPlayersSelector;


public class FirstBestPlayersSelectorTest {

	@Test
	public void getPoolFinalistsPicksTheFirstBestPlayerTest()
	{
		FinalistsSelector fs = new FirstBestPlayersSelector();
		Competitor c1 = new Competitor("jean", "pierre");
		Competitor c2 = new Competitor("marie", "dupond");

		Map<Competitor, Integer> myMap = new HashMap<>();
		myMap.put(c1, 1);
		myMap.put(c2, 0);
		
		assertEquals(c1, fs.getPoolFinalists(myMap).get(0));
		 
		 
	}
	
}
