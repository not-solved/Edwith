package org.edwith.webbe.securityexam.dao;

public class MemberRoleDaoSqls {
	
	// member(m), member_role(mr) 테이블을 id로 조인한 테이블에서 email로 사용자 정보 검색
	public static final String SELECT_ALL_BY_EMAIL = "SELECT mr.id, mr.member_id, mr.role_name FROM member_role mr JOIN member m ON mr.member_id = m.id WHERE m.email = :email";

	//	사용자 역할 - 관리자 지정
	public static final String INSERT_ADMIN_ROLE = "INSERT INTO member_role (member_id, role_name) VALUES (:memberId, \"ROLE_ADMIN\");";
	
	//	사용자 역할 - 사용자 지정
	public static final String INSERT_USER_ROLE = "INSERT INTO member_role (member_id, role_name) VALUES (:member_id, \"ROLE_USER\");";
}
