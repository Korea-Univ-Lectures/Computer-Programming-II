//FlowLayout: 컴포넌트들이 왼쪽에서 오른쪽으로 추가되는 형태!

/*
 * BorderLayout:
 * 기본적으로 컴포넌트들이 틀 형태로 존재
 * BorderLayout에 컴포넌트를 추가할 때는
 * c1.add(컴포넌트, 위치)   
 * 위치는 BorderLayout.NORTH 등이다.
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
		//제목 설정
		super("FlowLayout!");
		
		//레이아웃 설정
		this.setLayout(new FlowLayout());
		
		//버튼 추가
		this.add(b1);
		this.add(b2);
		this.add(b3);
		
		//프레임 크기 지정
		this.setSize(300, 400);
		
		//프레임 보이도록 설정
		this.setVisible(true);
		
		//X버튼 눌렀을 때 닫히도록 설정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
class BorderLayoutExam
{
	//컴포넌트 생성
	JFrame jFrame = new JFrame("BorderLayout!");
	JButton btn1 = new JButton("1번버튼");
	JButton btn2 = new JButton("2번버튼");
	JButton btn3 = new JButton("3번버튼");
	JButton btn4 = new JButton("4번버튼");
	JButton btn5 = new JButton("5번버튼");
	
	public BorderLayoutExam()
	{
		//컴포넌트를 넣을 컨테이너 구하기
		Container container = jFrame.getContentPane();
		
		//컴포넌트를 컨테이너에 추가
		container.add(btn1, BorderLayout.NORTH);
		container.add(btn2, BorderLayout.EAST);
		container.add(btn3, BorderLayout.WEST);
		container.add(btn4, BorderLayout.SOUTH);
		container.add(btn5, BorderLayout.CENTER);
		
		//프레임 크기 지정
		jFrame.setSize(300, 300);
		
		//프레임 보이기 설정
		jFrame.setVisible(true);
		
		//종료 버튼 설정
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class GridLayoutExam
{
	JFrame jFrame = new JFrame("이번엔 GridLayout이다!!");
	JButton [] btn = new JButton [6]; //6개 생성
	
	public GridLayoutExam()
    {
		//GridLayout 적용
		jFrame.setLayout(new GridLayout(3,2));
		/* (3,2)는 행(row)이 3개, 열(column)이2개이다. 
		 * (2,0)은 2개의 행을 설정하고 열을 무한대로 넣겠다는 의미!
		 * (0,4)은 4개의 열을 설정하고 행을 무한대로 넣겠다는 의미! 
		 * */
		
		//컨테이너 가져오기
		Container container = jFrame.getContentPane();
		
		//컴포넌트 생성 및 추가하기
		for(int i=0; i < btn.length; i++)
		{
			btn[i] = new JButton(i+"버튼");
			container.add(btn[i]);
		}
		
		//프레임 크기 지정하기
		jFrame.setSize(300,300);
		
		//프레임 보이기
		jFrame.setVisible(true);
		
		//종료버튼에 대한 설정
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
    }
}

class CompositeLayout
{
	JFrame jFrame = new JFrame("CompositeLayout!"); //전체적인 프레임
	JPanel jpanel = new JPanel(); //상단에 들어갈 패널
	JButton [] btn = new JButton[4]; //버튼

	public CompositeLayout()
	{
		//버튼 생성
		for(int i=0; i<btn.length; i++)
		{
			btn[i] = new JButton(i+"번째 버튼");
		}

		//패널에 버튼 추가
		jpanel.add(btn[0]);
		jpanel.add(btn[1]);
		
		jFrame.add(jpanel, "North"); //패널 추가
		jFrame.add(btn[2], "West");
		jFrame.add(btn[3], "Center");
		
		//사이즈 및 보여짐 여부 설정
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
