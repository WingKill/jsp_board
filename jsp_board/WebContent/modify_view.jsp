<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 수정창</h1>
	<form action="modify.do" method="post">
		<input type="hidden" name="bid" value="${content_view.bid}">	
		<table border="1" style="width: 500; background-color: gray;">
			<tr>
				<td style="background-color: pink">글 번호</td>
				<td style="background-color: white">${content_view.bid}</td>
			</tr>
			<tr>
				<td style="background-color: pink">이름</td>
				<td style="background-color: white"><input type="text" name="bname" size="50" value="${content_view.bname}" readonly="readonly"></td>
			</tr>
			<tr>
				<td style="background-color: pink">제목</td>
				<td style="background-color: white"><input type="text" name="btitle" size="50" value="${content_view.btitle}"></td>
			</tr>
			<tr>
				<td style="background-color: pink">내용</td>
				<td style="background-color: white"><textarea name="bcontent" rows="10">${content_view.bcontent}</textarea></td>
			</tr>
			<tr>
				<td style="background-color: pink" colspan="2"><input type="submit" value="수정하기">&nbsp;&nbsp;<a href="list.do">목록보기</a> </td>
			</tr>
		</table>
	</form>
</body>
</html>