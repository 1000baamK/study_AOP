<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>카테고리 추가</h1>
	
	<form action="insert" method="post">
		카테코리 번호 : <input type="number" name="category_no"><br>
		카테고리 이름 : <input tpye="text" name="category_name">
		<button type="submit">가자!</button>
	</form>
</body>
</html>