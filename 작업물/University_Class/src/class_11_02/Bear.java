package class_11_02;


public class Bear extends GameObject {
	public Bear(GameManager GM) {
		super(GM);
		pos_x = pos_y = 0;
		appearance = 'B';
	}
	
	public void Hunt(char command) {
		int dx = 0, dy = 0;
		
		switch(command) {
		case 'w': dy = -1; break;
		case 'a': dx = -1; break;
		case 's': dy = 1; break;
		case 'd': dx = 1; break;
		default: return;
		}
		
		int new_x = pos_x + dx, new_y = pos_y + dy;
		
		if(new_x < 0 || new_x >= GameManager.MAX_X ||
			new_y < 0 || new_y >= GameManager.MAX_Y)
			return;
		pos_x = new_x;
		pos_y = new_y;
		
		return;
	}
}

