package Schedule_Project4;

import java.util.Vector;

class course {
	String courseName;//���� �̸�
	String instructor;//������ �̸�
	String place;
	double priority;//���� ���� ��ȣ��
	int creedit;//����
	Vector<time> tv;//���� �ð� ���
	
	double attendChecking; //�⼮üũ ����
	double grading;// ����
	double difficulty; //���̵�
	double effort; //�н���
	double doneit;//���밨
	
	course(String courseName, String instructor, String place,double priority,int creedit, Vector<time> tv){
		this.courseName=courseName;
		this.instructor=instructor;
		this.place =place;
		this.priority=priority;
		this.creedit=creedit;
		this.tv=tv;
		
		attendChecking =priority;
		grading=priority;
		difficulty=priority;
		effort=priority;
		doneit=priority;
	}
	
	course(String courseName, String instructor, String place,int attendChecking,int grading,int difficulty,int effort, int doneit,int creedit, Vector<time> tv){
		this.courseName=courseName;
		this.instructor=instructor;
		this.place =place;
		this.creedit=creedit;
		this.tv=tv;
		
		this.attendChecking =attendChecking;
		this.grading=grading;
		this.difficulty=difficulty;
		this.effort=effort;
		this.doneit=doneit;
		
		this.priority=(attendChecking+grading+difficulty+effort+doneit)/5;
	}
}
