package Study_00;

public class Study_00_03_Blooean {

	public static void main(String[] args) {
		System.out.println(1==2);
		System.out.println(1==1);
		
		System.out.println();
		
		System.out.println(1!=2);
		System.out.println(1!=1);
		
		System.out.println();
		
		System.out.println("One"=="one");
		System.out.println();
		//==�� �ΰ��� ������ Ÿ���� ������ ��ü���� �˾Ƴ��� ���� ����ϴ� �������̴�
		String a="Hello";
		String b= new String("Hello");
		
		System.out.println(a==b);
		System.out.println(a.equals(b));
		//���ڿ��� ���� ������ ==�� �ƴ� ".equals"�� ����Ѵ�.
		
	}

}
