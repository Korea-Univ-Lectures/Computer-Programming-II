package Study_01_04;
abstract class A{
    public abstract int b();
    //�߻� �޼ҵ�! �߻�޼ҵ�� ��ü�� ����. signature�� �ִ�
    
    public void d(){
        System.out.println("world");
    //�߻�Ŭ���� ���ο� �߻� �޼ҵ尡 �ƴ� �޼ҵ尡 ������ �� �ִ�!
    }
}
class B extends A{//abstract class�� �ݵ�� ��ӵǾ�� �Ѵ�.
    public int b(){return 1;}
    //abstract �޼ҵ�� �ݵ�� overriding�Ǿ���Ѵ�.
}

public class Study_01_04_Abstract {
	 public static void main(String[] args) {
	        B obj = new B();
	        System.out.println(obj.b());
	    }
}
