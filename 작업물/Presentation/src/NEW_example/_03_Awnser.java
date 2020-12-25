package NEW_example;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class _03_Awnser extends JFrame{

	JPanel p1 =new JPanel();
	JPanel p2 =new JPanel();
	JTextField t1 =new JTextField("", 15);
	JTextField t2 =new JTextField("", 5);
	JButton Button[] = new JButton[16];
	
	int Prev, temp, result;
	String tempAO, tempInput = "";
	boolean finish = false;
	
	class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String input = e.getActionCommand();
			if (input.equals("+")) {
				Prev = temp;
				tempAO = "+";
				tempInput = "";
				t2.setText("더하기");
			}

			else if (input.equals("-")) {
				Prev = temp;
				tempAO = "-";
				tempInput = "";
				t2.setText("빼기");
			}

			else if (input.equals("X")) {
				Prev = temp;
				tempAO = "X";
				tempInput = "";
				t2.setText("곱하기");
			}

			else if (input.equals("/")) {
				Prev = temp;
				tempAO = "/";
				tempInput = "";
				t2.setText("나누기");
			}

			else if (input.equals("C")) {
				tempInput = "";
				temp = 0;
				Prev = 0;
				t1.setText("");
				t2.setText("초기화");
			}

			else if (input.equals("=")) {
				if (tempAO.equals("+")) {
					result = Prev + temp;
					t1.setText(String.valueOf(result));
					finish = true;
				}

				else if (tempAO.equals("-")) {
					result = Prev - temp;
					t1.setText(String.valueOf(result));
					finish = true;
				}

				else if (tempAO.equals("X")) {
					result = Prev * temp;
					t1.setText(String.valueOf(result));
					finish = true;
				}

				else if (tempAO.equals("/")) {
					result = Prev / temp;
					t1.setText(String.valueOf(result));
					finish = true;
				}
			}

			else {
				if (finish) {
					t1.setText("0");
					finish = false;
					temp = 0;
					Prev = 0;
					tempInput = "";
				}
				tempInput += e.getActionCommand();
				System.out.println(tempInput);
				t1.setText(tempInput);
				temp = Integer.parseInt(tempInput);
			}
		}
	}
	
	_03_Awnser(){
		setTitle("Calculator");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 400);
		
		t2.setEnabled(false); 
		
		p1.add(t1);
		p1.add(t2);
		
		p2.setLayout(new GridLayout(4, 4, 10, 10));
		
		String ButtonValue[] = { "1", "2", "3", "X", "4", "5", "6", "/", "7", "8", "9", "+", "C", "0", "=", "-" };
		
		for (int i = 0; i <= 15; i++) {
			Button[i] = new JButton(ButtonValue[i]);
			p2.add(Button[i]);
			
			Button[i].addActionListener(new MyListener());
		}
		
		setLayout(new BorderLayout());
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new _03_Awnser();
	}

}
