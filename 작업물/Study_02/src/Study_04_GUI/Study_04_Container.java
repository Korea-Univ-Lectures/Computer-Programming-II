package Study_04_GUI;

import javax.swing.JFrame;

public class Study_04_Container extends JFrame {
	
	JFrame frame1 = new JFrame("������"); //container
	JFrame button1 = new JFrame("��ư"); //component
	
	public void newFrame(){

		frame1.add(button1);//add component to container
		frame1.setSize(300, 600);//������ ����
		frame1.setVisible(true);//������ ���̱�
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//swing���Ը� �ִ� x��ư�� ������ ����
	}
	
	public static void main(String[] args) {
		Study_04_Container frame9 =new Study_04_Container();
		frame9.newFrame();
	}

}
