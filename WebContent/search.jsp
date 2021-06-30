<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>search</title>
</head>
<body>
<form action="search.do" method="post">
   <table align="center" width="800px">
      <tr><td colspan="2">이름을 입력하세요</td></tr>
      <tr>
         <td><input type="text" name="name"></td>
         <td><input type="submit" value="찾기"></td>
      </tr>
   </table>
</form>
</body>
</html>
