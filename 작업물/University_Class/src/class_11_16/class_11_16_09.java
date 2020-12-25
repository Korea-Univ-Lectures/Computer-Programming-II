package class_11_16;

import java.util.*;

public class class_11_16_09 {

	public static void main(String[] args) {
		HashMap<String, String> d= new HashMap();
		
		d.put("baby", "아기");
		d.put("baby", "아기");
		d.put("baby", "아기");
		
		Set<String> keys = d.keySet();
		Iterator <String> it = keys.iterator();
		while(it.hasNext()) {
			String key =it.next();
			String value = d.get(key);
		}
		
		Scanner sc = new Scanner(System.in);
		
		
		
	}

}
