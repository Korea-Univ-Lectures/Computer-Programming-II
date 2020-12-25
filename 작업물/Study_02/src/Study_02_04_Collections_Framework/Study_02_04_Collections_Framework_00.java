package Study_02_04_Collections_Framework;

import java.util.ArrayList;
//ArrayList�� ����ϱ� ���ؼ� �̸� import�� �־���Ѵ�.
import java.util.HashSet;

import java.util.Iterator;

public class Study_02_04_Collections_Framework_00 {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		//ArrayList�� ũ�� ������ ���� �迭 ���� ���̴�. (�迭�� �ƴϴ�.)
		//Collections Framework�� generic�� ����Ѵ�.
		//���� add()�޼ҵ�� ������ ���� ������ �𸣱⿡ Object�� �⺻ �Ű������� �����µ�,
		//�׷��� ����ȯ�� �ʿ��ϴ�.
		//������ generic�� ����ϸ� Ÿ���� �ϳ��� ����������, ����ȯ�� �ʿ��������.
		
		al.add("one");//add�� ArrayList�� �ϳ��� �߰��ϴ� �żҵ��̴�.
		al.add("two");
		al.add("three");
		
		for(int i=0; i<al.size(); i++){
		    String val = al.get(i);//al[0]�� ������ ������� �ʴ´�.
		    //get�̶�� �żҵ带 ����� ���̴�.
		   
		    System.out.println(val);
		}
		System.out.println(al.size());
		//ũ�⸦ ���Ҷ�, al.length�� ������� �ʰ�, .size()��� �żҵ带 ����Ѵ�.
		
		
		
		
		
		ArrayList<String> al2 = new ArrayList<String>();
        al.add("one");
        al.add("two");
        al.add("two");
        al.add("three");
        al.add("three");
        al.add("five");
        //List�� �ִ´�� �������
        System.out.println("array");
        Iterator ai = al2.iterator();
        while(ai.hasNext()){
            System.out.println(ai.next());
        }
         
        HashSet<String> hs = new HashSet<String>();
        //set�� �������� ����!
        hs.add("one");
        hs.add("two");
        hs.add("two");
        hs.add("three");
        hs.add("three");
        hs.add("five");
        //Set�� �ߺ��Ǵ� ���� ���� ����
        Iterator hi = hs.iterator();
        System.out.println("\nhashset");
        while(hi.hasNext()){
            System.out.println(hi.next());
        }

	}

}
