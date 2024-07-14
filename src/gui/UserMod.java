package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.UserDAO;

public class UserMod extends JFrame implements ActionListener {

	
	JPanel[] um = new JPanel[4];
	JLabel title2 = new JLabel("정보 수정");
	JLabel mname = new JLabel("수정할 이름 입력");
	JTextField m = new JTextField(5);
	JButton mm = new JButton("수정");
	
	
	UserMod() {
	
	
	this.setBounds(200, 200, 600, 400);
	this.setLayout(new GridLayout(4, 1));
	for (int i = 0; i < um.length; i++) {
		um[i] = new JPanel();
		this.add(um[i]);
	}
	
	um[0].add(title2);
	um[1].add(mname);
	um[1].add(m);
	um[2].add(mm);
	mm.addActionListener(this);
	this.setVisible(true);
	this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(mm)) {
			
			UserMod2 ua = new UserMod2();
			ua.setVisible(true);
			this.setVisible(false);
		}
	}
}
