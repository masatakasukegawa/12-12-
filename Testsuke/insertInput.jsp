<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="true"%>
<%@ page import="Model.Characters"%>

<!DOCTYPE html>
<html lang="ja">

  <head><meta charset="UTF-8">
    <%
  	Characters chaInsert = new  Characters();

    if (session.getAttribute("CharacterInsert") != null) {
  		chaInsert = (Characters) session.getAttribute("CharacterInsert");
  	}
  %>
  </head>
  <body align="center">
 <p> 追加する人の情報を入力してください</p>

    <form method=post action="confirmInsertServlet">
  <table align="center" border="2">
	     <tr><td>    名前</td><td> <input type="text" name="Name"  value="<%if(chaInsert.getName()!=null){%><%=chaInsert.getName()%><%}%>"/></td></tr>
	      <tr><td>年齢 </td><td><input type="text" name="Age" /></td></tr>
	      <tr><td>出身 </td><td><input type="text" name="Home" value="<%if(chaInsert.getHome()!=null){%><%=chaInsert.getHome()%><%}%>"/></td></tr>
	    <tr><td>  好きなもの・こと</td><td> <input type="text" name="Like" value="<%if(chaInsert.getLike()!=null){%><%=chaInsert.getLike()%><%}%>"/></td></tr>
	    <tr><td> その他 </td><td><input type="text" name="Other" value="<%if(chaInsert.getOther()!=null){%><%=chaInsert.getOther()%><%}%>"/></td></tr>
		</table></br>
		<input type="submit" value="新規作成" />
	</form></br>


	<form method=post action="startServlet"　>

		<input type="submit"  value="一覧に戻る" />

	</form>

  </body>
</html>