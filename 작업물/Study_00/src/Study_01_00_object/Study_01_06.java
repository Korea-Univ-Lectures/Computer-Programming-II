package Study_01_00_object;

class C3 {
    int v = 10;
 
    void m() {
        int v = 20;
        System.out.println(this.v);//this는 인스턴스 자체를 지칭. 
                  //->this.v는 메소드 안의 v가 아니라, 인스턴스 변수v가 됨
        
        System.out.println(v);
        //이건 메소드 안의 변수 v이다.
    }
}


public class Study_01_06 {

	public static void main(String[] args) {
		C3 c1 = new C3();
        c1.m();
	}

}
