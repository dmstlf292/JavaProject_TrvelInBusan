package tib;

import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyCalendar extends MFrame implements ActionListener{
	
	TextField tf;
	Button btn;
	
	public MyCalendar() {
		super(300, 150);
		add(tf = new TextField(20));
		add(btn = new Button("..."));
		btn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		new SwingCalendar3(this);
	}
	
	public static void main(String[] args) {
		new MyCalendar();
	}
}




