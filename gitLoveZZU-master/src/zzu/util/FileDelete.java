package zzu.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class FileDelete {

	/**
	 * ͼƬ��ɾ��
	 * @param oldimages 
	 */
	
	Panduanstr p=new Panduanstr();

	public String delete(String realPath,String oldimages, String[] DNames) throws Exception {//String oldimage:���ݿ���ȡ������ͼƬ����String[] deleted:ǰ�˴�����ָ��Ҫɾ����ͼƬ����
		
		System.out.println("ִ��ɾ������");
		String[] olds=null;
		olds=p.fenli(oldimages);
		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(olds));//��������ͼƬ���ļ��ϣ����ں���ƴ�ӳ��ַ���
		for(int i=0;i<arrayList.size();i++){
			System.out.println("ͼƬ��"+arrayList.get(i));
			for(int j=0;j<DNames.length;j++){
				System.out.println("ָ��ҪɾͼƬ:"+DNames[j]);
				if(arrayList.get(i) != null && arrayList.get(i).equals(DNames[j])){
					System.out.println("�鵽Ҫɾ����ͼƬ��"+arrayList.get(i));
					arrayList.remove(arrayList.get(i));
				}
			}
		}
		
		
		
		boolean isSuccessful=FileDelete.deleteiamge(realPath, DNames);
		String newnames=null;
       if(isSuccessful){
		 newnames=p.pinjie(arrayList);
		System.out.println("ɾ�������ɹ���ͼƬƴ���ַ���:"+newnames);
       }
		
		return newnames;
	}
	
	
	// ɾ���ɵ�ͼƬ�ļ�
		public static boolean deleteiamge(String realPath, String[] DNames){
			boolean isSuccesssful=false;
			int num=0;
			for (int i = 0; i < DNames.length; i++) {
				File f = new File(realPath + "goodsuploadImage" + "\\" + DNames[i]);

				if (f.exists()) {
					System.out.println("�鵽����ͼƬ��ʼɾ��������" + f.getAbsoluteFile());
					

					if (f.delete()) {
						System.out.println("��" + i + "��ͼƬ�ɹ���ɾ����");
						num+=1;
					} else {

						System.out.println("��" + i + "��ͼƬɾ��ʧ�ܣ�");
					}
				} else {
					System.out.println("Ҫɾ����ͼƬ������");
					
				}

			}
			if(num !=0){isSuccesssful=true;}//num ��Ϊ0������ִ����ɾ������
			return isSuccesssful;
			
			
}
		}
