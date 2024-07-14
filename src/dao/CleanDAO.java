package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dto.CleanDTO;
import gui.Manager;

public class CleanDAO {

	private Connection conn = null;
//	private String url = "jdbc:oracle:thin:@localhost:1522:xe";
	private String url="jdbc:oracle:thin:@localhost:1521:orcl";
	

	public CleanDAO() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		try {
			Class.forName(driver);
			System.out.println("로드 성공");
		} catch (Exception e) {
			System.out.println("로드 실패");
		}
	}

	public Connection getConnection() {
		try {
//			conn = DriverManager.getConnection(url, "system", "1111");
			conn = DriverManager.getConnection(url, "system", "1234");
			System.out.println("연결성공");
			return conn;
		} catch (Exception e) {
			System.out.println("연결실패");
		}
		return null;
	}

	public void cinsert(CleanDTO c) {
		if (getConnection() != null) {
			try {
				String sql = "insert into CLEAN values (?,?,?,?)";
				PreparedStatement psmt = null;
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, c.getNum());
				psmt.setString(2, c.getPlace());
				psmt.setString(3, c.getName());
				psmt.setString(4, c.getCall());
				int a=psmt.executeUpdate();
				if(a==0) {
					JOptionPane.showMessageDialog(null, "정보가 등록되지 않았습니다", "등록", JOptionPane.ERROR_MESSAGE);
				} else if(a>0) {
					JOptionPane.showMessageDialog(null, "정보가 등록되었습니다", "등록", JOptionPane.PLAIN_MESSAGE);
					Manager m= new Manager();
					m.setVisible(true);
				}
			} catch (Exception e) {
			}
		}
	}
	
	public ArrayList<CleanDTO> cSelect() {
		
		 ArrayList<CleanDTO> cc = new ArrayList<>();
			if(getConnection() != null) {
			try {
				ResultSet rs = null;
				Statement stmt=null;
				String sql = "select * from CLEAN";
				stmt=conn.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					CleanDTO cd = new CleanDTO();
					cd.setNum(rs.getString("num"));
					cd.setPlace(rs.getString("place"));
					cd.setName(rs.getString("name"));
					cd.setCall(rs.getString("call"));
					cc.add(cd);
					
				} 
				return cc;
			 }	catch (Exception e) {
				
			}
		}
		return null;
	}

}
