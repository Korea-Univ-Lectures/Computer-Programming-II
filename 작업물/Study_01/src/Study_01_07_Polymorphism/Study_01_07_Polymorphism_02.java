package Study_01_07_Polymorphism;

abstract class calculator {
	int left, right;
	
	public calculator (int left, int right){
		this.left=left;
		this.right=right;
	}
	public abstract void sum(); 
	
	public abstract void avg();
	
	public void run(){
		sum();
		avg();
	}
}

class plusCal extends calculator {
	public plusCal (int left, int right){
		super(left, right);
	}
	
	public void sum(){
		System.out.println("++++"+(this.left+this.right)+"++++");
	}
	public void avg(){
		System.out.println("++++"+((this.left+this.right)/2)+"++++");
	}
}

class minusCal extends calculator {
	public minusCal (int left, int right){
		super(left, right);
	}
	
	public void sum(){
		System.out.println("----"+(this.left+this.right)+"----");
	}
	public void avg(){
		System.out.println("----"+((this.left+this.right)/2)+"----");
	}
}

public class Study_01_07_Polymorphism_02 {
	
	public static void excute (calculator cal){
		System.out.println("Excution Result:");
		cal.run();
	}
	
	public static void main(String[] args) {
		calculator p = new plusCal(10, 20);
		calculator m = new minusCal(20, 30);
		
		excute(p);
		excute(m);
		
		/* ���� �ν���Ʈȭ �����߿��� ������ ������Ÿ���� ���� �ʾҴ����,
		 * excute�� �Ű����� Ÿ���� �ٸ��� �����ϴ� ���� ������ ���� �Ͼ�� ��.
		 * 
		 *  */
	}

}
