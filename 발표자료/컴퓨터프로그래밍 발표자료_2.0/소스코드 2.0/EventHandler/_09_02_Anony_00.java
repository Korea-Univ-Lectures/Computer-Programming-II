package EventHandler;

class Ex2{
	public void print(){
		System.out.println("Good");
	}
}

public class _09_02_Anony_00 {

	public static void main(String[] args) {
		Ex2 e1 = new Ex2(){
			public void print() {System.out.println("bad");}
			};
		e1.print();

		Ex2 e2 = new Ex2(){
			public void print() {System.out.println("So-so");}
			};
		e2.print();

		Ex2 e3 = new Ex2(){
			public void print() {System.out.println("Great");}
			};
		e3.print();

	}

}
