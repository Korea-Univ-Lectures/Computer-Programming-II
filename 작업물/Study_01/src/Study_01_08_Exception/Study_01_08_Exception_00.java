package Study_01_08_Exception;

class exceptionclass {
	 public void divide(int left,int right){
	        try {
	            System.out.print("������� ");
	            System.out.print(left/right);
	            System.out.print(" �Դϴ�.");
	            //try�� ���������� �Ǵ� �ڵ带 �ǹ�
	        } catch(Exception e){//������ ������ Ÿ���� Exception�̴�
	            //catch�� ������ ���� ������ �ڵ带 �ǹ�
	        	System.out.println("\n\ne.getMessage()\n"+e.getMessage());
	        	//getMessage();�� ������ ���� ���� �⺻���� ������ ����ϴ� �޼ҵ�
	        	
	            System.out.println("\n\ne.toString()\n"+e.toString());
	            //e.toString();�� ���� �ڼ��� ���� ������ ����
	            
	            System.out.println("\n\ne.printStackTrace()");
	            e.printStackTrace();
	            
	            //e.printStackTrace();�� ���� ���� ���� �޼ҵ� ���� �ڼ��� ���� ������ ����

	        }
	    }
}

public class Study_01_08_Exception_00 {

	public static void main(String[] args) {
		exceptionclass c = new exceptionclass();
		c.divide(10, 0);
	}

}
