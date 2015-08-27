package com.yfor.xml.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.yfor.xml.type.Body;

@XStreamAlias("Body")
public class ProviadBody extends Body {
	
String Name ;


String pid;
public ProviadBody(){
}
public ProviadBody(String pid) {
	super();
	this.pid = pid;
}
public String getName() {
	return Name;
}



public String getPid() {
	return pid;
}

public void setName(String name) {
	Name = name;
}

public void setPid(String pid) {
	this.pid = pid;
}
	
}
