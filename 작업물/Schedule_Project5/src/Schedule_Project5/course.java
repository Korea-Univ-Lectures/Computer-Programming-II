package Schedule_Project5;

import java.io.Serializable;
import java.util.Vector;

class course implements Serializable{
	String courseName;//���� �̸�
	String instructor;//������ �̸�
	String place;    //���� ���
	
	Vector<time> tv; //���� �ð� ���
	
	boolean isVoid;
	
	int creedit; //����
	int kind; //���� ����
	
	double priority;//���� ���� ��ȣ��
	double attendChecking; //�⼮üũ ����
	double grading;// ����
	double difficulty; //���̵�
	double effort; //�н���
	double doneit;//���밨
	
	course(String courseName, String instructor, String place,double attendChecking,double grading,double difficulty,double effort, double doneit,int creedit, Vector<time> tv, int kind, boolean isVoid){
		this.courseName=courseName;
		this.instructor=instructor;
		this.place =place;
		
		this.tv=tv;
		this.isVoid=isVoid;
		
		this.attendChecking =attendChecking;
		this.grading=grading;
		this.difficulty=difficulty;
		this.effort=effort;
		this.doneit=doneit;
		
		this.priority=(attendChecking+grading+difficulty+effort+doneit)/5;
	
		this.creedit=creedit;
		this.kind=kind;
	}

	boolean hasDay(int day) {
		boolean isDay=false;
		if(!tv.isEmpty()) {
			for(int i=0;i<tv.size();i++) {
				if(tv.elementAt(i).day==day) {
					isDay=true;
					break;
				}
			}
		}
		
		return isDay;
	}
	
	boolean hasPeriod(int Period) {
		boolean isPeriod=false;
		if(!tv.isEmpty()) {
			for(int i=0;i<tv.size();i++) {
				if(tv.elementAt(i).period==Period) {
					isPeriod=true;
					break;
				}
			}
		}
		
		return isPeriod;
	}
}
