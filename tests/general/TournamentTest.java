package general;

import static org.junit.Assert.assertNull;
import java.util.ArrayList;
import org.junit.Test;

import competition.Competition;
import competition.CompetitionBuilder;
import competition.Competitor;
import competition.Tournament;


public class TournamentTest extends CompetitionTest{

	
	public Competition createCompetition()
	{
		CompetitionBuilder cf = new CompetitionBuilder();
		
		return cf.setPlayers(this.competitors).build(CompetitionBuilder.TYPE_TOURNAMENT);
	}
	
	@Test
	public void sizeOfList_IsNot_APowerOfTwoTest() 
	{
		Competitor c1 = new Competitor("jean", "pierre");
		Competitor c2 = new Competitor("marie", "dupond");
		Competitor c3 = new Competitor("adrien", "delcambre");
		
		competitors = new ArrayList<>();
		competitors.add(c1);
		competitors.add(c2);
		competitors.add(c3);
		
		
		competition = this.createCompetition();
		assertNull(competition);
	}
	
	
}


