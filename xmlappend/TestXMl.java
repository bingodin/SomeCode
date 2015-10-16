import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;
/**
 * ����ʽ�����
 * ����Գ��Խ������ʽ�ϲ���css
 * �Ƚ�������ʽ�ĺû� ��Ҫ����   ��������վ�Ĵ����һ��֪��һЩԭ��
 * ��dom4j-1.61
 * @author xiaoqiang
 *
 */
public class TestXMl {
	// �������ɵ�css���
	private static StringBuffer cssOut = new StringBuffer();

	public static void main(String[] args) throws DocumentException,
			IOException {
		// ���
		// ���������̨

		XMLWriter xmlWriter = new XMLWriter();
		xmlWriter.write(changStyleToClass(mockresponseXMLStart()));
		System.out.println();
		System.out.println(getCssOut());
	}

	/**
	 * �ٵ�xml��������
	 * 
	 * @return
	 */
	public static String mockresponseXMLStart() {
		StringBuffer sb = new StringBuffer();
		sb.append("<Packet type=\"REQUEST\" version=\"1.0\">");
		sb.append("<Head>");
		sb.append("<ResquestType>WX110</ResquestType>");
		sb.append("<ResponseCode>0000</ResponseCode>");
		sb.append("<ErrorMessage>�ɹ�</ErrorMessage>");
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
	// <ErrorMessage>�ɹ�</ErrorMessage>
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
	// <ErrorMessage>�ɹ�</ErrorMessage>
	// </Head>
	// <Body>
	// <table id="idtest" class="c1595502228">
	// <TD id="idtest" class="c1089943603">xx</TD>
	// <TD id="idtest" class="c1089943603">yy</TD>
	// </table>
	// </Body>
	// </Packet>
	/**
	 * ����ʽ�����
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
	 * �ȶԽڵ���д����ٶ��ӽڵ���еݹ�
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
	 * ��������style
	 * @return
	 */
	public static String getCssOut() {
		return "<style>"+cssOut+"</style>";
	}

	/**
	 * �Խڵ���в��� 
	 * �������style���� �Ƴ����� 
	 * ������ʽ����������class�� ������class���� 
	 * ������ʽ 
	 * ��� �� <TD id='idtest' style='width:100;height:100'>xx</TD>
	 * �����<TD id="idtest" class="c1089943603">yy</TD> 
	 * �������� cssOut: .c1595502228{width:200;height:100}
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