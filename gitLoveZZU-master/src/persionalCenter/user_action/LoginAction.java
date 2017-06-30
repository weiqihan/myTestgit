package persionalCenter.user_action;

import java.io.PrintWriter;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


import net.sf.json.JSONObject;
import persionalCenter.entity.User;
import persionalCenter.service.UserService;
import zzu.util.Judge_character;


@Transactional
@Component(value="loginAction")
@Scope(value="prototype")
public class LoginAction extends ActionSupport implements ModelDriven<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//ע������
	@Resource(name="UserService")
	private UserService userService;
	
	@Resource(name="User")
	private User user;
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	
	
	@Override
	public String execute() throws Exception {
		
           
		Judge_character j=new Judge_character();
		String SessionID=null;
		String info=null;
		if( j.character(user.getPhone())){
		System.out.println("LoginAction��User�״ε�½"+user.toString());
		SessionID=userService.query(user);
		}else {
			if(user.getSessionID() !=null && !user.getSessionID().isEmpty()){
				System.out.println("�û��ٴε�½����,SessionID:"+user.getSessionID().toString());
				SessionID=userService.againquery(user);
				if(SessionID == null || SessionID.equals("")){
					info="��¼ʧ�ܣ��û�������";				
				}else{System.out.println("SeesionID��½");info="SessionID��½";}
				
			}else{
			info="�ͻ��˴������ֻ��ź�SessionID���ݶ�Ϊ�ջ򲻺Ϸ�";
			System.out.println("�ͻ��˴������ֻ��ź�SessionID���ݶ�Ϊ��");}
			}
	
	//��������
		HttpServletResponse response= ServletActionContext.getResponse();
		//������ķ��س��֣����ַ��������û�м�response.setCharacterEncoding("UTF-8");��仰��
      //������ص������ǡ����С��������룬˵��������Ľ������⣬Ӧ�ü�����Ƿ�����response.setHeader("Content-type", "text/html;charset=UTF-8");��仰
		response.setHeader("Content-type", "text/html;charset=UTF-8");   
		response.setCharacterEncoding("UTF-8"); 
		
		JSONObject json = new JSONObject();   
    	 json.put("SessionID", SessionID);    	
    	 json.put("info", info);    	
          System.out.println("LoginAction��json"+json);
        
         PrintWriter out=response.getWriter();    	
    	   out.println(json);
    	   out.flush();
    	   out.close();
		
		return null;
	}
	
	
	 

 


}
