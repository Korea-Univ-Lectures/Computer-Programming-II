package class_10_12;

import java.util.InputMismatchException;
import java.util.Scanner;

public class task {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int [] arr = new int[15];
		
		for(int i=0;i<arr.length;i++) {
			try {
				System.out.print("������ �ƴ� ������ �Է����ּ���!:");
				arr[i]=sc.nextInt();
				if(arr[i]<0) {
					System.out.println("������ �ƴ� ������ �Է��϶�ϱ�...�ٺ�...\n");
					i--;
				}
			}
			catch(InputMismatchException e){
				System.out.println("������ �ƴ� ������ �Է��϶�ϱ�...�ٺ�...\n");
				i--;
				sc.next();
			}
		}
		sc.close();
		
		int count=0;
		for(int i=0;i<5;i++) {
			for(int j=0;j<5-i;j++) {
				System.out.print(arr[count]);
				count++;
			}
			System.out.println();
		}
	}
}
