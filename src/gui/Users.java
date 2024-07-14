package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Users extends JFrame implements ActionListener {

	JPanel[] user = new JPanel[5];

	JLabel call = new JLabel("������ ��ȭ��ȣ 031-2222-8888");
	JButton b = new JButton("�� �� �� ��");
	JButton ev = new JButton("�� �� �� ��");
	JButton f = new JButton("�ü� �̿� �ȳ�");
	JButton p = new JButton("���� ���");
	JButton back = new JButton("�ڷ� ����");
	

	public Users() {
		this.setBounds(200, 200, 600, 400);
		back.setSize(getMaximumSize());
		this.setLayout(new GridLayout(5, 1));
		for(int i=0; i<user.length; i++) {
			user[i]=new JPanel();
			this.add(user[i]);
		}

		user[1].add(b);
		user[1].add(ev);
		user[2].add(f);
		user[2].add(p);
		user[3].add(call);
		user[4].add(back);
		back.setSize(300,300);
		b.addActionListener(this);
		ev.addActionListener(this);
		f.addActionListener(this);
		p.addActionListener(this);
		back.addActionListener(this);
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(b)) {
			Board bo = new Board();
			bo.setVisible(true);
			this.setVisible(false);
		} else if (e.getSource().equals(ev)) {
			Event v = new Event();
			v.setVisible(true);
			this.setVisible(false);
		} else if (e.getSource().equals(f)) {
			Fac ff = new Fac();
			ff.setVisible(true);
			this.setVisible(false);
		} else if (e.getSource().equals(p)) {
			Parking pp = new Parking();
			pp.setVisible(true);
			this.setVisible(false);
		} else if(e.getSource().equals(back)) {
			Login l =new Login();
			l.setVisible(true);
			this.setVisible(false);
		}
	}
}
