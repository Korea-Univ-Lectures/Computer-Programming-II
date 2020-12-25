package Study_02_04_Collections_Framework;

//map���� key�� value�� �ִ�.
//key�� �ָ�, value�� �ش�.
//key�� �ߺ� �����, value�� �ߺ����
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Study_02_04_Collectons_Framework_03 {

	public static void main(String[] args) {
		 HashMap<String, Integer> a = new HashMap<String, Integer>();
	        a.put("one", 1);//���� key, �ڰ� value
	        a.put("two", 2);
	        a.put("three", 3);
	        a.put("four", 4);
	        System.out.println(a.get("one"));
	        System.out.println(a.get("two"));
	        System.out.println(a.get("three"));
	        
	        System.out.println(a);
	        iteratorUsingForEach(a);
	        
	        System.out.println(a);
	        iteratorUsingIterator(a);
	}
	
	static void iteratorUsingForEach(HashMap map){
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        //entrySet():set ������Ÿ�Կ� ��ü�� return��
        
        for (Map.Entry<String, Integer> entry : entries) {
        	//Entry��� �������̽��� �����ϰ� �ִ� Map�̶�� �������̽��� �����ϴ�
        	//Set�� ����
        	//Map.Entry�� getKey(), getValue()��� �żҵ带 ������ ����
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
	static void iteratorUsingIterator(HashMap map){
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> i = entries.iterator();
        //set�� �ٽ� Iterator�� ����
        while(i.hasNext()){
            Map.Entry<String, Integer> entry = i.next();
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }



}
