package Study_00;

public class Study_00_03_Blooean {

	public static void main(String[] args) {
		System.out.println(1==2);
		System.out.println(1==1);
		
		System.out.println();
		
		System.out.println(1!=2);
		System.out.println(1!=1);
		
		System.out.println();
		
		System.out.println("One"=="one");
		System.out.println();
		//==은 두개의 데이터 타입이 동일한 객체인지 알아내기 위해 사용하는 연산자이다
		String a="Hello";
		String b= new String("Hello");
		
		System.out.println(a==b);
		System.out.println(a.equals(b));
		//문자열을 비교할 때에는 ==이 아닌 ".equals"를 사용한다.
		
	}

}
