package com.hotsource.hotbucket;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;

/**
 * 사용자 가이드 기재하는 페이지
 * 버튼은 세번째 탭에 존재
 * 
 */

public class GuiActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.guipage);
				
	}



}
