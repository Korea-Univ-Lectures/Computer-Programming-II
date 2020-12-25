package Schedule_Project5;

import java.util.Vector;

class Table implements Cloneable {
	boolean timeTable[][] = new boolean[5][8];
	int courseKind[] = new int[3]; 
	
	Vector <course> courseInfo = new Vector();
	int totalCre=0;//�ð�ǥ ���� �ѷ�
	
	double totalPri=0;//�ð�ǥ ��ȣ�� �ѷ�
	double totalAttendChecking=0;//�ð�ǥ �⼮üũ �ѷ�
	double totalGrading=0;//�ð�ǥ ���� �ѷ�
	double totalDifficulty=0;//�ð�ǥ ���̵� �ѷ�
	double totalEffort=0;//�ð�ǥ �н��� �ѷ�
	double totalDoneit=0;//�ð�ǥ ���밨 �ѷ�
	
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
	
	//Table �ʱ⼳��
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
	
	//Table�� �ð� ����
	void setTime(Vector <time> tv) {
		if(!tv.isEmpty())for(int i=0;i<tv.size();i++) {
			timeTable[tv.elementAt(i).day][tv.elementAt(i).period]=false;
		}
	}
	
	//Table�� Course �߰� ���ɿ���
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
	
	//Table�� Course �߰�
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
	//Table�� ��հ��
	void avgTable () {
		totalPri/=courseInfo.size();
		totalAttendChecking/=courseInfo.size();
		totalGrading/=courseInfo.size();
		totalDifficulty/=courseInfo.size();
		totalEffort/=courseInfo.size();
		totalDoneit/=courseInfo.size();
}

	//Table�� Clone ����
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