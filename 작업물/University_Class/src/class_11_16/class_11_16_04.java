package class_11_16;

import java.util.Scanner;
import java.util.ArrayList;

public class class_11_16_04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList <String> a= new ArrayList();
		
		for(int i=0;i<4;i++) {
			a.add(sc.nextLine());
		}
		
		String max = a.get(0);
		
		for(int i=0;i<3;i++) {
			if(a.get(i).length()<a.get(i+1).length()) max=a.get(i+1);
		}
		
		System.out.println(max);
	}

}
