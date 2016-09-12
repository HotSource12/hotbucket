package com.hotsource.hotbucket;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;

/**
 * 개발자 정보 기재
 * 세번째 탭에 존재
 * 
 */

public class DevActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.devpage);
				
	}



}
