package Study_01_00_object;

class C3 {
    int v = 10;
 
    void m() {
        int v = 20;
        System.out.println(this.v);//this�� �ν��Ͻ� ��ü�� ��Ī. 
                  //->this.v�� �޼ҵ� ���� v�� �ƴ϶�, �ν��Ͻ� ����v�� ��
        
        System.out.println(v);
        //�̰� �޼ҵ� ���� ���� v�̴�.
    }
}


public class Study_01_06 {

	public static void main(String[] args) {
		C3 c1 = new C3();
        c1.m();
	}

}
