package life.taoyu.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

import life.taoyu.modeldriver.CGoods;
import life.taoyu.service.TaoyuService;
import net.sf.json.JSONObject;
import zzu.util.Getjson;
import zzu.util.Returndata;
@Component(value = "cartAction")
@Scope(value = "prototype")
public class Cart extends ActionSupport{

	/**
	 * ���ﳵ
	 */
	private static final long serialVersionUID = 1L;
	private String SessionID;
	private String action=null;
	private String goods_id=null;
	private String count="1";
	@Resource(name = "taoyuService")
	private TaoyuService taoyuService;
@Override
public String execute() throws Exception {
	boolean isSuccessful=false;
	String[] cartinfo=new String[3];
	cartinfo[0]=SessionID;cartinfo[1]=goods_id;cartinfo[2]=count;
	JSONObject goods = new JSONObject();
	Getjson array = new Getjson();
	
	if(SessionID ==null && action ==null){System.out.println("�������ﳵ��Ʒ����������Ϊ�յ�����");return "false";}
	if(action.equals("���") && goods_id !=null){
		//�����Ʒ�����ﳵ
		isSuccessful=taoyuService.AddGoodsToCart(cartinfo);
		Returndata.returnboolean(isSuccessful);//���ز���ֵ
	}else if(action.equals("��ѯ")){
		//��ѯ���ﳵ����Ʒ
		List<CGoods> cglist=taoyuService.queryCart(cartinfo);
		goods = array.getjsonarray(cglist, action);
		Returndata.returndata(goods);//��������
	}else if(action.equals("ɾ��") && goods_id !=null){
		//ɾ�����ﳵ����Ʒ
		isSuccessful=taoyuService.DeleteGoodsFromCart(cartinfo);
		Returndata.returnboolean(isSuccessful);
	}

	
	return null;
}









//����ע��

public String getSessionID() {
	return SessionID;
}
public void setSessionID(String sessionID) {
	SessionID = sessionID;
}
public String getAction() {
	return action;
}
public void setAction(String action) {
	this.action = action;
}
public String getGoods_id() {
	return goods_id;
}
public void setGoods_id(String goods_id) {
	this.goods_id = goods_id;
}
public String getCount() {
	return count;
}
public void setCount(String count) {
	this.count = count;
}



}
