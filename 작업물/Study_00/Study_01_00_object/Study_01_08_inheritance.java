package Study_01_00_object;

class Calculator {
    int left, right;
 
    public void setOprands(int left, int right) {
        this.left = left;
        this.right = right;
    }
 
    public void sum() {
        System.out.println(this.left + this.right);
    }
 
    public void avg() {
        System.out.println((this.left + this.right) / 2);
    }
}

class SubCalculator extends Calculator {
    public void sub() {
        System.out.println(this.left - this.right);
    }
}


public class Study_01_08_inheritance {

	public static void main(String[] args) {
		SubsCalculator c1 = new SubsCalculator();
        c1.setOprands(10, 20);
        c1.sum();
        c1.avg();
        c1.sub();
	}
}
