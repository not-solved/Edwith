package kr.or.connect.jdbcExam.dto;

// Database Transfer Object : 데이터베이스로의 데이터 교환 매체
public class Role {
	private Integer roleID;
	private String description;
	
	public Role() {
		// 기본 생성자
	}
	
	public Role(Integer roleID, String description) {
		super();
		this.roleID = roleID;
		this.description = description;
	}
	
	public Integer getID() {
		return roleID;
	}
	public void setID(Integer id) {
		this.roleID = id;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String desc) {
		this.description = desc;
	}
	
	public String toString() {
		return "Role [roleID = " + roleID + "\tdescription = " + description + "]";
	}
	
}
