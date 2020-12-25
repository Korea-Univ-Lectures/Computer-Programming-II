package Study_00;

public class Study_00_07_Array {

	public static void main(String[] args) {
		String[] classGroup= {"Aba", "Lily", "James"};
		for(int i=0;i<3;i++){
			System.out.println(classGroup[i]);
		}
		
		System.out.println(classGroup.length);
		//    .length는 배열의 길이를 알려주는 연산자이다.
		String[] anyArray= new String[4];//또 다른 배열의 정의방법
		System.out.println(anyArray.length);
		
		
		
		for(int i =0 ;i<(classGroup.length);i++){
			String student=classGroup[i];
			System.out.println(student+" is dead");
		}
		
		for(String student:classGroup){
			System.out.println(student + " is dead.");
		}
		//위 두 반복문은 기능이 정확히 동일하다.
	}

}
