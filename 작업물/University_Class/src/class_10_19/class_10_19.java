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
		System.out.println("���� "+school+"�� "+number+", "+name+"�Դϴ�.");
	}
	
	public void Transfer(String school) {
		System.out.println(name+"�� "+this.school+"�� �����ϰ� "+school+"���� �ݼ��ع��Ƚ��ϴ�.");
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
		
		s1.name="ȫ�浿";
		s1.school="������б�";
		s1.getStudentInfo();
		
		s1.Transfer("�Ѿ���б�");
	}
}