package life.taoyu.entity;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import persionalCenter.entity.User;
@Component(value="goods")
//��Ʒʵ����
public class Goods {

	private Integer Goods_id ;//��Ʒid
	private String Gtype;// ��Ʒ����
	private String Gname;//  ��Ʒ����
	private String Ggrade;// ���꼶��Ʒ
	private String Gdescribe;//��Ʒ����
	private String Gprice;// ��Ʒ�۸�
	private String Gimage;//��ƷͼƬ
	private String Gthumb;//������
	private String Gcomments;//������
	private String Gsearch;//�����������ֶ�
	private String Gdate;//��Ʒ����
    
	private Set<Comments_L1> setcomments_L1=new HashSet<Comments_L1>();//ʹ��set���ϱ�ʾComments_L1��

	public Set<Comments_L1> getSetcomments_L1() {
		return setcomments_L1;
	}
	public void setSetcomments_L1(Set<Comments_L1> setcomments_L1) {
		this.setcomments_L1 = setcomments_L1;
	}
	public String getGthumb() {
		return Gthumb;
	}
	public void setGthumb(String gthumb) {
		Gthumb = gthumb;
	}
	public String getGcomments() {
		return Gcomments;
	}
	public void setGcomments(String gcomments) {
		Gcomments = gcomments;
	}

  
	private User user;
    private String SessionID;
	public String getSessionID() {
		return SessionID;
	}
	public void setSessionID(String sessionID) {
		SessionID = sessionID;
	}
	public String getGimage() {
		return Gimage;
	}
	public void setGimage(String gimage) {
		Gimage = gimage;
	}
	

	
	public String getGdate() {
		return Gdate;
	}
	public void setGdate(String gdate) {
		Gdate = gdate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
	public Integer getGoods_id() {
		return Goods_id;
	}
	public void setGoods_id(Integer goods_id) {
		Goods_id = goods_id;
	}
	public String getGtype() {
		return Gtype;
	}
	public void setGtype(String gtype) {
		Gtype = gtype;
	}
	public String getGname() {
		return Gname;
	}
	public void setGname(String gname) {
		Gname = gname;
	}
	public String getGgrade() {
		return Ggrade;
	}
	public void setGgrade(String ggrade) {
		Ggrade = ggrade;
	}
	public String getGdescribe() {
		return Gdescribe;
	}
	public void setGdescribe(String gdescribe) {
		Gdescribe = gdescribe;
	}
	public String getGprice() {
		return Gprice;
	}
	public void setGprice(String gprice) {
		Gprice = gprice;
	}
	
	public String getGsearch() {
		return Gsearch;
	}
	public void setGsearch(String gsearch) {
		Gsearch = gsearch;
	}
	@Override
	public String toString() {
		return "Goods [Goods_id=" + Goods_id + ", Gtype=" + Gtype + ", Gname=" + Gname + ", Ggrade=" + Ggrade
				+ ", Gdescribe=" + Gdescribe + ", Gprice=" + Gprice + ", Gimage=" + Gimage + ", Gthumb=" + Gthumb
				+ ", Gcomments=" + Gcomments + ", Gsearch=" + Gsearch + ", Gdate=" + Gdate + "]";
	}


	
}
