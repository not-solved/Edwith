package kr.or.connect.diexam01;

/* 
Bean class
	- 일반 Java 클래스를 Bean 클래스라고도 함
	특징 3가지
		1. 기본 생성자를 갖는다.
		2. 필드는 private 하게 선언
		3. getter, setter 메소드를 갖는다.
		4. getName(), setName() 메소드를 name property라고도 한다.
*/

public class UserBean {
	private String name;
	private int age;
	private boolean male;
	
	public UserBean() {
		
	}
	public UserBean(String name, int age, boolean male) {
		this.name = name;
		this.age = age;
		this.male = male;
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
	public boolean isMale() {
		return male;
	}
	public void setMale(boolean male) {
		this.male = male;
	}
}
