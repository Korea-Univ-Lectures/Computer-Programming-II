package Schedule_Project5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	String courseName;
	String instructorName;
	String placeName;
	
	int creedit;//학점
	boolean isVoid;//필수계산여부
	int kind;
	
	double priority; //우선도
	double attendChecking; //출석체크 정도
	double grading;// 성적
	double difficulty; //난이도
	double effort; //학습량
	double doneit;//성취감
	
	static Scanner sc = new Scanner(System.in);
	
	static GroupManager gm = new GroupManager();
	static TableManager tm = new TableManager();

	Main() {
		
	}
	
	public static void clearScreen() {
	    for (int i = 0; i < 80; i++)
	      System.out.println("");
	 }
	
	public static int getInt(Scanner sc, int first, int last) {
		int intInput;
		do {
			try {
				System.out.print("표시된 정수를 입력하시오("+first+"~"+last+"): ");
				intInput=sc.nextInt();
				sc.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println("올바른 형식대로 입력하십시오\n");
				intInput=-1;
				sc.nextLine();
			}
		} while(intInput<first||intInput>last);
		
		return intInput;
	 }
	
	public static double getDouble(Scanner sc, String consol) {
		double doubleInput;
		do {
			try {
				System.out.print(consol+"(0.0~5.0): ");
				doubleInput=sc.nextDouble();
				sc.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println("올바른 형식대로 입력하십시오\n");
				doubleInput=-1;
				sc.nextLine();
			}
		} while(doubleInput<0||doubleInput>5.0);
		
		return doubleInput;
	 }

	public static int getCreedit (Scanner sc) {
		int creedit;
		do {
			try {
				System.out.print("학점(0이상): ");
				creedit=sc.nextInt();
				sc.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println("올바른 형식대로 입력하십시오\n");
				creedit=-1;
				sc.nextLine();
			}
		} while(creedit<0);
		
		return creedit;
	}
	
	public static boolean getBoolean (Scanner sc) {
		boolean b;
		int inputInt= getInt(sc,0,1);
		if(inputInt==0) b=true;
		else b=false;
		
		return b;
	} 
	
	public void getGroupInfo(Scanner sc) {
		System.out.print("강의 이름: ");
		courseName=sc.nextLine();
		
		creedit=getCreedit(sc);
		
		System.out.println("과목종류(0:전공필수, 1:전공선택, 2:교양): ");
		kind=getInt(sc, 0, 2);
		
		System.out.println("필수계산여부(0:필수, 1:여유): ");
		isVoid=getBoolean(sc);
	}
	
	public void getCourseInfo (Scanner sc) {
		System.out.print("강의자 이름: ");
		instructorName=sc.nextLine();
		
		System.out.print("강의장소 이름: ");
		placeName=sc.nextLine();
		
		attendChecking=getDouble(sc, "출석체크");
		grading=getDouble(sc, "성적");
		difficulty=getDouble(sc, "난이도");
		effort=getDouble(sc,"학습량");
		doneit=getDouble(sc,"성취감");
	}

	
	public static void main(String[] args) {
		Main m = new Main();
		
		boolean isLoop = true;
		
		int intInput;
	
		while(isLoop) {
			System.out.println("---<MENU>---");
			System.out.println("1:과목정보확인 ");
			System.out.println("2:과목추가       ");
			System.out.println("3:과목수정       ");
			System.out.println("4:과목삭제       ");
			System.out.println("5:후보과목편집 ");
			System.out.println("6:시간표계산    ");
			System.out.println("0:프로그램종료 ");
			System.out.println("------------\n");

			intInput=getInt(m.sc, 0, 6);
			
			switch (intInput){
				case 0: {
					clearScreen();
					isLoop=false;
					break;
				}
				case 1: {
					clearScreen();
					System.out.println("---<과목확인>---");
					System.out.println("1:전체과목확인 ");
					System.out.println("2:선택과목확인 "); 
					System.out.println("0:뒤로 가기      ");
					System.out.println("------------\n");
					intInput=getInt(m.sc, 0, 2);
					
					switch(intInput) {
					case 1: {
						clearScreen();
						gm.printGV(gm.gv);
						break;
					}
					case 2: {
						clearScreen();
						gm.printGV(gm.selectedGV);
						break;
					}
					case 0: {
						clearScreen();
						break;
					}
				}
					break;
				}
				case 2:{
					clearScreen();
					System.out.println("---<MENU>---");
					System.out.println("1:과목추가       ");
					System.out.println("2:동질 과목추가");
					System.out.println("0:뒤로 가기      ");
					System.out.println("------------\n");
				
					intInput=getInt(m.sc, 0, 2);
					
					switch(intInput) {
						case 1: {
							clearScreen();
							m.getGroupInfo(m.sc);
							m.getCourseInfo(m.sc);
							gm.addCourseGroup(m);
							gm.setTempGroup(gm.gv.size()-1);
							gm.addCourse(m);
							break;
						}
						case 2: {
							clearScreen();
							System.out.println("---<과목목록>---"); 
							gm.printGVName();
					
							System.out.println("--------------"); 
							System.out.print("제시된 과목 중 하나를 선택하시오: ");
							intInput=getInt(sc, 0, gm.gv.size()-1);
							
							m.getCourseInfo(sc);
							gm.setTempGroup(intInput);
							gm.addCourse(m);
							
							break;
						}
						case 0: {
							clearScreen();
							break;
						}
					}
					break;
				}
				case 3: {
					clearScreen();
					System.out.println("---<MENU>---");
					System.out.println("1:과목 수정      ");
					System.out.println("2:동질 과목수정");
					System.out.println("0:뒤로 가기      ");
					System.out.println("------------\n");
				
					intInput=getInt(m.sc, 0, 2);
				switch (intInput) {
						case 1: {
							clearScreen();
							System.out.println("---<과목목록>---"); 
							gm.printGVName();
							System.out.println("--------------");
							System.out.print("제시된 과목 중 하나를 선택하시오: ");
							
							gm.setTempGroup(getInt(sc, 0, gm.gv.size()-1));
							m.getGroupInfo(sc);
							gm.editGroup(m);
							
							break;
						}
						case 2: {
							clearScreen();
							System.out.println("---<과목목록>---"); 
							gm.printGVName();
							System.out.println("--------------");
							System.out.print("제시된 과목 중 하나를 선택하시오: ");
							
							gm.setTempGroup(getInt(sc, 0, gm.gv.size()-1));
							
							System.out.println("--<동질과목목록>--"); 
							gm.printG(gm.gv.elementAt(gm.tempGruopIndex));
							System.out.println("--------------");
							System.out.print("제시된 과목 중 하나를 선택하시오: ");
							gm.setTempCourse(getInt(sc, 0, gm.gv.elementAt(gm.tempGruopIndex).cv.size()-1));
					
							m.getCourseInfo(sc);
							gm.editCourse(m);
							
							break;
						}
						case 0: {
							clearScreen();
							break;
						}
					}
					break;
				}
				case 4: {
					clearScreen();
					System.out.println("---<MENU>---");
					System.out.println("1:과목 삭제      ");
					System.out.println("2:동질 과목삭제");
					System.out.println("0:뒤로 가기      ");
					System.out.println("------------\n");
				
					intInput=getInt(m.sc, 0, 2);
				switch (intInput) {
						case 1: {
							clearScreen();
							System.out.println("---<과목목록>---"); 
							gm.printGVName();
							System.out.println("--------------");
							System.out.print("제시된 과목 중 하나를 선택하시오: ");
							
							gm.setTempGroup(getInt(sc, 0, gm.gv.size()-1));
			
							gm.eraseGroup();
							
							break;
						}
						case 2: {
							clearScreen();
							System.out.println("---<과목목록>---"); 
							gm.printGVName();
							System.out.println("--------------");
							System.out.print("제시된 과목 중 하나를 선택하시오: ");
							
							gm.setTempGroup(getInt(sc, 0, gm.gv.size()-1));
							
							System.out.println("--<동질과목목록>--"); 
							gm.printG(gm.gv.elementAt(gm.tempGruopIndex));
							System.out.println("--------------");
							System.out.print("제시된 과목 중 하나를 선택하시오: ");
							gm.setTempCourse(getInt(sc, 0, gm.gv.elementAt(gm.tempGruopIndex).cv.size()-1));
			
							gm.eraseCourse();
							
							break;
						}
						case 0: {
							clearScreen();
							break;
						}
					}
					break;
				}
				case 5:{
					clearScreen();
					System.out.println("---<MENU>---");
					System.out.println("1:후보과목추가 ");
					System.out.println("2:후보과목삭제");
					System.out.println("0:뒤로 가기      ");
					System.out.println("------------\n");
					
					intInput=getInt(m.sc, 0, 2);
					switch (intInput) {
							case 1: {
								clearScreen();
								System.out.println("---<과목목록>---"); 
								gm.printGVName();
								System.out.println("--------------");
								System.out.print("계산할 과목 하나를 선택하시오: ");
								
								gm.setTempGroup(getInt(sc, 0, gm.gv.size()-1));
				
								gm.addSelection();
								
								break;
							}
							case 2: {
								clearScreen();
								System.out.println("--<후보과목목록>--"); 
								gm.printSelction();
								System.out.println("--------------");
								System.out.print("목록에서 제외할 후보과목 하나를 선택하시오: ");
								
								gm.eraseSelection (getInt(sc, 0, gm.selectedGV.size()-1));
								
								break;
							}
							case 0: {
								clearScreen();
								break;
							}
						}
					
					break;
				}
				case 6:{
					clearScreen();
					boolean isInput=true;
					if(!gm.selectedGV.isEmpty()) {
					System.out.println("\n---<공강필터>---");
					while(true) {
						System.out.println("요일 공강필터를 설정하시겠습니까?(0:yes, 1:no)");
						isInput=m.getBoolean(m.sc);
						if(!isInput) break;
						
						System.out.println("---<요일입력>---");
						System.out.println("1: 월요일            ");
						System.out.println("2: 화요일            ");
						System.out.println("3: 수요일            ");
						System.out.println("4: 목요일            ");
						System.out.println("5: 금요일            ");
						System.out.println("--------------");
						tm.emptyDayFilter[m.getInt(m.sc, 1, 5)-1]=true;
					}
					isInput=true;
					while(true) {
						System.out.println("교시 공강필터를 설정하시겠습니까?(0:yes, 1:no)");
						isInput=m.getBoolean(m.sc);
						if(!isInput) break;
						
						System.out.println("---<교시입력>---");
						System.out.println("1: 1교시             ");
						System.out.println("2: 2교시             ");
						System.out.println("3: 3교시             ");
						System.out.println("4: 4교시             ");
						System.out.println("5: 5교시             ");
						System.out.println("6: 6교시             ");
						System.out.println("7: 7교시             ");
						System.out.println("8: 8교시             ");
						System.out.println("--------------");
						tm.emptyPeriodFilter[m.getInt(m.sc, 1, 8)-1]=true;
					}
					System.out.println("\n---<학점필터>---");
					isInput=true;
					while(isInput) {
						System.out.println("학점필터를 설정하시겠습니까?(0:yes, 1:no)");
						isInput=m.getBoolean(sc);
						if(!isInput) break;
						
						tm.creeditFilter.add(getCreedit(sc));
					}
					System.out.println("\n---<점수필터>---");
					isInput=true;
					while(isInput) {
						System.out.println("선호도 필터를 설정하시겠습니까??(0:yes, 1:no)");
						isInput=m.getBoolean(m.sc);
						if(!isInput) break;
						
						tm.pointFilter[0][0]=m.getDouble(sc,"최소 선호도");
						tm.pointFilter[1][0]=m.getDouble(sc,"최대 선호도");
					}
					isInput=true;
					while(isInput) {
						System.out.println("출석체크 필터를 설정하시겠습니까??(0:yes, 1:no)");
						isInput=m.getBoolean(sc);
						if(!isInput) break;
						
						tm.pointFilter[0][1]=m.getDouble(sc,"최소 선호도");
						tm.pointFilter[1][1]=m.getDouble(sc,"최대 선호도");
					}
					isInput=true;
					while(isInput) {
						System.out.println("성적 필터를 설정하시겠습니까??(0:yes, 1:no)");
						isInput=m.getBoolean(sc);
						if(!isInput) break;
						
						tm.pointFilter[0][2]=m.getDouble(sc,"최소 선호도");
						tm.pointFilter[1][2]=m.getDouble(sc,"최대 선호도");
					}
					isInput=true;
					while(isInput) {
						System.out.println("난이도 필터를 설정하시겠습니까??(0:yes, 1:no)");
						isInput=m.getBoolean(m.sc);
						if(!isInput) break;
						
						tm.pointFilter[0][0]=m.getDouble(sc,"최소 선호도");
						tm.pointFilter[1][0]=m.getDouble(sc,"최대 선호도");
					}
					isInput=true;
					while(isInput) {
						System.out.println("학습량 필터를 설정하시겠습니까??(0:yes, 1:no)");
						isInput=m.getBoolean(m.sc);
						if(!isInput) break;
						
						tm.pointFilter[0][0]=m.getDouble(sc,"최소 선호도");
						tm.pointFilter[1][0]=m.getDouble(sc,"최대 선호도");
					}
					isInput=true;
					while(isInput) {
						System.out.println("성취감 필터를 설정하시겠습니까??(0:yes, 1:no)");
						isInput=m.getBoolean(m.sc);
						if(!isInput) break;
						
						tm.pointFilter[0][0]=m.getDouble(sc,"최소 선호도");
						tm.pointFilter[1][0]=m.getDouble(sc,"최대 선호도");
					}
					if(!gm.selectedGV.isEmpty())tm.FILTEREDCALCUALATION(gm.selectedGV);
					else System.out.println("조건을 만족하는 시간표가 존재하지 않습니다.");
					
					System.out.println("0을 입력하여 프로그램을 종료하시오");
					getInt(sc, 0,0);
					System.exit(0);
					}
					else {
						System.out.println("선택한 과목이 존재하지 않습니다.");
					}
					break;
				}
			
			}
		}
	}
}
