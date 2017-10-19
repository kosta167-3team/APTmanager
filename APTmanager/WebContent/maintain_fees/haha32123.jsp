<%@page import="java.util.List"%>
<%@ page import = "maintain_fees.model.Personal_mgmt_ex" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        
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

<table>
	<tr>
		<td>월 </td>
		<c:forEach var = "Personal_mgmt_ex" items="${list }">
			 <td>${Personal_mgmt_ex.p_month }</td>
		</c:forEach>
	</tr>
	<tr>
		<td>일반 관리비 </td>
		<c:forEach var = "Personal_mgmt_ex" items="${list }">
			<td><fmt:formatNumber value="${Personal_mgmt_ex.general_mgmt }" pattern = "###,###,###"/></td>
		</c:forEach>
	</tr>
	<tr>
		<td>청소비 </td>
		<c:forEach var = "Personal_mgmt_ex" items="${list }">
			<td><fmt:formatNumber value="${Personal_mgmt_ex.clean }" pattern = "###,###,###"/></td>
		</c:forEach>
	</tr>
	<tr>
		<td>소독비 </td>
		<c:forEach var = "Personal_mgmt_ex" items="${list }">
			<td><fmt:formatNumber value="${Personal_mgmt_ex.fumigate }" pattern = "###,###,###"/></td>
		</c:forEach>
	</tr>
	<tr>
		<td>승강기유지비 </td>
		<c:forEach var = "Personal_mgmt_ex" items="${list }">
			<td><fmt:formatNumber value="${Personal_mgmt_ex.elevator_maintain }" pattern = "###,###,###"/></td>
		</c:forEach>
	</tr>
	<tr>
		<td>수선유지비 </td>
		<c:forEach var = "Personal_mgmt_ex" items="${list }">
			<td><fmt:formatNumber value="${Personal_mgmt_ex.repair }" pattern = "###,###,###"/></td>
		</c:forEach>
	</tr>
	<tr>
		<td>장기수선충당금 </td>
		<c:forEach var = "Personal_mgmt_ex" items="${list }">
			<td><fmt:formatNumber value="${Personal_mgmt_ex.long_term_repair }" pattern = "###,###,###"/></td>
		</c:forEach>
	</tr>
	<tr>
		<td>건물보험료 </td>
		<c:forEach var = "Personal_mgmt_ex" items="${list }">
			<td><fmt:formatNumber value="${Personal_mgmt_ex.building_insurance }" pattern = "###,###,###"/></td>
		</c:forEach>
	</tr>
	<tr>
		<td>경비비 </td>
		<c:forEach var = "Personal_mgmt_ex" items="${list }">
			<td><fmt:formatNumber value="${Personal_mgmt_ex.security}" pattern = "###,###,###"/></td>
		</c:forEach>
	</tr>
	<tr>
		<td>위탁관리수수료 </td>
		<c:forEach var = "Personal_mgmt_ex" items="${list }">
			<td><fmt:formatNumber value="${Personal_mgmt_ex.consignment }" pattern = "###,###,###"/></td>
		</c:forEach>
	</tr>
	<tr>
		<td>세대전기료 </td>
		<c:forEach var = "Personal_mgmt_ex" items="${list }">
			<td><fmt:formatNumber value="${Personal_mgmt_ex.personal_elec }" pattern = "###,###,###"/></td>
		</c:forEach>
	</tr>
	<tr>
		<td>공동전기료 </td>
		<c:forEach var = "Personal_mgmt_ex" items="${list }">
			<td><fmt:formatNumber value="${Personal_mgmt_ex.public_elec}" pattern = "###,###,###"/></td>
		</c:forEach>
	</tr>
	<tr>
		<td>TV수신료 </td>
		<c:forEach var = "Personal_mgmt_ex" items="${list }">
			<td><fmt:formatNumber value="${Personal_mgmt_ex.tv}" pattern = "###,###,###"/></td>
		</c:forEach>
	</tr>
	<tr>
		<td>세대수도료 </td>
		<c:forEach var = "Personal_mgmt_ex" items="${list }">
			<td><fmt:formatNumber value="${Personal_mgmt_ex.personal_water }" pattern = "###,###,###"/></td>
		</c:forEach>
	</tr>
	<tr>
		<td>세대급탕비 </td>
		<c:forEach var = "Personal_mgmt_ex" items="${list }">
			<td><fmt:formatNumber value="${Personal_mgmt_ex.personal_heat_water }" pattern = "###,###,###"/></td>
		</c:forEach>
	</tr>
	<tr>
		<td>생활폐기물 수거 </td>
		<c:forEach var = "Personal_mgmt_ex" items="${list }">
			<td><fmt:formatNumber value="${Personal_mgmt_ex.trash_pick_up  }" pattern = "###,###,###"/></td>
		</c:forEach>
	</tr>
	<tr>
		<td>입대위 운영비 </td>
		<c:forEach var = "Personal_mgmt_ex" items="${list }">
			<td><fmt:formatNumber value="${Personal_mgmt_ex.resident_repre }" pattern = "###,###,###"/></td>
		</c:forEach>
	</tr>
	<tr>
		<td>선관위 운영비 </td>
		<c:forEach var = "Personal_mgmt_ex" items="${list }">
			<td><fmt:formatNumber value="${Personal_mgmt_ex.emc }" pattern = "###,###,###원"/></td>
		</c:forEach>
	</tr>
	<tr>
		<td>미납여부 </td>
		<c:forEach var = "Personal_mgmt_ex" items="${list }">
			<td>${Personal_mgmt_ex.pay_check }</td>
		</c:forEach>
	</tr>
</table>
 
	
</body>
</html>