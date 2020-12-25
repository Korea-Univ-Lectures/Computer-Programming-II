package Schedule_Project;

class time {//시간표의 시간대 설정!
	int day;//요일
	int period;//몇 교시인지?
	
	time (int day, int period){
		this.day = day;
		this.period=period;
	}
	
}

class courseId{
	int group;//그룹번호
	int order;//그룹내의 순서
}

class course {
	String courseName;
	String instructor;
	int priority;//강의 선호도
	time [] Time = new time[5];
	courseId id = new courseId();
}

class courseGroup{
	String groupName;
	int groupCode;
	course [] Course = new course[10];
	boolean isCalculated = false;
}

public class Schedule_Project {
	
	public static courseGroup[] totalCourse = new courseGroup[10];
	//전체 강의의 그룹을 관리하는 배열
	
	//강의그룹넣기
	public static void addCourseGroup(String name){
		courseGroup g = new courseGroup();
		g.groupName = name;
		
		int i=0;
		
		while(true) {
			if(totalCourse[i]==null) {
				g.groupCode=i;
				totalCourse[i]=g;
				System.out.println(name+"이(가) "+i+"번째 그룹으로 지정되었습니다.");
				break;
			}
			i++;
			if(i>=10) { 
				System.out.println("그룹은 최대 10개까지만 생성가능합니다.");
				break;
				}
		}
		
	}
	
	//강의를 강의 그룹에 넣기
	public static void addCourse(time [] t,String name, String inst, int pri,int groupId) {
		course c = new course();
		c.courseName=name;
		c.instructor=inst;
		c.priority=pri;
		c.Time=t;
		c.id.group=groupId;
		
		int i=0;
		
		while(true) {
			if(totalCourse[groupId].Course[i]==null) {
				c.id.order=i;
				totalCourse[groupId].Course[i]=c;
				System.out.println(name+"이(가) "+totalCourse[groupId].groupName+"의 "+i+"번째 강의으로 지정되었습니다.");
				break;
			}
			i++;
			if(i>=10) { 
				System.out.println("강의는 한개의 그룹당은 최대 10개까지만 생성가능합니다.");
				break;
				}
		}
	}
	
	public static void main(String[] args) {
		/*course [] c1 =new course [6];
		if(c1[0]==null) {
			System.out.println("NULL!");
		}
		course c2 =new course();
		c1[0]= c2;
		if(c1[0]==null) {
			System.out.println("NULL!");
		}*/
		
		//for(int i=0; i<15; i++) {addCourseGroup("자정진"+i);}
		
		/*time [] t1 = new time[2];
		t1[0] = new time(1,2);
		t1[1] = new time(1,3);
		
		addCourseGroup("자정진");
		
		for(int i=1; i<15;i++) {
			addCourse(t1,"자유정의진리", "이만영", 1 ,0);
		}*/
		table t1 =new table();
		
		System.out.println(t1.timeTable[1][1]+"\n"+t1.timeTable[2][2]);
	}

}
