package com.hotsource.hotbucket;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class ClearBlogActivity extends Activity{
	String blogtodo;
	String blogdate;
	Uri blogpic;
	String blogstrpic;
	int blogstar;
	String blogmemo;
	private Button resetbtn;
	private Button okbtn;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.clearblog);
		//화면크기얻기
				Display display = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
		        int displayWidth = display.getWidth();
		        int displayHeight = display.getHeight();
		
		
		
		Intent i = getIntent(); // 값을 받아온다.
		blogtodo = i.getStringExtra("todo");
		blogdate = i.getStringExtra("date");
		blogstrpic = i.getStringExtra("pic");
		blogstar = i.getIntExtra("star", 1);
		blogmemo = i.getStringExtra("memo");
		 blogpic = Uri.parse(blogstrpic);
		
		 ImageView CBlogImg = (ImageView) findViewById(R.id.CBlogImg);
		 CBlogImg.setImageURI(blogpic);
		 LayoutParams params = (LayoutParams) CBlogImg.getLayoutParams();
		 params.height = displayWidth/5*3;
		 params.width =  displayWidth/5*3;
		 CBlogImg.setLayoutParams(params);
		
		 
		TextView CBlogtv = (TextView) findViewById(R.id.Blogtodo);
		CBlogtv.setText(blogtodo);
		TextView CBlogdate = (TextView) findViewById(R.id.CBlogDatatext);
		CBlogdate.setText(blogdate);
		RatingBar CBlogstar = (RatingBar) findViewById(R.id.ratingBar1);
		CBlogstar.setRating(blogstar);
		TextView CBlogmemo = (TextView) findViewById(R.id.CBlogMemotext);
		CBlogmemo.setText(blogmemo);
		
		
		 resetbtn = (Button) findViewById(R.id.resetbtn);
		 okbtn = (Button) findViewById(R.id.okbtn);
		 
		 resetbtn.setOnClickListener(new OnClickListener() { // 추가창에서 취소 누를 경우
					public void onClick(View v) {
						Toast.makeText(getApplicationContext(), "취소",
								1000).show();
				
						finish();
					}
				});
		 
		 okbtn.setOnClickListener(new OnClickListener() { // 추가창에서 공유 누를 경우
				public void onClick(View v) {
					Toast.makeText(getApplicationContext(), "공유가 완료되었습니다.",
							1000).show();

					SubPageThreeActivity.feed(blogtodo);
				}
			});
		 
		 
		 
	}
}