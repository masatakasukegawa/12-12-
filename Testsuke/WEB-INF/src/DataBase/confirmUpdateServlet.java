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

//データを修正するか確認するときにつかうプログラムです。confirmupdate.jspにとびます

//このファイルのURLです

@WebServlet(urlPatterns = { "/confirmUpdateServlet" })
//=============================ここはサーブレットとして使うために必要な箇所です　全サーブレット共通です　ここから

public class confirmUpdateServlet  extends HttpServlet {
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

		CharacterManager cm =new CharacterManager();


		//文字列で送られてくる情報を適宜文字列・数値に変換して変数に代入する

		String ridStr = req.getParameter("RID");
		int	rid = Integer.parseInt(ridStr);
		String name = req.getParameter("Name");
		String home = req.getParameter("Home");
		String like = req.getParameter("Like");
		String other = req.getParameter("Other");


		//JSPから受け取った各種データを保存できるItemクラスのオブジェクトを作成
		Characters cha =new Characters();

		cha.setRid(rid);
		cha.setName(name);
		cha.setHome(home);
		cha.setLike(like);
		cha.setOther(other);

		//sessionに数値以外のデータをのせておく。もし数値入力がされてなかったときこの値を保持してテキストボックスに出力する
		session.setAttribute("CharacterUpdate", cha);


		String agestr =req.getParameter("Age");
		//Ageにが数字がはいっているかの判定　はいっていないならエラーのｊｓｐにとびます
		if(cm.isNumber(agestr) == false) {
			req.getRequestDispatcher("/ErrorUpdate.jsp").forward(req, resp);
		}
		//よさそうならintがたに
		int age = Integer.parseInt(agestr);
		cha.setAge(age);

		//セッションへのセット
		session.setAttribute("Character", cha);
		//ｊｓｐへ
		req.getRequestDispatcher("/confirmUpdate.jsp").forward(req, resp);


	}
}
