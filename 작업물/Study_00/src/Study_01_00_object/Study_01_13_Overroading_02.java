package Study_01_00_object;

class parents {
	void A(){System.out.println("void A()");}
	void A(int para){System.out.println("void A(int para)");}
}

//overloading은 상속을 통해서도 쓸 수 있다.
//만약에 매개변수를 다양하게 그 숫자를 늘리고 싶으면 배열을 사용하는게 더 편하다.

class child extends parents {
	int []array;
	
	void setOprands(int []array){this.array=array;}
	void A(String para1){System.out.println("void A(String para1)");}
	void A(String para1, String para2){System.out.println("void A(String para1, String para2)");}
	
	void sum (){
		int total =0;
		for(int value: this.array){total+=value;}
		System.out.println(total);
	}
	
	void avg (){
		double total =0;
		for(int value: this.array){total+=value;}
		System.out.println(total/this.array.length);
	}
}

public class Study_01_13_Overroading_02 {

	public static void main(String[] args) {
		child c1 =new child();
		c1.A();
		c1.A("I love you");
		c1.A(23);
		c1.A("I love you", "I hate you");
		
		int []a={1,2,3,4};
		c1.setOprands(a);		
		c1.sum();
		c1.avg();
	}
}