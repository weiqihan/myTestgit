package life.taoyu.entity;

import java.util.HashSet;
import java.util.Set;

public class Comments_L1 {

	private int L1_Cid;// һ�����۱�ID
	
	private String account; //������Ψһ�˻���	
	private String comments;//   ��������
	private int num_replies; // �ظ�����
	private Goods Cgoods;
	private int num_thumb;//    ��������
	private String Cdate;
	private Set<Comments_L2> setcomments_L2=new HashSet<Comments_L2>();//ʹ��set���ϱ�ʾComments_L1��

	public Set<Comments_L2> getSetcomments_L2() {
		return setcomments_L2;
	}
	public void setSetcomments_L2(Set<Comments_L2> setcomments_L2) {
		this.setcomments_L2 = setcomments_L2;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getCdate() {
		return Cdate;
	}
	public void setCdate(String cdate) {
		Cdate = cdate;
	}

	public Goods getCgoods() {
		return Cgoods;
	}
	public void setCgoods(Goods cgoods) {
		Cgoods = cgoods;
	}
	
	public int getL1_Cid() {
		return L1_Cid;
	}
	public void setL1_Cid(int l1_Cid) {
		L1_Cid = l1_Cid;
	}

	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getNum_replies() {
		return num_replies;
	}
	public void setNum_replies(int num_replies) {
		this.num_replies = num_replies;
	}
	public int getNum_thumb() {
		return num_thumb;
	}
	public void setNum_thumb(int num_thumb) {
		this.num_thumb = num_thumb;
	}
	@Override
	public String toString() {
		return "Comments_L1 [L1_Cid=" + L1_Cid + ", account=" + account + ", comments=" + comments + ", num_replies="
				+ num_replies + ", Cgoods=" + Cgoods + ", num_thumb=" + num_thumb + ", Cdate=" + Cdate
				+ ", setcomments_L2=" + setcomments_L2 + "]";
	}


}
