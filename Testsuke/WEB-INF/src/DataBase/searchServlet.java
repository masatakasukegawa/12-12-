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
//検索結果をホームに表示するときつかうプログラムです。ホームにとびます

//このファイルのURLです
@WebServlet(urlPatterns = { "/searchServlet" })
//=============================ここはサーブレットとして使うために必要な箇所です　全サーブレット共通です　ここから
public class searchServlet extends HttpServlet {
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
		//jspからきた文字列をうけとって変数に格納
		String agestr =req.getParameter("Age");
		//数字入力のところに数字が入ってなかったときにエラーをだします
		if(cm.isNumber(agestr) == false) {
			req.getRequestDispatcher("/ErrorSearch.jsp").forward(req, resp);
		}
		int age = Integer.parseInt(agestr);

		//ｊｓｐからきたsizeデータをうけとり変数にかくのうします
		int	size = Integer.parseInt(req.getParameter("Size"));

		//検索によって引っかかったレコードをリストにしてとりだします
		LinkedList chaList= cm.search(age,size);

		//データベースに何人保存されてるか確認するためこのリストも同時につくってます。start.jspで表示する用です
				LinkedList chasize=cm.getList();

		//セッションに保存する
		session.setAttribute("Chasize", chasize);
		session.setAttribute("chaList", chaList);

		//一覧に飛ぶ
		req.getRequestDispatcher("/start.jsp").forward(req, resp);



	}}