package persionalCenter.entity;

import org.springframework.stereotype.Component;

@Component(value="UserInfo")
public class UserInfo {

	private Integer info_id;

	private String imageUrl;//ͷ���ַ
	private String nickname;//�ǳ�
	private String phone;//�ֻ���
	private String Qr_codeUrl; //��ά���ַ
	private String gender;//�Ա�
	private String hometown ;//����
	private String academy;//ԺУ
	private String departments ;//Ժϵ
	private String professional ;//רҵ
	private User user;
	public Integer getInfo_id() {
		return info_id;
	}
	public void setInfo_id(Integer info_id) {
		this.info_id = info_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQr_codeUrl() {
		return Qr_codeUrl;
	}
	public void setQr_codeUrl(String qr_codeUrl) {
		Qr_codeUrl = qr_codeUrl;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public String getAcademy() {
		return academy;
	}
	public void setAcademy(String academy) {
		this.academy = academy;
	}
	public String getDepartments() {
		return departments;
	}
	public void setDepartments(String departments) {
		this.departments = departments;
	}
	public String getProfessional() {
		return professional;
	}
	public void setProfessional(String professional) {
		this.professional = professional;
	}

	@Override
	public String toString() {
		
		return "UserInfo{phone:"+phone+"nickname:"+nickname+"gender:"+gender+"hometown:"+
				hometown+"academy:"+academy+"departments:"+departments+"professional:"+professional+"}";

	}
	
}
