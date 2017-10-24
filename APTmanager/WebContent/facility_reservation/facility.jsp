<%@ page import="facility_reservation.model.Facility"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>


	<p>${facility.f_name}</p>
	<p>${facility.f_contents}</p>
	<p>수용 가능 인원: ${facility.f_capa}</p>
	<br>
	<c:forEach var="date" items="${date }">
 	<a href="options.facility">${date }</a><br>
	</c:forEach>
</body>
</html>