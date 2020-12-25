package class_11_02;

import java.util.Random;

public class Trout extends Fish {
	
	public Trout(GameManager GM, int x, int y) {
		super(GM, x, y);
		appearance = '$';
		hungerPoint = 3;
		catchScore = 3;
	}
	public void Move() {
		Random rand = new Random();
		int direction = rand.nextInt(4);
		
		int dx = 0, dy = 0;
		switch(direction) {
		case 0: dx = -1; dy = -1; break;
		case 1: dx = -1; dy = 1; break;
		case 2: dx = 1; dy = 1; break;
		case 3: dx = 1; dy = -1; break;
		default: return;
		}
		
		int new_x = pos_x + dx, new_y = pos_y + dy;
		
		if(new_x < 0 || new_x >= GameManager.MAX_X ||
			new_y < 0 || new_y >= GameManager.MAX_Y ||
			!GM.IsEmpty(new_x, new_y))
			return;
		pos_x = new_x;
		pos_y = new_y;
		
		return;
	}
}
