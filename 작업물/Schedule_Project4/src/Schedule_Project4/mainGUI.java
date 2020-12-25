package Schedule_Project4;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import javax.swing.event.*;

import java.util.Vector;

class mainGUI {
	
	//
	//무지정 과목
		Vector <time> defaultTimeVector = new Vector();
		course defaultCourse = new course("","","",0,0,0,defaultTimeVector);
	
	//프레임 정보
	JButton addGroupB;
	
		//색지정
		Color selectColor = new Color(102,205,170);
		
		//가운데 정렬
		JPanel setCenter(Component cons) {
			JPanel p1 =new JPanel();
			p1.setSize(200,90);
			p1.setLayout(new FlowLayout(FlowLayout.CENTER));
			p1.setOpaque(false);
			p1.add(cons);
			return p1;
		}
		JPanel setCenter(Component cons ,Color c) {
			JPanel p1 =new JPanel();
			p1.setSize(200,90);
			p1.setLayout(new FlowLayout(FlowLayout.CENTER));
			p1.setOpaque(true);
			p1.setBackground(c);
			p1.add(cons);
			return p1;
		}
		
		//강의 그룹 정보창
		JPanel groupNameGUI (Group g, boolean hasButton) {
			final JPanel p =new JPanel();
			p.setPreferredSize(new Dimension(200, 90));
			p.setBackground(selectColor);
			p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

			JLabel l1 =new JLabel(g.GroupName);
			p.add(setCenter(l1));
			
			JLabel l2 =new JLabel();
			if(g.isVoid) l2.setText("(여유과목)");
			else l2.setText("(필수과목)");
			p.add(setCenter(l2));
			
			if(hasButton) {
			final JButton button =addB();
			p.add(setCenter(button));
			}
			
			LineBorder li1 =new LineBorder(Color.BLACK);
			p.setBorder(li1);
			
			return p;
		}

		//과목 정보창
		JPanel courseNameGUI (course c) {
			JPanel p =new JPanel();
			p.setPreferredSize(new Dimension(200, 90));
			p.setBackground(Color.WHITE);
			p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

			JLabel l1 =new JLabel(c.instructor+", "+c.place);
			p.add(setCenter(l1));
			
			JLabel l2 =new JLabel("학점: "+c.creedit+" 선호도: "+c.priority+" 안정도: "+c.stability);
			p.add(setCenter(l2));
			
			final JButton button =editB();
			p.add(setCenter(button));
			
			LineBorder li1 =new LineBorder(Color.BLACK);
			p.setBorder(li1);
			return p;
		}
		
		//추가 버튼:선택강의목록에 추가
		JButton addB() {
			
			final JButton addB = new JButton("추가");
			addB.setSize(60,30);
		
			return addB;
		}
		
		//편집 버튼: course 편집
		JButton editB() {
			final JButton addB = new JButton("수정");
			addB.setSize(60,30);
		
			return addB;
		}
		
		//시간대 버튼
		JButton selectionB (boolean isNotSelected) {
			final JButton b = new JButton();
			if(!isNotSelected) b.setText("선택됨");
			
			b.setPreferredSize(new Dimension(80, 30));
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton b = (JButton)e.getSource();
					if(b.getText().equals(""))
						b.setText("선택됨");
					
					else
						b.setText("");
				}
			});	
			return b;
		}
		
		//단일 과목에 대한시간표 출력
		JPanel TimeTable(Vector <time> tv) {
			JPanel a= new JPanel();
			JButton [][] buttonarr = new JButton[5][8];
			Table tab =new Table();
			
			tab.setTime(tv);
			
			for(int i=0;i<5;i++) {
				for(int j=0;j<8;j++) {
					buttonarr[i][j]=selectionB(tab.timeTable[i][j]);
				}
			}
			
			a.setSize(2000,3000);
			a.setLayout(new GridLayout(9,6,5,5));
			a.setBackground(Color.GRAY);
			a.add(new JPanel());
			
			JLabel t1 =new JLabel("월요일");
			a.add(setCenter(t1,Color.WHITE));
			
			JLabel t2 =new JLabel("화요일");
			a.add(setCenter(t2,Color.WHITE));
			
			JLabel t3 =new JLabel("수요일");
			a.add(setCenter(t3,Color.WHITE));
			
			JLabel t4 =new JLabel("목요일");
			a.add(setCenter(t4,Color.WHITE));
			
			JLabel t5 =new JLabel("금요일");
			a.add(setCenter(t5,Color.WHITE));
			
			for(int i=1;i<9;i++) {
				JLabel t=new JLabel(i+"교시");
				a.add(setCenter(t,Color.WHITE));
				
				for(int j=0;j<5;j++) {
					a.add(buttonarr[j][i-1]);
				}
			}
			
			LineBorder li1 =new LineBorder(Color.BLACK);
			a.setBorder(li1);
			
			return a;
		}

		//단일 과목에 대한 시간표와 설명 출력
		JPanel TableGUI(course c) {
			JPanel p =new JPanel();
			p.setLayout(new BorderLayout());
			
			JLabel subP =new JLabel("강의명: "+c.courseName+" 교수명: "+c.instructor+" 장소: "+c.place+"\n"+"학점: "+c.creedit+" 선호도: "+c.priority+" 안정도: "+c.stability);
			JPanel mainP =TimeTable(c.tv);
			
			p.add(setCenter(subP,Color.WHITE),BorderLayout.NORTH);
			p.add(mainP,BorderLayout.CENTER);
			
			LineBorder li1 =new LineBorder(Color.BLACK);
			p.setBorder(li1);
			
			return p;
		} 
		
		//인덱스값++
		JButton upB() {
			JButton b =new JButton("Up");
			b.setPreferredSize(new Dimension(200, 35));
			return b;
		}
		
		//인덱스값--
		JButton downB() {
			JButton b =new JButton("Down");
			b.setPreferredSize(new Dimension(200, 35));
			return b;
		}
		
		//그룹추가버튼
		JButton addGroupB_(JButton addGroupB) {
			JButton b =addGroupB;
			b.setPreferredSize(new Dimension(200, 35));
			b.setVisible(true);
			
			return b;
		}
		
		//강의추가버튼
		JButton addCourseB() {
			JButton b =new JButton("동일과목추가");
			b.setPreferredSize(new Dimension(200, 35));
			return b;
		}
		
		//강의계산 버튼
		JButton calculateB() {
			JButton b =new JButton("설정완료!");
			b.setPreferredSize(new Dimension(200, 35));
			return b;
		}
		
		//강의 그룹 저장 버튼
		JButton saveB() {
			JButton b =new JButton("저장");
			b.setPreferredSize(new Dimension(60, 30));
			return b;
		}
		
		//종료버튼
		JButton exitB() {
			JButton b = new JButton("종료");
			b.addActionListener(new ActionListener () {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			return b;
		}
		
		//강의 그룹 나열-설명
		JPanel applyGroup (Vector <Group> gv, int first, int last, boolean hasButton){
			JPanel groupPanel = new JPanel();
			groupPanel.setLayout(new BoxLayout(groupPanel, BoxLayout.Y_AXIS) );
			
			for(int i=first;i<=last;i++) {
				JPanel p = groupNameGUI (gv.elementAt(i),hasButton);
				groupPanel.add(p);
			}
			
			return groupPanel;
		}
		
		//강의  나열-설명
		JPanel applyCourse (Vector <course> cv, int first, int last) {
			JPanel groupPanel = new JPanel();
			groupPanel.setLayout(new BoxLayout(groupPanel, BoxLayout.Y_AXIS) );
			
			for(int i=first;i<=last;i++) {
				JPanel p = courseNameGUI (cv.elementAt(i));
				groupPanel.add(p);
			}
			
			return groupPanel;
		}
		
		//강의 갯수 조절
		JPanel controllCourse (Group g) {
			JPanel ctrlGroup = new JPanel();
			JPanel GroupInfo = groupNameGUI (g, false);
			JButton upButton =upB();
			JButton downButton =downB();
			
			int first=0, last;
			boolean isOver4=true;
			if(g.cv.size()<=4) {
				last=g.cv.size()-1;
				isOver4=false;
				}
			else last=3;
			upButton.setEnabled(isOver4);
			upButton.setVisible(isOver4);
			downButton.setEnabled(isOver4);
			downButton.setVisible(isOver4);
			
			ctrlGroup.setBackground(Color.WHITE);
			LineBorder li1 =new LineBorder(Color.BLACK);
			ctrlGroup.setBorder(li1);
			
			ctrlGroup.setLayout(new BoxLayout(ctrlGroup, BoxLayout.Y_AXIS));
			ctrlGroup.add(GroupInfo);
			ctrlGroup.add(setCenter(upButton));
			ctrlGroup.add(applyCourse (g.cv, first,last));
			ctrlGroup.add(setCenter(downButton));
			
			return ctrlGroup;
		}
		
		//강의 정보창
		JPanel CourseGUI (Group g) {
			JLabel l1 = new JLabel("과목 정보");
			JButton lb1 = addGroupB_(addGroupB);
			JPanel sgp =new JPanel();
			
			sgp.setBackground(Color.WHITE);
			LineBorder li1 =new LineBorder(Color.BLACK);
			sgp.setBorder(li1);
			
			sgp.setLayout(new BoxLayout(sgp, BoxLayout.Y_AXIS));
			sgp.add(setCenter(l1));
			if(!g.cv.isEmpty())sgp.add(controllCourse(g));
			sgp.add(setCenter(lb1));
			
			return sgp;
		}
		
		//강의 정보창 셋팅
		JPanel setCourseGUI () {
			JLabel l1 = new JLabel("과목 정보");
			JButton lb1 = addGroupB_(addGroupB);
			JPanel sgp =new JPanel();
			
			sgp.setBackground(Color.WHITE);
			LineBorder li1 =new LineBorder(Color.BLACK);
			sgp.setBorder(li1);
			
			sgp.setLayout(new BoxLayout(sgp, BoxLayout.Y_AXIS));
			sgp.add(setCenter(l1));
			sgp.add(setCenter(lb1));
			
			return sgp;
		}
		
		//강의그룹 갯수 조절
		JPanel controllGroup (Vector <Group> gv, boolean hasButton) {
			JPanel ctrlGroup = new JPanel();
			JButton upButton =upB();
			JButton downButton =downB();
			
			int first=0, last;
			boolean isOver5=true;
			if(gv.size()<=5) {
				last=gv.size()-1;
				isOver5=false;
				}
			else last=4;
			upButton.setEnabled(isOver5);
			upButton.setVisible(isOver5);
			downButton.setEnabled(isOver5);
			downButton.setVisible(isOver5);
			
			ctrlGroup.setBackground(Color.WHITE);
			LineBorder li1 =new LineBorder(Color.BLACK);
			ctrlGroup.setBorder(li1);
			
			ctrlGroup.setLayout(new BoxLayout(ctrlGroup, BoxLayout.Y_AXIS));
			ctrlGroup.add(setCenter(upButton));
			if(!gv.isEmpty())ctrlGroup.add(applyGroup (gv, first,last, hasButton));
			ctrlGroup.add(setCenter(downButton));
			
			return ctrlGroup;
		}
		
		//선택 강의그룹 정보창 
		JPanel selectedGroupGUI (Vector <Group> gv) {
			JLabel l1 = new JLabel("선택 과목 목록");
			JButton lb1 = calculateB();
			JPanel sgp =new JPanel();
			
			sgp.setBackground(Color.WHITE);
			LineBorder li1 =new LineBorder(Color.BLACK);
			sgp.setBorder(li1);
			
			sgp.setLayout(new BoxLayout(sgp, BoxLayout.Y_AXIS));
			sgp.add(setCenter(l1));
			if(!gv.isEmpty())sgp.add(controllGroup(gv,false));
			sgp.add(setCenter(lb1));
			
			return sgp;
		}
		
		//전체 강의그룹 정보창 
		JPanel totalGroupGUI (Vector <Group> gv) {
			JLabel l1 = new JLabel("전체 과목 목록");
			JButton lb1 = addGroupB_(addGroupB);
			JPanel sgp =new JPanel();
			
			sgp.setBackground(Color.WHITE);
			LineBorder li1 =new LineBorder(Color.BLACK);
			sgp.setBorder(li1);
			
			sgp.setLayout(new BoxLayout(sgp, BoxLayout.Y_AXIS));
			sgp.add(setCenter(l1));
			if(!gv.isEmpty())sgp.add(controllGroup(gv,true));
			sgp.add(setCenter(addGroupB));
			
			return sgp;
		}
		
		//gv에 대한 모든 정보 출력
		JPanel getAllInfo(Vector <Group> selectedGV,Vector <Group> gv){
			
			JPanel mainP = new JPanel();
			mainP.setLayout(new FlowLayout());
		
			JPanel JP1 = selectedGroupGUI (selectedGV);
			mainP.add(JP1);
			
			JPanel JP2 = totalGroupGUI (gv);
			mainP.add(JP2);
			
			JPanel JP3 =setCourseGUI ();
			mainP.add(JP3);
			
			/*JPanel JP4= TableGUI(defaultCourse);
			mainP.add(JP4);*/
			
			mainP.setVisible(true);
			
			return mainP;
	}	

		//네이밍 패널
		JPanel getNameCode() {
			JPanel p = new JPanel();
			p.setLayout(new FlowLayout(FlowLayout.CENTER));
			
			p.add(exitB());
			p.add(saveB());
			
			JLabel nameL = new JLabel("제작자: 고려대학교 2018320161 송대선");
			p.add(nameL);
			
			p.setBackground(Color.WHITE);
			LineBorder li1 =new LineBorder(Color.BLACK);
			p.setBorder(li1);
			p.setVisible(true);
			
			return p;
		}

		//메인 페널 출력
		JPanel getMainPanel(Vector <Group> selectedGV,Vector <Group> gv) {
			JPanel p = new JPanel();
			p.setLayout(new BorderLayout());
			p.add(getAllInfo(selectedGV,gv),BorderLayout.CENTER);
			p.add(getNameCode(),BorderLayout.NORTH);
			
			return p;
		}
}
