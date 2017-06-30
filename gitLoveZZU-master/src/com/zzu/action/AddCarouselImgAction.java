package com.zzu.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.zzu.entity.Carousel;
import com.zzu.service.CarouselService;


@Controller(value="addCarouselImgAction")
@Scope(value="prototype")
public class AddCarouselImgAction extends ActionSupport{

	//ע������
	@Resource(name="carouselServiceImpl")
	private CarouselService carouselService;
	@Resource(name="carousel")
	private Carousel carousel;
	private boolean isSuccessful=false;
	private File myUpload;
	private String myUploadFileName;
	private String myUploadContentType;
	public String upload() throws Exception{
		try{
		HttpServletRequest request= ServletActionContext.getRequest();
		
		String realPath = request.getRealPath("/").substring(0, request.getRealPath("/").lastIndexOf(request.getContextPath().replace("/", "")));
		System.out.println(realPath);
		File file = new File(realPath+File.separator+"uploadCarouselFiles"+File.separator);
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
		String fullPath=realPath+"uploadCarouselFiles"+File.separator+strNewFileName;
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
		
		fullPath="http://localhost:8080/uploadCarouselFiles/"+strNewFileName;
		carousel.setImgUrl(fullPath);
		carouselService.save(carousel);
		isSuccessful=true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HttpServletResponse response= ServletActionContext.getResponse();	
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Content-type", "text/html;charset=UTF-8");
		         PrintWriter out=response.getWriter();
		    	 out.println(isSuccessful);
		    	 out.flush();
		    	 out.close();
		}
		return SUCCESS;	
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
