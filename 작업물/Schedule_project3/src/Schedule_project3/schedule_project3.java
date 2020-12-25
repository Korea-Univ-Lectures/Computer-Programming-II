package Schedule_project3;

import java.util.Vector;
import java.util.Scanner;

class time implements Cloneable{//�ð�ǥ�� �ð��� ����!
	int day;//����
	int period;//�� ��������?
	
	time (int day, int period){
		this.day = day;
		this.period=period;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class course {
	String courseName;//���� �̸�
	String instructor;//������ �̸�
	int priority;//���� ��ȣ��
	int stability;//���� ���� ������
	Vector<time> tv;//���� �ð� ���
	
	course(String courseName, String instructor, int priority, int stability, Vector<time> tv){
		this.courseName=courseName;
		this.instructor=instructor;
		this.priority=priority;
		this.stability=stability;
		this.tv=tv;
	}
}

class Group{
	String GroupName; //�׷� �̸�
	Group(String name, boolean b){
		GroupName=name;
		isVoid= b;
	}
		Vector<course> cv = new Vector(); //�׷� ���� ���� ��ϵ�
	boolean isVoid = false; //���� ����
	
	int getNum() {
		if (isVoid)
			return cv.size()+1;
		else
			return cv.size();
	}
}
class Table implements Cloneable {
	boolean timeTable[][] = new boolean[9][6];
	
	Table() {
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=8;j++) {
				boolean b=true;
				timeTable[j][i]=b;
			}
		}
	}
	
	Vector <course> courseInfo = new Vector();
	int totalPri=0;//���� ��ȣ�� �ѷ�
	int totalSta=0;//���� ���� ������ �ѷ�
	
	//Table �ʱ⼳��
	public void setTable(course c) {
		courseInfo.add(c);
		totalPri=c.priority;
		totalSta=c.stability;
		
		for(int i=0;i<c.tv.size();i++) {
			timeTable[c.tv.elementAt(i).period][c.tv.elementAt(i).day]=false;
		}
	}
	
	//Table�� Course �߰� ���ɿ���
	public boolean addAbleCourse(course c) {
		boolean IsaddAble =true;
		
		for(int i=0;i<c.tv.size();i++) {
			if(timeTable[c.tv.elementAt(i).period][c.tv.elementAt(i).day]==false) {
				IsaddAble=false;
				break;
			}
		}
		return IsaddAble;
	}
	
	//Table�� Course �߰�
	public void addTable (course c) {
			courseInfo.add(c);
			totalPri+=c.priority;
			totalSta+=c.stability;
			
			for(int i=0;i<c.tv.size();i++) {
				timeTable[c.tv.elementAt(i).period][c.tv.elementAt(i).day]=false;
			}
		
	}

	//Table�� Clone ����
	public Object clone() throws CloneNotSupportedException {
		Table copy= (Table)super.clone();
		copy.timeTable = new boolean[9][6];
		for(int i=0;i<6;i++) {
			for(int j=0;j<9;j++) {
				copy.timeTable[j][i]=timeTable[j][i];
			}
		}
		copy.courseInfo = (Vector <course>)courseInfo.clone();
		
		for(int i=0;i<copy.courseInfo.size();i++) {
			copy.courseInfo.elementAt(i).tv=(Vector <time>)courseInfo.elementAt(i).tv.clone();
			/*for(int j=0;j<copy.courseInfo.elementAt(i).tv.size();j++) {
				copy.courseInfo.elementAt(i).tv.elementAt(j).day=courseInfo.elementAt(i).tv.elementAt(j).day;
				copy.courseInfo.elementAt(i).tv.elementAt(j).period=courseInfo.elementAt(i).tv.elementAt(j).period;
			}*/
		}
		
		return copy;
	}
}
public class schedule_project3 {
	schedule_project3(){
		
	}
	public static Vector <Group> gv =new Vector(); //�� ���� �׷�
	
	public static Vector <Table> Tv = new Vector(); //�ð�ǥ�� �÷��� ���ǵ�
	
	public static int tempGruopIndex;//���� ���� ���� �׷�
	
	//���� �׷� �߰�
	public static void addCourseGroup(String name, boolean b) {
		Group g1= new Group(name, b);
		gv.add(g1);
	}

	//���� �߰�
	public static void addCourse(String name, String ins, int pri, int sta) {
		course c1 = new course(name, ins, pri, sta,getTime());
		gv.elementAt(tempGruopIndex).cv.add(c1);
	}
	
	//���� ���� �׷� ����, ����
	public static void setTempGroup (int i) {
		if(i<gv.size())
			tempGruopIndex=i;
		else
			System.out.println("�׷��� �ε����� �������� �ʽ��ϴ�.");
	}
	
	//�ð� ���� ���� �żҵ�
	public static Vector<time> getTime() {
		Vector <time> tv =new Vector();
		int day;
		int hour;
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			day=sc.nextInt();
			if(day==-1)break;
			else {
				hour=sc.nextInt();
				if(hour==-1)break;
				else {
					time t =new time(day,hour);
					tv.add(t);
				}
			}
		}
		return tv;
	}
	
	//�ʱ� �ð�ǥ ����
	public static void FirstTable() {
		if(gv.size()==0)
			System.out.println("�ּ� �Ѱ� �̻��� ���Ǳ׷��� �־���մϴ�.");
		else {
			for(int i=0;i<gv.elementAt(0).cv.size();i++) {
				Table t= new Table();
				t.setTable(gv.elementAt(0).cv.elementAt(i));
				Tv.add(t);
			}
		}
	}
	
	//�ð�ǥ�� ������ �׷� ����
	public static void addingTable(int index){
		Vector<Table> ntv =new Vector();
		
		for(int i=0;i<Tv.size();i++) {
			
				for(int j=0;j<gv.elementAt(index).cv.size();j++) {
				
					if(Tv.elementAt(i).addAbleCourse(gv.elementAt(index).cv.elementAt(j))) {
						Table nt;
						try
						{
							nt=(Table)Tv.elementAt(i).clone();
							nt.addTable(gv.elementAt(index).cv.elementAt(j));
							ntv.add(nt);
						}
						catch(CloneNotSupportedException e)
						{
							e.printStackTrace();
						}
				}
			}
		}
		if(gv.elementAt(index).isVoid==true) {
			for(int i=0;i<Tv.size();i++) {
				ntv.add(Tv.elementAt(i));
			}
		}
		Tv.removeAllElements();
		Tv=ntv;
	}
	
	//�ð�ǥ ���
	public static void calculateTable() {
	
		int h;
		int t;
		Group temp;
		for(int i=gv.size()-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				h=gv.elementAt(j).getNum();
				t=gv.elementAt(j+1).getNum();
				if(h>t) {
					temp = gv.elementAt(j+1);
					gv.set(j+1,gv.elementAt(j));
					gv.set(j, temp);
				}
			}
		}
		
		FirstTable();
		for(int i=1;i<gv.size();i++)
			addingTable(i);
	}
	
	//GV ����Ʈ
	public static void printGV() {
		for(int i=0; i<gv.size();i++) {
			System.out.print(gv.elementAt(i).GroupName);
			
			for(int j=0; j<gv.elementAt(i).cv.size();j++) {
				System.out.print("\t"+gv.elementAt(i).cv.elementAt(j).courseName);
			}
			System.out.println();
		}
	}
	
	//TV ����Ʈ
	public static void printTV() {
		for(int i=0;i<Tv.size();i++) {
			for(int j=0;j<Tv.elementAt(i).courseInfo.size();j++) {
				System.out.print(Tv.elementAt(i).courseInfo.elementAt(j).courseName+"\t");
			}
			System.out.println();
		}
	}
	
	public static void printTV2() {
		for(int i=0;i<Tv.size();i++) {
			for(int j=0;j<Tv.elementAt(i).courseInfo.size();j++) {
				printTime(Tv.elementAt(i));
			}

		}
	}
	//�ð� ����Ʈ
	public static void printTime(Table t) {
		for(int i=0;i<=5;i++) {
			for(int j=0;j<=8;j++) {
				System.out.print(t.timeTable[i][j]+"\t");
				}
			System.out.println();
		}
	}
	
	//��ȣ�� ����Ʈ
	public static void printPri() {
		for(int i=0;i<Tv.size();i++) {
			System.out.println(Tv.elementAt(i).totalPri+", "+Tv.elementAt(i).totalSta);
		}
	}
	
	//��ȣ�� �迭
	public static void sortbyPri() {
		int h;
		int t;
		Table temp;
		for(int i=0;i<gv.size()+1;i++) {
			for(int j=0;j<gv.size()+2-i;j++) {
				
				h=Tv.elementAt(j).totalPri;
				t=Tv.elementAt(j+1).totalPri;
				if(h<t) {
					temp = Tv.elementAt(j);
					Tv.set(j,Tv.elementAt(j+1));
					Tv.set(j+1, temp);
				}
			}
		}
	}
	
	//������ �迭
		public static void sortbySta() {
			int h;
			int t;
			Table temp;
			for(int i=0;i<gv.size()+1;i++) {
				for(int j=0;j<gv.size()+2-i;j++) {
					
					h=Tv.elementAt(j).totalSta;
					t=Tv.elementAt(j+1).totalSta;
					if(h<t) {
						temp = Tv.elementAt(j);
						Tv.set(j,Tv.elementAt(j+1));
						Tv.set(j+1, temp);
					}
				}
			}
		}
	
	public static void main(String[] args){
		schedule_project3 s = new schedule_project3();
		
		addCourseGroup("��Ÿ����",true);
		addCourseGroup("������ ���α׷���",false);
		addCourseGroup("������",false);
		
		setTempGroup(0);
		addCourse("���������", "�۴뼱", 2, 4);
		addCourse("������ �ؽ�Ʈ�� ��갡�ɼ�", "�ڼ���", 6, 2);
		
		setTempGroup(1);
		addCourse("��ǻ�� ���α׷���a", "�̸���", 3, 4);
		addCourse("��ǻ�� ���α׷���b", "�̸���", 10, 2);
		
		setTempGroup(2);
		addCourse("������������a", "�̸���", 4, 4);

		//System.out.println(gv.elementAt(0).cv.elementAt(0).priority);
		
		calculateTable();
		printGV();
		
		printTV();
		printPri();
		
		sortbyPri();
		printTV();
		printPri();
		
		sortbySta();
		printTV();
		printPri();
		
		/*
		Table t1= new Table();
		t1.totalPri=1;
		
		Table t2= (Table) t1.clone();
		t2.totalPri=2;
		System.out.println(t1.totalPri+", "+t2.totalPri);
		
		Vector <Table> In =new Vector();
		
		for(int i=0;i<10;i++) {
			Table t3= (Table) t1.clone();
			t2.totalPri=i;
			In.add(t3);
		}*/
		

	}
}
