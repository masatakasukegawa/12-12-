package DataBase;

import java.sql.ResultSet;
import java.util.LinkedList;
import Model.Characters;


//＝＝＝情報に処理をくわえる関数をまとめた場所です＝＝



//「DataBaeeManager」を継承しています。このクラスは学校kら配られたのをそのまま使いました。なかにDBのパスワードなどがかいてあるため送っていません
//========レコードから情報を受け取ります===============＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
public class CharacterManager extends DataBaseManager{

	//データベースから受け取ったデータを「Characterクラス（Model内）」のオブジェクトに代入する
	public Object copyRecord(ResultSet rs) throws Exception{

		Characters cha = new Characters();
		cha.setRid(rs.getInt("RID")); //　　　""の中はテーブルのフィールド名です
		cha.setName(rs.getString("Name"));
		cha.setAge(rs.getInt("Age"));
		cha.setHome(rs.getString("Home"));
		cha.setLike(rs.getString("Love"));
		cha.setOther(rs.getString("Other"));

		return cha;
	}
	//-----------------------------------------------------------------------------
	//
	//レコードに値を追加するためのメソッド
	public void insert(Characters aCha) {
		//DBに引数を入れるためのクエリを作成
		String sql ="";
		sql+=	"Insert into people(Name,Age,Home,Love,Other)values(";
		sql+=	"'"+aCha.getName()+"'";
		sql+=	",";
		sql+=	aCha.getAge();
		sql+=	",";
		sql+=	"'"+aCha.getHome()+"'";
		sql+=	",";
		sql+=	"'"+aCha.getLike()+"'";
		sql+=	",";
		sql+=	"'"+aCha.getOther()+"'";
		sql+=	")";
		//作成したSQLをアップロード
		updateRecord(sql);

	}
	//-----------------------------------------------------------------------------
	//
	//レコードのRIDを入れるとそのレコードのパラメータをすべて取り出します
	public Characters get(int id) {
		//DBMSへおくるクエリを作成する、このときIDを指定する
		String sql ="Select * from people where RID = "+id;
		Characters aCha = new Characters();
		//作成したクエリをgetrecordでDBから該当のレコードをItem型で取り出し、aItemにいれる
		 aCha = (Characters)getRecord(sql);

		return aCha;
	}
	//-----------------------------------------------------------------------------
	//
	//テーブルの値をすべてリストに代入
	public LinkedList getList() {
		String sql = "select * from people";
		LinkedList chaList = getRecords(sql);
		return chaList;

	}


	//条件を満たしたパラメータのテーブルをすべてリストに代入------------------------------------------
	public LinkedList search(int age ,int size ) {

		String sql = "select * from people where ";

		switch(size) {
		case 0:
			sql+=" Age ="+age;
			break;
		case 1:
			sql+=" Age >="+age;
			break;
		case 2:
			sql+=" Age <="+age;
			break;
		}


		LinkedList itemList = getRecords(sql);
		return itemList;

	}
	//-----------------------------------------------------------------------------
	//
	//レコードを削除するときにつかう
	public void delete(Characters cha) {
		String sql ="delete from people where RID ="+cha.getRid();
		updateRecord(sql);

	}
	//-----------------------------------------------------------------------------
	//データベースを修正するときにつかう関数です
	public void update(Characters cha) {
		String sql ="UPDATE people SET Name='"+cha.getName()+"',　Age="+cha.getAge()+" ,Home='"+cha.getHome()+"' ,Love='"+cha.getLike()+"' ,　Other='"+cha.getOther()+"'WHERE RID = "+cha.getRid();
		updateRecord(sql);

	}
	//-----------------------------------------------------------------------------
	//String型に数字がはいっているかどうか判定する関数です
	public boolean isNumber(String num) {

		try {
			Integer.parseInt(num);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}

	//-----------------------------------------------------------------------------

		//キャラクターオブジェクトの中身をきれいにする関数です
	public void clear(Characters cha) {
		cha.setName(null);
		cha.setHome(null);
		cha.setLike(null);
		cha.setOther(null);
	}

}








