package Study_02_04_Collections_Framework;

import java.util.HashSet;
import java.util.Iterator;

public class Study_02_04_Collections_Framework_02 {

	public static void main(String[] args) {
		HashSet<Integer> A = new HashSet<Integer>();
		A.add(1);
		A.add(2);
		A.add(3);
		
		Iterator hi = A.iterator();
		//iterator()��� �żҵ带 ����ؼ�  Iterator ������ Ÿ���� return��.
		//hi�� A�� �Ȱ��� ������ ������ ����
		
		while(hi.hasNext()){//hasNext()��� �żҵ�� hi�ȿ� ���Ұ� �ִ��� ������ �Ǵ��Ͽ�,
			//������ true, ������ false�� ��ȯ�ϴ� �޼ҵ��̴�.
			
			System.out.println(hi.next());
			//next()��� �żҵ�� hi�ȿ� �ִ� �����ϳ��� ��ȯ�� ��, �� ���Ҹ� ������ ����
			
		}
	}

}
