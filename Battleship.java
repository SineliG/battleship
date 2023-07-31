import java.util.*;


public class Battleship {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String errorMessage = "Invalid coordinates. Choose different coordinates.";
		int battleshipplayer1 = 0;
		int battleshipplayer2 = 0;

		char[][] battle2 = new char[5][5];
		char[][] battlenew = new char[5][5];
		char[][] battlenew2 = new char[5][5];
		char[][] battle = new char[5][5];

        System.out.println("Welcome to Battleship!");

		//**PLAYER 1 STARTING SHIP LOCATIONS**
		System.out.println("PLAYER 1, ENTER YOUR SHIPS' COORDINATES.");

		for (char[] row: battle)
    	Arrays.fill(row, '-');

		for (int r = 1; r < 6; r++) {
			System.out.println("Enter ship " + r + " location:");
			if (input.hasNextInt()) {
				int row = input.nextInt();
				if (input.hasNextInt()) {
					int col = input.nextInt();
					if ((row >= 0 && row <=4) && (col >= 0 && col <=4) && (battle[row][col]==('-'))){
						battle[row][col] = '@';
					} else if ((row >= 0 && row <=4) && (col >= 0 && col <=4) && (battle[row][col]==('@'))) {
						System.out.println("You already have a ship there. Choose different coordinates.");
						r--; continue;
					} else {
						System.out.println(errorMessage);
						r--; continue;
					}
				} else {
					System.out.println(errorMessage);
					r--; continue;
				}
			} else {
				System.out.println(errorMessage);
				r--; continue;
			}
		}
		printBattleShip(battle);

		//**Prints 100 lines so Player 2 cannot see Player 1's board**
		int i = 0;
		do {
			System.out.println(" ");
			i++;
		} while (i <= 100);


		//**PLAYER 2 STARTING SHIP LOCATIONS**
		System.out.println("PLAYER 2, ENTER YOUR SHIPS' COORDINATES.");
		
		for (char[] row: battle2)
			Arrays.fill(row, '-');
		
		for (int r2 = 1; r2 < 6; r2++) {
			System.out.println("Enter ship " + r2 + " location:");
			if (input.hasNextInt()) {
				int row = input.nextInt();
				if (input.hasNextInt()) {
					int col = input.nextInt();
					if ((row >= 0 && row <=4) && (col >= 0 && col <=4) && (battle2[row][col]==('-'))){
						battle2[row][col] = '@';
					} else if ((row >= 0 && row <=4) && (col >= 0 && col <=4) && (battle2[row][col]==('@'))) {
						System.out.println("You already have a ship there. Choose different coordinates.");
						r2--; continue;
					} else {
						System.out.println(errorMessage);
						r2--; continue;
					}
				} else {
					System.out.println(errorMessage);
					r2--; continue;
				}
			} else {
				System.out.println(errorMessage);
				r2--; continue;
			}
		}
		printBattleShip(battle2);

		//**Prints 100 lines so Player 1 cannot see Player 2's board**
		int i2 = 0;
		do {
			System.out.println(" ");
			i2++;
		} while (i2 <= 100);


		//THE GAME STARTS
		for (char[] row: battlenew)
		Arrays.fill(row, '-');

		for (char[] row: battlenew2)
		Arrays.fill(row, '-');

		do {
			//**PLAYER 1 TURN**
			System.out.println("Player 1, enter hit row/column:");
			if (input.hasNextInt()) {
				int row = input.nextInt();
				if (input.hasNextInt()) {
					int col = input.nextInt();
					if ((row >= 0 && row < 5) && (col >= 0 && col < 5) && (battle2[row][col]==('-'))) {
						battlenew[row][col] = 'O';
						battle2[row][col] = 'O';
						System.out.println("PLAYER 1 MISSED!");
					} else if ((row >= 0 && row < 5) && (col >= 0 && col < 5) && (battle2[row][col] == ('@'))) {
						System.out.println("PLAYER 1 HIT PLAYER 2's SHIP!");
						battlenew[row][col] = 'X';
						battle2[row][col] = 'X';
						battleshipplayer1++;
							if (battleshipplayer1 == 5) {
								break;
							}
						System.out.println(battleshipplayer1);
					} else if ((row >= 0 && row < 5) && (col >= 0 && col < 5) && (battle2[row][col] == ('O'))){
						System.out.println("You already fired on this spot. Choose different coordinates.");
						continue;
					} else {
						System.out.println(errorMessage);
						System.out.println("Player 1, enter hit row/column:");
					}
				} else {
					System.out.println(errorMessage);
					System.out.println("Player 1, enter hit row/column:");
				}
			} else {
				System.out.println(errorMessage);
				System.out.println("Player 1, enter hit row/column:");
			}
			printBattleShip(battlenew);

			//**PLAYER 2 TURN**
			System.out.println("Player 2, enter hit row/column:");
			if (input.hasNextInt()) {
				int row = input.nextInt();
				if (input.hasNextInt()) {
					int col = input.nextInt();
					if((row >= 0 && row < 5) && (col >= 0 && col < 5) && (battle[row][col]==('-'))) {
						battlenew2[row][col] = 'O';
						battle[row][col] = 'O';
						System.out.println("PLAYER 2 MISSED!");
					} else if ((row >= 0 && row < 5) && (col >= 0 && col < 5) && (battle[row][col] == ('@'))){
						System.out.println("PLAYER 2 HIT PLAYER 1's SHIP!");
						battlenew2[row][col] = 'X';
						battle[row][col] = 'X';
						battleshipplayer2++;
						if (battleshipplayer2 == 5) {
							break;
						}
						System.out.println(battleshipplayer2);
					} else if ((row >= 0 && row < 5) && (col >= 0 && col < 5) && (battle[row][col] == ('O'))){
						System.out.println("You already fired on this spot. Choose different coordinates.");
						continue;
					} else {
						System.out.println(errorMessage);
						System.out.println("Player 2, enter hit row/column:");
					}
				} else {
					System.out.println(errorMessage);
					System.out.println("Player 2, enter hit row/column:");
				}
			} else {
				System.out.println(errorMessage);
				System.out.println("Player 2, enter hit row/column:");
			}
			printBattleShip(battlenew2);
		
		} while (((battleshipplayer1 >= 0) && (battleshipplayer1 < 5)) && ((battleshipplayer2 >= 0) && (battleshipplayer2 < 5)));
			if (battleshipplayer1 == 5) {
				System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!");
			} else if (battleshipplayer2 == 5){
				System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!");
			}
			System.out.println("Final boards:");
			printBattleShip(battle);
			printBattleShip(battle2);}


	// Use this method to print game boards to the console.
	private static void printBattleShip(char[][] player) {
		System.out.print("  ");
		for (int row = -1; row < 5; row++) {
			if (row > -1) {
				System.out.print(row + " ");
			}
			for (int column = 0; column < 5; column++) {
				if (row == -1) {
					System.out.print(column + " ");
				} else {
					System.out.print(player[row][column] + " ");
				}
			}
			System.out.println("");
		}
	}
}