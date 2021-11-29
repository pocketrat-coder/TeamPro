<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sales</title>
<style type="text/css">
	.ch {
		width: 500px;
		height: 300px;
		border: 5px solid;
		overflow: auto;
	}
	.up {
        width: 50%;
        float: up;
        box-sizing: border-box;

    }
	
	
	.down {
        width: 50%;
        float: left;
        box-sizing: border-box;

    }


</style>
</head>
<body>

<!--  
<div class="ch">

	
	<c:forEach var="vo" items="${spendingList.list}">
	<div class="down" align="center">${vo.name}</td> 
	<div class="down" align="center">${vo.price}원</td>
	<div class="down" align="center">${vo.datetime}</td>	
	<br>
</c:forEach>
</div>
-->

<!-- text 2개 /etcInsert로 넘겨 받기  -->

<!-- 새로 작업 -->
<div class="profit" align="center">
	<h2>수입/지출 관리</h2>
	<table width="1750" align="center" border="1" cellpadding="8" cellspacing="0">
		<tr>
			<td width="100" align="center">종류</td>
			<td width="300" align="center">내역</td>
			<td width="100" align="center">개수</td>
			<td width="200" align="center">금액</td>
			<td width="300" align="center">수입</td>
			<td width="300" align="center">지출</td>
			<td width="400" align="center">datetime</td>
			<td width="50" align="center"></td>
		</tr>
		<c:set var="list" value="${spendingList.list}"/>
		
		<c:if test="${list.size() == 0}">
			<tr>
				<td colspan="8">
					<marquee>데이터베이스에 저장된 글이 없습니다.</marquee>
				</td>
			</tr>
		</c:if>
		
		<c:if test="${list.size() != 0}">
			<c:forEach var="vo" items="${list}">
				<tr>
					<td align="center">${vo.item}</td>
					<td align="center">${vo.name}</td>
					<td align="center">${vo.etc}</td>
					<td align="center">${vo.price}</td>
					<td align="center">+${vo.income}</td>
					<td align="center">-${vo.spending}</td>
					<td align="center">${vo.datetime} </td>
					<td align="center"><input type="checkbox" name="code"/></td> <!-- index 부분이나 선택이 있으면 좋겟음 -->
			</c:forEach>
		</c:if>
				</tr>
	
	<tr>
		<td colspan="4" align="center">총 지출 내역</td>
		<td align="center">${revenue}</td>
		<td align="center">${spending}</td>
		<td colspan="2" align="center">
			총 금액 : ${income}
		</td>
	</tr>	
		
	<tr>
		<td colspan="8" align="right">
			<input type="button" value="선택" onclick="location.href='#'"/>
			<input type="button" value="선택" onclick="location.href='#'"/>
		</td>
	</tr>
		
		
	</table>
</div>

</body>
</html>