package zzu.util;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

public class Panduanstr {
	
	
	
	public String pinjie(List<String> imageurl){
		String URL="";
		 System.out.println("ͼƬ����:"+imageurl.size()+",��ʼƴ��");
		 for(int s=0;s<imageurl.size();s++){
			 if(imageurl.get(s) !=null){
		 	          String o= (String) imageurl.get(s);
		 	           o+="ZZU";
		 	           URL+=o;
			 }
		 }
		 System.out.println(URL);
		return URL;
		
	}
	public String[] fenli(String URL){
		List<String> imageURL=new ArrayList<String>();
		
		  
		 if(URL ==null){ System.out.println("������Ҫ�����ַ���Ϊ��");}
	     String a[] = URL.split("ZZU");  
	    
	     System.out.println("ͼƬ����:"+a.length+",��ʼ����");
	for(int j=0;j<a.length;j++){
		  imageURL.add(a[j].trim());
	}
	System.out.println("�ַ�������ɹ�:"+imageURL);
	String[] arr = (String[])imageURL.toArray(new String[imageURL.size()]);//listת����
		return arr;
		
	} 
public static void main(String[] args) {
//	 String str="ABC#0#1"; 
//	 if(str.indexOf("A") ==0){  
//	 System.out.println("����"); 
//	 }else{ System.out.println("������"); 
//	 } 
//	 int i=str.indexOf("#");
//	 System.out.println(i);
	
	
	
	
	 String url1="http://localhost:8080/LoveZZU/image1";
	 String url2="http://localhost:8080/LoveZZU/image2";
	 String url3="http://localhost:8080/LoveZZU/image3";
	 String url4="http://localhost:8080/LoveZZU/image4";

	 List<String> imageurl = new ArrayList();	 
	 imageurl.add(url1);
	 imageurl.add(url2);
	 imageurl.add(url3);
	 imageurl.add(url4);
	 
	 Panduanstr p=new Panduanstr();
	String url= p.pinjie(imageurl);
	String[] S= p.fenli(url);
	
	
	 
	 
	 
//	 System.out.println(imageurl.size()+"��ʼƴ��");
//for(int s=0;s<imageurl.size();s++){
//	          String o= imageurl.get(s);
//	           o+="#";
//	           URL+=o;
//	           System.out.println(URL);
//}
//	 
//	 String s = new String(URL);   
//     String a[] = s.split("#");  
//    
//     System.out.println(a.length+"��ʼ����");
//for(int j=0;j<a.length;j++){
//	
//	  System.out.println(a[j].trim());  
//	  
//}
	 
	 
}
}
