<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- HTML식 주석처리 -->
<%-- JSP식 주석처리 --%>

<%-- 1. 선언문 예시 --%>
id : <%=getId()%>


<%-- 2. 스크립트릿 예시 --%>
<%--    지역변수식 선언 --%>
<%
	for(int i = 1; i <= 5; i++) {
%>
		<H<%=i%>> 아름다운 한글 </H<%=i%>>
<%
	}
%>

<%-- 3. 표현식 --%>
<%--    <%=%> 내부에서 사용 --%>
<%--    out, print() 등의 메소드를 사용해서 출력하는 방식 --%>

</body>
</html>

<%!	// JSP에서의 선언은 "<%!"으로 시작

	String id = "u001";
	public String getId() {
		return id;
	}
%>