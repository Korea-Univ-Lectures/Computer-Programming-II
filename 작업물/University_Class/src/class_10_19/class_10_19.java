package class_10_19;

class Student {
	String name;
	String school;
	int number=2018320000;
	
	private boolean goingSchool=true;
	
	public Student (String name) {
		this.name=name;
	}
	
	public Student (int number) {
		this("No name","No school",number);
	}
	
	public Student(String name, String school, int number) {
		this.name=name;
		this.school=school;
		this.number=number;
	}
	
	void getStudentInfo() {
		System.out.println("저는 "+school+"의 "+number+", "+name+"입니다.");
	}
	
	public void Transfer(String school) {
		System.out.println(name+"이 "+this.school+"를 자퇴하고 "+school+"으로 반수해버렸습니다.");
		this.school=school;
	}
	
	public void isGoing(boolean a) {
		goingSchool=a;
	}
}

public class class_10_19 {

	public static void main(String[] args) {
		Student s1= new Student(2018320000);
		s1.getStudentInfo();
		
		s1.name="홍길동";
		s1.school="고려대학교";
		s1.getStudentInfo();
		
		s1.Transfer("한양대학교");
	}
}