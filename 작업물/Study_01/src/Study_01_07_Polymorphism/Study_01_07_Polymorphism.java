package Study_01_07_Polymorphism;

class A{
	public String x(){return "A.x";}
}
class B extends A{
	public String x(){return "B.x";}
	public String y(){return "y";}
}
class B2 extends A{
	public String x(){return "B2.x";}
} 

public class Study_01_07_Polymorphism {

	public static void main(String[] args) {
		A obj = new B();
		//class B�� �ν��Ͻ�ȭ ���״µ�, �̰��� ��ġ A Ŭ������ ��ó�� �ൿ��!
		
		
		System.out.println(obj.x());
		//��� ����� "B.x"�̴�. 
		
		//System.out.println(obj.y);
		//�� �ڵ�� ������� �ֳ��ϸ�, class A������ �޼ҵ� y�� ���ǵ��� �ʾұ� �����̴�
		
		/*
		 * A obj = new B();-> Ŭ���� B�� A�� ������Ÿ������ �ν��Ͻ�ȭ ��Ŵ!
		 * 1. A�� �����ϴ� �ɹ����� Ŭ���� B�� �ɹ��� �ȴ�.
		 * 2. Ŭ���� B���� �������̵��� �ɹ��� ���۹���� �״�� �����Ѵ�
		 * */
		
		A obj2 =new B2();
		System.out.println(obj2.x());
	}

}
