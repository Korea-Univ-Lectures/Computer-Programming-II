//swing:�ڹٿ��� ����->����� ��� �Ȱ���.
package Study_05_00;

import javax.swing.JFrame;
import javax.swing.JButton;

class newFrame{
	JFrame frame1 = new JFrame("������"); //container
	JButton button1 = new JButton("��ư"); //component
	
	public void creatFrame(){

		frame1.add(button1);//add component to container
		frame1.setSize(300, 600);//������ ����
		frame1.setVisible(true);//������ ���̱�
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//swing���Ը� �ִ� x��ư�� ������ ����
	}
}

public class Study_05_00_Container {
	
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		newFrame f1 = new newFrame();
		f1.creatFrame();
	}

}
