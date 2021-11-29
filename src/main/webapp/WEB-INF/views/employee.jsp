<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employee</title>
</head>
<link rel="stylesheet" href="resources/css/employee.css">
<body>

<form action="update" method="post">
	<div id="title" align="center">
		<h2>직원 명단</h2>
	<table width="1000" align="center" border="1" cellpadding="5" cellspacing="0">
		<tr>
			<th width="300" align="center">직원 번호</th>
			<th width="300" align="center">이름</th>
			<th width="300" align="center">시급</th>
		</tr>
		<c:set var="list" value="${employeeList.list}"/>
		<c:forEach var="vo" items="${list}">
			<tr id="em">
			<td align="center">${vo.idx}</td>
			<td align="center">${vo.name}</td>
			<td align="center">${vo.wage}<input type="text" name="workpay" value="근무시간"/><input type="button" name="pay" value="급여지급"/><input type="button" name="fire" value="해고"/></td>			
		</c:forEach>
			</tr>
		<td colspan="5" align="center">
			<input type="text" name="name" placeholder="이름"/>
			<input type="number" name="price" placeholder="시급" />
			<input type="button" value="고용" onclick="location.href='insertEmployee?id=${vo.id}"/>
		</td>
	</table>
	</div>
	</form>
</body> 
</html>