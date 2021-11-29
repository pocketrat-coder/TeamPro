<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>물품 관리 페이지</title>
</head>
<link rel="stylesheet" href="resources/css/product.css">
<body>

<form id="form1" method="post">
	<div id="title" align="center">
		<h2>물품 보기</h2>
	<table width="1000" align="center" border="1" cellpadding="5" cellspacing="0">
		<tr>
			<th width="300" align="center">이름</th>
			<th width="600" align="center">바코드</th>
			<th width="200" align="center">가격</th>
			<th width="650" align="center">유통기한</th>
			<th align="center"><input type="button" value="판매" onclick="form1.action='productSell'"/></th>
			<th align="center"><input type="button" value="폐기" onclick="form1.action='productDispose'"/></th>
		</tr>
		<c:set var="list" value="${productList.list}"/>
		<c:if test="${list.size() == 0}">
		<tr>
			<td colspan="5">
				<marquee>데이터베이스에 저장된 글이 없습니다.</marquee>
			</td>
		</tr>
		</c:if>
		
			<c:if test="${list.size() != 0}">
				<c:forEach var="vo" items="${list}">
					<tr id="pr">
					<td align="center">${vo.name}</td>
					<td align="center">${vo.code}</td>
					<td align="center">${vo.price}</td>
					<td align="center">${vo.expireDate} </td>
					<td align="center"><input type="checkbox" name="code" value="${vo.code}"/></td>
				</c:forEach>
			</c:if>
	
			<form action="productAdd" method="post">
			<tr>
				<td colspan="5" align="right">
					<input type="text" name="name" placeholder="이름"/>
					<input type="number" name="sellPrice" placeholder="판매가격"/>
					<input type="number" name="num" placeholder="개수"/>
					<input type="number" name="price" placeholder="주문금액"/>
					<input type="date" name="expireDate1" placeholder="유통기한"/>
					<input type="submit" value="추가">
				</td>
			</tr>
		</form>
	</table>
	</div>
</form>


<!-- 		<tr>
			<td colspan="5" align="right">
				<td align="center"><input type="button" value="판매" onclick="form1.action='productSell'"/></td>
					<td align="center"><input type="button" value="폐기" onclick="form1.action='productDispose'"/></td>
			</td>
		</tr>  -->


</body>
</html>