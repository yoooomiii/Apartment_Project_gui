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

import dao.BoardDAO;
import dto.BoardDTO;


public class Board extends JFrame implements ActionListener {
	private DefaultTableModel view;
	private BoardDAO bdao;
	JButton b = new JButton("�ڷΰ���");
	public Board() {
		this.setTitle("�� �� �� ��");

		this.setBounds(200, 200, 600, 300);
		bdao= new BoardDAO();
		view = new  DefaultTableModel();

		view.addColumn("�� ��ȣ");
		view.addColumn("����");
		view.addColumn("����");
		view.addColumn("�ۼ���");

		JTable table = new JTable(view);
		
		TableColumnModel col = table.getColumnModel();
		col.getColumn(0).setPreferredWidth(50);
		col.getColumn(1).setPreferredWidth(150);
		col.getColumn(2).setPreferredWidth(300);
		col.getColumn(3).setPreferredWidth(100);
		
		JScrollPane scroll = new JScrollPane(table); 
		scroll.setPreferredSize(new Dimension(100, 100));
		this.getContentPane().add(scroll);
		
	JPanel p = new JPanel();
	
		
		p.add(b);
		b.addActionListener(this);
		
		this.add(p, BorderLayout.SOUTH);
		
		ArrayList<BoardDTO> boardList = bdao.selectAll();
		for (BoardDTO bd : bdao.selectAll()) {
			view.addRow(new Object[]{bd.getNum(), bd.getTitle(), bd.getCon(), bd.getWriter()});

		
			this.setVisible(true);
			this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		}
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