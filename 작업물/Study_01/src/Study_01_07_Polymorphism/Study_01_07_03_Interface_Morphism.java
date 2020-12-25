package Study_01_07_Polymorphism;

interface I2{
    public String A();
}
interface I3{
    public String B();
}

class D implements I2, I3{
    public String A(){
        return "A";
    }
    public String B(){
        return "B";
    }
}


public class Study_01_07_03_Interface_Morphism {

	public static void main(String[] args) {
		D obj = new D();
        I2 objI2 = new D();
        I3 objI3 = new D();
         
        obj.A();
        obj.B();
         
        objI2.A();
        //objI2.B();
         
        //objI3.A();
        objI3.B();
        /* �ν��Ͻ� objI2�� ������ Ÿ���� I2�� �Ѵٴ� ���� 
         * �ν��Ͻ��� �ܺο��� ������ �� �ִ� ���� ��ġ�� 
         * �ν��Ͻ� I2�� �ɹ��� �����Ѵٴ� �ǹ̰� �ȴ�. 
         * �ν��Ͻ� I2�� I3�� ���ؼ� 
         * �ϳ��� Ŭ������ �پ��� ���¸� ��� �Ǵ� ���̴�.*/

	}

}
