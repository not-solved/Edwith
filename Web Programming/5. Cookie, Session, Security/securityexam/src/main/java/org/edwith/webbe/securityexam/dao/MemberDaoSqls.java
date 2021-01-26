package org.edwith.webbe.securityexam.dao;

public class MemberDaoSqls {
	
	// email로 사용자 정보 검색
	public static final String SELECT_ALL_BY_EMAIL = "SELECT id, name, password, email, create_date, modify_date FROM member WHERE email = :email";
	
	// 사용자 정보 입력
	public static final String INSERT_MEMBER = "INSERT INTO member(name, password, email, create_date, modify_date) VALUES (:name, :password, :email, :createDate, :modifyDate);";

}
