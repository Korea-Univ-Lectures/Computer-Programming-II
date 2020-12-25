package class_11_16;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class class_11_16_03 extends JFrame implements ActionListener{
	
	JTextField T1, T2;
	int j = 0;
	int oldnum, temp, result;
	String tempFun, tempInput="";
	boolean finish = false;
	JButton Button[] = new JButton[16];
	

	public void actionPerformed(ActionEvent e) {
		String input = e.getActionCommand();
		
		//입력 판단, 기능 실행
		if(input.equals("+")) {
			oldnum = temp;
			tempFun = "+";
			tempInput = "";
			T2.setText("더하기");
		}
		
		else if(input.equals("X")){
			oldnum = temp;
			tempFun = "X";
			tempInput ="";
			T2.setText("곱하기");
		}
		
		else if(input.equals("/")) {
			oldnum = temp;
			tempFun = "/";
			tempInput = "";
			T2.setText("나누기");
		}
		
		else if(input.equals("C")) {
			tempInput = "";
			temp = 0;
			oldnum = 0;
			T1.setText("");
			T2.setText("초기화");
		}
		
		else if(input.equals("=")) {
			if(tempFun.equals("+")) {
				result = oldnum + temp;
				T1.setText(String.valueOf(result));
				finish = true;
			}
			
			else if(tempFun.equals("-")) {
				result = oldnum - temp;
				T1.setText(String.valueOf(result));
				finish = true;
			}
			
			else if(tempFun.equals("X")) {
				result = oldnum*temp;
				T1.setText(String.valueOf(result));
				finish = true;
			}
			
			else if(tempFun.equals("/")) {
				result = oldnum/temp;
				T1.setText(String.valueOf(result));
				finish = true;
			}
		}
		
		else {
			if(finish) {
				T1.setText("0");
				finish = false;
				temp = 0;
				oldnum = 0;
				tempInput = "";
			}
			tempInput += e.getActionCommand();
			System.out.println(tempInput);
			T1.setText(tempInput);
			temp = Integer.parseInt(tempInput);
		}
	}
	
	public class_11_16_03() {
		//생성자, UI 모양 결정
		super("계산기");
		super.setResizable(true);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 400);
		T1 = new JTextField("", 15);
		T2 = new JTextField("", 5);
		T2.setEnabled(false);
		JPanel P1 = new JPanel();
		JPanel P2 = new JPanel();
		P1.add(T1);
		P2.add(T2);
		P2.setLayout(new GridLayout(4,4,10,10));
		String btnValue[] = {"1","2","3","X","4","5","6","/","7","8","9","+","C","0","=","-"};
		//버튼에 값 대입
		for(int i=0; i<=15; i++) {
			Button[i] = new JButton(btnValue[i]);
			P2.add(Button[i]);
			Button[i].addActionListener(this);
			Button[i].setBackground(new Color(175,175,175));
			Button[i].setFont(new Font("굴림",Font.BOLD,18));
			Button[i].setForeground(Color.WHITE);
			if(i==3||i==7||i==11||i==15) {
				Button[i].setBackground(new Color(153,0,225));
				Button[i].setFont(new Font("굴림",Font.BOLD,18));
				Button[i].setForeground(Color.WHITE);
			}
			else if(i==12||i==14) {
				Button[i].setBackground(new Color(225,166,0));
				Button[i].setFont(new Font("굴림",Font.BOLD,18));
				Button[i].setForeground(Color.DARK_GRAY);
			}
		}
		
		add(P1, BorderLayout.NORTH);
		add(P2, BorderLayout.CENTER);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new class_11_16_03();
	}
}