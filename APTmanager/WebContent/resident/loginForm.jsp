<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login.resident" method = "post">
	<center>
		<table align="center">
			<tr >
				<td>ID</td>
				<td><input type="text" name="r_id"></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="password" name="r_pw"></td>
			</tr>
			<tr>			
				<td><input type="submit" value="로그인"></td>
			</tr>
		</table>
		</center>
	</form>
	
</body>
</html>