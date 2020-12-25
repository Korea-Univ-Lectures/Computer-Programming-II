package Schedule_Project4;

import java.awt.*;
import javax.swing.*;

import javax.swing.border.LineBorder;

class CourseEditGUI {
	mainGUI m = new mainGUI();
	String arrnum [] = {"0","1","2","3","4","5","6","7","8","9","10"};
	JTextField instructorText = new JTextField(15);//강의자 텍스트 필드
	JTextField placeText =new JTextField(15);//장소 텍스트 필드
	JComboBox<String> cb = new JComboBox<String>(arrnum); //학점
	JComboBox<String> pb = new JComboBox<String>(arrnum); //선호도
	JComboBox<String> sb = new JComboBox<String>(arrnum); //안정도
	JButton db =doneB();
	
	//이름 설정
	JPanel NameLine () {
			JPanel p =new JPanel();
			p.setLayout(new FlowLayout(FlowLayout.CENTER));
			
			p.add(m.exitB());
			p.add(new JLabel("동일과목추가"));
			
			p.setBackground(Color.WHITE);
			LineBorder li1 =new LineBorder(Color.BLACK);
			p.setBorder(li1);
			p.setVisible(true);
			
			return p;
		}
		
	//교수 이름 작성
	JPanel InstructorP(JTextField instructorText) {
		JPanel p =new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
		p.add(instructorText); 
			
		return p;
	}

	//강의 장소 작성
	JPanel PlaceP(JTextField placeText) {
		JPanel p =new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
		p.add(new JLabel("강의장소 ")); 
		p.add(placeText); 
			
		return p;
	}

	//학점선택
	JPanel CreeditP(JComboBox<String> cb) {
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
		p.add(new JLabel("학점 "));
		p.add(cb);
		
		return p;
	}

	//선호도선택
	JPanel PriP(JComboBox<String> pb) {
			JPanel p = new JPanel();
			p.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
			p.add(new JLabel("선호도 "));
			
			p.add(pb);
			
			return p;
		}

	//안정도 선택
	JPanel StaP(JComboBox<String> sb) {
	JPanel p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
		p.add(new JLabel("안정도 "));
			
		p.add(sb);
			
		return p;
	}	

	//완료버튼
	JButton doneB() {
			final JButton b = new JButton("완료");
			b.setSize(60,30);
			return b;
		}

	//강의편집
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
