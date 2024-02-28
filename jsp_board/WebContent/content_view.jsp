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
	<h1>글 보기</h1>
	<form action="modify_view.do" method="post">
		<input type="hidden" name="bid" value="${content_view.bid}">	
		<table border="1" style="width: 500; background-color: gray;">
			<tr>
				<td style="background-color: pink">번호</td>
				<td style="background-color: white" >${content_view.bid}</td>
			</tr>
			<tr>
				<td style="background-color: pink">조회수</td>
				<td style="background-color: white" ><input type="text" name="bhit" size="50" value="${content_view.bhit}" readonly="readonly"></td>
			</tr>
			<tr>
				<td style="background-color: pink">이름</td>
				<td style="background-color: white"><input type="text" name="bname" size="50" value="${content_view.bname}" readonly="readonly"></td>
			</tr>
			<tr>
				<td style="background-color: pink">제목</td>
				<td style="background-color: white"><input type="text" name="btitle" size="50" value="${content_view.btitle}" readonly="readonly"></td>
			</tr>
			<tr>
				<td style="background-color: pink">내용</td>
				<td style="background-color: white"><textarea name="bcontent" rows="10" readonly="readonly">${content_view.bcontent}</textarea></td>
			</tr>
			<tr>
				<td style="background-color: pink" colspan="2">
					<input type="submit" value="수정">
					&nbsp;&nbsp;<a href="list.do">목록보기</a>
					&nbsp;&nbsp;<a href="delete.do?bid=${content_view.bid}">삭제</a> 
					&nbsp;&nbsp;<a href="reply_view.do?bid=${content_view.bid}">답변</a> 
				</td>
			</tr>
		</table>
	</form>
</body>
</html>