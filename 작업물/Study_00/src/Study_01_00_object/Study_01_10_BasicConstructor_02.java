package Study_01_00_object;

class Calculator7 {
    int left, right;
    
   
    /*
    	�ڽ�Ŭ�������� �θ�Ŭ������ �����. 
    	�� ���������� �ڽ�Ŭ������ �θ�Ŭ������ �⺻�����ڸ� �ڵ����� ȣ����
    	�׷��� ���������� �����ڰ� �����ڸ� ���������� �⺻�����ڴ� ������.
    	->���� �߻�
    	�׷��� ���������� �⺻ �����ڸ� �������
    	// public Calculator (){}!!
    	 
    	�׷��� �����ڰ� ���� �θ��� �����ڰ� �ڽ��� �����ڰ� �ϴ� ���� �Ȱ���!(�ߺ�)
    	�׷� ���� "super"��� ���� ����ϸ� �ȴ�!
    	37������! ����!
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
    	//super�� �θ�Ŭ������ �ǹ��Ѵ�.
    	//super();�� �θ�Ŭ������ �����ڸ� �ǹ�
    	//�� �ڽ� Ŭ������ �ʱ�ȭ �ڵ�� super();���� ���� ������ �ȵȴ�.
    	//���� Ŭ������ �ν��Ͻ�ȭ �Ƿ���, �̹� ����Ŭ������ �ν��Ͻ�ȭ�Ǿ� �־���Ѵ�.
    	//�θ�Ŭ������ �����ڰ� �̹� ����Ǿ����, �ڽ�Ŭ������ �����ڰ� ����� �� �ִ�.
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
