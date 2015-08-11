package com.qjjc.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
/**
 * 获得汇总数据
 * @author wangqiangae
 *
 */
public class HzData {
	public  List<Map<String, Object>> getData(){
		List<Map<String, Object>> contents = new ArrayList<Map<String, Object>>();

		for (int i = 1; i < 35; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("jinghao", "QYN1_0"+i+"V");
			Random random = new Random();
			Date date = new Date(random.nextInt(2015),random.nextInt(11),random.nextInt(31)); 
			 
			map.put("qidongshijian", new SimpleDateFormat("yy/MM/dd HH:mm").format(date));
			map.put("liuya", random.nextFloat()*150);
			map.put("shuiliang", random.nextFloat()*150);
			map.put("dianliu", random.nextFloat()*150);
			contents.add(map);
		}
		return contents;
	}

}
