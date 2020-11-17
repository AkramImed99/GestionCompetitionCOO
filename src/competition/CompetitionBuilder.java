package competition;
/**
 * @author LE GUENNEC YAAKOUB
 * @author Ghelani Akram
 * @version 1.0
 */
import java.util.List;

import competition.display.Displayer;
import competition.matchs.Match;
import competition.selectors.FinalistsSelector;
import util.IncorrectListCardinalException;

public class CompetitionBuilder {
	
	public static final int TYPE_LEAGUE = 1;
	public static final int TYPE_TOURNAMENT = 2;
	public static final int TYPE_MASTER = 3;
	
	private Displayer displayer;
	private List<Competitor> competitors;
	private Match matchType;
	private FinalistsSelector selector;

	public CompetitionBuilder()
	{
		this.displayer = null;
		this.competitors = null;
		this.matchType = null;
	}

	/**
	 *  Creates an instance of a competition (league, tournament, master...)
	 * @param typeCompetition The type of competition to create (Look static attributes of CompetitionFactory that designates the right Competition)
	 * @return An instance of a type of Competition (league, tournament, master...)
	 */
	public Competition build(int typeCompetition) {
		
		Competition comp = null;
		
		if(this.competitors == null) // On doit obligatoirement donner la liste des competiteurs avant de récuperer l'instance
			return null;
		
		switch(typeCompetition)
		{
			
		case TYPE_LEAGUE:
			try {
			comp = new League(this.competitors, this.matchType, this.displayer);
			}catch(IncorrectListCardinalException e)
			{
				System.out.println(e.getMessage());
			}
			break;
			
		case TYPE_TOURNAMENT:
			try {
			    comp = new Tournament(this.competitors, this.matchType, this.displayer);
			    }catch(IncorrectListCardinalException e)
			    {
			    	System.out.println(e.getMessage());
			    }
			break;
			
		case TYPE_MASTER:
			try {
				comp = new Master(this.competitors, this.selector, this.matchType, this.displayer);
				}catch(IncorrectListCardinalException e)
				{
					System.out.println(e.getMessage());
				}
				break;
			
		}
		
		return comp;
	}
	
	/**
	 * Set the selector for master competition
	 * @param fs Second stage selector (Only for Master competition)
	 * @return The competitionFactory itself
	 */
	public CompetitionBuilder setSelector(FinalistsSelector fs)
	{
		this.selector = fs;
		return this;
	}
	
	/**
	 * Set the displayer of the competition
	 * @param displayer The displayer of the competition
	 * @return The competitionFactory itself
	 */
	public CompetitionBuilder setDisplayer(Displayer displayer)
	{
		this.displayer = displayer;
		return this;
	}
	
	/**
	 * Set players of the competition
	 * @param players A list of competitors
	 * @return The competitionFactory itself
	 */
	public CompetitionBuilder setPlayers(List<Competitor> players)
	{
		this.competitors = players;
		return this;
	}

	/**
	 * Set the kind of match of the competition
	 * @param match The type of match played on competition
	 * @return The competitionFactory itself
	 */
	public CompetitionBuilder setMatchType(Match match)
	{
		this.matchType = match;
		return this;
	}
	
	
}
