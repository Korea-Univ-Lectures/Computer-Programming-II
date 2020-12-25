package Study_01_06;

public class Study_01_06_Interface {
	//하나의 클래스가 여러개의 인터패이스를 구현가능!
	/*
	 * interface I1{
       public void x();
       }
       
       interface I2{
       public void z();
       }
       class A implements I1, I2{
       public void x(){}
       public void z(){}
       }
	 */
	
	//인터페이스도 상속이 된다
	/*interface I3{
	    public void x();
	}
	 
	interface I4 extends I3{
	    public void z();
	}
	 
	class B implements I4{
	    public void x(){}
	    public void z(){}   
	}
*/
	
	
	//인터페이스의 멤버는 반드시 public이다!
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
