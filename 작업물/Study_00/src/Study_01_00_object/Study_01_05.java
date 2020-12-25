package Study_01_00_object;

public class Study_01_05 {
	
	static int i=5;//클래스 변수, 클래스 전체에 영향을 미침 그래서 우선도가 떨어짐
	
	static void a(){
		int i=10;//클래스 메소드 안의 변수, 메소드가 끝나면 사라짐
		//지역변수-> 특수한경우, 우선도가 높아짐
		b();
	}
	
	static void b(){
		System.out.println(i);//a의 i를 사용하지 않고, 전역변수의i를 사용한다
		//바로 "정의"된 시점에서의 변수를 활용!
		
	}
	
	public static void main(String[] args) {
		for(i=0;i<5;i++){//여기서의 i는 5행의 i이다, 전역변수의 i이다
			a();//여기서는 메소드 안의 i만을 다루고, 메소드가 끝나면 사라진다.
			System.out.println(i);
		}
	}

}
