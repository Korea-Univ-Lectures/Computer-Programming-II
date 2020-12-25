package Study_01_00_object;
/*
 �ν��Ͻ� �޼ҵ�: static�� �Ⱥ��� �޼ҵ�->�ν��Ͻ� �޼ҵ� ���ο��� Ŭ���� ����, Ŭ���� �޼ҵ带 ȣ�Ⱑ��
 Ŭ���� �޼ҵ�: static�� ���� �޼ҵ�->
�ν��Ͻ� ���� -> Non-Static Field
Ŭ���� ���� -> Static Field
*/
class C1{
    static int static_variable = 1;
    int instance_variable = 2;
    static void static_static(){
        System.out.println(static_variable);
    }
    static void static_instance(){
        // Ŭ���� �޼ҵ忡���� �ν��Ͻ� ������ ���� �� �� ����. 
        //System.out.println(instance_variable);
    }
    void instance_static(){
        // �ν��Ͻ� �޼ҵ忡���� Ŭ���� ������ ���� �� �� �ִ�.
        System.out.println(static_variable);
    }
    void instance_instance(){        
        System.out.println(instance_variable);
    }
}

public class Study_01_04 {

	public static void main(String[] args) {
		 C1 c = new C1();
	        // �ν��Ͻ��� �̿��ؼ� ���� �޼ҵ忡 ���� -> ����
	        // �ν��Ͻ� �޼ҵ尡 ���� ������ ���� -> ����
	        c.static_static();
	        // �ν��Ͻ��� �̿��ؼ� ���� �޼ҵ忡 ���� -> ����
	        // ���� �޼ҵ尡 �ν��Ͻ� ������ ���� -> ����
	        c.static_instance();
	        // �ν��Ͻ��� �̿��ؼ� �ν��Ͻ� �޼ҵ忡 ���� -> ����
	        // �ν��Ͻ� �޼ҵ尡 Ŭ���� ������ ���� -> ����
	        c.instance_static();
	        // �ν��Ͻ��� �̿��ؼ� �ν��Ͻ� �޼ҵ忡 ���� -> ���� 
	        // �ν��Ͻ� �޼ҵ尡 �ν��Ͻ� ������ ���� -> ����
	        c.instance_instance();
	        // Ŭ������ �̿��ؼ� Ŭ���� �޼ҵ忡 ���� -> ����
	        // Ŭ���� �޼ҵ尡 Ŭ���� ������ ���� -> ����
	        C1.static_static();
	        // Ŭ������ �̿��ؼ� Ŭ���� �޼ҵ忡 ���� -> ����
	        // Ŭ���� �޼ҵ尡 �ν��Ͻ� ������ ���� -> ����
	        C1.static_instance();
	        // Ŭ������ �̿��ؼ� �ν��Ͻ� �޼ҵ忡 ���� -> ����
	        //C1.instance_static();
	        // Ŭ������ �̿��ؼ� �ν��Ͻ� �޼ҵ忡 ���� -> ����
	        //C1.instance_instance();
	}

}
