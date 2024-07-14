package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dto.ParkingDTO;
import gui.Users;

public class ParkingDAO {

	private Connection conn = null;
//	private String url = "jdbc:oracle:thin:@localhost:1522:xe";
	private String url="jdbc:oracle:thin:@localhost:1521:orcl";

	public ParkingDAO() {
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

	public void pinsert(ParkingDTO p) {
		if (getConnection() != null) {
			try {
				String sql = "insert into Parking values (?,?,?,?)";
				PreparedStatement psmt = null;
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, p.getName());
				psmt.setString(2, p.getKind());
				psmt.setString(3, p.getNum());
				psmt.setString(4, p.getHome());
				int a=psmt.executeUpdate();
				if(a==0) {
				JOptionPane.showMessageDialog(null, "정보가 등록되지 않았습니다", "등록", JOptionPane.ERROR_MESSAGE);
			} else if(a>0) {
				JOptionPane.showMessageDialog(null, "정보가 등록되었습니다", "등록", JOptionPane.PLAIN_MESSAGE);
				Users u = new Users();
				u.setVisible(true);
			}
			} catch (Exception e) {
			}
		}
	}
	
	public ArrayList<ParkingDTO> PSelect() {
		 ArrayList<ParkingDTO> pp = new ArrayList<>();
			if(getConnection() != null) {
			try {
				ResultSet rs = null;
				Statement stmt=null;
				String sql = "select * from PARKING";
				stmt=conn.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					ParkingDTO pd = new ParkingDTO();
					pd.setName(rs.getString("name"));
					pd.setKind(rs.getString("kind"));
					pd.setNum(rs.getString("num"));
					pd.setHome(rs.getString("home"));
					pp.add(pd);
					
				} 
				return pp;
			 }	catch (Exception e) {
				
			}
		}
		return null;
	}
}
