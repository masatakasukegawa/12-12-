package Model;

//単一のキャラクターを保存するためのクラスです。　

public class Characters {

	private int rid ;
	private String name ;
	private int age ;
	private String home;
	private String like;
	private String other;

	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getLike() {
		return like;
	}
	public void setLike(String like) {
		this.like = like;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}




}
