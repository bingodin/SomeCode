package com.yfor.xml.utilts;

import com.yfor.xml.bean.PackageMessage;
/**
 * �򵥽ӿ�
 * @author xiaoqiang
 *
 */
public interface ItoXmltoBean {
	public <T> T toBeanFromStr(String str, Class<T> cls);

	public String toXml(PackageMessage p);
}
