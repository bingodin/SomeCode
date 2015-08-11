package com.qjjc.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
/**
 * 登录界面
 * @author wangqiangae
 *
 */
public class LoginActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);// 鍘绘�?��囬鏍�
		setContentView(R.layout.login);
	}

	public void loginBtnclick(View view) {

		Intent in = new Intent(this, MianActivity.class);
		startActivity(in);

	}
}