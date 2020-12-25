package Study_02_00_Object;

//clone은 똑같은 객체를 복제해 주는 메소드이다.

class Student2 implements Cloneable{
	String name;
	Student2 (String name){this.name=name;}
	
	//복제하려면 복제가능한 객체라는 것을 JVM에게 알려 주어야한다.
	 //이걸안하면 s1.clone();이 에러가 난다
	//->cloneable이라는 interface를 구현해주면 된다
	//interface cloneable은 비어있다. 그저 단순히 지정해 주는 것 뿐이다.
	
	//또 문제가 clone()은 접근제어자가 protected이다
	//그래서 상속을 해줘야한다 
	
	/** public Object clone(){
	 * 	return super.clone();
	 * }
	 * @throws CloneNotSupportedException 
	 */
	
	//근데 이게 또 문제가 있다
	//clone메소드에는 예외가 있다! throw예외 처리를 해줘야한다!
	//여기서는 예외처리 책임을 다른 사용자에게 넘기자!
	
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}

public class Study_02_00_Object_01 {

	public static void main(String[] args) {
		Student2 s1 = new Student2("Egoing");//이걸 똑같이 복제하고 싶다.
		
		try {
			Student2 s2= (Student2)s1.clone();
			System.out.println(s1);
			System.out.println(s2);
			
			System.out.println(s1.name);
			System.out.println(s2.name);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

}
