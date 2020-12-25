package Schedule_Project5;

import java.util.Scanner;
import java.util.Vector;

class TableManager {
	Vector <Table> tv = new Vector(); //�ð�ǥ�� �÷��� ���ǵ�, �⺻ �ð�ǥ ����
	Vector <Table> edited= new Vector();//�������͸��� ���ļ� �ö�� ����
	
	boolean [] emptyDayFilter = new boolean[5];
	boolean [] emptyPeriodFilter = new boolean[8];
	Vector <Integer> creeditFilter = new Vector();
	double [][] pointFilter = new double [2][6];
	
	boolean isRight=true;//�ð�ǥ����� ��ȿ�Ѱ�?
	
	Scanner sc1 =new Scanner(System.in);

	GroupManager m = new GroupManager();
	
	/*
	 * [0][]:�ּҰ��
	 * [1][]:�ִ���
	 * 
	 * [][0]:��ռ�ȣ��
	 * [][1]:attendChecking; //�⼮üũ ����
	 * [][2]:grading;// ����
	 * [][3]:difficulty; //���̵�
	 * [][4]:effort; //�н���
	 * [][5]:doneit;//���밨
	 * 
	 * */
	TableManager () {
		for(int i=0;i<6;i++) {
			pointFilter[0][i]=0;
			pointFilter[1][i]=5.0;
		}
		for(int i=0;i<5;i++) {
			emptyDayFilter[i]=false;
		}
		
		for(int i=0;i<8;i++) {
			emptyPeriodFilter[i]=false;
		}
	}
	
	//���α׷� ����
	void endProgram (String endMessage) {
		System.out.println(endMessage);
		System.out.println("����Ϸ��� ����Ű�� �����ÿ�");
		sc1.nextLine();
		System.exit(0);
	}
	
	//�������� ��������
	Vector <Group> applyEmptyDayFilter (Vector <Group> gv){
		if(!gv.isEmpty()){
			for(int day=0;day<5;day++) {
				if(emptyDayFilter[day]) {
					for(int i=0;i<gv.size();i++) {
						if(!gv.elementAt(i).cv.isEmpty()) {
							for(int j=0;j<gv.elementAt(i).cv.size();j++) {
								if(gv.elementAt(i).cv.elementAt(j).hasDay(day)) {
									gv.elementAt(i).cv.remove(j);
									j--;
									if(gv.elementAt(i).cv.isEmpty()) {
										if(!gv.elementAt(i).isVoid) {
											isRight=false;
											endProgram ("�ĺ� ������� ���� ������ �������� �ʽ��ϴ�.");
											break;
										}
										gv.remove(i);
										i--;
									}
								}
							}
						}
					}
				}
			}
		}
		return gv;
	}
	
	//�ð����� ��������
	Vector <Group> applyEmptyPeriodFilter (Vector <Group> gv){
		if(!gv.isEmpty()){
			for(int Period=0;Period<8;Period++) {
				if(emptyPeriodFilter[Period]) {
					for(int i=0;i<gv.size();i++) {
						if(!gv.elementAt(i).cv.isEmpty()) {
							for(int j=0;j<gv.elementAt(i).cv.size();j++) {
								if(gv.elementAt(i).cv.elementAt(j).hasPeriod(Period)) {
									gv.elementAt(i).cv.remove(j);
									j--;
									if(gv.elementAt(i).cv.isEmpty()) {
										if(!gv.elementAt(i).isVoid) {
											isRight=false;
											endProgram ("�ĺ� ������� ���� ������ �������� �ʽ��ϴ�.");
											break;
										}
										gv.remove(i);
										i--;
									}
								}
							}
						}
					}
				}
			}
		}
		return gv;
	}
	
	//��������
	void creeditFilter (int cre) {
		if(!tv.isEmpty()) {
			for(int i=0;i<tv.size();i++) {
				if(tv.elementAt(i).totalCre==cre) {
					edited.add(tv.elementAt(i));
				}
			}
		}
	}
	
	//�ʱ� �ð�ǥ ����
 	void FirstTable(Vector <Group> gv) {
		if(gv.isEmpty())
			System.out.println("�ּ� �Ѱ� �̻��� ���Ǳ׷��� �־���մϴ�.");
		else {
			for(int i=0;i<gv.elementAt(0).cv.size();i++) {
				Table t= new Table();
				t.setTable(gv.elementAt(0).cv.elementAt(i));
				tv.add(t);
			}
			if(gv.elementAt(0).isVoid) {
				Table t= new Table();
				tv.add(t);
			}
		}
	}
	
	//�ð�ǥ�� ������ �׷� ����
	void addingTable(Vector <Group> gv, int index){
		Vector<Table> ntv =new Vector();
			
		for(int i=0;i<tv.size();i++) {
			for(int j=0;j<gv.elementAt(index).cv.size();j++) {
			
				if(tv.elementAt(i).addAbleCourse(gv.elementAt(index).cv.elementAt(j))) {
					Table nt;
					try
					{
						nt=(Table)tv.elementAt(i).clone();							
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
			for(int i=0;i<tv.size();i++) {
				ntv.add(tv.elementAt(i));
			}
		}
		tv.removeAllElements();
		tv=ntv;
	}
	
	//�ð�ǥ ���
	void calculateTable(Vector <Group> gv) {
	
		int h;
		int t;
		Group temp;
		
		if(!gv.isEmpty()) {
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
		
			FirstTable(gv);
			for(int i=1;i<gv.size();i++)
				addingTable(gv, i);
			for(int i=0;i<tv.size();i++) 
				tv.elementAt(i).avgTable();
			}
		else 
			System.out.println("���õ� ������ �����ϴ�.");
	}

	//��ȣ�� �迭
	void sortbyPri() {
		double h;
		double t;
		Table temp;
		for(int i=0;i<edited.size()-1;i++) {
			for(int j=0;j<edited.size()-1-i;j++) {
				
				h=edited.elementAt(j).totalPri;
				t=edited.elementAt(j+1).totalPri;
				if(h<t) {
				temp = edited.elementAt(j);
				edited.set(j,edited.elementAt(j+1));
				edited.set(j+1, temp);
				}
			}
		}
	}

	//point ����
	void PriFilter() {
		if(!edited.isEmpty())
		for(int i=0;i<edited.size();i++) {
			if(!edited.isEmpty())
			if(edited.elementAt(i).totalPri>pointFilter[1][0]||
					edited.elementAt(i).totalPri<pointFilter[0][0]||
					edited.elementAt(i).totalAttendChecking>pointFilter[1][1]||
					edited.elementAt(i).totalAttendChecking<pointFilter[0][1]||
					edited.elementAt(i).totalGrading>pointFilter[1][2]||
					edited.elementAt(i).totalGrading<pointFilter[0][2]||
					edited.elementAt(i).totalDifficulty>pointFilter[1][3]||
					edited.elementAt(i).totalDifficulty<pointFilter[0][3]||
					edited.elementAt(i).totalEffort>pointFilter[1][4]||
					edited.elementAt(i).totalEffort<pointFilter[0][4]||
					edited.elementAt(i).totalDoneit>pointFilter[1][5]||
					edited.elementAt(i).totalDoneit<pointFilter[0][5]
					) {
				edited.removeElementAt(i);
				i--;
			}
		}
	}
	
	void FILTEREDCALCUALATION (Vector <Group> gv){
		if(isRight) {
			gv=applyEmptyDayFilter(gv);
		if(isRight) {
			gv=applyEmptyPeriodFilter(gv);
			calculateTable(gv);
			
			if(!creeditFilter.isEmpty()) {
				for(int i=0;i<creeditFilter.size();i++) {
					creeditFilter (creeditFilter.elementAt(i));
				}
			}
			if(!edited.isEmpty())
			PriFilter();
			
			if(!edited.isEmpty())
			sortbyPri();
			
			printFilter();
			
			System.out.println("---<�ð�ǥ>---");
			System.out.println("������ �ð�ǥ�� ��: "+edited.size()+"��\n");
			if(!edited.isEmpty())
				for(int i=0;i<edited.size();i++)
					{
					printTable (edited.elementAt(i));
					System.out.println();
					}
			}
			else endProgram ("�ð�ǥ ������ �Ұ��� �մϴ�.");
		}
		else endProgram ("�ð�ǥ ������ �Ұ��� �մϴ�.");
	}
	void printFilter () {
		System.out.println("---<��������>---");
		if(emptyDayFilter[0])System.out.print("(���� ����) ");
		if(emptyDayFilter[1])System.out.print("(ȭ�� ����) ");
		if(emptyDayFilter[2])System.out.print("(���� ����) ");
		if(emptyDayFilter[3])System.out.print("(��� ����) ");
		if(emptyDayFilter[4])System.out.print("(�ݿ� ����) ");
		System.out.println();
		for(int i=0;i<8;i++)
		if(emptyPeriodFilter[i])System.out.print("("+(i+1)+"���� ����) ");
		System.out.println();
		
		System.out.println("---<��������>---");
		if(!creeditFilter.isEmpty()) {
			for(int i=0;i<creeditFilter.size();i++)
				System.out.print("("+creeditFilter.elementAt(i)+"����"+") ");
		}
		else System.out.println("�������Ͱ� �����ϴ�. ��");
		
		System.out.println();
		
		System.out.println("---<��������>---");
		System.out.println("��� ��ȣ��: "+pointFilter[0][0]+"�̻�, "+pointFilter[1][0]+"����");
		System.out.println("��� �⼮üũ: "+pointFilter[0][1]+"�̻�, "+pointFilter[1][1]+"����");
		System.out.println("��� ����: "+pointFilter[0][2]+"�̻�, "+pointFilter[1][2]+"����");
		System.out.println("��� ���̵�: "+pointFilter[0][3]+"�̻�, "+pointFilter[1][3]+"����");
		System.out.println("��� �н���: "+pointFilter[0][4]+"�̻�, "+pointFilter[1][4]+"����");
		System.out.println("��� ���밨: "+pointFilter[0][5]+"�̻�, "+pointFilter[1][5]+"����");
		System.out.println();
		
	}
	
	void printTable (Table t) {
		System.out.println("�� ����: "+t.totalCre+", ��� ��ȣ��: "+t.totalPri+",��� �⼮üũ: "+t.totalAttendChecking+",��� ����: "+t.totalGrading+", ��� ���̵�: " +t.totalDifficulty+", ��� �н���: " +t.totalEffort+", ��� ���밨: "+t.totalDoneit+"�����ʼ�����: "+t.courseKind[0]+"��, �������ð���: "+t.courseKind[1]+"��, �������"+t.courseKind[2]+"��");
		if(!t.courseInfo.isEmpty()) {
			for(int i=0;i<t.courseInfo.size();i++) {
				m.printCourse(t.courseInfo.elementAt(i));
			}
		}
	}
}