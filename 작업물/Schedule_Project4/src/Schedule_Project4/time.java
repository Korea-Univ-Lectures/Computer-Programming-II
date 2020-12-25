package Schedule_Project4;

class time implements Cloneable{//시간표의 시간대 설정!
	int day;//요일
	int period;//몇 교시인지?
	
	time (int day, int period){
		this.day = day;
		this.period=period;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
