package tib;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.List;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class Info extends JFrame implements ActionListener {

	JLabel lab1, lab2, lab3, lab4, lab5, lab6, lab7, lab8;
	ImageIcon busan, background, background2, bts, bts1, map, site1,site2,site3;
	JButton btn1, btfn, btna, btnb, btnmap, btnLogout, btnLogo;
	TextField fi, fi2, fi3, fi4, fi5, fi6, fi7, fi8, fi9,fi0;
	TextArea ta1, ta2, ta3, ta4, ta5, ta6;
	List list;
	String food[] = { "짜장면", "짬뽕", "우동" };
	Button logoutBtn,wel;
	Place place;
	Choose choose;
	Login login;
	TibMap tibMap;
	
	int UC_SEQ;
	URL url = null;
	TibMapMgr mgr = null;
	int position = 1; 
	Vector<TravelBean> vlist = null;
	TravelBean bean;
	WeatherBean wbean;
	RssReadMgr mgr1;
	Image skyImg, ptyImg;

	
	public Info(int UC_SEQ) {
		try {
			mgr = new TibMapMgr();
			mgr1 = new RssReadMgr();
			wbean = mgr1.getTownForecast(UC_SEQ);
			
			
			this.UC_SEQ = UC_SEQ;
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
			map = new ImageIcon("tib/map.png");
			JPanel panelMap = new JPanel() {
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
			background = new ImageIcon("tib/background1100.jpg");
			JPanel panelBackground = new JPanel() {
				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(background.getImage(), 0, 0, null);
					setOpaque(false);// 바깥배경
				}
			};
///////////////////////////여기추가//////////////////////////////////////////////////////////////////////////////

			bean = mgr.getTravel(UC_SEQ);

			url = new URL("https://www.visitbusan.net/" + bean.getMAIN_IMG_THUMB());

			site1 = new ImageIcon(url);
			JPanel panelSite1 = new JPanel() {
				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(site1.getImage(), 0, 0, null);
					setOpaque(false);// 바깥배경
				}
			};
			panelSite1.setLayout(null);
			panelSite1.setBounds(220, 120, 417, 320);
			add(panelSite1);
			
//////////////////////////////////////////////////////////////////////////////////////////////////////////
			//소개글이 안나온다...
			
			panelBackground2.add(ta1 = new TextArea(bean.getITEMCNTNTS(), 5, 5, TextArea.SCROLLBARS_VERTICAL_ONLY));
			ta1.setBounds(40, 390, 1020, 330);
			
			
			
			///////// 지도버튼
			panelBackground2.add(btnmap = new JButton(map));
			btnmap.setBounds(857, 95, 45, 45);
			btnmap.setBackground(new Color(251, 246, 240));
			btnmap.addActionListener(this);

			panelBackground2.add(btna = new JButton("이전"));
			btna.setBounds(500, 750, 100, 30);
			btna.addActionListener(this);

			panelBackground2.add(lab6 = new JLabel("위치 보기"));
			lab6.setBounds(850, 65, 500, 30);
			
			panelBackground2.add(lab7 = new JLabel("이용가능 날짜 시간"));
			lab7.setBounds(480, 250, 150, 30);
			
			panelBackground2.add(ta6 = new TextArea(bean.getUSAGE_DAY_WEEK_AND_TIME(),5,5,TextArea.SCROLLBARS_VERTICAL_ONLY));
			ta6.setBounds(480, 280, 530, 80);
			
			
			/*
			 * panelLogo.setLayout(null); panelLogo.setBounds(180, 20, 180, 50);
			 * add(panelLogo); add(panelLogo);
			 */

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

			panelBackground2.setLayout(null);
			panelBackground2.setBounds(180, 80, 1100, 800);
			panelBackground2.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 5), "★"));
			panelBackground2.setBackground(new Color(0, 0, 0, 50));
			add(panelBackground2);

			panelBackground.setLayout(null);
			panelBackground.setBounds(0, 0, 1500, 1000);
			add(panelBackground);

			Font title = new Font("맑은고딕", Font.BOLD, 30);
			Font list = new Font("맑은고딕", Font.BOLD, 15);
			Font top = new Font("맑은고딕", Font.BOLD, 12);

			ta1.setFont(list);
			lab6.setFont(list);
			lab7.setFont(list);
			ta6.setFont(list);
			
			btna.setBackground(Color.WHITE);
			btnLogout.setFont(top);
			btnLogout.setForeground(Color.WHITE);

			setSize(1500, 1000);
			setVisible(true);
			validate();
			
			setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		if (btna == obj) {
			new MBack(this, "알림", "", true);
			this.setVisible(false);
			place = new Place();
			place.setVisible(true);
		} else if (btnmap == obj) {
			tibMap = new TibMap(UC_SEQ);
		} else if (btnLogout == obj) {
			this.setVisible(false);
			login = new Login();
			login.setVisible(true);
		}else if (obj == btnLogo) {
			this.setVisible(false);
			Choose Choose = new Choose();
			Choose.setVisible(true);
			
		}
		
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(wbean!=null) {
			Font list = new Font("Dialog", Font.BOLD, 15);
			g.setColor(Color.BLACK);
			g.setFont(list);
			
			g.drawString("여행정보 : " + wbean.getMAIN_TITLE(), 660, 200);
			g.drawString("현재기온 : " + wbean.getTemp(), 660, 220);
			g.drawString("현재날씨 : " + wbean.getWfKor(), 660, 240);
			
			String sky = wbean.getSky();
			if (sky.equals("1")) {
                sky = "sunshine.png";
			} else if(sky.equals("2")) {
				sky = "sunny_cloudy1.png";
			}else if(sky.equals("3")) {
				sky = "sunny_cloudy2.png";
			}else if(sky.equals("4")) {
				sky = "over_cloudy.png";
			}
			
			System.out.println(sky);
			skyImg = Toolkit.getDefaultToolkit().getImage("tib/"+sky);
			g.drawString("하늘날씨 : ", 660, 280);
			g.drawImage(skyImg, 740, 260 ,this);
           
		
			String pty = wbean.getPty();
			if (pty.equals("0")) {
				pty = "no_rain.png";
			} else if(pty.equals("1")) {
				pty = "rain.png";
			}else if(pty.equals("2")) {
				pty = "rain_snow.png";
			}else if(pty.equals("3")) {
				pty = "snow.png";
			}
             
			System.out.println(pty);
			ptyImg = Toolkit.getDefaultToolkit().getImage("tib/"+pty);
			g.drawString("강수상태 : ",660, 330);
			g.drawImage(ptyImg, 740, 310 ,this);
			
				
		}
	}

	class MBack extends JDialog implements ActionListener {

		int width = 200;
		int height = 145;
		JButton btnu;
		JLabel msg1L;
		Frame f;
		int xmsg;

		public MBack(Frame f, String title, String msg, boolean flag) {
			super(f, title, flag);
			this.f = f;
			xmsg = msg.length();

			setLayout(null);
			add(msg1L = new JLabel("뒤로 가겠습니까?"));
			add(btnu = new JButton("yes"));

			msg1L.setBounds(40, 20, 150, 25);
			Font top = new Font("맑은고딕", Font.BOLD, 13);
			msg1L.setFont(new Font("맑은고딕", Font.BOLD, 13));
			btnu.setBackground(Color.WHITE);

			btnu.setBounds(60, 65, 60, 30);
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
}