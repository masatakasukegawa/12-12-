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
//テーブルにアップデートを要求するときに使うプログラムです。upddate.jspにとびます

//このファイルのURLです
@WebServlet(urlPatterns = { "/updateRequestServlet" })

//=============================ここはサーブレットとして使うために必要な箇所です　全サーブレット共通です　ここから
public class updateRequestServlet extends HttpServlet {
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
		String ridStr = req.getParameter("RID");
		int	rid = Integer.parseInt(ridStr);

		//サンプルの修正を選択するとエラーが出るようになっています。きたろうのRIDが9番なのでrid＜10になてます
		if(rid<10) {
			req.getRequestDispatcher("/ErrorMeUpdate.jsp").forward(req, resp);

		}

		//RIDを入力してそのレコードをとりだす
		Characters cha = cm.get(rid);

		//セッションにせっと
		session.setAttribute("Character", cha);
		//update.jspにとぶ
		req.getRequestDispatcher("/update.jsp").forward(req, resp);


}
}


