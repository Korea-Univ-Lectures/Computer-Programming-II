package Study_01_00_object;

class Calculator5{
	int left, right;
	 
    public Calculator5(int left, int right) {//이것이 바로 "생성자"!
        this.left = left;//매개 변수로 받은 것은 인스턴스에 넣어버림!
        this.right = right;
        //생성자는 값을 반환하지 않음.
    }
 
    void sum() {
        System.out.println(this.left + this.right);
    }
 
    void avg() {
        System.out.println((this.left + this.right) / 2);
    }

	
}

public class Study_01_07_Constructor {

	public static void main(String[] args) {
		Calculator5 c1 = new Calculator5(10, 20);
        c1.sum();
        c1.avg();
 
        Calculator5 c2 = new Calculator5(20, 40);
        c2.sum();
        c2.avg();
        
        //c2.setOprands(10, 20);를 사용할 이유가 없음
	}

}
