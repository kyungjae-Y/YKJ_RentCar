<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${ctx}/userAdd.do" method="post">
		<table class="table table-bordered">
			<tr>
				<td>아이디</td>
				<td>
					<input class="col-5" type="text" name="id" id="id" autofocus required />
					<input type="button" value="중복체크" id="checkId" class="btn btn-outline-dark" />
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input class="col-5" type="password" name="pw" id="pw" required />
				</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>
					<input class="col-5" type="email" name="email" id="email" required />
				</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td>
					<input class="col-5" type="tel" name="tel" id="tel" required />
				</td>
			</tr>
			<tr>
				<td>취미</td>
				<td>
					<input class="col-5" type="text" name="hobby" id="hobby" required />
				</td>
			</tr>
			<tr>
				<td>직업</td>
				<td>
					<input class="col-5" type="text" name="job" id="job" required />
				</td>
			</tr>
			<tr>
				<td>나이</td>
				<td>
					<input class="col-5" type="number" name="age" id="age" required />
				</td>
			</tr>
			<tr>
				<td>소개</td>
				<td>
					<input class="col-5" type="text" name="info" id="info" required />
				</td>
			</tr>
			<tr>
				<td colspan="2" id="btns" align="center">
					<input type="button" value="가입" class="col-3 btn btn-primary" onclick="validCheck(form)" />
					<input type="reset" value="취소" class="col-3 btn btn-warning" />
				</td>
			</tr>
		</table>
	</form>
</body>
<script src="${ctx}/script/join.js"></script>
</html>