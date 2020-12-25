package Study_00_01_IO;

import java.io.File;//File ����
import java.io.FileNotFoundException;
import java.util.Scanner;//��ĳ�� ����

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
		catch(FileNotFoundException e){//������ ã�� ���� ���!
			e.printStackTrace();//�� ������ ����ض�
		}
		//try, catch�� ���ܸ� ó���ϱ� �����̴�. try���� "out.txt"�� ã�����ϸ� ���ܰ� �߻�!
	}
}
