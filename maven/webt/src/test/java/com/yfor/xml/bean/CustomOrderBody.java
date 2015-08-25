package com.yfor.xml.bean;

import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.yfor.xml.type.Body;
/**
 * 客户订单返回信息的包
 * @author Administrator
 *
 */

@XStreamAlias("Body")
public class CustomOrderBody extends Body {
	@XStreamAlias("Orders")
	ArrayList<Order> orders;
	String Name ;
	 

	
String id;


public CustomOrderBody(){
	orders= new ArrayList<Order>();
	orders.add(new Order(1));
	orders.add(new Order(2));
}
public String getId() {
	return id;
}


public String getName() {
	return Name;
}


public ArrayList<Order> getOrders() {
	return orders;
}


public void setId(String id) {
	this.id = id;
}


public void setName(String name) {
	Name = name;
}


public void setOrders(ArrayList<Order> orders) {
	this.orders = orders;
}



	
}
