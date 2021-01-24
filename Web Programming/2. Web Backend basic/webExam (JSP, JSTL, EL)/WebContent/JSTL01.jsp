<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%-- core 라이브러리, java.util 라이브러리 사용 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	page import="java.util.*"%>


<%-- 1.	core : 변수 지원 태그 사용 (변수 선언 및 사용)
	 	var -변수명	scope -영역	value -변수 값 --%> 
<c:set var="value1" scope="request" value="kang"/>

<%-- 2.	core 조건문 테스트를 위한 객체 설정 --%>
<%
	request.setAttribute("n", 10);
	request.setAttribute("score", 83);
%>

<%-- 4. forEach 흐름 테스트를 위한 변수 설정 --%>
<%
	List<String> list = new ArrayList<>();
	list.add("Str1 - Hello");
	list.add("Str2 - World");
	list.add("Str3 - !!!");
	request.setAttribute("list", list);
%>

<html>
<head>
<meta charset="UTF-8">
<title>Core tag example</title>
</head>
<body>

<%-- 이전에 지정한 코어변수를 표현으로 사용하면 된다. --%>
1.	CoreTag Value<br>FirstName : ${value1} 
<%-- 지정한 변수 태그 제거 --%>
<c:remove var="value1" scope="request"/>
<br><br><br>

2.	If flow test<br>
<%-- 시작 -c:if --%>
<c:if test="${n == 0 }">	n is equal to 0		</c:if>
<c:if test="${n == 10 }">	n is equal to 10	</c:if>
<br><br><br>

3.	Switch flow test<Br>
<%-- 시작 -c:choose	각 조건 -c:when 	default 조건 -c:otherwise--%>
<c:choose>
	<c:when test = "${score >= 90}">	score A		</c:when>
	<c:when test = "${score >= 80}">	score B		</c:when>
	<c:when test = "${score >= 70}">	score C		</c:when>
	<c:when test = "${score >= 60}">	score D		</c:when>
	<c:otherwise>	score F	</c:otherwise>
</c:choose>
<br><br><br>

4.	forEach flow test<br>
<%-- 시작 -c:forEach 	list의 iterator, 표현할 변수 명 기입--%>
<c:forEach items="${list}" var="item">
${item } <br>
</c:forEach>

</body>
</html>