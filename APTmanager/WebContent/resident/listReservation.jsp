<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function fn_delete(vr_id) {
	alert(vr_id);
	location.href="deleteReservation.resident?vr_id="+vr_id;
}
function fn_update(vr_id) {
	location.href="updateReservation.resident?vr_id="+vr_id;
}
</script>
</head>
<body>
	<form action="" method="post">
		<table>

			<tr>
				<th width="50">방문객 이름</th>
				<th width="200">방문 사유</th>
				<th width="100">방문 예정일</th>
				<th width="100">방문 예약일</th>
				<th width="50">방문 여부</th>
				<th colspan="2" width="50">기능</th>
			</tr>
			<c:forEach var="reservation" items="${listModel.list}">
				<tr height="30">
					<td align="center">${reservation.v_name}</td>
					<td align="center">${reservation.v_contents }</td>
					<td align="left">${reservation.v_date }</td>
					<td align="center">${reservation.vr_date}</td>
					<td align="center">${reservation.v_check }</td>
					<td align="center">
						<input type="button" value="삭제" onclick="fn_delete(${reservation.vr_id});">
					</td>
					<td align="center">
						<input type="button" value="수정" onclick="fn_udpate(${reservation.vr_id});">
					</td>
				</tr>
			</c:forEach>
		</table>
		<!-- 이전 -->
		<c:if test="${listModel.startPage > 5 }">
			<a href="list.jsp?pageNum=${listModel.startPage -1 }">[이전]</a>
		</c:if>

		<!-- 페이지목록 -->
		<c:forEach var="pageNo" begin="${listModel.startPage }"
			end="${listModel.endPage }">
			<c:if test="${listModel.requestPage == pageNo }">
				<b>
			</c:if>
			<a href="list?pageNum=${pageNo }">[${pageNo }]</a>
			<c:if test="${lisWtModel.requestPage == pageNo }">
				</b>
			</c:if>
		</c:forEach>

		<!-- 이후 -->
		<c:if test="${listModel.endPage < listModel.totalPageCount }">
			<a href="list.jsp?pageNum=${listModel.endPage + 1 }">[이후]</a>
		</c:if>
	</form>
</body>
</html>