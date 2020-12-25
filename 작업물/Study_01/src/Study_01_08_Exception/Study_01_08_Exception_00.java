package Study_01_08_Exception;

class exceptionclass {
	 public void divide(int left,int right){
	        try {
	            System.out.print("계산결과는 ");
	            System.out.print(left/right);
	            System.out.print(" 입니다.");
	            //try는 오류가예상 되는 코드를 의미
	        } catch(Exception e){//변수의 데이터 타입이 Exception이다
	            //catch는 오류가 나면 실행할 코드를 의미
	        	System.out.println("\n\ne.getMessage()\n"+e.getMessage());
	        	//getMessage();은 오류에 대한 아주 기본적인 내용을 출력하는 메소드
	        	
	            System.out.println("\n\ne.toString()\n"+e.toString());
	            //e.toString();은 좀더 자세한 예외 정보를 제공
	            
	            System.out.println("\n\ne.printStackTrace()");
	            e.printStackTrace();
	            
	            //e.printStackTrace();은 리턴 값이 없는 메소드 가장 자세한 예외 정보를 제공

	        }
	    }
}

public class Study_01_08_Exception_00 {

	public static void main(String[] args) {
		exceptionclass c = new exceptionclass();
		c.divide(10, 0);
	}

}
