package Study_01_08_Exception;
import java.io.*;

//어떤 예외는 반드시 처리되어야하고, 어떤 예외는 다른 사람에게 맡긴다
//강력하게 try-catch구문으로 처리되어야 하는 예외도 있다(버퍼 입출력처럼!)
//예외는 던져지는 것이다. 다시말해 throw되는 것이다 catch는 이것을 탁 잡는 것이다.
//우리도 예외를 다른 사람들에게 예외를 던질 수 있다

//class B의 사용자는 class C이고,
//class C의 사용자는 메인 메소드가 포함된 클래스이고,
//메인 메소드가 포함된 클래스의 사용자는 현실세계의 User이다

//예외 처리를 상위의 사용자에게 던질 수 있다.
//현실세계의 User에게 예외처리를 맡긴다는 것은 자동으로 프로그램을 종료하겠다는 것이다


class B{
    void run() throws IOException, FileNotFoundException{
    	//상위 사용자에게 예외책임을 전가함 -->class C
    	
        BufferedReader bReader = null;
        String input = null;
        bReader = new BufferedReader(new FileReader("out.txt"));
        input = bReader.readLine();
        System.out.println(input);
    }
}
class C{
    void run() throws IOException, FileNotFoundException{
    	//상위 사용자에게 예외책임을 전가함 -->class Study_01_08_Exception_02
    	
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
		//여기에서 예외처리의 책임을 다함
			 C c = new C();
	         try {
	            c.run();
	        } catch (FileNotFoundException e) {
	            System.out.println("out.txt 파일은 설정 파일 입니다. 이 파일이 프로잭트 루트 디렉토리에 존재해야 합니다.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}   
}

