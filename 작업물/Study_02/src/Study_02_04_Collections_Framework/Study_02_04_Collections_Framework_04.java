package Study_02_04_Collections_Framework;

import java.util.*;

//정렬을 알아보자!
//여기서는 Comparable이라는 Interface를 사용하자

class Computer implements Comparable{
    int serial;
    String owner;
    Computer(int serial, String owner){
        this.serial = serial;
        this.owner = owner;
    }
    
    public int compareTo(Object o) {
        return this.serial - ((Computer)o).serial;
    }
    
    public String toString(){
        return serial+" "+owner;
    }
}
 
public class Study_02_04_Collections_Framework_04 {

	public static void main(String[] args) {
		List<Computer> computers = new ArrayList<Computer>();
        computers.add(new Computer(500, "egoing"));
        computers.add(new Computer(200, "leezche"));
        computers.add(new Computer(3233, "graphittie"));
        
        Iterator i = computers.iterator();
        System.out.println("before");
        while(i.hasNext()){
            System.out.println(i.next());
        }
        
        Collections.sort(computers);
        //Collections라고 하는 클래스가 있다. 
        //이 클래스는 정렬을 위한 다양한 매소드를 제공한다.
        //이 매소드들은 전부 static 이기때문에 매소드를 따로 만들 필요도 없다.
        
        //sort()매소드는 computers라는 List를 받으면 정렬을 해줍니다.
        // public static <T extends Comparable<? super T>> void sort(List<T> list)
        //이것이 sort()매소드의 signature이다.
        //List<T>를 매개변수로 받는다.즉, List만 정렬해준다.
        //List<T>에서 Generic T는 T extends Comparable이다.
        //즉, 정렬의 대상이 되는 클래스는 Comparable을 implements하고 있어야한다.
        
        //인터페이스  Comparable는  public int compareTo(Object o)
        //를 강제로 오버라이딩 할 것을 요구하고 있다.
        //같으면 0을 리턴한다.
        //현재의 객체가 비교대상보다 값이 더 크다면 양수를 반환,
        //현재의 객체가 비교대상보다 값이 더 작다면 음수를 반환
        
        //EX) a.compareTo(b)에서 a가 b보다 크면 양수를 반환.
        
        System.out.println("\nafter");
        i = computers.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }


	}

}
