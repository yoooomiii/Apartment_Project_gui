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
	JLabel title = new JLabel("��  ��  ��  ��");
	JLabel name = new JLabel("������ �̸�:");
	JTextField pname = new JTextField(8);
	JLabel kind = new JLabel("���� ��:");
	JTextField pkind = new JTextField(8);
	JLabel num = new JLabel("���� ��ȣ:");
	JTextField pnum = new JTextField(8);
	JLabel home = new JLabel("��/ȣ��:");
	JTextField phome = new JTextField(8);
	JLabel con = new JLabel(" *������� �ο��� ������ ��� �ð��� ������ �� �ֽ��ϴ�*");
	JButton b = new JButton("���");
	JButton bc = new JButton("�ڷΰ���");
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
	