package cn.edu.jsu.llx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import cn.edu.jsu.llx.util.DataOpeate;


public class Admsql {

    	    public static void addAdm() {//增加管理员
    	    	DatabaseConnection dbcs=new DatabaseConnection();//使用1中定义的连接数据库的类
    	    	String sql="insert into Administrators(name,password) values(?,?)";//使用占位符定义插入语句
    	    	try(Connection conn=dbcs.getConnection();//获取数据库接
    	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
    	        	ArrayList<String> alist=new ArrayList<String>();//定义集合
    	    		for(int i=1;i<=10;) {
    	    			String password=DataOpeate.getPassword();//随机获取密码
    	    			if(!alist.contains(password)) {//判断密码是否唯一
    	    				alist.add(password);//将学号加入集合
    	    				String xm=DataOpeate.getChineseName();//随机获取姓名
    	    				pstmt.setString(1, xm);//定义第1个占位符的内容
    	    	    		pstmt.setString(2, password);//定义第2个占位符的内容
    	    	    		pstmt.addBatch();//加入批处理等待执行
    	    				i++;//学号唯一，循环继续往下执行
    	    			}
    	    		}
    	    		pstmt.executeBatch();//批量执行插入操作
    	    		JOptionPane.showMessageDialog(null, "已在Administrators生成数据");
    	    	}catch(SQLException e) {
    	    		e.printStackTrace();
    	    	}
    	    }
    	    public static void main(String args[])
    	    {
    	    	addAdm();
    	    }
    		 public static void  insertAdm(String zh,String mm) {
    			 String sql1="Insert into Administrators(name,password)"+"values(?,?)";
    			 DatabaseConnection dbcs=new DatabaseConnection();
    			 try (Connection conn=dbcs.getConnection();
    					 PreparedStatement pstmt=conn.prepareStatement(sql1);){
    				pstmt.setString(1,zh);
    				pstmt.setString(2,mm);
    				pstmt.executeUpdate();
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		 }
      }

