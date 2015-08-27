package com.yfor.xml.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.yfor.xml.type.AbsHead;
import com.yfor.xml.type.Body;
import com.yfor.xml.type.ContentValue;
import com.yfor.xml.type.PackageType;

@XStreamAlias("Package")
//����ע��  
//����Ŀ��: ��,�ֶ�  

public class PackageMessage {

	@XStreamAlias("Head")
	AbsHead head;

	@XStreamAlias("Body")
	Body body;
	/**
	 * �汾
	 */
	@XStreamAsAttribute
	String version = ContentValue.version;



	@XStreamAsAttribute
	/**
	 * ������
	 */
	protected PackageType type;




	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public PackageType getType() {
		return type;
	}
	public void setType(PackageType type) {
		this.type = type;
	}

	public void setHead(AbsHead head) {
		this.head = head;
	}
	public void setBody(Body body) {
		this.body = body;
	}
	public PackageMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PackageMessage(PackageType type) {
		super();
		this.type = type;
	}
	public Body getBody() {
		return body;
	}

	public AbsHead getHead() {
		return head;
	}



	public <T> void setBody(T t) {
		this.body = (Body) t;
	}

	public <T> void setHead(T t) {
		this.head = (AbsHead) t;
	}




}
