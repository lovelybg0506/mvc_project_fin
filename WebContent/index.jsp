<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
<%
	response.sendRedirect("main.jsp"); //리다이렉트는 다시 접속해 라는뜻
%>

<!-- 
create table Board(
id varchar2(10) not null,
pwd varchar2(10) not null,
name varchar2(24),
email varchar2(30),
phone varchar2(30),
gender char(10) default '1',
primary key(id)
);
 -->
</body>
</html>