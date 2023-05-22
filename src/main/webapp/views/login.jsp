<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>
<body>
	
	<div class="wrapper fadeInDown">
			
			<c:if test="${not empty message}">
				<div class="alert alert-${alert}" role="alert">
				  ${message}
				</div>
			</c:if>
			
		<div id="formContent">
			<!-- Tabs Titles -->
	
			<!-- Icon -->
			<!-- <div class="fadeIn first">
				<img src="http://danielzawadzki.com/codepen/01/icon.svg" id="icon"
					alt="User Icon" />
			</div> -->

			<!-- Login Form -->
			<form action="<c:url value='/dang-nhap?action=login'/>"  id="formLogin" method="post" >
				<input type="text" id="login" class="fadeIn second" name="username" placeholder="UserName"> 
				<input type="password" id="password" class="fadeIn third" name="password" placeholder="Password"> 
				<input type="hidden" value="login" name="action" />
				<input type="submit" class="fadeIn fourth" value="Login">
			</form>

			<!-- Remind Passowrd -->
			<div id="formFooter">
				<a class="underlineHover" href="#">Forgot Password?</a>
			</div>

		</div>
	</div>
</body>
</html>