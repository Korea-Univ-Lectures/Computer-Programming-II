package Study_00;

public class Study_00_07_Array {

	public static void main(String[] args) {
		String[] classGroup= {"Aba", "Lily", "James"};
		for(int i=0;i<3;i++){
			System.out.println(classGroup[i]);
		}
		
		System.out.println(classGroup.length);
		//    .length�� �迭�� ���̸� �˷��ִ� �������̴�.
		String[] anyArray= new String[4];//�� �ٸ� �迭�� ���ǹ��
		System.out.println(anyArray.length);
		
		
		
		for(int i =0 ;i<(classGroup.length);i++){
			String student=classGroup[i];
			System.out.println(student+" is dead");
		}
		
		for(String student:classGroup){
			System.out.println(student + " is dead.");
		}
		//�� �� �ݺ����� ����� ��Ȯ�� �����ϴ�.
	}

}
