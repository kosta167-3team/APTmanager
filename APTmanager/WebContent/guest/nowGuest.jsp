<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "guest.model.Guest" %>
    <%@page import="java.util.List"%>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            
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

<table>
	<c:forEach var="Guest" items="${selected }">
			<tr>
				<td>**당일 방문객 조회**</td>
			</tr>
			<tr>
				<td>동 : ${Guest.vh_dong }</td>
			</tr>
			<tr>
				<td>호수 : ${Guest.vh_ho }</td>
				</tr>
				<td>방문객 아이디 : ${Guest.r_id }</td>
				<tr>
				<td>방문객 이름 : ${Guest.vh_name }</td>
				</tr>
				<td>방문 목적 : ${Guest.vh_contents }</td>
				<tr>
				<td>방문객 차량 : ${Guest.vh_car }</td>
				</tr>
				<td>방문객 연락처 : ${Guest.vh_tel }</td>
				<tr>
				<td>방문객 허가여부 : ${Guest.vh_check }</td>
				</tr>
			
	
	</c:forEach>

	
	

</table>

</body>
</html>