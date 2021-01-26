package org.edwith.webbe.securityexam.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
    // Spring Config 파일 설정
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{ApplicationConfig.class, SecurityConfig.class};
    }

    // Spring WEB Config 파일을 설정
    // 		WebConfig는 Bean을 RootConfig에서 설정한 곳에서부터 찾는다.
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{MvcConfig.class};
    }

    // DispatcherServlet이 매핑되기 위한 하나 혹은 여러 개의 패스를 지정
    //		여기서는 기본 경로 ('/')에서의 서블릿에만 매핑하여 애플리케이션으로 들어오는 모든 요청을 처리
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    // 필터 설정
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");

        return new Filter[]{encodingFilter};
    }
}
