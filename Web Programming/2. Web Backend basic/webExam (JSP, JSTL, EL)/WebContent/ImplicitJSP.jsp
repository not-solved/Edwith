<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP exercise</title>
</head>
<body>
<%
	StringBuffer URL = request.getRequestURL();
	out.println("URL : " + URL.toString() + "<br>");
%>

</body>
</html>

<%-- 내장 객체
	 JSP를 실행하면 서블릿 소스가 생성되고 실행된다.
	 JSP의 코드는 서블릿의 _jspService()에서 받으며, 여기서 선언된 객체들은 JSP에서도 사용 가능
	
	대응되는 객체들 (서블릿에서 사용하던 객체들과 거의 동일)
	1. request		==> javax.servlet.http.HttpServletRequest
	2. response 	==> javax.servlet.http.HttpServletRequest
	3. pageContext	==> javax.servlet.jsp.PageContext
	4. session		==>	javax.servlet.http.HttpSession
	5. application	==>	javax.servlet.ServletConetxt
	6. out			==> javax.servlet.jsp.JspWriter
	7. config		==>	javax.servlet.ServletConfig
	8. page			==>	javax.servlet.http.HttpJspPage
	9. exception	==>	java.lang.Throwable	

	서블릿으로 생성될 때 jspService에서 선언된 것을 이용하기 때문에,
	JSP에서 객체를 선언할 필요는 없다.
--%>
