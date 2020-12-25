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
	Vector <Group> gv =new Vector(); //�� ���� �׷�
	Vector <Group> selectedGV = new Vector();//������ ���Ǳ׷�
	int tempGruopIndex;//���� ���� ���� �׷�
	int tempCourseIndex;//���� ���� ���� �׷�
	
	//���� �׷� �߰�
	void addCourseGroup(String name, boolean b) {
		Group g1= new Group(name, b);
		gv.add(g1);
	}
	
	//���� �߰�
	void addCourse(String ins, String pla,int pri, int sta, int cre) {
		course c1 = new course(gv.elementAt(tempGruopIndex).GroupName, ins, pla, pri, sta,cre,getTime());
		gv.elementAt(tempGruopIndex).cv.add(c1);
	}
	
	//���� ���� �׷� ����, ����
	void setTempGroup (int i) {
		if(i<gv.size())
			tempGruopIndex=i;
		else
			System.out.println("�׷��� �ε����� �������� �ʽ��ϴ�.");
	}
	
	//�ð� ���� ���� �żҵ�
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
	
	//�׷����翩���Ǵ�
	boolean isGroupThere() {
		if(gv.size()==0) return false;
		else return true;
	}
	
	//���� ���翩���Ǵ�
	boolean isCourseThere(Vector <course> cv) {
		if(cv.size()==0) return false;
		else return true;
	}

	//GV ����
		void writeGV() throws IOException {
			File f = new File("save.txt");
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(gv);
			oos.flush();
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
}
