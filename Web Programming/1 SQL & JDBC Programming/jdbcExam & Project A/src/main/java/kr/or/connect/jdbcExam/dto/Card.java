package kr.or.connect.jdbcExam.dto;

public class Card {
	private String Name;
	private String Phone_num;
	private String Corp_name;
	
	public Card() {
		
	}
	public Card(String name, String pn, String cn) {
		super();
		this.Name = name;
		this.Phone_num = pn;
		this.Corp_name = cn;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	public String getPhone_num() {
		return Phone_num;
	}
	public void setPhone_num(String phone_num) {
		Phone_num = phone_num;
	}
	
	public String getCorp_name() {
		return Corp_name;
	}
	public void setCorp_name(String corp_name) {
		Corp_name = corp_name;
	}
	
	@Override
	public String toString() {
		return "Card [Name=" + Name + ", Phone_num=" + Phone_num + ", Corp_name=" + Corp_name + "]";
	}
}
