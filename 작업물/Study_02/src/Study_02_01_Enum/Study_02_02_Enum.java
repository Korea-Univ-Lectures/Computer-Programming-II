package Study_02_01_Enum;
/*
 class Fruit{
 	public static final Fruit APPLE = new Fruit();
	public static final Fruit PEACH = new Fruit();
	public static final Fruit BANANA = new Fruit();
 }
 
 
 * */
enum Fruit{//��ǻ� class!
	APPLE("red"), PEACH("pink"), BANANA("yellow");
	//enum�� ������� �����̴�!
	//������� ȣ��� ������ ���ο� Fruit�� ����� �� 
	//�� ������ �����ڰ� �ڵ����� ȣ��! 
	
	//enum�� �ʵ� ���� ���� ���� �ִ� 
	public String color;
	
	//APPLE("red")���� ()�� �����ڸ� ȣ���ϴ� ���̰�, �� �ȿ� �Ű����� ���� "red"�� �ִ� ���̴�
	//�޼ҵ嵵 ���� �� �ִ�
	
	public String getColor(){
		return this.color;
	}
	
	Fruit(String color){
		System.out.println("Call Constructor: "+this);
		//this�� �ν��Ͻ��� ��ǥ�ϴ� � ������ �ڹٰ� �츮���� �ִ� ���̴�.
		this.color = color;
	}
	
	//enum�� �迭�� ������ �� ���� �ִ�.
}

enum Company{
	GOOGLE, APPLE, ORACLE;
}

public class Study_02_02_Enum {

	public static void main(String[] args) {
		
		Fruit type =Fruit.PEACH;
		switch (type){
			case APPLE: 
				System.out.println("This is APPLE");
				System.out.println(Fruit.APPLE.getColor());
				break;
			case PEACH:
				System.out.println("This is PEACH");
				System.out.println(Fruit.PEACH.getColor());
				break;
			case BANANA:
				System.out.println("This is BANANA");
				System.out.println(Fruit.BANANA.getColor());
				break;
		}
		System.out.println(Fruit.BANANA.getColor());
		
		//enum�� �ϳ��� ���� ������ ����� �� �ִµ�, �׶� ����ϴ� �޼ҵ尡 values()�̴�
		for(Fruit f : Fruit.values()){
			System.out.println(f+", "+f.getColor());
		}
	}

}
