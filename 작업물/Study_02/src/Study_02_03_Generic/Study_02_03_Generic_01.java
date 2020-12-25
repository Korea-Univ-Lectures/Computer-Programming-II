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
	//���׸����� ���� ������ Ÿ���� Ư�� Ŭ������ �ڽ����� ���ѽ�ų �� �ִ�!!
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

//����������, ���׸����� ���� ������ Ÿ���� implements�� ���迡���� ���������ϴ�
class Person2<T extends Info>{
	//���⼭�� extends�� ����� �ǹ̰� �ƴ� �θ� �����ĸ� ���� extends�̴�
    public T info;
    Person2(T info){ this.info = info; }
}

public class Study_02_03_Generic_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
