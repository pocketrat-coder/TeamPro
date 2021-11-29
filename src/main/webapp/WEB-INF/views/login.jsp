<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>

<link rel="stylesheet" href="resources/css/Login.css">

<body> 



	<h2>PROJECT_4 재고관리(가칭)</h2>
	<br/>
	<form action="loginOK" method="post">
		<div class="input-box">
			<div class="header-box">Login</div>
			<div class="body-box">
				<div class="body-input-box">
					<div class="hr-sect">login-erp</div>					
					<input type="text" name="id" placeholder="아이디" id="id" autocomplete="off"><br>
					<input type="password" name="pw" placeholder="비밀번호"><br>
				</div>
			</div>
			<div class="footer-box">
				<button type="submit" value="로그인">로그인</button>
			</div>
			<div>
				<p class="copylight">
				 	copylight 2021. PROJECT_4 재고관리(가칭)
				</p>
			</div>
		</div>	
	</form>

</body>
</html>