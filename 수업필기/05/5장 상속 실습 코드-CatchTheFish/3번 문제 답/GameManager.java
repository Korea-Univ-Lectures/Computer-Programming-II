import java.util.Scanner;

public class GameManager {
	public static final int MAX_X = 10, MAX_Y = 6, MAX_HUNGER = 40;
	private Scanner scan;
	
	private GameObject[][] board = new GameObject[MAX_Y][MAX_X];
	private int score = 0;
	private int hunger = 0;
	
	private Bear bear;
	private Salmon salmon;
	private Trout trout;
	
	
	
	public GameManager() {
		scan = new Scanner(System.in);
		
		bear = new Bear(this);
		salmon = new Salmon(this, 4, 4);
		trout = new Trout(this, 8, 1);
		
		board[bear.pos_y][bear.pos_x] = bear;
		board[salmon.pos_y][salmon.pos_x] = salmon;
		board[trout.pos_y][trout.pos_x] = trout;
	}
	
	
	public boolean IsEmpty(int x, int y) {
		if(board[y][x] == null)
			return true;
		else return false;
	}
	
	private void PrintBoard() {
		String[] sidebar = {"Hunger Level: " + hunger + "/" + MAX_HUNGER,
							"Current Score: " + score, "",
							salmon.appearance+" : Salmon : " + salmon.hungerPoint + " Food, " + salmon.catchScore + " Points",
							trout.appearance+" :  Trout : " + trout.hungerPoint + " Food, " + trout.catchScore + " Points"
							};
		
		System.out.println("\n");
		for(int i = 0; i < MAX_X; i++)
			System.out.print("~");
		System.out.println("~~");
		
		for(int j = 0; j < MAX_Y; j++) {
			System.out.print("~");
			for(int i = 0; i < MAX_X; i++) {
				if(board[j][i] == null) System.out.print("-");
				else System.out.print(board[j][i].appearance);
			}
			if(j < sidebar.length)
				System.out.println("~  " + sidebar[j]);
			else System.out.println("~  ");
		}

		for(int i = 0; i < MAX_X; i++)
			System.out.print("~");
		System.out.println("~~");
		
		return;
	}
	
	private char GetInput() {
		System.out.println("Enter your next move (one letter) >> WASD , Q to quit");
		boolean inLoop = true;
		char command = ' ';
		do{
			command = scan.next().charAt(0);
			if(command >= 'A' && command <= 'Z')
				command += 'a'-'A';
			
			switch(command) {
			case 'w': case 'a': case 's': case 'd': case 'q':
				inLoop = false;
				break;
			}
			
		} while(inLoop);
		
		return command;
	}
	
	private void MoveBear(char command) {
		board[bear.pos_y][bear.pos_x] = null;
		bear.Hunt(command);
		
		GameObject stomped = board[bear.pos_y][bear.pos_x];
		if(stomped instanceof Fish) {
			
			/* Put score incrementing code here */
			/* Downcast stomped (GameObject Class) into Fish Class */
			
			hunger -= ((Fish)stomped).hungerPoint;
			if(hunger < 0) hunger = 0;
			
			((Fish)stomped).Respawn();
			board[stomped.pos_y][stomped.pos_x] = stomped;
		}
		board[bear.pos_y][bear.pos_x] = bear;

		hunger++;
	}

	private void MoveFish(Fish fish) {
		board[fish.pos_y][fish.pos_x] = null;
		fish.Move();
		board[fish.pos_y][fish.pos_x] = fish;
	}
	
	private void QuitGame() {
		System.out.println("The game has Ended. Your score is : "+score);
		scan.close();
	}
	
	private void PlayGame() {
		char command;
		
		PrintBoard();
		command = GetInput();
		
		while(command != 'q') {
			MoveBear(command);
			MoveFish(salmon);
			MoveFish(trout);
			
			PrintBoard();
			if(hunger >= MAX_HUNGER) break;
			command = GetInput();
		}
		QuitGame();
		scan.close();
	}
	
	//Main Function
	public static void main(String[] args) {
		GameManager GM = new GameManager();
		
		GM.PlayGame();
		
	}
}
