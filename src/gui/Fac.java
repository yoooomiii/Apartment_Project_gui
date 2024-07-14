package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fac extends JFrame implements ActionListener {
	
	JPanel[] f = new JPanel[9];
	JLabel title = new JLabel("신비 아파트 시설 이용 안내");
	JLabel title2 = new JLabel("이곳은 많은 입주민이 함께 이용하는 공간입니다");
	JLabel con1 = new JLabel("1. 놀이터는 오전 10시부터 저녁 8시까지 이용 가능합니다");
	JLabel con2 = new JLabel("2. 분리수거 일은 월요일, 목요일 입니다");
	JLabel con3 = new JLabel("3. 노인복지관은 60세 이상부터 등록 가능하며 관리사무소에서 등록해주세요");
	JLabel con4 = new JLabel("4. 관리사무소는 오전 8시부터 오후 6시까지 이용 가능합니다");
	JLabel con5 = new JLabel(" 관리 사무소 전화번호: 031-225-8080");
	JButton b = new JButton("뒤로가기");
	Fac() {
		this.setBounds(200, 200, 600, 400);
		this.setLayout(new GridLayout(9,1));
		for(int i=0; i<f.length; i++) {
			f[i]= new JPanel();
			this.add(f[i]);
		}
		
			f[0].add(title);
			f[0].setBackground(Color.decode("#F8E77F"));
			f[1].add(title2);
			f[1].setBackground(Color.decode("#F8E77F"));
			f[2].add(con1);
			f[3].add(con2);
			f[4].add(con3);
			f[5].add(con4);
			f[7].add(con5);
			f[8].add(b);
			b.addActionListener(this);
			
			this.setVisible(true);
			this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(b)) {
			Users u = new Users();
			u.setVisible(true);
			this.setVisible(false);
		}
	}
	
}
