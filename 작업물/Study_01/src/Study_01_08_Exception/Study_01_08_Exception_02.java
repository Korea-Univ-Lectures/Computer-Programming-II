package Study_01_08_Exception;
import java.io.*;

//� ���ܴ� �ݵ�� ó���Ǿ���ϰ�, � ���ܴ� �ٸ� ������� �ñ��
//�����ϰ� try-catch�������� ó���Ǿ�� �ϴ� ���ܵ� �ִ�(���� �����ó��!)
//���ܴ� �������� ���̴�. �ٽø��� throw�Ǵ� ���̴� catch�� �̰��� Ź ��� ���̴�.
//�츮�� ���ܸ� �ٸ� ����鿡�� ���ܸ� ���� �� �ִ�

//class B�� ����ڴ� class C�̰�,
//class C�� ����ڴ� ���� �޼ҵ尡 ���Ե� Ŭ�����̰�,
//���� �޼ҵ尡 ���Ե� Ŭ������ ����ڴ� ���Ǽ����� User�̴�

//���� ó���� ������ ����ڿ��� ���� �� �ִ�.
//���Ǽ����� User���� ����ó���� �ñ�ٴ� ���� �ڵ����� ���α׷��� �����ϰڴٴ� ���̴�


class B{
    void run() throws IOException, FileNotFoundException{
    	//���� ����ڿ��� ����å���� ������ -->class C
    	
        BufferedReader bReader = null;
        String input = null;
        bReader = new BufferedReader(new FileReader("out.txt"));
        input = bReader.readLine();
        System.out.println(input);
    }
}
class C{
    void run() throws IOException, FileNotFoundException{
    	//���� ����ڿ��� ����å���� ������ -->class Study_01_08_Exception_02
    	
        B b = new B();
        try {
            b.run();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Study_01_08_Exception_02 {

	public static void main(String[] args) {
		//���⿡�� ����ó���� å���� ����
			 C c = new C();
	         try {
	            c.run();
	        } catch (FileNotFoundException e) {
	            System.out.println("out.txt ������ ���� ���� �Դϴ�. �� ������ ������Ʈ ��Ʈ ���丮�� �����ؾ� �մϴ�.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}   
}

