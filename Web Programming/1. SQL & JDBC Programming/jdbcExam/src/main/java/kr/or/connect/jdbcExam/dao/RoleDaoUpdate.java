package kr.or.connect.jdbcExam.dao;

import java.sql.*;
import kr.or.connect.jdbcExam.dto.Role;

public class RoleDaoUpdate {
	
	// 개인의 DB URL, User, Password를 고정으로 지정 
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb?serverTimezone=Asia/Seoul&useSSL=false";
	private static String dbUser= "user1";
	private static String dbpassword = "user1";
	
	public int UPDATE(Role role) {
		int updateCount = 0;
		
		
		// 클래스 생성 part
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e) {
			System.out.println("Error in create!");
			e.printStackTrace();
		}
		
		String sql = "UPDATE role SET description = ? WHERE role_id = ?";
		// Update 연산 part
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpassword);
			 PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setInt(2, role.getID());
			ps.setString(1, role.getDescription());
			
			updateCount = ps.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("Error in UPDATE!");
			e.printStackTrace();
		}
		
		return updateCount;
	}
}
