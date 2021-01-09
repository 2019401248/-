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
	    	DatabaseConnection dbcs=new DatabaseConnection();//ʹ��1�ж�����������ݿ����
	    	String sql="insert into pos(pos,state,carid,name,phone,intime) values(?,?,?,?,?,?)";//ʹ��ռλ������������
	    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
	    		ArrayList<String> alist1=new ArrayList<String>();
	    		for(int i=1;i<=500;i++) {
	    			pstmt.setInt(1, i);
	               int flag=DataOpeate.getNum(0, 1);
	               if (flag==0)
	                {
	            	   pstmt.setString(2, "true");
	                      String carid=DataOpeate.getCarid();
	       	    			if(!alist1.contains(carid)) {//�жϳ����Ƿ�Ψһ
	       	    				alist1.add(carid);//�����ż��뼯��
	       	    				String name=DataOpeate.getChineseName();//�����ȡ����
	       	    				String phone=DataOpeate.getPhone();
	       	    				String intime=DataOpeate.getTime("2019");  	  
	       	    				pstmt.setString(3, carid);//�����1��ռλ��������
	       	    	    		pstmt.setString(4, name);//�����2��ռλ��������
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
	    		pstmt.executeBatch();//����ִ�в������
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
	    	DatabaseConnection dbcs=new DatabaseConnection();//ʹ��1�ж�����������ݿ����
	    	String sql="Update  pos Set state= ?,carid= ?,name= ?,phone= ?,intime= ? where pos=?";//ʹ��ռλ������������
	    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
	    		pstmt.setString(1, "true");
	    		pstmt.setString(2, id);
	    		pstmt.setString(3, name);
	    		pstmt.setString(4, phone);
	    		pstmt.setString(5, intime);
	    		pstmt.setInt(6, poss);
	               pstmt.addBatch();
	    		pstmt.executeBatch();//����ִ�в������
	    		JOptionPane.showMessageDialog(null, "��ӳɹ�");
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    }
	    public static void deleteuser(String ad)
	    {
	    	//System.out.println("ok");
	    	DatabaseConnection dbcs=new DatabaseConnection();//ʹ��1�ж�����������ݿ����
	    	String sql="Update  pos Set state= ?,carid= ?,name= ?,phone= ?,intime= ? where pos=?";//ʹ��ռλ������������
	    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
	    		pstmt.setString(1, "true");
	    		pstmt.setString(2, null);
	    		pstmt.setString(3, null);
	    		pstmt.setString(4, null);
	    		pstmt.setString(5, null);
	    		pstmt.setString(6, ad);
	               pstmt.addBatch();
	    		
	    		pstmt.executeBatch();//����ִ�в������
	    		JOptionPane.showMessageDialog(null, "�����ɹ�");
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    }
	    public static String seachtime(String ad) {
	    	DatabaseConnection dbcs=new DatabaseConnection();//ʹ��1�ж�����������ݿ����
	    	String sql="Select * from pos";//ʹ��ռλ������������
	    	String AC=null;
	    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
	    		Statement pstmt=conn.createStatement();
	    			ResultSet rslt=pstmt.executeQuery(sql);){//ʵ����PreparedStatement
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
	    	DatabaseConnection dbcs=new DatabaseConnection();//ʹ��1�ж�����������ݿ����
	    	String sql="Update  pos Set state= ?,carid= ?,name= ?,phone= ?,intime= ? ";//ʹ��ռλ������������
	    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
	    		pstmt.setString(1, "false");
	    		pstmt.setString(2, null);
	    		pstmt.setString(3, null);
	    		pstmt.setString(4, null);
	    		pstmt.setString(5, null);
	    		
	               pstmt.addBatch();
	    		pstmt.executeBatch();//����ִ�в������
	    		JOptionPane.showMessageDialog(null, "�����ͣ����");
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    }
	    public static  void deletepos(int pos1) {
	    	DatabaseConnection dbcs=new DatabaseConnection();//ʹ��1�ж�����������ݿ����
	    	String sql="Delete from pos where pos=?";//ʹ��ռλ������������
	    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
	    		pstmt.setInt(1, pos1);
	               pstmt.addBatch();
	    		pstmt.executeBatch();//����ִ�в������
	    		JOptionPane.showMessageDialog(null, "��ɾ���ó�λ");
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    }
	    public static   void  addPos(int pos1) {
	    	DatabaseConnection dbcs=new DatabaseConnection();//ʹ��1�ж�����������ݿ����
	    	String sql="Insert into pos(pos,state)"+"values(?,?)";//ʹ��ռλ������������
	    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
	    	     pstmt.setInt(1, pos1);
	    		 pstmt.setString(2, null);
	               pstmt.addBatch();
	    		pstmt.executeBatch();//����ִ�в������
	    		JOptionPane.showMessageDialog(null, "��ӳ�λ�ɹ�");
	    	}catch(SQLException e) {
	    		JOptionPane.showMessageDialog(null, "�ó�λ�Ѵ���");
	    		e.printStackTrace();
	    	}
	    }
}