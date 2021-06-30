<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
<style type="text/css">
   td{
      border:1px solid black;
      height:40px;
      text-align:center;
      
   }
   td.blue{
         background-color:skyblue;
         width:200px;
   }
</style>
</head>
<body>
<div align="center">
   <h2>회원관리프로그램</h2>
   <form>
      <table width="800px">
         <tr>
         <td class="blue"><a name="main" href="main.jsp">처음으로</a></td>
         <td class="blue"><a name="join" href="join.jsp">회원가입</a></td>
         <td class="blue"><a name="view" href="view.jsp">회원보기</a></td>
         <td class="blue"><a name="search" href="search.jsp">회원찾기</a></td>
         </tr>
      </table>
   </form>
</div>
</body>
</html>