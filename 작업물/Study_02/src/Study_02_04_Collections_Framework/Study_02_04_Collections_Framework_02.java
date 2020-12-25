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
		//iterator()라는 매소드를 사용해서  Iterator 데이터 타입을 return함.
		//hi는 A랑 똑같은 집합을 가지고 있음
		
		while(hi.hasNext()){//hasNext()라는 매소드는 hi안에 원소가 있는지 없는지 판단하여,
			//있으면 true, 없으면 false를 반환하는 메소드이다.
			
			System.out.println(hi.next());
			//next()라는 매소드는 hi안에 있는 원소하나를 반환한 후, 그 원소를 삭제해 버림
			
		}
	}

}
