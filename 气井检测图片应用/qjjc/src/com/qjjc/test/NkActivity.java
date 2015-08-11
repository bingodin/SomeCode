package com.qjjc.test;


import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class NkActivity extends Activity {
	
	static WebView wv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//鍘绘�?��囬鏍�
		setContentView(R.layout.syss);
		wv = (WebView) findViewById(R.id.wv);
		wv.getSettings().setJavaScriptEnabled(true);
		wv.getSettings().setUseWideViewPort(true);
		wv.getSettings().setSupportZoom(true);
		
		wv.getSettings().setBuiltInZoomControls(true);
		wv.getSettings().setLoadWithOverviewMode(true);
		wv.requestFocus();
		wv.loadUrl("file:///android_asset/nk.html");
		wv.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				view.loadUrl(url);
				return true;
			}

			@Override
			
			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
				// TODO Auto-generated method stub
				Toast.makeText(NkActivity.this, "Oh no! " + description,
						Toast.LENGTH_SHORT).show();
			}
		});

	}
	public void backBtn(View view) {
		this.finish();
	}
	public void updateBtn(View view) {

		// wv.loadUrl("javascript:setContentInfo('"+getRemoteData()+"')");
	}
	@Override
	protected void onResume() {
		super.onDestroy();
		exampleThree();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mThread.close();
	}
	private MyThread mThread;

	private void exampleThree() {
		mThread = new MyThread();

		mThread.start();
	}
	private static class MyThread extends Thread {
		SYRemoteData data = new SYRemoteData();
		boolean isRunning = true;

		@Override
		public void run() {
			while (isRunning) {
				SystemClock.sleep(1000);
				wv.loadUrl("javascript:clock()");
			}
		}

		public void close() {
			isRunning = false;
		}

	}
}
