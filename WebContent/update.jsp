<%@page import="com.project.dto.BoardVO"%>
<%@page import="com.project.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>
</head>
<body>
<%
	String id=request.getParameter("id");
	BoardDAO bdao = BoardDAO.getInstance();
	BoardVO bvo = bdao.getMember(id);
%>
<div align="center">
<h3>회원 정보 수정하기</h3>
<form action="updateproc.jsp" method="post">
<table width="400" border="1">
		<tr height= "50">
			<td align="center" width="150">아이디</td>
			<td width = "250"><input type="hidden" name="id" value="<%=id %>"><%=id %></td>
		</tr>
		
		<tr height= "50">	
			<td align="center" width="150">이메일</td>
			<td width="250">
			<input type ="email" name="email" value="<%=bvo.getEmail() %>">
			</td>
		</tr>
		
		<tr height = "50">
			<td align="center" width="150">전화번호</td>
			<td width="250">
			<input type="text" name="phone" value="<%=bvo.getPhone() %>">
			</td>
		</tr>
		<tr height = "50">
			<td align="center" width="150">암호</td>
			<td width="250">
				<input type="password" name="pwd">
			</td>
		</tr>
		<tr height="50">
			<td align="center" colspan="2">
				<input type="hidden" name="id" value="<%=bvo.getId() %>">
				<input type="submit" value="회원 수정">&nbsp;&nbsp;				
				<button type ="button" onclick="location.href ='view.jsp'">회원 전체 보기</button>				
			</td>
		</tr>
</table>
</form>
</div>
</body>
</html>