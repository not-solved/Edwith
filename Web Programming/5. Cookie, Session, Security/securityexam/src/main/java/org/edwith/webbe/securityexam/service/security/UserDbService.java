package org.edwith.webbe.securityexam.service.security;

import org.edwith.webbe.securityexam.dto.Member;

import java.util.List;

public interface UserDbService {
	public UserEntity getUser(String loginUserId);
	public List<UserRoleEntity> getUserRoles(String loginUserId);
	public void addMember(Member member, boolean admin);
	public Member getMemberByEmail(String email);
}
