package New_example_00;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class _00 extends JFrame {

	JTextField Text1, Text2;
	int Prev, temp, result;
	String tempAO, tempInput = "";
	boolean finish = false;
	JButton Button[] = new JButton[16];
	
	class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String input = e.getActionCommand();

			// 입력 판단, 기능 실행
			if (input.equals("+")) {
				Prev = temp;
				tempAO = "+";
				tempInput = "";
				//1
			}

			else if (input.equals("-")) {
				Prev = temp;
				tempAO = "-";
				tempInput = "";
				//1
			}

			else if (input.equals("X")) {
				Prev = temp;
				tempAO = "X";
				tempInput = "";
				//1
			}

			else if (input.equals("/")) {
				Prev = temp;
				tempAO = "/";
				tempInput = "";
				//1
			}

			else if (input.equals("C")) {
				tempInput = "";
				temp = 0;
				Prev = 0;
				Text1.setText("");
				Text2.setText("초기화");
			}

			else if (input.equals("=")) {
				if (tempAO.equals("+")) {
					result = Prev + temp;
					//2
					finish = true;
				}

				else if (tempAO.equals("-")) {
					result = Prev - temp;
					//2
					finish = true;
				}

				else if (tempAO.equals("X")) {
					result = Prev * temp;
					//2
					finish = true;
				}

				else if (tempAO.equals("/")) {
					result = Prev / temp;
					//2
					finish = true;
				}
			}

		else {
			if (finish) {
				Text1.setText("0");
				finish = false;
				temp = 0;
				Prev = 0;
				tempInput = "";
			}
			System.out.println(tempInput);
			Text1.setText(tempInput);
			temp = Integer.parseInt(tempInput);
			}
		}
	}

	public _00() {
		// 생성자, UI 모양 결정
		setTitle("Calculator");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 400);
		
		Text1 = new JTextField("", 15);
		Text2 = new JTextField("", 5);
		Text2.setEnabled(false);
		
		JPanel P1 = new JPanel();
		JPanel P2 = new JPanel();
		
		P1.add(Text1);
		P1.add(Text2);
		
		P2.setLayout(new GridLayout(4, 4, 10, 10));
		String ButtonValue[] = { "1", "2", "3", "X", "4", "5", "6", "/", "7", "8", "9", "+", "C", "0", "=", "-" };
		// 버튼에 값 대입
		for (int i = 0; i <= 15; i++) {
			Button[i] = new JButton(ButtonValue[i]);
			P2.add(Button[i]);
			
			Button[i].addActionListener(new MyListener());

		}

		add(P1, BorderLayout.NORTH);
		add(P2, BorderLayout.CENTER);
		setVisible(true);
	}

	public static void main(String[] args) {
		new _00();
	}
}
