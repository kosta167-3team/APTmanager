<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
 <%request.setCharacterEncoding("UTF-8"); 
 System.out.println(request.getAttribute("annualRent"));
 %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	지난 달 전세<br>
	
	${lastMonthRent.a_name}||${lastMonthRent.rr_year}||${lastMonthRent.rr_month}| |${lastMonthRent.rr_deposit}<br>
	
	지난 달 매매<br>
	
	${lastMonthTrade.a_name} | |${lastMonthTrade.rt_price}<br>
	
	<br>
	1년간 전세 추이<br>
	<c:forEach var="annualRent" items="${annualRent}">
		${annualRent.rr_year} | |${annualRent.rr_month} ||${annualRent.rr_max}||${annualRent.rr_min}<br>
	</c:forEach>
	<br>
	1년간 매매 추이<br>
	<c:forEach var="annualTrade" items="${annualTrade}">
		 ${annualTrade.rt_year} | |${annualTrade.rt_month} ||${annualTrade.rt_max}||${annualTrade.rt_min}<br> 
	</c:forEach>
	
	
</body>
</html>