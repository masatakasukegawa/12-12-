package DataBase;
import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Characters;
import DataBase.CharacterManager;

//ホームにもどるときプログラムです。表示するべきリストを選んでstart.jspにとびます

//このファイルのURLです
@WebServlet(urlPatterns = { "/startServlet" })

//=============================ここはサーブレットとして使うために必要な箇所です　全サーブレット共通です　ここから

public class startServlet  extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doMain(req,resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doMain(req,resp);
	}

	protected void doMain(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		HttpSession session = req.getSession();
		//==========================================================================ここまで


		 CharacterManager cm = new CharacterManager();

		  	Characters chaInsert = new  Characters();

		  	//「新規作成のときエラーがでるとデータがいったん保持される仕様にしてます。そのとき保持されたデータを残しておくといつまでもほじされたままなのでここで削除します
		    if (session.getAttribute("CharacterInsert") != null) {
		  		chaInsert = (Characters) session.getAttribute("CharacterInsert");
		  		cm.clear(chaInsert);
		  	}

		  	Characters chaUpdate = new  Characters();
		  	//上のコメントと同じ理由で保持データを削除してます
		    if (session.getAttribute("CharacterUpdate") != null) {
		  		chaUpdate = (Characters) session.getAttribute("CharacterUpdate");
		  		cm.clear(chaUpdate);
		  	}

		    //データベースの一覧をここでつくる
		LinkedList chaList= cm.getList();
		//データベースに何人保存されてるか確認するためこのリストも同時につくってます。start.jspで表示する用です
		LinkedList chasize=cm.getList();

		//セッションへの保存
		session.setAttribute("Chasize", chasize);
		session.setAttribute("chaList", chaList);

		//ホームへとびます
		req.getRequestDispatcher("/start.jsp").forward(req, resp);


}

}
