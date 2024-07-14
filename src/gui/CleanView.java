package gui;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import dao.CleanDAO;
import dto.CleanDTO;


public class CleanView extends JFrame implements ActionListener {

	
	private DefaultTableModel vieww;
	private CleanDAO cd;
	private Object i;
	private CleanDTO CleanDTO;
	JButton b1 = new JButton("���� ���");
	JButton b2 = new JButton("�ڷΰ���");
	public CleanView() {
		this.setTitle("û  ��  ��  ��");

		this.setBounds(200, 200, 600, 400);
		cd= new CleanDAO();
		vieww = new  DefaultTableModel();

		vieww.addColumn("û�� ��¥");
		vieww.addColumn("û�� ����");
		vieww.addColumn("û�� �����");
		vieww.addColumn("����� ��ȣ");
		
		JTable table = new JTable(vieww);
		
		TableColumnModel col = table.getColumnModel();
		col.getColumn(0).setPreferredWidth(100);
		col.getColumn(1).setPreferredWidth(100);
		col.getColumn(2).setPreferredWidth(100);
		col.getColumn(3).setPreferredWidth(100);
		
		JScrollPane scroll = new JScrollPane(table); 
		scroll.setPreferredSize(new Dimension(100, 100));
		this.getContentPane().add(scroll);
		
		JPanel p = new JPanel();
	
		p.add(b1);
		p.add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		this.add(p, BorderLayout.SOUTH);

		
		ArrayList<CleanDTO> cList = cd.cSelect();
		for (CleanDTO ct : cList ) {
			vieww.addRow(new Object[]{ct.getNum(), ct.getPlace(), ct.getName(), ct.getCall()});
		}
			this.setVisible(true);
			this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(b1)) {
			Clean c = new Clean();
			c.setVisible(true);
			this.setVisible(false);
		} else if(e.getSource().equals(b2)) {
			Users u =new Users();
			u.setVisible(true);
			this.setVisible(false);
		}
	}
}
	
