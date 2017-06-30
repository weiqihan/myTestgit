package com.zzu.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.zzu.entity.Advisory;
import com.zzu.entity.Results;
import com.zzu.service.AdvisoryService;


@Controller(value="addAdvisoryImgAction")
@Scope(value="prototype")
public class AddAdvisoryImgAction extends ActionSupport{
	//ע������
	@Resource(name="advisoryServiceImpl")
	private AdvisoryService advisoryService;
	@Resource(name="advisory")
	private Advisory advisory;
	
	private Integer New_Id;
	private String title;
	private File myUpload;
	private String myUploadFileName;
	private String myUploadContentType;
	public String upload() throws Exception{
		System.out.println("");
		HttpServletRequest request= ServletActionContext.getRequest();
		String realPath = request.getRealPath("/").substring(0, request.getRealPath("/").lastIndexOf(request.getContextPath().replace("/", "")));
		System.out.println(realPath);
		File file = new File(realPath+File.separator+"uploadFiles"+File.separator);
		//�����ļ��ϴ���λ��
        if(!file.exists() ){
            file.mkdirs();   
            System.out.println("�ļ��в������Ѵ���");
        }else{
            System.out.println("�ļ����Ѿ�����");
        }
		String strNewFileName = UUID.randomUUID().toString();
		String suffix=myUploadFileName.substring(myUploadFileName.lastIndexOf("."));
		strNewFileName +=suffix;
		System.out.println(strNewFileName);
		String fullPath=realPath+"uploadFiles"+File.separator+strNewFileName;
		System.out.println("�ϴ�·����"+fullPath);
		FileOutputStream fos=new FileOutputStream(fullPath);
		myUploadFileName=strNewFileName;
		FileInputStream fis=new FileInputStream(getMyUpload());
		byte[] buffer=new byte[1024];
		int len=0;
		while((len=fis.read(buffer))>0){
			fos.write(buffer,0,len);
		}
		fos.close();
		fis.close();
		
		fullPath="http://192.168.1.100:8080/uploadFiles/"+strNewFileName;
		advisory.setUrlImg(fullPath);
		advisory.setTitle(title);
		System.out.println(New_Id);
		advisory.setNew_Id(New_Id);
		advisoryService.save(advisory);
		return SUCCESS;	
	}
	
	
	public String getTitle() {
		return title;
	}
	
	public Integer getNew_Id() {
		return New_Id;
	}
	public void setNew_Id(Integer new_Id) {
		New_Id = new_Id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public File getMyUpload() {
		return myUpload;
	}
	public void setMyUpload(File myUpload) {
		this.myUpload = myUpload;
	}
	public String getMyUploadFileName() {
		return myUploadFileName;
	}
	public void setMyUploadFileName(String myUploadFileName) {
		this.myUploadFileName = myUploadFileName;
	}
	public String getMyUploadContentType() {
		return myUploadContentType;
	}
	public void setMyUploadContentType(String myUploadContentType) {
		this.myUploadContentType = myUploadContentType;
	}
}
