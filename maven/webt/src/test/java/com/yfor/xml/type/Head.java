package com.yfor.xml.type;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
/**
 * 消息头
 * @author xiaoqiang
 *
 */
public abstract  class Head {
	/**
	 * 版本
	 */
	@XStreamAsAttribute
	String version = ContentValue.version;
	@XStreamAsAttribute
	/**
	 * 头类型
	 */
	protected HeadType type;
	protected RequestType  requestType;

	 public Head() {
		super();
		// TODO Auto-generated constructor stub
	}
}
