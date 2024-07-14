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
import dto.UserDTO;

public class UserDEL extends JFrame implements ActionListener {
	JPanel[] ud = new JPanel[4];
	JLabel title = new JLabel("정보 삭제");
	JLabel name = new JLabel("삭제할 이름 입력");
	JTextField n = new JTextField(5);
	JButton d = new JButton("삭제");
	

	UserDEL() {
		this.setBounds(200, 200, 600, 400);
		this.setLayout(new GridLayout(4, 1));
		for (int i = 0; i < ud.length; i++) {
			ud[i] = new JPanel();
			this.add(ud[i]);
		}

		ud[0].add(title);
		ud[1].add(name);
		ud[1].add(n);
		ud[2].add(d);
		d.addActionListener(this);
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(d)) {
			System.out.println("연결됨");
			String name = n.getText();
			UserDAO ua = new UserDAO();
			ua.del(name);
			this.setVisible(false);
		
		}
	}
}
