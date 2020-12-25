package Study_00;

public class Study_00_05_conditions {

	public static void main(String[] args) {
		String id =args [0];
		String password = args[1];
		
		if(id.equals("backgom07")&&password.equals("1111")){
			System.out.println("Right");
		}
		else{
			System.out.println("Wrong");
		}
		//   ||은 or을 상징한다.     !은 not을 상징한다.

	}

}
