package Study_02_04_Collections_Framework;

import java.util.*;

//������ �˾ƺ���!
//���⼭�� Comparable�̶�� Interface�� �������

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
        //Collections��� �ϴ� Ŭ������ �ִ�. 
        //�� Ŭ������ ������ ���� �پ��� �żҵ带 �����Ѵ�.
        //�� �żҵ���� ���� static �̱⶧���� �żҵ带 ���� ���� �ʿ䵵 ����.
        
        //sort()�żҵ�� computers��� List�� ������ ������ ���ݴϴ�.
        // public static <T extends Comparable<? super T>> void sort(List<T> list)
        //�̰��� sort()�żҵ��� signature�̴�.
        //List<T>�� �Ű������� �޴´�.��, List�� �������ش�.
        //List<T>���� Generic T�� T extends Comparable�̴�.
        //��, ������ ����� �Ǵ� Ŭ������ Comparable�� implements�ϰ� �־���Ѵ�.
        
        //�������̽�  Comparable��  public int compareTo(Object o)
        //�� ������ �������̵� �� ���� �䱸�ϰ� �ִ�.
        //������ 0�� �����Ѵ�.
        //������ ��ü�� �񱳴�󺸴� ���� �� ũ�ٸ� ����� ��ȯ,
        //������ ��ü�� �񱳴�󺸴� ���� �� �۴ٸ� ������ ��ȯ
        
        //EX) a.compareTo(b)���� a�� b���� ũ�� ����� ��ȯ.
        
        System.out.println("\nafter");
        i = computers.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }


	}

}
