package kr.or.connect.jdbcExam.dao;

import java.sql.*;


public class RoleDaoDelete {
	
	// 개인의 DB URL, User, Password를 고정으로 지정 
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb?serverTimezone=Asia/Seoul&useSSL=false";
	private static String dbUser= "user1";
	private static String dbpassword = "user1";
	
	public int DELETE(int ID) {
		int deleteCount = 0;
		
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
		
		String sql = "DELETE FROM role WHERE role_id = ?";		// sql 문자열
		
		// Delete 연산 part
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpassword);
			 PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setInt(1,  ID);
			
			deleteCount = ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("Error during insertion!");
			e.printStackTrace();
		}
		return deleteCount;
	}
}
