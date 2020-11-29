package tib;

import java.awt.BorderLayout;
import java.awt.Button;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PrintWriter;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class More extends JFrame implements ActionListener { 

	ImageIcon busan, background, background2, profileUpload, site1, user1, user2, like, mail;

	JLabel labWelcome, labLogout, labelInfo1, labelClock1, labelDate1, labelD1, labelAge1, labGender1, labCount1, labLike,
			labMail, labCount, label, label1;//////여기 좋아요 Jlabel

	int count =0;

	TextArea ta, taInfo1, taClock1, taDate1, tad1, taAge1, taGender1, taCount1, taSite1, taReview1, taID, taTime;

	JButton btnLogo,btnLogout, btnLike, btnMail, button;

	List list, list0, list1, list2, list3, list4,liReview1;
	
	PrintWriter out;

	JButton btn[] = new JButton[4];
	
	Button welcomeBtn;
	TextField t1,t2,t3,t4;
	
	
	String str[] = {"등록하기","수정하기","삭제하기","뒤로가기"};
	
///////////////////////////////////////////이미지//////////////////
	public More() { // introduce것 내용 전부 긁어와야함 + 쪽지보내기 + 좋아요 버튼
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setTitle("Travle in Busan");
		busan = new ImageIcon("tib/busanwhite157.png");
		JPanel panelLogo = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(busan.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};
		profileUpload = new ImageIcon("tib/profileUpload.jpg");
		JPanel panelProfile = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(profileUpload.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};
		site1 = new ImageIcon("tib/site1.jpg");
		JPanel panelSite1 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(site1.getImage(), 0, 0, null);
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
		mail = new ImageIcon("tib/mail.png");
		JPanel panelMail = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(mail.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};
		user1 = new ImageIcon("tib/usermini.png");
		JPanel panelUser1 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(user1.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};
		user2 = new ImageIcon("tib/usermini.png");
		JPanel panelUser2 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(user1.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};
		background2 = new ImageIcon("tib/beige.png");
		JPanel panelBackground2 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background2.getImage(), 0, 0, null);
				setOpaque(false);

			}
		};
		background = new ImageIcon("tib/background1100.jpg");
		JPanel panelBackground = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background.getImage(), 0, 0, null);
				setOpaque(false);

			}
		};
		
		welcomeBtn = new Button();
		panelBackground.add(welcomeBtn = new Button("Welcome"));
		welcomeBtn.setBounds(1070,30,100,30);
		welcomeBtn.setBackground(new Color(0, 0, 0));
		welcomeBtn.setForeground(Color.WHITE);
		welcomeBtn.addActionListener(this);
	

		panelProfile.setLayout(null);
		panelProfile.setBounds(220, 100, 200, 200);
		add(panelProfile);
		panelBackground2.add(ta = new TextArea("같이갈 사람 구함"));
		ta.setBounds(520, 50, 550, 130);
		ta.setFocusable(false);
////////////////////////////각 기간 여행지 list 창///////////////////////////////////////	
		panelBackground2.add(t1 = new TextField("죽성성당")); //댓글이 달리는 list창
		t1.setBounds(220, 240, 150, 170);	
		
		panelBackground2.add(t2 = new TextField("오륙도")); //댓글이 달리는 list창
		t2.setBounds(400, 240, 150, 170);

		panelBackground2.add(t3 = new TextField("해동용궁사")); //댓글이 달리는 list창
		t3.setBounds(580, 240, 150, 170);
		
		panelBackground2.add(t4 = new TextField("일광해수욕장")); //댓글이 달리는 list창
		t4.setBounds(760, 240, 150, 170);
		
		/*
		 * panelBackground2.add(list0 = new List(6,false)); //댓글이 달리는 list창
		 * list0.setBounds(220, 240, 150, 170);
		 * 
		 * panelBackground2.add(list1 = new List(6,false)); //댓글이 달리는 list창
		 * list1.setBounds(400, 240, 150, 170);
		 * 
		 * panelBackground2.add(list2 = new List(6,false)); //댓글이 달리는 list창
		 * list2.setBounds(580, 240, 150, 170);
		 * 
		 * panelBackground2.add(list3 = new List(6,false)); //댓글이 달리는 list창
		 * list3.setBounds(760, 240, 150, 170);
		 */

		panelSite1.setLayout(null);
		panelSite1.setBounds(220, 510, 350, 170);
		add(panelSite1);

		panelBackground2.add(taSite1 = new TextArea("부산 여행이 혼자 인 30대 여자입니다. 부산에서 맛있는 음식 같이 먹을 먹방투어 할 사람 구합니다^^"));
		taSite1.setBounds(420, 450, 650, 120);
		taSite1.setFocusable(false);

		panelUser1.setLayout(null);
		panelUser1.setBounds(220, 740, 100, 100);
		add(panelUser1);
		
		panelUser2.setLayout(null);
		panelUser2.setBounds(220, 870, 100, 100);
		add(panelUser2);
		
		
		
///////////////////////////이부분 입니다///////////////////////////////////////////////////////

		//좋아요 사진의 버튼//
		btnLike = new JButton(like);
		btnLike.setBounds(40, 620, 30, 30);
		btnLike.setBackground(new Color(251, 246, 240));
		panelBackground2.add(btnLike);
		btnLike.addActionListener(this); 

		//label 좋아요
		labLike = new JLabel("좋아요 " + count);
		panelBackground2.add(labLike);
		labLike.setBounds(80, 620, 100, 30);
		labLike.setBackground(new Color(251, 246, 240));
	
		
///////////////////////////////////////////////////////////////////////////////////		
		
		
		//쪽지보내기 버튼//
		btnMail = new JButton(mail);
		btnMail.setBounds(190, 620, 30, 30);
		btnMail.setBackground(new Color(251, 246, 240));
		panelBackground2.add(btnMail);
		btnMail.addActionListener(this);

		Label labmail = new Label();
		panelBackground2.add(labmail = new Label("쪽지보내기"));
		labmail.setBounds(230, 620, 100, 30);
		labmail.setBackground(new Color(251, 246, 240));

		///버튼4개 위치////
		for (int i = 0; i < btn.length; i++) {
			panelBackground2.add(btn[i] = new JButton(str[i]));
			btn[i].addActionListener(this);
			btn[i].setBackground(new Color(251, 246, 240));
		}
		btn[0].setBounds(350, 620, 100, 30);
		btn[1].setBounds(470, 620, 100, 30);
		btn[2].setBounds(590, 620, 100, 30);
		btn[3].setBounds(710, 620, 100, 30);
		
		panelBackground2.add(taReview1 = new TextArea("댓글을 남겨주세요. (200자 이내)", 5, 5, TextArea.SCROLLBARS_VERTICAL_ONLY));
		taReview1.setBounds(190, 680, 880, 50);
		taReview1.setForeground(Color.GRAY);
		taReview1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {// MouseEvent이 부분 ctrl + space
				taReview1.setText("");
			}
		});
		
		panelBackground2.add(taID = new TextArea("작성ID", 5, 5, TextArea.SCROLLBARS_NONE));
		taID.setBounds(190, 800, 100, 20);
		taID.setForeground(Color.GRAY);
		
		panelBackground2.add(taTime = new TextArea("작성날짜", 5, 5, TextArea.SCROLLBARS_NONE));
		taTime.setBounds(320, 800, 100, 20);
		taTime.setForeground(Color.GRAY);
		
		panelBackground2.add(liReview1 = new List(5,false)); //댓글확인할 수 있는 list창
		liReview1.setBounds(190, 830, 880, 50);		
		
////////////////////////////////////////////////////////////////////////////////////////////////////////
		Label labelinfo = new Label(); 
		panelBackground2.add(labelinfo = new Label("닉네임"));
		labelinfo.setBounds(280, 20, 50, 23);
		labelinfo.setBackground(new Color(251,246,240));
	
		
		panelBackground2.add(taInfo1 =new TextArea("멍뭉이", 5 ,5, TextArea.SCROLLBARS_NONE));
		taInfo1.setBounds(350, 20, 140, 23);
		taInfo1.setFocusable(false);
		
		Label labelclock = new Label(); 
		panelBackground2.add(labelclock = new Label("기간"));
		labelclock.setBounds(280, 50, 50, 23);
		labelclock.setBackground(new Color(251,246,240));

		
		panelBackground2.add(taClock1 =new TextArea("1박2일", 5 ,5, TextArea.SCROLLBARS_NONE));
		taClock1.setBounds(350, 50, 140, 23);
		taClock1.setFocusable(false);
		
		Label labeldate = new Label(); 
		panelBackground2.add(labeldate = new Label("여행일자"));
		labeldate.setBounds(280, 80, 50, 23);
		labeldate.setBackground(new Color(251,246,240));
		
		panelBackground2.add(taDate1 =new TextArea("2020-11-21", 5 ,5, TextArea.SCROLLBARS_NONE));
		taDate1.setBounds(350, 80, 140, 23);
		taDate1.setFocusable(false);	
		
		Label labeld= new Label(); 
		panelBackground2.add(labeld = new Label("구별"));
		labeld.setBounds(280, 110, 50, 23);
		labeld.setBackground(new Color(251,246,240));
		
		panelBackground2.add(tad1 =new TextArea("진구", 5 ,5, TextArea.SCROLLBARS_NONE));
		tad1.setBounds(350, 110, 140, 23);
		tad1.setFocusable(false);
		
		Label labelage = new Label(); 
		panelBackground2.add(labelage = new Label("희망연령"));
		labelage.setBounds(280, 140, 50, 23);
		labelage.setBackground(new Color(251,246,240));
		
		panelBackground2.add(taAge1 =new TextArea("30대", 5 ,5, TextArea.SCROLLBARS_NONE));
		taAge1.setBounds(350, 140, 140, 23);
		taAge1.setFocusable(false);
		
		Label labsex = new Label(); 
		panelBackground2.add(labsex = new Label("성별"));
		labsex.setBounds(280, 170, 50, 23);
		labsex.setBackground(new Color(251,246,240));
		
		panelBackground2.add(taGender1 =new TextArea("여", 5 ,5, TextArea.SCROLLBARS_NONE));
		taGender1.setBounds(350, 170, 140, 23);
		taGender1.setFocusable(false);
		
		Label labcount = new Label(); 
		panelBackground2.add(labcount = new Label("희망인원"));
		labcount.setBounds(280, 200, 50, 23);
		labcount.setBackground(new Color(251,246,240));
			
		panelBackground2.add(taCount1 =new TextArea("2명~3명", 5 ,5, TextArea.SCROLLBARS_NONE));
		taCount1.setBounds(350, 200, 140, 23);
/////////////////////////////////////////////////////////////////////////////////////
		btnLogo = new JButton(busan);
		btnLogo.setBounds(180, 20, 180, 50);
		btnLogo.setBackground(new Color(0, 0, 0));
		panelBackground.add(btnLogo);
		btnLogo.addActionListener(this);

		btnLogout = new JButton("Logout");
		btnLogout.setBounds(1200, 30, 90, 30);
		btnLogout.setBackground(new Color(0, 0, 0));
		panelBackground.add(btnLogout);
		btnLogout.addActionListener(this);
		
		panelBackground2.setLayout(null);
		panelBackground2.setBounds(180, 80, 1100, 1100);
		add(panelBackground2);

		panelBackground.setLayout(null);
		panelBackground.setBounds(0, 0, 1500, 1100);
		add(panelBackground);
//////////////////////////////폰트//////////////////////////////////////
		Font top = new Font("맑은고딕", Font.BOLD, 15);
		Font day = new Font("맑은고딕", Font.BOLD, 20);

		btnLogout.setFont(top);

		btnLogout.setForeground(Color.WHITE);
		liReview1.setFont(day);
		
		setSize(1500, 1100);
		setVisible(true);
		validate();
		setLocationRelativeTo(null);
	}
//////////////////////////////Logout 버튼//////////////////////////////////////////
	class MLogout extends JDialog implements ActionListener {
		int width = 200;
		int height = 145;
		JButton btnu;
		JLabel msg1L;
		Frame f;

		public MLogout(Frame f, String title, String msg, boolean flag) {
			super(f, title, flag);
			this.f = f;
			int xmsg = msg.length();

			setLayout(null);
			add(msg1L = new JLabel("Logout 하시겠습니까?"));
			add(btnu = new JButton("확인"));
			msg1L.setBounds(30, 20, 150, 25);

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
///////////////////////////////////////////////이부분 입니다/////////////////////////
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String cmd = e.getActionCommand();
		
		if (cmd.equals(str[0]) || ta ==e.getSource()) {///등록하기
			String item = taReview1.getText(); 
			new MUpdate(this, "알림", "", true);			
			liReview1.add(item); 
			ta.setText(""); 
			ta.requestFocus(); 
		} else if (cmd.equals(str[1]) || ta ==e.getSource()) {//수정하기 ----------> 수정하는 기능 찾기이거 기능을 못찾겠다..
			new MModi(this, "알림", "", true);
			String item = taReview1.getText(); 	
			liReview1.add(item); 
			ta.setText(""); 
			ta.requestFocus();
		} else if (cmd.equals(str[2]) || ta ==e.getSource()) {//삭제하기
			new MDelete(this, "알림", "", true);
			int idx = liReview1.getSelectedIndex();
			liReview1.remove(idx);
		} else if (cmd.equals(str[3]) || ta ==e.getSource()) {//나가기
			this.setVisible(false);
			JFrame frame = new Mate();
			frame.setVisible(true);
		} else if (btnMail == obj) { // 쪽지보내기
			new Message("TO:");
		} else if (btnLogo == obj) { // 로고 누르면 메인페이지로 이동
			this.setVisible(false);
			JFrame frame = new Choose();
			frame.setVisible(true);
		} else if(e.getSource()==btnLike) { // 좋아요 버튼
			String str = labLike.getText();//str
			System.out.println(str);//str
			count =  Integer.parseInt(str.replace("좋아요 ",  ""));//count
			count++;//count
			labLike.setText("좋아요 " + count);//str+count
		} else if (welcomeBtn == obj) { // 로고 누르면 메인페이지로 이동
			Choose Choose = new Choose();
			Choose.setVisible(true);
		}
	
		taReview1.setText("");
		taReview1.requestFocus(); 
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
			
			if(obj==send) { /*보내기 & 저장*/
				/*NoteBean bean = new  NoteBean();
				bean.setSid(id); // 보낸사람
				bean.setRid(name.getText()); // 받는사람
				bean.setNote(ta.getText());//내용
				//bean.setNdate(date);//날짜*/
			}
			validate();
			setVisible(false);
			dispose();
		}
	}
////////////////////////////등록하기 버튼///////////////////////////////////
	class MUpdate extends JDialog implements ActionListener {
		int width = 200;
		int height = 145;
		JButton btnu;
		JLabel msg1L;
		Frame f;

		public MUpdate(Frame f, String title, String msg, boolean flag) {
			super(f, title, flag);
			this.f = f;
			int xmsg = msg.length();

			setLayout(null);
			add(msg1L = new JLabel("등록을 하시겠습니까?"));
			add(btnu = new JButton("확인"));
			msg1L.setBounds(30, 20, 150, 25);

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
/////////////////////////////수정하기 버튼///////////////////////////////////
	class MModi extends JDialog implements ActionListener {

		int width = 200;
		int height = 145;
		JButton btnu;
		JLabel msg1L;
		Frame f;

		public MModi(Frame f, String title, String msg, boolean flag) {
			super(f, title, flag);
			this.f = f;
			int xmsg = msg.length();

			setLayout(null);
			add(msg1L = new JLabel("수정 하시겠습니까?"));
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
//////////////////////////////삭제하기 버튼/////////////////////////////////
	class MDelete extends JDialog implements ActionListener {

		int width = 200;
		int height = 145;
		JButton btnu;
		JLabel msg1L;
		Frame f;

		public MDelete(Frame f, String title, String msg, boolean flag) {
			super(f, title, flag);
			this.f = f;
			int xmsg = msg.length();

			setLayout(null);
			add(msg1L = new JLabel("삭제 하시겠습니까?"));
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
/////////////////////////돌아가기 버튼//////////////////////////////////////
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
			add(msg1L = new JLabel("나가시겠습니까?"));
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

	public static void main(String[] args) {
		new More();
	}
}
