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

	JLabel title = new JLabel("��   ��   ��   ��   Ʈ");
	JButton res = new JButton("�Ϲ� ����� ���");
	JButton man = new JButton("�� �� ��   �� ��");
	JButton join = new JButton("��  ��  ��  ��");
	JLabel x = new JLabel(" ");
	JLabel y = new JLabel(" ");
	JLabel ii = new JLabel();

	Menu() {

		this.setBounds(200, 100, 900, 500);

//		this.setBackground(Color.decode("#F2F2F2"));
//		ImageIcon i3 = new ImageIcon("imagee/�׸�14.png");
		ImageIcon i = new ImageIcon("imagee/����Ʈ5.png");
		ImageIcon i2 = new ImageIcon("imagee/�ֹ�2.png");
//		ImageIcon i4 = new ImageIcon("imagee/�׸�5.png");
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(1, 2));

		JPanel p2 = new JPanel();
		p1.add(p2);

		JPanel p3 = new JPanel();
		p3.add(ii);
		ii.setIcon(i);
		p3.setBackground(Color.WHITE);
		p1.add(p3);
		

		// �����ӿ� �г� �߰�
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
		// ������ ����
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

