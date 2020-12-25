package Study_01_08_Exception;

import java.io.IOException;

class E{
	void throwArithmeticException(){
        throw new ArithmeticException();
        //���ܸ� ������, ���� ó������ �ʾƵ� ������ �߻��ϴ� �� ������ �ʴ�
    }
	
    void throwIOException1(){
    	//IOException�� ������ ó���ϴ� ù��° ����� try-catch������ �̿��ϴ� ���̴�
        try {
            throw new IOException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    void throwIOException2() throws IOException{
    	//IOException�� ������ ó���ϴ� �ι�° ����� IOExceptionŬ������ å���� ���������� ���̴�.
        throw new IOException();
    }
/*
 * java.lang.Object //�ڹ��� ���� Ŭ����
 * 	����)java.lang.Throwable //throw������ �͵��� Ŭ����. �� Ŭ���� �ȿ�, ������ �־�� throw�� ������
 * 	java.lang.Throwable�� �޼ҵ���߿�����
 *	getMessage(), printStackTrace(), toString() ���� �ִ�
 * 		����)java.lang.Exception
 * 			����)java.lang.RuntimeException
 * 				����)java.lang.ArithmeticException
 * java.lang.Exception�� java.lang.ArithmeticException���� �� ������������, 
 * catch�� ����ó���ÿ� catch(Exception e)��  catch (ArithmeticException e)������ ���� ���̴�
 * 
 * ��Ӱ���
 * Throwable
 * 		->Error //Throwable�� �������, JVM�� ������ ������� ��, �������� å���� �ƴ� ��
 * 				//�̰� ��� �ý����� �����̴�, �״ϱ� �Ű� ����
 *				//�޸𸮰� ��������. Logical�ϰ� ó���Ұ���
 * 
 * 		->Exception
 * 			->IOException
 * 			->RuntimeException
 * 				->ArithmeticException
 * 
 * 
 * checked exception - RuntimeException�� ������ Exception�� ���� Ŭ���� (+ Error)
 * ->�ݵ�� ����ó���� �ؾ��Ѵ�. EX) IOException
 * 
 * unchekced exception - RuntimeException�� ���� Ŭ����
 * ->����ó���� �ʼ��������� �ʴ�. EX) ArithmeticException
 * */
	
}

public class Study_01_08_Exception_Check {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
