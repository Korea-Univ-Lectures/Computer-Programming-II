package Schedule_Project4;

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
	
	//강의 그룹 추가
	void addCourseGroup(String name, boolean b) {
		Group g1= new Group(name, b);
		gv.add(g1);
	}
	
	//강의 추가
	void addCourse(String ins, String pla,int pri, int sta, int cre) {
		course c1 = new course(gv.elementAt(tempGruopIndex).GroupName, ins, pla, pri, sta,cre,getTime());
		gv.elementAt(tempGruopIndex).cv.add(c1);
	}
	
	//현재 선택 그룹 설정, 변경
	void setTempGroup (int i) {
		if(i<gv.size())
			tempGruopIndex=i;
		else
			System.out.println("그러한 인덱스는 존재하지 않습니다.");
	}
	
	//시간 백터 생성 매소드
	Vector<time> getTime() {
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
	
	//그룹존재여부판단
	boolean isGroupThere() {
		if(gv.size()==0) return false;
		else return true;
	}
	
	//과목 존재여부판단
	boolean isCourseThere(Vector <course> cv) {
		if(cv.size()==0) return false;
		else return true;
	}

	//GV 쓰기
		void writeGV() throws IOException {
			File f = new File("save.txt");
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(gv);
			oos.flush();
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
}
