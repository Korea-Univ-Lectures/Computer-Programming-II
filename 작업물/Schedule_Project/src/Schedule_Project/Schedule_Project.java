package Schedule_Project;

class time {//�ð�ǥ�� �ð��� ����!
	int day;//����
	int period;//�� ��������?
	
	time (int day, int period){
		this.day = day;
		this.period=period;
	}
	
}

class courseId{
	int group;//�׷��ȣ
	int order;//�׷쳻�� ����
}

class course {
	String courseName;
	String instructor;
	int priority;//���� ��ȣ��
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
	//��ü ������ �׷��� �����ϴ� �迭
	
	//���Ǳ׷�ֱ�
	public static void addCourseGroup(String name){
		courseGroup g = new courseGroup();
		g.groupName = name;
		
		int i=0;
		
		while(true) {
			if(totalCourse[i]==null) {
				g.groupCode=i;
				totalCourse[i]=g;
				System.out.println(name+"��(��) "+i+"��° �׷����� �����Ǿ����ϴ�.");
				break;
			}
			i++;
			if(i>=10) { 
				System.out.println("�׷��� �ִ� 10�������� ���������մϴ�.");
				break;
				}
		}
		
	}
	
	//���Ǹ� ���� �׷쿡 �ֱ�
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
				System.out.println(name+"��(��) "+totalCourse[groupId].groupName+"�� "+i+"��° �������� �����Ǿ����ϴ�.");
				break;
			}
			i++;
			if(i>=10) { 
				System.out.println("���Ǵ� �Ѱ��� �׷���� �ִ� 10�������� ���������մϴ�.");
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
		
		//for(int i=0; i<15; i++) {addCourseGroup("������"+i);}
		
		/*time [] t1 = new time[2];
		t1[0] = new time(1,2);
		t1[1] = new time(1,3);
		
		addCourseGroup("������");
		
		for(int i=1; i<15;i++) {
			addCourse(t1,"������������", "�̸���", 1 ,0);
		}*/
		table t1 =new table();
		
		System.out.println(t1.timeTable[1][1]+"\n"+t1.timeTable[2][2]);
	}

}
