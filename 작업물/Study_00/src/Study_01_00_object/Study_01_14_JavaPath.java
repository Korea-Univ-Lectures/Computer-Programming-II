package Study_01_00_object;

public class Study_01_14_JavaPath {
	public static void main(String[] args){
		/*
		 * javac Study_01_14_JavaPath.java
		 * -> Study_01_14_JavaPath.java라는 자바 파일을 컴파일!
		 * -> Study_01_14_JavaPath안에 있었던 모든 클래스들이 클래스 파일로 만들어진다!
		 * 
		 * 
		 * class Item2 {
	public void print(){
		System.out.println("Hello world");
	}
}

class ClasspathDemo2 {
	public static void main (String[] args){
		Item2 i1 = new Item2();
		i1.print();
	}
}
		 * 라는 ClasspathDemo2.java 파일을 만들고, 컴파일하고, 
		 * java ClasspathDemo2로 클래스 ClasspathDemo2를 실행하면,
		 * 그 클래스의 매인 메소드가 호출된다
		 * 만일 Item2라는 클래스가 lib이라는 다른 폴더에 저장되어 있으면 에러발생!
		 * java -classpath ".;lib" ClasspathDemo2
		 * ".;lib"이 의미하는 바는 다음과 같다.
		 * .은 그저 현재 디렉토리를 의미,
		 * ;는 여기에 필요한 클래스가 없으면...
		 * lib이라는 디렉토리로 가봐라
		 * 
		 * java -classpath "." ClasspathDemo2
		 * java ClasspathDemo2
		 * 위 둘은 같은 명령어다
		 * 
		 * classpath는 환경변수중에 하나이다
		 * 환경변수는 운영체제에 설정하는 변수이다.
		 * 
		 * */
		
	}
}
