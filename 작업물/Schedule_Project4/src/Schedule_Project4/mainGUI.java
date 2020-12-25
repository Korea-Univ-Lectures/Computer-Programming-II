package Schedule_Project4;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import javax.swing.event.*;

import java.util.Vector;

class mainGUI {
	
	//
	//������ ����
		Vector <time> defaultTimeVector = new Vector();
		course defaultCourse = new course("","","",0,0,0,defaultTimeVector);
	
	//������ ����
	JButton addGroupB;
	
		//������
		Color selectColor = new Color(102,205,170);
		
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
		
		//���� �׷� ����â
		JPanel groupNameGUI (Group g, boolean hasButton) {
			final JPanel p =new JPanel();
			p.setPreferredSize(new Dimension(200, 90));
			p.setBackground(selectColor);
			p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

			JLabel l1 =new JLabel(g.GroupName);
			p.add(setCenter(l1));
			
			JLabel l2 =new JLabel();
			if(g.isVoid) l2.setText("(��������)");
			else l2.setText("(�ʼ�����)");
			p.add(setCenter(l2));
			
			if(hasButton) {
			final JButton button =addB();
			p.add(setCenter(button));
			}
			
			LineBorder li1 =new LineBorder(Color.BLACK);
			p.setBorder(li1);
			
			return p;
		}

		//���� ����â
		JPanel courseNameGUI (course c) {
			JPanel p =new JPanel();
			p.setPreferredSize(new Dimension(200, 90));
			p.setBackground(Color.WHITE);
			p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

			JLabel l1 =new JLabel(c.instructor+", "+c.place);
			p.add(setCenter(l1));
			
			JLabel l2 =new JLabel("����: "+c.creedit+" ��ȣ��: "+c.priority+" ������: "+c.stability);
			p.add(setCenter(l2));
			
			final JButton button =editB();
			p.add(setCenter(button));
			
			LineBorder li1 =new LineBorder(Color.BLACK);
			p.setBorder(li1);
			return p;
		}
		
		//�߰� ��ư:���ð��Ǹ�Ͽ� �߰�
		JButton addB() {
			
			final JButton addB = new JButton("�߰�");
			addB.setSize(60,30);
		
			return addB;
		}
		
		//���� ��ư: course ����
		JButton editB() {
			final JButton addB = new JButton("����");
			addB.setSize(60,30);
		
			return addB;
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
		
		//�ε�����++
		JButton upB() {
			JButton b =new JButton("Up");
			b.setPreferredSize(new Dimension(200, 35));
			return b;
		}
		
		//�ε�����--
		JButton downB() {
			JButton b =new JButton("Down");
			b.setPreferredSize(new Dimension(200, 35));
			return b;
		}
		
		//�׷��߰���ư
		JButton addGroupB_(JButton addGroupB) {
			JButton b =addGroupB;
			b.setPreferredSize(new Dimension(200, 35));
			b.setVisible(true);
			
			return b;
		}
		
		//�����߰���ư
		JButton addCourseB() {
			JButton b =new JButton("���ϰ����߰�");
			b.setPreferredSize(new Dimension(200, 35));
			return b;
		}
		
		//���ǰ�� ��ư
		JButton calculateB() {
			JButton b =new JButton("�����Ϸ�!");
			b.setPreferredSize(new Dimension(200, 35));
			return b;
		}
		
		//���� �׷� ���� ��ư
		JButton saveB() {
			JButton b =new JButton("����");
			b.setPreferredSize(new Dimension(60, 30));
			return b;
		}
		
		//�����ư
		JButton exitB() {
			JButton b = new JButton("����");
			b.addActionListener(new ActionListener () {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			return b;
		}
		
		//���� �׷� ����-����
		JPanel applyGroup (Vector <Group> gv, int first, int last, boolean hasButton){
			JPanel groupPanel = new JPanel();
			groupPanel.setLayout(new BoxLayout(groupPanel, BoxLayout.Y_AXIS) );
			
			for(int i=first;i<=last;i++) {
				JPanel p = groupNameGUI (gv.elementAt(i),hasButton);
				groupPanel.add(p);
			}
			
			return groupPanel;
		}
		
		//����  ����-����
		JPanel applyCourse (Vector <course> cv, int first, int last) {
			JPanel groupPanel = new JPanel();
			groupPanel.setLayout(new BoxLayout(groupPanel, BoxLayout.Y_AXIS) );
			
			for(int i=first;i<=last;i++) {
				JPanel p = courseNameGUI (cv.elementAt(i));
				groupPanel.add(p);
			}
			
			return groupPanel;
		}
		
		//���� ���� ����
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
		
		//���� ����â
		JPanel CourseGUI (Group g) {
			JLabel l1 = new JLabel("���� ����");
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
		
		//���� ����â ����
		JPanel setCourseGUI () {
			JLabel l1 = new JLabel("���� ����");
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
		
		//���Ǳ׷� ���� ����
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
		
		//���� ���Ǳ׷� ����â 
		JPanel selectedGroupGUI (Vector <Group> gv) {
			JLabel l1 = new JLabel("���� ���� ���");
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
		
		//��ü ���Ǳ׷� ����â 
		JPanel totalGroupGUI (Vector <Group> gv) {
			JLabel l1 = new JLabel("��ü ���� ���");
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
		
		//gv�� ���� ��� ���� ���
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

		//���̹� �г�
		JPanel getNameCode() {
			JPanel p = new JPanel();
			p.setLayout(new FlowLayout(FlowLayout.CENTER));
			
			p.add(exitB());
			p.add(saveB());
			
			JLabel nameL = new JLabel("������: ������б� 2018320161 �۴뼱");
			p.add(nameL);
			
			p.setBackground(Color.WHITE);
			LineBorder li1 =new LineBorder(Color.BLACK);
			p.setBorder(li1);
			p.setVisible(true);
			
			return p;
		}

		//���� ��� ���
		JPanel getMainPanel(Vector <Group> selectedGV,Vector <Group> gv) {
			JPanel p = new JPanel();
			p.setLayout(new BorderLayout());
			p.add(getAllInfo(selectedGV,gv),BorderLayout.CENTER);
			p.add(getNameCode(),BorderLayout.NORTH);
			
			return p;
		}
}
