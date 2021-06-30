<%@page import="com.project.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deleteproc</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<jsp:useBean id="bvo" class="com.project.dto.BoardVO">
		<jsp:setProperty name="bvo" property="*"/>
	</jsp:useBean>
<%
	String id=request.getParameter("id"); 
	BoardDAO bdao= BoardDAO.getInstance();
	String pass = bdao.getPwd1(id);
	
	if (bvo.getPwd() != null) {
	      if(bvo.getPwd().equals(pass)){
	         bdao.deleteMember(id);
	         response.sendRedirect("view.jsp");
	      }else{
	%>
	      <script type="text/javascript">
	         alert("패스워드가 맞지 않습니다. 다시 확인해 주세요!!!");
	         history.go(-1);
	      </script>
	<%
	      }
	   }else{
	%>
	   <script type="text/javascript">
	      alert("패스워드를 입력해주세요!!!");
	      history.go(-1);
	      </script>
	<%
	   }
	%>
</body>
</html>