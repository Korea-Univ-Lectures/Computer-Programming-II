package Study_01_00_object;

class Calculator{//class�� ������ ������ �޼ҵ��� �����̴�.
	int left, right;
	
	public void setOprands(int left, int right){
		//�� �޼ҵ� setOprands�� �ŰԺ��� left, right�� �� �޼ҵ� �ȿ����� ���δ�
		//��, �ٸ� �޼ҵ峪 �� �޼ҵ� �ۿ� �ִ� ���� ������ �Ұ����ϴ�
		//this.�� Ŭ������ ���� ������� �ν��Ͻ� �ڽ��� ����Ű�� ���̴�.
		//this.left, this.right�� 4�࿡ ����� ������ �ǹ��Ѵ�. 
		//�ٽø��� �޼ҵ� �ۿ� ����� �����̴�.
		//setOprands�޼ҵ�� this.left=left;�� �̿��Ͽ� �ٸ� �޼ҵ忡���� ���� left,right�� ��밡���ϰ� �Ϸ��� ���̴�.
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
		Calculator c1 =new Calculator();//Ŭ������ ���赵�� �Ͽ� �ν��Ͻ���� ��ǰ�� ����.
		Calculator c2 =new Calculator();
		
		c1.setOprands(10, 20);
		c1.sum();
		c1.avg();
		
		c2.setOprands(30, 40);
		c2.sum();
		c2.avg();
		
	}

}
