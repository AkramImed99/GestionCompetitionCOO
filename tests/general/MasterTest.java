package general;

import java.util.ArrayList;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import org.junit.*;
import competition.Competition;
import competition.CompetitionBuilder;
import competition.Competitor;

public class MasterTest extends CompetitionTest{

	@Override
	public Competition createCompetition() {
		CompetitionBuilder cf = new CompetitionBuilder();
		
		return cf.setPlayers(this.competitors).build(CompetitionBuilder.TYPE_MASTER);
	}
	
	
	@Test
	public void sizeOfListOfCompetitorsIsMoreThanThreeTest()
	{
		Competitor c1 = new Competitor("c1", "c1");
		Competitor c2 = new Competitor("c2", "c2");
		Competitor c3 = new Competitor("c3", "c3");
		Competitor c4 = new Competitor("c4", "c4");
		
		competitors = new ArrayList<>();
		competitors.add(c1);
		competitors.add(c2);
		competitors.add(c3);
		
		competition = this.createCompetition();
		
		assertNull(competition);
		
		competitors.add(c4);
		competition = this.createCompetition();
		
		assertNotNull(competition);
		
		
	}
	
	
}
