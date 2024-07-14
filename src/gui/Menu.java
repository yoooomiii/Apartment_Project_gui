package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JFrame implements ActionListener {

//	JPanel [] log = new JPanel[8];

	JLabel title = new JLabel("신   비   아   파   트");
	JButton res = new JButton("일반 사용자 모드");
	JButton man = new JButton("관 리 자   모 드");
	JButton join = new JButton("주  민  등  록");
	JLabel x = new JLabel(" ");
	JLabel y = new JLabel(" ");
	JLabel ii = new JLabel();

	Menu() {

		this.setBounds(200, 100, 900, 500);

//		this.setBackground(Color.decode("#F2F2F2"));
//		ImageIcon i3 = new ImageIcon("imagee/그림14.png");
		ImageIcon i = new ImageIcon("imagee/아파트5.png");
		ImageIcon i2 = new ImageIcon("imagee/주민2.png");
//		ImageIcon i4 = new ImageIcon("imagee/그림5.png");
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(1, 2));

		JPanel p2 = new JPanel();
		p1.add(p2);

		JPanel p3 = new JPanel();
		p3.add(ii);
		ii.setIcon(i);
		p3.setBackground(Color.WHITE);
		p1.add(p3);
		

		// 프레임에 패널 추가
		this.add(p1);

		p2.setLayout(new GridLayout(1, 3));
		JPanel p4 = new JPanel();
		p4.setBackground(Color.WHITE);
		JPanel p5 = new JPanel();
		JPanel p6 = new JPanel();
		p6.setBackground(Color.WHITE);
		p2.add(p4);
		p2.add(p5);
		p2.add(p6);
		p5.setLayout(new GridLayout(3, 1));
		p5.add(join);
		res.setIcon(i2);
		p5.add(res);
		p5.add(man);
		// 프레임 설정
		this.setBounds(200, 90, 900, 500);
		join.addActionListener(this);
		res.addActionListener(this);
		man.addActionListener(this);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(join)) {
			Join j = new Join();
			j.setVisible(true);
			this.setVisible(false);
		} else if (e.getSource().equals(res)) {
			Resident r = new Resident();
			r.setVisible(true);
			this.setVisible(false);
		} else if (e.getSource().equals(man)) {
			Manager m = new Manager();
			m.setVisible(true);
			this.setVisible(false);
		}
	}
}

