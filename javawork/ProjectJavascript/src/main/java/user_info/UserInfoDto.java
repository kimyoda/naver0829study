package user_info;

import java.sql.Timestamp;

public class UserInfoDto {
	private String num; // num을 반드시 dto에 넣어야 하는지..?
	private String id;
	private String password;
	private String name;
	private String gender;
	private String nickname;
	private String address;
	private String email;
	private String phone;
	private String jumin;
	private Timestamp sign_DT;
	
	public Timestamp getSign_DT() {
		return sign_DT;
	}
	public void setSign_DT(Timestamp sign_DT) {
		this.sign_DT = sign_DT;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}

}