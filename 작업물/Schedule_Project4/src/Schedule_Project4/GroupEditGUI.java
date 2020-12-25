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

//필수과목체크란
JCheckBox isNotVoid = new JCheckBox("필수과목여부", true);
JButton db =doneB();

	//이름 설정
	JPanel NameLine () {
		JPanel p =new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		p.add(m.exitB());
		p.add(new JLabel("강의 편집"));
		
		p.setBackground(Color.WHITE);
		LineBorder li1 =new LineBorder(Color.BLACK);
		p.setBorder(li1);
		p.setVisible(true);
		
		return p;
	}

	//강의 이름 작성
	JPanel GroupNameP(JTextField nameText) {
		JPanel p =new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
		p.add(new JLabel("강의자 ")); 
		p.add(nameText); 
		
		return p;
	}

	
	//완료버튼
	JButton doneB() {
		final JButton b = new JButton("완료");
		b.setSize(60,30);
		return b;
	}

	//강의그룹편집
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
