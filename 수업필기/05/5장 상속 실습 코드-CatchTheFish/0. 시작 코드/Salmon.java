import java.util.Random;

public class Salmon extends Fish {
	int catchScore;
	int hungerPoint;
	public Salmon(GameManager GM, int x, int y) {
		super(GM);
		pos_x = x;
		pos_y = y;
		
		appearance = '#';
		hungerPoint = 6;
	}
	
}
