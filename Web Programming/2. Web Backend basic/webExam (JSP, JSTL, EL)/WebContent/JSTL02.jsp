<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.*" %>
<%--	core의 import 기능 --> url, var, scope 순서로 기입  --%>
<c:import url="http://localhost:8000/webExam/jstValue.jsp" var="urlValue" scope="request"></c:import>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--	import한 값 화면에 출력 --%>
읽어들인 값 : ${urlValue } <br>

<%--	redirect 기능 : 해당 페이지에 다시 접근한다. --%>
<c:redirect url="jstRedirect.jsp"></c:redirect>

<%--	out 기능 : JspWriter에 데이터를 출력한다.  --%>
<%--	value : 출력할 변수		escapeXml : 문자의 변환여부(기본 true) --%>
<%--	< : &lt;	> : &gt;	& : &amp;	' : &#039;	" : &#034 --%>
<c:set var="t" value="<script type='text/javascript'>alert(1);</script>"/>
<c:out value="${t}" escapeXml="true"/>
<c:out value="${t}" escapeXml="false"/>

</body>
</html>