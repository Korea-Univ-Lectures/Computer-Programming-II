package EventHandler;

class Ex{
	int var=1;

	class Inner{
		void Print () {System.out.println(var);}
	}
	
	void Print(){
		Inner in = new Inner();
		in.Print();
	}
}

public class _09_01_Innerclass_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
