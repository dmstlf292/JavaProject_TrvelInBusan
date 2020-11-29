package tib;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeatherFrame extends MFrame implements ActionListener{
	
	Label label;
	TextField tf;
	Button btn;
	Panel p;
	WeatherBean wbean;
	RssReadMgr mgr;
	Image skyImg, ptyImg;
	
	public WeatherFrame() {
		super(400, 400); 
		p = new Panel();
		p.add(label = new Label("UC45_SEQ"));
		p.add(tf = new TextField("264",15));
		p.add(btn = new Button("SEND"));
		btn.addActionListener(this);
		add(p, BorderLayout.NORTH);
		validate();
	}
	
	@Override
	public void paint(Graphics g) {
		if(wbean!=null) {
			g.drawString("여행정보 : " + wbean.getMAIN_TITLE(), 20, 100);
			g.drawString("현재기온 : " + wbean.getTemp(), 20, 120);
			g.drawString("현재날씨 : " + wbean.getWfKor(), 20, 140);
			
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
			g.drawString("하늘날씨 : ", 20, 180);
			g.drawImage(skyImg, 80, 160 ,this);
           
		
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
			g.drawString("강수상태 : ",120, 180);
			g.drawImage(ptyImg, 180, 160 ,this);
			
				
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int UC_SEQ = Integer.parseInt(tf.getText());
		mgr = new RssReadMgr();
		wbean = mgr.getTownForecast(UC_SEQ);
		validate();
		repaint();
	}
	
	public static void main(String[] args) {
		new WeatherFrame();
	}
}







