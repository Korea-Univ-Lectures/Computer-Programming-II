package Study_01_00_object;

class Calculator6{
	int left,right;
	
	public void setOprands(int left, int right){
		this.left=left;
		this.right=right;
	}
	
	public void add(){
		System.out.println(this.left + this.right);
	}
	
	public void avg(){
		System.out.println((this.left+this.right)/2);
	}
	
}

class subCalculator extends Calculator6{
	public void sub(){
		System.out.println(this.left-this.right);
	}
}

class multiCalculator extends subCalculator{
	public void multi(){
		System.out.println(this.left*this.right);
	}
}

public class Study_01_08_inheritance {

	public static void main(String[] args) {
		subCalculator c1 = new subCalculator();
		c1.setOprands(10,20);
		c1.add();
		c1.sub();
		
		System.out.println();
		
		multiCalculator c2= new multiCalculator();
		c2.setOprands(30, 40);
		c2.add();
		c2.sub();
		c2.multi();
		
	}

}
