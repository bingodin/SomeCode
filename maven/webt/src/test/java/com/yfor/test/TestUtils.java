package com.yfor.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.yfor.xml.bean.CustomOrderBody;
import com.yfor.xml.bean.FailedHead;
import com.yfor.xml.bean.Head;
import com.yfor.xml.bean.PackageMessage;
import com.yfor.xml.bean.ProviadBody;
import com.yfor.xml.type.PackageType;
import com.yfor.xml.utilts.XmlUtils;
public class TestUtils {
	/**
	 * 测试类
	 * @throws Exception
	 */
	@Test
public  void testUtils() throws Exception {
	
	PackageMessage p =new PackageMessage(PackageType.REQUEST);
	p.setHead(new Head());
	
	
	ProviadBody proviadBody = new ProviadBody("01");
	proviadBody.setName("湖南");
	p.setBody(proviadBody);
	
	
	String xml = XmlUtils.toXml(p);
	System.out.println(xml);
  
		 
	PackageMessage packageMessagetoBean = XmlUtils.PackageMessagetoBean(xml, Head.class, ProviadBody.class);
	
	
	
	System.out.println(XmlUtils.toXml(packageMessagetoBean));
	assertEquals(xml, XmlUtils.toXml(packageMessagetoBean));
	p =new PackageMessage(PackageType.RESPOSE);
	p.setHead(new FailedHead("不能为空"));
	p.setBody(new CustomOrderBody());
	xml = XmlUtils.toXml(p);
	System.out.println(xml);
	packageMessagetoBean=XmlUtils.PackageMessagetoBean(xml, FailedHead.class, CustomOrderBody.class);
	System.out.println(XmlUtils.toXml(packageMessagetoBean));
	assertEquals(xml, XmlUtils.toXml(packageMessagetoBean));
}

	
		




}