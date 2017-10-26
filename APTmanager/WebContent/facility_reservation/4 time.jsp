<%@ page import="facility_reservation.model.Facility"%>
<%@ page import="facility_reservation.model.Facility_time"%>

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

	<c:forEach var="t" begin="${open_id-1}" end="${close_id-1 }"
		items="${timeTable}">

		<c:forEach var="m" items="${map}">

			<c:if test="${t.t_id == m.key}">
				<c:set var="spot" value="${m.value}"></c:set>
			</c:if>

		</c:forEach>

		<input type="button" value="${t.t_start } ~ ${t.t_end }">  남은 자리 ${ spot}  /  총 ${capa} </input>
		<br>
	</c:forEach>

</body>
</html>