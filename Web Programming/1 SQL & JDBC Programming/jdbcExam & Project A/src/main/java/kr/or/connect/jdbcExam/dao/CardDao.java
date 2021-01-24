package kr.or.connect.jdbcExam.dao;

import kr.or.connect.jdbcExam.dto.Card;
import java.util.*;
import java.sql.*;

public class CardDao {
	
	private static String dburl = "jdbc:mysql://localhost:3306/db1?serverTimezone=Asia/Seoul&useSSL=false";
	private static String dbUser= "user1";
	private static String dbpassword = "user1";

	String SQL = "";
	public int Insert(Card card) {
		int insert_complete = 0;
		
		// Class 생성 part
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			System.out.println("Error! no class");
			e.printStackTrace();
		}
		
		// Insert 연산 part
		SQL = "INSERT INTO card VALUES (?, ?, ?)";
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpassword);
			 PreparedStatement ps = conn.prepareStatement(SQL)) {	
			ps.setString(1, card.getName());
			ps.setString(2, card.getPhone_num());
			ps.setString(3, card.getCorp_name());
		
			insert_complete = ps.executeUpdate();
		}
		catch (Exception insertExcept) {
			System.out.println("Error! deal with SQL");
			insertExcept.printStackTrace();
		}
		return insert_complete;
	}
	
	public List<Card> Select(String name) {
		List<Card> result = new ArrayList<> ();
		String temp_n, temp_p, temp_c;
		// Class 생성 part
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			System.out.println("Error! no class");
			e.printStackTrace();
		}
		
		// Select 연산 part
		SQL = "SELECT name, phone, corp FROM card WHERE name = ? order by name desc";
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpassword);
			 PreparedStatement ps = conn.prepareStatement(SQL)) {	
			ps.setString(1, name);
			try (ResultSet rs = ps.executeQuery();) {
				while(rs.next()) {
					temp_n = rs.getString(1);
					temp_p = rs.getString(2);
					temp_c = rs.getString(3);
					Card sesarch = new Card(temp_n, temp_p, temp_c);
					result.add(sesarch);
				}
			}
			catch (Exception e) {
				System.out.println("Error! illegal tuple access");
				e.printStackTrace();
			}
		}
		catch (Exception insertExcept) {
			System.out.println("Error! deal with SQL");
			insertExcept.printStackTrace();
		}
		return result;
	}
}
