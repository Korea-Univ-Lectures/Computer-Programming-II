package Study_01_00_object;

class Calculator7 {
    int left, right;
    
   
    /*
    	자식클래스에서 부모클래스를 상속함. 
    	그 과정에서는 자식클래스는 부모클래스의 기본생성자를 자동으로 호출함
    	그런데 인위적으로 개발자가 생성자를 만들어버리면 기본생성자는 없어짐.
    	->에러 발생
    	그래서 인위적으로 기본 생성자를 만들어줌
    	// public Calculator (){}!!
    	 
    	그런데 개발자가 만든 부모의 생성자과 자식의 생성자가 하는 일이 똑같음!(중복)
    	그럴 때는 "super"라는 것을 사용하면 된다!
    	37행으로! 가라!
     */
     
    
    public Calculator7(int left, int right) {
        this.left = left;
        this.right = right;
    }
 
    public void sum() {
        System.out.println(this.left + this.right);
    }
 
    public void avg() {
        System.out.println((this.left + this.right) / 2);
    }
}
 
class SubstractionableCalculator extends Calculator7 {
    public SubstractionableCalculator(int left, int right) {
    	super(left, right);
    	//super는 부모클래스를 의미한다.
    	//super();는 부모클래스의 생성자를 의미
    	//단 자식 클래스의 초기화 코드는 super();보다 먼저 있으면 안된다.
    	//하위 클래스가 인스턴스화 되려면, 이미 상위클래스가 인스턴스화되어 있어야한다.
    	//부모클래스의 생성자가 이미 실행되었어야, 자식클래스의 생성자가 실행될 수 있다.
    }
    
    public void substract() {
        System.out.println(this.left - this.right);
    }
}

public class Study_01_10_BasicConstructor_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
