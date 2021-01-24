package kr.or.connect.jdbcExam.dao;

import java.sql.*;

import kr.or.connect.jdbcExam.dto.Role;

// Database Access Object : 데이터베이스로의 접근 매체
public class RoleDao {
	
	// 개인의 DB URL, User, Password를 고정으로 지정 
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb?serverTimezone=Asia/Seoul&useSSL=false";
	private static String dbUser= "user1";
	private static String dbpassword = "user1";
	
	Role role = null;				// 
	Connection conn = null;			// DB로 연결
	PreparedStatement ps = null;	// conn의 상태를 조정
	ResultSet rs = null;			// ps으로 설정한 conn을 최종으로 적용에 사용
	
	String sql = "";
	public Role delRole(Integer id) {		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(dburl, dbUser, dbpassword);
			sql = "DELETE FROM role WHERE role_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String description = rs.getString(1);
				int ID = rs.getInt("role_id");
				role = new Role(ID, description);
			}
		}
		catch(Exception e) {
			System.out.println("Error in create!\n");
			e.printStackTrace();
		}
		finally {
			// 생성한 connection, preparedstatement, resultset 종료
			if(rs != null) {
				try {
					rs.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return role;
	}
	
	public Role insertRole (Integer id, String desc) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(dburl, dbUser, dbpassword);
			sql = "INSERT INTO role (role_id, description) VALUES (?, ?)";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			ps.setNString(2, desc);
		}
		catch(Exception e) {
			System.out.println("Error in create!\n");
			e.printStackTrace();
		}
		finally {
			
		}
		return role;
	}
	
	public Role selectRole(Integer id) {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(dburl, dbUser, dbpassword);
			sql = "SELECT description, role_id FROM role WHERE role_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String description = rs.getString(1);
				int ID = rs.getInt("role_id");
				role = new Role(ID, description);
			}
			
		}
		catch (Exception e) {
			System.out.println("Error in create!\n");
			e.printStackTrace();
		}
		finally {
			if(rs != null) {
				try {
					rs.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return role;
	}
}
