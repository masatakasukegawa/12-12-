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
  %>
  </head>
  <body>
 <p> characterの中身</p>

       RID<input type="text" name="RID" value="<%=cha.getRid()%>"/>
	      名前 <input type="text" name="Name" value="<%=cha.getName()%>"/><br />
	      年齢 <input type="text" name="Age" value="<%=cha.getAge()%>"/><br />
	      出身 <input type="text" name="Home" value="<%=cha.getHome()%>"/><br />
	      好きなもの・こと <input type="text" name="Like" value="<%=cha.getLike()%>"/><br />
	      その他 <input type="text" name="Other" value="<%=cha.getOther()%>"/><br />

	<form method=post action="startServlet"　>
		<input type="submit"  value="一覧に戻る" />

	</form>

  </body>
</html>