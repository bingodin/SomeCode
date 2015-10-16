import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;

import com.ebnsp.common.util.JSONUtil;

public class TestBuild {

	@Test
	public void test() throws UnsupportedEncodingException, DocumentException,
			ParseException {
		

		
		System.out.println(JSONUtil.xml2object(mockresponseXML()));

	}

	@SuppressWarnings("unchecked")
	public List<Map<String, String>> getCustomInfo(String xml)
			throws UnsupportedEncodingException, DocumentException,
			ParseException {
		String stringBody = "Body";
		List<Map<String, String>> customInfo = new ArrayList<Map<String, String>>();
		Map<String, Object> xml2object = (Map<String, Object>) JSONUtil
				.xml2object(xml);
		if (xml2object.get(stringBody) instanceof java.util.ArrayList) {
			List<Object> Body = (List<Object>) xml2object.get(stringBody);
			for (Object object : Body) {
				List<Object> OrderList = (List<Object>) object;
				for (Object object2 : OrderList) {
					Map<String, String> Order = (Map<String, String>) object2;
					customInfo.add(Order);
				}
			}

		}

		return customInfo;
	}
	@SuppressWarnings("unchecked")
	public Map<String, String> getDataFromOrder(String transNo) {
		Map<String, String> m = new HashMap<String, String>();
		JSONObject transNojson = new JSONObject();
		transNojson.element("orderNo", transNo);
		try {
	
//			HrClientService hrClientService =new HrClientServiceImpl();
//			Object queryOrderDetails = hrClientService 
//					.queryOrderDetails(transNojson.toString());



			Map<String, Object> xml2object = (Map<String, Object>) JSONUtil
					.xml2object(mockOrderList());
			String stringBody = "Body";
			if (xml2object.get(stringBody) instanceof java.util.Map<?, ?>) {
	
				Map<String, Object> Body = (Map<String, Object>) xml2object.get(stringBody);
		
			}
			m.put("PolicyNo", "1111");
//			m.put("ProductName", "国华机动车辆保险");
//			m.put("SignDate", getSignDate(Body));
//			m.put("ValiDate", getSignDate(Body));
//			m.put("Amount", getAmount(Body));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return m;

	}
	/**
	 * 假的返回保单成员xml
	 * 
	 * @return
	 */
	public String mockresponseXML() {
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"GBK\"?>");
		sb.append("<Packet type=\"REQUEST\" version=\"1.0\">");
		sb.append("<Head>");
		sb.append("<ResquestType>WX110</ResquestType>");
		sb.append("<ResponseCode>0000</ResponseCode>");
		sb.append("<ErrorMessage>成功</ErrorMessage>");
		sb.append("</Head>");
		sb.append("<Body>");
		sb.append("<OrderList>");
		sb.append("<Order>");
		sb.append("<CustomerId>101483</CustomerId>");
		sb.append("<TransNo>DT00000170</TransNo>");
		sb.append("</Order>");
		sb.append("<Order>");
		sb.append("<CustomerId>101480</CustomerId>");
		sb.append("<TransNo>DT00000172</TransNo>");
		sb.append("</Order>");
		sb.append("</OrderList>");
		sb.append("</Body>");
		sb.append("</Packet>");
		return sb.toString();
	}

	/**
	 * 假的返回保单成员xml
	 * 
	 * @return
	 */
	public String mockresponseXML1() {
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"GBK\"?>");
		sb.append("<Packet type=\"REQUEST\" version=\"1.0\">");
		sb.append("<Head>");
		sb.append("<ResquestType>WX110</ResquestType>");
		sb.append("<ResponseCode>0000</ResponseCode>");
		sb.append("<ErrorMessage>成功</ErrorMessage>");
		sb.append("</Head>");
		sb.append("<Body>");
		// sb.append("<OrderList>");
		// sb.append("<Order>");
		// sb.append("<CustomerId>101483</CustomerId>");
		// sb.append("<TransNo>DT00000170</TransNo>");
		// sb.append("</Order>");
		// sb.append("<Order>");
		// sb.append("<CustomerId>101483</CustomerId>");
		// sb.append("<TransNo>DT00000172</TransNo>");
		// sb.append("</Order>");
		// sb.append("</OrderList>");
		sb.append("</Body>");
		sb.append("</Packet>");
		return sb.toString();
	}
	public String mockOrderList(){
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"GBK\"?>");
		sb.append("<Packet>");
		sb.append("	<Head>");
		sb.append("		<ResquestType>WX070</ResquestType>");
		sb.append("		<ResponseCode>1</ResponseCode>");
		sb.append("		<ErrorCode>0000</ErrorCode>");
		sb.append("		<ErrorMessage>成功</ErrorMessage>");
		sb.append("	</Head>");
		sb.append("	<Body>");
		sb.append("		<BasePart>");
		sb.append("			<TransNo>DT00000172</TransNo>");
		sb.append("			<CustomerNo>101483</CustomerNo>");
		sb.append("			<Province>8637</Province>");
		sb.append("			<CompanyCode>01</CompanyCode>");
		sb.append("			<CompanyName>天平车险</CompanyName>");
		sb.append("		</BasePart>");
		sb.append("		<Vehicle>");
		sb.append("			<VehicleLicenceCode/>");
		sb.append("			<FirstRegisterDate>20151012</FirstRegisterDate>");
		sb.append("			<VehicleFrameNo>LSVAM4187C2184847</VehicleFrameNo>");
		sb.append("			<EngineNo>LSVAM4187C2184847</EngineNo>");
		sb.append("			<AutoModelCode>DZABCD0035</AutoModelCode>");
		sb.append("			<VehicleBrand>上海大众</VehicleBrand>");
		sb.append("		</Vehicle>");
		sb.append("		<Applicant>");
		sb.append("			<Personnel>");
		sb.append("				<PersonnelName>张三</PersonnelName>");
		sb.append("				<CertificateType>1</CertificateType>");
		sb.append("				<CertificateNo>110101198001010010</CertificateNo>");
		sb.append("				<MobileTelephone>13111111111</MobileTelephone>");
		sb.append("				<DriverLicenseExpirationDate/>");
		sb.append("				<DrivingExpirationDate/>");
		sb.append("				<Gender>M</Gender>");
		sb.append("			</Personnel>");
		sb.append("		</Applicant>");
		sb.append("		<Insured>");
		sb.append("			<Personnel>");
		sb.append("				<PersonnelName>张三</PersonnelName>");
		sb.append("				<CertificateType>1</CertificateType>");
		sb.append("				<CertificateNo>110101198001010010</CertificateNo>");
		sb.append("				<MobileTelephone>13111111111</MobileTelephone>");
		sb.append("				<DriverLicenseExpirationDate/>");
		sb.append("				<DrivingExpirationDate/>");
		sb.append("				<Gender>M</Gender>");
		sb.append("			</Personnel>");
		sb.append("		</Insured>");
		sb.append("		<SendInfo>");
		sb.append("			<Contacts>张三</Contacts>");
		sb.append("			<ContactsMobile>13111111111</ContactsMobile>");
		sb.append("			<SendAddress>中国和</SendAddress>");
		sb.append("		</SendInfo>");
		sb.append("		<BizApplication>");
		sb.append("			<EffectiveDate>20151013</EffectiveDate>");
		sb.append("			<PlanCode>109</PlanCode>");
		sb.append("		</BizApplication>");
		sb.append("		<TPFApplication>");
		sb.append("			<EffectiveDate>20151013</EffectiveDate>");
		sb.append("			<PlanCode>105</PlanCode>");
		sb.append("		</TPFApplication>");
		sb.append("		<CoverageList>");
		sb.append("			<Coverage>");
		sb.append("				<CoverageCode>AOD</CoverageCode>");
		sb.append("				<CoverageName/>");
		sb.append("				<Premium>3228.30</Premium>");
		sb.append("			</Coverage>");
		sb.append("			<Coverage>");
		sb.append("				<CoverageCode>ATP</CoverageCode>");
		sb.append("				<CoverageName/>");
		sb.append("				<Premium>603.50</Premium>");
		sb.append("			</Coverage>");
		sb.append("			<Coverage>");
		sb.append("				<CoverageCode>NGLASS</CoverageCode>");
		sb.append("				<CoverageName/>");
		sb.append("				<Premium>185.40</Premium>");
		sb.append("			</Coverage>");
		sb.append("			<Coverage>");
		sb.append("				<CoverageCode>TPF</CoverageCode>");
		sb.append("				<CoverageName/>");
		sb.append("				<Premium>855.00</Premium>");
		sb.append("			</Coverage>");
		sb.append("		</CoverageList>");
		sb.append("	</Body>");
		sb.append("</Packet>  ");
		return sb.toString();
	}
	
	/**
	 * 把XML数据格式转换为Object对象
	 * 
	 * @param xml
	 * @return
	 * @throws DocumentException,UnsupportedEncodingException 
	 */
	public static Object xml2object(String xml) throws DocumentException, UnsupportedEncodingException{
		Document document = DocumentHelper.parseText(xml);
	    Element root = document.getRootElement();
	    Object obj = parse(root);
		return obj;
	}
	private static Object parse(Element root) {
	    List<?> elements = root.elements();
	    if (elements.size() == 0) {
	        // 没有子元素
	        return root.getTextTrim();
	    } else {
	        // 有子元素
	        String prev = null;
	        boolean guess = false; // 默认按照数组处理
	        Iterator<?> iterator = elements.iterator();
	        while (iterator.hasNext()) {
	            Element elem = (Element) iterator.next();
	            String name = elem.getName();
	            if (prev == null) {
	                prev = name;
	            } else {
	                guess = name.equals(prev);
	                break;
	            }
	        }
	        iterator = elements.iterator();
	        if (guess) {
	            List<Object> data = new ArrayList<Object>();
	            while (iterator.hasNext()) {
	                Element elem = (Element) iterator.next();
	                Map<String, Object> o = new HashMap<String, Object>();
	                o.put(elem.getName(), parse(elem));
	                ((List<Object>) data).add(o);
	            }
	            return data;
	        } else {
	            Map<String, Object> data = new HashMap<String, Object>();
	            while (iterator.hasNext()) {
	                Element elem = (Element) iterator.next();
	                ((Map<String, Object>) data).put(elem.getName(), parse(elem));
	            }
	            return data;
	        }
	    }
	}
}
