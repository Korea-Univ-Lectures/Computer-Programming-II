package Schedule_Project5;

import java.util.Scanner;
import java.util.Vector;

class TableManager {
	Vector <Table> tv = new Vector(); //시간표로 올려진 강의들, 기본 시간표 벡터
	Vector <Table> edited= new Vector();//학점필터링을 거쳐서 올라온 필터
	
	boolean [] emptyDayFilter = new boolean[5];
	boolean [] emptyPeriodFilter = new boolean[8];
	Vector <Integer> creeditFilter = new Vector();
	double [][] pointFilter = new double [2][6];
	
	boolean isRight=true;//시간표계산이 유효한가?
	
	Scanner sc1 =new Scanner(System.in);

	GroupManager m = new GroupManager();
	
	/*
	 * [0][]:최소경계
	 * [1][]:최대경계
	 * 
	 * [][0]:평균선호도
	 * [][1]:attendChecking; //출석체크 정도
	 * [][2]:grading;// 성적
	 * [][3]:difficulty; //난이도
	 * [][4]:effort; //학습량
	 * [][5]:doneit;//성취감
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
	
	//프로그램 종료
	void endProgram (String endMessage) {
		System.out.println(endMessage);
		System.out.println("계속하려면 엔터키를 누르시오");
		sc1.nextLine();
		System.exit(0);
	}
	
	//공강필터 과목적용
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
											endProgram ("후보 과목들이 요일 공강을 만족하지 않습니다.");
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
	
	//시간필터 과목적용
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
											endProgram ("후보 과목들이 교시 공강을 만족하지 않습니다.");
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
	
	//학점필터
	void creeditFilter (int cre) {
		if(!tv.isEmpty()) {
			for(int i=0;i<tv.size();i++) {
				if(tv.elementAt(i).totalCre==cre) {
					edited.add(tv.elementAt(i));
				}
			}
		}
	}
	
	//초기 시간표 적용
 	void FirstTable(Vector <Group> gv) {
		if(gv.isEmpty())
			System.out.println("최소 한개 이상의 강의그룹이 있어야합니다.");
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
	
	//시간표에 순차적 그룹 적용
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
	
	//시간표 계산
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
			System.out.println("선택된 과목이 없습니다.");
	}

	//선호도 배열
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

	//point 필터
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
			
			System.out.println("---<시간표>---");
			System.out.println("가능한 시간표의 수: "+edited.size()+"개\n");
			if(!edited.isEmpty())
				for(int i=0;i<edited.size();i++)
					{
					printTable (edited.elementAt(i));
					System.out.println();
					}
			}
			else endProgram ("시간표 생성이 불가능 합니다.");
		}
		else endProgram ("시간표 생성이 불가능 합니다.");
	}
	void printFilter () {
		System.out.println("---<공강필터>---");
		if(emptyDayFilter[0])System.out.print("(월요 공강) ");
		if(emptyDayFilter[1])System.out.print("(화요 공강) ");
		if(emptyDayFilter[2])System.out.print("(수요 공강) ");
		if(emptyDayFilter[3])System.out.print("(목요 공강) ");
		if(emptyDayFilter[4])System.out.print("(금요 공강) ");
		System.out.println();
		for(int i=0;i<8;i++)
		if(emptyPeriodFilter[i])System.out.print("("+(i+1)+"교시 공강) ");
		System.out.println();
		
		System.out.println("---<학점필터>---");
		if(!creeditFilter.isEmpty()) {
			for(int i=0;i<creeditFilter.size();i++)
				System.out.print("("+creeditFilter.elementAt(i)+"학점"+") ");
		}
		else System.out.println("학점필터가 없습니다. 뀨");
		
		System.out.println();
		
		System.out.println("---<점수필터>---");
		System.out.println("평균 선호도: "+pointFilter[0][0]+"이상, "+pointFilter[1][0]+"이하");
		System.out.println("평균 출석체크: "+pointFilter[0][1]+"이상, "+pointFilter[1][1]+"이하");
		System.out.println("평균 성적: "+pointFilter[0][2]+"이상, "+pointFilter[1][2]+"이하");
		System.out.println("평균 난이도: "+pointFilter[0][3]+"이상, "+pointFilter[1][3]+"이하");
		System.out.println("평균 학습량: "+pointFilter[0][4]+"이상, "+pointFilter[1][4]+"이하");
		System.out.println("평균 성취감: "+pointFilter[0][5]+"이상, "+pointFilter[1][5]+"이하");
		System.out.println();
		
	}
	
	void printTable (Table t) {
		System.out.println("총 학점: "+t.totalCre+", 평균 선호도: "+t.totalPri+",평균 출석체크: "+t.totalAttendChecking+",평균 성적: "+t.totalGrading+", 평균 난이도: " +t.totalDifficulty+", 평균 학습량: " +t.totalEffort+", 평균 성취감: "+t.totalDoneit+"전공필수과목: "+t.courseKind[0]+"개, 전공선택과목: "+t.courseKind[1]+"개, 교양과목"+t.courseKind[2]+"개");
		if(!t.courseInfo.isEmpty()) {
			for(int i=0;i<t.courseInfo.size();i++) {
				m.printCourse(t.courseInfo.elementAt(i));
			}
		}
	}
}