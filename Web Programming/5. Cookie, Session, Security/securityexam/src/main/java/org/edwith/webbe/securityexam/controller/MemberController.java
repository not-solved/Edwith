package org.edwith.webbe.securityexam.controller;

import org.edwith.webbe.securityexam.dto.Member;
import org.edwith.webbe.securityexam.service.MemberService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping(path = "/members")
public class MemberController {
    // 스프링 컨테이너가 생성자를 통해 자동으로 주입한다.
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    // 생성자
    public MemberController(MemberService memberService, PasswordEncoder passwordEncoder){
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
    }

    // 로그인 화면
    @GetMapping("/loginform")
    public String loginform(){
        return "members/loginform";
    }

    // 로그인 에러 화면
    @RequestMapping("/loginerror")
    public String loginerror(@RequestParam("login_error")String loginError){
        return "members/loginerror";
    }
    
    @GetMapping("/join")
    public String joinform() {
    	return "members/joinform";
    }
    
    @PostMapping("/join")
    public String join(@ModelAttribute Member member) {
    	member.setPassword(passwordEncoder.encode(member.getPassword()));
    	memberService.addMember(member, false);
    	return "redirect:members/welcome";
    }
    
    @GetMapping("/welcome")
    public String welcome() {
    	return "members/welcome";
    }
    
    @GetMapping("/memberinfo")
    public String memberInfo(Principal principal, ModelMap modelMap) {
    	String loginId = principal.getName();
    	Member member = memberService.getMemberByEmail(loginId);
    	
    	String hiddenPassword = "";
    	for(int i = 0; i < member.getPassword().length(); i++)
    		hiddenPassword += "*";
    	member.setPassword(hiddenPassword);
    	
    	modelMap.addAttribute("member", member);
    	
    	return "members/memberinfo";
    }

}
