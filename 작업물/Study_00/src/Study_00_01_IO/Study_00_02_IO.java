package Study_00_01_IO;

import java.util.Scanner;

public class Study_00_02_IO {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()){//hasNextInt()�� �Է°��� int�̸� true ��ȯ, int�� �ƴϸ� false��ȯ
			
			System.out.println(sc.nextInt()*10);
		}
		sc.close();

	}

}
