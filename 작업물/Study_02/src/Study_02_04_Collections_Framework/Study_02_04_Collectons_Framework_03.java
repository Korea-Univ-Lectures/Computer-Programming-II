package Study_02_04_Collections_Framework;

//map에는 key와 value가 있다.
//key를 주면, value를 준다.
//key는 중복 불허용, value는 중복허용
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Study_02_04_Collectons_Framework_03 {

	public static void main(String[] args) {
		 HashMap<String, Integer> a = new HashMap<String, Integer>();
	        a.put("one", 1);//앞이 key, 뒤가 value
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
        //entrySet():set 데이터타입에 객체가 return됨
        
        for (Map.Entry<String, Integer> entry : entries) {
        	//Entry라는 인터페이스를 구현하고 있는 Map이라는 인터페이스를 구현하는
        	//Set이 생김
        	//Map.Entry는 getKey(), getValue()라는 매소드를 가지고 있음
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
	static void iteratorUsingIterator(HashMap map){
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> i = entries.iterator();
        //set을 다시 Iterator로 만듦
        while(i.hasNext()){
            Map.Entry<String, Integer> entry = i.next();
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }



}
