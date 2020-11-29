package tib;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;

import tib.Mate.MDialog;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Introduce extends JFrame implements ActionListener { 
	
	ImageIcon  busan, background, background2, profileUpload, site1, site2;
	
	JLabel labWelcome,labLogout, labLike, labMail, labText1;
	
	TextArea ta1, ta2, ta3, taInfo, taClock, taDate, taD, taAge,taGender,taCount,taToday0;
	
	TextField tfSite0,t1,t2,t3,t4;
	
	JButton btnLogo,btnU, btnLogout;
	
	Button welcomeBtn;
	
	Label labDay, labelInfo,labelClock, labelDate, labelD, labelAge, labGender, labCount;
	
	List list0, list1, list2, list3, list4;
	DesignMgr mgr = null;
	static int dcode;
	DesignBean bean;
	Vector<DesignBean> vlist = null;
	
	

	
	public Introduce(int dcode) {
		mgr = new DesignMgr();
		bean = mgr.getDesign(dcode);

		
		
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
	
		background2 = new ImageIcon("tib/beige.png");
		JPanel panelBackground2 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background2.getImage(), 0, 0, null);		
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
/////////////////////////////이미지 위치//////////////////////////////////////////////////
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
		
		panelProfile.setLayout(null);
		panelProfile.setBounds(500, 100, 200, 200);
		add(panelProfile);	

		///////////////////////////////////////////////////////////////////////////////////////////////////////
		Label labelinfo = new Label(); 
		panelBackground2.add(labelinfo = new Label("닉네임"));
		labelinfo.setBounds(530, 20, 50, 23);
		labelinfo.setBackground(new Color(251,246,240));
	
		
		panelBackground2.add(taInfo =new TextArea("멍뭉이", 5 ,5, TextArea.SCROLLBARS_NONE));
		taInfo.setBounds(610, 20, 140, 23);
		taInfo.setFocusable(false);
		
		Label labelclock = new Label(); 
		panelBackground2.add(labelclock = new Label("기간"));
		labelclock.setBounds(530, 50, 50, 23);
		labelclock.setBackground(new Color(251,246,240));

		
		panelBackground2.add(taClock =new TextArea("1박2일", 5 ,5, TextArea.SCROLLBARS_NONE));
		taClock.setBounds(610, 50, 140, 23);
		taClock.setFocusable(false);
		
		Label labeldate = new Label(); 
		panelBackground2.add(labeldate = new Label("여행일자"));
		labeldate.setBounds(530, 80, 50, 23);
		labeldate.setBackground(new Color(251,246,240));
		
		panelBackground2.add(taDate =new TextArea("2020-11-21", 5 ,5, TextArea.SCROLLBARS_NONE));
		taDate.setBounds(610, 80, 140, 23);
		taDate.setFocusable(false);	
		
		Label labeld= new Label(); 
		panelBackground2.add(labeld = new Label("구별"));
		labeld.setBounds(530, 110, 50, 23);
		labeld.setBackground(new Color(251,246,240));
		
		panelBackground2.add(taD =new TextArea("진구", 5 ,5, TextArea.SCROLLBARS_NONE));
		taD.setBounds(610, 110, 140, 23);
		taD.setFocusable(false);
		
		Label labelage = new Label(); 
		panelBackground2.add(labelage = new Label("희망연령"));
		labelage.setBounds(530, 140, 50, 23);
		labelage.setBackground(new Color(251,246,240));
		
		panelBackground2.add(taAge =new TextArea("30대", 5 ,5, TextArea.SCROLLBARS_NONE));
		taAge.setBounds(610, 140, 140, 23);
		taAge.setFocusable(false);
		
		Label labsex = new Label(); 
		panelBackground2.add(labsex = new Label("성별"));
		labsex.setBounds(530, 170, 50, 23);
		labsex.setBackground(new Color(251,246,240));
		
		panelBackground2.add(taGender =new TextArea("여", 5 ,5, TextArea.SCROLLBARS_NONE));
		taGender.setBounds(610, 170, 140, 23);
		taGender.setFocusable(false);
		
		Label labcount = new Label(); 
		panelBackground2.add(labcount = new Label("희망인원"));
		labcount.setBounds(530, 200, 50, 23);
		labcount.setBackground(new Color(251,246,240));
			
		panelBackground2.add(taCount =new TextArea("2명~3명", 5 ,5, TextArea.SCROLLBARS_NONE));
		taCount.setBounds(610, 200, 140, 23);
///////////////////////////////////각 기간 여행지 list 창///////////////////////
		panelBackground2.add(t1 = new TextField("죽성성당")); //댓글이 달리는 list창
		t1.setBounds(220, 240, 150, 170);	
		
		panelBackground2.add(t2 = new TextField("오륙도")); //댓글이 달리는 list창
		t2.setBounds(400, 240, 150, 170);

		panelBackground2.add(t3 = new TextField("해동용궁사")); //댓글이 달리는 list창
		t3.setBounds(580, 240, 150, 170);
		
		panelBackground2.add(t4 = new TextField("일광해수욕장")); //댓글이 달리는 list창
		t4.setBounds(760, 240, 150, 170);
		////////////////////////////////////////////////////////////////////////////////////////////////////
		panelBackground2.add(ta1 =new TextArea("부산 여행이 혼자 인 30대 여자입니다. 부산에서 맛있는 음식 같이 먹을 먹방투어 할 사람 구합니다^^", 5 ,5, TextArea.SCROLLBARS_VERTICAL_ONLY));
		ta1.setBounds(290, 430, 550, 130);
		ta1.setForeground(Color.BLACK);
		ta1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {// MouseEvent이 부분 ctrl + space
				ta1.setText("");
			}
		});
		
	
///////////////////////////////////////////////////////////////////////////////////////
		panelBackground2.setLayout(null);
		panelBackground2.setBounds(180,80,1100,620);
		add(panelBackground2);
		
		panelBackground.setLayout(null);
		panelBackground.setBounds(0,0,1500,1100);
		add(panelBackground);
//////////////////////////////폰트///////////////////////////////////////////////		
		Font top = new Font("맑은고딕",Font.BOLD,15);
		Font day = new Font("맑은고딕",Font.BOLD,20);
		btnLogout.setFont(top);
		btnLogout.setForeground(Color.WHITE);
		btnU = new JButton("등록하기");
		btnU.setBounds(500,575,100,30);
		btnU.setBackground(new Color(251,246,240));
		panelBackground2.add(btnU);
		btnU.addActionListener(this);
		
		setSize(1500,800);
		setVisible(true);
		validate();
		setLocationRelativeTo(null);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String item1 = ta1.getText();
		Object obj = e.getSource();
		if(btnLogout == obj) { // 로그아웃 버튼
			MDialog2 jd2 = new MDialog2(this, "알림", "Logout 하시겠습니까?", true);
			int width = 210;
			int height = 150;
			int px = getX();
			int py = getY();
			int x = px+getWidth()/2-width/2;
			int y = py+getHeight()/2-height/2;
			jd2.setBounds(x, y, width, height);
			jd2.setVisible(true);	
			this.setVisible(false);
			Login Login = new Login();
			Login.setVisible(true);
		} else if (obj == btnLogo) {
			this.setVisible(false);
			Choose Choose = new Choose();
			Choose.setVisible(true);
		}else if(item1.trim().length()==0) {// 입력을 한 값이 공백이라면 , trim 빈값을 제거시키는 기능 
			MDialog jd = new MDialog(this, "알림", "본인 소개글은 꼭 입력해주세요.", true);
			int width = 250;
			int height = 150;
			int px = getX();
			int py = getY();
			int x = px+getWidth()/2-width/2;
			int y = py+getHeight()/2-height/2;
			jd.setBounds(x, y, width, height);
			jd.setVisible(true);
		}else if(item1.length()>500){
			MDialog jd = new MDialog(this, "알림", "500자 미만으로 작성해주세요.", true);
			int width = 250;
			int height = 150;
			int px = getX();
			int py = getY();
			int x = px+getWidth()/2-width/2;
			int y = py+getHeight()/2-height/2;
			jd.setBounds(x, y, width, height);
			jd.setVisible(true);
		}else if(item1.length()<50){
			MDialog jd = new MDialog(this, "알림", "50자 이상으로 작성해주세요.", true);
			int width = 250;
			int height = 150;
			int px = getX();
			int py = getY();
			int x = px+getWidth()/2-width/2;
			int y = py+getHeight()/2-height/2;
			jd.setBounds(x, y, width, height);
			jd.setVisible(true);
		}else if (welcomeBtn == obj) { //choose 페이지로 안넘어가짐...
			//Choose Choose = new Choose();
			//Choose.setVisible(true);
		}else {
			MDialog jd = new MDialog(this, "알림", "등록이 완료되었습니다.", true);
			int width = 250;
			int height = 150;
			int px = getX();
			int py = getY();
			int x = px+getWidth()/2-width/2;
			int y = py+getHeight()/2-height/2;
			jd.setBounds(x, y, width, height);
			jd.setVisible(true);
			}
		ta1.setText(""); // 빈값으로 초기화 시킨다. // 자리만 차지하고 값은 없는것 -> 문자를 입력하세요 
		ta1.requestFocus(); // 포커스를 가져온다. 
	}
	/*
	 * public void updateForm(DesignBean bean) {
	 * 
	 * idx = bean.getIdx(); taClock =new TextArea(bean.getPeriod()); taDate =new
	 * TextArea(bean.getDdate()); taD =new TextArea(bean.getArea()); taAge =new
	 * TextArea(bean.getDage()); taGender =new TextArea(bean.getGender()); taCount
	 * =new TextArea(bean.getNump());//체크박스에 성별넣기 //체크바스에 위의 스트링 넣기 }
	 */
	

class MDialog extends JDialog implements ActionListener{
		
		Button btnu;
        JLabel msgL; 
		public MDialog(Frame f, String title, String msg,boolean flag) {
			super(f, title, flag);
			setLayout(null);
			add(msgL =new JLabel(msg));
			add(btnu = new Button("확인"));
			msgL.setBounds(35, 20,200,30);
			btnu.setBounds(80,60,70,30);
			btnu.addActionListener(this); 
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			  dispose();		
		}
	}


class MDialog2 extends JDialog implements ActionListener{
	
	Button btnYes,btnNo;
    JLabel msgL; 
	public MDialog2(Frame f, String title, String msg,boolean flag) {
		super(f, title, flag);
		setLayout(null);
		add(msgL =new JLabel(msg));
		add(btnYes = new Button("네"));
		add(btnNo = new Button("아니오"));
		msgL.setBounds(35, 20,200,30);
		btnYes.setBounds(30,60,50,30);
		btnNo.setBounds(110,60,50,30);
		btnYes.addActionListener(this); 
		btnNo.addActionListener(this); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}
	
}
	
public static void main(String[] args) {
	new Introduce(dcode);
}
}
	
	
	
	
	
	
	
	
	
	
	
	








