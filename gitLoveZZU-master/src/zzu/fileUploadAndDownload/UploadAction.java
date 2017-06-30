package zzu.fileUploadAndDownload;

//�ϴ�����ļ�
import java.util.ArrayList;


import java.util.List;
import java.util.UUID;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

import life.taoyu.entity.Goods;
import life.taoyu.service.TaoyuService;
import net.sf.json.JSONObject;
import zzu.util.FileDelete;
import zzu.util.GetDate;
import zzu.util.Panduanstr;

@Component(value = "imagesupload")
@Scope(value = "prototype")
public class UploadAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// �ϴ��ļ���
	private File[] images = new File[10];
	// �ϴ��ļ�����
	private String[] imagesContentType = new String[10];
	// ��װ�ϴ��ļ���
	private String[] imagesFileName = new String[10];

	private String goods_id;
	private String SessionID;
    private String action=null;
    
    private String[] DNames=null;//ָ��Ҫɾ����ͼƬ����


	@Resource(name = "getdata")
	private GetDate data;
	@Resource(name = "taoyuService")
	private TaoyuService taoyuService;

	@Override
	public String execute() throws FileNotFoundException, IOException {
		boolean isSuccessful=false;
		String[] str =null;// str[0] �Ƿ�Account��str[1]�ǷŻ�ȡ���ݿ��еľɵ�ͼƬ��
		String[] imagenames = null;// ��Ż�ȡ�ľɵ�ͼƬ��
		Panduanstr p = new Panduanstr();
		Goods goods = new Goods();
		
		//��ȡ���ݿ�����Ʒ��Ϣ
		if (goods_id != null && goods_id != null) {
			str = taoyuService.getImageName(SessionID, goods_id);
			goods.setGoods_id(Integer.parseInt(goods_id));
			imagenames = p.fenli(str[1]);

		} else {
			System.out.println("�ϴ�ͼƬʱSessionIDΪ��");
			
		}
       
		HttpServletRequest request = ServletActionContext.getRequest();
		String realPath = request.getRealPath("/").substring(0,
				request.getRealPath("/").lastIndexOf(request.getContextPath().replace("/", "")));
		System.out.println("�ļ����Ŀ¼: " + realPath + "goodsuploadImage" + File.separator);
		FileOutputStream fos = null;
		FileInputStream fis = null;
		
		try {
			 if(action.equals("ɾ��ͼƬ") ){
		        	FileDelete d=new FileDelete();
		          String newnames= d.delete(realPath, str[1],DNames);//�����µ�imageurl
		          if(newnames !=null){
		          goods.setGimage(newnames);
					taoyuService.updateGoods(goods);}
		          isSuccessful=true;
		          
			 }else if(action.equals("�ϴ�ͼƬ") && imagenames.length<10){
		        
		
			File file = new File(realPath + "goodsuploadImage" + File.separator);

	// �����ļ��ϴ���λ��
			if (!file.exists()) {
				file.mkdirs();
				System.out.println("�ļ��в������Ѵ���");
			} else {
				System.out.println("�ļ����Ѿ�����");
			}

	//�ϴ��ļ�
			List<String> l = new ArrayList<>();//��������ͼƬ���ļ��ϣ����ں���ƴ�ӳ��ַ���
			
			for (int i = 0; i < images.length; i++) {
                 String sss=getImagesContentType()[i];System.out.println("����:"+sss);
				String suffix = getImagesFileName()[i].substring(getImagesFileName()[i].lastIndexOf("."));
				String name = str[0] + data.GetNowDate2() + UUID.randomUUID().toString() + suffix; // ����ͼƬ��=�û��˻�+Ŀǰʱ��+UUID
				l.add(name);

				fos = new FileOutputStream(realPath  + "goodsuploadImage" + File.separator + name);
				fis = new FileInputStream(getImages()[i]);
				
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = fis.read(buffer)) != -1) {
					fos.write(buffer, 0, len);
				}
				}
				
				close(fos, fis);
				System.out.println("���ļ��ϴ������ɹ�");
			
			
			
			
			String imageurl = p.pinjie(l);//    ƴ�ӳ��ַ���
			       imageurl +=str[1];//���ݿ��к������ɵ�ͼƬ��ƴ��
			       
			if (imageurl != null && !imageurl.equals("")) {
				goods.setGimage(imageurl);
				taoyuService.updateGoods(goods);
				isSuccessful=true;
			}
		
		
	    	
			 }else{System.out.println("���û��ϴ�ͼƬ�����ۼ��ѳ���"+imagenames.length +"��");}

		} catch (FileNotFoundException e) {
			System.out.println("�ļ�������" + e.getMessage());
		} catch (Exception e) {
			System.out.println("�ļ��ϴ�ʧ��");
			e.printStackTrace();
		}
//��������	
		HttpServletResponse response= ServletActionContext.getResponse();
		response.setHeader("Content-type", "text/html;charset=UTF-8");   
		response.setCharacterEncoding("UTF-8");
		JSONObject json = new JSONObject();   
		
    	 json.put("isSuccessful", isSuccessful);	    	 
          
        
     PrintWriter out=response.getWriter();    	
    	out.println(json);
    	out.flush();
    	out.close();
		return null;
	}

	/**
	 * ����ע��
	 * 
	 * @return
	 */
	public String[] getDNames() {
		return DNames;
	}

	public void setDNames(String[] dNames) {
		DNames = dNames;
	}
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getSessionID() {
		return SessionID;
	}

	public void setSessionID(String sessionID) {
		SessionID = sessionID;
	}


	public String getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
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

	private void close(FileOutputStream fos, FileInputStream fis) {
		if (fis != null) {
			try {
				fis.close();
				fis = null;
			} catch (IOException e) {
				System.out.println("FileInputStream�ر�ʧ��");
				e.printStackTrace();
			}
		}
		if (fos != null) {
			try {
				fos.close();
				fis = null;
			} catch (IOException e) {
				System.out.println("FileOutputStream�ر�ʧ��");
				e.printStackTrace();
			}
		}
	}


	
}
