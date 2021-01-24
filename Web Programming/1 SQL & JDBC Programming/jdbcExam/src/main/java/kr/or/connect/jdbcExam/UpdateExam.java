package kr.or.connect.jdbcExam;

import kr.or.connect.jdbcExam.dao.RoleDaoUpdate;
import kr.or.connect.jdbcExam.dto.Role;
import java.util.*;

public class UpdateExam {

	public static void main(String[] args) {
		int updateCount = 0, id;
		Role role = null;
		String desc = "";
		Scanner sc = new Scanner(System.in);
		RoleDaoUpdate dao = new RoleDaoUpdate();
		
		
		System.out.println("Update Exercise (-1 to quit)");
		
		// -1을 입력하기 전까지 update연산 반복수행
		while(true) {
			System.out.print("ID you want : ");
			id = sc.nextInt();
			if(id == -1)
				break;
			System.out.print("Description to update : ");
			desc = sc.next();
			role = new Role(id, desc);
			updateCount = dao.UPDATE(role);
			if(updateCount > 1)
				System.out.println("Update " + updateCount + " tuples");
			else if(updateCount == 1)
				System.out.println("Update " + updateCount + " tuple");
			else
				System.out.println("No such ID exists");
		} 
		System.out.println("Terminate program. Good bye!");
		sc.close();
	}

}
