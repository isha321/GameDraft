//Isha Sinha
//CSC311

import java.util.Random;
import java.text.DecimalFormat;


public class CSC311P1 {
	
	public static void main (String [] args) {
		String [] teams = new String [8];				//creating array for teams
		String [] players = new String [32];			//creating array for players
		double [] winnings = new double [8];
		String [][] draft = new String [4][8];
		
		teams = makeTeams(teams);				// initialize team array
		winnings = makeWinnings(winnings);		// initialize winnings array
		printLastSeason(teams, winnings);		// print default arrays
		
		teams = makeRanking(teams, winnings);	// bubble sort arrays
		printRanking(teams);					// print sorted teams
		
		players = makePlayers(players);			// initialize players array and shuffles
		//printPlayers(players);
		draft = makeDraft(draft, players);		// inserts shuffled players into draft
		printDraft(draft);						// print draft
		
		picks(draft, teams);					// shuffles draft and teams pick
	}
	
	public static String [] makeTeams(String [] teams) {					
		teams[0] = "Dallas Cowboys";
		teams[1] = "Indianapolis Colts";
		teams[2] = "New Orleans Saints";
		teams[3] = "Buffalo Bills";
		teams[4] = "Denver Broncos";
		teams[5] = "San Fransisco 49ers";
		teams[6] = "Green Bay Packers";
		teams[7] = "Minnesota Vikings";
		
		return teams;
	}
	
	public static String [] makePlayers(String [] players) {
		players[0] = "Tony Romo";
		players[1] = "Demarco Murray";
		players[2] = "Sam Bradford";
		players[3] = "Andrian Peterson";
		players[4] = "Landry Jones";
		players[5] = "Blake Bell";
		players[6] = "Tom Brady";
		players[7] = "Roy Finch";
		players[8] = "Ryan Broyles";
		players[9] = "Trevor Knight";
		players[10] = "Peytton Manning";
		players[11] = "Eli Manning";
		players[12] = "Brett Favre";
		players[13] = "Ben Roethlisberger";
		players[14] = "Aaron Rodgers";
		players[15] = "Joe Flacco";
		players[16] = "Reggie Bush";
		players[17] = "Lance Dunbar";
		players[18] = "Toby Gerhart";
		players[19] = "Brandon Bostick";
		players[20] = "Garret Celek";
		players[21] = "Gavin Escobar";
		players[22] = "Anthony Fasano";
		players[23] = "Geno Smith";
		players[24] = "Drew Brees";
		players[25] = "Andrew Luck";
		players[26] = "Johny Manziel";
		players[27] = "Robert Griffin III";
		players[28] = "Jonathan Franklin";
		players[29] = "Arian Foster";
		players[30] = "Mike Goodson";
		players[31] = "Jeff Demps";
		
		players = shuffle(players);
		
		return players;
	}
	
	public static double [] makeWinnings(double [] winnings) {												
		
		// Reference: http://stackoverflow.com/questions/3680637/generate-a-random-double-in-a-range					
		double start = 0;
		double end = 100;							
		
		// Generate random number and put it in winnings array
		for(int i = 0; i < winnings.length; i++) {
			double random = new Random().nextDouble();			
			double result = start + (random * (end - start));
			winnings[i] = result;
		}

		return winnings;
	}
	
	public static String [] makeRanking(String [] teams, double [] winnings) {
		// Reference: www.hackerrank.com
		
		// Bubble sort both arrays at the same time
        for (int i = 0; i < winnings.length; i++) {
            for (int j = 0; j < winnings.length - i - 1; j++) {
                if (winnings[j] > winnings[j + 1]) {
                    double temp = winnings[j];
					String t = teams[j];
                    winnings[j] = winnings[j + 1];
					teams[j] = teams[j+1];
                    winnings[j + 1] = temp;
					teams[j+1] = t;
                }
            }
        }
		
		return teams;
    }
	
	public static String [][] makeDraft(String [][] draft, String [] players) {
		int playerindex = 0;		// counter to go up to 32
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 8; j++) {
				draft[i][j] = players[playerindex++];
			}
		}
		return draft;
	}
	
	public static void picks(String[][] draft, String [] teams) {
		// shuffle draft for the 2d array
		Random rnd = new Random();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 8; j++) {
				int index = rnd.nextInt(8);
				String temp = draft[i][index];
				draft[i][index] = draft[i][j];
				draft[i][j] = temp;
			}
		}
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 8; j++) {
				System.out.println("Round " + (i+1) +": Team: " + teams[j] + " selected: " + draft[i][j]);
			}
			System.out.println();
		}
	}
	
	public static String [] shuffle(String [] players) {
		Random rnd = new Random();
		
		// swap values at random indexes
		for (int j = 0; j < players.length; j++) {
			int index = rnd.nextInt(players.length);
			String temp = players[index];
			players[index] = players[j];
			players[j] = temp;
		}
		
		return players;
	}
	
	public static void printLastSeason (String [] teams, double [] winnings) {
		DecimalFormat df = new DecimalFormat("#.##");						//roundsnumber
		for(int i = 0; i < teams.length; i++) {
            System.out.println("The " + teams[i] + " won " + df.format(winnings[i]) + " of their games last season!");
        }
		System.out.println();
	}
	
	public static void printRanking(String [] teams) {
        System.out.println("After sorting the data:");
		for(int i = 0; i < teams.length; i++) {
            System.out.println("The " + teams[i] + " is ranked " + (i+1));
        }

        System.out.println();
    }
	
	public static void printDraft(String[][] draft) {						//prints out the round
        for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 8; j++) {
				System.out.println(draft[i][j] + " has been selected to be drafted in Round " + (i+1));
			}
		}

        System.out.println();
    }
	
	public static void printPlayers(String[] players) {				//prints out the players
        for(int i = 0; i < players.length; i++) {
            System.out.println(players[i] + " ");
        }

        System.out.println();
    }
}
