package persionalCenter.user_action;

import java.io.PrintWriter;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONObject;
import persionalCenter.entity.UserInfo;
import persionalCenter.service.UserService;

@Component(value="queryuserinfo_action")
public class QueryUserInfo_action extends ActionSupport implements ModelDriven<UserInfo> {

	/**
	 * ��ѯ�û���Ϣ
	 */
	private static final long serialVersionUID = 1L;
	
	//ע��service��ʵ��������
			@Resource(name="UserService")
			private UserService userService;
			@Resource(name="UserInfo")
			private UserInfo userinfo;
	
	@Override
	public UserInfo getModel() {
		// TODO Auto-generated method stub
		return userinfo;
	}

	@Override
	public String execute() throws Exception {
		String[] userinfoDatas;
		
		if(!userinfo.getPhone().equals("") && userinfo !=null){
		userinfoDatas=userService.query(userinfo);
		
		
		//��������
		HttpServletResponse response= ServletActionContext.getResponse();
		response.setHeader("Content-type", "text/html;charset=UTF-8");   
		response.setCharacterEncoding("UTF-8");
		JSONObject json = new JSONObject(); 
		  
    	 json.put("imageUrl", userinfoDatas[0]);
    	 json.put("nickname", userinfoDatas[1]);
    	 json.put("phone", userinfoDatas[2]);
    	 json.put("Qr_codeUrl", userinfoDatas[3]);
    	 json.put("gender", userinfoDatas[4]);
    	 json.put("hometown", userinfoDatas[5]);
    	 json.put("academy", userinfoDatas[6]);
    	 json.put("departments",userinfoDatas[7] );
    	 json.put("professional", userinfoDatas[8]);
    	 PrintWriter out=response.getWriter();    	
	    	out.println(json);
	    	out.flush();
	    	out.close();
			json.clear();
			userinfoDatas=null;
			
    

		}else{ 
		
			System.out.println("QueryuserinfoAction��,�����phoneΪ��");}
	
		return NONE;
	}
}
