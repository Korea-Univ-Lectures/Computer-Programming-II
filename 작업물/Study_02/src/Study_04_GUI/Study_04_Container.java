package Study_04_GUI;

import javax.swing.JFrame;

public class Study_04_Container extends JFrame {
	
	JFrame frame1 = new JFrame("ㅎㅎㅎ"); //container
	JFrame button1 = new JFrame("버튼"); //component
	
	public void newFrame(){

		frame1.add(button1);//add component to container
		frame1.setSize(300, 600);//사이즈 결정
		frame1.setVisible(true);//프래임 보이기
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//swing에게만 있는 x버튼을 눌러서 종료
	}
	
	public static void main(String[] args) {
		Study_04_Container frame9 =new Study_04_Container();
		frame9.newFrame();
	}

}
