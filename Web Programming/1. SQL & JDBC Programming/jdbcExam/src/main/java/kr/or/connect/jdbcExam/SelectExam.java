package kr.or.connect.jdbcExam;

import kr.or.connect.jdbcExam.dao.RoleDaoSelect;
import kr.or.connect.jdbcExam.dto.Role;
import java.util.*;

public class SelectExam {

	public static void main(String[] args) {
		
		RoleDaoSelect dao = new RoleDaoSelect();
		List<Role> list = dao.SELECT();
		
		for(Role role : list) {
			System.out.println(role);
		}
	}

}
 