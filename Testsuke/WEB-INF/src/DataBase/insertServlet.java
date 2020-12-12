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

//データを新規作成してあらたにテーブルをつくるときにつかうプログラムです。ホームにとびます

//このファイルのURLです
@WebServlet(urlPatterns = { "/insertServlet" })
//=============================ここはサーブレットとして使うために必要な箇所です　全サーブレット共通です　ここから

public class insertServlet extends HttpServlet {
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

		Characters cha =new Characters();

		//セッションに値があるか確認しながら代入します。こうすることでエラーをぼうししてます
		  if (session.getAttribute("Character") != null) {
				cha = (Characters) session.getAttribute("Character");
			}

		  //DBにあらたにデータを作成する
		cm.insert(cha);

		//ホームに飛ぶ
		req.getRequestDispatcher("/startServlet").forward(req, resp);



	}}