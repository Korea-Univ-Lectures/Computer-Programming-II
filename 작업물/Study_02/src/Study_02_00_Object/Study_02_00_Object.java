package Study_02_00_Object;

//사실 모든 클래스는 Object라는 클래스의 자식 클래스이다
//class A (extends Object)-생략
//위와 같다
//
/*
 * toString()이라는 메소드는 객체를 문자화시키는 메소드이다
 * 사실 모든 객체 뒤에 .toString()이라는 메소드가 이미 붙어있다
 * 암시적으로 그렇다
 * 
 * System.out.println(c1);
 * System.out.println(c1.toString());
 * 두개가 같은 결과를 출력하게 한다.
 *  
 *  toString()이라는 메소드를 overriding하게 만들 수 있다.
 *  
 *  
 * */

/*
 * finalize이라는 메소드도 았다.
 * 이 메소드는 자바의 garbage collection과 관련이 있다.
 * */

class Student{
    String name;
    Student(String name){
        this.name = name;
    }
    public boolean equals(Object obj) {//equals의 overriding
    	//signature는 변경이 불가능
    	//뭐가 들어올지 모르는 경우, 그냥 Object 데이터 타입을 이용한다.
    	
    	//자식 데이터타입은 부모 데이터 타입에 할당이 가능하다
    	//따라서 s2는 Object 데이터타입으로 할당가능하다
    	//그러나 Object obj는 name이라는 변수에 접근이 불가능하다
    	// 왜냐하면 Object에는 name이라는 멤버가 존재하지 않기 때문이다.
    	//다시 obj를 Student 데이터타입으로 바꿀 필요가 있다.
    	// Student _s = obj;를 강제 형변환(casting)시켜야함
    	// Object -obj = s;는 가능. 자식은 자연스럽게 부모행세를 할 수 있음
    	//자식이 부모행사를 하면 자식은 부모의 특성을 이미 가지고 있고,
    	//그저 부모가 가지지 못한 특성을 그냥 없는척하면 그만이다.
    	//부모입장에서는 자식이 가지는 특성이 어떤 것인지 모르게 때문에 그것 새로 만들어야함
    	//그래서 Student _s = (Student)obj;로 강제 형변환시키면 된다.
    	//데이터 형식을 강제적으로 변환하면 된다
    	
    	/*
    	 * Object -obj = s;
    	 * Student _s = (Student)obj;
    	 **/
    	
    	//equals는 hashCode()에 대해 알아야할 필요가 있다.
    	
        Student _s = (Student)obj;
        return name == _s.name;
    }
}

public class Study_02_00_Object {

	public static void main(String[] args) {
		 Student s1 = new Student("egoing");
	        Student s2 = new Student("egoing");
	        System.out.println(s1 == s2);
	        System.out.println(s1.equals(s2));
	}
}
