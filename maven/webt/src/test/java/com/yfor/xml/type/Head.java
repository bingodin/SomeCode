package com.yfor.xml.type;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
/**
 * ��Ϣͷ
 * @author xiaoqiang
 *
 */
public abstract  class Head {
	/**
	 * �汾
	 */
	@XStreamAsAttribute
	String version = ContentValue.version;
	@XStreamAsAttribute
	/**
	 * ͷ����
	 */
	protected HeadType type;
	protected RequestType  requestType;

	 public Head() {
		super();
		// TODO Auto-generated constructor stub
	}
}
