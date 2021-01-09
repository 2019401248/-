package cn.edu.jsu.llx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import cn.edu.jsu.llx.util.DataOpeate;

public class Possql {
	 public static void initPos() {
	    	DatabaseConnection dbcs=new DatabaseConnection();//使用1中定义的连接数据库的类
	    	String sql="insert into pos(pos,state,carid,name,phone,intime) values(?,?,?,?,?,?)";//使用占位符定义插入语句
	    	try(Connection conn=dbcs.getConnection();//获取数据库接
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
	    		ArrayList<String> alist1=new ArrayList<String>();
	    		for(int i=1;i<=500;i++) {
	    			pstmt.setInt(1, i);
	               int flag=DataOpeate.getNum(0, 1);
	               if (flag==0)
	                {
	            	   pstmt.setString(2, "true");
	                      String carid=DataOpeate.getCarid();
	       	    			if(!alist1.contains(carid)) {//判断车牌是否唯一
	       	    				alist1.add(carid);//将车排加入集合
	       	    				String name=DataOpeate.getChineseName();//随机获取姓名
	       	    				String phone=DataOpeate.getPhone();
	       	    				String intime=DataOpeate.getTime("2019");  	  
	       	    				pstmt.setString(3, carid);//定义第1个占位符的内容
	       	    	    		pstmt.setString(4, name);//定义第2个占位符的内容
	       	    	    		pstmt.setString(5, phone);
	       	    	    		pstmt.setString(6, intime);
	       	    	 }
	       	    	}
	               else
	               {
	            	   pstmt.setString(2, "false");
  	    				pstmt.setString(3, null);
   	    	    		pstmt.setString(4, null);
   	    	    		pstmt.setString(5, null);
   	    	    		pstmt.setString(6, null);
	               }

	               pstmt.addBatch();
	    		}
	    		pstmt.executeBatch();//批量执行插入操作
	    		JOptionPane.showMessageDialog(null, "sucess");
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    }
	    public static void main(String []args) {
	    	
	    	initPos();
	    	
	    }
	    public static void insert(int poss,String id,String name,String phone,String intime)
	    {
	    	DatabaseConnection dbcs=new DatabaseConnection();//使用1中定义的连接数据库的类
	    	String sql="Update  pos Set state= ?,carid= ?,name= ?,phone= ?,intime= ? where pos=?";//使用占位符定义插入语句
	    	try(Connection conn=dbcs.getConnection();//获取数据库接
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
	    		pstmt.setString(1, "true");
	    		pstmt.setString(2, id);
	    		pstmt.setString(3, name);
	    		pstmt.setString(4, phone);
	    		pstmt.setString(5, intime);
	    		pstmt.setInt(6, poss);
	               pstmt.addBatch();
	    		pstmt.executeBatch();//批量执行插入操作
	    		JOptionPane.showMessageDialog(null, "添加成功");
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    }
	    public static void deleteuser(String ad)
	    {
	    	//System.out.println("ok");
	    	DatabaseConnection dbcs=new DatabaseConnection();//使用1中定义的连接数据库的类
	    	String sql="Update  pos Set state= ?,carid= ?,name= ?,phone= ?,intime= ? where pos=?";//使用占位符定义插入语句
	    	try(Connection conn=dbcs.getConnection();//获取数据库接
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
	    		pstmt.setString(1, "true");
	    		pstmt.setString(2, null);
	    		pstmt.setString(3, null);
	    		pstmt.setString(4, null);
	    		pstmt.setString(5, null);
	    		pstmt.setString(6, ad);
	               pstmt.addBatch();
	    		
	    		pstmt.executeBatch();//批量执行插入操作
	    		JOptionPane.showMessageDialog(null, "出车成功");
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    }
	    public static String seachtime(String ad) {
	    	DatabaseConnection dbcs=new DatabaseConnection();//使用1中定义的连接数据库的类
	    	String sql="Select * from pos";//使用占位符定义插入语句
	    	String AC=null;
	    	try(Connection conn=dbcs.getConnection();//获取数据库接
	    		Statement pstmt=conn.createStatement();
	    			ResultSet rslt=pstmt.executeQuery(sql);){//实例化PreparedStatement
	    		while(rslt.next()) {
	    			String ID=rslt.getString("carid");
	    			//System.out.println(ID);
	    			if(ad.equals(ID))
	    			{
	    				AC=rslt.getString("intime");
	    			}
	    		}
                 
	    		
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    }
			return AC;
	     
      }
	    public static void clear() {
	    	DatabaseConnection dbcs=new DatabaseConnection();//使用1中定义的连接数据库的类
	    	String sql="Update  pos Set state= ?,carid= ?,name= ?,phone= ?,intime= ? ";//使用占位符定义插入语句
	    	try(Connection conn=dbcs.getConnection();//获取数据库接
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
	    		pstmt.setString(1, "false");
	    		pstmt.setString(2, null);
	    		pstmt.setString(3, null);
	    		pstmt.setString(4, null);
	    		pstmt.setString(5, null);
	    		
	               pstmt.addBatch();
	    		pstmt.executeBatch();//批量执行插入操作
	    		JOptionPane.showMessageDialog(null, "已清空停车场");
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    }
	    public static  void deletepos(int pos1) {
	    	DatabaseConnection dbcs=new DatabaseConnection();//使用1中定义的连接数据库的类
	    	String sql="Delete from pos where pos=?";//使用占位符定义插入语句
	    	try(Connection conn=dbcs.getConnection();//获取数据库接
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
	    		pstmt.setInt(1, pos1);
	               pstmt.addBatch();
	    		pstmt.executeBatch();//批量执行插入操作
	    		JOptionPane.showMessageDialog(null, "已删除该车位");
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    }
	    public static   void  addPos(int pos1) {
	    	DatabaseConnection dbcs=new DatabaseConnection();//使用1中定义的连接数据库的类
	    	String sql="Insert into pos(pos,state)"+"values(?,?)";//使用占位符定义插入语句
	    	try(Connection conn=dbcs.getConnection();//获取数据库接
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
	    	     pstmt.setInt(1, pos1);
	    		 pstmt.setString(2, null);
	               pstmt.addBatch();
	    		pstmt.executeBatch();//批量执行插入操作
	    		JOptionPane.showMessageDialog(null, "添加车位成功");
	    	}catch(SQLException e) {
	    		JOptionPane.showMessageDialog(null, "该车位已存在");
	    		e.printStackTrace();
	    	}
	    }
}