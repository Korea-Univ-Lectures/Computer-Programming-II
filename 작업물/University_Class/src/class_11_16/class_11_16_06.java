package class_11_16;

import java.util.*;

class Member{
	public String name;
	public int age;
	
	public Member(String name, int age) {
		this.name=name;
		this.age=age;
	}
	/*
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member member = (Member) obj;
		}
	}*/
}




public class class_11_16_06 {

	public static void main(String[] args) {
		HashSet<Member> Memberlist = new HashSet();
		
		Memberlist.add(new Member("송대선", 19));
		Memberlist.add(new Member("정채훈", 20));
		
		System.out.println(Memberlist.size()); 
	}

}
