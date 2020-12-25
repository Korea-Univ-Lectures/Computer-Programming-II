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
    /* overriding: �ڽ�Ŭ������ �θ�Ŭ�������� ��ӹ��� �޼ҵ带 �����ϴ� ��
	 * overriding�� �Ϸ��� signature(����)��(��) ���ƾ��Ѵ�.
	 * signature(����)�� ũ�� 3���� ����̴�.
	 * 1. �޼ҵ��� �̸�
	 * 2. �ްԺ����� ����, Ÿ��, ����
	 * 3. �ް� ������ ���ϰ�
	*/
    public void sum(){System.out.println("���� "+(left+right)+"�Դϴ�.");}
    public void avg(){
    	super.avg();//�θ�Ŭ������ �޼ҵ� ȣ��!!
    	sum();
    	super.sum();
    	System.out.println("����Դϴ�.");
    	}
}

public class Study_01_11_overriding {

	public static void main(String[] args) {
		SubCal2 c1 = new SubCal2(20, 30);
		c1.sum();
		c1.avg();
	}

}