package org.edwith.webbe.securityexam.service.security;


/*		사용자의 권한 정보를 담는 개체
 * 		사용자 ID, 권한 정보를 갖는다.
 */
public class UserRoleEntity {
    private String userLoginId;
    private String roleName;

    public UserRoleEntity(String userLoginId, String roleName) {
        this.userLoginId = userLoginId;
        this.roleName = roleName;
    }

    public String getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
