package Study_01_00_object;

class Cal9{
	int left, right, third=0;
	/* ���� �̸�, ���� ���� ���� ���� �޼ҵ尡
	 * �ٸ� �Ű����� (����, Ÿ��, ����)�� �ٸ� ó������� ������ �ϴ� ���� 
	 * overriding�̶�� �Ѵ�. 
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
