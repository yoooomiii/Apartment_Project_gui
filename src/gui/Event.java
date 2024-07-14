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

import dao.EventDAO;
import dto.MEventDTO;

public class Event extends JFrame implements ActionListener {

	private DefaultTableModel view2;
	private EventDAO edao;
	private MEventDTO edto;
	JButton b = new JButton("뒤로가기");

	public Event() {
		this.setTitle("행  사  정  보");

		this.setBounds(200, 200, 600, 400);
		edao = new EventDAO();
		view2 = new DefaultTableModel();
		view2.addColumn("행사 이름");
		view2.addColumn("행사 기간");
		view2.addColumn("행사 내용");
		view2.addColumn("등록 날짜");
		view2.addColumn("작성자");

		JTable table2 = new JTable(view2);

		TableColumnModel col = table2.getColumnModel();
		col.getColumn(0).setPreferredWidth(150);
		col.getColumn(1).setPreferredWidth(100);
		col.getColumn(2).setPreferredWidth(350);
		col.getColumn(3).setPreferredWidth(70);
		col.getColumn(4).setPreferredWidth(100);

		JScrollPane scroll = new JScrollPane(table2);
		scroll.setPreferredSize(new Dimension(100, 100));
		this.getContentPane().add(scroll);
		
		JPanel p = new JPanel();
		
		
		p.add(b);
	
		b.addActionListener(this);
		
		this.add(p, BorderLayout.SOUTH);


		ArrayList<MEventDTO> eList = edao.selectevent();
		for (MEventDTO et : edao.selectevent()) {
			view2.addRow(new Object[] { et.getName(), et.getEdate(), et.getCon(), et.getRdate(), et.getWriter() });

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
