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
	<form action="${ctx}/updateUser.do" method="post">
		<table class="table table-bordered">
			<tr>
				<td>아이디</td>
				<td class="left">${vo.id}</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input class="col-12" type="text" name="pw" value="${vo.pw}" />
				</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>
					<input class="col-12" type="text" name="email" value="${vo.email}" />
				</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td>
					<input class="col-12" type="tel" name="tel" value="${vo.tel}" />
				</td>
			</tr>
			<tr>
				<td>취미</td>
				<td>
					<input class="col-12" type="text" name="hobby" value="${vo.hobby}" />
				</td>
			</tr>
			<tr>
				<td>직업</td>
				<td>
					<input class="col-12" type="text" name="job" value="${vo.job}" />
				</td>
			</tr>
			<tr>
				<td>나이</td>
				<td>
					<input class="col-12" type="number" name="age" value="${vo.age}" />
				</td>
			</tr>
			<tr>
				<td>소개</td>
				<td>
					<input class="col-12" type="text" name="info" value="${vo.info}" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="수정하기" class="col-5 btn btn-primary" />
				</td>
			</tr>
		</table>
	</form>
	<input type="button" value="삭제하기" class="col-5 btn btn-primary" onclick="${ctx}/deleteUser.do?id=${vo.id}" />
</body>
</html>