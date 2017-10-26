<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function cancleButton() {
		
		location.href="mainForm.jsp?r_id=${r_id}"
	}	
</script>
</head>
<body>
	<h3> 방문객 등록 </h3>
	<form action= createReservation.resident method="post">
		<table>
			<tr> 
				<td> 방문객 이름 </td>
				<td> <input type="text" name = "v_name"/> </td>
			</tr>
			<tr> 
				<td> 방문객 연락처 </td>
				<td> <input type="text" name = "v_tel"/> </td>
			</tr>
			<tr> 
				<td> 방문 예정일 </td>
				<td> <input type="text" name = "vr_date"/> </td>
			</tr>
			<tr> 
				<td> 방문 목적</td>
				<td> <input type="text" name = "v_contents"/> </td>
			</tr>
			<tr> 
				<td> <input type="hidden" name = "r_id" value="${r_id}"/> </td>
			</tr>
			<tr> 
				<td> <input type="submit" value="등록"/> </td>
				<td> <input type="button" value="취소" onclick="cancleButton()"/> </td>
			</tr>
		</table>
	</form>
</body>
</html>