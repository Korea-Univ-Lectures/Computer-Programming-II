package Schedule_Project4;

class time implements Cloneable{//�ð�ǥ�� �ð��� ����!
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
