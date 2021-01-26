package org.edwith.webbe.securityexam.service;

import org.edwith.webbe.securityexam.config.ApplicationConfig;
import org.edwith.webbe.securityexam.config.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class, SecurityConfig.class})
public class PasswordEncoderTest {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    public void passwordEncode() throws Exception{
    	
    	// password 인코딩 테스트
        System.out.println(passwordEncoder.encode("1234"));
    }
    
    @Test
    public void passwordTest() throws Exception{
    	
    	// password와 인코딩된 password의 일치여부 테스트
    	String encodePasswd = "$2a$10$USbExG2YOZJqu5rR9eWAqO3NqwjS6c8uI0c695cnURA2gxqRnx41O";
    	String password = "1234";
    	boolean test = passwordEncoder.matches(password, encodePasswd);
    	System.out.println(test);
    }

}
