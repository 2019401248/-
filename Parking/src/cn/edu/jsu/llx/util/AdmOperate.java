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
	 public static boolean addAdm(String stu,String password) {//����passwordΪѧ��
		  try(FileReader fr=new FileReader(file);
		      FileWriter fw=new FileWriter(file,true);){
		    char[] tmp=new char[1024];
		    int len=0;
		    while((len=fr.read(tmp))!=-1) {
		       if(new String(tmp,0,len).contains(password)) {//��ȡ�������а���ѧ��
		         return false;
		    }}
		    fw.write(stu);
		  }catch(Exception e1) {e1.printStackTrace();}
		  return true;
		}
	 public static boolean inter(String zh,String mm) {//��¼
		 String a,b;
	    	DatabaseConnection dbcs=new DatabaseConnection();//ʹ��1�ж�����������ݿ����
	    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
	    		ResultSet rs=pstmt.executeQuery();//ִ�в�ѯ��䣬����ŵ����ݼ���
	    		while(rs.next()) {//�������ݼ�
	    			a=rs.getString("name");
	    			b=rs.getString("password");
                  if(zh.equals(a)&&mm.equals(b))  
                	   return true;
	    		}
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    	return false;//��������������
	 }
	 public static void initFile() {
		 String a,b;
	    	DatabaseConnection dbcs=new DatabaseConnection();//ʹ��1�ж�����������ݿ����
	    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
	    		PreparedStatement pstmt=conn.prepareStatement(sql);
	    			FileWriter fw=new FileWriter(file,true);){//ʵ����PreparedStatement
	    		ResultSet rs=pstmt.executeQuery();//ִ�в�ѯ��䣬����ŵ����ݼ���
	    		while(rs.next()) {//�������ݼ�
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
		 JOptionPane.showMessageDialog(null, "�����ļ��ɹ�");
	}
}
