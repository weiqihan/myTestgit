package life.taoyu.modeldriver;

import life.taoyu.entity.Goods;
import persionalCenter.entity.UserInfo;

//���洢�û��������Ʒ�����ģ�� Ugoods
public class Ugoods {

	private UserInfo userinfo;
	private Goods goods;

	public UserInfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	@Override
	public String toString() {
		return "Ugoods [userinfo=" + userinfo + ", goods=" + goods + "]";
	}
	
}
