package Study_01_03;

class Access {
	public String x(){
		return "public String x()";
	}
	
	private String y(){
		return "private String y()";
	}//private ���������ڴ� ���� Ŭ���� �ȿ����� ȣ�Ⱑ���ϴ�
	
	public String z(){
		return y();
	}
	
}

public class Study_01_03_Access_Modifier {

	public static void main(String[] args) {
		Access a1 =new Access();
		a1.x();
		//a1.y();
		//�� �޼ҵ� y()�� ���ص��� �ʴ´�. �ֳ��ϸ� ���������ڰ� private�̱� �����̴�
		a1.z();
		//�̰� �����ϴ�. �ֳ��ϸ� �޼ҵ� x�� �޼ҵ� z�� ���� Ŭ������ �Ҽ��̱� �����̴�.

	}

}
/* ����鿡 ���ؼ��� private, (default), protected, public
 * Ŭ������ ���ؼ��� (default), public
 * 
 * !!!!!�߿�!
 * public Ŭ������ ���Ե� �Ҽ��ڵ�� 
 * public Ŭ������ Ŭ���� ��� �ҽ��ڵ��� ���ϸ��� ���ƾ� �Ѵ�.
 * ��, �ϳ��� �ҽ��ڵ� (java����)�� ���ؼ���
 * �ϳ��� public class���� ������ �� �ִٴ� ���̴�.
 * */
