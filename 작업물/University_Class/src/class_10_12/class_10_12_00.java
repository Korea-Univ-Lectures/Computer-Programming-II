package class_10_12;

import java.util.Scanner;
import java.util.InputMismatchException;

public class class_10_12_00 {
	static Scanner s1 = new Scanner(System.in);

	public static int[] makeArr() {

		int[] arr = new int[5];
		int tmp;

		for (int i = 0; i < 5; i++) {
			System.out.print("������ �Է��ϼ���: ");
			try {
				arr[i] = s1.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("������ �Է��϶�� ��û��! \n");
				s1.next();
				i--;
			}

		}

		for (int j = 0; j < arr.length; j++) {
			for (int i = 0; i < arr.length - 1 - j; i++) {
				if (arr[i] > arr[i + 1]) {
					tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
				}
			}
		}

		return arr;
	}

	public static void main(String[] args) {
		System.out.println("����1");
		char alphabet = 'a';

		do {
			System.out.print((char) (alphabet));
			alphabet += 1;
		} while (alphabet <= 'z');

		System.out.println("\n\n����2");
		int input = -1;
		int count = 0;

		while (input != 0) {
			System.out.print("���ڸ� �Է��Ͻÿ�(0�Է½� ����):");
			input = s1.nextInt();

			if (input == 1)
				count++;
			else if (input == 0)
				break;
		}
		System.out.println("����ڰ� 1�� �Է��� Ƚ��: " + count);

		System.out.println("\n\n����3");
		int arr[] = { 5, 7, 1, 2, 9 };
		int tmp;

		for (int j = 0; j < arr.length; j++) {
			for (int i = 0; i < arr.length - 1 - j; i++) {
				if (arr[i] > arr[i + 1]) {
					tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
				}
			}
		}
		for (int i : arr)
			System.out.print(i + " ");

		System.out.println("\n\n����4");
		int[] brr = makeArr();
		for (int i : brr)
			System.out.print(i + " ");

		s1.close();
	}
}
