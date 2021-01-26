package org.edwith.webbe.securityexam.config;

import org.edwith.webbe.securityexam.service.security.CustomUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
    	
        //   /webjars/** 경로에 대한 요청은 인증/인가 처리하지 않도록 무시
        web.ignoring().antMatchers("/webjars/**");
    }

    //   /, /main에 대한 요청은 누구나 할 수 있지만 
    //   그 외의 요청은 모두 인증 후 접근 가능하게 설정
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
	        .csrf().disable()
	        .authorizeRequests()
	        // 로그인 과정 없이 사용할 수 있는 경로
	        .antMatchers("/", "/main", "/loginerror", "/members/joinform", "/members/join", "/members/welcome").permitAll()
	        // 사용자(USER) 권한을 가지고 있어야 접근할 수 있는 경로
	        .antMatchers("/securepage", "/members/**").hasRole("USER")
	        .anyRequest().authenticated()
	        .and()
	        		//	로그인 관련
	            .formLogin()
	            .loginPage("/members/loginform")		// 로그인 페이지
	            .usernameParameter("userId")			// ID 파라미터
	            .passwordParameter("password")			// PW 파라미터
	            .loginProcessingUrl("/authenticate")	// 로그인 프로세스 URL
	            .failureForwardUrl("/members/loginerror?login_error=1")		// 로그인 오류 시 URL
	            .defaultSuccessUrl("/",true)			// 로그인 성공 시 페이지
	            .permitAll()
	        .and()
	        		//	로그아웃 관련
	            .logout()
	            .logoutUrl("/logout")					// 로그아웃 페이지
	            .logoutSuccessUrl("/");					// 로그아웃 성공 시 페이지
    }

    // 패스워드 인코더를 빈으로 등록 
    // 암호를 인코딩하거나, 인코딩된 암호와 사용자가 입력한 암호가 같은 지 확인할 때 사용
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
