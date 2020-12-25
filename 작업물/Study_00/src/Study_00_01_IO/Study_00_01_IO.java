package Study_00_01_IO;

import java.util.Scanner;//scanner를 load하는 것임

public class Study_00_01_IO {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);//Scnner를 가져옴
		//System.in 사용자가 입력한 값을 의미
		//System.in 대신 파일을 넣을 수도 있다
		int i = sc.nextInt();
		//nextInt()는 여기서 실행이 딱멈추고 기다리게 된다.
		//값을 입력! 숫자로 만! 엔터를 땅 치는 순간 시스템이 작동!
		System.out.println(i*1000);
		sc.close();
	}

}
