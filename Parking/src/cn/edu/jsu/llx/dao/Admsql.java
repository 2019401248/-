package cn.edu.jsu.llx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import cn.edu.jsu.llx.util.DataOpeate;


public class Admsql {

    	    public static void addAdm() {//���ӹ���Ա
    	    	DatabaseConnection dbcs=new DatabaseConnection();//ʹ��1�ж�����������ݿ����
    	    	String sql="insert into Administrators(name,password) values(?,?)";//ʹ��ռλ������������
    	    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
    	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
    	        	ArrayList<String> alist=new ArrayList<String>();//���弯��
    	    		for(int i=1;i<=10;) {
    	    			String password=DataOpeate.getPassword();//�����ȡ����
    	    			if(!alist.contains(password)) {//�ж������Ƿ�Ψһ
    	    				alist.add(password);//��ѧ�ż��뼯��
    	    				String xm=DataOpeate.getChineseName();//�����ȡ����
    	    				pstmt.setString(1, xm);//�����1��ռλ��������
    	    	    		pstmt.setString(2, password);//�����2��ռλ��������
    	    	    		pstmt.addBatch();//����������ȴ�ִ��
    	    				i++;//ѧ��Ψһ��ѭ����������ִ��
    	    			}
    	    		}
    	    		pstmt.executeBatch();//����ִ�в������
    	    		JOptionPane.showMessageDialog(null, "����Administrators��������");
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

