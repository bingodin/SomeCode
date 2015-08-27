package com.companyname.bank;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
   
{
	@Test
    public void testApp()
    {
	System.out.println("hi");

        assertTrue( true );
    }
	@Test
public  void testUtils() throws Exception {
		//198
		long nanoTime = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			String vehicleFrameNo="LV3LD830473894821";
			StringBuffer sb = new StringBuffer(198);
			sb.append("<?xml version=\"1.0\" encoding=\"GBK\"?>");
			sb.append("<Packet type=\"REQUEST\" version=\"1.0\">");
			sb.append("<Head>");
			sb.append("<RequestType>V020</RequestType>");
			sb.append("</Head>");
			sb.append("<Body>");
			sb.append("<VehicleFrameNo>");
			sb.append(vehicleFrameNo);
			sb.append("</VehicleFrameNo>");
			sb.append("</Body>");
			sb.append("</Packet>");
		}
	System.out.println( (System.nanoTime()- nanoTime)/1000);
	System.out.println( "-------------------------------------");
	nanoTime = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			String vehicleFrameNo="LV3LD830473894821";
			StringBuffer sb = new StringBuffer(198);
			sb.append("<?xml version=\"1.0\" encoding=\"GBK\"?>");
			sb.append("<Packet type=\"REQUEST\" version=\"1.0\">");
			sb.append("<Head>");
			sb.append("<RequestType>V020</RequestType>");
			sb.append("</Head>");
			sb.append("<Body>");
			sb.append("<VehicleFrameNo>");
			sb.append(vehicleFrameNo);
			sb.append("</VehicleFrameNo>");
			sb.append("</Body>");
			sb.append("</Packet>");
		}
	System.out.println( (System.nanoTime()- nanoTime)/1000);
	nanoTime = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			String vehicleFrameNo="LV3LD830473894821";
			StringBuilder sb = new StringBuilder();
			sb.append("<?xml version=\"1.0\" encoding=\"GBK\"?>");
			sb.append("<Packet type=\"REQUEST\" version=\"1.0\">");
			sb.append("<Head>");
			sb.append("<RequestType>V020</RequestType>");
			sb.append("</Head>");
			sb.append("<Body>");
			sb.append("<VehicleFrameNo>");
			sb.append(vehicleFrameNo);
			sb.append("</VehicleFrameNo>");
			sb.append("</Body>");
			sb.append("</Packet>");
		}
	System.out.println( (System.nanoTime()- nanoTime)/1000);
}
}
