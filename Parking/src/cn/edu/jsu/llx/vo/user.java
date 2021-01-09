package cn.edu.jsu.llx.vo;

import java.text.SimpleDateFormat;

public class user {
    private String name;
    private String  phone;
    private  String  carid;
    private Pos  pos;
    private String   intime;
    private String   outtime;

	public user(String name, String phone, String carid, Pos pos, String sdf1, String sdf2) {
		super();
		this.name = name;
		this.phone = phone;
		this.carid = carid;
		this.pos = pos;
		this.intime = sdf1;
		this.outtime = sdf2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getIntime() {
		return intime;
	}
	public void setIntime(String intime) {
		this.intime = intime;
	}
	public String getOuttime() {
		return outtime;
	}
	public void setOuttime(String outtime) {
		this.outtime = outtime;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCarid() {
		return carid;
	}
	public void setCarid(String carid) {
		this.carid = carid;
	}
	public Pos getPos() {
		return pos;
	}
	public void setPos(Pos pos) {
		this.pos = pos;
	}

    
}
