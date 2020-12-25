package Study_01_00_object;

class Calculator3{
	public static void sum(int left, int right){//멤버 메소드이다!
        System.out.println(left+right);
    }
     
    public static void avg(int left, int right){
        System.out.println((left+right)/2);
    }
}

public class Study_01_03 {

	public static void main(String[] args) {
		Calculator3.sum(10, 20);
        Calculator3.avg(10, 20);
         
        Calculator3.sum(20, 40);
        Calculator3.avg(20, 40);
        //인스턴스를 생성할 필요가 없음

	}

}


