package com.yfor.xml.utilts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.yfor.xml.bean.PackageMessage;
import com.yfor.xml.type.ContentValue;
/**
 * xml工具类
 * 
 * @author wangqiang
 *
 */
public class XmlUtils {
	/**
	 * 
	 * @param doc
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Map<String, Object> Dom2Map(Document doc){
		Map<String, Object> map = new HashMap<String, Object>();
		if(doc == null)
			return map;
		Element root = doc.getRootElement();
		for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
			Element e = (Element) iterator.next();
			//System.out.println(e.getName());
			List list = e.elements();
			if(list.size() > 0){
				map.put(e.getName(), Dom2Map(e));
			}else
				map.put(e.getName(), e.getText());
		}
		return map;
	}
	
	/**
	 * 
	 * @param e
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static  Map Dom2Map(Element e){
		Map	map = new HashMap();
		List list = e.elements();
		if(list.size() > 0){
			for (int i = 0;i < list.size(); i++) {
				Element iter = (Element) list.get(i);
				List mapList = new ArrayList();
				
				if(iter.elements().size() > 0){
					Map m = Dom2Map(iter);
					if(map.get(iter.getName()) != null){
						Object obj = map.get(iter.getName());
						if(!obj.getClass().getName().equals("java.util.ArrayList")){
							mapList = new ArrayList();
							mapList.add(obj);
							mapList.add(m);
						}
						if(obj.getClass().getName().equals("java.util.ArrayList")){
							mapList = (List) obj;
							mapList.add(m);
						}
						map.put(iter.getName(), mapList);
					}else
						map.put(iter.getName(), m);
				}
				else{
					if(map.get(iter.getName()) != null){
						Object obj = map.get(iter.getName());
						if(!obj.getClass().getName().equals("java.util.ArrayList")){
							mapList = new ArrayList();
							mapList.add(obj);
							mapList.add(iter.getText());
						}
						if(obj.getClass().getName().equals("java.util.ArrayList")){
							mapList = (List) obj;
							mapList.add(iter.getText());
						}
						map.put(iter.getName(), mapList);
					}else
						map.put(iter.getName(), iter.getText());
				}
			}
		}else
			map.put(e.getName(), e.getText());
		return map;
	}
	/**
	 * 将xml转换成 PackageMessage
	 * 因为类的继承关系所以不能直接转换
	 * @param xml
	 * @param headClass
	 * @param bodyClass
	 * @return PackageMessage（bean）
	 * @throws Exception
	 */

	public static  <T> PackageMessage PackageMessagetoBean(String xml,Class<?>  headClass,Class<?> bodyClass) throws Exception {

		//可以优化取参数的方式  例如dom4j
		String splitStr="<Body";
		String[] split = xml.split(splitStr);
		if(split.length!=2){
			return null;
		}
		String headStr=ContentValue.xmlHead+split[0].substring(split[0].indexOf("<Head"));
		String bodyStr=ContentValue.xmlHead+"<Body"+split[1].substring(0, split[1].lastIndexOf("<"));
		PackageMessage p=new  PackageMessage();

		p.setBody(toBeanFromStr(bodyStr,bodyClass));
		p.setHead(toBeanFromStr(headStr,headClass));
		return p;
	}
	/**
	 * 单个类的转换
	 * @param str
	 * @param cls
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static <T> T  toBeanFromStr(String str,Class<T> cls) throws Exception{
		   	XStream xstream = new XStream(new DomDriver());
		  
		 xstream.processAnnotations(cls);
		 return (T)xstream.fromXML(str);   
     }
	/**
	 * 
	 * @param p
	 * @return
	 */
	 public static String   toXml(PackageMessage p){
		XStream xstream = new XStream();
		xstream.aliasSystemAttribute(null, "class");//去掉class熟悉
//		xstream.processAnnotations(this.getClass());
		xstream.autodetectAnnotations(true); 
		
		StringBuilder xml = new StringBuilder();
		xml.append(ContentValue.xmlHead).append(xstream.toXML(p));
		return xml.toString();
	} 
}

