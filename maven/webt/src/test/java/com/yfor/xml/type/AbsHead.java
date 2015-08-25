package com.yfor.xml.type;
/**
 * ÏûÏ¢Í·
 * @author xiaoqiang
 *
 */
public  abstract class AbsHead {

	protected RequestType  requestType;
	 public AbsHead() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequestType getRequestType() {
		return requestType;
	}
	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}
	public AbsHead(RequestType requestType) {
		super();
		this.requestType = requestType;
	}
}
