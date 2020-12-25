package Study_01_08_Exception;

class A{
	private int []arr =new int[3];
	
	A() {
		arr[0]=0;
		arr[1]=10;
		arr[2]=20;
	}
	
	public void z(int first, int last){
		try{
			System.out.println(arr[first]/arr[last]);
		}
		//catch는 다양하게 쓸 수 있다.
		catch (ArrayIndexOutOfBoundsException e){
			System.out.println("ArrayIndexOutOfBoundsException");
		}
		
		catch (ArithmeticException e){
			System.out.println("ArithmeticException");
			}
		
		//에러의 폭이 넓은 Exception을 가장 아래에 두어야한다
		catch (Exception e){
			System.out.println("Exception");
		}
		
		//finally는 예외 상황과 관계없이 무조건적으로 실행되는 코드이다.
		finally{
			System.out.println("finally");
		}
	}
}

public class Study_01_08_Exception_01 {

	public static void main(String[] args) {
		 A a = new A();
	        a.z(10, 0);
	        a.z(1, 0);
	        a.z(2, 1);
	}

}
