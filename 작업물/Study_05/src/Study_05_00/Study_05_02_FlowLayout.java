//FlowLayout: ������Ʈ���� ���ʿ��� ���������� �߰��Ǵ� ����!

/*
 * BorderLayout:
 * �⺻������ ������Ʈ���� Ʋ ���·� ����
 * BorderLayout�� ������Ʈ�� �߰��� ����
 * c1.add(������Ʈ, ��ġ)   
 * ��ġ�� BorderLayout.NORTH ���̴�.
 * */
package Study_05_00;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

class ButtonThree extends JFrame
{
	JButton b1 = new JButton("1");
	JButton b2 = new JButton("2");
	JButton b3 = new JButton("3");
	
	public ButtonThree()
	{
		//���� ����
		super("FlowLayout!");
		
		//���̾ƿ� ����
		this.setLayout(new FlowLayout());
		
		//��ư �߰�
		this.add(b1);
		this.add(b2);
		this.add(b3);
		
		//������ ũ�� ����
		this.setSize(300, 400);
		
		//������ ���̵��� ����
		this.setVisible(true);
		
		//X��ư ������ �� �������� ����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
class BorderLayoutExam
{
	//������Ʈ ����
	JFrame jFrame = new JFrame("BorderLayout!");
	JButton btn1 = new JButton("1����ư");
	JButton btn2 = new JButton("2����ư");
	JButton btn3 = new JButton("3����ư");
	JButton btn4 = new JButton("4����ư");
	JButton btn5 = new JButton("5����ư");
	
	public BorderLayoutExam()
	{
		//������Ʈ�� ���� �����̳� ���ϱ�
		Container container = jFrame.getContentPane();
		
		//������Ʈ�� �����̳ʿ� �߰�
		container.add(btn1, BorderLayout.NORTH);
		container.add(btn2, BorderLayout.EAST);
		container.add(btn3, BorderLayout.WEST);
		container.add(btn4, BorderLayout.SOUTH);
		container.add(btn5, BorderLayout.CENTER);
		
		//������ ũ�� ����
		jFrame.setSize(300, 300);
		
		//������ ���̱� ����
		jFrame.setVisible(true);
		
		//���� ��ư ����
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class GridLayoutExam
{
	JFrame jFrame = new JFrame("�̹��� GridLayout�̴�!!");
	JButton [] btn = new JButton [6]; //6�� ����
	
	public GridLayoutExam()
    {
		//GridLayout ����
		jFrame.setLayout(new GridLayout(3,2));
		/* (3,2)�� ��(row)�� 3��, ��(column)��2���̴�. 
		 * (2,0)�� 2���� ���� �����ϰ� ���� ���Ѵ�� �ְڴٴ� �ǹ�!
		 * (0,4)�� 4���� ���� �����ϰ� ���� ���Ѵ�� �ְڴٴ� �ǹ�! 
		 * */
		
		//�����̳� ��������
		Container container = jFrame.getContentPane();
		
		//������Ʈ ���� �� �߰��ϱ�
		for(int i=0; i < btn.length; i++)
		{
			btn[i] = new JButton(i+"��ư");
			container.add(btn[i]);
		}
		
		//������ ũ�� �����ϱ�
		jFrame.setSize(300,300);
		
		//������ ���̱�
		jFrame.setVisible(true);
		
		//�����ư�� ���� ����
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
    }
}

class CompositeLayout
{
	JFrame jFrame = new JFrame("CompositeLayout!"); //��ü���� ������
	JPanel jpanel = new JPanel(); //��ܿ� �� �г�
	JButton [] btn = new JButton[4]; //��ư

	public CompositeLayout()
	{
		//��ư ����
		for(int i=0; i<btn.length; i++)
		{
			btn[i] = new JButton(i+"��° ��ư");
		}

		//�гο� ��ư �߰�
		jpanel.add(btn[0]);
		jpanel.add(btn[1]);
		
		jFrame.add(jpanel, "North"); //�г� �߰�
		jFrame.add(btn[2], "West");
		jFrame.add(btn[3], "Center");
		
		//������ �� ������ ���� ����
		jFrame.setSize(300,300);
		jFrame.setVisible(true);
		
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

public class Study_05_02_FlowLayout {
	public static void main(String[] args) {
		ButtonThree f1= new ButtonThree();
		BorderLayoutExam f2= new BorderLayoutExam();
		GridLayoutExam f3 =new GridLayoutExam();
		CompositeLayout f4 = new CompositeLayout();
	}
}
