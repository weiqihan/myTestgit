package zzu.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component(value="getdata")
public class GetDate {

	//��ȡʱ��������
	 public int getDataNum(String last,String now) throws ParseException {  
	        // TODO Auto-generated method stub  
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	       
           Date  d1=sdf.parse(last);  
	       Date  d2=sdf.parse(now);  
	        int n=daysBetween(d1,d2);//���������������
	       // System.out.println(daysBetween(d1,d2));  
	      //  System.out.println(daysBetween("2012-09-08 10:10:10","2012-09-15 00:00:00"));
			return n;  
	    }  
	      
	    /**  
	     * ������������֮����������  
	     * @param smdate ��С��ʱ�� 
	     * @param bdate  �ϴ��ʱ�� 
	     * @return ������� 
	     * @throws ParseException  
	     * 
	     */    
	    public static int daysBetween(Date smdate,Date bdate) throws ParseException    
	    {    
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
	        smdate=sdf.parse(sdf.format(smdate));  
	        bdate=sdf.parse(sdf.format(bdate));  
	        Calendar cal = Calendar.getInstance();    
	        cal.setTime(smdate);    
	        long time1 = cal.getTimeInMillis();                 
	        cal.setTime(bdate);    
	        long time2 = cal.getTimeInMillis();         
	        long between_days=(time2-time1)/(1000*3600*24);  
	            
	       return Integer.parseInt(String.valueOf(between_days));           
	    }    
	  //�ַ�����ʽ���ڼ��������������
	    public static int daysBetween(String smdate,String bdate) throws ParseException{  
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
	        Calendar cal = Calendar.getInstance();    
	        cal.setTime(sdf.parse(smdate));    
	        long time1 = cal.getTimeInMillis();                 
	        cal.setTime(sdf.parse(bdate));    
	        long time2 = cal.getTimeInMillis();         
	        long between_days=(time2-time1)/(1000*3600*24);  
	            
	       return Integer.parseInt(String.valueOf(between_days));     
	    }  
	    public String GetNowDate(){
	    	   Date dt=new Date();
	 		  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//������ʾ��ʽ
	 		      String  nowTime= df.format(dt);
	 		
			return nowTime;}
	    
	    public String GetNowDate2(){
	    	Date dt=new Date();
	    	SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//������ʾ��ʽ
	    	String  nowTime= df.format(dt);
	    	
	    	return nowTime;}
	  
	    public static void main(String[] args) {
	    	GetDate g=new GetDate();
	    	System.out.println(g.GetNowDate2());
		}
}
