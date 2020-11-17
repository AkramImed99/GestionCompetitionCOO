package general;


import org.junit.Test;

import competition.Competition;
import competition.CompetitionBuilder;


public class LeagueTest extends CompetitionTest{


	public Competition createCompetition()
	{
		CompetitionBuilder cf = new CompetitionBuilder();
		
		return cf.setPlayers(this.competitors).build(CompetitionBuilder.TYPE_LEAGUE);
	}
	
}
