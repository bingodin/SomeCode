package com.yfor.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.yfor.xml.bean.CustomOrderBody;
import com.yfor.xml.bean.PackageMessage;
import com.yfor.xml.bean.ProviadBody;
import com.yfor.xml.bean.ProviadHead;
import com.yfor.xml.utilts.XmlUtils;
public class TestUtils {
	@Test
public  void testUtils() throws Exception {
	
	PackageMessage p =new PackageMessage();
	p.setHead(new ProviadHead());
	ProviadBody proviadBody = new ProviadBody("01");
	proviadBody.setName("ºþÄÏ");
	p.setBody(proviadBody);
	String xml = XmlUtils.toXml(p);
	System.out.println(xml);
  
		 
	PackageMessage packageMessagetoBean = XmlUtils.PackageMessagetoBean(xml, ProviadHead.class, ProviadBody.class);
	System.out.println(XmlUtils.toXml(packageMessagetoBean));
	assertEquals(xml, XmlUtils.toXml(packageMessagetoBean));
	
	
	p.setBody(new CustomOrderBody());
	xml = XmlUtils.toXml(p);
	System.out.println(xml);
	packageMessagetoBean=XmlUtils.PackageMessagetoBean(xml, ProviadHead.class, CustomOrderBody.class);
	System.out.println(XmlUtils.toXml(packageMessagetoBean));
	assertEquals(xml, XmlUtils.toXml(packageMessagetoBean));
}

	
		




}