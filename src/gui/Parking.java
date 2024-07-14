package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.ParkingDAO;
import dto.ParkingDTO;

public class Parking extends JFrame implements ActionListener{

	JPanel[] p = new JPanel[7];
	JLabel title = new JLabel("주  차  등  록");
	JLabel name = new JLabel("소유주 이름:");
	JTextField pname = new JTextField(8);
	JLabel kind = new JLabel("차량 명:");
	JTextField pkind = new JTextField(8);
	JLabel num = new JLabel("차량 번호:");
	JTextField pnum = new JTextField(8);
	JLabel home = new JLabel("동/호수:");
	JTextField phome = new JTextField(8);
	JLabel con = new JLabel(" *차량등록 인원이 많을시 등록 시간이 지연될 수 있습니다*");
	JButton b = new JButton("등록");
	JButton bc = new JButton("뒤로가기");
	Parking() {
		
		this.setBounds(200, 200, 600, 400);
		this.setLayout(new GridLayout(7,1));
		for(int i=0; i<p.length; i++) {
			p[i]=new JPanel();
			this.add(p[i]);
		}	
			p[0].add(title);
			p[1].add(name);
			p[1].add(pname);
			p[2].add(kind);
			p[2].add(pkind);
			p[3].add(num);
			p[3].add(pnum);
			p[4].add(home);
			p[4].add(phome);
			p[5].add(con);
			p[6].add(b);
			p[6].add(bc);
			b.addActionListener(this);
			bc.addActionListener(this);
			this.setVisible(true);
			this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(b)) {
		String getname= pname.getText();
		String getkind = pkind.getText();
		String getnum = pnum.getText();
		String gethome = phome.getText();
	
		ParkingDTO pdto = new ParkingDTO();
		pdto.setName(getname);
		pdto.setKind(getkind);
		pdto.setNum(getnum);
		pdto.setHome(gethome);
		
		ParkingDAO p = new ParkingDAO();
		p.pinsert(pdto);
		this.setVisible(false);
		} else if(e.getSource().equals(bc)) {
			Users u = new Users();
			u.setVisible(true);
			this.setVisible(false);
		}
		
		
	}
	
}
	