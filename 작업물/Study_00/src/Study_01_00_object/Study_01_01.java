package Study_01_00_object;

class Calculator{//class는 연관된 변수와 메소드의 집합이다.
	int left, right;
	
	public void setOprands(int left, int right){
		//이 메소드 setOprands의 매게변수 left, right는 이 메소드 안에서만 쓰인다
		//즉, 다른 메소드나 이 메소드 밖에 있는 것은 접근이 불가능하다
		//this.는 클래스를 통해 만들어진 인스턴스 자신을 가리키는 말이다.
		//this.left, this.right는 4행에 선언된 변수를 의미한다. 
		//다시말해 메소드 밖에 선언된 변수이다.
		//setOprands메소드는 this.left=left;를 이용하여 다른 메소드에서도 변수 left,right를 사용가능하게 하려는 것이다.
		this.left=left;
		this.right=right;
	}
	
	public void sum(){
		System.out.println(this.left+this.right);
	}
	
	public void avg(){
		System.out.println((this.left+this.right)/2);
	}
	
}

public class Study_01_01 {

	public static void main(String[] args) {
		Calculator c1 =new Calculator();//클래스를 설계도로 하여 인스턴스라는 제품을 만듦.
		Calculator c2 =new Calculator();
		
		c1.setOprands(10, 20);
		c1.sum();
		c1.avg();
		
		c2.setOprands(30, 40);
		c2.sum();
		c2.avg();
		
	}

}
