package com.qjjc.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MianActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//鍘绘�?��囬鏍�
        setContentView(R.layout.main);
    }
    public void btnclick(View view){
    	Button btn = (Button)view;
    	Intent in;
    	switch (btn.getId()) {
		case R.id.a1:
			in = new Intent(this,HzGridActivity.class);
	    	startActivity(in);
			break;
		case R.id.a2:
			in = new Intent(this,SySsActivity.class);
	    	startActivity(in);
			break;
		case R.id.a3:
			in = new Intent(this,NkActivity.class);
	    	startActivity(in);
			break;
		default:
			break;
		}
    	
    }
}