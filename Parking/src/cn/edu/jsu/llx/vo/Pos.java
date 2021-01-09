package cn.edu.jsu.llx.vo;

public class Pos {
  private int  carpos;
  private  boolean  flag;
  private user user;

public Pos(int carpos, boolean flag, cn.edu.jsu.llx.vo.user user) {
	super();
	this.carpos = carpos;
	this.flag = flag;
	this.user = user;
}
public void setCarpos(int carpos) {
	this.carpos = carpos;
}
public boolean isFlag() {
	return flag;
}
public void setFlag(boolean flag) {
	this.flag = flag;
}
public user getUser() {
	return user;
}
public void setUser(user user) {
	this.user = user;
}
public int getCarpos() {
	return carpos;
}
  
}
