package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import dao.UserDAO;
import dto.UserDTO;

public class Resident extends JFrame implements ActionListener {

	
	private DefaultTableModel view;
	private UserDAO ud;
//	JButton b1= new JButton("정보 수정");
	JButton b2= new JButton("정보 삭제");
	JButton b = new JButton("뒤로가기");
	JButton bm = new JButton("수정하기");
			
	
	public Resident() {
		this.setTitle("주  민  정  보");

		this.setBounds(200, 200, 600, 400);
		ud= new UserDAO();
		view = new  DefaultTableModel();

		view.addColumn("아이디");
		view.addColumn("이름");
		view.addColumn("전화번호");
		view.addColumn("동/호수");

		JTable table = new JTable(view);
		
		TableColumnModel col = table.getColumnModel();
		col.getColumn(0).setPreferredWidth(100);
		col.getColumn(1).setPreferredWidth(100);
		col.getColumn(2).setPreferredWidth(100);
		col.getColumn(3).setPreferredWidth(100);
		
		JScrollPane scroll = new JScrollPane(table); 
		scroll.setPreferredSize(new Dimension(100, 100));
		this.getContentPane().add(scroll);
		
		JPanel p = new JPanel();
	
		
		p.add(b);
		p.add(b2);
		p.add(bm);
		b.addActionListener(this);
		b2.addActionListener(this);
		bm.addActionListener(this);
		this.add(p, BorderLayout.SOUTH);
		
		
		
		ArrayList<UserDTO> uList = ud.selectAll();
		for (UserDTO bt : uList ) {
			view.addRow(new Object[]{bt.getId(), bt.getName(), bt.getCall(), bt.getNum()});
		}
			this.setVisible(true);
			this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(b)) {
			Manager m = new Manager();
			m.setVisible(true);
			this.setVisible(false);
		} else if(e.getSource().equals(b2)) {
			UserDEL d = new UserDEL();
			d.setVisible(true);
			this.setVisible(false);
		} else if(e.getSource().equals(bm)) {
			UserMod d = new UserMod();
			d.setVisible(true);
			this.setVisible(false);
		}
	}
}
	
