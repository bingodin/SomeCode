package com.yfor.xml.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.yfor.xml.type.Head;
import com.yfor.xml.type.HeadType;
import com.yfor.xml.type.RequestType;
@XStreamAlias("Head")
public class ProviadHead extends Head {
	

	 



	public ProviadHead(){
		
		
		 type=HeadType.REQUEST;
		 requestType=RequestType.VO1;
	 }

	
}
