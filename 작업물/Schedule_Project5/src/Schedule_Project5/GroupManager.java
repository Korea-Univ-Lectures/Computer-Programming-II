package Schedule_Project5;

import java.util.Scanner;
import java.util.Vector;

import java.io.Serializable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

class GroupManager implements Serializable{
	Vector <Group> gv =new Vector(); //�� ���� �׷�
	Vector <Group> selectedGV = new Vector();//������ ���Ǳ׷�
	
	int tempGruopIndex;//���� ���� ���� �׷�
	int tempCourseIndex;//���� ���� ���� �׷�
	
	GroupManager () {
		try {readGV();}
		catch(Exception e) {e.printStackTrace();}
		
		try {readGVSelection();}
		catch(Exception e) {e.printStackTrace();}
	}
	
	//���� �׷� �߰�
	void addCourseGroup(Main m) {
		Group g1= new Group(m.courseName, m.isVoid, m.creedit, m.kind);
		gv.add(g1);
		writeGV();
	}
	
	//���� �߰�
	void addCourse(Main m) {
		if(!gv.isEmpty()) 
		{course c1 = new course(gv.elementAt(tempGruopIndex).GroupName, m.instructorName, m.placeName, m.attendChecking, m.grading, m.difficulty, m.effort, m.doneit, gv.elementAt(tempGruopIndex).creedit,getTime(), gv.elementAt(tempGruopIndex).kind, gv.elementAt(tempGruopIndex).isVoid );
		
		gv.elementAt(tempGruopIndex).cv.add(c1);
		writeGV();
		}
		else System.out.println("������ �������� �ʽ��ϴ�.");
	}
	
	//���� ���� �׷�  ����
	void setTempGroup (int i) {
		if(i<gv.size())
			tempGruopIndex=i;
		else
			System.out.println("�׷��� �ε����� �������� �ʽ��ϴ�.");
	}
	
	//���� ���� ���� ����
	void setTempCourse (int i) {
		if(i<gv.elementAt(tempGruopIndex).cv.size())
			tempCourseIndex=i;
		else
			System.out.println("�׷��� �ε����� �������� �ʽ��ϴ�.");
	}
	
	//�ð� ���� ���� �żҵ�
	Vector<time> getTime() {
		Vector <time> tv =new Vector();
		Main m = new Main();
		int inputInt;
		boolean isLoop=true;
		
		int day;
		int period;
		
		while(true) {
			System.out.println("�ð��� �Է��Ͻðڽ��ϱ�?(0:yes, 1:no)");
			isLoop=m.getBoolean(m.sc);
			if(!isLoop) break;
			
			System.out.println("---<�����Է�>---");
			System.out.println("1: ������            ");
			System.out.println("2: ȭ����            ");
			System.out.println("3: ������            ");
			System.out.println("4: �����            ");
			System.out.println("5: �ݿ���            ");
			System.out.println("--------------");
			day=m.getInt(m.sc, 1, 5)-1;
			
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
			period = m.getInt(m.sc, 1, 8)-1;
			
			time t = new time(day,period);
			tv.add(t);
		}
		return tv;
	}

	//�����������
	void printCourse(course c) {
		System.out.print("���Ǹ�:"+c.courseName);
		System.out.print(", ������:"+c.instructor);
		System.out.print(", �������:"+c.place);
		
		if(!c.isVoid) System.out.print(", �ʼ�����");
		else System.out.print(", ��������");
		
		switch(c.kind) {
		case 0: System.out.print(", �����ʼ�");
		case 1: System.out.print(", ��������");
		case 2: System.out.print(", ����");
		}
		
		System.out.print(", ����:"+c.creedit);
		
		System.out.print(", ��ȣ��:"+c.priority);
		System.out.print(", �⼮üũ:"+c.attendChecking);
		System.out.print(", ����:"+c.grading);
		System.out.print(", ���̵�:"+c.difficulty);
		System.out.print(", �н���:"+c.effort);
		System.out.print(", ���밨:"+c.doneit);
		if(!c.tv.isEmpty()) 
			for(int i=0;i<c.tv.size();i++) {
				System.out.print(", ");
				switch(c.tv.elementAt(i).day) {
				case 0:System.out.print("��(");
				break;
				case 1:System.out.print("ȭ(");
				break;
				case 2:System.out.print("��(");
				break;
				case 3:System.out.print("��(");
				break;
				case 4:System.out.print("��(");
				break;
				}
				
				switch(c.tv.elementAt(i).period) {
				case 0:System.out.print("1)");
				break;
				case 1:System.out.print("2)");
				break;
				case 2:System.out.print("3)");
				break;
				case 3:System.out.print("4)");
				break;
				case 4:System.out.print("5)");
				break;
				case 5:System.out.print("6)");
				break;
				case 6:System.out.print("7)");
				break;
				case 7:System.out.print("8)");	
				break;
				}	
			}
		System.out.println();
	} 
	
	//�׷� �������
	void printGroup(Group g) {
		System.out.println();
		printCourse(g.cv.elementAt(0));
		for(int i=1;i<g.cv.size();i++) {
			System.out.print("��(��������)");
			printCourse(g.cv.elementAt(i));
		}
	}

	//�׷캤�� �������
	void printGV (Vector <Group> GV) {
		if(!GV.isEmpty()) {
			for(int i=0;i<GV.size();i++) {
				printGroup(GV.elementAt(i));
			}
		}
		else {System.out.println("������ �������� �ʽ��ϴ�.");}
	}
	
	//�׷��̸� ���
	void printGVName() {
		if(!gv.isEmpty()) {
			for(int i=0;i<gv.size();i++) {
				System.out.println((i)+":"+gv.elementAt(i).GroupName);
			}
		}
		else {System.out.println("������ �������� �ʽ��ϴ�.");}
	}
	
	//���������̸� ���
	void printG(Group g) {
		for(int i=0;i<g.cv.size();i++) {
			System.out.println((i)+":"+g.cv.elementAt(i).courseName+", " +g.cv.elementAt(i).instructor+", "+g.cv.elementAt(i).place);
		}
	}
	
	//�׷���������
	void editGroup (Main m) {
		gv.elementAt(tempGruopIndex).GroupName=m.courseName;
		gv.elementAt(tempGruopIndex).isVoid=m.isVoid;
		gv.elementAt(tempGruopIndex).creedit=m.creedit;
		gv.elementAt(tempGruopIndex).kind=m.kind;
		
		for(int i=0;i<gv.elementAt(tempGruopIndex).cv.size();i++) {
			gv.elementAt(tempGruopIndex).cv.elementAt(i).courseName=m.courseName;
			gv.elementAt(tempGruopIndex).cv.elementAt(i).creedit=m.creedit;
			gv.elementAt(tempGruopIndex).cv.elementAt(i).kind=m.kind;
		}
		writeGV();
	}
	
	//������������
	void editCourse (Main m) {
		if(!gv.isEmpty()) {
		gv.elementAt(tempGruopIndex).cv.elementAt(tempCourseIndex).instructor=m.instructorName;
		gv.elementAt(tempGruopIndex).cv.elementAt(tempCourseIndex).place=m.placeName;
		
		gv.elementAt(tempGruopIndex).cv.elementAt(tempCourseIndex).attendChecking=m.attendChecking;
		gv.elementAt(tempGruopIndex).cv.elementAt(tempCourseIndex).difficulty=m.difficulty;
		gv.elementAt(tempGruopIndex).cv.elementAt(tempCourseIndex).grading=m.grading;
		gv.elementAt(tempGruopIndex).cv.elementAt(tempCourseIndex).effort=m.effort;
		gv.elementAt(tempGruopIndex).cv.elementAt(tempCourseIndex).doneit=m.doneit;
		gv.elementAt(tempGruopIndex).cv.elementAt(tempCourseIndex).priority= (m.attendChecking+m.difficulty+m.grading+m.effort+m.doneit)/5;
	
		gv.elementAt(tempGruopIndex).cv.elementAt(tempCourseIndex).tv=getTime();
		
		writeGV();
		}
		else System.out.println("������ �������� �ʽ��ϴ�.");
	}
	
	//�׷����
	void eraseGroup () {
		if(!gv.isEmpty()) {
			if(gv.elementAt(tempGruopIndex).isSelected) {
				int index=selectedGV.indexOf(gv.elementAt(tempGruopIndex));
				selectedGV.remove(index);
				writeGVSelection();
			}
			
			gv.remove(tempGruopIndex);
			writeGV();
		}
		else System.out.println("������ �������� �ʽ��ϴ�.");
	}
	
	//�������
	void eraseCourse () {
		gv.elementAt(tempGruopIndex).cv.remove(tempCourseIndex);
		if(gv.elementAt(tempGruopIndex).cv.isEmpty()) eraseGroup();
		writeGV();
	}
	void eraseCourse (int a) {
		gv.elementAt(tempGruopIndex).cv.remove(tempCourseIndex);
		if(gv.elementAt(tempGruopIndex).cv.isEmpty()) eraseGroup();
		writeGV();
	}
	
	//���ð����߰�
	void addSelection () {
		if((selectedGV.indexOf(gv.elementAt(tempGruopIndex)))==-1) {
			selectedGV.add(gv.elementAt(tempGruopIndex));
			gv.elementAt(tempGruopIndex).isSelected=true;
			writeGVSelection();	
		}
		else System.out.println("�̹� ������ �����Դϴ�.");
	}
	
	//���ð��� ����
	void eraseSelection (int index) {
		selectedGV.elementAt(index).isSelected=false;
		selectedGV.remove(index);
		writeGVSelection();
	}
	
	//���ð����̸� ���
	void printSelction() {
		if(!selectedGV.isEmpty()) {
			for(int i=0;i<selectedGV.size();i++) {
				System.out.println((i)+":"+selectedGV.elementAt(i).GroupName);
			
			}
		}
		else {System.out.println("������ �������� �ʽ��ϴ�.");}
	}
	
	//GV ����
	void writeGV(){
		try {
			File f = new File("save.txt");
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(gv);
			oos.flush();
			}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//GV �б�
	void readGV() throws IOException {
		File f = new File("save.txt");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
		try{
			gv= (Vector <Group>)ois.readObject();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//selectedGV ����
		void writeGVSelection(){
			try {
				File f = new File("saveSelection.txt");
				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(selectedGV);
				oos.flush();
				}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//selectedGV �б�
		void readGVSelection() throws IOException {
			File f = new File("saveSelection.txt");
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			try{
				selectedGV= (Vector <Group>)ois.readObject();
			}
			catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

