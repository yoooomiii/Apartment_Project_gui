package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dto.MEventDTO;
import gui.Manager;

public class EventDAO {
	private Connection conn = null;
//	private String url = "jdbc:oracle:thin:@localhost:1522:xe";
	private String url="jdbc:oracle:thin:@localhost:1521:orcl";

	public EventDAO() {
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

	public ArrayList<MEventDTO> selectevent() {
		ArrayList<MEventDTO> elist = new ArrayList<>();
		if (getConnection() != null) {
			try {
				ResultSet rs = null;
				Statement stmt = null;
				String sql = "select * from EVENT";
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					MEventDTO mt = new MEventDTO();
					mt.setName(rs.getString("name"));
					mt.setEdate(rs.getString("edate"));
					mt.setCon(rs.getString("con"));
					mt.setRdate(rs.getString("rdate"));
					mt.setWriter(rs.getString("writer"));
					elist.add(mt);

				}
				return elist;
			} catch (Exception e) {

			}
		}
		return null;
	}

	public void eventadd(MEventDTO et) {
		if (getConnection() != null) {
			try {
				String sql = "insert into EVENT values (?,?,?,?,?)";
				PreparedStatement psmt = null;
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, et.getName());
				psmt.setString(2, et.getEdate());
				psmt.setString(3, et.getCon());
				psmt.setString(4, et.getRdate());
				psmt.setString(5, et.getWriter());
				int a= psmt.executeUpdate();
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

}
