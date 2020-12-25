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
		//catch�� �پ��ϰ� �� �� �ִ�.
		catch (ArrayIndexOutOfBoundsException e){
			System.out.println("ArrayIndexOutOfBoundsException");
		}
		
		catch (ArithmeticException e){
			System.out.println("ArithmeticException");
			}
		
		//������ ���� ���� Exception�� ���� �Ʒ��� �ξ���Ѵ�
		catch (Exception e){
			System.out.println("Exception");
		}
		
		//finally�� ���� ��Ȳ�� ������� ������������ ����Ǵ� �ڵ��̴�.
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
