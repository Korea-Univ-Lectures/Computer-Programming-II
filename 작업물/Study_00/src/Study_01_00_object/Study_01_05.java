package Study_01_00_object;

public class Study_01_05 {
	
	static int i=5;//Ŭ���� ����, Ŭ���� ��ü�� ������ ��ħ �׷��� �켱���� ������
	
	static void a(){
		int i=10;//Ŭ���� �޼ҵ� ���� ����, �޼ҵ尡 ������ �����
		//��������-> Ư���Ѱ��, �켱���� ������
		b();
	}
	
	static void b(){
		System.out.println(i);//a�� i�� ������� �ʰ�, ����������i�� ����Ѵ�
		//�ٷ� "����"�� ���������� ������ Ȱ��!
		
	}
	
	public static void main(String[] args) {
		for(i=0;i<5;i++){//���⼭�� i�� 5���� i�̴�, ���������� i�̴�
			a();//���⼭�� �޼ҵ� ���� i���� �ٷ��, �޼ҵ尡 ������ �������.
			System.out.println(i);
		}
	}

}
