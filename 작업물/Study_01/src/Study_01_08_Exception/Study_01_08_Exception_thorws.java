package Study_01_08_Exception;

class Calculator{
    int left, right;
    
    public void setOprands(int left, int right){
        this.left = left;
        this.right = right;
    }
    
    public void divide(){
    	
    	if(this.right == 0){
    		try {
    			throw new DivideException("0���� ������ ���� ������ �ʽ��ϴ�.");
                } 
    		
    		catch (DivideException e) {
                e.printStackTrace();
    		}
    	System.out.print("������� "+this.left/this.right+" �Դϴ�.");
    	}
    } 
}
public class Study_01_08_Exception_thorws {
	public static void main (String[] args) {
        Calculator c1 = new Calculator();
        c1.setOprands(10, 0);
        c1.divide();
    }
}
