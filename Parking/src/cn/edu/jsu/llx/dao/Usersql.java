package cn.edu.jsu.llx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import cn.edu.jsu.llx.util.DataOpeate;

public class Usersql {
	public static void  initUsers() {
		DatabaseConnection dbcs=new DatabaseConnection();//ʹ��1�ж�����������ݿ����
    	String sql="insert into Users(carid,name,phone,pos,intime,outtime) values(?,?,?,?,?,?)";//ʹ��ռλ������������
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
    		PreparedStatement pstmt=conn.prepareStatement(sql);
    			){//ʵ����PreparedStatement
    		ArrayList<String> alist=new ArrayList<String>();
    		for(int i=1;i<=10000;i++) {
               String carid=DataOpeate.getCarid();
	    			if(!alist.contains(carid)) {//�жϳ����Ƿ�Ψһ
	    				alist.add(carid);//�����ż��뼯��
	    				String name=DataOpeate.getChineseName();//�����ȡ����
	    				String phone=DataOpeate.getPhone();
	    				String intime=DataOpeate.getTime("2019");
	    				String outtime=DataOpeate.getTime("2020");
	    				int pos=DataOpeate.getPos();
	    				pstmt.setString(1, carid);//�����1��ռλ��������
	    	    		pstmt.setString(2, name);//�����2��ռλ��������
	    	    		pstmt.setString(3, phone);
	    	    		pstmt.setInt(4, pos);
	    	    		pstmt.setString(5, intime);
	    	    		pstmt.setString(6, outtime);
	    	    		pstmt.addBatch();//����������ȴ�ִ��
	    				i++;//ѧ��Ψһ��ѭ����������ִ��
	    			}
	    		}
    		
    		pstmt.executeBatch();//����ִ�в������
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
