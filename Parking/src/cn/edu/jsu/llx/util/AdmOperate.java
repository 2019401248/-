package cn.edu.jsu.llx.util;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

import cn.edu.jsu.llx.dao.DatabaseConnection;



public class AdmOperate {
	 final static File file=new File("E:/Parking/Admini.txt");
	 final static String sql="Select * from Administrators";
	 public static boolean addAdm(String stu,String password) {//参数password为学号
		  try(FileReader fr=new FileReader(file);
		      FileWriter fw=new FileWriter(file,true);){
		    char[] tmp=new char[1024];
		    int len=0;
		    while((len=fr.read(tmp))!=-1) {
		       if(new String(tmp,0,len).contains(password)) {//读取的数据中包含学号
		         return false;
		    }}
		    fw.write(stu);
		  }catch(Exception e1) {e1.printStackTrace();}
		  return true;
		}
	 public static boolean inter(String zh,String mm) {//登录
		 String a,b;
	    	DatabaseConnection dbcs=new DatabaseConnection();//使用1中定义的连接数据库的类
	    	try(Connection conn=dbcs.getConnection();//获取数据库接
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
	    		ResultSet rs=pstmt.executeQuery();//执行查询语句，结果放到数据集中
	    		while(rs.next()) {//遍历数据集
	    			a=rs.getString("name");
	    			b=rs.getString("password");
                  if(zh.equals(a)&&mm.equals(b))  
                	   return true;
	    		}
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    	return false;//返回所有行数据
	 }
	 public static void initFile() {
		 String a,b;
	    	DatabaseConnection dbcs=new DatabaseConnection();//使用1中定义的连接数据库的类
	    	try(Connection conn=dbcs.getConnection();//获取数据库接
	    		PreparedStatement pstmt=conn.prepareStatement(sql);
	    			FileWriter fw=new FileWriter(file,true);){//实例化PreparedStatement
	    		ResultSet rs=pstmt.executeQuery();//执行查询语句，结果放到数据集中
	    		while(rs.next()) {//遍历数据集
	    			a=rs.getString("name");
	    			b=rs.getString("password");
	    			System.out.println(a+"   "+b);
	    			fw.write(a+"\t"+b+"\r\n");   
               }
                 
	    		
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	 }
       public static void main(String[] args) {
		 initFile();
		 JOptionPane.showMessageDialog(null, "加载文件成功");
	}
}
