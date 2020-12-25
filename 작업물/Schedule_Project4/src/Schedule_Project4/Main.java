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
	
	int tempGruopIndex;//���� ���� ���� �׷�
	int tempCourseIndex;//���� ���� ���� �׷�
	
	//�����ư
	JButton exitB() {
		JButton exitB= new JButton("����");
		exitB.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		return exitB;
	}
			
	//���� ȭ�鿡 ���� �޼ҵ��-����:1
	//��� ����
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
	
	//�ð��� ��ư
	JButton selectionB (boolean isNotSelected) {
				final JButton b = new JButton();
				if(!isNotSelected) b.setText("���õ�");
				
				b.setPreferredSize(new Dimension(80, 30));
				b.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton b = (JButton)e.getSource();
						if(b.getText().equals(""))
							b.setText("���õ�");
						
						else
							b.setText("");
					}
				});	
				return b;
			}
	
	//���� ���� ���ѽð�ǥ ���
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
				
				JLabel t1 =new JLabel("������");
				a.add(setCenter(t1,Color.WHITE));
				
				JLabel t2 =new JLabel("ȭ����");
				a.add(setCenter(t2,Color.WHITE));
				
				JLabel t3 =new JLabel("������");
				a.add(setCenter(t3,Color.WHITE));
				
				JLabel t4 =new JLabel("�����");
				a.add(setCenter(t4,Color.WHITE));
				
				JLabel t5 =new JLabel("�ݿ���");
				a.add(setCenter(t5,Color.WHITE));
				
				for(int i=1;i<9;i++) {
					JLabel t=new JLabel(i+"����");
					a.add(setCenter(t,Color.WHITE));
					
					for(int j=0;j<5;j++) {
						a.add(buttonarr[j][i-1]);
					}
				}
				
				LineBorder li1 =new LineBorder(Color.BLACK);
				a.setBorder(li1);
				
				return a;
			}

	//���� ���� ���� �ð�ǥ�� ���� ���
	JPanel TableGUI(course c) {
				JPanel p =new JPanel();
				p.setLayout(new BorderLayout());
				
				JLabel subP =new JLabel("���Ǹ�: "+c.courseName+" ������: "+c.instructor+" ���: "+c.place+"\n"+"����: "+c.creedit+" ��ȣ��: "+c.priority+" ������: "+c.stability);
				JPanel mainP =TimeTable(c.tv);
				
				p.add(setCenter(subP,Color.WHITE),BorderLayout.NORTH);
				p.add(mainP,BorderLayout.CENTER);
				
				LineBorder li1 =new LineBorder(Color.BLACK);
				p.setBorder(li1);
				
				return p;
			} 
	
	//���� ȭ�鿡 ���� �޼ҵ��-��:1
	
	
	
	Main(){
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		
		CardLayout card =new CardLayout();
		setLayout(card);
		Container cp = getContentPane();
		
		//���� ȭ�鿡 ���� ������Ʈ��-����:1
		
		//������
		Color selectColor = new Color(102,205,170);
		LineBorder li1 =new LineBorder(Color.BLACK);
		
		//��� ���� �׷��� �߰���ư �迭
		JButton[] totalButtonArray = new JButton[gv.size()];
		
		for(int i=0;i<gv.size();i++) {
			final JButton addB = new JButton("�߰�");
			addB.setSize(60,30);
			totalButtonArray[i]=addB;
		}
		
		//��� ���� �׷�
		JPanel[] totalGroupGUIArray = new JPanel[gm.gv.size()];
		
		for(int i=0;i<gm.gv.size();i++) {
			final JPanel GroupGUI =new JPanel();
			GroupGUI.setPreferredSize(new Dimension(200, 90));
			GroupGUI.setBackground(selectColor);
			GroupGUI.setLayout(new BoxLayout(GroupGUI, BoxLayout.Y_AXIS));

			JLabel GroupNameLabel =new JLabel(gm.gv.elementAt(i).GroupName);
			GroupGUI.add(setCenter(GroupNameLabel));
			
			JLabel voidInfo =new JLabel();
			if(gm.gv.elementAt(i).isVoid) voidInfo.setText("(��������)");
			else voidInfo.setText("(�ʼ�����)");
			GroupGUI.add(setCenter(voidInfo));
			GroupGUI.add(setCenter(totalButtonArray[i]));
			
			GroupGUI.setBorder(li1);
			
			totalGroupGUIArray[i]=GroupGUI;
		}
		
		//��ü ���� �׷��� �ε��� ��
		int totalGroupFirst=0;
		int totalGroupLast;
		
		//��ü ���� �׷��� �ε�����++
		JButton upButton =new JButton("Up");
		upButton.setPreferredSize(new Dimension(200, 35));
				
		//��ü ���� �׷��� �ε�����--
		JButton downButton =new JButton("Down");
		downButton.setPreferredSize(new Dimension(200, 35));
		
		//��ü���Ǳ׷� ���� ����
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
		
		//�׷��߰���ư
		JButton addGroupB =new JButton("�����߰�");
		addGroupB.setPreferredSize(new Dimension(200, 35));
		
		
		//��ü ���Ǳ׷� ����â 
		JPanel totalGroupGUI=new JPanel();
		totalGroupGUI.setBackground(Color.WHITE);
		totalGroupGUI.setBorder(li1);
		
		totalGroupGUI.setLayout(new BoxLayout(totalGroupGUI, BoxLayout.Y_AXIS));
		JLabel ��ü������ = new JLabel("��ü ���� ���");
		totalGroupGUI.add(setCenter(��ü������));
		totalGroupGUI.add(setCenter(upButton));
		if(!gm.gv.isEmpty()) for(int i=totalGroupFirst;i<=totalGroupLast;i++) {
			totalGroupGUI.add(totalGroupGUIArray[i]);
		}
		totalGroupGUI.add(setCenter(downButton));
		totalGroupGUI.add(setCenter(addGroupB));
		
		//���õ� ���� �׷�
		JPanel[] selectedGroupGUIArray = new JPanel[gm.selectedGV.size()];
		
		for(int i=0;i<gm.selectedGV.size();i++) {
			final JPanel GroupGUI =new JPanel();
			GroupGUI.setPreferredSize(new Dimension(200, 90));
			GroupGUI.setBackground(selectColor);
			GroupGUI.setLayout(new BoxLayout(GroupGUI, BoxLayout.Y_AXIS));

			JLabel GroupNameLabel =new JLabel(gm.selectedGV.elementAt(i).GroupName);
			GroupGUI.add(setCenter(GroupNameLabel));
			
			JLabel voidInfo =new JLabel();
			if(gm.gv.elementAt(i).isVoid) voidInfo.setText("(��������)");
			else voidInfo.setText("(�ʼ�����)");
			GroupGUI.add(setCenter(voidInfo));
			
			GroupGUI.setBorder(li1);
			
			selectedGroupGUIArray[i]=GroupGUI;
		}
		
		//���� ���� �׷��� �ε��� ��
		int selectedGroupFirst=0;
		int selectedGroupLast;
				
		//���� ���� �׷��� �ε�����++
		JButton selectedupButton =new JButton("Up");
		selectedupButton.setPreferredSize(new Dimension(200, 35));
						
		//���� ���� �׷��� �ε�����--
		JButton selecteddownButton =new JButton("Down");
		selecteddownButton.setPreferredSize(new Dimension(200, 35));
				
		//���ǰ�� ��ư
		JButton calculateB=new JButton("�����Ϸ�!");
		calculateB.setPreferredSize(new Dimension(200, 35));
		
		//���ð��Ǳ׷� ���� ����
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
				
		//���� ���Ǳ׷� ����â 
		JPanel selectedGroupGUI = new JPanel();
		selectedGroupGUI.setBackground(Color.WHITE);
		selectedGroupGUI.setBorder(li1);
				
		selectedGroupGUI.setLayout(new BoxLayout(selectedGroupGUI, BoxLayout.Y_AXIS));
		JLabel ���ð����� = new JLabel("���� ���� ���");
		selectedGroupGUI.add(setCenter(���ð�����));
		selectedGroupGUI.add(setCenter(selectedupButton));
		if(!gm.selectedGV.isEmpty()) for(int i=selectedGroupFirst;i<=selectedGroupLast;i++) {
			selectedGroupGUI.add(selectedGroupGUIArray[i]);
		}
		selectedGroupGUI.add(setCenter(selecteddownButton));
		selectedGroupGUI.add(setCenter(calculateB));
		
		
		Vector <JPanel> courseGUIVector = new Vector();
		
		
		//���� ��ư: course ����
		final JButton editB = new JButton("����");
		editB.setSize(60,30);
		
		//�����߰���ư
		JButton addCourseB =new JButton("���ϰ����߰�");
		addCourseB.setPreferredSize(new Dimension(200, 35));

		//���� �׷� ���� ��ư
		JButton saveB=new JButton("����");
		saveB.setPreferredSize(new Dimension(60, 30));
		
		//���� ���� ����
		JPanel setCourseGUI=new JPanel();
		JLabel �������� = new JLabel("���� ����");
		
		setCourseGUI.setBackground(Color.WHITE);
		setCourseGUI.setBorder(li1);
		
		setCourseGUI.setLayout(new BoxLayout(setCourseGUI, BoxLayout.Y_AXIS));
		setCourseGUI.add(setCenter(��������));
		setCourseGUI.add(setCenter(addCourseB));
		
		//���̹� �г�
		JPanel getNameCode= new JPanel();
		getNameCode.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		getNameCode.add(exitB());
		getNameCode.add(saveB);
		
		JLabel nameL = new JLabel("������: ������б� 2018320161 �۴뼱");
		getNameCode.add(nameL);
		
		getNameCode.setBackground(Color.WHITE);
		getNameCode.setBorder(li1);
		getNameCode.setVisible(true);
		
		//gv�� ���� ��� ���� ���
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
		
		//���� ��� ���
		JPanel getMainPanel= new JPanel();
		getMainPanel.setLayout(new BorderLayout());
		getMainPanel.add(getAllInfo,BorderLayout.CENTER);
		getMainPanel.add(getNameCode,BorderLayout.NORTH);
		
		//���� ȭ�鿡 ���� ������Ʈ�� -��:1
		
		//���� �׷� �߰��� ���� ������Ʈ��-����:2
		JTextField nameText = new JTextField(15);
		JCheckBox isNotVoid =new JCheckBox("�ʼ����񿩺�", true);
		
		String arrnum [] = {"0","1","2","3","4","5","6"};
		JTextField instructorText = new JTextField(15);//������ �ؽ�Ʈ �ʵ�
		JTextField placeText =new JTextField(15);//��� �ؽ�Ʈ �ʵ�
		JComboBox<String> cbox = new JComboBox<String>(arrnum); //����
		
		
		JComboBox<String> pbox = new JComboBox<String>(arrnum); //��ȣ��
		JButton doneButtonAddGroup = new JButton("�Ϸ�");
		doneButtonAddGroup.setSize(60,30);
		
		//���� �̸� �ۼ�
		JPanel GroupNameP=new JPanel();
		GroupNameP.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		GroupNameP.add(new JLabel("���Ǹ� ")); 
		GroupNameP.add(nameText); 
		
		//���� �̸� �ۼ�
		JPanel InstructorP=new JPanel();
		InstructorP.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		InstructorP.add(new JLabel("������ ")); 
		InstructorP.add(instructorText); 
		
		//���� ��� �ۼ�
		JPanel PlaceP=new JPanel();
		PlaceP.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		PlaceP.add(new JLabel("������� ")); 
		PlaceP.add(placeText); 
		
		//��������
		JPanel CreeditP= new JPanel();
		CreeditP.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		CreeditP.add(new JLabel("���� "));
		CreeditP.add(cbox);
		
		//��ȣ������
		JPanel PriP= new JPanel();
		PriP.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
		PriP.add(new JLabel("��ȣ�� "));
		PriP.add(pbox);
		
		//�����г�
		JPanel addGroupName =new JPanel();
		addGroupName.setLayout(new FlowLayout(FlowLayout.CENTER));
		addGroupName.add(exitB());
		addGroupName.add(new JLabel("���� �߰�"));
		addGroupName.setBackground(Color.WHITE);
		addGroupName.setBorder(li1);
		addGroupName.setVisible(true);
		
		//�Ϸ��ư �۵�
		doneButtonAddGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gm.addCourseGroup(nameText.getText(),!(isNotVoid.isSelected()));
				gm.setTempGroup(gm.gv.size()-1);
				gm.addCourse(instructorText.getText(), placeText.getText(), pri, sta, );
			}
		});
		
		//���빰
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
		//���� �׷� �߰��� ���� ������Ʈ��-��:2
		
		add(getMainPanel,"1");
		add(addGroupbaseP,"2");
		
		class MyActionListener implements ActionListener {
			public void actionPerformed (ActionEvent e) {
				JButton b = (JButton)e.getSource();
				String s=b.getText();
				
				if (s.equals("�����߰�")) {
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
		
		//���� ���� ���� � ��������? �̷� �͵� ��������!
		//arrayList �������!
	}

}
