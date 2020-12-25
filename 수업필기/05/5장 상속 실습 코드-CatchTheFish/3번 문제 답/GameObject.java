
public abstract class GameObject {
	public int pos_x, pos_y;
	public char appearance;
	protected GameManager GM;
	
	public GameObject(GameManager GM) {
		this.GM = GM;
	}
}
