package com.qjjc.test;

import java.util.Random;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * 水压数据
 * @author wangqiangae
 *
 */
public class SYRemoteData {
	public int length=60;
	public JSONArray data;
	public Random random;

	public SYRemoteData() {
		data = new JSONArray();
		random = new Random();
		for (int i = 0; i < length; i++) {
			data.put(random.nextInt(40));
		}
	}
	//虚拟机横批 ctrl+F11
	public String getRemoteData() {
		try {
			JSONObject object1 = new JSONObject();
			object1.put("name", "油井");
			object1.put("color", "#1f7e92");
			//只更新最后一项
			for (int i = 0; i < length-1; i++) {
				data.put(i, data.getInt(i+1));
			}
			//产生冗余
			int r=0;
			if(data.getInt(length-1)>0&&data.getInt(length-1)<40){
				 r=data.getInt(length-1)+random.nextInt(14)*(random.nextInt(3)>1?+1:-1);
			}
			else{
				r=random.nextInt(40);
			}
			data.put(length-1, r);
			
			
			object1.put("value", data);
			JSONArray jsonArray = new JSONArray();
			jsonArray.put(object1);
			return jsonArray.toString();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
}