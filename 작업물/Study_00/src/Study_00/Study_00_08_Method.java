package Study_00;
//  main(String[] args) {   }�̰��� �޼ҵ��� �� �����̴�
//�޼ҵ带 ����� ���� "����", ������� �޼ҵ带 �����ϴ� ���� "ȣ��"�̶�� �Ѵ�.
public class Study_00_08_Method {
	
	public static String numbering(int init, int limit){
		int i= init;
		String output="";
		
		while(i<limit){
			output+=i;//���ڿ��� �߰�!
			i++;
		}
		return output;
	}

	public static void main(String[] args) {
		String result;
		result=numbering(1,9);
		System.out.println(result);
	}

}
