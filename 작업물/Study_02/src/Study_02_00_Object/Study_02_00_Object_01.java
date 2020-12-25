package Study_02_00_Object;

//clone�� �Ȱ��� ��ü�� ������ �ִ� �޼ҵ��̴�.

class Student2 implements Cloneable{
	String name;
	Student2 (String name){this.name=name;}
	
	//�����Ϸ��� ���������� ��ü��� ���� JVM���� �˷� �־���Ѵ�.
	 //�̰ɾ��ϸ� s1.clone();�� ������ ����
	//->cloneable�̶�� interface�� �������ָ� �ȴ�
	//interface cloneable�� ����ִ�. ���� �ܼ��� ������ �ִ� �� ���̴�.
	
	//�� ������ clone()�� ���������ڰ� protected�̴�
	//�׷��� ����� ������Ѵ� 
	
	/** public Object clone(){
	 * 	return super.clone();
	 * }
	 * @throws CloneNotSupportedException 
	 */
	
	//�ٵ� �̰� �� ������ �ִ�
	//clone�޼ҵ忡�� ���ܰ� �ִ�! throw���� ó���� ������Ѵ�!
	//���⼭�� ����ó�� å���� �ٸ� ����ڿ��� �ѱ���!
	
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}

public class Study_02_00_Object_01 {

	public static void main(String[] args) {
		Student2 s1 = new Student2("Egoing");//�̰� �Ȱ��� �����ϰ� �ʹ�.
		
		try {
			Student2 s2= (Student2)s1.clone();
			System.out.println(s1);
			System.out.println(s2);
			
			System.out.println(s1.name);
			System.out.println(s2.name);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

}
