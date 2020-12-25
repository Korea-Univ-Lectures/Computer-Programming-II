package Study_02_04_Collections_Framework;

import java.util.ArrayList;
//ArrayList를 사용하기 위해서 미리 import해 주어야한다.
import java.util.HashSet;

import java.util.Iterator;

public class Study_02_04_Collections_Framework_00 {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		//ArrayList는 크기 제한이 없는 배열 같은 것이다. (배열은 아니다.)
		//Collections Framework는 generic을 사용한다.
		//원래 add()메소드는 값으로 뭐가 들어올지 모르기에 Object를 기본 매개변수로 가지는데,
		//그래서 형변환이 필요하다.
		//하지만 generic을 사용하면 타입이 하나로 결정됨으로, 형변환이 필요없어진다.
		
		al.add("one");//add는 ArrayList에 하나더 추가하는 매소드이다.
		al.add("two");
		al.add("three");
		
		for(int i=0; i<al.size(); i++){
		    String val = al.get(i);//al[0]의 형식은 사용하지 않는다.
		    //get이라는 매소드를 사용할 뿐이다.
		   
		    System.out.println(val);
		}
		System.out.println(al.size());
		//크기를 구할때, al.length를 사용하지 않고, .size()라는 매소드를 사용한다.
		
		
		
		
		
		ArrayList<String> al2 = new ArrayList<String>();
        al.add("one");
        al.add("two");
        al.add("two");
        al.add("three");
        al.add("three");
        al.add("five");
        //List는 넣는대로 계속저장
        System.out.println("array");
        Iterator ai = al2.iterator();
        while(ai.hasNext()){
            System.out.println(ai.next());
        }
         
        HashSet<String> hs = new HashSet<String>();
        //set은 순서없이 저장!
        hs.add("one");
        hs.add("two");
        hs.add("two");
        hs.add("three");
        hs.add("three");
        hs.add("five");
        //Set은 중복되는 것은 저장 ㄴㄴ
        Iterator hi = hs.iterator();
        System.out.println("\nhashset");
        while(hi.hasNext()){
            System.out.println(hi.next());
        }

	}

}
