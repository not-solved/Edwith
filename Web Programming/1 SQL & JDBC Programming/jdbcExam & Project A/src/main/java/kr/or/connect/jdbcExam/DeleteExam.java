package kr.or.connect.jdbcExam;

import kr.or.connect.jdbcExam.dao.RoleDaoDelete;
import java.util.Scanner;

public class DeleteExam {

	public static void main(String[] args) {
		int deleteCount = 0, id;
		Scanner sc = new Scanner(System.in);
		RoleDaoDelete dao = new RoleDaoDelete();
		
		System.out.println("Delete Exercise (-1 to quit)");
		
		// -1을 입력하기 전까지 delete연산 반복수행
		while(true) {
			System.out.print("ID to delete : ");
			id = sc.nextInt();
			if(id == -1)
				break;
			deleteCount = dao.DELETE(id);
			System.out.println(deleteCount);
		}
		System.out.println("Terminate program. Good bye!");
		sc.close();
	}

}
