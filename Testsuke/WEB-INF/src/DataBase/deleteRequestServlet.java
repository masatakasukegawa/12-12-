package DataBase;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Characters;
import DataBase.CharacterManager;
//データを削除するか確認するときにつかうプログラムです。confirmDelete.jspにとびます

//このファイルのURLです
@WebServlet(urlPatterns = { "/deleteRequestServlet" })
//=============================ここはサーブレットとして使うために必要な箇所です　全サーブレット共通です　ここから
public class deleteRequestServlet extends HttpServlet {
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
		//IDを文字列でうけとって変換しintに代入します。
		String ridStr = req.getParameter("RID");
		int	rid = Integer.parseInt(ridStr);

		//サンプルを削除しようとするとエラーが出るようになっています。きたろうのRIDが9番なのでrid＜10になてます

		if(rid<10) {
			req.getRequestDispatcher("/ErrorMeDelete.jsp").forward(req, resp);

		}

		//RIDが一致するレコードをとってきて代入
		Characters cha = cm.get(rid);

		//セッションにせっと
		session.setAttribute("Character", cha);
		//confirmDelete.jspにとぶ
		req.getRequestDispatcher("/confirmDelete.jsp").forward(req, resp);


}
}

