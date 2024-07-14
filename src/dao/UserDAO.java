package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dto.UserDTO;
import gui.Manager;
import gui.Users;

public class UserDAO {

	private Connection conn = null;
//	private String url = "jdbc:oracle:thin:@localhost:1522:xe";
	private String url="jdbc:oracle:thin:@localhost:1521:orcl";

	public UserDAO() {
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

	public void insert(UserDTO u) {
		if (getConnection() != null) {
			try {
				String sql = "insert into USERS values (?,?,?,?,?)";
				PreparedStatement psmt = null;
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, u.getId());
				psmt.setString(2, u.getPw());
				psmt.setString(3, u.getName());
				psmt.setString(4, u.getCall());
				psmt.setString(5, u.getNum());
				int a=psmt.executeUpdate();
				if(a==0) {
				JOptionPane.showMessageDialog(null, "가입이 완료되지 않았습니다", "가입", JOptionPane.ERROR_MESSAGE);
			} else if(a>0) {
				JOptionPane.showMessageDialog(null, "가입이 완료되었습니다", "가입", JOptionPane.PLAIN_MESSAGE);
				Users uu= new Users();
				uu.setVisible(true);
			}

				System.out.println("가입을 축하드립니다");
			} catch (Exception e) {
			}
		}
	}

	public boolean idchk(String id, String pw) {
		if (getConnection() != null) {
			try {
				String sql = "select * from USERS where id=? and pw=?";
				PreparedStatement psmt=null;
				ResultSet rs = null;
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, id);
				psmt.setString(2, pw);
				rs=psmt.executeQuery();
				while (rs.next()) {
					return true;
				}
			} catch (Exception e) {
			}
		}
		return false;
	}

	public ArrayList<UserDTO> selectAll() {
		ArrayList<UserDTO> ulist = new ArrayList<>();
		if (getConnection() != null) {
			try {
				ResultSet rs = null;
				Statement stmt = null;
				String sql = "select * from USERS";
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					UserDTO ut = new UserDTO();
					ut.setId(rs.getString("id"));
					ut.setPw(rs.getString("pw"));
					ut.setName(rs.getString("name"));
					ut.setCall(rs.getString("call"));
					ut.setNum(rs.getString("num"));
					ulist.add(ut);

				}
				return ulist;
			} catch (Exception e) {

			}
		}
		return null;
	}

	public ArrayList<UserDTO> check(String id) {
		ArrayList<UserDTO> u = new ArrayList<>();
		if (getConnection() != null) {
			try {
				System.out.println("연결됨");
				String sql = "select * from USERS where id=? ";
				ResultSet rs = null;
				PreparedStatement psmt = null;
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, id);
				
				rs = psmt.executeQuery();
				while (rs.next()) {
					UserDTO ut = new UserDTO();
					ut.setId(rs.getString("id"));
					
					u.add(ut);
				}
			} catch (Exception e) {
			}
		}
		return u;
	}
	
	public ArrayList<UserDTO> del(String name) {
		ArrayList<UserDTO> u = new ArrayList<>();
		if (getConnection() != null) {
			try {
				String sql = "delete from USERS where name=? ";
				PreparedStatement psmt = null;
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, name);
				int a= psmt.executeUpdate();
				if(a==0) {
					JOptionPane.showMessageDialog(null, "삭제할 정보가 없습니다", "삭제", JOptionPane.ERROR_MESSAGE);
				} else if(a>0) {
					JOptionPane.showMessageDialog(null, "삭제되었습니다", "삭제", JOptionPane.PLAIN_MESSAGE);
					Users uu= new Users();
					uu.setVisible(true);
				}
			} catch (Exception e) {
			}
		}
		return u;
	}
	
	public void update(UserDTO u) {
	    if (getConnection() != null) {
	        try {
	            String sql = "update USERS set id=?, pw=?, call=?, num=? WHERE name=?";
	            PreparedStatement psmt = conn.prepareStatement(sql);
	            psmt.setString(1, u.getId());
	            psmt.setString(2, u.getPw());
	            psmt.setString(3, u.getCall());
	            psmt.setString(4, u.getNum());
	            psmt.setString(5, u.getName());
	            psmt.executeUpdate();
	            System.out.println("수정됨");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	
	

}
