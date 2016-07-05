<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="jp.ac.kic.st.s15018.BookBean" %>
<%@ page import="jp.ac.kic.st.s15018.BookListBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	BufferedReader br = null;
	String line = null;
	String[] lib = null;
	BookBean bookBean = (BookBean)request.getAttribute("bookBean");
	if(bookBean == null){
		 bookBean = new BookBean();
	}
%>
<head>
<meta charset="utf-8">
<title>検索画面</title>
<link rel="stylesheet" type="text/css" href="lib.css">
<script type="text/javascript" src="code.js"></script>
</head>
<body>
	<div id="header">
		<h1>図書管理システム</h1>
	</div>
	<div id="user">
		<p>検索項目</p>
		<form action="SearchServlet" method="post">
			<label>図書名:
			<input type="text" name="book_name" value="<%=bookBean.getName() %>">
			</label>
			<br><br>
			<label>著者名:
			<input type="text" name="author" value="<%=bookBean.getAuthor() %>">
			</label>
			<br><br>
			<label>ISBN-13:
			<input type="text" name="isbn_13" value="<%=bookBean.getIsbn() %>">
			</label>
			<br><br>
			<label>
			<input type="checkbox" name="is_publised_year" value="true"  onclick="connecttext('published_year',this.checked);">
			出版年:</label>
			<select name="publised_year" id="published_year" disabled>
<%
			Calendar cal = Calendar.getInstance();
			int nowYear = cal.get(Calendar.YEAR);
			for(int i = nowYear; i > nowYear - 10; i--){
				if(i== bookBean.getPublishYear()){
					out.println("<option value=\"" + i +"\" selected>" + i + "</option>");
				}else{
					out.println("<option value=\"" + i +"\">" + i + "</option>");
				}
			}
%>
			</select>

			<br><br>
			<label>貸出状況:</label>
			<label>
			<input type="checkbox" name="unborrowed">未貸出
			</label>
			<label>
			<input type="checkbox" name="borrowed">貸出
			</label>

			<br><br>
			<input type="submit" value="検索">
			<input type="reset" value="リセット" onclick="disable('purchased_year');disable('published_year')">
			<input type="button" value="戻る" onClick="location.href='index.html'">
		</form>
	</div>


			<div id="search_result">
		<h1>検索結果</h1>
		<br>
		<h2>結果一覧</h2>
		<br>
		<center>
		<div id="result">
			<table>
				<thead>
					<tr>
						<th>図書名</th><th>著者名</th><th>ISBN-13</th><th>出版年</th><th>貸出状況</th>
					</tr>
				</thead>
				<tbody>
				<%
				BookListBean listBean = (BookListBean)request.getAttribute("listBean");
				if(listBean != null){
					for(int i=0; i<listBean.getSize(); i++){
						 out.println("<tr><td>" + listBean.get(i).getName() + "</td>");
						 out.println("<td>" + listBean.get(i).getAuthor() + "</td>");
				    	 out.println("<td>" + listBean.get(i).getIsbn() + "</td>");
						 out.println("<td>" + listBean.get(i).getPublishYear() + "</td>");
						 out.println("<td>" + listBean.get(i).getKashidashiString() + "</td></tr>" );
				    }
				}
				%>
				</tbody>
			</table>
		</div>
		</center>
		</div>


</body>
</html>