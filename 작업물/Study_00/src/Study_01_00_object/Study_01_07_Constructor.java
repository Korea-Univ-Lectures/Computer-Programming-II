package Study_01_00_object;

class Calculator5{
	int left, right;
	 
    public Calculator5(int left, int right) {//�̰��� �ٷ� "������"!
        this.left = left;//�Ű� ������ ���� ���� �ν��Ͻ��� �־����!
        this.right = right;
        //�����ڴ� ���� ��ȯ���� ����.
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
        
        //c2.setOprands(10, 20);�� ����� ������ ����
	}

}
