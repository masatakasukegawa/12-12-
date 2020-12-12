package DataBase;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Model.Characters;
import DataBase.CharacterManager;
//テーブルにアップデートするときに使うプログラムです。ホームにもどります

//このファイルのURLです
@WebServlet(urlPatterns = { "/updateServlet" })

//=============================ここはサーブレットとして使うために必要な箇所です　全サーブレット共通です　ここから
public class updateServlet extends HttpServlet {
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
//セッションの接続
		HttpSession session = req.getSession();

//==========================================================================ここまで


		CharacterManager cm = new CharacterManager();

		//セッションにデータがあるかをっ確認してうけとります。こうするとエラーが減ります
		Characters cha =new Characters();
		  if (session.getAttribute("Character") != null) {
				cha = (Characters) session.getAttribute("Character");
			}
		//修正データをテーブルに反映させます
		cm.update(cha);



		//ホームに戻ります
		req.getRequestDispatcher("/startServlet").forward(req, resp);



	}}