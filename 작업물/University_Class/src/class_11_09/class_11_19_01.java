package class_11_09;

import java.util.Scanner;

class Student{
	String name;
	String school_name="고려대학교";
	StringBuffer self_intro = new StringBuffer("저는 연세대학교에 재학중인 입니다.");
	
	Integer score;
}

public class class_11_19_01 {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String a[]) {
		Student[] index = new Student[100];
		
		for(int i=0;i<100;i++) {
			index[i] = new Student();
		}
		
		index[0].name = new String("류호준");
		index[1].name = "한재연";
		index[2].name = "김인규";
		
		System.out.printf("%s, 성: %c, 이름 자수: %d\n",
				index[0].name, index[0].name.charAt(0), index[0].name.length()); 
		
		System.out.println(search_name(index,"송대선"));
		System.out.println(search_name(index,"류호준"));
		System.out.println(search_name(index,"한재연"));
		
		give_student_number(index[0], 95);
		give_student_number(index[1], 91);
		give_student_number(index[2], 85);
		
		setIntro(index[0]);
		System.out.println(index[0].self_intro);
	}
	
	public static void setIntro (Student s) {
		s.self_intro.replace (3,8,s.school_name);
		s.self_intro.insert(15, s.name);
	}
	
	public static boolean search_name (Student[] index, String name) {
		
		for(int i=0;i<index.length;i++) 
			if(name.equals(index[i].name)) 
				return true;
		
		return false;
	}
	
	public static void give_student_number (Student a, int s) {
		a.score=Integer.valueOf(s);
	}
	
	public static double find_stdev(Student[] index) {
		double var=0;
		
		double exp=0;
		for(int i=0;i<index.length;i++) exp+=index[i].score;
		exp/=index.length;
		
		for(int i=0;i<index.length;i++) var+=Math.pow(index[i].score-exp,2);
		var/=(index.length-1);
		
		return Math.sqrt(var);
	}
}
