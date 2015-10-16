import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;
/**
 * 将样式变成类
 * 你可以尝试将类的形式合并成css
 * 比较两种形式的好坏 不要极端   看看大网站的代码猜一猜知道一些原因
 * 是dom4j-1.61
 * @author xiaoqiang
 *
 */
public class TestXMl {
	// 最终生成的css输出
	private static StringBuffer cssOut = new StringBuffer();

	public static void main(String[] args) throws DocumentException,
			IOException {
		// 输出
		// 输出到控制台

		XMLWriter xmlWriter = new XMLWriter();
		xmlWriter.write(changStyleToClass(mockresponseXMLStart()));
		System.out.println();
		System.out.println(getCssOut());
	}

	/**
	 * 假的xml测试数据
	 * 
	 * @return
	 */
	public static String mockresponseXMLStart() {
		StringBuffer sb = new StringBuffer();
		sb.append("<Packet type=\"REQUEST\" version=\"1.0\">");
		sb.append("<Head>");
		sb.append("<ResquestType>WX110</ResquestType>");
		sb.append("<ResponseCode>0000</ResponseCode>");
		sb.append("<ErrorMessage>成功</ErrorMessage>");
		sb.append("</Head>");
		sb.append("<Body>");
		sb.append("<table id='idtest' style='width:200;height:100'  >");
		sb.append("<TD id='idtest' style='width:100;height:100'  >");
		sb.append("xx");
		sb.append("</TD>");
		sb.append("<TD id='idtest' style='width:100;height:100'  >");
		sb.append("yy");
		sb.append("</TD>");
		sb.append("</table>");
		sb.append("<div style='color:blue;float:left'>");
		sb.append("<div style='color:red;float:right'>ii");
		sb.append("</div>");
		sb.append("</div>");
		sb.append("</Body>");
		sb.append("</Packet>");
		return sb.toString();
	}

	// <Packet type="REQUEST" version="1.0">
	// <Head>
	// <ResquestType>WX110</ResquestType>
	// <ResponseCode>0000</ResponseCode>
	// <ErrorMessage>成功</ErrorMessage>
	// </Head>
	// <Body>
	// <table id='idtest' style='width:200;height:100'>
	// <TD id='idtest' style='width:100;height:100'>xx</TD>
	// <TD id='idtest' style='width:100;height:100'>yy</TD>
	// </table>
	// </Body>
	// </Packet>
	// <style>.c1595502228{width:200;height:100}.c1089943603{width:100;height:100}.c1089943603{width:100;height:100}<style>
	// <?xml version="1.0" encoding="UTF-8"?>
	// <Packet type="REQUEST" version="1.0">
	// <Head>
	// <ResquestType>WX110</ResquestType>
	// <ResponseCode>0000</ResponseCode>
	// <ErrorMessage>成功</ErrorMessage>
	// </Head>
	// <Body>
	// <table id="idtest" class="c1595502228">
	// <TD id="idtest" class="c1089943603">xx</TD>
	// <TD id="idtest" class="c1089943603">yy</TD>
	// </table>
	// </Body>
	// </Packet>
	/**
	 * 将样式变成类
	 * 
	 * @param xml
	 * @return
	 * @throws DocumentException
	 * @throws UnsupportedEncodingException
	 */
	public static Document changStyleToClass(String xml)
			throws DocumentException, UnsupportedEncodingException {
		Document document = DocumentHelper.parseText(xml);
		Element root = document.getRootElement();
		changElementThenChildren(root);
		return document;
	}

	/**
	 * 先对节点进行处理，再对子节点进行递归
	 * @param root
	 * @return
	 */
	private static Element changElementThenChildren(Element root) {
		changStyleToClass(root);
		List<?> elements = root.elements();
		for (Object object : elements) {
			changElementThenChildren((Element) object);
		}
		return root;
	}
	/**
	 * 返回完整style
	 * @return
	 */
	public static String getCssOut() {
		return "<style>"+cssOut+"</style>";
	}

	/**
	 * 对节点进行操作 
	 * 如果存在style属性 移除属性 
	 * 根据样式的内容生产class名 并增加class属性 
	 * 生成样式 
	 * 入参 ： <TD id='idtest' style='width:100;height:100'>xx</TD>
	 * 处理后：<TD id="idtest" class="c1089943603">yy</TD> 
	 * 附带增加 cssOut: .c1595502228{width:200;height:100}
	 * 
	 * @param root
	 */
	private static void changStyleToClass(Element root) {
		String style = root.attributeValue("style");
		if (style != null) {
			root.remove(root.attribute("style"));
			String className = ".c" + Math.abs(style.hashCode());
			root.addAttribute("class", className);
			cssOut.append(className + "{").append(style).append("}");
		}
	}

}