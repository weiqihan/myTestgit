package com.zzu.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzu.dao.Dao;
import com.zzu.entity.User;
import com.zzu.entity.UserInfo;
@Transactional
@Service(value="userService")
public class UserService {

	@Resource(name="userDao")
	private Dao dao;

	boolean isSuccessful=false;
	String[] userinfoDatas=new String[9];
	String sql=null;
	String values;
	Serializable id = null;
//�����û�����
	public boolean save(User user){
		
		id=null;//��ʼ��id
		sql="from User where phone=?";
		values=user.getPhone();
		List<User> list=dao.query(sql, values);
		if(list.isEmpty()){
			id=this.dao.save(user);
		}else{System.out.println("�û�:"+user.getPhone()+"�Ѵ���");}
			if(id !=null){
				isSuccessful=true;
				System.out.println("���û��ѱ��浽���ݿ�!");
			}else{
			System.out.println("User����Ϊ��!!!");
			}
		
		return isSuccessful;
		
	}

//��ѯ�û�����
	public boolean query(User user) {
		
		sql="from User where phone=?";
		values=user.getPhone();
		List<User> list=this.dao.query(sql, values);
		if(!list.isEmpty()){
			isSuccessful=true;
			System.out.println("�û�:"+user.getPhone()+"����");
		}else{System.out.println("�û�:"+user.getPhone()+"������");
		}
		
		return isSuccessful;
	}
//������޸��û���Ϣ
	public boolean saveOrupdate(UserInfo userinfo) {
		
		id = null;//��ʼ��id
			//�õ�User����
		sql="from User where phone=?";
		values=userinfo.getPhone();
		List<User> list=this.dao.query(sql, values);
			
			for (User user : list) {
				//�õ�User�����id
			//����id��ѯ������userinfo������Ϊul_id=id�Ķ����Ƿ����
				sql="from UserInfo where ul_id=?";
				values=user.getUid().toString();
				System.out.println("Uid:"+values+sql+","+values);
				List<UserInfo> infolist=dao.query(sql, values);
				//������ڲ�ִ�и��²���
				if(infolist.size() ==1){
					 for (UserInfo userInfo2 : infolist) {
						String phone=userInfo2.getPhone();
						String nickname=userInfo2.getNickname();
						String gender=userInfo2.getGender();
						String hometown=userInfo2.getHometown();
						String image=userInfo2.getImageUrl();
						String codeurl=userInfo2.getQr_codeUrl();
						String departments=userInfo2.getDepartments();
						String academy=userInfo2.getAcademy();
						String professional=userInfo2.getProfessional();				 
						if(!userinfo.getPhone().equals("")){phone=userinfo.getPhone();}
						if(!userinfo.getNickname().equals("")){nickname=userinfo.getNickname();}
						if(!userinfo.getGender().equals("")){gender=userinfo.getGender();}
						if(!userinfo.getHometown().equals("")){hometown=userinfo.getHometown();}
						if(!userinfo.getImageUrl().equals("")){image=userinfo.getImageUrl();}
						if(!userinfo.getQr_codeUrl().equals("")){codeurl=userinfo.getQr_codeUrl();}
						if(!userinfo.getDepartments().equals("")){departments=userinfo.getDepartments();}
						if(!userinfo.getAcademy().equals("")){academy=userinfo.getAcademy();}
						if(!userinfo.getProfessional().equals("")){professional=userinfo.getProfessional();}
					    userInfo2.setPhone(phone);
			    	    userInfo2.setNickname(nickname);
					    userInfo2.setGender(gender);
					    userInfo2.setHometown(hometown);
					    userInfo2.setImageUrl(image);
			            userInfo2.setQr_codeUrl(codeurl);
			     	    userInfo2.setDepartments(departments);
					    userInfo2.setAcademy(academy);
					    userInfo2.setProfessional(professional);
					    this.dao.update(userInfo2);
					    System.out.println("�û���Ϣ�Ѵ��ڣ������޸Ĳ���");
						id=1;
					}	
				//����������û���Ϣ��ִ�м����������	
				}else{

					//User���������UserInfo����
					user.getSetuserinfo().add(userinfo);
					//UserInfo���������User����
					userinfo.setUser(user);
					id=this.dao.save(user);
					System.out.println("�û���Ϣ�����ڣ����б������");
				}	
				
			}

			if(id !=null){
				isSuccessful=true;
				System.out.println("������Ϣ�ѱ��浽���ݿ�!");
			}else{
			System.out.println("Service�㣬UserInfo����Ϊ��!!!");
			}
		
		return isSuccessful;
		
		
	}
//��ѯ�������û���Ϣ
		public String[] query(UserInfo userinfo) {
			Integer Uid=null;
			//����phone��ѯUser����
			sql="from User where phone=?";
			values=userinfo.getPhone();
			List<User> list=this.dao.query(sql, values);
			
			for (User user : list) {
				Uid=user.getUid();
			}
			if(Uid !=null){
				//����User��id��ѯ������userinfo������Ϊul_id=id�Ķ����Ƿ����
				sql="from UserInfo where ul_id=?";
				values=Uid.toString();
				System.out.println("Uid:"+values+sql+","+values);
				List<UserInfo> list2=dao.query(sql, values);
			
			for (UserInfo userInfo2 : list2) {
				
				userinfoDatas[0]=userInfo2.getImageUrl();
				userinfoDatas[1]=userInfo2.getNickname();
				userinfoDatas[2]=userInfo2.getPhone();
				userinfoDatas[3]=userInfo2.getQr_codeUrl();
				userinfoDatas[4]=userInfo2.getGender();
				userinfoDatas[5]=userInfo2.getHometown();
				userinfoDatas[6]=userInfo2.getAcademy();
				userinfoDatas[7]=userInfo2.getDepartments();
				userinfoDatas[8]=userInfo2.getProfessional();
			}
			}else{
				System.out.println("�����û�ID:"+Uid+"�鲻��UserInfo��Ϣ ,�����������phone");
				userinfoDatas[2]=userinfo.getPhone();
			}
		
			return userinfoDatas;
			
		}
}
