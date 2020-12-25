package Study_02_03_Generic;
//Generic�� �⺻ ������ Ÿ���� �� �� ����.
//Generic�� ���� ������ Ÿ�Ը� �� �� �ִ�.
//�׷��� �⺻ ������ Ÿ���� ��ġ ��ü�� ��ó�� ����� ����Ѵ�.
//wrapper class�� ����ؼ� ��ġ �⺻ �����͸� ��ó�� ��ó�� �ٸ��ش�!

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
    
    //�޼ҵ� ���������� �������� ��밡��!
    public <U> void printInfo(U info){
    	System.out.println(info);
    }
}

public class Study_02_03_Generic {

	public static void main(String[] args) {
		// Person<EmployeeInfo, int> p1 = new Person<EmployeeInfo, int>(new EmployeeInfo(1), 1);
		
		//Wrapping�� �ʿ�!
		Integer id = new Integer(1);
		Person<EmployeeInfo, Integer> p1 = new Person<EmployeeInfo, Integer>(new EmployeeInfo(1), id);
		System.out.println(p1.id.intValue());
		//intValue�� int�� ���� �ǵ����ִ� �޼ҵ��̴�
		
		//���׸��� ���������ϴ�
		EmployeeInfo e= new EmployeeInfo(1);
		Integer i = new Integer(1);
		Person<EmployeeInfo, Integer> p2 = new Person<EmployeeInfo, Integer>(e, i);
		Person p3 = new Person(e, i);
		
		p2.<EmployeeInfo>printInfo(e);
		//���׸��� ���������ϴ�
		p2.printInfo(e);
		
	}

}
