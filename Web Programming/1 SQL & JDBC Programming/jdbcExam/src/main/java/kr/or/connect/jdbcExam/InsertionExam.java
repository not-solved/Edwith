package kr.or.connect.jdbcExam;

import kr.or.connect.jdbcExam.dao.RoleDaoInsert;
import kr.or.connect.jdbcExam.dto.Role;

import java.util.Scanner;

public class InsertionExam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Insert Exercise (-1 to quit)");
		
		Role role = null;
		int ID;
		String desc;
		
		// -1을 입력하기 전까지 insert연산 반복수행
		while(true) {
			System.out.print("1. role ID (integer) : \t");
			ID = sc.nextInt();
			if(ID == -1)
				break;
			System.out.print("2. Description (string) : \t");
			desc = sc.next();
		
			role = new Role(ID, desc);
			
			RoleDaoInsert dao = new RoleDaoInsert();
			int insertCount = dao.INSERT(role);
		
			System.out.println(insertCount);
		}
		System.out.println("Terminate program. Good bye!");
		sc.close();
	}
}
