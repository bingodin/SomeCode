package com.qjjc.test;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
/**
 * 进入程序的闪屏
 * @author wangqiangae
 *
 */
public class SplashActivity extends Activity { 

private Intent intent; 
@Override 
protected void onCreate(Bundle savedInstanceState) { 
super.onCreate(savedInstanceState); 
setContentView(R.layout.splash); 
startMainAvtivity(); 
} 

private void startMainAvtivity() { 
new Handler().postDelayed(new Runnable() { 
public void run() { 
intent=new Intent(SplashActivity.this,LoginActivity.class); 
startActivity(intent); 
SplashActivity.this.finish();//结束本Activity 
} 
}, 1000);//设置执行时间 
} 
}
