package Study_00_01_IO;

import java.util.Scanner;

public class Study_00_02_IO {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()){//hasNextInt()는 입력값이 int이면 true 반환, int가 아니면 false반환
			
			System.out.println(sc.nextInt()*10);
		}
		sc.close();

	}

}
