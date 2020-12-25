package Study_01_00_object;

class Cal9{
	int left, right, third=0;
	/* 같은 이름, 같은 리턴 값을 가진 메소드가
	 * 다른 매개변수 (갯수, 타입, 순서)와 다른 처리방식을 가지게 하는 것을 
	 * overriding이라고 한다. 
	 * */
	public void setOprands(int left, int right){
		this.left=left;
		this.right=right;
	}
	public void setOprands(int left, int right, int third){
		this.left=left;
		this.right=right;
		this.third=third;
	}
}

public class Study_01_12_overloading {

	public static void main(String[] args) {

	}

}
