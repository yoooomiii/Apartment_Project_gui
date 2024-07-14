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

public class UserMod2 extends JFrame implements ActionListener  {
	JPanel [] mm = new JPanel[7];
	JLabel title = new JLabel("정 보 수 정");
	JLabel id = new JLabel("ID:");
	JLabel pw = new JLabel("PW:");
	JLabel name = new JLabel("이름:");
	JLabel call = new JLabel("전화번호:");
	JLabel num= new JLabel("동 / 호:");
	JTextField jid = new JTextField(10);
	JTextField jpw = new JTextField(10);
	JTextField jname = new JTextField(10);
	JTextField jcall = new JTextField(18);
	JTextField jnum = new JTextField(18);
	JButton save = new JButton("수정하기");

	UserMod2() {
	
	this.setBounds(200, 200, 600, 400);
	this.setLayout(new GridLayout(7,1));
	for(int i=0; i<mm.length; i++) {
		mm[i]=new JPanel();
		this.add(mm[i]);
	}
	
	mm[0].add(title);
	mm[1].add(id);
	mm[1].add(jid);
	mm[2].add(pw);
	mm[2].add(jpw);
	mm[3].add(name);
	mm[3].add(jname);
	mm[4].add(call);
	mm[4].add(jcall);
	mm[5].add(num);
	mm[5].add(jnum);
	mm[6].add(save);
	save.addActionListener(this);
	
	this.setVisible(true);
	this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(save)) {
			  String userId = jid.getText();
		        String userPw = jpw.getText();
		        String userName = jname.getText();
		        String userCall = jcall.getText();
		        String userNum = jnum.getText();
		        
		        UserDTO ut = new UserDTO();

		        // UserDAO 객체 생성 후 update 메서드 호출
		        UserDAO userDAO = new UserDAO();
		        userDAO.update(ut);
		        this.setVisible(false);
		    }
		}
}
	

