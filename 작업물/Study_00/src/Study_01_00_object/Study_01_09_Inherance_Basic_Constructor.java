package Study_01_00_object;

public class Study_01_09_Inherance_Basic_Constructor {
	public Study_01_09_Inherance_Basic_Constructor(int param1){};//
	//이것은 생성자이지만, 매개변수가 있음으로, 기본생성자가 아니다! 
	//어떠한 생성자도 없는 클래스에게는 자동으로 기본생성자를 만들어준다!
	//기본생성자는 클래스와 이름이 같고, 매개변수가 없고, 내용도 비어있다.
	//개발자가 인위적으로 생성자를 만들면, 자바는 기본생성을 자동으로 만들어주지 않는다.
	
	public Study_01_09_Inherance_Basic_Constructor(){}
	//기본생성자를 인위적으로 만듦!
	
	public static void main(String[] args) {
		Study_01_09_Inherance_Basic_Constructor c =new Study_01_09_Inherance_Basic_Constructor();
		//메인 함수가 포함된 클래스를 인스턴스화 시키는 것이 가능!
		//이것은 매개변수가 없는 기본 생성자를 이용하여 인스턴스를 만들고 있다!-> 에러발생
		//인위적으로 기본생성자를 만들어 줘야한다!
	}

}
