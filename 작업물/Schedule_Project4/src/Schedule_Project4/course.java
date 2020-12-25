package Schedule_Project4;

import java.util.Vector;

class course {
	String courseName;//강의 이름
	String instructor;//교수님 이름
	String place;
	double priority;//강의 전반 선호도
	int creedit;//학점
	Vector<time> tv;//강의 시간 기록
	
	double attendChecking; //출석체크 정도
	double grading;// 성적
	double difficulty; //난이도
	double effort; //학습량
	double doneit;//성취감
	
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
