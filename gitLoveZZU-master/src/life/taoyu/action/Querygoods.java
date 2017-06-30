package life.taoyu.action;

import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.opensymphony.xwork2.ActionSupport;

import life.taoyu.modeldriver.Ugoods;
import life.taoyu.service.TaoyuService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import zzu.util.Getjson;

@Component(value = "querygoodsAction")
@Scope(value = "prototype")

public class Querygoods extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource(name = "taoyuService")
	private TaoyuService taoyuService;
	private String action = null;// ����ǰ̨�����ķ����ѯ����
	private int num = 0;// ����ǰ̨���������֣����ڴӵ�num�����ݿ�ʼ��ѯ

	public void setNum(int num) {
		this.num = num;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String execute() throws Exception {
		String sql = null;

		Getjson array = new Getjson();
		List<Ugoods> list = new ArrayList<Ugoods>();
		JSONObject goods = new JSONObject();
		System.out.println(action + "|||||" + num);
		if (action.equals("ѧϰ") || action.equals("����") || action.equals("����")) {
			sql = "from Goods where Gtype=? order by Goods_id desc";
			list = taoyuService.query(action, num, sql);
			goods = array.getjsonarray(list, action);// ���ݼ��Ϻ�Ҫȥ���ļ������ԣ���ȡjson����
			System.out.println("�����ѯ����");
		} else if (action != null && !action.equals("")) {

			sql = "from Goods where Gsearch like ? order by Goods_id desc";
			action = "%" + action + "%";
			list = taoyuService.query(action, num, sql);
			action = "����";
			goods = array.getjsonarray(list, action);
			System.out.println("������ѯ����");
		}

		// ��������
		if (goods != null) {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("Content-type", "text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");

			PrintWriter out = response.getWriter();
			out.println(goods);
			out.flush();
			out.close();
		} else {
			System.out.println("��Ʒ��ϢΪ��");
		}

		return NONE;
	}
}
