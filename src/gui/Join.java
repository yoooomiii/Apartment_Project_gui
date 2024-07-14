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


public class Join  extends JFrame implements ActionListener{
	JPanel [] join = new JPanel[7];
	JLabel title = new JLabel("주 민 등 록");
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
	JButton save = new JButton("등 록  완 료");

	Join() {
		this.setBounds(200, 200, 600, 400);
		this.setLayout(new GridLayout(7,1));
		for(int i=0; i<join.length; i++) {
			join[i]=new JPanel();
			this.add(join[i]);
		}
		
		join[0].add(title);
		join[1].add(id);
		join[1].add(jid);
		join[2].add(pw);
		join[2].add(jpw);
		join[3].add(name);
		join[3].add(jname);
		join[4].add(call);
		join[4].add(jcall);
		join[5].add(num);
		join[5].add(jnum);
		join[6].add(save);
		save.addActionListener(this);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String getid = jid.getText();
		String getpw = jpw.getText();
		String getname = jname.getText();
		String getcall = jcall.getText();
		String getnum = jnum.getText();
	
		UserDTO udto = new UserDTO();
		udto.setName(getname);
		udto.setId(getid);
		udto.setPw(getpw);
		udto.setCall(getcall);
		udto.setNum(getnum);
		
		
		UserDAO udao = new UserDAO();
		udao.insert(udto);
		
		this.setVisible(false);
	}

}
