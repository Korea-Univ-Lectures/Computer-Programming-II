package Study_02_03_Generic;

abstract class Info{
    public abstract int getLevel();
}

class EmployeeInfo3 extends Info{
    public int rank;
    EmployeeInfo3(int rank){ this.rank = rank; }
    public int getLevel(){
        return this.rank;
    }
}

class Person3<T extends Info>{
	//제네릭으로 오는 데이터 타입을 특정 클래스의 자식으로 제한시킬 수 있다!!
    public T info;
    Person3(T info){ this.info = info; }
}

interface Info2{
    int getLevel();
}

class EmployeeInfo2 implements Info2{
    public int rank;
    EmployeeInfo2(int rank){ this.rank = rank; }
    public int getLevel(){
        return this.rank;
    }
}

//마찬가지로, 제네릭으로 오는 데이터 타입은 implements의 관계에서도 성립가능하다
class Person2<T extends Info>{
	//여기서의 extends는 상속의 의미가 아닌 부모가 누구냐를 묻는 extends이다
    public T info;
    Person2(T info){ this.info = info; }
}

public class Study_02_03_Generic_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
