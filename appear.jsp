<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="db.Appear, java.util.List"%>
<%
List<Appear> appearList = (List<Appear>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		<a href="AppearServlet">ポケモン出現DB</a>
	</h1>
	<hr>
	<form action="AppearServlet" method="POST">
		<input type="radio" name="item" value="ID" checked="checked">ID
		<input type="radio" name="item" value="番号">番号 <input
			type="radio" name="item" value="名前">名前 <br> <input
			type="radio" name="order" value="asc" checked="checked">昇順 <input
			type="radio" name="order" value="desc">降順 <br> <input
			type="submit" name="submit" value="並び替え">
		<hr>
		<input type="radio" name="type" value="あく">あく
		<input type="radio" name="type" value="いわ" >いわ
		<input type="radio" name="type" value="かくとう" >かくとう
		<input type="radio" name="type" value="くさ" >くさ
		<input type="radio" name="type" value="こおり" >こおり
		<input type="radio" name="type" value="じめん" >じめん
		<input type="radio" name="type" value="でんき" >でんき
		<input type="radio" name="type" value="どく" >どく
		<input type="radio" name="type" value="はがね" >はがね<br>
		<input type="radio" name="type" value="ひこう" >ひこう
		<input type="radio" name="type" value="ほのお" >ほのお
		<input type="radio" name="type" value="みず" >みず
		<input type="radio" name="type" value="むし" >むし
		<input type="radio" name="type" value="エスパー" >エスパー
		<input type="radio" name="type" value="ゴースト" >ゴースト
		<input type="radio" name="type" value="ドラゴン" >ドラゴン
		<input type="radio" name="type" value="ノーマル" >ノーマル
		<input type="radio" name="type" value="フェアリー" >フェアリー
		<input type="submit" name="submit" value="タイプ選択">
		<hr>
		番号<input type="text" name="newnumber"> 市コード<input type="text"
			name="newshicode"> <input type="submit" name="submit"
			value="登録">
		<hr>
		ID<input type="text" name="deleteid"> <input type="submit"
			name="submit" value="削除">
	</form>
	<hr>
	<a href="AppearServlet?shimei=習志野市">習志野市</a>
	<a href="AppearServlet?shimei=船橋市">船橋市</a>
	<hr>
	<%
	if (appearList != null) {
	%>
	出現情報
	<table border="1">
		<tr>
			<th>ID</th>
			<th>番号</th>
			<th>画像</th>
			<th>名前</th>
			<th>タイプ</th>
			<th>県名</th>
			<th>市名</th>
			<th>日付</th>
			<th>時刻</th>
		</tr>
		<%
		for (Appear appear : appearList) {
		%>
		<tr>
			<td><%=appear.getId()%></td>
			<td><%=appear.getnumber()%></td>
			<td><img src="https://image.boom-app.wiki/wiki/59fab19d3d1bee03b541dcd5/pokemon/l/
			<%= String.format("%03d", appear.getnumber()) %>.jpg?w=50"></td>
			<td><%=appear.getName()%></td>
			<td><%=appear.gettype()%></td>
			<td><%=appear.getken()%></td>
			<td><%=appear.getshi()%></td>
			<td><%=appear.getdate()%></td>
			<td><%=appear.gettime() %></td>
		</tr>
		<% } %>
	</table>
	<% } %>
</body>
</html>