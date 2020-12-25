package Study_00;
//  main(String[] args) {   }이것이 메소드의 한 종류이다
//메소드를 만드는 것을 "정의", 만들어진 메소드를 실행하는 것을 "호출"이라고 한다.
public class Study_00_08_Method {
	
	public static String numbering(int init, int limit){
		int i= init;
		String output="";
		
		while(i<limit){
			output+=i;//문자열에 추가!
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
