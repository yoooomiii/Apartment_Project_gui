package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.EventDAO;
import dao.ParkingDAO;
import dto.MEventDTO;
import dto.ParkingDTO;

public class MEvent extends JFrame implements ActionListener {

	JPanel[] e = new JPanel[7];
	JLabel title = new JLabel("행  사  일  정");
	JLabel name = new JLabel("제목");
	JTextField ename = new JTextField(8);
	JLabel edate = new JLabel("행사 기간");
	JTextField eedate = new JTextField(8);
	JLabel con = new JLabel("행사 내용");
	JTextField econ = new JTextField(20);
	JLabel rdate = new JLabel("등록 날짜");
	JTextField redate = new JTextField(10);
	JLabel writer = new JLabel("작성자");
	JTextField ewriter = new JTextField(8);
	JButton b = new JButton("행사 등록");
	JButton bc = new JButton("뒤로가기");

	MEvent() {
		this.setBounds(200, 200, 600, 400);
		this.setLayout(new GridLayout(7, 1));
		for (int i = 0; i < e.length; i++) {
			e[i] = new JPanel();
			this.add(e[i]);
		}
		e[0].add(title);
		e[1].add(name);
		e[1].add(ename);
		e[2].add(edate);
		e[2].add(eedate);
		e[3].add(con);
		e[3].add(econ);
		e[4].add(rdate);
		e[4].add(redate);
		e[5].add(writer);
		e[5].add(ewriter);
		e[6].add(b);
		e[6].add(bc);
		b.addActionListener(this);
		bc.addActionListener(this);

		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(b)) {
			String getname= ename.getText();
			String getedate = eedate.getText();
			String getcon = econ.getText();
			String getrdate = redate.getText();
			String getwriter= ewriter.getText();
		
			MEventDTO edto = new MEventDTO();
			edto.setName(getname);
			edto.setEdate(getedate);
			edto.setCon(getcon);
			edto.setRdate(getrdate);
			edto.setWriter(getwriter);
			
			EventDAO v = new EventDAO();
			v.eventadd(edto);
			this.setVisible(false);
	
		} else if (e.getSource().equals(bc)) {
			Manager m = new Manager();
			m.setVisible(true);
			this.setVisible(false);
		}
	}
}
