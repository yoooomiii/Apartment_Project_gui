package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.UserDAO;
import dto.UserDTO;

public class Login extends JFrame implements ActionListener {

	JPanel[] log = new JPanel[10];
	JLabel pw = new JLabel("PW");
	JLabel id = new JLabel("ID");
	JButton b = new JButton("Login");
	JTextField idd = new JTextField(8);
	JTextField pww = new JTextField(8);
	JLabel no = new JLabel("아이디와 비밀번호를 다시 입력해주세요");

	Login() {
		this.setBounds(200, 200, 600, 400);
		this.setLayout(new GridLayout(10, 1));
		for (int i = 0; i < log.length; i++) {
			log[i] = new JPanel();
			this.add(log[i]);
		}
		log[1].add(id);
		log[1].add(idd);
		log[4].add(pw);
		log[4].add(pww);

		log[9].add(b);
		b.addActionListener(this);

		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		UserDAO ud = new UserDAO();
		UserDTO ut = new UserDTO();
		if (e.getSource().equals(b)) {
			if (ud.idchk(idd.getText(), pww.getText()) == true) {
				Users uu = new Users();
				uu.setVisible(true);
				this.setVisible(false);
			} else {
				log[6].add(no);
				this.setVisible(true);
			}
		}
	}
}