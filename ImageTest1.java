package tib;


import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ImageTest1 implements ActionListener{
	
	JPanel panel;
	FileDialog getImg;
	JButton button;
	JFrame frame;
	ImagePanel panel1;
	
	public ImageTest1() {
	    frame = new JFrame("이미지 불러오기");
		button = new JButton("이미지 불러오기");
		panel = new JPanel(); 
		panel1 = new ImagePanel(); // 이미지를 불러오기 위한 패널
		frame.setBounds(500, 400, 480, 640);
		frame.add(panel1);
		getImg = new FileDialog(frame,"이미지 선택",FileDialog.LOAD);
		button.addActionListener(this);
		panel.add(button);
		frame.add(panel,BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 메모리에서 완전 사삭
		frame.setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		getImg.setVisible(true);
		String s = getImg.getDirectory() +  getImg.getFile();
		panel1.setPath(s);
		panel1.repaint();
	}
	
	class ImagePanel extends JPanel {
		
		Image image;
		Toolkit toolkit = getToolkit(); // 이미지를 가져오기 위해서

		public void setPath(String src) {
			image = toolkit.getImage(src); // 경로 설정
		}

		@Override
		public void paint(Graphics g) {
			g.clearRect(0, 0, 480, 640);
			if (image != null)
				g.drawImage(image, 0, 0, this); // 경로가 들어왔을 때 출력
		}
	}
	
	public static void main(String[] args) {
		new ImageTest1();
	}
}


