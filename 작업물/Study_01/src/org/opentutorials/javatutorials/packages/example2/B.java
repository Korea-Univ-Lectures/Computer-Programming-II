package org.opentutorials.javatutorials.packages.example2;

//��Ű���� import�ؾ� �۵���!
import org.opentutorials.javatutorials.packages.example1.A;
//A��� Ŭ������ ������

import org.opentutorials.javatutorials.packages.example1.*;
//*�� ��� ���� ����

public class B {

	public static void main(String[] args) {
		A a1= new A();
		a1.print();
		}

}

/*
 * src:�ҽ� ����, bin:���̳ʸ� ���� (�����ϵ� Ŭ��������)
 * javac src/org/opentutorials/javatutorials/packages/example1/*.java -d bin
 * ->������ �� class������ bin�� ����!
 * 
 * ���� ��Ű���� �Ҽӵ� Ŭ������ �̸��� ���� ���?
 * org.opentutorials.javatutorials.packages.example2.B b = new org.opentutorials.javatutorials.packages.example2.B();
 * ��� ����� �Ѵ�.
 * */
 