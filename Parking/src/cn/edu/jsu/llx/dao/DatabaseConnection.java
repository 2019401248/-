package cn.edu.jsu.llx.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	// ����SQLServer�����ݿ���������
	public static final String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver" ;
	// ����SQLServer���ݿ�����ӵ�ַ
	public static final String DBURL = "jdbc:sqlserver://localhost:1433;DatabaseName=Parking Information" ;
	// SQL���ݿ�������û���
	public static final String DBUSER = "sa" ;
	// MySQL���ݿ����������
	public static final String DBPASS = "123456789" ;
	  private Connection conn=null; //�������Ӷ���
	  public DatabaseConnection() {//���췽���������ݿ�
	    try {
	      Class.forName(DBDRIVER);
	      this.conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
	    } catch (Exception e) {e.printStackTrace();}
	  }
	  public Connection getConnection() {//�������ݿ����Ӷ���
	    return this.conn;
	  }
	  public void close() {//�ر���������
	    if(this.conn!=null) {
	      try {this.conn.close();} catch (SQLException e) {e.printStackTrace();}
	}}}
