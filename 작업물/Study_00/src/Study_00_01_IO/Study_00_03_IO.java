package Study_00_01_IO;

import java.io.File;//File 쓴다
import java.io.FileNotFoundException;
import java.util.Scanner;//스캐너 쓴다

public class Study_00_03_IO {

	public static void main(String[] args) {
		try {
			File outfile = new File("out.txt");
			Scanner sc =new Scanner(outfile);
			while(sc.hasNextInt()){
				System.out.println(sc.nextInt());
			}
			sc.close();
		}
		catch(FileNotFoundException e){//파일을 찾지 못할 경우!
			e.printStackTrace();//그 에러를 출력해라
		}
		//try, catch는 예외를 처리하기 위함이다. try에서 "out.txt"를 찾지못하면 예외가 발생!
	}
}
