package Study_01_03;

class Access {
	public String x(){
		return "public String x()";
	}
	
	private String y(){
		return "private String y()";
	}//private 접근제어자는 같은 클래스 안에서만 호출가능하다
	
	public String z(){
		return y();
	}
	
}

public class Study_01_03_Access_Modifier {

	public static void main(String[] args) {
		Access a1 =new Access();
		a1.x();
		//a1.y();
		//위 메소드 y()는 실해되지 않는다. 왜냐하면 접근제어자가 private이기 때문이다
		a1.z();
		//이건 가능하다. 왜냐하면 메소드 x와 메소드 z는 같은 클래스의 소속이기 때문이다.

	}

}
/* 멤버들에 대해서는 private, (default), protected, public
 * 클래스에 대해서는 (default), public
 * 
 * !!!!!중요!
 * public 클래스가 포함된 소소코드는 
 * public 클래스의 클래스 명과 소스코드의 파일명이 같아야 한다.
 * 즉, 하나의 소스코드 (java파일)에 대해서는
 * 하나의 public class만이 존재할 수 있다는 것이다.
 * */
