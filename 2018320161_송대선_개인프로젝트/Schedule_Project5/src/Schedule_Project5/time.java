package Schedule_Project5;

import java.io.Serializable;

class time implements Cloneable, Serializable{
	
	//�ð�ǥ�� �ð��� ����!
	int day;//����
	int period;//�� ��������?
	
	time (int day, int period){
		this.day = day;
		this.period=period;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}