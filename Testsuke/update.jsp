<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="true"%>
<%@ page import="Model.Characters"%>

<!DOCTYPE html>
<html lang="ja">

  <head><meta charset="UTF-8">
  <%
  	Characters cha = new  Characters();

    if (session.getAttribute("Character") != null) {
  		cha = (Characters) session.getAttribute("Character");
  	}

  	Characters chaUpdate = new  Characters();

    if (session.getAttribute("CharacterUpdate") != null) {
  		chaUpdate = (Characters) session.getAttribute("CharacterUpdate");
  	}
  %>
  </head>
  <body align="center">
 <p> 修正する情報を入力してください</p>

    <form method=post action="confirmUpdateServlet">
	      <input type="hidden" name="RID" value="<%=cha.getRid()%>"/>
	      <table align="center" border="2">
	    <tr><td> 名前</td><td> <input type="text" name="Name" value="<%if(chaUpdate.getName()!=null){%><%=chaUpdate.getName()%><%}else{%><%=cha.getName()%><%}%>"/></td></tr>
	     <tr><td> 年齢 </td><td><input type="text" name="Age" value="<%=cha.getAge()%>"/></td></tr>
	      <tr><td>出身 </td><td><input type="text" name="Home" value="<%if(chaUpdate.getHome()!=null){%><%=chaUpdate.getHome()%><%}else{%><%=cha.getHome()%><%}%>"/></td></tr>
	      <tr><td>好きなもの・こと </td><td><input type="text" name="Like" value="<%if(chaUpdate.getLike()!=null){%><%=chaUpdate.getLike()%><%}else{%><%=cha.getLike()%><%}%>"/></td></tr>
	      <tr><td>その他 </td><td><input type="text" name="Other" value="<%if(chaUpdate.getOther()!=null){%><%=chaUpdate.getOther()%><%}else{%><%=cha.getOther()%><%}%>"/></td></tr>
		</table></br>
		<input type="submit" value="情報の修正" />
	</form></br>


	<form method=post action="startServlet"　>

		<input type="submit"  value="一覧に戻る" />

	</form>

  </body>
</html>