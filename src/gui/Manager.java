package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Manager extends JFrame implements ActionListener {
	
	JPanel[] man = new JPanel[4];
	JLabel title = new JLabel("관 리 인 시 스 템");
	JButton r = new JButton("주 민 정 보");
	JButton ev = new JButton("행 사 일 정");
	JButton c = new JButton("청 소 일 정");
	JButton p = new JButton("등 록 차 량");

	public Manager() {
		this.setBounds(200, 200, 600, 400);
		this.setLayout(new GridLayout(4, 1));
		for(int i=0; i<man.length; i++) {
			man[i]=new JPanel();
			this.add(man[i]);
		}
		man[0].add(title);
		man[1].add(r);
		man[1].add(ev);
		man[2].add(c);
		man[2].add(p);
		
		r.addActionListener(this);
		ev.addActionListener(this);
		c.addActionListener(this);
		p.addActionListener(this);

		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(r)) {
			Resident rd = new Resident();
			rd.setVisible(true);
			this.setVisible(false);
		} else if (e.getSource().equals(ev)) {
			MEvent ee = new MEvent();
			ee.setVisible(true);
			this.setVisible(false);
		} else if (e.getSource().equals(c)) {
			CleanView cv = new CleanView();
			cv.setVisible(true);
			this.setVisible(false);
		} else if (e.getSource().equals(p)) {
			MParking pp = new MParking();
			pp.setVisible(true);
			this.setVisible(false);
		}

	}

}
	
	
	


