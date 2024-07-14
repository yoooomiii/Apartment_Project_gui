package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dto.BoardDTO;

public class BoardDAO {

	private Connection conn=null;
//	private String url="jdbc:oracle:thin:@localhost:1522:xe";
	private String url="jdbc:oracle:thin:@localhost:1521:orcl";

	public BoardDAO() {  
		String driver ="oracle.jdbc.driver.OracleDriver";
		try {
			Class.forName(driver);
						System.out.println("로드 성공");
		} catch (Exception e) {
						System.out.println("로드 실패");
		}
	}
	
	public Connection getConnection() {
		try {
//			conn = DriverManager.getConnection(url,"system","1111");
			conn = DriverManager.getConnection(url, "system", "1234");
						System.out.println("연결성공");
			return conn;
		} catch (Exception e) {
						System.out.println("연결실패");
		}
		return null;
	}
	


	public ArrayList<BoardDTO> selectAll() {
		 ArrayList<BoardDTO> al = new ArrayList<>();
			if(getConnection() != null) {
			try {
				BoardDAO bdao=new BoardDAO();
				ResultSet rs = null;
				Statement stmt=null;
				String sql = "select * from BOARD";
				stmt=conn.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					BoardDTO bd = new BoardDTO();
					bd.setNum(rs.getString("num"));
					bd.setTitle(rs.getString("title"));
					bd.setCon(rs.getString("con"));
					bd.setWriter(rs.getString("writer"));
					al.add(bd);
					
				} 
				return al;
			 }	catch (Exception e) {
				
			}
		}
			return null;
	}
	
	
	public ArrayList<BoardDTO> selectFac() {
		 ArrayList<BoardDTO> al = new ArrayList<>();
			if(getConnection() != null) {
			try {
				BoardDAO bdao=new BoardDAO();
				ResultSet rs = null;
				Statement stmt=null;
				String sql = "select * from BOARD";
				stmt=conn.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					BoardDTO bd = new BoardDTO();
					bd.setNum(rs.getString("num"));
					bd.setTitle(rs.getString("title"));
					bd.setCon(rs.getString("con"));
					bd.setWriter(rs.getString("writer"));
					al.add(bd);
					
				} 
				return al;
			 }	catch (Exception e) {
				
			}
		}
		return null;
	}
}
