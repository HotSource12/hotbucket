package com.hotsource.hotbucket;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;

/**
 * 공지사항을 기재 세번째 탭에 버튼 존재
 * 
 */

public class InforActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.inforpage);

	}

}
