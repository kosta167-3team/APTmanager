<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<table>
		<c:forEach var="l" items="${list}">
		<tr>
			<td> <a href="detail.facility?f_id=${l.f_id}"> ${l.f_name } </a></td>
		</tr>
	</c:forEach>
	</table>
	
 

</body>
</html>