package Schedule_Project5;

import java.io.Serializable;
import java.util.Vector;

class Group implements Serializable{
	String GroupName; //강의 이름
	int creedit;
	int kind;
	Vector<course> cv = new Vector(); //그룹 내의 강의 목록들
	boolean isVoid = false; //연산 유무
	boolean isSelected =false;//선택그룹인지의 여부
	
	/*
	 * 1: 전공필수
	 * 2: 전공선택
	 * 3: 교양과목
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