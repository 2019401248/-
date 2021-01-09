package cn.edu.jsu.llx.vo;

public class fee {
  private String cartype;
  private  double  price;
public fee(String cartype, double price) {
	super();
	this.cartype = cartype;
	this.price = price;
}
public String getCartype() {
	return cartype;
}
public void setCartype(String cartype) {
	this.cartype = cartype;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
  
}
