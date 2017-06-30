package com.zzu.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;
@Transactional
@Component(value="uploadAction")
@Scope(value="prototype")
public class UploadAction extends ActionSupport{

	// �ϴ��ļ���
		private File[] images = new File[10];
		// �ϴ��ļ�����
		private String[] imagesContentType = new String[10];
		// ��װ�ϴ��ļ���
		private String[] imagesFileName = new String[10];
		
		@Override
		public String execute() throws FileNotFoundException, IOException {
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
	        List<String> l = new ArrayList<>();//��������ͼƬ���ļ��ϣ����ں���ƴ�ӳ��ַ���
	           
	           for(int i=0;i<images.length;i++){
	        	   String strNewFileName = UUID.randomUUID().toString();
	        	   String suffix=getImagesFileName()[i].substring(getImagesFileName()[i].lastIndexOf("."));
	        	   strNewFileName +=suffix;
	        	   
	        	   String fullPath=realPath+"uploadFiles"+File.separator+strNewFileName;
	        	   FileOutputStream fos=new FileOutputStream(fullPath);
	        	   
	        	   FileInputStream fis=new FileInputStream(getImagesFileName()[i]);
	        	   byte[] buffer=new byte[1024];
	       		   int len=0;
	       		   while((len=fis.read(buffer))>0){
	       			   fos.write(buffer,0,len);
	       		   }
	       		   fos.close();
	       		   fis.close();
	       		   fullPath="http://192.168.1.100:8080/uploadFiles/"+strNewFileName;
	       		   l.add(i, fullPath);
	           }
	       System.out.println(l.get(0)+l.get(1));
		
			return NONE;
		}
		public File[] getImages() {
			return images;
		}
		public void setImages(File[] images) {
			this.images = images;
		}
		public String[] getImagesContentType() {
			return imagesContentType;
		}
		public void setImagesContentType(String[] imagesContentType) {
			this.imagesContentType = imagesContentType;
		}
		public String[] getImagesFileName() {
			return imagesFileName;
		}
		public void setImagesFileName(String[] imagesFileName) {
			this.imagesFileName = imagesFileName;
		}

}
