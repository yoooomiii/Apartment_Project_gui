package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MLogin extends JFrame implements ActionListener {
	JPanel[] log = new JPanel[5];
	JLabel pw = new JLabel("PW");
	JLabel title = new JLabel("관 리 인 시 스 템");
	JButton b = new JButton("접속");
	JTextField pww = new JTextField(4);
	JLabel no = new JLabel("비밀번호를 다시 입력해주세요");

	MLogin() {
		this.setBounds(200, 200, 600, 400);
		this.setLayout(new GridLayout(5, 1));
		for (int i = 0; i < log.length; i++) {
			log[i] = new JPanel();
			this.add(log[i]);
		}
		log[0].add(title);
		log[1].add(pw);
		log[1].add(pww);
		log[2].add(b);
		b.addActionListener(this);

		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(b)&& pww.getText().equals("1111")) {
			Manager m = new Manager();
			m.setVisible(true);
			this.setVisible(false);
		} else {
			log[3].add(no);
			this.setVisible(true);
		}
	}
}
