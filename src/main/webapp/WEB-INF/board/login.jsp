<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<center>
<form action="login.do" method="post">
<table border="1" cellpadding="0" cellspacing="0">
	
	<tr>
		<td bgcolor="orange">아이디</td>
		<td><input type="text" name="id" size="20" value="${user.id}"/></td>  
		<!-- 컨트롤러(loginView)에서 매개변수로 VO 객체 받았으므로 화면에 뿌릴수 있는 것  -->
	</tr>
	
	<tr>
		<td bgcolor="orange">비밀번호</td>
		<td><input type="password" name="password" size="20" value="${user.password}"/></td>
	</tr>

	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="로그인" />
		</td>
	</tr>
</table>
</form>
</center>

<%@ include file="../layout/footer.jsp" %>


<!-- request에 userVO로 등록된 객체 있는 이유 : UserController의 loginView에서 UserVO를 매개변수로 받았기때문 -->