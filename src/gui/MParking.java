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

import dao.ParkingDAO;
import dto.ParkingDTO;



public class MParking extends JFrame implements ActionListener {
	private DefaultTableModel view3;
	private ParkingDAO pdao;
	private ParkingDTO ParkingDTO;
	JButton b = new JButton("뒤로가기");

	public MParking() {
		this.setTitle("등록 차량");

		this.setBounds(200, 200, 600, 300);
		pdao= new ParkingDAO();
		view3 = new  DefaultTableModel();

		view3.addColumn("소유주 성함");
		view3.addColumn("차종");
		view3.addColumn("차량 번호");
		view3.addColumn("동/호수");

		JTable table3 = new JTable(view3);
		
		TableColumnModel col = table3.getColumnModel();
		col.getColumn(0).setPreferredWidth(150);
		col.getColumn(1).setPreferredWidth(150);
		col.getColumn(2).setPreferredWidth(150);
		col.getColumn(3).setPreferredWidth(150);
		
		JScrollPane scroll = new JScrollPane(table3); 
		scroll.setPreferredSize(new Dimension(100, 100));
		this.getContentPane().add(scroll);
		
		JPanel p = new JPanel();
	
		
		p.add(b);
		b.addActionListener(this);
		
		this.add(p, BorderLayout.SOUTH);
		
		ArrayList<ParkingDTO> pList = pdao.PSelect();
		for (ParkingDTO P: pdao.PSelect()) {
			view3.addRow(new Object[]{P.getName(), P.getKind(), P.getNum(), P.getHome()});

			this.setVisible(true);
			this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(b)) {
			Manager m = new Manager();
			m.setVisible(true);
			this.setVisible(false);
		}
	}
}