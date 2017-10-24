<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	전체 전기 평균 : ${allElec } , 내 평균 ${meBill.elec_bill() }
	전체 열 평균 : ${allHeat }, 내 평균 : ${meBill.heat_bill() }
	전체 물 평균 : ${allWater } 내 평균 : ${meBill.water_bill() }
	
</body>
</html>