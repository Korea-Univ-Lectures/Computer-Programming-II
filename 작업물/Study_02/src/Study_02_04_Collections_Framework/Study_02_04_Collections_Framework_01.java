package Study_02_04_Collections_Framework;

import java.util.ArrayList;
import java.util.HashSet;
 
import java.util.Iterator;

public class Study_02_04_Collections_Framework_01 {

	public static void main(String[] args) {
		 HashSet<Integer> A = new HashSet<Integer>();
	        A.add(1);
	        A.add(2);
	        A.add(3);
	         
	        HashSet<Integer> B = new HashSet<Integer>();
	        B.add(3);
	        B.add(4);
	        B.add(5);
	         
	        HashSet<Integer> C = new HashSet<Integer>();
	        C.add(1);
	        C.add(2);

	        
	        
	        System.out.println(A.containsAll(B)); // false
	        System.out.println(A.containsAll(C)); // true
	        //A.containsAll(B)부분집합?
	        
	        //A.addAll(B); 합집합
	        //A.retainAll(B); 교집합
	        //A.removeAll(B);차집합 A-B
	         
	        Iterator hi = A.iterator();
	        while(hi.hasNext()){
	            System.out.println(hi.next());
	        }


	}

}
