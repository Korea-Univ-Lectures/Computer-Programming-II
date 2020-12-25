package Schedule_Project4;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import javax.swing.event.*;

import java.util.Vector;

class GroupEditGUI {
mainGUI m = new mainGUI();
	
JTextField nameText= new JTextField(15);

//�ʼ�����üũ��
JCheckBox isNotVoid = new JCheckBox("�ʼ����񿩺�", true);
JButton db =doneB();

	//�̸� ����
	JPanel NameLine () {
		JPanel p =new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		p.add(m.exitB());
		p.add(new JLabel("���� ����"));
		
		p.setBackground(Color.WHITE);
		LineBorder li1 =new LineBorder(Color.BLACK);
		p.setBorder(li1);
		p.setVisible(true);
		
		return p;
	}

	//���� �̸� �ۼ�
	JPanel GroupNameP(JTextField nameText) {
		JPanel p =new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
		p.add(new JLabel("������ ")); 
		p.add(nameText); 
		
		return p;
	}

	
	//�Ϸ��ư
	JButton doneB() {
		final JButton b = new JButton("�Ϸ�");
		b.setSize(60,30);
		return b;
	}

	//���Ǳ׷�����
	JPanel GroupEditGUIScreen() {
		JPanel baseP = new JPanel();
		baseP.setLayout(new BorderLayout());
		baseP.add(NameLine(),BorderLayout.NORTH);
		
		JPanel mainP = new JPanel();
		mainP.setLayout(new BoxLayout(mainP, BoxLayout.Y_AXIS));
		
		JPanel name =GroupNameP(nameText);
		mainP.add(name);
		
		JCheckBox isV =isNotVoid;
		mainP.add(isV);
		
		JButton b =doneB();
		mainP.add(db);
		
		baseP.add(mainP, BorderLayout.CENTER);
		
		return baseP;
	}
}
