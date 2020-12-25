package Study_01_07_Polymorphism;

interface father{}
interface mother{}
interface programmer{
    public void coding();
}
interface believer{}

class Steve implements father, programmer, believer{
    public void coding(){
        System.out.println("fast");
    }
}
class Rachel implements mother, programmer{
    public void coding(){
        System.out.println("elegance");
    }
}


public class Study_01_07_04_Metaphor {
	public static void main (String []arg){
		
		programmer employee1 = new Steve();
	    programmer employee2 = new Rachel();
	     
	    employee1.coding();
	    employee2.coding();
	}
}
