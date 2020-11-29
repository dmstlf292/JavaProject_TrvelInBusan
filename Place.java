package tib;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import tib.More.Message;

public class Place extends JFrame implements ActionListener {

	JLabel lab1, lab2, lab3, lab4, lab5, lab6, lab7, lab8, lab9, lab10, lab11, lab12, lab13, lab14, lab15, lab16,
			labLike, labLike2, labLike3, labMail;
	ImageIcon busan, background, background2, site1, site2, site3, bts, bts1, like, mail;
	JButton btn1, btna, btnb, btnc, btnd, btne, btnf, btng, btnh, btnS, btnj, btnk, btnLogout, btnLogo, btnLike,
			btnLike2, btnLike3, btnMail;
	TextField fi, fi2, fi3, fi4, fi5, fi6, fi7, fi8, fi9;
	TextArea ta1, ta2, ta3, ta4, ta5, ta6;
	JPanel p1, p2;
	List li1, li2, li3, li4, li5;
	JButton btn[] = new JButton[2], btnq[] = new JButton[2], btnw[] = new JButton[2];
	String str1[] = { "더보기", "list 담기" };
	String str2[] = { "더보기", "list 담기" };
	String str3[] = { "더보기", "list 담기" };

	int count = 0;
	int count2 = 0;
	int count3 = 0;
	PrintWriter out;

	int mode = 0;
	Info infoF;

	URL url = null;
	String url2 = "http://jspstudy.co.kr/tib/map.jsp?";
	TibMapMgr mgr = null;
	int position = 1;
	Vector<TravelBean> vlist = null;
	TravelBean bean[];
	JPanel panelLogo, panelBackground2, panelSite1, panelSite2, panelSite3, panelBackground, info;

	public Place() {
		mgr = new TibMapMgr();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setTitle("Travle in Busan");
		busan = new ImageIcon("tib/busanwhite157.png");
		panelLogo = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(busan.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};
		mail = new ImageIcon("tib/mail.png");
		JPanel panelMail = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(mail.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};

		like = new ImageIcon("tib/like.png");
		JPanel panelLike = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(like.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};
		background2 = new ImageIcon("tib/beige.png");
		panelBackground2 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background2.getImage(), 0, 0, null);
				setOpaque(false);// 안배경
			}
		};
		setPosition(position);
		info.add(lab4 = new JLabel(" 무박 "));
		info.add(btn1 = new JButton("삭제"));
		btn1.setBounds(1330, 680, 30, 20);
		btn1.addActionListener(this);
		info.add(li1 = new List(7, false));

		info.add(lab5 = new JLabel("1일차"));
		info.add(btna = new JButton("삭제"));
		btna.setBounds(1330, 680, 20, 10);
		btna.addActionListener(this);
		info.add(li2 = new List(7, false));

		info.add(lab6 = new JLabel("2일차"));
		info.add(btnb = new JButton("삭제"));
		btnb.setBounds(1330, 680, 30, 20);
		btnb.addActionListener(this);
		info.add(li3 = new List(7, false));

		info.add(lab7 = new JLabel("3일차"));
		info.add(btnc = new JButton("삭제"));
		btnc.setBounds(1330, 680, 30, 20);
		btnc.addActionListener(this);
		info.add(li4 = new List(7, false));
		info.add(lab14 = new JLabel("4일차"));
		info.add(btnd = new JButton("삭제"));
		btnd.setBounds(1330, 680, 30, 20);
		btnd.addActionListener(this);

		info.add(li5 = new List(7, false));

		for (int i = 0; i < btn.length; i++) {
			panelBackground2.add(btn[i] = new JButton(str1[i]));
			btn[i].addActionListener(this);
		}
		btn[0].setBounds(920, 70, 100, 30);
		btn[1].setBounds(920, 130, 100, 30);
		for (int i = 0; i < btnq.length; i++) {
			panelBackground2.add(btnq[i] = new JButton(str2[i]));
			btnq[i].addActionListener(this);
		}
		btnq[0].setBounds(920, 330, 100, 30);
		btnq[1].setBounds(920, 390, 100, 30);

		for (int i = 0; i < btnw.length; i++) {
			panelBackground2.add(btnw[i] = new JButton(str3[i]));
			btnw[i].addActionListener(this);
		}
		btnw[0].setBounds(920, 580, 100, 30);
		btnw[1].setBounds(920, 640, 100, 30);

		btnLogo = new JButton(busan);
		btnLogo.setBounds(120, 20, 180, 50);
		btnLogo.setBackground(new Color(0, 0, 0));
		panelBackground.add(btnLogo);
		btnLogo.addActionListener(this);

		btnLogout = new JButton("Logout");
		btnLogout.setBounds(1130, 30, 90, 30);
		btnLogout.setBackground(new Color(0, 0, 0));
		panelBackground.add(btnLogout);
		btnLogout.addActionListener(this);

		// 좋아요 사진의 버튼//
		btnLike = new JButton(like);
		btnLike.setBounds(920, 190, 30, 30);
		btnLike.setBackground(new Color(251, 246, 240));
		panelBackground2.add(btnLike);
		btnLike.addActionListener(this);

		// label 좋아요
		labLike = new JLabel("좋아요 " + count);
		panelBackground2.add(labLike);
		labLike.setBounds(960, 190, 100, 30);
		labLike.setBackground(new Color(251, 246, 240));

		// 좋아요2 사진의 버튼//
		btnLike2 = new JButton(like);
		btnLike2.setBounds(920, 450, 30, 30);
		btnLike2.setBackground(new Color(251, 246, 240));
		panelBackground2.add(btnLike2);
		btnLike2.addActionListener(this);

		// label2 좋아요
		labLike2 = new JLabel("좋아요 " + count2);
		panelBackground2.add(labLike2);
		labLike2.setBounds(960, 450, 100, 30);
		labLike2.setBackground(new Color(251, 246, 240));

		// 좋아요3 사진의 버튼//
		btnLike3 = new JButton(like);
		btnLike3.setBounds(920, 710, 30, 30);
		btnLike3.setBackground(new Color(251, 246, 240));
		panelBackground2.add(btnLike3);
		btnLike3.addActionListener(this);

		// label3 좋아요
		labLike3 = new JLabel("좋아요 " + count3);
		panelBackground2.add(labLike3);
		labLike3.setBounds(960, 710, 100, 30);
		labLike3.setBackground(new Color(251, 246, 240));

		panelSite1.setLayout(null);
		panelSite1.setBounds(180, 100, 400, 240);
		add(panelSite1);

		panelSite2.setLayout(null);
		panelSite2.setBounds(180, 350, 400, 240);
		add(panelSite2);

		panelSite3.setLayout(null);
		panelSite3.setBounds(180, 600, 400, 240);
		add(panelSite3);

		panelBackground2.setLayout(null);
		panelBackground2.setBounds(120, 80, 1100, 800);
		panelBackground2.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 5), "★"));
		panelBackground2.setBackground(new Color(0, 0, 0, 50));
		add(panelBackground2);

		btnMail = new JButton(mail);
		btnMail.setBounds(980, 30, 30, 30);
		btnMail.setBackground(new Color(0, 0, 0));
		panelBackground.add(btnMail);
		btnMail.addActionListener(this);

		Label labmail = new Label();
		panelBackground.add(labmail = new Label("쪽지보내기"));
		labmail.setBounds(1020, 30, 80, 30);
		labmail.setBackground(new Color(0, 0, 0));

		panelBackground.add(btnk = new JButton("이전"));
		btnk.setBounds(550, 900, 100, 30);
		btnk.addActionListener(this);

		panelBackground.add(btnj = new JButton("다음"));
		btnj.setBounds(770, 900, 100, 30);
		btnj.addActionListener(this);

		panelBackground.add(btnS = new JButton("저장"));
		btnS.setBounds(1270, 900, 100, 30);
		btnS.addActionListener(this);

		panelBackground.setLayout(null);
		panelBackground.setBounds(0, 0, 1500, 1000);
		add(panelBackground);

		Font title = new Font("맑은고딕", Font.BOLD, 30);
		Font list = new Font("맑은고딕", Font.BOLD, 20);
		Font top = new Font("맑은고딕", Font.BOLD, 15);

		lab1.setFont(top);
		lab2.setFont(top);
		lab3.setFont(top);
		lab4.setFont(top);
		lab5.setFont(top);
		lab6.setFont(top);
		lab7.setFont(top);
		lab8.setFont(top);
		lab9.setFont(top);
		lab10.setFont(top);
		lab11.setFont(top);
		lab12.setFont(top);
		lab13.setFont(top);
		lab14.setFont(top);

		labmail.setForeground(Color.WHITE);
		lab4.setForeground(Color.WHITE);
		lab5.setForeground(Color.WHITE);
		lab6.setForeground(Color.white);
		lab7.setForeground(Color.WHITE);
		lab14.setForeground(Color.WHITE);
		btn1.setForeground(Color.BLACK);
		btna.setForeground(Color.BLACK);
		btnb.setForeground(Color.BLACK);
		btnc.setForeground(Color.BLACK);
		btnd.setForeground(Color.BLACK);
		btn1.setBackground(Color.WHITE);
		btna.setBackground(Color.WHITE);
		btnb.setBackground(Color.WHITE);
		btnc.setBackground(Color.WHITE);
		btn[0].setBackground(Color.WHITE);
		btn[1].setBackground(Color.WHITE);
		btnq[0].setBackground(Color.WHITE);
		btnq[1].setBackground(Color.WHITE);
		btnw[0].setBackground(Color.WHITE);
		btnw[1].setBackground(Color.WHITE);
		btnd.setBackground(Color.WHITE);
		btnS.setBackground(Color.WHITE);
		btnj.setBackground(Color.WHITE);
		btnk.setBackground(Color.WHITE);
		btnLogout.setFont(top);
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setBackground(Color.BLACK);

		setSize(1500, 1000);
		setVisible(true);
		validate();
		setLocationRelativeTo(null);
	}

	public void setPosition(int position) {

		try {

			vlist = mgr.getListTravel(position);
			bean = new TravelBean[vlist.size()];
			for (int i = 0; i < bean.length; i++) {
				bean[i] = vlist.elementAt(i);
			}

			url = new URL("https://www.visitbusan.net/" + bean[0].getMAIN_IMG_THUMB());
			site1 = new ImageIcon(url);
			panelSite1 = new JPanel() {
				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(site1.getImage(), 0, 0, null);
					setOpaque(false);// 바깥배경
				}
			};

			url = new URL("https://www.visitbusan.net/" + bean[1].getMAIN_IMG_THUMB());
			site2 = new ImageIcon(url);
			panelSite2 = new JPanel() {
				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(site2.getImage(), 0, 0, null);
					setOpaque(false);// 바깥배경

				}
			};

			url = new URL("https://www.visitbusan.net/" + bean[2].getMAIN_IMG_THUMB());
			site3 = new ImageIcon(url);
			panelSite3 = new JPanel() {
				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(site3.getImage(), 0, 0, null);
					setOpaque(false);// 바깥배경

				}
			};

			background = new ImageIcon("tib/background1100.jpg");
			panelBackground = new JPanel() {
				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(background.getImage(), 0, 0, null);
					setOpaque(false);// 바깥배경

				}
			};

			info = new JPanel();
			info.setBounds(1250, 100, 140, 750);
			info.setBorder(new TitledBorder(new LineBorder(Color.WHITE, 5), ""));
			info.setBackground(new Color(0, 0, 0, 50));
			add(info);

///////////////////////////////////////////////////////////////////////////
			if (lab1 != null)
				panelBackground2.remove(lab1);
			panelBackground2.add(lab1 = new JLabel("이름"));
			lab1.setBounds(510, 60, 40, 50);

			if (fi != null)
				panelBackground2.remove(fi);
			panelBackground2.add(fi = new TextField(bean[0].getMAIN_TITLE()));
			fi.setBounds(580, 70, 300, 30);

			if (lab2 != null)
				panelBackground2.remove(lab2);
			panelBackground2.add(lab2 = new JLabel("주소"));
			lab2.setBounds(510, 120, 40, 50);

			if (fi2 != null)
				panelBackground2.remove(fi2);
			panelBackground2.add(fi2 = new TextField(bean[0].getADDR1(), 5));
			fi2.setBounds(580, 130, 300, 30);

			if (lab3 != null)
				panelBackground2.remove(lab3);
			panelBackground2.add(lab3 = new JLabel("공휴일"));
			lab3.setBounds(510, 180, 60, 50);

			if (fi3 != null)
				panelBackground2.remove(fi3);
			panelBackground2.add(fi3 = new TextField(bean[0].getHLDY_INFO(), 5));
			fi3.setBounds(580, 190, 300, 30);

///////////////////////////////////////////////////////////////////////////
			if (lab8 != null)
				panelBackground2.remove(lab8);
			panelBackground2.add(lab8 = new JLabel("이름"));
			lab8.setBounds(510, 320, 40, 50);

			if (fi4 != null)
				panelBackground2.remove(fi4);
			panelBackground2.add(fi4 = new TextField(bean[1].getMAIN_TITLE(), 5));
			fi4.setBounds(580, 330, 300, 30);

			if (lab9 != null)
				panelBackground2.remove(lab9);
			panelBackground2.add(lab9 = new JLabel("주소"));
			lab9.setBounds(510, 380, 40, 50);

			if (fi5 != null)
				panelBackground2.remove(fi5);
			panelBackground2.add(fi5 = new TextField(bean[1].getADDR1(), 5));
			fi5.setBounds(580, 390, 300, 30);

			if (lab10 != null)
				panelBackground2.remove(lab10);
			panelBackground2.add(lab10 = new JLabel("공휴일"));
			lab10.setBounds(510, 440, 60, 50);

			if (fi6 != null)
				panelBackground2.remove(fi6);
			panelBackground2.add(fi6 = new TextField(bean[1].getHLDY_INFO(), 5));
			fi6.setBounds(580, 450, 300, 30);

///////////////////////////////////////////////////////////////////////////
			if (lab11 != null)
				panelBackground2.remove(lab11);
			panelBackground2.add(lab11 = new JLabel("이름"));
			lab11.setBounds(510, 570, 40, 50);

			if (fi7 != null)
				panelBackground2.remove(fi7);
			panelBackground2.add(fi7 = new TextField(bean[2].getMAIN_TITLE(), 5));
			fi7.setBounds(580, 580, 300, 30);

			if (lab12 != null)
				panelBackground2.remove(lab12);
			panelBackground2.add(lab12 = new JLabel("주소"));
			lab12.setBounds(510, 630, 40, 50);

			if (fi8 != null)
				panelBackground2.remove(fi8);
			panelBackground2.add(fi8 = new TextField(bean[2].getADDR1(), 5));
			fi8.setBounds(580, 640, 300, 30);

			if (lab13 != null)
				panelBackground2.remove(lab13);
			panelBackground2.add(lab13 = new JLabel("공휴일"));
			lab13.setBounds(510, 690, 60, 50);

			if (fi9 != null)
				panelBackground2.remove(fi9);
			panelBackground2.add(fi9 = new TextField(bean[2].getHLDY_INFO(), 5));
			fi9.setBounds(580, 700, 300, 30);

			repaint();
			validate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String cmd = e.getActionCommand();
		int id = li1.getSelectedIndex();
		int id2 = li2.getSelectedIndex();
		int id3 = li3.getSelectedIndex();
		int id4 = li4.getSelectedIndex();
		int id5 = li5.getSelectedIndex();
		if (btnk == obj) {// 이전
			if (position > 3)
				position -= 3;
			setPosition(position);
		} else if (btnj == obj) {// 다음
			position += 3;
			setPosition(position);
		}else if (btnS == obj) { // 저장1
			new MSave(this, "알림", "", true);
		}else if (btnS == obj) { // 저장2
			new MSave2(this, "알림", "", true);
		}else if (obj == btn[1]) {
			mode = 0;
			new MDialog1(this, "알림", "", true);// list1
		} else if (obj == btn[0]) {
			this.setVisible(false);
			infoF = new Info(bean[0].getUC_SEQ());
			infoF.setVisible(true);// 더보기1
		} else if (obj == btnq[1]) {
			mode = 1;
			new MDialog1(this, "알림", "", true);// list2
		} else if (obj == btnq[0]) {
			this.setVisible(false);
			infoF = new Info(bean[1].getUC_SEQ());
			infoF.setVisible(true);// 더보기1
		} else if (obj == btnw[1]) {
			mode = 2;
			new MDialog1(this, "알림", "", true);
			;// list3
		} else if (obj == btnw[0]) {
			this.setVisible(false);
			infoF = new Info(bean[2].getUC_SEQ());
			infoF.setVisible(true);// 더보기1
		} else if (obj == btn1) {
			li1.remove(id);
		} else if (obj == btna) {
			li2.remove(id2);
		} else if (obj == btnb) {
			li3.remove(id3);
		} else if (obj == btnc) {
			li4.remove(id4);
		} else if (obj == btnd) {
			li5.remove(id5);
		} else if (btnLogout == obj) {
			this.setVisible(false);
			Login Login = new Login();
			Login.setVisible(true);
		} else if (obj == btnLogo) {
			this.setVisible(false);
			Choose Choose = new Choose();
			Choose.setVisible(true);
		} else if (e.getSource() == btnLike) { // 좋아요 버튼
			String str = labLike.getText();// str
			System.out.println(str);// str
			count = Integer.parseInt(str.replace("좋아요 ", ""));// count
			count++;// count
			labLike.setText("좋아요 " + count);// str+count
		} else if (e.getSource() == btnLike2) { // 좋아요2 버튼
			String str = labLike2.getText();// str
			System.out.println(str);// str
			count2 = Integer.parseInt(str.replace("좋아요 ", ""));// count
			count2++;// count
			labLike2.setText("좋아요 " + count2);// str+count
		} else if (e.getSource() == btnLike3) { // 좋아요3 버튼
			String str = labLike3.getText();// str
			System.out.println(str);// str
			count3 = Integer.parseInt(str.replace("좋아요 ", ""));// count
			count3++;// count
			labLike3.setText("좋아요 " + count3);// str+count
		} else if (btnMail == obj) { // 쪽지보내기
			new Message("TO:");
		}
	}
//////////////////////////////저장2////////////////////////////////////////////////
	
	class MSave2 extends JDialog implements ActionListener {

		int width = 500;
		int height = 145;
		JButton btnu;
		JLabel msg1L;
		Frame f;
		TextArea ta;

		public MSave2(Frame f, String title, String msg, boolean flag) {
			super(f, title, flag);
			this.f = f;

			setLayout(null);
			add(msg1L = new JLabel("저장된 여행일자별 장소를 받으실 이메일을 입력하세요. "));
			add(ta = new TextArea("이메일을 입력하세요",5,5,TextArea.SCROLLBARS_VERTICAL_ONLY));
			add(btnu = new JButton("네"));
			msg1L.setBounds(40, 20, 150, 25);
			msg1L.setFont(new Font("맑은고딕", Font.BOLD, 13));
			ta.setBounds(100, 50, 300, 30);
			btnu.setBounds(220, 100, 80, 30);
			btnu.setBackground(Color.WHITE);
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
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}	
	
//////////////////////////저장/////////////////////////////////////////////////
	class MSave extends JDialog implements ActionListener {

		int width = 200;
		int height = 145;
		JButton btnu, btn;
		JLabel msg1L;
		Frame f;

		public MSave(Frame f, String title, String msg, boolean flag) {
			super(f, title, flag);
			this.f = f;

			setLayout(null);
			add(msg1L = new JLabel("저장하시겠습니까?"));
			add(btnu = new JButton("네"));
			add(btn = new JButton("아니오"));

			msg1L.setBounds(40, 20, 150, 25);
			msg1L.setFont(new Font("맑은고딕", Font.BOLD, 13));
			btnu.setBackground(Color.WHITE);
			btn.setBackground(Color.WHITE);

			btn.setBounds(10, 65, 80, 30);
			btn.addActionListener(this);

			btnu.setBounds(100, 65, 80, 30);
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
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}	
////////////////////////////쪽지보내기///////////////////////////
	public void sendMessage(String msg) {
		out.println(msg);
	}

	class Message extends Frame implements ActionListener {

		Button send, close;
		TextField name;
		TextArea ta;
		String mode;// to/from
		String id = "aaa";
		Vector<NoteBean> vlist;
		NoteMgr mgr;
		int date;
		Frame f;
		int width = 300;
		int height = 110;

		public Message(String mode) {
			setTitle("쪽지보내기");
			this.mode = mode;
			layset("");
			validate();
		}

		public void layset(String msg) {
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					dispose();
				}
			});
			Panel p1 = new Panel();
			p1.add(new Label(mode, Label.CENTER));
			name = new TextField(id, 20);
			p1.add(name); 
			add(BorderLayout.NORTH, p1);

			ta = new TextArea("");
			add(BorderLayout.CENTER, ta);
			ta.setText(msg);
			Panel p2 = new Panel();
			if (mode.equals("TO:")) {
				p2.add(send = new Button("send"));
				send.addActionListener(this);
			}
			p2.add(close = new Button("close"));
			close.addActionListener(this);
			add(BorderLayout.SOUTH, p2);

			setBounds(850, 500, 250, 250);
			setVisible(true);
		}

		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();

			if (obj == send) { /* 보내기 & 저장 */
				/*
				 * NoteBean bean = new NoteBean(); bean.setSid(id); // 보낸사람
				 * bean.setRid(name.getText()); // 받는사람 bean.setNote(ta.getText());//내용
				 * //bean.setNdate(date);//날짜
				 */
			}
			validate();
			setVisible(false);
			dispose();
		}
	}

	class MBack extends JDialog implements ActionListener {

		int width = 200;
		int height = 145;
		JButton btnu, btn;
		JLabel msg1L;
		Frame f;

		public MBack(Frame f, String title, String msg, boolean flag) {
			super(f, title, flag);
			this.f = f;

			setLayout(null);
			add(msg1L = new JLabel("뒤로 가겠습니까?"));
			add(btnu = new JButton("네"));
			add(btn = new JButton("아니오"));

			msg1L.setBounds(40, 20, 150, 25);
			msg1L.setFont(new Font("맑은고딕", Font.BOLD, 13));
			btnu.setBackground(Color.WHITE);
			btn.setBackground(Color.WHITE);

			btn.setBounds(10, 65, 80, 30);
			btn.addActionListener(this);

			btnu.setBounds(100, 65, 80, 30);
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
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}

	class MDialog1 extends JDialog implements ActionListener {

		Checkbox cb1_1, cb1_2, cb1_3, cb1_4, cb1_5;
		Checkbox ch[] = new Checkbox[5];
		String str[] = { "무박", "1일차", "2일차", "3일차", "4일차" };
		CheckboxGroup cbg;
		int width = 300;
		int height = 130;
		Button save;
		Frame f;

		public MDialog1(Frame f, String title, String msg, boolean flag) {
			super(f, title, flag);
			this.f = f;
			setLayout(new FlowLayout());

			cbg = new CheckboxGroup();
			Panel p = new Panel();
			for (int i = 0; i < ch.length; i++) {
				p.add(ch[i] = new Checkbox(str[i], cbg, false));
			}
			add(p);
			add(save = new Button("SAVE"));
			save.addActionListener(this);
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
			String s = e.getActionCommand();
			String item = "";
			if (mode == 0)
				item = fi.getText();
			else if (mode == 1)
				item = fi4.getText();
			else if (mode == 2)
				item = fi7.getText();

			if (s.equals("SAVE")) {
				Checkbox cb = cbg.getSelectedCheckbox();
				if (cb == ch[0])
					li1.add(item);
				else if (cb == ch[1])
					li2.add(item);
				else if (cb == ch[2])
					li3.add(item);
				else if (cb == ch[3])
					li4.add(item);
				else if (cb == ch[4])
					li5.add(item);
			}
			dispose();
		}
	}

	public static void main(String[] args) {
		new Place();

	}

}
