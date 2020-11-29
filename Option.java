package tib;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.print.attribute.standard.JobOriginatingUserName;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Option extends JFrame implements ActionListener {

	JLabel lab1, lab2, lab3, lab4, lab5, lab6, lab7, lab8, lab9;
	JButton btnq, btn1, btn2, btna, btnb, btnc, btnd, btnf, labLogout, btnLogout, btnLogo;
	ImageIcon busan, background, background2, date;
	TextArea ta;
	Checkbox box[] = new Checkbox[2];
	JRadioButton rMan, rWoman;
	TextField fi1, fi2;
	Button logoutBtn;
	Vector<DesignBean> vlist;
	DesignMgr mgr;
	int idx, dcode;
	ButtonGroup group;
	Introduce duce;
	String id;

	String ra1[] = { "기간 선택", "무박", "1박2일", "2박3일", "3박4일" };
	String ra2[] = { "부산시 구 선택", "강서구", "금정구", "기장군", "남구", "동구", "동래구", "부산진구", "북구", "사상구", "사하구", "서구", "수영구", "연제구",
			"영도구", "중구", "해운대구" };
	String ra3[] = { "연령 선택", "10대", "20대", "30대", "40대", "50대이상" };
	String ra4[] = { "희망인원 선택", "2~3명", "3~4명", "5~6명","7명이상" };
	JComboBox<String> combo1, combo2, combo3, combo4;

	public Option() {// 각 메뉴 아이콘 클릭시 선택할 수 있는 창 pop up띄우기

		mgr = new DesignMgr();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setTitle("Travle in Busan");

		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");// HH:mm:ss
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");

		Date time = new Date();

		String time1 = format1.format(time);
		String time2 = format2.format(time);

		busan = new ImageIcon("tib/busanwhite157.png");
		JPanel panelLogo = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(busan.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};

		background2 = new ImageIcon("tib/beige.png");
		JPanel panelBackground2 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background2.getImage(), 0, 0, null);
				setOpaque(false);// 안배경

			}
		};

		background = new ImageIcon("tib/background800.jpg");
		JPanel panelBackground = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background.getImage(), 0, 0, null);
				setOpaque(false);// 바깥배경

			}
		};

		date = new ImageIcon("tib/date.png");
		JPanel panelKa = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(date.getImage(), 0, 0, null);
				setOpaque(false);// 바깥배경
			}
		};

////////////////// 하단 버튼 다음//////////////////////////////////////

		panelBackground2.add(btn2 = new JButton("검색하기"));
		btn2.setBounds(480, 540, 150, 30);
		btn2.addActionListener(this);

		/*panelBackground2.add(btnq = new JButton("저장하고 검색하기"));
		btnq.setBounds(480, 540, 300, 30);
		btnq.addActionListener(this);*/

///////////////////////////////////////////////////////////////////////
		// 페이지 로고//
		btnLogo = new JButton(busan);
		btnLogo.setBounds(180, 20, 180, 50);
		btnLogo.setBackground(new Color(0, 0, 0));
		panelBackground.add(btnLogo);
		btnLogo.addActionListener(this);

		btnLogout = new JButton("Logout");
		btnLogout.setBounds(1190, 30, 90, 30);
		btnLogout.setBackground(new Color(0, 0, 0));
		panelBackground.add(btnLogout);
		btnLogout.addActionListener(this);

		panelBackground2.add(lab1 = new JLabel("빅데이터로 알려주는 여행지 정보"));
		lab1.setBounds(320, 50, 1100, 50);

		panelBackground2.add(lab2 = new JLabel("여행기간별 여행추천 정보를 제공해 드립니다."));
		lab2.setBounds(380, 90, 1100, 50);

		panelBackground2.add(lab3 = new JLabel("기간"));
		lab3.setBounds(320, 160, 1100, 50);

		panelBackground2.add(combo1 = new JComboBox<String>(ra1));
		combo1.setBounds(520, 170, 290, 30);

		panelBackground2.add(lab4 = new JLabel("여행일자"));
		lab4.setBounds(320, 220, 190, 50);
		
		panelBackground2.add(fi1 = new TextField(time1, 5));
		fi1.setBounds(520, 230, 100, 30);

		panelBackground2.add(btnc = new JButton(date));
		btnc.setBounds(630, 230, 30, 30);
		btnc.addActionListener(this);


		panelBackground2.add(lab5 = new JLabel("구별 선택"));
		lab5.setBounds(320, 280, 1100, 50);

		panelBackground2.add(combo2 = new JComboBox<String>(ra2));
		combo2.setBounds(520, 290, 290, 30);

		panelBackground2.add(lab6 = new JLabel("희망연령 선택"));
		lab6.setBounds(320, 340, 1100, 50);

		panelBackground2.add(combo3 = new JComboBox<String>(ra3));
		combo3.setBounds(520, 350, 290, 30);

		panelBackground2.add(lab7 = new JLabel("희망성별 선택"));
		lab7.setBounds(320, 400, 1100, 50);

		panelBackground2.add(rMan = new JRadioButton("남자", true));
		panelBackground2.add(rWoman = new JRadioButton("여자"));
		group = new ButtonGroup();
		group.add(rMan);
		group.add(rWoman);
		rMan.setBounds(570, 410, 80, 40);
		rMan.setBackground(new Color(251, 246, 240));
		rWoman.setBounds(680, 410, 80, 40);
		rWoman.setBackground(new Color(251, 246, 240));

		panelBackground2.add(lab9 = new JLabel("희망인원 선택"));
		lab9.setBounds(320, 460, 1100, 50);

		panelBackground2.add(combo4 = new JComboBox<String>(ra4));
		combo4.setBounds(520, 470, 290, 30);

		panelBackground2.setLayout(null);
		panelBackground2.setBounds(180, 80, 1100, 620);
		panelBackground2.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 5), "★"));
		panelBackground2.setBackground(new Color(0, 0, 0, 50));
		add(panelBackground2);

		panelBackground.setLayout(null);
		panelBackground.setBounds(0, 0, 1500, 800);
		add(panelBackground);
////////////////////////////////////////////////////////////////////////////////////		
		// 폰트//
		Font title = new Font("맑은고딕", Font.BOLD, 30);
		Font list = new Font("맑은고딕", Font.BOLD, 15);
		Font top = new Font("맑은고딕", Font.BOLD, 15);

		lab1.setFont(title);
		lab2.setFont(list);
		lab3.setFont(list);
		lab4.setFont(list);
		lab5.setFont(list);
		lab6.setFont(list);
		lab7.setFont(list);
		lab9.setFont(list);
		fi1.setFont(list);

		rMan.setFont(list);
		rWoman.setFont(list);

		
		btnLogout.setFont(top);
		btnLogout.setFont(top);
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setBackground(Color.BLACK);

		btn2.setBackground(Color.WHITE);
		combo1.setBackground(Color.WHITE);
		combo2.setBackground(Color.WHITE);
		combo3.setBackground(Color.WHITE);
		combo4.setBackground(Color.WHITE);

		btnc.setBackground(Color.WHITE);


		rMan.setForeground(Color.BLACK);
		rWoman.setForeground(Color.BLACK);

		setSize(1500, 800);
		setVisible(true);
		validate();
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (btnc == obj) {
			new SwingCalendar(this);
		} else if (btnd == obj) {
			new SwingCalendar2(this);
		} else if (btnLogout == obj) {
			this.setVisible(false);
			Login Login = new Login();
			Login.setVisible(true);
		} else if (btn2 == obj) {
			
			DesignBean bean = new DesignBean();
			bean.setIdx(idx);
			bean.setPeriod((String) combo1.getSelectedItem());
			bean.setDdate(fi1.getText());
			bean.setArea((String) combo2.getSelectedItem());
			bean.setDage((String) combo3.getSelectedItem());
			String msg = "남자";
			if(!rMan.isSelected()) msg = "여자";
			bean.setGender(msg);
			bean.setNump((String) combo4.getSelectedItem());
			this.setVisible(false);
			Place Place = new Place();
			Place.setVisible(true);
			//duce = new Introduce( dcode);
			//duce.setVisible(true);
			boolean flag = mgr.insertDesign(bean);
			if(flag==true) {
				//duce.updateForm(bean);
			}
		} else if (obj == btnLogo) {
			this.setVisible(false);
			Choose Choose = new Choose();
			Choose.setVisible(true);
			
		}
	}

	class MBack extends JDialog implements ActionListener {

		int width = 200;
		int height = 145;
		JButton btnu;
		JLabel msg1L;
		Frame f;

		public MBack(Frame f, String title, String msg, boolean flag) {
			super(f, title, flag);
			this.f = f;
			int xmsg = msg.length();

			setLayout(null);
			add(msg1L = new JLabel("sibar"));
			add(btnu = new JButton("확인"));
			msg1L.setBounds(40, 20, 150, 25);

			btnu.setBounds(60, 55, 60, 30);
			btnu.addActionListener(this);
			layset();
		}

		public void layset() {
			int px = f.getX();
			int py = f.getY();
			int x = px + f.getWidth() / 2;
			int y = py + f.getHeight() / 2;
			setBounds(x, y, width, height);
			setVisible(true);
			// validate();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}

	//// JFrame 배경색상 지정//////////////////////////////////////////
	public static void main(String[] args) {
		new Option();
	}
}
