package cn.edu.jsu.llx.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.RowFilter.Entry;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;




public class PosOpeate {
	   public  static void seachName(DefaultTableModel model,JTable table,String str) {
		   TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);//���ñ��ģ�͹�����
		   table.setRowSorter(sorter);//���ñ��������

		   RowFilter<Object, Object> cjFilter = new RowFilter<Object, Object>() {
			   public boolean include(Entry<? extends Object, ? extends Object> entry) {
				   
			     if(entry.getStringValue(2).contains(str) ) {//���˵�1���ֶβ���str
			       return true;
			     }
			     return false;
			  }
			 };
			 sorter.setRowFilter(cjFilter);//���ù�����
			 table.setRowSorter(sorter);//���ñ��������

	   }
	   public static long fee(String statrt,String type,String time)
	   {
		   long money=0;
		    Date d= new Date();
            String pat="yyyy-mm-dd hh:mm:ss";
            SimpleDateFormat  end=new  SimpleDateFormat (pat);
            try {
                System.out.println(statrt);
				Date s=end.parse(statrt);
				int i=(int) (d.getTime()-s.getTime());
				int day=i/(24*60*60*1000);
				int hour=(i/(60*60*1000)-24*day);
				int min=(i/(60*1000)-day*24*60-hour*60);
				if(min>30)
					hour++;
				int hours=day*60+hour;
				if("С�ͳ�".equals(type))
					money=hours*60;
				else if("���ͳ�".equals(type))
					money=hours*70;
				else
					money=hours*80;
				time=time+"����ͣ��"+day+"��"+hour+"Сʱ"+min+"����";
				System.out.println(time);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            return money;
	   }
}
