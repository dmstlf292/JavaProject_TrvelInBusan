package tib;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Choose extends JFrame implements ActionListener {

	ImageIcon background, busan, background2;

	JLabel nameL, welL;
	JButton chReBtn, chFrBtn, btnLogout, btnLogo, reInfoBtn;// posdata(후기)
	Introduce duce;
	int dcode;

	public Choose() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setTitle("Travle in Busan");

		busan = new ImageIcon("tib/busanwhite157.png");
		JPanel panelLogowhite = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(busan.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};

		background = new ImageIcon("tib/background800.jpg");
		JPanel panelBackground = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background.getImage(), 0, 0, null);
				setOpaque(false);

			}
		};

		background2 = new ImageIcon("tib/background2.png");
		JPanel panelBackground2 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background2.getImage(), 0, 0, null);
				g.setColor(Color.BLACK);
				g.drawLine(200, 160, 870, 160);
				setOpaque(false);

			}
		};

//////////////////////////////////////////////////////////////////////////////////////////

		btnLogo = new JButton(busan);
		btnLogo.setBounds(180, 20, 180, 50);
		btnLogo.setBackground(new Color(0, 0, 0));
		panelBackground.add(btnLogo);
		btnLogo.addActionListener(this);

/// logo 사진이 제일 위에와야함//
		panelLogowhite.setLayout(null);
		panelLogowhite.setBounds(180, 20, 180, 50);
		add(panelLogowhite);

		Font top = new Font("맑은고딕", Font.BOLD, 15);
		Font top1 = new Font("맑은고딕", Font.BOLD, 40);
		Font top2 = new Font("맑은고딕", Font.BOLD, 40);
		Font top3 = new Font("맑은고딕", Font.BOLD, 25);

		reInfoBtn = new JButton();
		panelBackground.add(reInfoBtn = new JButton("내정보 수정"));
		reInfoBtn.setBounds(1050, 30, 120, 30);
		reInfoBtn.setBackground(new Color(0, 0, 0));
		reInfoBtn.setFont(top);
		reInfoBtn.setForeground(Color.WHITE);

		btnLogout = new JButton("Logout");
		btnLogout.setBounds(1190, 30, 90, 30);
		btnLogout.setBackground(new Color(0, 0, 0));
		panelBackground.add(btnLogout);
		btnLogout.setForeground(Color.WHITE);
		btnLogout.addActionListener(this);

		// background2 위치//
		panelBackground2.setLayout(null);
		panelBackground2.setBounds(180, 80, 1100, 620);
		add(panelBackground2);

		// background 패널 위치는 제일 하단에 위치//
		panelBackground.setLayout(null);
		panelBackground.setBounds(0, 0, 1500, 800);
		add(panelBackground);

		panelBackground2.add(nameL = new JLabel("멍뭉이"));
		nameL.setBounds(280, 100, 300, 50);
		nameL.setFont(top1);

		panelBackground2.add(welL = new JLabel("님 환영 합니다."));
		welL.setBounds(550, 100, 350, 50);
		welL.setFont(top2);

		panelBackground2.add(chReBtn = new JButton("<HTML><BODY><CENTER>여행 플래너가<br> 되고 싶어요</CENTER></BODY></HTML>"));
		chReBtn.setBounds(270, 260, 220, 220);
		chReBtn.setFont(top3);
		chReBtn.setBackground(Color.WHITE);

		panelBackground2.add(chFrBtn = new JButton("<HTML><BODY><CENTER>여행 친구를<br> 찾고 싶어요</CENTER></BODY></HTML>"));
		chFrBtn.setBounds(580, 260, 220, 220);
		chFrBtn.setFont(top3);
		chFrBtn.setBackground(Color.WHITE);

		
		///////////////////////// 이밴트 연결 //////////////////////
		reInfoBtn.addActionListener(this);
		btnLogout.addActionListener(this);
		chReBtn.addActionListener(this);
		chFrBtn.addActionListener(this);

		setSize(1500, 800);
		setVisible(true);
		validate();
		setLocationRelativeTo(null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (reInfoBtn == e.getSource()) {
           
			this.setVisible(false);
			Signin frame = new Signin(Login.id);// 회원가입
			frame.setVisible(true);
			return;
		} else if (btnLogout == e.getSource()) {
			new MBack(this, "알림", "", true);
			this.setVisible(false);
			Login Login = new Login();
			Login.setVisible(true);
		} else if (chReBtn == e.getSource()) {
			this.setVisible(false);
			Option frame = new Option();// 리더 클래스로 수정하기
			frame.setVisible(true);
			return;
		} else if (chFrBtn == e.getSource()) {
			DesignBean bean = new DesignBean();
			this.setVisible(false);
			
			duce = new Introduce(dcode);// 친구 클래스로 수정하기
			duce.setVisible(true);
			return;
		} 

	}// action

	class MBack extends JDialog implements ActionListener {

		int width = 200;
		int height = 145;
		JButton btnu, btn;
		JLabel msg1L;
		Frame f;

		public MBack(Frame f, String title, String msg, boolean flag) {
			super(f, title, flag);
			this.f = f;
			int xmsg = msg.length();

			setLayout(null);
			add(msg1L = new JLabel("Logout 하시겠습니까?"));
			add(btnu = new JButton("아니오"));
			add(btn = new JButton("네"));

			msg1L.setBounds(40, 20, 150, 25);
			Font top = new Font("맑은고딕", Font.BOLD, 13);
			msg1L.setFont(new Font("맑은고딕", Font.BOLD, 13));
			btnu.setBackground(Color.WHITE);
			btn.setBackground(Color.WHITE);

			btn.setBounds(10, 65, 80, 30);
			btn.addActionListener(this);

			btnu.setBounds(100, 65, 80, 30);
			btnu.addActionListener(this);

			/*
			 * JButton btnExit = new JButton("no"); btnExit.addActionListener(new
			 * ActionListener() { public void actionPerformed(ActionEvent arg0) {
			 * System.exit(0); } }); btnExit.setBounds(20, 55, 60, 30);
			 * getContentPane().add(btnExit); btnExit.setBackground(Color.WHITE);
			 */

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
			Object obj = e.getSource();
			if (btn == obj) {

			}
			dispose();
		}
	}
}
