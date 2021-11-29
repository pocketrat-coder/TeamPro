<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
</head>

<link rel="stylesheet" href="resources/css/main.css">

<body>

<div class="main">
	<div class="nav">
		<div class="header">
			<a class="home" href='main'>PROJECT_4 재고관리(가칭)</a>
		</div>
		<div class="loginStatus-Box">
			<div class="loginStatus-Box-define">
				로그인&nbsp;:  
			</div>
			<div id="login">
				<ul>
					<li>
						<a href="#">${id}님</a>
						<ul>
							<li>
								<a class="logout" href="logout">로그아웃</a>
							</li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</div>

	<div class="menu">
		<div id="menu-bar">
			<ul>
				<li>
					<a href="product">물품</a>
					<ul>
						<li><a href="#">등록</a></li>
						<li><a href="#">폐기</a></li>
					</ul>
				</li>
				<li>
					<a href="profit">매출</a>
					<ul>
						<li><a href="#">선택</a></li>
						<li><a href="#">선택</a></li>
					</ul>
				</li>
				<li>
					<a href="employee">직원</a>
					<ul>
						<li><a href="#">@@</a></li>
						<li><a href="#">@@</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
		
	<div class="body">
		<div class="body-box">
			<div class="body-box-div1">
				<table width="600" align="center" border="1" cellpadding="3" cellspacing="0">
					<div class="notice"> 
						공지
					</div>
					<tr>
						<td width="100" align="center">작성일</td>
						<td width="500" align="center">내용</td>
					</tr>
					<!--  
					<c:set var="list" value="${productList.list}"/>
					<c:if test="${list.size() == 0}">
						<tr>
							<td colspan="3">
								<marquee>현제 공지 사항 없음</marquee>
							</td>
						</tr>
					</c:if>
					
					<c:if test="${list.size() != 0}">
						<c:forEach var="vo" items="${list}">
							<tr>
								<td align="center">${vo.name}</td>
								<td align="center">${vo.code}</td>
								<td align="center">${vo.price}</td>
								<td align="center">${vo.expireDate} </td>
								<td align="center"><input type="checkbox" name="code"/></td>
							</c:forEach>
						</c:if>
					</tr>
					-->
					<tr>
						<td class="content">
							${notice.datetime}
						</td>
						<td class="content">
							<marquee>${notice.content}</marquee>
						</td>
					</tr>
				</table>
			</div>
			<div class="body-box-div2">
				<button class="body-box-div2-circle" value="물품" onclick="location.href='product'">물품</button>
				<button class="body-box-div2-circle" value="매출" onclick="location.href='profit'">매출</button>
				<button class="body-box-div2-circle" value="직원" onclick="location.href='employee'">직원</button>
			</div>
		</div>
		
	</div>
	
</div>

	

</body>
</html>