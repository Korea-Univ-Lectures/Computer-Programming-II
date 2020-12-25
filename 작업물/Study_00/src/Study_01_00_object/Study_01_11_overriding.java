package Study_01_00_object;

class Cal8 {
    int left, right;
    
    public Cal8(int left, int right) {
        this.left = left;
        this.right = right;
    }
    public void sum() {System.out.println(this.left + this.right);}
    public void avg() {System.out.println((this.left + this.right) / 2);}
}
 
class SubCal2 extends Cal8 {
    public SubCal2(int left, int right) {super(left, right);}
    public void sub() {System.out.println(this.left - this.right);}
    /* overriding: 자식클래스가 부모클래스에게 상속받은 메소드를 변형하는 것
	 * overriding을 하려면 signature(서명)가(이) 같아야한다.
	 * signature(서명)은 크게 3가지 요소이다.
	 * 1. 메소드의 이름
	 * 2. 메게변수의 갯수, 타입, 순서
	 * 3. 메게 변수의 리턴값
	*/
    public void sum(){System.out.println("합은 "+(left+right)+"입니다.");}
    public void avg(){
    	super.avg();//부모클래스의 메소드 호출!!
    	sum();
    	super.sum();
    	System.out.println("평균입니다.");
    	}
}

public class Study_01_11_overriding {

	public static void main(String[] args) {
		SubCal2 c1 = new SubCal2(20, 30);
		c1.sum();
		c1.avg();
	}

}