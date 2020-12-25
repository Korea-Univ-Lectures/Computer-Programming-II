package Schedule_Project5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	String courseName;
	String instructorName;
	String placeName;
	
	int creedit;//����
	boolean isVoid;//�ʼ���꿩��
	int kind;
	
	double priority; //�켱��
	double attendChecking; //�⼮üũ ����
	double grading;// ����
	double difficulty; //���̵�
	double effort; //�н���
	double doneit;//���밨
	
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
				System.out.print("ǥ�õ� ������ �Է��Ͻÿ�("+first+"~"+last+"): ");
				intInput=sc.nextInt();
				sc.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println("�ùٸ� ���Ĵ�� �Է��Ͻʽÿ�\n");
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
				System.out.println("�ùٸ� ���Ĵ�� �Է��Ͻʽÿ�\n");
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
				System.out.print("����(0�̻�): ");
				creedit=sc.nextInt();
				sc.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println("�ùٸ� ���Ĵ�� �Է��Ͻʽÿ�\n");
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
		System.out.print("���� �̸�: ");
		courseName=sc.nextLine();
		
		creedit=getCreedit(sc);
		
		System.out.println("��������(0:�����ʼ�, 1:��������, 2:����): ");
		kind=getInt(sc, 0, 2);
		
		System.out.println("�ʼ���꿩��(0:�ʼ�, 1:����): ");
		isVoid=getBoolean(sc);
	}
	
	public void getCourseInfo (Scanner sc) {
		System.out.print("������ �̸�: ");
		instructorName=sc.nextLine();
		
		System.out.print("������� �̸�: ");
		placeName=sc.nextLine();
		
		attendChecking=getDouble(sc, "�⼮üũ");
		grading=getDouble(sc, "����");
		difficulty=getDouble(sc, "���̵�");
		effort=getDouble(sc,"�н���");
		doneit=getDouble(sc,"���밨");
	}

	
	public static void main(String[] args) {
		Main m = new Main();
		
		boolean isLoop = true;
		
		int intInput;
	
		while(isLoop) {
			System.out.println("---<MENU>---");
			System.out.println("1:��������Ȯ�� ");
			System.out.println("2:�����߰�       ");
			System.out.println("3:�������       ");
			System.out.println("4:�������       ");
			System.out.println("5:�ĺ��������� ");
			System.out.println("6:�ð�ǥ���    ");
			System.out.println("0:���α׷����� ");
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
					System.out.println("---<����Ȯ��>---");
					System.out.println("1:��ü����Ȯ�� ");
					System.out.println("2:���ð���Ȯ�� "); 
					System.out.println("0:�ڷ� ����      ");
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
					System.out.println("1:�����߰�       ");
					System.out.println("2:���� �����߰�");
					System.out.println("0:�ڷ� ����      ");
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
							System.out.println("---<������>---"); 
							gm.printGVName();
					
							System.out.println("--------------"); 
							System.out.print("���õ� ���� �� �ϳ��� �����Ͻÿ�: ");
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
					System.out.println("1:���� ����      ");
					System.out.println("2:���� �������");
					System.out.println("0:�ڷ� ����      ");
					System.out.println("------------\n");
				
					intInput=getInt(m.sc, 0, 2);
				switch (intInput) {
						case 1: {
							clearScreen();
							System.out.println("---<������>---"); 
							gm.printGVName();
							System.out.println("--------------");
							System.out.print("���õ� ���� �� �ϳ��� �����Ͻÿ�: ");
							
							gm.setTempGroup(getInt(sc, 0, gm.gv.size()-1));
							m.getGroupInfo(sc);
							gm.editGroup(m);
							
							break;
						}
						case 2: {
							clearScreen();
							System.out.println("---<������>---"); 
							gm.printGVName();
							System.out.println("--------------");
							System.out.print("���õ� ���� �� �ϳ��� �����Ͻÿ�: ");
							
							gm.setTempGroup(getInt(sc, 0, gm.gv.size()-1));
							
							System.out.println("--<����������>--"); 
							gm.printG(gm.gv.elementAt(gm.tempGruopIndex));
							System.out.println("--------------");
							System.out.print("���õ� ���� �� �ϳ��� �����Ͻÿ�: ");
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
					System.out.println("1:���� ����      ");
					System.out.println("2:���� �������");
					System.out.println("0:�ڷ� ����      ");
					System.out.println("------------\n");
				
					intInput=getInt(m.sc, 0, 2);
				switch (intInput) {
						case 1: {
							clearScreen();
							System.out.println("---<������>---"); 
							gm.printGVName();
							System.out.println("--------------");
							System.out.print("���õ� ���� �� �ϳ��� �����Ͻÿ�: ");
							
							gm.setTempGroup(getInt(sc, 0, gm.gv.size()-1));
			
							gm.eraseGroup();
							
							break;
						}
						case 2: {
							clearScreen();
							System.out.println("---<������>---"); 
							gm.printGVName();
							System.out.println("--------------");
							System.out.print("���õ� ���� �� �ϳ��� �����Ͻÿ�: ");
							
							gm.setTempGroup(getInt(sc, 0, gm.gv.size()-1));
							
							System.out.println("--<����������>--"); 
							gm.printG(gm.gv.elementAt(gm.tempGruopIndex));
							System.out.println("--------------");
							System.out.print("���õ� ���� �� �ϳ��� �����Ͻÿ�: ");
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
					System.out.println("1:�ĺ������߰� ");
					System.out.println("2:�ĺ��������");
					System.out.println("0:�ڷ� ����      ");
					System.out.println("------------\n");
					
					intInput=getInt(m.sc, 0, 2);
					switch (intInput) {
							case 1: {
								clearScreen();
								System.out.println("---<������>---"); 
								gm.printGVName();
								System.out.println("--------------");
								System.out.print("����� ���� �ϳ��� �����Ͻÿ�: ");
								
								gm.setTempGroup(getInt(sc, 0, gm.gv.size()-1));
				
								gm.addSelection();
								
								break;
							}
							case 2: {
								clearScreen();
								System.out.println("--<�ĺ�������>--"); 
								gm.printSelction();
								System.out.println("--------------");
								System.out.print("��Ͽ��� ������ �ĺ����� �ϳ��� �����Ͻÿ�: ");
								
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
					System.out.println("\n---<��������>---");
					while(true) {
						System.out.println("���� �������͸� �����Ͻðڽ��ϱ�?(0:yes, 1:no)");
						isInput=m.getBoolean(m.sc);
						if(!isInput) break;
						
						System.out.println("---<�����Է�>---");
						System.out.println("1: ������            ");
						System.out.println("2: ȭ����            ");
						System.out.println("3: ������            ");
						System.out.println("4: �����            ");
						System.out.println("5: �ݿ���            ");
						System.out.println("--------------");
						tm.emptyDayFilter[m.getInt(m.sc, 1, 5)-1]=true;
					}
					isInput=true;
					while(true) {
						System.out.println("���� �������͸� �����Ͻðڽ��ϱ�?(0:yes, 1:no)");
						isInput=m.getBoolean(m.sc);
						if(!isInput) break;
						
						System.out.println("---<�����Է�>---");
						System.out.println("1: 1����             ");
						System.out.println("2: 2����             ");
						System.out.println("3: 3����             ");
						System.out.println("4: 4����             ");
						System.out.println("5: 5����             ");
						System.out.println("6: 6����             ");
						System.out.println("7: 7����             ");
						System.out.println("8: 8����             ");
						System.out.println("--------------");
						tm.emptyPeriodFilter[m.getInt(m.sc, 1, 8)-1]=true;
					}
					System.out.println("\n---<��������>---");
					isInput=true;
					while(isInput) {
						System.out.println("�������͸� �����Ͻðڽ��ϱ�?(0:yes, 1:no)");
						isInput=m.getBoolean(sc);
						if(!isInput) break;
						
						tm.creeditFilter.add(getCreedit(sc));
					}
					System.out.println("\n---<��������>---");
					isInput=true;
					while(isInput) {
						System.out.println("��ȣ�� ���͸� �����Ͻðڽ��ϱ�??(0:yes, 1:no)");
						isInput=m.getBoolean(m.sc);
						if(!isInput) break;
						
						tm.pointFilter[0][0]=m.getDouble(sc,"�ּ� ��ȣ��");
						tm.pointFilter[1][0]=m.getDouble(sc,"�ִ� ��ȣ��");
					}
					isInput=true;
					while(isInput) {
						System.out.println("�⼮üũ ���͸� �����Ͻðڽ��ϱ�??(0:yes, 1:no)");
						isInput=m.getBoolean(sc);
						if(!isInput) break;
						
						tm.pointFilter[0][1]=m.getDouble(sc,"�ּ� ��ȣ��");
						tm.pointFilter[1][1]=m.getDouble(sc,"�ִ� ��ȣ��");
					}
					isInput=true;
					while(isInput) {
						System.out.println("���� ���͸� �����Ͻðڽ��ϱ�??(0:yes, 1:no)");
						isInput=m.getBoolean(sc);
						if(!isInput) break;
						
						tm.pointFilter[0][2]=m.getDouble(sc,"�ּ� ��ȣ��");
						tm.pointFilter[1][2]=m.getDouble(sc,"�ִ� ��ȣ��");
					}
					isInput=true;
					while(isInput) {
						System.out.println("���̵� ���͸� �����Ͻðڽ��ϱ�??(0:yes, 1:no)");
						isInput=m.getBoolean(m.sc);
						if(!isInput) break;
						
						tm.pointFilter[0][0]=m.getDouble(sc,"�ּ� ��ȣ��");
						tm.pointFilter[1][0]=m.getDouble(sc,"�ִ� ��ȣ��");
					}
					isInput=true;
					while(isInput) {
						System.out.println("�н��� ���͸� �����Ͻðڽ��ϱ�??(0:yes, 1:no)");
						isInput=m.getBoolean(m.sc);
						if(!isInput) break;
						
						tm.pointFilter[0][0]=m.getDouble(sc,"�ּ� ��ȣ��");
						tm.pointFilter[1][0]=m.getDouble(sc,"�ִ� ��ȣ��");
					}
					isInput=true;
					while(isInput) {
						System.out.println("���밨 ���͸� �����Ͻðڽ��ϱ�??(0:yes, 1:no)");
						isInput=m.getBoolean(m.sc);
						if(!isInput) break;
						
						tm.pointFilter[0][0]=m.getDouble(sc,"�ּ� ��ȣ��");
						tm.pointFilter[1][0]=m.getDouble(sc,"�ִ� ��ȣ��");
					}
					if(!gm.selectedGV.isEmpty())tm.FILTEREDCALCUALATION(gm.selectedGV);
					else System.out.println("������ �����ϴ� �ð�ǥ�� �������� �ʽ��ϴ�.");
					
					System.out.println("0�� �Է��Ͽ� ���α׷��� �����Ͻÿ�");
					getInt(sc, 0,0);
					System.exit(0);
					}
					else {
						System.out.println("������ ������ �������� �ʽ��ϴ�.");
					}
					break;
				}
			
			}
		}
	}
}
