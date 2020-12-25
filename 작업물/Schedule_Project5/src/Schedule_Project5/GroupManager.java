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
	Vector <Group> gv =new Vector(); //총 강의 그룹
	Vector <Group> selectedGV = new Vector();//선택한 강의그룹
	
	int tempGruopIndex;//현재 선택 강의 그룹
	int tempCourseIndex;//현재 선택 강의 그룹
	
	GroupManager () {
		try {readGV();}
		catch(Exception e) {e.printStackTrace();}
		
		try {readGVSelection();}
		catch(Exception e) {e.printStackTrace();}
	}
	
	//강의 그룹 추가
	void addCourseGroup(Main m) {
		Group g1= new Group(m.courseName, m.isVoid, m.creedit, m.kind);
		gv.add(g1);
		writeGV();
	}
	
	//강의 추가
	void addCourse(Main m) {
		if(!gv.isEmpty()) 
		{course c1 = new course(gv.elementAt(tempGruopIndex).GroupName, m.instructorName, m.placeName, m.attendChecking, m.grading, m.difficulty, m.effort, m.doneit, gv.elementAt(tempGruopIndex).creedit,getTime(), gv.elementAt(tempGruopIndex).kind, gv.elementAt(tempGruopIndex).isVoid );
		
		gv.elementAt(tempGruopIndex).cv.add(c1);
		writeGV();
		}
		else System.out.println("과목이 존재하지 않습니다.");
	}
	
	//현재 선택 그룹  변경
	void setTempGroup (int i) {
		if(i<gv.size())
			tempGruopIndex=i;
		else
			System.out.println("그러한 인덱스는 존재하지 않습니다.");
	}
	
	//현재 선택 과목 변경
	void setTempCourse (int i) {
		if(i<gv.elementAt(tempGruopIndex).cv.size())
			tempCourseIndex=i;
		else
			System.out.println("그러한 인덱스는 존재하지 않습니다.");
	}
	
	//시간 백터 생성 매소드
	Vector<time> getTime() {
		Vector <time> tv =new Vector();
		Main m = new Main();
		int inputInt;
		boolean isLoop=true;
		
		int day;
		int period;
		
		while(true) {
			System.out.println("시간을 입력하시겠습니까?(0:yes, 1:no)");
			isLoop=m.getBoolean(m.sc);
			if(!isLoop) break;
			
			System.out.println("---<요일입력>---");
			System.out.println("1: 월요일            ");
			System.out.println("2: 화요일            ");
			System.out.println("3: 수요일            ");
			System.out.println("4: 목요일            ");
			System.out.println("5: 금요일            ");
			System.out.println("--------------");
			day=m.getInt(m.sc, 1, 5)-1;
			
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
			period = m.getInt(m.sc, 1, 8)-1;
			
			time t = new time(day,period);
			tv.add(t);
		}
		return tv;
	}

	//과목정보출력
	void printCourse(course c) {
		System.out.print("강의명:"+c.courseName);
		System.out.print(", 교수자:"+c.instructor);
		System.out.print(", 강의장소:"+c.place);
		
		if(!c.isVoid) System.out.print(", 필수과목");
		else System.out.print(", 여유과목");
		
		switch(c.kind) {
		case 0: System.out.print(", 전공필수");
		case 1: System.out.print(", 전공선택");
		case 2: System.out.print(", 교양");
		}
		
		System.out.print(", 학점:"+c.creedit);
		
		System.out.print(", 선호도:"+c.priority);
		System.out.print(", 출석체크:"+c.attendChecking);
		System.out.print(", 성적:"+c.grading);
		System.out.print(", 난이도:"+c.difficulty);
		System.out.print(", 학습량:"+c.effort);
		System.out.print(", 성취감:"+c.doneit);
		if(!c.tv.isEmpty()) 
			for(int i=0;i<c.tv.size();i++) {
				System.out.print(", ");
				switch(c.tv.elementAt(i).day) {
				case 0:System.out.print("월(");
				break;
				case 1:System.out.print("화(");
				break;
				case 2:System.out.print("수(");
				break;
				case 3:System.out.print("목(");
				break;
				case 4:System.out.print("금(");
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
	
	//그룹 정보출력
	void printGroup(Group g) {
		System.out.println();
		printCourse(g.cv.elementAt(0));
		for(int i=1;i<g.cv.size();i++) {
			System.out.print("ㄴ(동질과목)");
			printCourse(g.cv.elementAt(i));
		}
	}

	//그룹벡터 정보출력
	void printGV (Vector <Group> GV) {
		if(!GV.isEmpty()) {
			for(int i=0;i<GV.size();i++) {
				printGroup(GV.elementAt(i));
			}
		}
		else {System.out.println("과목이 존재하지 않습니다.");}
	}
	
	//그룹이름 출력
	void printGVName() {
		if(!gv.isEmpty()) {
			for(int i=0;i<gv.size();i++) {
				System.out.println((i)+":"+gv.elementAt(i).GroupName);
			}
		}
		else {System.out.println("과목이 존재하지 않습니다.");}
	}
	
	//동질과목이름 출력
	void printG(Group g) {
		for(int i=0;i<g.cv.size();i++) {
			System.out.println((i)+":"+g.cv.elementAt(i).courseName+", " +g.cv.elementAt(i).instructor+", "+g.cv.elementAt(i).place);
		}
	}
	
	//그룹정보변경
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
	
	//과목정보변경
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
		else System.out.println("과목이 존재하지 않습니다.");
	}
	
	//그룹삭제
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
		else System.out.println("과목이 존재하지 않습니다.");
	}
	
	//과목삭제
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
	
	//선택과목추가
	void addSelection () {
		if((selectedGV.indexOf(gv.elementAt(tempGruopIndex)))==-1) {
			selectedGV.add(gv.elementAt(tempGruopIndex));
			gv.elementAt(tempGruopIndex).isSelected=true;
			writeGVSelection();	
		}
		else System.out.println("이미 선택한 과목입니다.");
	}
	
	//선택과목 삭제
	void eraseSelection (int index) {
		selectedGV.elementAt(index).isSelected=false;
		selectedGV.remove(index);
		writeGVSelection();
	}
	
	//선택과목이름 출력
	void printSelction() {
		if(!selectedGV.isEmpty()) {
			for(int i=0;i<selectedGV.size();i++) {
				System.out.println((i)+":"+selectedGV.elementAt(i).GroupName);
			
			}
		}
		else {System.out.println("과목이 존재하지 않습니다.");}
	}
	
	//GV 쓰기
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
	
	//GV 읽기
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
	
	//selectedGV 쓰기
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
		
		//selectedGV 읽기
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

