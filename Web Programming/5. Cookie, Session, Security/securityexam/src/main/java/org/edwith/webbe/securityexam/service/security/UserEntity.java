package org.edwith.webbe.securityexam.service.security;


/*		사용자 정보를 담는 개체
 * 		ID, Password 정보만 갖는다.
 */
public class UserEntity {
    private String loginUserId;
    private String password;

    public UserEntity(String loginUserId, String password) {
        this.loginUserId = loginUserId;
        this.password = password;
    }

    public String getLoginUserId() {
        return loginUserId;
    }

    public void setLoginUserId(String loginUserId) {
        this.loginUserId = loginUserId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
