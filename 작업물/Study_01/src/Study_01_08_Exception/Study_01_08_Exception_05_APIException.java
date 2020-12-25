package Study_01_08_Exception;
/*예외를 만들기 전에 해야 할 것은 자신의 예외를 checked로 할 것인가?
 * unchecked로 할 것인가를 정해야 한다. 그 기준은 모호한 문제다. 
 * 하지만 기준이 없는 것도 아니다.
 * 
 * API 쪽에서 예외를 던졌을 때
 * API 사용자 쪽에서 예외 상황을 복구 할 수 있다면 checked 예외를 사용한다. 
 * 
 * checked 예외는
 * 사용자에게 문제를 해결할 기회를 주는 것이면서
 * 예외처리를 강제하는 것이다.
 * 
 * 하지만 checked 예외를 너무 자주 사용하면
 * API 사용자를 몹시 힘들게 할 수 있기 때문에
 * 적정선을 찾는 것이 중요하다.
 *  
 *  
 * 사용자가 API의 사용방법을 어겨서 발생하는 문제거나 예외 상황이 이미 발생한 시점에서
 * 그냥 프로그램을 종료하는 것이 덜 위험 할 때 unchecked를 사용한다. 
 * 
 * 기존의 ArithmeticException을 직접 만든 Exception으로 교체해보자.
 * */
class DivideException extends RuntimeException {
    DivideException(){
        super();
    }
    DivideException(String message){
        super(message);
    }
}

class Calculator2{
    int left, right;
    public void setOprands(int left, int right){        
        this.left = left;
        this.right = right;
    }
    public void divide(){
        if(this.right == 0){
            throw new DivideException("0으로 나누는 것은 허용되지 않습니다.");
        }
        System.out.print(this.left/this.right);
    }
}


public class Study_01_08_Exception_05_APIException {
	
	public static void main(String[] args) {
		Calculator2 c1 = new Calculator2();
	    c1.setOprands(10, 0);
	    c1.divide();
	    }
}


