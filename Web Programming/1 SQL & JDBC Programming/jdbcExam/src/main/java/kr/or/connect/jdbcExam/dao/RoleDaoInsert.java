package kr.or.connect.jdbcExam.dao;

import java.sql.*;
import kr.or.connect.jdbcExam.dto.Role;

public class RoleDaoInsert {
	
	// 개인의 DB URL, User, Password를 고정으로 지정 
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb?serverTimezone=Asia/Seoul&useSSL=false";
	private static String dbUser= "user1";
	private static String dbpassword = "user1";
	
	public int INSERT(Role role) {
		int insertCount = 0;
		
		// Class 생성 part
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e) {
			System.out.println("Error in create!");
			e.printStackTrace();
		}
		 
		//Connection conn = null;		// DB로 연결
		//PreparedStatement ps = null;	// conn의 상태를 조정
		//ResultSet rs = null;			// ps으로 설정한 conn을 최종으로 적용에 사용
		
		String sql = "INSERT INTO role (role_id, description) VALUES (?, ?)";		// sql 문자열
		
		// Insert 연산 part
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpassword);
			 PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setInt(1,  role.getID());
			ps.setNString(2,  role.getDescription());
			
			insertCount = ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("Error during insertion!");
			e.printStackTrace();
		}
		return insertCount;
	}
}
