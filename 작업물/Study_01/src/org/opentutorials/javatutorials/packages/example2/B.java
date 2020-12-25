package org.opentutorials.javatutorials.packages.example2;

//패키지를 import해야 작동됨!
import org.opentutorials.javatutorials.packages.example1.A;
//A라는 클래스를 가져옴

import org.opentutorials.javatutorials.packages.example1.*;
//*은 모든 것을 뜻함

public class B {

	public static void main(String[] args) {
		A a1= new A();
		a1.print();
		}

}

/*
 * src:소스 폴더, bin:바이너리 폴더 (컴파일된 클래스파일)
 * javac src/org/opentutorials/javatutorials/packages/example1/*.java -d bin
 * ->컴파일 된 class파일을 bin에 저장!
 * 
 * 만일 패키지에 소속된 클래스의 이름이 같을 경우?
 * org.opentutorials.javatutorials.packages.example2.B b = new org.opentutorials.javatutorials.packages.example2.B();
 * 라고 해줘야 한다.
 * */
 