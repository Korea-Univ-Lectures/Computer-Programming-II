package Schedule_Project4;

import java.awt.*;
import javax.swing.*;

import javax.swing.border.LineBorder;

class CourseEditGUI {
	mainGUI m = new mainGUI();
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
			p.add(new JLabel("���ϰ����߰�"));
			
			p.setBackground(Color.WHITE);
			LineBorder li1 =new LineBorder(Color.BLACK);
			p.setBorder(li1);
			p.setVisible(true);
			
			return p;
		}
		
	//���� �̸� �ۼ�
	JPanel InstructorP(JTextField instructorText) {
		JPanel p =new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
		p.add(instructorText); 
			
		return p;
	}

	//���� ��� �ۼ�
	JPanel PlaceP(JTextField placeText) {
		JPanel p =new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
		p.add(new JLabel("������� ")); 
		p.add(placeText); 
			
		return p;
	}

	//��������
	JPanel CreeditP(JComboBox<String> cb) {
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
		p.add(new JLabel("���� "));
		p.add(cb);
		
		return p;
	}

	//��ȣ������
	JPanel PriP(JComboBox<String> pb) {
			JPanel p = new JPanel();
			p.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
			p.add(new JLabel("��ȣ�� "));
			
			p.add(pb);
			
			return p;
		}

	//������ ����
	JPanel StaP(JComboBox<String> sb) {
	JPanel p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
		p.add(new JLabel("������ "));
			
		p.add(sb);
			
		return p;
	}	

	//�Ϸ��ư
	JButton doneB() {
			final JButton b = new JButton("�Ϸ�");
			b.setSize(60,30);
			return b;
		}

	//��������
	JPanel GroupEditGUIScreen() {
			JPanel baseP = new JPanel();
			baseP.setLayout(new BorderLayout());
			baseP.add(NameLine(),BorderLayout.NORTH);
			
			JPanel mainP = new JPanel();
			mainP.setLayout(new BoxLayout(mainP, BoxLayout.Y_AXIS));
			
			JPanel inst =InstructorP(instructorText);
			mainP.add(inst);
			
			JPanel pla =PlaceP(placeText);
			mainP.add(pla);
			
			JPanel subP = new JPanel();
			subP.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
			
			JPanel cp =CreeditP(cb);
			subP.add(cp);
			
			JPanel pp =PriP(pb);
			subP.add(pp);
			
			JPanel sp =StaP(sb);
			subP.add(sp);
			
			mainP.add(subP);
			
			mainP.add(db);
			
			baseP.add(mainP, BorderLayout.CENTER);
			
			return baseP;
		}
}
