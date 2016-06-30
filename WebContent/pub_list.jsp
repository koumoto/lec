<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
BufferedReader br = null;
String line = null;
String[] lib = null;

%>

<head>
<meta charset="UTF-8">
<title>検索結果</title>
<link rel="stylesheet" type="text/css" href="lib.css">
</head>
<body>
	<div id="header">
		<h1>図書管理システム</h1>
	</div>
	<div id="search_result">
		<h1>検索結果</h1>
		<br>
		<br>
		<h2>結果一覧</h2>
		<br>
		<center>
		<div id="result">
			<table>
				<thead>
					<tr>
						<th>図書名</th><th>著者名</th><th>ISBN-13</th><th>出版年</th><th>購入年</th><th>貸し出し状況</th>
					</tr>
				</thead>
				<tbody>
				<%
				try {
				    File file = new File(application.getRealPath("/WEB-INF/library.csv")); // CSVデータファイル
				    br = new BufferedReader(new FileReader(file));
				    while ((line = br.readLine()) != null) {
				    	lib = line.split(",");
				    	out.println("<tr><td>" + lib[0] + "</td><td>" + lib[1] +"</td><td>" + lib[2] + "</td><td>" + lib[3] + "</td><td>" + lib[4] +"</td><td>" + lib[5] +"</td></tr>");
				    }
				}catch(Exception e){
					out.print(e);
				}finally{
					br.close();
				}
				%>

				</tbody>
			</table>
		</div>
		<input type="button" value="戻る" onClick="location.href='pub_search.html'">
		</center>
		</div>

</body>
</html>