
<%@ page import="maintain_fees.model.Personal_mgmt_ex"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
			<td>월</td>

			<td>${Personal_mgmt_ex.p_month }</td>
			<td>지난달 비교
			<td>
		</tr>
		<tr>
			<td>일반 관리비</td>
			<td><fmt:formatNumber value="${Personal_mgmt_ex.general_mgmt }"	pattern="###,###,###" /></td>
			<td><fmt:formatNumber value="${compare.general_mgmt }"	pattern="###,###,###" /></td>


		</tr>
		<tr>
			<td>청소비</td>
			<td><fmt:formatNumber value="${Personal_mgmt_ex.clean }"	pattern="###,###,###" /></td>
			<td><fmt:formatNumber value="${compare.clean }"	pattern="###,###,###" /></td>

		</tr>
		<tr>
			<td>소독비</td>

			<td><fmt:formatNumber value="${Personal_mgmt_ex.fumigate }"	pattern="###,###,###" /></td>
			<td><fmt:formatNumber value="${compare.fumigate }"	pattern="###,###,###" /></td>

		</tr>
		<tr>
			<td>승강기유지비</td>

			<td><fmt:formatNumber	value="${Personal_mgmt_ex.elevator_maintain }"	pattern="###,###,###" /></td>
			<td><fmt:formatNumber value="${compare.elevator_maintain }"	pattern="###,###,###" /></td>

		</tr>
		<tr>
			<td>수선유지비</td>

			<td><fmt:formatNumber value="${Personal_mgmt_ex.repair }"	pattern="###,###,###" /></td>
			<td><fmt:formatNumber value="${compare.repair }"	pattern="###,###,###" /></td>

		</tr>
		<tr>
			<td>장기수선충당금</td>

			<td><fmt:formatNumber	value="${Personal_mgmt_ex.long_term_repair }" pattern="###,###,###" /></td>
			<td><fmt:formatNumber value="${compare.long_term_repair }"	pattern="###,###,###" /></td>

		</tr>
		<tr>
			<td>건물보험료</td>

			<td><fmt:formatNumber	value="${Personal_mgmt_ex.building_insurance }"	pattern="###,###,###" /></td>
			<td><fmt:formatNumber value="${compare.building_insurance }"	pattern="###,###,###" /></td>

		</tr>
		<tr>
			<td>경비비</td>

			<td><fmt:formatNumber value="${Personal_mgmt_ex.security}"	pattern="###,###,###" /></td>
			<td><fmt:formatNumber value="${compare.security }"	pattern="###,###,###" /></td>

		</tr>
		<tr>
			<td>위탁관리수수료</td>

			<td><fmt:formatNumber value="${Personal_mgmt_ex.consignment }"	pattern="###,###,###" /></td>
			<td><fmt:formatNumber value="${compare.consignment }"	pattern="###,###,###" /></td>

		</tr>
		<tr>
			<td>세대전기료</td>

			<td><fmt:formatNumber value="${Personal_mgmt_ex.personal_elec }"	pattern="###,###,###" /></td>
			<td><fmt:formatNumber value="${compare.personal_elec}"	pattern="###,###,###" /></td>

		</tr>
		<tr>
			<td>공동전기료</td>

			<td><fmt:formatNumber value="${Personal_mgmt_ex.public_elec}"	pattern="###,###,###" /></td>
			<td><fmt:formatNumber value="${compare.public_elec }"	pattern="###,###,###" /></td>

		</tr>
		<tr>
			<td>TV수신료</td>

			<td><fmt:formatNumber value="${Personal_mgmt_ex.tv}"	pattern="###,###,###" /></td>
			<td><fmt:formatNumber value="${compare.tv }"	pattern="###,###,###" /></td>

		</tr>
		<tr>
			<td>세대수도료</td>

			<td><fmt:formatNumber	value="${Personal_mgmt_ex.personal_water }" pattern="###,###,###" /></td>
			<td><fmt:formatNumber value="${compare.personal_water }"	pattern="###,###,###" /></td>

		</tr>
		<tr>
			<td>세대급탕비</td>

			<td><fmt:formatNumber	value="${Personal_mgmt_ex.personal_heat_water }"	pattern="###,###,###" /></td>
			<td><fmt:formatNumber value="${compare.personal_heat_water }"	pattern="###,###,###" /></td>

		</tr>
		<tr>
			<td>생활폐기물 수거</td>

			<td><fmt:formatNumber	value="${Personal_mgmt_ex.trash_pick_up  }" pattern="###,###,###" /></td>
			<td><fmt:formatNumber value="${compare.trash_pick_up }"	pattern="###,###,###" /></td>

		</tr>
		<tr>
			<td>입대위 운영비</td>

			<td><fmt:formatNumber	value="${Personal_mgmt_ex.resident_repre }" pattern="###,###,###" /></td>
			<td><fmt:formatNumber value="${compare.resident_repre }"	pattern="###,###,###" /></td>

		</tr>
		<tr>
			<td>선관위 운영비</td>

			<td><fmt:formatNumber value="${Personal_mgmt_ex.emc }"	pattern="###,###,###원" /></td>
			<td><fmt:formatNumber value="${compare.emc}"	pattern="###,###,###" /></td>

		</tr>
		<tr>
			<td>미납여부</td>

			<td>${Personal_mgmt_ex.pay_check }</td>
			<td>${compare.pay_check}
			<td>
		</tr>
	</table>


</body>
</html>