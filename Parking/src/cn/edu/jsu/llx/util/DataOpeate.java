package cn.edu.jsu.llx.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

import cn.edu.jsu.llx.dao.DatabaseConnection;



public class DataOpeate {
	//��������
	private static String firstName="��Ǯ��������֣��������������������������ʩ�ſײ��ϻ���κ�ս���л������ˮ��������˸��ɷ�����³Τ������ﻨ������Ԭ��ۺ��ʷ�Ʒ����Ѧ�׺����������ޱϺ�����������ʱ��Ƥ���뿵����Ԫ������ƽ�ƺ�������Ҧ��տ����ë����ױ���갼Ʒ��ɴ�̸��é���ܼ�������ף������������ϯ����ǿ��·¦Σ��ͯ�չ�÷ʢ�ֵ�����������Ĳ��﷮���������֧�¾̹�¬Ī�������Ѹɽ�Ӧ�������ڵ��������������ʯ�޼�ť�������ϻ���½��������춻���κ�ӷ����ഢ���������ɾ��θ����ڽ��͹�����ɽ�ȳ������ȫۭ�����������������ﱩ�����������������ղ����Ҷ��˾��۬�輻��ӡ�ް׻���̨�Ӷ����̼���׿�����ɳ����������ܲ�˫��ݷ����̷�����̼������Ƚ��۪Ӻȴ�ɣ���ţ��ͨ�����༽ۣ����ũ�±�ׯ�̲����ֳ�Ľ����ϰ�°���������������θ����߾Ӻⲽ�����������Ŀܹ�»�ڶ�Ź�����εԽ��¡ʦ�������˹��������������Ǽ��Ŀ�����ɳؿ������ᳲ�������󽭺�����Ȩ�ָ��滸����ٹ˾���Ϲ�ŷ���ĺ�������˶��������ʸ�ξ�ٹ����̨��ұ���������������̫����������������ԯ�������������Ľ����������˾ͽ˾������˾���붽�ӳ�����ľ����������������ṫ���ذμй��׸����������ַ���۳Ϳ�նθɰ��ﶫ�����ź��ӹ麣����΢����˧�ÿ�������������������������Ĳ��٦�����Ϲ�ī�������갮��١�����Ը��ټ�����";
	//����Ů������
	private static String girl="���Ӣ���������Ⱦ���������֥��Ƽ�����ҷ���ʴ��������÷���������滷ѩ�ٰ���ϼ����ݺ�����𷲼Ѽ�������������Ҷ�������������ɺɯ������ٻ�������ӱ¶������������Ǻɵ���ü������ޱݼ���Է�ܰ�������԰��ӽ�������ع���ѱ�ˬ������ϣ����Ʈ�����������������������ܿ�ƺ������˿ɼ���Ӱ��֦˼�� ";
	//������������
    private static String boy="ΰ�����㿡��ǿ��ƽ�����Ļ�������������־��������ɽ�ʲ���������Ԫȫ��ʤѧ��ŷ���������ɱ�˳���ӽ��β��ɿ��ǹ���ﰲ����ï�����м�ͱ벩���Ⱦ�����׳��˼Ⱥ���İ�����ܹ����ƺ���������ԣ���ܽ���������ǫ�����֮�ֺ��ʲ����������������ά�������������󳿳�ʿ�Խ��������׵���ʱ̩ʢ��衾��ڲ�����ŷ纽��";
    private static String carid1="�����弽ԥ���ɺ�����³������Ӷ���ʽ����¼���������ش�����";
    private static String carid2="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static int getNum(int start,int end) {//������ط���ָ����Χ�������
    	//Math.random()�������0.0��1.0֮�����
        return (int)(Math.random()*(end-start+1)+start);
    }
    public static String getChineseName() {
        int index=getNum(0, firstName.length()-1);//���ȡ�����ַ����е�����λ��
        String first=firstName.substring(index, index+1);//��ȡ��λ�õ�����
        int sex=getNum(0,1);//���ȡ�Ա�����1Ϊ������0ΪŮ��
        String str=boy;//��������Ϊ�����ַ���
        int length=boy.length();//��ȡ�����ַ����ĳ���
        if(sex==0){//��������ȡΪ0�������ָ�ΪŮ��
            str=girl;
            length=girl.length();
        }
        index=getNum(0,length-1);//�����ȡ���ֵ�λ��
        String second=str.substring(index, index+1);//��ȡ��λ���е�����
        int hasThird=getNum(0,1);//�����ȡ�����Ƿ��е�������
        String third="";//Ĭ��û�е�������
        if(hasThird==1){//��������ȡΪ1�����е�������
            index=getNum(0,length-1);
            third=str.substring(index, index+1);
        }
        return first+second+third;//��������
    }
    public static String  getPassword() {//�����������
    	String password="";
    	for(int i=0;i<6;i++)//����Ϊ6λ
    		password=password+getNum(0,9);
    	return password;
    }
    public static String  getCarid() {//���ɳ��ƺ�
    	String id="";
    	int x=getNum(0,carid1.length()-1);
    	id=id+carid1.substring(x,x+1);
    	int y=getNum(0,carid2.length()-1);
    	id=id+carid2.substring(y,y+1);
    	int z=getNum(0,carid2.length()-1);
    	id=id+"-"+carid2.substring(z,z+1);
    	for(int i=1;i<=4;i++)
    		id=id+getNum(0,9);
    	return id;
    }
    public static String  getPhone() {//��������ֻ�����
    	String p="1";
    	for(int i=0;i<10;i++)
    	{
    		p=p+getNum(0, 9);
    		
    	}
    	return p;
    }
    public static int getPos()//������ɳ�λ
    {
    	int pos=getNum(1,500);
    	return pos;
    }
    public  static String getTime(String year)//��������복ʱ��
    {
    	String time=""+year;
    	int month=getNum(1, 12);
    	 if(month<10)
    		 time=time+"-0"+month;
    	 else
    		 time=time+"-"+month;
    	int day=getNum(1,31);
   	     if(day<10)
		     time=time+"-0"+day;
	     else
		     time=time+"-"+day;
    	int hour=getNum(0, 24);
   	     if(hour<10)
		     time=time+" 0"+hour;
	     else
		     time=time+" "+hour;
    	int min=getNum(0,60);
   	     if(min<10)
		     time=time+":0"+min;
	    else
		     time=time+":"+min;
   	    int ms=getNum(0,60);
   	     if(ms<10)
		     time=time+":0"+ms;
	     else
		     time=time+":"+ms;
    	
    	return time;
    }
    public static Vector<Vector> getSelectAll(String sql){//
    	Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
    	DatabaseConnection dbcs=new DatabaseConnection();//ʹ��1�ж�����������ݿ����
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//ִ�в�ѯ��䣬����ŵ����ݼ���
    		while(rs.next()) {//�������ݼ�
    			Vector row=new Vector();//����������
    			row.add(rs.getInt(1));//��ȡ��һ���ֶ�ѧ��
    			row.add(rs.getString(2));//��ȡ�ڶ����ֶ�����
    			row.add(rs.getString(3));//��ȡ�������ֶγɼ�
    			row.add(rs.getString(4));//��ȡ�������ֶγɼ�
    			row.add(rs.getString(5));
    			row.add(rs.getString(6));
    			row.add(rs.getString(7));
    			rows.add(row);//����������ӵ���¼������
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return rows;//��������������
    }
}
