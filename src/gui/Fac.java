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
	JLabel title = new JLabel("�ź� ����Ʈ �ü� �̿� �ȳ�");
	JLabel title2 = new JLabel("�̰��� ���� ���ֹ��� �Բ� �̿��ϴ� �����Դϴ�");
	JLabel con1 = new JLabel("1. �����ʹ� ���� 10�ú��� ���� 8�ñ��� �̿� �����մϴ�");
	JLabel con2 = new JLabel("2. �и����� ���� ������, ����� �Դϴ�");
	JLabel con3 = new JLabel("3. ���κ������� 60�� �̻���� ��� �����ϸ� �����繫�ҿ��� ������ּ���");
	JLabel con4 = new JLabel("4. �����繫�Ҵ� ���� 8�ú��� ���� 6�ñ��� �̿� �����մϴ�");
	JLabel con5 = new JLabel(" ���� �繫�� ��ȭ��ȣ: 031-225-8080");
	JButton b = new JButton("�ڷΰ���");
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
