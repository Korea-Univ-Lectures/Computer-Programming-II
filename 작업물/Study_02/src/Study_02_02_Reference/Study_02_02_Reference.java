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
		//���� ���� �޼ҵ��� �Ű������� ������ ���� �۵��Ѵ�.
		//int b=a;�̴�.
		//�� �ǹ̴� b=1;�̰�, ���� �ڵ� �ٿ��� b=2;���� �ٲ��.
		//������ a�� ������ ���� ������ ��ġ�� ���Ѵ�.
		System.out.println(a);
	}
	
	static void _reference(A b){
		b= new A(2);
	}
	
	static void runReference1(){
		A a = new A(1);
		_reference(a);
		//�̰��� A b= a;�̴� ��� ���̴�.
		//b= new A(2);�� b�� ���ο� �ν��Ͻ��� �����ϰ� �Ǿ���.
		//�׷��� a�� �����ϴ� �ν��Ͻ����� ��ȭ�� ����.
		System.out.println(a.id);
	}
	
	static void _reference2(A b){
		b.id=2;
	}
	
	static void runReference2(){
		A a = new A(1);
		_reference2(a);
		//A b =a;�̴�. b�� a�� �����ϴ� ���� �����ϰ� �ִ�.
		//b.id=2;�� ���� �޶���������.
		System.out.println(a.id);
	}
	
	public static void runReference(){
		A a = new A(1);
		A b= a;//�̰��� �ν��Ͻ�b�� �ν��Ͻ�a�� �����ϴ� ���� �����ϰ� ������ ��Ÿ����!
		b.id =2;
		System.out.println(a.id);
		
		A c= new A(2);//�� �ٸ� ��������� �������	
		
		
		
		//-->2�� ��µȴ�! a.id �� 2!
	}
	
	public static void main (String args[]){
		runReference();
	}
}
