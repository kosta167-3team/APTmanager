<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.tbl tr {
	border: solid 0.5px #BDBDBD;
}

.tbl {
	/* border-top: solid 1px;
		border-bottom: solid 1px; */
	border-color: #5D5D5D;
	border: 1px solid;
	width: 750px;
}

.tbl td {
	height: 40px;
	padding-left: 10px;
}

.tbl th {
	height: 50px;
}

.price_table_body td:FIRST-CHILD {
	font: bold;
}

.tit_center_area {
	width: 60px;
}

.price_table_body tr {
	text-align: center;
}

.price_table_body td:NTH-CHILD(2n+3) {
	color: red;
	font: bold;
}

.price_table_body td:NTH-CHILD(2n+3) {
	color: #4374D9;
	font: bold;
}

.price_table_body td:NTH-CHILD(2n+2) {
	color: #F06161;
	font: bold;
}

div #tot_price_wrap{
	margin-top: 20px;
	margin-left: 20px;
}
</style>

<script src="./js/vendor/jquery-1.10.2.min.js"></script>
<script src="./js/vendor/jquery-ui-1.10.3.custom.min.js"></script>
<script src="./js/vendor/jquery.typoshadow.js"></script>
<script type="text/javascript">
	

</script>
</head>
<body>
	<h2>면적별 시세</h2>
	<div id="tot_price_wrap">
		<table class="tbl" summary="면적별 매매평균가, 전세평균가가 제공됨" border="1">
			<caption class="screen_hide">면적별 매매평균가, 전세평균가 테이블</caption>
			<colgroup>
				<col width="90">
			</colgroup>
			<colgroup>
				<col width="102">
				<col width="102">
				<col width="102">
			</colgroup>
			<colgroup>
				<col width="102">
				<col width="102">
				<col width="102">
			</colgroup>
			<thead>
				<tr>
					<th scope="col" rowspan="2" class="tit_center_area">면적(㎡)</th>
					<th scope="colgroup" colspan="2" class="tit_sale">매매(만원)</th>
					<th scope="colgroup" colspan="2" class="tit_lease border_right">전세(만원)</th>
				</tr>
				<tr>
					<th scope="col">상한가</th>
					<th scope="col">하한가</th>

					<th scope="col">상한가</th>
					<th scope="col">하한가</th>
				</tr>
			</thead>
			<tbody class="price_table_body">
				<c:forEach var="list" items="${catArea}">
					<tr>
						<td>${list.area}</td>
						<td>${list.rt_max}</td>
						<td>${list.rt_min}</td>
						<td>${list.rr_max}</td>
						<td>${list.rr_min}</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>

	</div>

</body>
</html>