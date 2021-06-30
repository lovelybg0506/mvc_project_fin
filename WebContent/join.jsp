<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join</title>
</head>
<body>
<div align="center">
<h3>회원 가입</h3>
<form action="custom.do" method="post">
   <table align="center" height="500px" width="550px">
      <tr>
         <td align="center">아이디</td>
         <td><input type="text" name="id"></td>
      </tr>
      <tr>
         <td align="center">비밀번호</td>
         <td><input type="password" name="pwd"></td>
      </tr>
      <tr>
         <td align="center">이름</td>
         <td><input type="text" name="name"></td>
      </tr>
      <tr>
         <td align="center">이메일</td>
         <td><input type="text" name="email"></td>
      </tr>
      <tr>
         <td align="center">전화번호</td>
         <td><input type="text" name="phone"></td>
      </tr>
      <tr>
         <td align="center">성별</td>
         <td>
            <select name="gender">
               <option value="남자">남자</option>
               <option value="여자">여자</option>
            </select>
         </td>
      </tr>
      <tr align="center">
         <td colspan = "2">
            <input type = "submit" value = "가입">
            <input type = "reset" value = "취소">
            <input type = "button" value = "메인 페이지로 이동" onclick = "location.href='main.jsp'">
         </td>
      </tr>
   </table>
</form>
</div>
</body>
</html>