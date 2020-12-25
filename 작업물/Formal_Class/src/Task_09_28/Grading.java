package Task_09_28;

import java.util.Scanner;

public class Grading {

	public static void main(String[] args) {
		char grade;
		Scanner s1= new Scanner(System.in);
		
		System.out.println("점수를 입력하시오:");
		int score =s1.nextInt();
		
		if(score>=90) 
			grade='A';
		else if(score>=80)
			grade='B';
		else if(score>=70)
			grade='C';
		else if(score>=60)
			grade='D';
		else
			grade='F';
		
		System.out.println("학점은 "+grade+"입니다.");
		s1.close();
		

	}

}
