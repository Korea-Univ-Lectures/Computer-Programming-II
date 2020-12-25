import java.util.Random;

public class Trout extends Fish {
	int catchScore;
	int hungerPoint;
	public Trout(GameManager GM, int x, int y) {
		super(GM);
		pos_x = x;
		pos_y = y;
		
		appearance = '$';
		hungerPoint = 3;
	}
	
}
