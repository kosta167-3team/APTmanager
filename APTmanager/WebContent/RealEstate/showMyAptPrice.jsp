<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
	request.setCharacterEncoding("UTF-8");
	System.out.println(request.getAttribute("annualRent"));
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="myaptChart">
		<h3>내 아파트 시세 보기</h3>
		<p><span>${lastMonthRent.a_name}</span>의 1㎡당 시세</p>
		<div id="myAPTchart">
			<div class ="non-cat">
				<jsp:include page="lastMonth.jsp"></jsp:include>
				<jsp:include page="annual.jsp"></jsp:include>
			</div>
			<div class="cat">
				<jsp:include page="cat_area.jsp"></jsp:include>
			</div>
		</div>
	</div>
</body>
</html>