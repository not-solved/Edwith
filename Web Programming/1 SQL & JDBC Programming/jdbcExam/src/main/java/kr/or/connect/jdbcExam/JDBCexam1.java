package kr.or.connect.jdbcExam;

import kr.or.connect.jdbcExam.dao.RoleDao;
import kr.or.connect.jdbcExam.dto.Role;
import java.util.Scanner;

public class JDBCexam1 {

	public static void main(String[] args) {
		RoleDao dao = new RoleDao();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("Input role_id (0 to quit) : ");
			int input;
			input = sc.nextInt();
			if(input == 0)
				break;
			Role role = dao.selectRole(input);
			System.out.println(role);
		}
		sc.close();
		System.out.println("Good bye");
	}
}
