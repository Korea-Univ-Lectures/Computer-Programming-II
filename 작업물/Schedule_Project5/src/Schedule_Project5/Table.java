package Schedule_Project5;

import java.util.Vector;

class Table implements Cloneable {
	boolean timeTable[][] = new boolean[5][8];
	int courseKind[] = new int[3]; 
	
	Vector <course> courseInfo = new Vector();
	int totalCre=0;//시간표 학점 총량
	
	double totalPri=0;//시간표 선호도 총량
	double totalAttendChecking=0;//시간표 출석체크 총량
	double totalGrading=0;//시간표 학점 총량
	double totalDifficulty=0;//시간표 난이도 총량
	double totalEffort=0;//시간표 학습량 총량
	double totalDoneit=0;//시간표 성취감 총량
	
	Table() {
		for(int i=0;i<5;i++) {
			for(int j=0;j<8;j++) {
				boolean b=true;
				timeTable[i][j]=b;
			}
		}
		for(int i=0;i<3;i++) {
			courseKind[i]=0;
		}
	}
	
	//Table 초기설정
	void setTable(course c) {
		courseInfo.add(c);
		totalPri=c.priority;
		totalCre=c.creedit;
		totalAttendChecking=c.attendChecking;
		totalGrading=c.grading;
		totalDifficulty=c.difficulty;
		totalEffort=c.effort;
		totalDoneit=c.doneit;
		
		switch(c.kind) {
		case 0: courseKind[0]=1;
			break;
		case 1: courseKind[1]=1;
			break;
		case 2: courseKind[2]=1;
			break;
		}
		
		setTime(c.tv);
	}
	
	//Table에 시간 적용
	void setTime(Vector <time> tv) {
		if(!tv.isEmpty())for(int i=0;i<tv.size();i++) {
			timeTable[tv.elementAt(i).day][tv.elementAt(i).period]=false;
		}
	}
	
	//Table에 Course 추가 가능여부
	boolean addAbleCourse(course c) {
		boolean isAddable =true;
		
		for(int i=0;i<c.tv.size();i++) {
			if(timeTable[c.tv.elementAt(i).day][c.tv.elementAt(i).period]==false) {
				isAddable=false;
				break;
			}
		}
		return isAddable;
	}
	
	//Table에 Course 추가
	void addTable (course c) {
		courseInfo.add(c);
		totalPri+=c.priority;
		totalCre+=c.creedit;
		totalAttendChecking+=c.attendChecking;
		totalGrading+=c.grading;
		totalDifficulty+=c.difficulty;
		totalEffort+=c.effort;
		totalDoneit+=c.doneit;
			
		setTime(c.tv);
		
		switch(c.kind) {
		case 0: 
			courseKind[0]+=1;
			break;
		case 1: 
			courseKind[1]+=1;
			break;
		case 2: 
			courseKind[2]+=1;
			break;
		}
	}
	//Table의 평균계산
	void avgTable () {
		totalPri/=courseInfo.size();
		totalAttendChecking/=courseInfo.size();
		totalGrading/=courseInfo.size();
		totalDifficulty/=courseInfo.size();
		totalEffort/=courseInfo.size();
		totalDoneit/=courseInfo.size();
}

	//Table의 Clone 생성
	public Object clone() throws CloneNotSupportedException {
		Table copy= (Table)super.clone();
		copy.timeTable = new boolean[5][8];
		for(int i=0;i<5;i++) {
			for(int j=0;j<8;j++) {
				copy.timeTable[i][j]=timeTable[i][j];
			}
		}
		
		copy.courseKind= new int[3];
		for(int i=0;i<3;i++) {
			copy.courseKind[i]=courseKind[i];
		}
		
		copy.courseInfo = (Vector <course>)courseInfo.clone();
		
		for(int i=0;i<copy.courseInfo.size();i++) {
			copy.courseInfo.elementAt(i).tv=(Vector <time>)courseInfo.elementAt(i).tv.clone();	
		}
		return copy;
	}
}