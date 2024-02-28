<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>
</head>
<body>
	<h1>게시글 리스트</h1>
	<table border="1" style="width: 500">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td>조회수</td>
		</tr>
	<c:forEach var="board" items="${boards}">
		<tr>
			<td>${board.bid}</td>
			<td>${board.bname}</td>
			<td>
				<c:forEach begin="1" end="${board.bindent}">
					[Re]
				</c:forEach>
				<a href="content_view.do?bid=${board.bid}">${board.btitle}</a>
			</td>
			<td>${board.bdate}</td>
			<td>${board.bhit}</td>
		</tr>		
	</c:forEach>
		<tr>
			<td colspan="5"><a href="write_view.do">글작성</a></td>
		</tr>	
	</table>
</body>
</html>