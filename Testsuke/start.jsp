<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="true"%>
<%@ page import="Model.Characters"%>
<%@ page import="java.util.LinkedList"%>

<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="test.css">
<%
	LinkedList chaList = (LinkedList) session.getAttribute("chaList");
LinkedList chaSize = (LinkedList) session.getAttribute("Chasize");
%>

</head>
<body align="center">

	<h1>人/キャラクター保存データベース</h1>
	<h3>
		現在
		<%=chaSize.size()%>
		名が登録されてます！！
	</h3>

<h5>＊名前に（）のついた上の5にんはサンプルです。修正、削除はできません</h5>
	<table >
		<tr>

			<form method=post action="insertInput.jsp"　>
				<input type="submit" value="新たに人を登録する" />
			</form>

		</tr>
	</table></br>


	<table align="center" border=2>
		<tr class="content">
			<th width=200>名前</th>
			<th width=200>年齢</th>
			<th width=200>出身</th>
			<th width=400>好きなこと・もの</th>
			<th width=400>その他</th>

		</tr>

		<%
			for (int i = 0; i < chaList.size(); i++) {
				Characters cha = (Characters) chaList.get(i);
		%>

		<tr class="row">
			<td><%=cha.getName()%></td>
			<td><%=cha.getAge()%></td>
			<td><%=cha.getHome()%></td>
			<td><%=cha.getLike()%></td>
			<td><%=cha.getOther()%></td>
			<td>
				<form method=post action="updateRequestServlet">
					<input type="hidden" name="RID" value=<%=cha.getRid()%> /> <input
						　	type="submit" value="修正" />
				</form>
			</td>
			<td>
				<form method=post action="deleteRequestServlet"　>
					<input type="hidden" name="RID" value=<%=cha.getRid()%> /> <input
						type="submit" value="削除" />
				</form>
			</td>

		</tr>
		<%
			}
		%>

	</table>


	<p>検索機能</p>



	<form method=post action="searchServlet">
		<p>年齢で検索します。数字を入れてください</p>
		<table align="center">
			<tr>
				<td><input type="text" name="Age">
				</td>
			<td>
			<select name="Size">
				<option value="0" selected />歳の人を探す
				<option value="1" />歳以上の人を探す
				<option value="2" />歳以下の人を探す
			</select>
				</td>
			</tr>
		</table>

	<input type="submit" value="検索" />
	</form></br>

	<form method=post action="startServlet"　>
		<input type="submit"  value="ホーム" />

	</form>


</body>
</html>
