package com.yfor.xml.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.yfor.xml.type.Body;
import com.yfor.xml.type.Head;

@XStreamAlias("Package")
//别名注解  
//作用目标: 类,字段  
public class PackageMessage {

	@XStreamAlias("Head")
	Head head;

	@XStreamAlias("Body")
	Body body;
	public PackageMessage() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Body getBody() {
		return body;
	}

	public Head getHead() {
		return head;
	}




	public <T> void setBody(T t) {
		this.body = (Body) t;
	}

	public <T> void setHead(T t) {
		this.head = (Head) t;
	}




}
