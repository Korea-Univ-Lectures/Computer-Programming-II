package Schedule_Project4;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import javax.swing.event.*;

import java.util.Vector;

class GroupInsertGUI {
	mainGUI m = new mainGUI();
	GroupEditGUI geg = new GroupEditGUI();
	CourseEditGUI ceg = new CourseEditGUI();
	
	JTextField nameText = new JTextField(15);
	JCheckBox isNotVoid =new JCheckBox("�ʼ����񿩺�", true);
	
	String arrnum [] = {"0","1","2","3","4","5","6","7","8","9","10"};
	JTextField instructorText = new JTextField(15);//������ �ؽ�Ʈ �ʵ�
	JTextField placeText =new JTextField(15);//��� �ؽ�Ʈ �ʵ�
	JComboBox<String> cb = new JComboBox<String>(arrnum); //����
	JComboBox<String> pb = new JComboBox<String>(arrnum); //��ȣ��
	JComboBox<String> sb = new JComboBox<String>(arrnum); //������
	JButton db =doneB();
	//�̸� ����
	JPanel NameLine () {
		JPanel p =new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		p.add(m.exitB());
		p.add(new JLabel("���� �߰�"));
		
		p.setBackground(Color.WHITE);
		LineBorder li1 =new LineBorder(Color.BLACK);
		p.setBorder(li1);
		p.setVisible(true);
		
		return p;
	}
	
	//�Ϸ��ư
	JButton doneB() {
			final JButton b = new JButton("�Ϸ�");
			b.setSize(60,30);
			return b;
		}
	
	JPanel GroupInsertGUIScreen () {
		JPanel baseP = new JPanel();
		baseP.setLayout(new BorderLayout());
		baseP.add(NameLine(),BorderLayout.NORTH);
		
		JPanel mainP = new JPanel();
		mainP.setLayout(new BoxLayout(mainP, BoxLayout.Y_AXIS));
		
		JPanel name =geg.GroupNameP(nameText);
		mainP.add(name);
		
		JPanel inst =ceg.InstructorP(instructorText);
		mainP.add(inst);
		
		JPanel pla =ceg.PlaceP(placeText);
		mainP.add(pla);
		
		JPanel subP = new JPanel();
		subP.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		
		JPanel cp =ceg.CreeditP(cb);
		subP.add(cp);
		
		JPanel pp =ceg.PriP(pb);
		subP.add(pp);
		
		JPanel sp =ceg.StaP(sb);
		subP.add(sp);
		
		mainP.add(subP);
		
		JCheckBox isV =isNotVoid;
		mainP.add(isV);
		
		mainP.add(db);
		
		baseP.add(mainP, BorderLayout.CENTER);
		
		return baseP;
	}
}
