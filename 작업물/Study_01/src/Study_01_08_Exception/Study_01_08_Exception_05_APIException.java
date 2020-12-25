package Study_01_08_Exception;
/*���ܸ� ����� ���� �ؾ� �� ���� �ڽ��� ���ܸ� checked�� �� ���ΰ�?
 * unchecked�� �� ���ΰ��� ���ؾ� �Ѵ�. �� ������ ��ȣ�� ������. 
 * ������ ������ ���� �͵� �ƴϴ�.
 * 
 * API �ʿ��� ���ܸ� ������ ��
 * API ����� �ʿ��� ���� ��Ȳ�� ���� �� �� �ִٸ� checked ���ܸ� ����Ѵ�. 
 * 
 * checked ���ܴ�
 * ����ڿ��� ������ �ذ��� ��ȸ�� �ִ� ���̸鼭
 * ����ó���� �����ϴ� ���̴�.
 * 
 * ������ checked ���ܸ� �ʹ� ���� ����ϸ�
 * API ����ڸ� ���� ����� �� �� �ֱ� ������
 * �������� ã�� ���� �߿��ϴ�.
 *  
 *  
 * ����ڰ� API�� ������� ��ܼ� �߻��ϴ� �����ų� ���� ��Ȳ�� �̹� �߻��� ��������
 * �׳� ���α׷��� �����ϴ� ���� �� ���� �� �� unchecked�� ����Ѵ�. 
 * 
 * ������ ArithmeticException�� ���� ���� Exception���� ��ü�غ���.
 * */
class DivideException extends RuntimeException {
    DivideException(){
        super();
    }
    DivideException(String message){
        super(message);
    }
}

class Calculator2{
    int left, right;
    public void setOprands(int left, int right){        
        this.left = left;
        this.right = right;
    }
    public void divide(){
        if(this.right == 0){
            throw new DivideException("0���� ������ ���� ������ �ʽ��ϴ�.");
        }
        System.out.print(this.left/this.right);
    }
}


public class Study_01_08_Exception_05_APIException {
	
	public static void main(String[] args) {
		Calculator2 c1 = new Calculator2();
	    c1.setOprands(10, 0);
	    c1.divide();
	    }
}


