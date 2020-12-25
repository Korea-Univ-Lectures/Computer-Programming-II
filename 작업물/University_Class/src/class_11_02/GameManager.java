package class_11_02;

import java.util.Scanner;

public class GameManager {
	public static final int MAX_X = 70, MAX_Y = 16, MAX_HUNGER = 70;
	private Scanner scan;
	
	private GameObject[][] board = new GameObject[MAX_Y][MAX_X];
	private int score = 0;
	private int hunger = 0;
	
	private Bear bear;
	private Salmon[] salmon= new Salmon[10];
	private Trout[] trout= new Trout[10];
	private Nimo[] nimo = new Nimo[10];
	
	
	
	public GameManager() {
		scan = new Scanner(System.in);
		
		bear = new Bear(this);
		board[bear.pos_y][bear.pos_x] = bear;
		
		for(int i=0;i<10;i++) {
			salmon[i] = new Salmon(this, 4, i);
			trout[i] = new Trout(this, i, 15);
			nimo[i] =new Nimo(this, 8, i+5);
			
			board[salmon[i].pos_y][salmon[i].pos_x] = salmon[i];
			board[trout[i].pos_y][trout[i].pos_x] = trout[i];
			board[nimo[i].pos_y][nimo[i].pos_x] = nimo[i];
		}
	}
	
	
	public boolean IsEmpty(int x, int y) {
		if(board[y][x] == null)
			return true;
		else return false;
	}
	
	private void PrintBoard() {
		String[] sidebar = {"Hunger Level: " + hunger + "/" + MAX_HUNGER,
							"Current Score: " + score, "",
							salmon[0].appearance+" : Salmon : " + salmon[0].hungerPoint + " Food, " + salmon[0].catchScore + " Points",
							trout[0].appearance+" :  Trout : " + trout[0].hungerPoint + " Food, " + trout[0].catchScore + " Points",
							nimo[0].appearance+" :  Nimo : " + nimo[0].hungerPoint + " Food, " + nimo[0].catchScore + " Points"
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
			
			score +=((Fish)stomped).catchScore;
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
			
			for(int i=0; i<10;i++) {
				MoveFish(salmon[i]);
				MoveFish(trout[i]);
				MoveFish(nimo[i]);
			}
			
			
			PrintBoard();
			if(hunger >= MAX_HUNGER) break;
			command = GetInput();
		}
		QuitGame();
	}
	
	//Main Function
	public static void main(String[] args) {
		GameManager GM = new GameManager();
		
		GM.PlayGame();
		
	}
}

