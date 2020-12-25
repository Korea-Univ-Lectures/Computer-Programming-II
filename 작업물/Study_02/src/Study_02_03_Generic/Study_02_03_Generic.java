package Study_02_03_Generic;
//Generic은 기본 데이터 타입이 올 수 없다.
//Generic은 참조 데이터 타입만 올 수 있다.
//그래서 기본 데이터 타입을 마치 객체인 것처럼 만들어 줘야한다.
//wrapper class를 사용해서 마치 기본 데이터를 객처인 것처럼 꾸며준다!

class EmployeeInfo{
    public int rank;
    EmployeeInfo(int rank){ this.rank = rank; }
}

class Person<T, S>{
    public T info;
    public S id;
    Person(T info, S id){ 
        this.info = info; 
        this.id = id;
    }
    
    //메소드 차원에서도 제레릭을 사용가능!
    public <U> void printInfo(U info){
    	System.out.println(info);
    }
}

public class Study_02_03_Generic {

	public static void main(String[] args) {
		// Person<EmployeeInfo, int> p1 = new Person<EmployeeInfo, int>(new EmployeeInfo(1), 1);
		
		//Wrapping이 필요!
		Integer id = new Integer(1);
		Person<EmployeeInfo, Integer> p1 = new Person<EmployeeInfo, Integer>(new EmployeeInfo(1), id);
		System.out.println(p1.id.intValue());
		//intValue는 int로 값을 되돌려주는 메소드이다
		
		//제네릭은 생략가능하다
		EmployeeInfo e= new EmployeeInfo(1);
		Integer i = new Integer(1);
		Person<EmployeeInfo, Integer> p2 = new Person<EmployeeInfo, Integer>(e, i);
		Person p3 = new Person(e, i);
		
		p2.<EmployeeInfo>printInfo(e);
		//제네릭은 생략가능하다
		p2.printInfo(e);
		
	}

}
