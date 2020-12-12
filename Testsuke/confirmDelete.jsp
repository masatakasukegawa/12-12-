<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="true"%>
<%@ page import="Model.Characters"%><!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">

<%
	Characters cha = new  Characters();

if (session.getAttribute("Character") != null) {
		cha = (Characters) session.getAttribute("Character");
	}
%>

</head>
<body>

	<p align=center>削除の確認</p>
	<table border=2 width=500 align=center>
		<tr>
			<td align=center width=100>名前</td>
			<td><%=cha.getName()%></td>

		</tr>
		<tr>
			<td align=center width=100>年齢</td>
			<td><%=cha.getAge()%></td>

		</tr>
		<tr>
			<td align=center width=100>出身</td>
			<td><%=cha.getHome()%></td>

		</tr>
		<tr>
			<td align=center width=100>好きなもの・こと</td>
			<td><%=cha.getLike()%></td>

		</tr>
		<tr>
			<td align=center width=100>その他</td>
			<td><%=cha.getOther()%></td>

		</tr>

	</table>
<p align=center>この情報を削除します。よろしいでしょうか</p>
<table align = center>
<tr>
<td>
	<form method=post action="deleteServlet">
		<input type="submit" value="はい" />
	</form>
</td>
<td>
	<form method=post action="startServlet">
		<input type="submit" value="いいえ" />
	</form>
</td>
</tr>
</table>

</body>
</html>


