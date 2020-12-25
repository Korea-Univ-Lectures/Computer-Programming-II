package class_11_16;

import java.util.*;

public class class_11_16_08 {

	public static void main(String[] args) {
		HashSet <Integer> h= new HashSet();
		
		while(h.size()!=6){
			h.add((Integer)(int)(Math.random()*45)+1);
		}
		
		Iterator <Integer> it = h.iterator();
		while(it.hasNext()) {
			System.out.print(+it.next()+"\t");
		}
	}

}
