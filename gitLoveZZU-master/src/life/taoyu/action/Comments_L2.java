package life.taoyu.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import life.taoyu.modeldriver.L2_Comments_Modeldriver;
import life.taoyu.modeldriver.UComments_L2;
import life.taoyu.service.TaoyuService;
import zzu.util.Getjson;
import zzu.util.Returndata;

@Component(value = "comments_L2Action")
@Scope(value = "prototype")
public class Comments_L2 extends ActionSupport implements ModelDriven<L2_Comments_Modeldriver> {

	/**
	 * ��������(һ�����۵�����)���飬�棬��
	 */
	private static final long serialVersionUID = 1L;
	@Resource(name = "CommentsL2_Modeldriver")
	private L2_Comments_Modeldriver CMD2;
	
	@Resource(name = "taoyuService")
	private TaoyuService taoyuService;
	
	@Resource(name = "GetjsonArray")
	private Getjson jsonarray;
	@Override
	public L2_Comments_Modeldriver getModel() {
		// TODO Auto-generated method stub
		return CMD2;
	}
       boolean Successful=false;
	@Override
	public String execute() throws NumberFormatException,Exception {
//�����������		
		if (CMD2.getAction().equals("postcomments_L2")) {
			System.out.println("����������۲���!");
			if (CMD2.getL1_Cid() != null && !CMD2.getL1_Cid().isEmpty()) {
				System.out.println("�������۶�һ�����۵Ĳ���!");

			//����sql����ֵ��StringתInteger		
					CMD2.setSql("from Comments_L1 where L1_Cid = ?");
					Integer integerValue=Integer.valueOf(CMD2.getL1_Cid());
					CMD2.setValues(integerValue);
					Successful=taoyuService.postcommentsL2(CMD2);

			} else if (CMD2.getL2_Cid() != null && !CMD2.getL2_Cid().isEmpty()) {
				System.out.println("�����������Զ������۵Ĳ���!");
				//����sql����ֵ��StringתInteger		
				CMD2.setSql("from Comments_L2 where L2_Cid = ?");
				Integer integerValue=Integer.valueOf(CMD2.getL2_Cid());
				CMD2.setValues(integerValue);
				Successful=taoyuService.postcommentsL2(CMD2);
			}
//��ѯ��������
		} else if(CMD2.getAction().equals("querycomments_L2")){
			System.out.println("��ѯ�������۲���!");
			CMD2.setSql("from Comments_L2 where LL_id=?");
			CMD2.setValues(CMD2.getL1_Cid());
			List<UComments_L2> uc2list=taoyuService.querycomments(CMD2);
			jsonarray.getjsonarray(uc2list, "���ض�������");
			
			//��������
			Returndata.returndata(jsonarray.getjsonarray(uc2list, "���ض�������"));
		}

		
//��������
		Returndata.returnboolean(Successful);
		return null;
	}

}
