<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>Insert title here</title>
</head>
<body>
	<form action="insertCar.do" method="post" enctype="multipart/form-data">
		<table class="table table-bordered">
			<tr>
				<td>이름</td>
				<td>
					<input class="col-5" type="text" name="name" id="name" required />
				</td>
			</tr>
			<tr>
				<td>카테고리</td>
				<td>
					<input class="col-5" type="number" name="category" id="category" required />
				</td>
			</tr>
			<tr>
				<td>가격</td>
				<td>
					<input class="col-5" type="number" name="price" id="price" required />
				</td>
			</tr>
			<tr>
				<td>승차 인원</td>
				<td>
					<input class="col-5" type="number" name="usepeople" id="usepeople" required />
				</td>
			</tr>
			<tr>
				<td>남은 개수</td>
				<td>
					<input class="col-5" type="number" name="total_qty" id="total_qty" required />
				</td>
			</tr>
			<tr>
				<td>회사</td>
				<td>
					<input class="col-5" type="text" name="company" id="company" required />
				</td>
			</tr>
			<tr>
				<td>이미지</td>
				<td>
					<input type="file" name="uploadFile" accept="img/*" />
				</td>
			</tr>
			<tr>
				<td>정보</td>
				<td>
					<input class="col-5" type="text" name="info" id="info" required />
				</td>
			</tr>
			<tr>
				<td colspan="2" id="btns" align="center">
					<input type="submit" value="등록하기" class="col-3 btn btn-primary" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>