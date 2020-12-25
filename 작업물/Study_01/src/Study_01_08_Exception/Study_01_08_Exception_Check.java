package Study_01_08_Exception;

import java.io.IOException;

class E{
	void throwArithmeticException(){
        throw new ArithmeticException();
        //예외를 던지고, 딱히 처리하지 않아도 문제가 발생하는 것 같지는 않다
    }
	
    void throwIOException1(){
    	//IOException의 문제를 처리하는 첫번째 방법은 try-catch구문을 이용하는 것이다
        try {
            throw new IOException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    void throwIOException2() throws IOException{
    	//IOException의 문제를 처리하는 두번째 방법은 IOException클래스로 책임을 던져버리는 것이다.
        throw new IOException();
    }
/*
 * java.lang.Object //자바의 시초 클래스
 * 	하위)java.lang.Throwable //throw가능한 것들의 클래스. 이 클래스 안에, 하위에 있어야 throw가 가능함
 * 	java.lang.Throwable의 메소드들중에서는
 *	getMessage(), printStackTrace(), toString() 등이 있다
 * 		하위)java.lang.Exception
 * 			하위)java.lang.RuntimeException
 * 				하위)java.lang.ArithmeticException
 * java.lang.Exception이 java.lang.ArithmeticException보다 더 포괄적임으로, 
 * catch의 예외처리시에 catch(Exception e)가  catch (ArithmeticException e)밑으로 들어가는 것이다
 * 
 * 상속관계
 * Throwable
 * 		->Error //Throwable을 직접상속, JVM에 문제가 방생했을 때, 개발자의 책임은 아닐 때
 * 				//이건 기반 시스템의 문제이다, 그니까 신경 ㄴㄴ
 *				//메모리가 부족해짐. Logical하게 처리불가능
 * 
 * 		->Exception
 * 			->IOException
 * 			->RuntimeException
 * 				->ArithmeticException
 * 
 * 
 * checked exception - RuntimeException을 제외한 Exception의 하위 클래스 (+ Error)
 * ->반드시 예외처리를 해야한다. EX) IOException
 * 
 * unchekced exception - RuntimeException의 하위 클래스
 * ->예외처리가 필수적이지는 않다. EX) ArithmeticException
 * */
	
}

public class Study_01_08_Exception_Check {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
