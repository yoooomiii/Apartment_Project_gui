package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.CleanDAO;
import dto.CleanDTO;

public class Clean extends JFrame implements ActionListener{

	JPanel[] cl = new JPanel[6];
	JLabel title = new JLabel("청  소  일  정");
	JLabel num = new JLabel("청소 날짜");
	JTextField cnum = new JTextField(10);
	JLabel place = new JLabel("청소 구역");
	JTextField cplace = new JTextField(10);
	JLabel name = new JLabel("청소 담당자");
	JTextField cname = new JTextField(10);
	JLabel call = new JLabel("담당자 번호");
	JTextField ccall = new JTextField(10);
	JButton b = new JButton("등 록");
	
	
	Clean() {
		
		this.setBounds(200, 200, 600, 400);
		this.setLayout(new GridLayout(6,1));
		for(int i=0; i<cl.length; i++) {
			cl[i]= new JPanel();
			this.add(cl[i]);
		}
		
		cl[0].add(title);
		cl[1].add(num);
		cl[1].add(cnum);
		cl[2].add(place);
		cl[2].add(cplace);
		cl[3].add(name);
		cl[3].add(cname);
		cl[4].add(call);
		cl[4].add(ccall);
		cl[5].add(b);
		b.addActionListener(this);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String getnum = cnum.getText();
		String getplace = cplace.getText();
		String getname = cname.getText();
		String getcall = ccall.getText();
		
		CleanDTO ct = new CleanDTO();
		ct.setNum(getnum);
		ct.setPlace(getplace);
		ct.setName(getname);
		ct.setCall(getcall);

		CleanDAO cd = new CleanDAO();
		cd.cinsert(ct);
		
		this.setVisible(false);
	}
}
