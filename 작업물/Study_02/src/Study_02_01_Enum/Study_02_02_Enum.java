package Study_02_01_Enum;
/*
 class Fruit{
 	public static final Fruit APPLE = new Fruit();
	public static final Fruit PEACH = new Fruit();
	public static final Fruit BANANA = new Fruit();
 }
 
 
 * */
enum Fruit{//사실상 class!
	APPLE("red"), PEACH("pink"), BANANA("yellow");
	//enum은 상수들의 열거이다!
	//상수들이 호출될 때마다 새로운 Fruit가 만들어 짐 
	//그 때마다 생성자가 자동으로 호출! 
	
	//enum은 필드 값을 가질 수도 있다 
	public String color;
	
	//APPLE("red")에서 ()는 생성자를 호출하는 것이고, 그 안에 매개변수 인자 "red"를 주는 것이다
	//메소드도 만들 수 있다
	
	public String getColor(){
		return this.color;
	}
	
	Fruit(String color){
		System.out.println("Call Constructor: "+this);
		//this는 인스턴스를 대표하는 어떤 정보를 자바가 우리에게 주는 것이다.
		this.color = color;
	}
	
	//enum는 배열의 역할을 할 수도 있다.
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
		
		//enum은 하나씩 값을 꺼내서 사용할 수 있는데, 그때 사용하는 메소드가 values()이다
		for(Fruit f : Fruit.values()){
			System.out.println(f+", "+f.getColor());
		}
	}

}
