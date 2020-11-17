package competition;

import java.util.ArrayList;
import java.util.List;
import competition.selectors.FirstBestPlayersSelector;
import java.util.Scanner;


public class main {

	public static void main(String[] args) {
		
		
		CompetitionBuilder competitionBuilder = new CompetitionBuilder();
		Competition competition = null;
		
		Competitor c1 = new Competitor("Jean");
		Competitor c2 = new Competitor("Pierre");
		Competitor c3 = new Competitor("Greg");
		Competitor c4 = new Competitor("Yaakoub");
		
		Competitor c5 = new Competitor("Adrien");
		Competitor c6 = new Competitor("Akram");
		Competitor c7 = new Competitor("Lucas");
		Competitor c8 = new Competitor("Kenny");
		
		List<Competitor> listCompetitor = new ArrayList<>();
		listCompetitor.add(c1);
		listCompetitor.add(c2);
		listCompetitor.add(c3);
		listCompetitor.add(c4);	
		listCompetitor.add(c5);	
		listCompetitor.add(c6);	
		listCompetitor.add(c7);	
		listCompetitor.add(c8);	
	
		
		Scanner keyboard = new Scanner(System.in);
		boolean continuer = true;
		
		while(continuer) {
			
			
			System.out.println("\nA quel type de tournois voulez vous assister :  1. Les Masters     2. La League     3. Le Tournois 4. Quitter\n (Tapez le numéro correspondant )\n");
			keyboard.reset();
			int choix = keyboard.nextInt();
			
			switch(choix)
			{
				case 1:
					competitionBuilder.setPlayers(listCompetitor).setSelector(new FirstBestPlayersSelector());
					competition = competitionBuilder.build(CompetitionBuilder.TYPE_MASTER);
					competition.play();
					break;
				case 2:
					competition = competitionBuilder.setPlayers(listCompetitor).build(CompetitionBuilder.TYPE_LEAGUE);
					competition.play();
					break;
				case 3:
					competition = competitionBuilder.setPlayers(listCompetitor).build(CompetitionBuilder.TYPE_TOURNAMENT);
					competition.play();
					break;
				case 4:
					continuer = false;
					break;
					
			}
			
			
		}
		System.out.println("\n\nFIN....");
	
		
		
		

	}
	
	
	

}
