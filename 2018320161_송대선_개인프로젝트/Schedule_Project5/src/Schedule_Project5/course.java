package Schedule_Project5;

import java.io.Serializable;
import java.util.Vector;

class course implements Serializable{
	String courseName;//강의 이름
	String instructor;//교수님 이름
	String place;    //강의 장소
	
	Vector<time> tv; //강의 시간 기록
	
	boolean isVoid;
	
	int creedit; //학점
	int kind; //강의 종류
	
	double priority;//강의 전반 선호도
	double attendChecking; //출석체크 정도
	double grading;// 성적
	double difficulty; //난이도
	double effort; //학습량
	double doneit;//성취감
	
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
