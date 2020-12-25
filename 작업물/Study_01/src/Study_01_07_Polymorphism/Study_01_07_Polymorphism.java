package Study_01_07_Polymorphism;

class A{
	public String x(){return "A.x";}
}
class B extends A{
	public String x(){return "B.x";}
	public String y(){return "y";}
}
class B2 extends A{
	public String x(){return "B2.x";}
} 

public class Study_01_07_Polymorphism {

	public static void main(String[] args) {
		A obj = new B();
		//class B를 인스턴스화 시켰는데, 이것은 마치 A 클래스인 것처럼 행동함!
		
		
		System.out.println(obj.x());
		//출력 결과는 "B.x"이다. 
		
		//System.out.println(obj.y);
		//이 코드는 에러뜬다 왜냐하면, class A에서는 메소드 y가 정의되지 않았기 때문이다
		
		/*
		 * A obj = new B();-> 클래스 B를 A의 데이터타입으로 인스턴스화 시킴!
		 * 1. A에 존재하는 맴버만이 클래스 B의 맴버가 된다.
		 * 2. 클래스 B에서 오버라이딩한 맴버의 동작방식은 그대로 유지한다
		 * */
		
		A obj2 =new B2();
		System.out.println(obj2.x());
	}

}
