<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="http://code.jquery.com/jquery-latest.min.js" ></script>  

<script type="text/javascript">
$(function() {
	$("#reserve").click(function () {
	location.href = "success.facility"; 
	});
});
</script>

</head>
<body>

	<p>예약 가능 인원: ${spot}</p>

	<select>

		<c:forEach var="cnt" begin="1" end="${spot }">
			<option value="${cnt}">${cnt}</option>
		</c:forEach>
		
	</select>

	<br>
	<br>
	<input type="button" value="예약하기" id="reserve">

</body>
</html>