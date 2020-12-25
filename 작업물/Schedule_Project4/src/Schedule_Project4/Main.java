package Schedule_Project4;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import javax.swing.event.*;

import java.util.Vector;

public class Main extends JFrame {
	GroupManager gm =new GroupManager();
	TableManager tm =new TableManager();
	
	int tempGruopIndex;//현재 선택 강의 그룹
	int tempCourseIndex;//현재 선택 강의 그룹
	
	//종료버튼
	JButton exitB() {
		JButton exitB= new JButton("종료");
		exitB.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		return exitB;
	}
			
	//메인 화면에 들어가는 메소드들-시작:1
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
	
	//메인 화면에 들어가는 메소드들-끝:1
	
	
	
	Main(){
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		
		CardLayout card =new CardLayout();
		setLayout(card);
		Container cp = getContentPane();
		
		//메인 화면에 들어가는 컴포넌트들-시작:1
		
		//색지정
		Color selectColor = new Color(102,205,170);
		LineBorder li1 =new LineBorder(Color.BLACK);
		
		//모든 강의 그룹의 추가버튼 배열
		JButton[] totalButtonArray = new JButton[gv.size()];
		
		for(int i=0;i<gv.size();i++) {
			final JButton addB = new JButton("추가");
			addB.setSize(60,30);
			totalButtonArray[i]=addB;
		}
		
		//모든 강의 그룹
		JPanel[] totalGroupGUIArray = new JPanel[gm.gv.size()];
		
		for(int i=0;i<gm.gv.size();i++) {
			final JPanel GroupGUI =new JPanel();
			GroupGUI.setPreferredSize(new Dimension(200, 90));
			GroupGUI.setBackground(selectColor);
			GroupGUI.setLayout(new BoxLayout(GroupGUI, BoxLayout.Y_AXIS));

			JLabel GroupNameLabel =new JLabel(gm.gv.elementAt(i).GroupName);
			GroupGUI.add(setCenter(GroupNameLabel));
			
			JLabel voidInfo =new JLabel();
			if(gm.gv.elementAt(i).isVoid) voidInfo.setText("(여유과목)");
			else voidInfo.setText("(필수과목)");
			GroupGUI.add(setCenter(voidInfo));
			GroupGUI.add(setCenter(totalButtonArray[i]));
			
			GroupGUI.setBorder(li1);
			
			totalGroupGUIArray[i]=GroupGUI;
		}
		
		//전체 강의 그룹의 인덱스 값
		int totalGroupFirst=0;
		int totalGroupLast;
		
		//전체 강의 그룹의 인덱스값++
		JButton upButton =new JButton("Up");
		upButton.setPreferredSize(new Dimension(200, 35));
				
		//전체 강의 그룹의 인덱스값--
		JButton downButton =new JButton("Down");
		downButton.setPreferredSize(new Dimension(200, 35));
		
		//전체강의그룹 갯수 조절
		boolean isOver5=true;
		
		if(gm.gv.size()<=5) {
			totalGroupLast=gm.gv.size()-1;
			isOver5=false;
			}
		else totalGroupLast=4;
		
		upButton.setEnabled(isOver5);
		upButton.setVisible(isOver5);
		downButton.setEnabled(isOver5);
		downButton.setVisible(isOver5);
		
		//그룹추가버튼
		JButton addGroupB =new JButton("과목추가");
		addGroupB.setPreferredSize(new Dimension(200, 35));
		
		
		//전체 강의그룹 정보창 
		JPanel totalGroupGUI=new JPanel();
		totalGroupGUI.setBackground(Color.WHITE);
		totalGroupGUI.setBorder(li1);
		
		totalGroupGUI.setLayout(new BoxLayout(totalGroupGUI, BoxLayout.Y_AXIS));
		JLabel 전체과목목록 = new JLabel("전체 과목 목록");
		totalGroupGUI.add(setCenter(전체과목목록));
		totalGroupGUI.add(setCenter(upButton));
		if(!gm.gv.isEmpty()) for(int i=totalGroupFirst;i<=totalGroupLast;i++) {
			totalGroupGUI.add(totalGroupGUIArray[i]);
		}
		totalGroupGUI.add(setCenter(downButton));
		totalGroupGUI.add(setCenter(addGroupB));
		
		//선택된 강의 그룹
		JPanel[] selectedGroupGUIArray = new JPanel[gm.selectedGV.size()];
		
		for(int i=0;i<gm.selectedGV.size();i++) {
			final JPanel GroupGUI =new JPanel();
			GroupGUI.setPreferredSize(new Dimension(200, 90));
			GroupGUI.setBackground(selectColor);
			GroupGUI.setLayout(new BoxLayout(GroupGUI, BoxLayout.Y_AXIS));

			JLabel GroupNameLabel =new JLabel(gm.selectedGV.elementAt(i).GroupName);
			GroupGUI.add(setCenter(GroupNameLabel));
			
			JLabel voidInfo =new JLabel();
			if(gm.gv.elementAt(i).isVoid) voidInfo.setText("(여유과목)");
			else voidInfo.setText("(필수과목)");
			GroupGUI.add(setCenter(voidInfo));
			
			GroupGUI.setBorder(li1);
			
			selectedGroupGUIArray[i]=GroupGUI;
		}
		
		//선택 강의 그룹의 인덱스 값
		int selectedGroupFirst=0;
		int selectedGroupLast;
				
		//선택 강의 그룹의 인덱스값++
		JButton selectedupButton =new JButton("Up");
		selectedupButton.setPreferredSize(new Dimension(200, 35));
						
		//선택 강의 그룹의 인덱스값--
		JButton selecteddownButton =new JButton("Down");
		selecteddownButton.setPreferredSize(new Dimension(200, 35));
				
		//강의계산 버튼
		JButton calculateB=new JButton("설정완료!");
		calculateB.setPreferredSize(new Dimension(200, 35));
		
		//선택강의그룹 갯수 조절
		boolean selectedisOver5=true;
				
		if(gm.selectedGV.size()<=5) {
			selectedGroupLast=gm.selectedGV.size()-1;
			selectedisOver5=false;
			}
		else selectedGroupLast=4;
				
		selectedupButton.setEnabled(selectedisOver5);
		selectedupButton.setVisible(selectedisOver5);
		selecteddownButton.setEnabled(selectedisOver5);
		selecteddownButton.setVisible(selectedisOver5);
				
		//선택 강의그룹 정보창 
		JPanel selectedGroupGUI = new JPanel();
		selectedGroupGUI.setBackground(Color.WHITE);
		selectedGroupGUI.setBorder(li1);
				
		selectedGroupGUI.setLayout(new BoxLayout(selectedGroupGUI, BoxLayout.Y_AXIS));
		JLabel 선택과목목록 = new JLabel("선택 과목 목록");
		selectedGroupGUI.add(setCenter(선택과목목록));
		selectedGroupGUI.add(setCenter(selectedupButton));
		if(!gm.selectedGV.isEmpty()) for(int i=selectedGroupFirst;i<=selectedGroupLast;i++) {
			selectedGroupGUI.add(selectedGroupGUIArray[i]);
		}
		selectedGroupGUI.add(setCenter(selecteddownButton));
		selectedGroupGUI.add(setCenter(calculateB));
		
		
		Vector <JPanel> courseGUIVector = new Vector();
		
		
		//편집 버튼: course 편집
		final JButton editB = new JButton("수정");
		editB.setSize(60,30);
		
		//강의추가버튼
		JButton addCourseB =new JButton("동일과목추가");
		addCourseB.setPreferredSize(new Dimension(200, 35));

		//강의 그룹 저장 버튼
		JButton saveB=new JButton("저장");
		saveB.setPreferredSize(new Dimension(60, 30));
		
		//과목 정보 띄우기
		JPanel setCourseGUI=new JPanel();
		JLabel 과목정보 = new JLabel("과목 정보");
		
		setCourseGUI.setBackground(Color.WHITE);
		setCourseGUI.setBorder(li1);
		
		setCourseGUI.setLayout(new BoxLayout(setCourseGUI, BoxLayout.Y_AXIS));
		setCourseGUI.add(setCenter(과목정보));
		setCourseGUI.add(setCenter(addCourseB));
		
		//네이밍 패널
		JPanel getNameCode= new JPanel();
		getNameCode.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		getNameCode.add(exitB());
		getNameCode.add(saveB);
		
		JLabel nameL = new JLabel("제작자: 고려대학교 2018320161 송대선");
		getNameCode.add(nameL);
		
		getNameCode.setBackground(Color.WHITE);
		getNameCode.setBorder(li1);
		getNameCode.setVisible(true);
		
		//gv에 대한 모든 정보 출력
		JPanel getAllInfo= new JPanel();
		getAllInfo.setLayout(new FlowLayout());
		
		JPanel JP1 = selectedGroupGUI;
		getAllInfo.add(JP1);
		
		JPanel JP2 = totalGroupGUI;
		getAllInfo.add(JP2);
		
		JPanel JP3 =setCourseGUI ;
		getAllInfo.add(JP3);
		
		/*JPanel JP4= TableGUI(defaultCourse);
		getAllInfo.add(JP4);*/
		
		getAllInfo.setVisible(true);
		
		//메인 페널 출력
		JPanel getMainPanel= new JPanel();
		getMainPanel.setLayout(new BorderLayout());
		getMainPanel.add(getAllInfo,BorderLayout.CENTER);
		getMainPanel.add(getNameCode,BorderLayout.NORTH);
		
		//메인 화면에 들어가는 컴포넌트들 -끝:1
		
		//강의 그룹 추가에 들어가는 컴포넌트들-시작:2
		JTextField nameText = new JTextField(15);
		JCheckBox isNotVoid =new JCheckBox("필수과목여부", true);
		
		String arrnum [] = {"0","1","2","3","4","5","6"};
		JTextField instructorText = new JTextField(15);//강의자 텍스트 필드
		JTextField placeText =new JTextField(15);//장소 텍스트 필드
		JComboBox<String> cbox = new JComboBox<String>(arrnum); //학점
		
		
		JComboBox<String> pbox = new JComboBox<String>(arrnum); //선호도
		JButton doneButtonAddGroup = new JButton("완료");
		doneButtonAddGroup.setSize(60,30);
		
		//강의 이름 작성
		JPanel GroupNameP=new JPanel();
		GroupNameP.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		GroupNameP.add(new JLabel("강의명 ")); 
		GroupNameP.add(nameText); 
		
		//교수 이름 작성
		JPanel InstructorP=new JPanel();
		InstructorP.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		InstructorP.add(new JLabel("교수명 ")); 
		InstructorP.add(instructorText); 
		
		//강의 장소 작성
		JPanel PlaceP=new JPanel();
		PlaceP.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		PlaceP.add(new JLabel("강의장소 ")); 
		PlaceP.add(placeText); 
		
		//학점선택
		JPanel CreeditP= new JPanel();
		CreeditP.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		CreeditP.add(new JLabel("학점 "));
		CreeditP.add(cbox);
		
		//선호도선택
		JPanel PriP= new JPanel();
		PriP.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
		PriP.add(new JLabel("선호도 "));
		PriP.add(pbox);
		
		//제목패널
		JPanel addGroupName =new JPanel();
		addGroupName.setLayout(new FlowLayout(FlowLayout.CENTER));
		addGroupName.add(exitB());
		addGroupName.add(new JLabel("강의 추가"));
		addGroupName.setBackground(Color.WHITE);
		addGroupName.setBorder(li1);
		addGroupName.setVisible(true);
		
		//완료버튼 작동
		doneButtonAddGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gm.addCourseGroup(nameText.getText(),!(isNotVoid.isSelected()));
				gm.setTempGroup(gm.gv.size()-1);
				gm.addCourse(instructorText.getText(), placeText.getText(), pri, sta, );
			}
		});
		
		//내용물
		JPanel addGroupbaseP = new JPanel();
		addGroupbaseP.setLayout(new BorderLayout());
		addGroupbaseP.add(addGroupName,BorderLayout.NORTH);
		
		JPanel addGroupmainP = new JPanel();
		addGroupmainP.setLayout(new BoxLayout(addGroupmainP, BoxLayout.Y_AXIS));
		
		addGroupmainP.add(GroupNameP);
		addGroupmainP.add(InstructorP);
		addGroupmainP.add(PlaceP);
		
		JPanel addGroupsubP = new JPanel();
		addGroupsubP.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		
		addGroupsubP.add(CreeditP);
		addGroupsubP.add(PriP);
		addGroupsubP.add(StaP);
		
		addGroupmainP.add(addGroupsubP);
		
		addGroupmainP.add(setCenter(isNotVoid));
		addGroupmainP.add(doneButtonAddGroup);
		
		addGroupbaseP.add(addGroupmainP, BorderLayout.CENTER);
		//강의 그룹 추가에 들어가는 컴포넌트들-끝:2
		
		add(getMainPanel,"1");
		add(addGroupbaseP,"2");
		
		class MyActionListener implements ActionListener {
			public void actionPerformed (ActionEvent e) {
				JButton b = (JButton)e.getSource();
				String s=b.getText();
				
				if (s.equals("과목추가")) {
					card.show(cp,"2");
				}
			}
		}
		
		addGroupB.addActionListener(new MyActionListener());
		setVisible(true);
		card.show(this, "1");
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		
		//전필 전선 교양 몇개 들을꺼야? 이런 것도 설정하자!
		//arrayList 사용하자!
	}

}
