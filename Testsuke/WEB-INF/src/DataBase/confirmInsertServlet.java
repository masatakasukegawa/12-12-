package DataBase;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.lang.Character;

import Model.Characters;
import DataBase.CharacterManager;

//新規作成していいか確認するときつかうにプログラムです。confirmInsert.jspにとびます

//このファイルのURLです
@WebServlet(urlPatterns = { "/confirmInsertServlet" })

//=============================ここはサーブレットとして使うために必要な箇所です　全サーブレット共通です　ここから
public class confirmInsertServlet  extends HttpServlet {
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

		//セッションを使えるようにします
		HttpSession session = req.getSession();

//==========================================================================ここまで


		//オブジェクト生成
		CharacterManager cm =new CharacterManager();

		//JSPから送られてきたデータを変数に代入
		String name = req.getParameter("Name");
		String home = req.getParameter("Home");
		String like = req.getParameter("Like");
		String other = req.getParameter("Other");

		//変数のデータをオブジェクトにセット
		Characters cha =new Characters();

		cha.setName(name);
		cha.setHome(home);
		cha.setLike(like);
		cha.setOther(other);

		//sessionに数値以外のデータをのせておく。もし数値入力がされてなかったときこの値を保持してテキストボックスに出力する
		session.setAttribute("CharacterInsert", cha);


		//Ageにが数字がはいっているかの判定　はいっていないならエラーのｊｓｐにとびます
		String agestr =req.getParameter("Age");
		if(cm.isNumber(agestr) == false) {
			req.getRequestDispatcher("/ErrorInsert.jsp").forward(req, resp);
		}
		//よさそうならintがたに
		int age = Integer.parseInt(agestr);
		cha.setAge(age);

		//セッションへのセット
		session.setAttribute("Character", cha);
		//ｊｓｐへ飛ぶ
		req.getRequestDispatcher("/confirmInsert.jsp").forward(req, resp);


	}
}
