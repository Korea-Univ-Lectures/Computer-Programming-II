package Study_00_01_IO;

import java.util.Scanner;//scanner�� load�ϴ� ����

public class Study_00_01_IO {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);//Scnner�� ������
		//System.in ����ڰ� �Է��� ���� �ǹ�
		//System.in ��� ������ ���� ���� �ִ�
		int i = sc.nextInt();
		//nextInt()�� ���⼭ ������ �����߰� ��ٸ��� �ȴ�.
		//���� �Է�! ���ڷ� ��! ���͸� �� ġ�� ���� �ý����� �۵�!
		System.out.println(i*1000);
		sc.close();
	}

}
