package tib;

import java.awt.Graphics;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Container;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import javax.print.attribute.standard.JobOriginatingUserName;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


///클래스 "내정보수정" 버튼을 누르면 id와 닉네임은 비활성화 시켜놓아야함
//수정Signin클래스를 만들어야 할것 같음
public class Signin extends JFrame implements ActionListener {
	Vector<MemberBean> vlist1;
	
	ImageIcon background, busan, background2,profil,date;
	Button login, logoutBtn;
	JButton btnLogo;
	
	JLabel proL;
	JButton proCallBtn, proReBtn, proChBtn;
	FileDialog getImg;//이미지가져오기 
	ImagePanel panelProfil;
	
	JLabel lavel[];
	String lavelStr[] = {"닉네임","ID 입력", "PASS 입력","PASS 재입력","성별","생년월일","Email 주소","핸드폰번호"};
	JTextField nameTf;//닉네임
	JButton checkNBtn;//닉네임 중복확인
	
	JTextField idTf; //id입력하는 텍스트 필드 변수
	JButton checkIBtn;//id 중복확인
	
	JTextField passTf; //password입력하는 텍스트 필드 변수
	JButton checkPBtn;//password 확인
	JLabel passL;//패스워드 조건 알려주는 레이블
	
	JTextField passTf2; //password 재입력하는 텍스트 필드 변수
	JButton checkPBtn2;//password 재확인
	
	Choice genderC;
	String sGen[]= {"남","여"};
	
	JTextField birthTf; //생년월일 입력하는 텍스트 필드 변수
	JButton calBtn;//생년월일 선택하는 버튼
	Image calImg;//달력그림
	
	
	JTextField emailTf; //email 입력하는 텍스트 필드 변수
	
	
	JComboBox comboTel;//핸드폰 번호 입력
	JTextField telTf2; 
	JTextField telTf3; 
	JLabel bar1, bar2;
	
	JButton saveSiBtn,reInfoBtn;

	JPanel pMain;
	JPanel[] p;
	
	Signin signin;
	
	//db입력에 필요한 변후
	Vector<MemberBean> vlist;
	MemberMgr mgr;
	int idx;
	String id;

	
	public Signin(String id) {
		this.id=id;
		
		mgr = new MemberMgr(); 
		MemberBean bean = mgr.getMember(id);
		//System.out.println(bean.getEmail());
		idx = bean.getIdx();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setTitle("Travle in Busan");

		busan = new ImageIcon("tib/busanwhite157.png");
		JPanel panellogo = new JPanel() {
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
		

		background2 = new ImageIcon("tib/beige.png");
		JPanel panelBackground2 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background2.getImage(), 0, 0, null);
				setOpaque(false);

			}
		};

		/// logo 사진이 제일 위에와야함//
		panellogo.setLayout(null);
		panellogo.setBounds(180, 20, 180, 50);
		
		add(panellogo);
		
		Font top = new Font("맑은고딕",Font.BOLD,15);
		Font top2 = new Font("맑은고딕",Font.BOLD,12);
		Font top3 = new Font("맑은고딕",Font.BOLD,12);
		Font top4 = new Font("맑은 고딕" ,Font.BOLD,9 );
		
		btnLogo = new JButton(busan);
		btnLogo.setBounds(180, 20, 180, 50);
		btnLogo.setBackground(new Color(0, 0, 0));
		panelBackground.add(btnLogo);
		btnLogo.addActionListener(this);
		
		login = new Button();
		panelBackground.add(login = new Button("Login"));
		login.setBounds(1070,30, 90, 30); 
		login.setBackground(new Color(0, 0, 0));
		login.setFont(top);
		login.setForeground(Color.WHITE);
		
		
		logoutBtn = new Button();
		panelBackground.add(logoutBtn = new Button("Logout"));
		logoutBtn.setBounds(1190, 30, 90, 30);
		logoutBtn.setBackground(new Color(0, 0, 0));
		logoutBtn.setFont(top);
		logoutBtn.setForeground(Color.WHITE);
		
		
		
		// background2 위치//
		panelBackground2.setLayout(null);
		panelBackground2.setBounds(180, 80, 1100, 620);
		add(panelBackground2);

		// background 패널 위치는 제일 하단에 위치//
		panelBackground.setLayout(null);
		panelBackground.setBounds(0, 0, 1500, 800);
		add(panelBackground);
		
		panelBackground2.add(proL=new JLabel("사진 권장사이즈 200 X 200"));
		proL.setBounds(120, 330, 200,30);
		proL.setFont(top2);
		
		panelBackground2.add(proCallBtn = new JButton("이미지 불러오기"));
		proCallBtn.setBounds(70, 375, 125,30);
		proCallBtn.setBackground(Color.WHITE);
		
		panelBackground2.add(proReBtn = new JButton("수  정  하  기"));
		proReBtn.setBounds(200, 375, 125,30);
		proReBtn.setFont(top2);
		proReBtn.setBackground(Color.WHITE);

		
		
		int j = 100;
		lavel = new JLabel[8];
		for (int i = 0; i < lavel.length; i++) {
			panelBackground2.add(lavel[i] = new JLabel(lavelStr[i]));
			lavel[i].setBounds(470,j, 140, 30);
			lavel[i].setFont(top);
			j += 40;
		}
		
		panelBackground2.add(nameTf=new JTextField(bean.getName()));
		panelBackground2.add(checkNBtn= new JButton("중복확인"));
		nameTf.setBounds(610,100,200, 30);
		//nameTf.setEditable(false);
		checkNBtn.setBounds(820, 100, 100,30);
		checkNBtn.setBackground(Color.WHITE);
		//checkNBtn.setEnabled(false);

		nameTf.setFont(top2);
		nameTf.setForeground(Color.GRAY);
		checkNBtn.setFont(top2);
		
		
		
		panelBackground2.add(idTf=new JTextField(bean.getId()));
		panelBackground2.add(checkIBtn= new JButton("중복확인"));
		idTf.setBounds(610,140 ,200, 30);
		checkIBtn.setBounds(820, 140, 100,30);
		idTf.setFont(top2);
		idTf.setForeground(Color.GRAY);
		idTf.setEditable(false);
		checkIBtn.setFont(top2);
		checkIBtn.setBackground(Color.WHITE);
		checkIBtn.setEnabled(false);

		
		
		panelBackground2.add(passTf=new JTextField(bean.getPassword()));
		//passTf.setEchoChar('#');
		panelBackground2.add(checkPBtn= new JButton("확      인"));
		passTf.setBounds(610,179 ,200, 30);
		checkPBtn.setBounds(820, 179, 100,30);
		passTf.setFont(top2);
		checkPBtn.setFont(top2);
		checkPBtn.setBackground(Color.WHITE);

		panelBackground2.add( passL = new JLabel("비밀번호는 특수문자 영문대문자 1개이상 사용"));
		passL.setFont(top4);
		passL.setBounds(610,210, 300,10);
		
		
		panelBackground2.add(passTf2=new JTextField(bean.getPassword()));
		panelBackground2.add(checkPBtn2= new JButton("확      인"));
		passTf2.setBounds(610,221 ,200, 30);
		checkPBtn2.setBounds(820, 220, 100,30);
		passTf2.setFont(top2);
		checkPBtn2.setFont(top2);
		checkPBtn2.setBackground(Color.WHITE);

		
		genderC = new Choice();
		String gen = bean.getGender();                     //성별넣기
		if (gen.equals("남") ) {
			genderC.add(sGen[0]);
			genderC.add(sGen[1]);
			}else {genderC.add(sGen[1]);
			          genderC.add(sGen[0]);	}
		panelBackground2.add(genderC);
		genderC.setBounds(610,260,200,30);
		genderC.setFont(top2);
		genderC.setBackground(Color.WHITE);

		panelBackground2.add(birthTf=new JTextField(bean.getBirth()));//텍스트 필드 중간에 위치하게 하는 방법?
		birthTf.setBounds(610,300 ,170, 30);
		birthTf.setFont(top2);
				
		panelBackground2.add(calBtn = new JButton(new ImageIcon("tib/date.png")));
		calBtn.setBounds(780,300,30,30);
		calBtn.setFont(top2);
		calBtn.setBackground(Color.WHITE);
		
		panelBackground2.add(emailTf=new JTextField(bean.getEmail()));
		emailTf.setBounds(610,340 ,200, 30);
		emailTf.setFont(top2);
				
		JPanel p = new JPanel();
		p.setLayout(null);
		String ph = bean.getPhone();//핸드폰번호 넣기
		String arr[] = ph.split("-");
		String[] tel1 = { arr[0],"010", "011", "016", "017", "018", "019" };
		comboTel = new JComboBox(tel1);
		//String[] tel1 = { "010", "011", "016", "017", "018", "019" };
		//comboTel = new JComboBox(tel1);
		p.add(comboTel);
		comboTel.setBounds(0,0,60,30);
		comboTel.setBackground(Color.WHITE);
		comboTel.setFont(top2);
		
		p.add( bar1 =new JLabel("-"));
		bar1.setBounds(65,0,5,30);
		bar1.setBackground(Color.WHITE);
		bar1.setFont(top2);
		
		telTf2 = new JTextField(arr[1]);
		p.add(telTf2);
		telTf2.setBounds(75,0,55,30);
		telTf2.setBackground(Color.WHITE);
		telTf2.setFont(top2);
		
		p.add( bar2 =new JLabel("-"));
		bar2.setBounds(135,0,5,30);
		bar2.setBackground(Color.WHITE);
		bar2.setFont(top2);
		
		telTf3 = new JTextField(arr[2]);
		p.add(telTf3);
		telTf3.setBounds(145,0,55,30);
		telTf3.setBackground(Color.WHITE);
		telTf3.setFont(top2);
		
		panelBackground2.add(p);
		p.setBounds(610, 380, 200, 30);
		p.setBackground(Color.WHITE);
					
		panelBackground2.add(saveSiBtn = new JButton("내 정 보 저 장 하 기"));
		saveSiBtn.setBounds(350, 500, 200,40);
		saveSiBtn.setFont(top);
		saveSiBtn.setBackground(Color.WHITE);
		saveSiBtn.setEnabled(false);
		
		panelBackground2.add(reInfoBtn = new JButton("내 정 보 수 정 하 기"));
		reInfoBtn.setBounds(570, 500, 200,40);
		reInfoBtn.setFont(top);
		reInfoBtn.setBackground(Color.WHITE);
		
		//////////////이미지 파일 가져와서 넣기///////////////////
		panelProfil = new ImagePanel();
		panelBackground2.add(panelProfil);
		panelProfil.setBounds(95,110, 200, 200);
		
		String s="tib/user.png";
		 panelProfil.setPath(s);//이미지 판넬에 이미지를 가져온다
		 panelProfil.repaint();//이미지 판넬에 이미지를 그린다.
		
		getImg = new FileDialog(this,"이미지 선택",FileDialog.LOAD);
		
		///////////////////////////이밴트 연결//////////////////////
		proCallBtn.addActionListener(this);
		proReBtn.addActionListener(this);
		
		login.addActionListener(this);
		logoutBtn.addActionListener(this);
		
		calBtn.addActionListener(this);
		
		/////////////////diallog 창 띄우기 아직/////////////////////////////////////
       	checkNBtn.addActionListener(this);
		//checkIBtn.addActionListener(this);
		checkPBtn.addActionListener(this);
		checkPBtn2.addActionListener(this);
		reInfoBtn.addActionListener(this);
		
		setSize(1500, 800);
		setVisible(true);
		validate();
		setLocationRelativeTo(null);//판넬을 중간에 위치 시킨다. 
	}
	
	public Signin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setTitle("Travle in Busan");

		busan = new ImageIcon("tib/busanwhite157.png");
		JPanel panellogo = new JPanel() {
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
		
		background2 = new ImageIcon("tib/beige.png");
		JPanel panelBackground2 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background2.getImage(), 0, 0, null);
				setOpaque(false);

			}
		};
	//////////////////////////////////////////////////////////////////////////////////////////
			/// logo 사진이 제일 위에와야함//
		panellogo.setLayout(null);
		panellogo.setBounds(180, 20, 180, 50);
		
		add(panellogo);
		
		Font top = new Font("맑은고딕",Font.BOLD,15);
		Font top2 = new Font("맑은고딕",Font.BOLD,12);
		Font top3 = new Font("맑은고딕",Font.BOLD,12);
		Font top4 = new Font("맑은 고딕" ,Font.BOLD,9 );
		
		btnLogo = new JButton(busan);
		btnLogo.setBounds(180, 20, 180, 50);
		btnLogo.setBackground(new Color(0, 0, 0));
		panelBackground.add(btnLogo);
		btnLogo.addActionListener(this);
		
		login = new Button();
		panelBackground.add(login = new Button("Login"));
		login.setBounds(1070,30, 90, 30); 
		login.setBackground(new Color(0, 0, 0));
		login.setFont(top);
		login.setForeground(Color.WHITE);
				
		logoutBtn = new Button();
		panelBackground.add(logoutBtn = new Button("Logout"));
		logoutBtn.setBounds(1190, 30, 90, 30);
		logoutBtn.setBackground(new Color(0, 0, 0));
		logoutBtn.setFont(top);
		logoutBtn.setForeground(Color.WHITE);
				
		// background2 위치//
		panelBackground2.setLayout(null);
		panelBackground2.setBounds(180, 80, 1100, 620);
		add(panelBackground2);

		// background 패널 위치는 제일 하단에 위치//
		panelBackground.setLayout(null);
		panelBackground.setBounds(0, 0, 1500, 800);
		add(panelBackground);
		
		panelBackground2.add(proL=new JLabel("사진 권장사이즈 200 X 200"));
		proL.setBounds(120, 330, 200,30);
		proL.setFont(top2);
		
		panelBackground2.add(proCallBtn = new JButton("이미지 불러오기"));
		proCallBtn.setBounds(70, 375, 125,30);
		proCallBtn.setBackground(Color.WHITE);
		
		panelBackground2.add(proReBtn = new JButton("수  정  하  기"));
		proReBtn.setBounds(200, 375, 125,30);
		proReBtn.setFont(top2);
		proReBtn.setBackground(Color.WHITE);
		
		int j = 100;
		lavel = new JLabel[8];
		for (int i = 0; i < lavel.length; i++) {
			panelBackground2.add(lavel[i] = new JLabel(lavelStr[i]));
			lavel[i].setBounds(470,j, 140, 30);
			lavel[i].setFont(top);
			j += 40;
		}
		
		panelBackground2.add(nameTf=new JTextField("  10자 이내"));
		panelBackground2.add(checkNBtn= new JButton("중복확인"));
		nameTf.setBounds(610,100,200, 30);
		checkNBtn.setBounds(820, 100, 100,30);
		checkNBtn.setBackground(Color.WHITE);

		nameTf.setFont(top2);
		nameTf.setForeground(Color.GRAY);
		checkNBtn.setFont(top2);
		nameTf.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				nameTf.setText("");
			}
		});
				
		panelBackground2.add(idTf=new JTextField("  10자 이내"));
		panelBackground2.add(checkIBtn= new JButton("중복확인"));
		idTf.setBounds(610,140 ,200, 30);
		checkIBtn.setBounds(820, 140, 100,30);
		idTf.setFont(top2);
		idTf.setForeground(Color.GRAY);
		checkIBtn.setFont(top2);
		checkIBtn.setBackground(Color.WHITE);

		idTf.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				idTf.setText("");
			}
		});
		
		panelBackground2.add(passTf=new JTextField());
		//passTf.setEchoChar('#');
		panelBackground2.add(checkPBtn= new JButton("확      인"));
		passTf.setBounds(610,179 ,200, 30);
		checkPBtn.setBounds(820, 179, 100,30);
		passTf.setFont(top2);
		checkPBtn.setFont(top2);
		checkPBtn.setBackground(Color.WHITE);

		panelBackground2.add( passL = new JLabel("비밀번호는 특수문자 영문대문자 1개이상 사용"));
		passL.setFont(top4);
		passL.setBounds(610,210, 300,10);
				
		panelBackground2.add(passTf2=new JTextField());
		panelBackground2.add(checkPBtn2= new JButton("확      인"));
		passTf2.setBounds(610,221 ,200, 30);
		checkPBtn2.setBounds(820, 220, 100,30);
		passTf2.setFont(top2);
		checkPBtn2.setFont(top2);
		checkPBtn2.setBackground(Color.WHITE);
		
		genderC = new Choice();
		genderC.add(sGen[0]);
		genderC.add(sGen[1]);
		panelBackground2.add(genderC);
		genderC.setBounds(610,260,200,30);
		genderC.setFont(top2);
		genderC.setBackground(Color.WHITE);

		panelBackground2.add(birthTf=new JTextField("2020-11-11"));//텍스트 필드 중간에 위치하게 하는 방법?
		birthTf.setBounds(610,300 ,170, 30);
		birthTf.setFont(top2);
		
		//텍스트 필드위에 어떻게 달력 이미지가 이쓴 버튼 넣는지 모르겠음 - 못넣음
		panelBackground2.add(calBtn = new JButton(new ImageIcon("tib/date.png")));
		calBtn.setBounds(780,300,30,30);
		calBtn.setFont(top2);
		calBtn.setBackground(Color.WHITE);

		
		panelBackground2.add(emailTf=new JTextField(""));
		emailTf.setBounds(610,340 ,200, 30);
		emailTf.setFont(top2);
		
		
		JPanel p = new JPanel();
		p.setLayout(null);
		//p.setBackground(new Color(251, 246, 240));  ----> 여기 흰색 배경이 자꾸 생기는데 안없어져요
		String[] tel1 = { "010", "011", "016", "017", "018", "019" };
		comboTel = new JComboBox(tel1);
		p.add(comboTel);
		comboTel.setBounds(0,0,60,30);
		comboTel.setBackground(Color.WHITE);
		comboTel.setFont(top2);
		
		p.add( bar1 =new JLabel("-"));
		bar1.setBounds(65,0,5,30);
		bar1.setBackground(Color.WHITE);
		bar1.setFont(top2);
		

		telTf2 = new JTextField(4);
		p.add(telTf2);
		telTf2.setBounds(75,0,55,30);
		telTf2.setBackground(Color.WHITE);
		telTf2.setFont(top2);

		
		p.add( bar2 =new JLabel("-"));
		bar2.setBounds(135,0,5,30);
		bar2.setBackground(Color.WHITE);
		bar2.setFont(top2);
		
		telTf3 = new JTextField(4);
		p.add(telTf3);
		telTf3.setBounds(145,0,55,30);
		telTf3.setBackground(Color.WHITE);
		telTf3.setFont(top2);
		
		panelBackground2.add(p);
		p.setBounds(610, 380, 200, 30);
		p.setBackground(Color.WHITE);
				
		
		
		
		panelBackground2.add(saveSiBtn = new JButton("내 정 보 저 장 하 기"));
		saveSiBtn.setBounds(350, 500, 200,40);
		saveSiBtn.setFont(top);
		saveSiBtn.setBackground(Color.WHITE);


		panelBackground2.add(reInfoBtn = new JButton("내 정 보 수 정 하 기"));
		reInfoBtn.setBounds(570, 500, 200,40);
		reInfoBtn.setFont(top);
		reInfoBtn.setBackground(Color.WHITE);
		reInfoBtn.setEnabled(false);


		
		
		
		//////////////이미지 파일 가져와서 넣기///////////////////
		panelProfil = new ImagePanel();
		panelBackground2.add(panelProfil);
		panelProfil.setBounds(95,110, 200, 200);
		
		String s="tib/user.png";
		 panelProfil.setPath(s);//이미지 판넬에 이미지를 가져온다
		 panelProfil.repaint();//이미지 판넬에 이미지를 그린다.
		
		getImg = new FileDialog(this,"이미지 선택",FileDialog.LOAD);
		
		///////////////////////////이밴트 연결//////////////////////
		proCallBtn.addActionListener(this);
		proReBtn.addActionListener(this);
		
		login.addActionListener(this);
		logoutBtn.addActionListener(this);
		
		calBtn.addActionListener(this);
		
		/////////////////diallog 창 띄우기 아직/////////////////////////////////////
       	checkNBtn.addActionListener(this);
		checkIBtn.addActionListener(this);
		checkPBtn.addActionListener(this);
		checkPBtn2.addActionListener(this);
		saveSiBtn.addActionListener(this);
		
		
		setSize(1500, 800);
		setVisible(true);
		validate();
		setLocationRelativeTo(null);//판넬을 중간에 위치 시킨다. 
	}
/////////////이미지 가져오는 클래스////////
		
	class ImagePanel extends JPanel{
	
		Image image;
		Toolkit toolkit = getToolkit();//이미지를 가져오기 위해서 
		
		public void setPath(String src) {
			image = toolkit.getImage(src);//경로설정
		}
		
		public void paint(Graphics g) {
			g.clearRect(0,0,200,200);
			if(image != null)
				g.drawImage(image ,0,0,this);//경로가 들어왔을때 출력
		}
	
	}//ImagePanel클래스
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		
		
		if(proCallBtn==obj||proReBtn==obj) {//프로필 이미지 가져오기
			 getImg.setVisible(true);
			 String s=getImg.getDirectory()+getImg.getFile();
			 panelProfil.setPath(s);//이미지 판넬에 이미지를 가져온다
			 panelProfil.repaint();//이미지 판넬에 이미지를 그린다.
			 return;
		} else if (login==obj){//welcome 버튼을 누르면 choose 클래스로 넘어간다.
			this.setVisible(false);
			JFrame frame = new Login();
			frame.setVisible(true);
			return;
	   } else if (logoutBtn == obj){//logout 버튼을 누르면 종료된다.
		   this.setVisible(false);
		    Login Login = new Login();
		    Login.setVisible(true);
	   }else if (calBtn == obj){// 달력 버튼을 누르면 생년 월일을 선택할수 있다. 
		    new SwingCalendar4(this);//이렇게만 해도 JDatePicker가 호출됌
		   
	//////////////////////////dialog창 띄우기///////////////////////////////////////////////		
	   } else if (saveSiBtn == obj ||checkNBtn == obj||checkIBtn == obj||checkPBtn == obj
			   ||checkPBtn2 == obj||reInfoBtn==obj) {
		   String title="알림", msg1="", msg2="",
				 nameitem=nameTf.getText(),  iditem=idTf.getText(), passitem=passTf.getText(),
				 pass2item=passTf2.getText(), emailitem=emailTf.getText(),
				 tel1item=telTf2.getText(), tel2item=telTf3.getText(),birthItem=birthTf.getText();
		 
	        if(checkNBtn == obj) {   		
			   	 if (nameitem.trim().length() >10 || nameitem.trim().length() == 0 || nameitem.trim().equals("bean.name")
			   			 ||nameitem.equals("  10자 이내")){//닉네임 중복 확인
			   		msg1 = "사용할 수 없는 닉네임입니다.";
			   		msg2 = "다시 만들어 중복확인 해주세요";
		   			nameTf.requestFocus();
		   			}else {
		   				msg1 = "사용 가능한";
				   		msg2 = "닉네임 입니다. ";
				   		idTf.requestFocus();	
		   			}
			
			}else if(checkIBtn == obj) {	   	
			   	   if (iditem.trim().length() >10 || iditem.trim().length() == 0 ||iditem.trim().equals("bean.name")
			   			 ||iditem.equals("  10자 이내")){//ID 중복 확인
			   		   msg1 = "사용할 수 없는 ID입니다.";
			   		   msg2 = "다시 만들어 중복확인 해주세요";
			   		   idTf.requestFocus();
		   			}else {
		   				msg1 = "사용 가능한";
				   		msg2 = "ID입니다.";
				   		passTf.requestFocus();	
		   			}
			}else if(checkPBtn == obj) {   	   
			   	 if(passitem.trim().length() == 0) {//패스워드부분 공백인지 확인
			   		msg1 = "패스워드를 ";
			   		msg2 = "입력해 주세요";
			   		passTf.requestFocus();
			   	 } else {//대문자와 특수문자 사용 확인
			   		int count = 0;
			   		for(int i=0; i<passitem.length();i++ ) {//패스워드부분 특수문자있는지 확인
			   			char c = passitem.charAt(i);
			   			if(c=='~'||c=='@'||c=='#'||c=='$'||c=='%'||c=='^'||c=='&'||c=='*'||c=='!') {
			   			count ++;
			   			if(count == 1) break; //특수문자 1개 사용했으면 특수문자 for문 중지
			   			}//특수문자 if
			   		}//특수문자for
			   		if(count ==0) {//특수문자가 사용되지 않았으면
			   			msg1 = " 특수문자를";
			   			msg2 = "1개이상 사용해 주세요";
			   			passTf.requestFocus();
			   		}	else {//특수문자를 1개이상 사용했으면 대문자 사용 체크
				   			count =0;
				   			for(int j=0; j< passitem.length() ;j++) {
			   					char c= passitem.charAt(j);
			   					if('A'<= c && c<='Z') { // 인식안됌
			   						count ++;
			   						if(count ==1) break;
			   					}//대문자 만족하면 for문 벗어남
			   				}//대문자 for
					   		if(count==0)  {//대문자를 사용하지 않았으면
					   			msg1 = "영문 대문자를 ";
					   			msg2 = "1개이상 사용해 주세요.";
					   			passTf.requestFocus();
					   			}else {
						   		msg1 = "사용 가능한";
						   		msg2 = "비밀번호 입니다. ";
						   		passTf2.requestFocus();
						   		}	
				   		}//특수문자를 만족
			   	 
			  }//패스워드가 입력되었어면	 
			} else if(checkPBtn2==obj) { 
				if(pass2item.trim().length() == 0) {//패스워드부분 공백인지 확인
			   		msg1 = "패스워드를 ";
			   		msg2 = "입력해 주세요";
			   		passTf2.requestFocus();
			   	 }
				else if( !passitem.equals(pass2item)) {
			   		msg1 = "비밀번호가";
		   			msg2 = "일치하지 않습니다.";
		   			passTf2.requestFocus();
			   	 }else {
			   		 msg1 = "비밀번호가";
			   		 msg2 = "바르게 입력되었습니다. ";
			   		genderC.requestFocus();
			   	 }
			}else if(saveSiBtn == obj) {
				 if (nameitem.trim().length() >10 || nameitem.trim().length() == 0 || nameitem.trim().equals("bean.name")
						 ||nameitem.equals("  10자 이내")){//닉네임 중복 확인
				   		msg1 = "사용할 수 없는 닉네임입니다.";
				   		msg2 = "다시 만들어 중복확인 해주세요";
			   			nameTf.requestFocus();
			   	}else if (iditem.trim().length() >10 || iditem.trim().length() == 0 ||iditem.trim().equals("bean.name")
			   		 ||iditem.equals("  10자 이내")){//ID 중복 확인
					   msg1 = "사용할 수 없는 ID입니다.";
					   msg2 = "다시 만들어 중복확인 해주세요";
					   idTf.requestFocus();
				}else	 if(passitem.trim().length() == 0) {//패스워드부분 공백인지 확인
			   		msg1 = "패스워드를 ";
			   		msg2 = "입력해 주세요";
			   		passTf.requestFocus();
				} else  if(passitem.trim().length() != 0)  {//대문자와 특수문자 사용 확인
				   		int count = 0;
				   		for(int i=0; i<passitem.length();i++ ) {//패스워드부분 특수문자있는지 확인
				   			char c = passitem.charAt(i);
				   			if(c=='~'||c=='@'||c=='#'||c=='$'||c=='%'||c=='^'||c=='&'||c=='*'||c=='!') {
				   			count ++;
				   			if(count == 1) break; //특수문자 1개 사용했으면 특수문자 for문 중지
				   			}//특수문자 if
				   		}//특수문자for
				   		if(count ==0) {//특수문자가 사용되지 않았으면
				   			msg1 = " 특수문자를";
				   			msg2 = "1개이상 사용해 주세요";
				   			passTf.requestFocus();
				   		}	else {//특수문자를 1개이상 사용했으면 대문자 사용 체크
					   			count =0;
					   			for(int j=0; j< passitem.length() ;j++) {
				   					char c= passitem.charAt(j);
				   					if('A'<= c && c<='Z') { // 인식안됌
				   						count ++;
				   						if(count ==1) break;
				   					}//대문자 만족하면 for문 벗어남
				   				}//대문자 for
						   		if(count==0)  {//대문자를 사용하지 않았으면
						   			msg1 = "영문 대문자를 ";
						   			msg2 = "1개이상 사용해 주세요.";
						   			passTf.requestFocus();
						   			}else if(pass2item.trim().length() == 0) {//패스워드부분 공백인지 확인
								   		msg1 = "패스워드를 ";
								   		msg2 = "재입력해 주세요";
								   		passTf2.requestFocus();
								   	 }	else if( !passitem.equals(pass2item)) {
								   		msg1 = "비밀번호가";
							   			msg2 = "일치하지 않습니다.";
							   			passTf2.requestFocus();
								   	 } else	 if(birthItem.trim().length() == 0) {
									   		msg1 = "생년월일을";
									   		msg2 = "입력해 주세요";
									   		calBtn.requestFocus();
								   	}	else	 if(emailitem.trim().length() == 0) {
								   		msg1 = "이메일 주소를";
								   		msg2 = "입력해 주세요";
								   		emailTf.requestFocus();
							   		} else if(tel1item.trim().length() == 0) {
								   		msg1 = "전화번호를";
								   		msg2 = "입력해 주세요";
								   		telTf2.requestFocus();
							   		} else if(tel2item.trim().length() == 0) {
								   		msg1 = "전화번호를";
								   		msg2 = "입력해 주세요";
								   		telTf3.requestFocus();
							   		} else if(tel2item.trim().length() == 0) {
								   		msg1 = "전화번호를";
								   		msg2 = "입력해 주세요";
							   		} else {
							   			MemberBean  bean;
							   			mgr = new MemberMgr();
							   			bean = new MemberBean();
							   			
							   			bean.setName(nameTf.getText());
							   			bean.setId(idTf.getText());
							   			bean.setPassword(passTf.getText());
							   			bean.setPassword(passTf2.getText());
							   			bean.setGender(genderC.getSelectedItem());
							   			bean.setBirth(birthTf.getText());
							   			bean.setEmail(emailTf.getText());
							   			bean.setPhone(comboTel.getSelectedItem()+"-"+telTf2.getText()+ "-"+telTf3.getText());
							   			//bean.setImg(img);
							   			if (mgr.insertMember(bean)) {
							   				System.out.println("수정완료");
							   			}
							   				
							   			//}
							   			msg1 = "내정보를 성공적으로";
								   		msg2 = "저장하였습니다.";
								   		this.setVisible(false);
										JFrame frame = new Login();
										frame.setVisible(true);
									}
								     
					   		}//특수문자를 만족
	            	  //패스워드가 입력되었어면	 
			     } 
	   		}else if(reInfoBtn == obj) {
	   			if (nameitem.trim().length() >10 || nameitem.trim().length() == 0 || nameitem.trim().equals("bean.name")
						 ||nameitem.equals("  10자 이내")){//닉네임 중복 확인
				   		msg1 = "사용할 수 없는 닉네임입니다.";
				   		msg2 = "다시 만들어 중복확인 해주세요";
			   			nameTf.requestFocus();
			   	}else if (passitem.trim().length() == 0) {//패스워드부분 공백인지 확인
			   		msg1 = "패스워드를 ";
			   		msg2 = "입력해 주세요";
			   		passTf.requestFocus();
				} else  if(passitem.trim().length() != 0)  {//대문자와 특수문자 사용 확인
				   		int count = 0;
				   		for(int i=0; i<passitem.length();i++ ) {//패스워드부분 특수문자있는지 확인
				   			char c = passitem.charAt(i);
				   			if(c=='~'||c=='@'||c=='#'||c=='$'||c=='%'||c=='^'||c=='&'||c=='*'||c=='!') {
				   			count ++;
				   			if(count == 1) break; //특수문자 1개 사용했으면 특수문자 for문 중지
				   			}//특수문자 if
				   		}//특수문자for
				   		if(count ==0) {//특수문자가 사용되지 않았으면
				   			msg1 = " 특수문자를";
				   			msg2 = "1개이상 사용해 주세요";
				   			passTf.requestFocus();
				   		}	else {//특수문자를 1개이상 사용했으면 대문자 사용 체크
					   			count =0;
					   			for(int j=0; j< passitem.length() ;j++) {
				   					char c= passitem.charAt(j);
				   					if('A'<= c && c<='Z') { // 인식안됌
				   						count ++;
				   						if(count ==1) break;
				   					}//대문자 만족하면 for문 벗어남
				   				}//대문자 for
						   		if(count==0)  {//대문자를 사용하지 않았으면
						   			msg1 = "영문 대문자를 ";
						   			msg2 = "1개이상 사용해 주세요.";
						   			passTf.requestFocus();
						   			}else if(pass2item.trim().length() == 0) {//패스워드부분 공백인지 확인
								   		msg1 = "패스워드를 ";
								   		msg2 = "재입력해 주세요";
								   		passTf2.requestFocus();
								   	 }	else if( !passitem.equals(pass2item)) {
								   		msg1 = "비밀번호가";
							   			msg2 = "일치하지 않습니다.";
							   			passTf2.requestFocus();
								   	 } else	 if(birthItem.trim().length() == 0) {
									   		msg1 = "생년월일을";
									   		msg2 = "입력해 주세요";
									   		calBtn.requestFocus();
								   	}	else	 if(emailitem.trim().length() == 0) {
								   		msg1 = "이메일 주소를";
								   		msg2 = "입력해 주세요";
								   		emailTf.requestFocus();
							   		} else if(tel1item.trim().length() == 0) {
								   		msg1 = "전화번호를";
								   		msg2 = "입력해 주세요";
								   		telTf2.requestFocus();
							   		} else if(tel2item.trim().length() == 0) {
								   		msg1 = "전화번호를";
								   		msg2 = "입력해 주세요";
								   		telTf3.requestFocus();
							   		} else if(tel2item.trim().length() == 0) {
								   		msg1 = "전화번호를";
								   		msg2 = "입력해 주세요";
							   		} else {
							   			MemberBean  bean;
							   			mgr = new MemberMgr();
							   			bean = new MemberBean();
							   			
							   			bean.setIdx(idx);
							   			bean.setName(nameTf.getText());
							   			bean.setId(idTf.getText());
							   			bean.setPassword(passTf.getText());
							   			bean.setPassword(passTf2.getText());
							   			bean.setGender(genderC.getSelectedItem());
							   			bean.setBirth(birthTf.getText());
							   			bean.setEmail(emailTf.getText());
							   			bean.setPhone(comboTel.getSelectedItem()+"-"+telTf2.getText()+ "-"+telTf3.getText());
							   			
							   			if (mgr.updateMember(bean)) {
							   				System.out.println(123);
							   			}
							   										   			
							   			msg1 = "내정보를 성공적으로";
								   		msg2 = "수정하였습니다.";
								   		this.setVisible(false);
								   		Choose frame = new Choose();
								   		frame.setVisible(true);
									}
				   				}     
					   		}//특수문자를 만족
	            	  //패스워드가 입력되었어면	 
			     }   					   
		   MDialog md = new MDialog(this, title, msg1, msg2, true);
			int width = 250;
			int height = 200;
			int x = getX() + getWidth() / 2 - width / 2;
			int y = getY() + getHeight() / 2 - height / 2;
			md.setBounds(x, y, width, height);
			md.setVisible(true);
					   
		 }//모든 프로필 입력일 경우	   		
		
		
		}//action
	
	


	class MDialog extends JDialog implements ActionListener{
		JButton btnu;
		JLabel msg1L;
		JLabel msg2L;
		
		public MDialog(Frame f,String title, String msg1,String msg2, boolean flag) {
			super(f, title, flag);
							
			setLayout(null);
			add(msg1L = new JLabel(msg1));
			add(msg2L = new JLabel(msg2));
		     			
			add(btnu = new JButton("확인"));
			
								
			msg1L.setBounds(30,20,200,30);
			msg2L.setBounds(30,60,200,30);
			btnu.setBounds(80,100,70,30);
			btnu.addActionListener(this);
		    }
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			}
		}//MDialog 클래스
		
		

	
	public static void main(String[] args) {
		
		new Signin();
	}
}