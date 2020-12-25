//swing:자바에서 제공->모양이 모두 똑같다.
package Study_05_00;

import javax.swing.JFrame;
import javax.swing.JButton;

class newFrame{
	JFrame frame1 = new JFrame("ㅎㅎㅎ"); //container
	JButton button1 = new JButton("버튼"); //component
	
	public void creatFrame(){

		frame1.add(button1);//add component to container
		frame1.setSize(300, 600);//사이즈 결정
		frame1.setVisible(true);//프래임 보이기
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//swing에게만 있는 x버튼을 눌러서 종료
	}
}

public class Study_05_00_Container {
	
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		newFrame f1 = new newFrame();
		f1.creatFrame();
	}

}
