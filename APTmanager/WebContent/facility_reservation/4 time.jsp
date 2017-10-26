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

<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">
	$(function() {
		$(".button").click(function() {
			location.href = "count.facility?t_id=" + $(this).val();
		});
	});
</script>
</head>
<body>

	<c:forEach var="t" begin="${open_id-1}" end="${close_id-1 }"
		items="${timeTable}">

		<c:forEach var="m" items="${map}">

			<c:if test="${t.t_id == m.key}">
				<c:set var="spot" value="${m.value}"></c:set>
				<c:set var="t_id" value="${m.key}"></c:set>

			</c:if>

		</c:forEach>
		<button class="button" value="${t.t_id }">${t.t_start }~
			${t.t_end }</button>
남은 자리 ${ spot}  /  총 ${capa}
		<input type="hidden" value=${t.t_id } class="button">
		<br>
	</c:forEach>

</body>
</html>