package com.yfor.xml.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.yfor.xml.type.AbsHead;

@XStreamAlias("Head")
public class FailedHead extends AbsHead {
	String tips;

	public FailedHead(String tips) {
		super();
		this.tips = tips;
	}

	public FailedHead(){
		
	}
}
