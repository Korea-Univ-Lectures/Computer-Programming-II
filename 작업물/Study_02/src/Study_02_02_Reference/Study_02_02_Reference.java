package Study_02_02_Reference;

class A{
	public int id;
	A(int id){
		this.id=id;
	}
}

public class Study_02_02_Reference {
	static void _value(int b){
		b=2;
	}
	
	static void runValue(){
		int a=1;
		_value(a);
		//위와 같은 메소드의 매개변수는 다음과 같이 작동한다.
		//int b=a;이다.
		//이 의미는 b=1;이고, 이후 코드 줄에서 b=2;으로 바뀐다.
		//하지만 a의 값에는 전혀 영향을 미치지 못한다.
		System.out.println(a);
	}
	
	static void _reference(A b){
		b= new A(2);
	}
	
	static void runReference1(){
		A a = new A(1);
		_reference(a);
		//이것은 A b= a;이다 라는 뜻이다.
		//b= new A(2);은 b는 새로운 인스턴스를 참조하게 되었다.
		//그래서 a가 참조하는 인스턴스에는 변화가 없다.
		System.out.println(a.id);
	}
	
	static void _reference2(A b){
		b.id=2;
	}
	
	static void runReference2(){
		A a = new A(1);
		_reference2(a);
		//A b =a;이다. b는 a가 참조하는 값을 참조하고 있다.
		//b.id=2;는 값이 달라져버린다.
		System.out.println(a.id);
	}
	
	public static void runReference(){
		A a = new A(1);
		A b= a;//이것은 인스턴스b가 인스턴스a가 참조하는 것을 참조하고 있음을 나타낸다!
		b.id =2;
		System.out.println(a.id);
		
		A c= new A(2);//또 다른 참조대상을 만들어줌	
		
		
		
		//-->2가 출력된다! a.id 는 2!
	}
	
	public static void main (String args[]){
		runReference();
	}
}
