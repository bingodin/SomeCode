package com.qjjc.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class HzGridActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hz);
		ListView listView = (ListView) findViewById(R.id.list);


		SimpleAdapter adapter = new MySimpleAdapter(this,
				(List<Map<String, Object>>) new HzData().getData(), R.layout.listviewlayout,
				new String[] { "jinghao", "qidongshijian", "liuya","shuiliang","dianliu" }, 
				new int[] {
						R.id.jinghao, R.id.qidongshijian,R.id.liuya,
						R.id.shuiliang,R.id.dianliu 
						}
		);

		listView.setAdapter(adapter);
	}
}