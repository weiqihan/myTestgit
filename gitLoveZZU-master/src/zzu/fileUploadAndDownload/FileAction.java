package zzu.fileUploadAndDownload;

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

import net.sf.json.JSONObject;
import persionalCenter.entity.UserInfo;
import persionalCenter.service.UserService;
import zzu.util.Returndata;

@Component(value = "upload")
@Scope(value = "prototype")
public class FileAction extends ActionSupport {

	/**
	 * 
	 */
	@Resource(name = "userService")
	private UserService userService;

	private static final long serialVersionUID = 1L;
	private String SessionID;
	private File myUpload;
	private String myUploadFileName;
	private String myUploadContentType;

	public String getSessionID() {
		return SessionID;
	}

	public void setSessionID(String sessionID) {
		SessionID = sessionID;
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

	@SuppressWarnings("deprecation")
	public String upload() throws FileNotFoundException, IOException {
		String[] str = new String[10];// str[0]
										// �Ƿ��������ɵ�ͼƬ����str[1]�ǷŻ�ȡ���ݿ��е��û��ֻ��ţ�str[2]�ǷŻ�ȡ���ݿ��еľɵ�ͼƬ��
		boolean isSuccessful = false;
		String imageurl = null;
		System.out.println("�ͻ����ϴ�����ͼƬ��������SessionID:" + SessionID);
		HttpServletRequest request = ServletActionContext.getRequest();

		UserInfo userinfo = new UserInfo();
		if (SessionID != null) {
			str = userService.getImageName(SessionID);

			userinfo.setPhone(str[1]);
		} else {
			System.out.println("�ϴ�ͼƬʱSessionIDΪ��");
			str[0] = "1.jpg";// ����Ĭ��ͼƬ
		}

		String strNewFileName = str[0];// ���ͼƬ��
		String realPath = request.getRealPath("/").substring(0,
				request.getRealPath("/").lastIndexOf(request.getContextPath().replace("/", "")));
		File file = new File(realPath + File.separator + "uploadFiles" + File.separator);

		// �����ļ��ϴ���λ��
		if (!file.exists()) {
			file.mkdirs();

			System.out.println("�ļ��в������Ѵ���");
		} else {
			System.out.println("�ļ����Ѿ�����");
		}
		System.out.println("�ļ���:" + myUpload.getName());

		String suffix = myUploadFileName.substring(myUploadFileName.lastIndexOf("."));
		strNewFileName += suffix;
		FileOutputStream fos = new FileOutputStream(
				realPath + File.separator + "uploadFiles" + File.separator + strNewFileName);
		myUploadFileName = strNewFileName;

		// ͼƬ�����浽���ݿ�
		userinfo.setImageUrl(myUploadFileName);
		
		// ��ȡ�ͱ���ͼƬ�ļ�
		FileInputStream fis = new FileInputStream(getMyUpload());
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = fis.read(buffer)) > 0) {

			fos.write(buffer, 0, len);

		}
		System.out.println("�ɹ����浽�ϴ���ͼƬ");
		fos.close();
		fis.close();
		String filepath = realPath + "uploadFiles" + File.separator + myUploadFileName;
		System.out.println("�ļ��ϴ�·��:" + filepath);
		// ɾ��ͼƬ
		
		if ( SessionID != null && str[2] !=null && !str[2].equals("")) {
			File f = new File(realPath + "uploadFiles" + File.separator + str[2]);

			DataOutputStream dos = new DataOutputStream(new FileOutputStream(f));

			if (f.exists()) {
				System.out.println("�鵽����ͼƬ��ʼɾ��������" + f.getAbsoluteFile());
				dos.close();

				if (!f.delete()) {
					System.out.println("��ر�ʹ�ø��ļ������н��̻���������");
				} else {
					System.out.println(f.getName() + " �ɹ���ɾ����");
				}
			} else {
				System.out.println("û�鵽����ͼƬ");
			}
			
		}
		boolean b = userService.saveOrupdate(userinfo);
		System.out.println("�Ƿ�ͼƬ���������ݿ����:" + b);

		isSuccessful = b;
		imageurl = myUploadFileName;

		// ��������
		JSONObject json = new JSONObject();

		json.put("isSuccessful", isSuccessful);
		json.put("imageurl", imageurl);
		Returndata.returndata(json);

		return SUCCESS;

	}

}
