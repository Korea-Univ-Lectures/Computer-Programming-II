package Study_00;

public class Study_00_06_for_While {
	
	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			if(i==5) continue;//밑에 남은 코드를 실행하지 않고 반복문(for문)이 있는 줄로 이동한다.
			if(i==7) break;//반복문을 나간다
			System.out.println(i);
		}

	}

}
