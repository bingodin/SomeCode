package com.yfor.xml.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Order")
public class Order {
	int number;

	public Order(int i) {
		// TODO Auto-generated constructor stub
		number = i;
	}

	public Order(){
		
	}
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}