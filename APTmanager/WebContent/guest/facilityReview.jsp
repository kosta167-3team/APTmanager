<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "guest.model.GuestRe" %>
    <%@page import="java.util.List"%>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            
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
   <h3>시설 후기 작성</h3>
   <hr>
   <form action="FaInsertReview.guest" method="post">
      시설ID : <input type="text" name="f_id"><br> 
      입주민 ID : <input type="text" name="R_id">
      별점 :  <input type="text" name="rev_rate">
      <br> 후기 <br>
      <textarea rows="6" cols="70" name="contents"></textarea>
      <br> <input type="submit" value="등록">
   </form>
   <br>
   <br>
   <br>
   
   <table width="500" border="1" cellpadding="0" cellspacing="0">
      <tr>
         <th>글번호</th>
         <th>입주민 id</th>
         <th>시설문번호</th>         
         <th>내용</th>         
         <th>날짜</th>   
         <th>별점 </th>
      </tr>
      
      <c:forEach var="GuestRe" items="${listRe }">
         <tr>
            <td> ${GuestRe.rev_id } </td>
            <td> ${GuestRe.r_id } </td>
            <td> ${GuestRe.f_id } </td>
            <td> ${GuestRe.rev_contents } </td>
            <td> ${GuestRe.rev_date } </td>
            <td> ${GuestRe.rev_rate } </td>            
         </tr>
      </c:forEach> 
   
   </table>
</body>
</html>