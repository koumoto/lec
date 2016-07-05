<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jp.ac.kic.st.s15018.BookBean" %>
<%
	BookBean bean =(BookBean) request.getAttribute("bean");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>図書を登録しました。</title>
<link rel="stylesheet" type="text/css" href="lib.css">
</head>
<body>
	<div id="header">
		<h1>図書管理システム</h1>
	</div>
	<div id="user">
 	<p>以下の図書を登録しました。</p>
	<p>図書名:<%=bean.getName() %></p>
	<p>著者名:<%=bean.getAuthor() %></p>
	<p>ISBN-13:<%=bean.getIsbn() %></p>
	<p>購入年:<%=bean.getPublishYear() %></p>
	<br><br>
	<input type="button" value="戻る" onClick="location.href='admin_register.html'">
	<input type="button" value="ログアウト" onClick="location.href='login.html'">
	</div>
</body>
</html>