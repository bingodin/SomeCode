package com.yfor.xml.utilts;

import com.yfor.xml.bean.PackageMessage;
/**
 * ¼òµ¥½Ó¿Ú
 * @author xiaoqiang
 *
 */
public interface ItoXmltoBean {
	public <T> T toBeanFromStr(String str, Class<T> cls);

	public String toXml(PackageMessage p);
}
