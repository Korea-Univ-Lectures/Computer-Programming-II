package Study_02_00_Object;

//��� ��� Ŭ������ Object��� Ŭ������ �ڽ� Ŭ�����̴�
//class A (extends Object)-����
//���� ����
//
/*
 * toString()�̶�� �޼ҵ�� ��ü�� ����ȭ��Ű�� �޼ҵ��̴�
 * ��� ��� ��ü �ڿ� .toString()�̶�� �޼ҵ尡 �̹� �پ��ִ�
 * �Ͻ������� �׷���
 * 
 * System.out.println(c1);
 * System.out.println(c1.toString());
 * �ΰ��� ���� ����� ����ϰ� �Ѵ�.
 *  
 *  toString()�̶�� �޼ҵ带 overriding�ϰ� ���� �� �ִ�.
 *  
 *  
 * */

/*
 * finalize�̶�� �޼ҵ嵵 �Ҵ�.
 * �� �޼ҵ�� �ڹ��� garbage collection�� ������ �ִ�.
 * */

class Student{
    String name;
    Student(String name){
        this.name = name;
    }
    public boolean equals(Object obj) {//equals�� overriding
    	//signature�� ������ �Ұ���
    	//���� ������ �𸣴� ���, �׳� Object ������ Ÿ���� �̿��Ѵ�.
    	
    	//�ڽ� ������Ÿ���� �θ� ������ Ÿ�Կ� �Ҵ��� �����ϴ�
    	//���� s2�� Object ������Ÿ������ �Ҵ簡���ϴ�
    	//�׷��� Object obj�� name�̶�� ������ ������ �Ұ����ϴ�
    	// �ֳ��ϸ� Object���� name�̶�� ����� �������� �ʱ� �����̴�.
    	//�ٽ� obj�� Student ������Ÿ������ �ٲ� �ʿ䰡 �ִ�.
    	// Student _s = obj;�� ���� ����ȯ(casting)���Ѿ���
    	// Object -obj = s;�� ����. �ڽ��� �ڿ������� �θ��༼�� �� �� ����
    	//�ڽ��� �θ���縦 �ϸ� �ڽ��� �θ��� Ư���� �̹� ������ �ְ�,
    	//���� �θ� ������ ���� Ư���� �׳� ����ô�ϸ� �׸��̴�.
    	//�θ����忡���� �ڽ��� ������ Ư���� � ������ �𸣰� ������ �װ� ���� ��������
    	//�׷��� Student _s = (Student)obj;�� ���� ����ȯ��Ű�� �ȴ�.
    	//������ ������ ���������� ��ȯ�ϸ� �ȴ�
    	
    	/*
    	 * Object -obj = s;
    	 * Student _s = (Student)obj;
    	 **/
    	
    	//equals�� hashCode()�� ���� �˾ƾ��� �ʿ䰡 �ִ�.
    	
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
