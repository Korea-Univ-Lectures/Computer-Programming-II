package Schedule_Project5;

import java.io.Serializable;
import java.util.Vector;

class Group implements Serializable{
	String GroupName; //���� �̸�
	int creedit;
	int kind;
	Vector<course> cv = new Vector(); //�׷� ���� ���� ��ϵ�
	boolean isVoid = false; //���� ����
	boolean isSelected =false;//���ñ׷������� ����
	
	/*
	 * 1: �����ʼ�
	 * 2: ��������
	 * 3: �������
	 * 
	 * */
	
	Group(String name, boolean b, int cre, int ki){
		GroupName=name;
		isVoid= b;
		creedit =cre;
		kind = ki;
	}

	int getNum() {
		if (isVoid)
			return cv.size()+1;
		else
			return cv.size();
	}
	
	boolean isCalculateable() {
		if(cv.size()==0)
			return false;
		else
			return true;
	}
}