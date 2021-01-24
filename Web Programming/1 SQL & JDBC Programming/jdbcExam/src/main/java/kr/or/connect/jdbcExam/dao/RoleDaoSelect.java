package kr.or.connect.jdbcExam.dao;

import java.sql.*;

import kr.or.connect.jdbcExam.dto.Role;
import java.util.*;

public class RoleDaoSelect {
	
	// 개인의 DB URL, User, Password를 고정으로 지정 
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb?serverTimezone=Asia/Seoul&useSSL=false";
	private static String dbUser= "user1";
	private static String dbpassword = "user1";
	
	public List<Role> SELECT() {		
		List<Role> list = new ArrayList<> ();
		
		// 클래스 생성 part
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e) {
			System.out.println("Error in create!");
			e.printStackTrace();
		}
		
		String sql = "SELECT role_id, description FROM role order by role_id desc";
		// Select 연산 part
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpassword);
			 PreparedStatement ps = conn.prepareStatement(sql)) {
			
			try (ResultSet rs = ps.executeQuery()) {
				while(rs.next()) {
					// rs의 iterator가 가리키는 모든 데이터를 추출하여 리스트에 추가
					int id = rs.getInt(1);
					String description = rs.getString(2);
					Role role = new Role(id, description);
					list.add(role);
				}
			}
			catch(Exception result) {
				System.out.println("Error in query!");
				result.printStackTrace();
			}
		}
		catch(Exception e) {
			System.out.println("Error in SELECT!");
			e.printStackTrace();
		}
		
		return list;
	}
}