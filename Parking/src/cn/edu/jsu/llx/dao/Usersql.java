package cn.edu.jsu.llx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import cn.edu.jsu.llx.util.DataOpeate;

public class Usersql {
	public static void  initUsers() {
		DatabaseConnection dbcs=new DatabaseConnection();//使用1中定义的连接数据库的类
    	String sql="insert into Users(carid,name,phone,pos,intime,outtime) values(?,?,?,?,?,?)";//使用占位符定义插入语句
    	try(Connection conn=dbcs.getConnection();//获取数据库接
    		PreparedStatement pstmt=conn.prepareStatement(sql);
    			){//实例化PreparedStatement
    		ArrayList<String> alist=new ArrayList<String>();
    		for(int i=1;i<=10000;i++) {
               String carid=DataOpeate.getCarid();
	    			if(!alist.contains(carid)) {//判断车牌是否唯一
	    				alist.add(carid);//将车排加入集合
	    				String name=DataOpeate.getChineseName();//随机获取姓名
	    				String phone=DataOpeate.getPhone();
	    				String intime=DataOpeate.getTime("2019");
	    				String outtime=DataOpeate.getTime("2020");
	    				int pos=DataOpeate.getPos();
	    				pstmt.setString(1, carid);//定义第1个占位符的内容
	    	    		pstmt.setString(2, name);//定义第2个占位符的内容
	    	    		pstmt.setString(3, phone);
	    	    		pstmt.setInt(4, pos);
	    	    		pstmt.setString(5, intime);
	    	    		pstmt.setString(6, outtime);
	    	    		pstmt.addBatch();//加入批处理等待执行
	    				i++;//学号唯一，循环继续往下执行
	    			}
	    		}
    		
    		pstmt.executeBatch();//批量执行插入操作
    		JOptionPane.showMessageDialog(null, "sucess");
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
	}
   public static void main(String []args)
   {
	   initUsers();
	   
   }
}
