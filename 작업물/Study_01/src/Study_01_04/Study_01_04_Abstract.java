package Study_01_04;
abstract class A{
    public abstract int b();
    //추상 메소드! 추상메소드는 본체가 없다. signature만 있다
    
    public void d(){
        System.out.println("world");
    //추상클래스 내부에 추상 메소드가 아닌 메소드가 존재할 수 있다!
    }
}
class B extends A{//abstract class는 반드시 상속되어야 한다.
    public int b(){return 1;}
    //abstract 메소드는 반드시 overriding되어야한다.
}

public class Study_01_04_Abstract {
	 public static void main(String[] args) {
	        B obj = new B();
	        System.out.println(obj.b());
	    }
}
