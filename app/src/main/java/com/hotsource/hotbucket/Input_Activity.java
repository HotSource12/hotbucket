package com.hotsource.hotbucket;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class Input_Activity extends Activity {

	public String todostr;
	public float star;
	public RatingBar rating;
	private Button makelistbtn;
	private Button cancleBtn;
	EditText edit1;
	BucketData bucketdb; // DB 입니당 = 주현

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.input);

		bucketdb = MainActivity.getDB(); // DB 받아왔습니당 = 주현

		edit1 = (EditText) findViewById(R.id.todoEditText); // /// 밑에 todostr에
															// 바로 editbox를 연결하면
															// 안에 내용이 안받아와져서
															// edit1 추가함=주현

		makelistbtn = (Button) findViewById(R.id.inputBtn);
		rating = (RatingBar) findViewById(R.id.ratingBar1); // 별

		rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() { // 사용자가
																						// 별점을
																						// 바꿀때마다
																						// 발생
			public void onRatingChanged(RatingBar ratingBar, float rating,
					boolean fromUser) {
				star = rating; // 바꾼 별을 계속 star에 저장
			}
		});

		makelistbtn.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				todostr = edit1.getText().toString();

				if (todostr.length() == 0) {
					// 공백일 때 처리할 내용
					Toast.makeText(getApplicationContext(), "내용을 입력하세요", 1000)
							.show();
				} else { // 공백이 아닐 때 처리할 내용
					bucketdb.insertMember(todostr, star); // DB 추가 =주현
					Toast.makeText(getApplicationContext(), "추가", 1000).show();

					finish();
				}
			}
		});

		cancleBtn = (Button) findViewById(R.id.cancleBtn);

		cancleBtn.setOnClickListener(new OnClickListener() { // 추가창에서 취소 누를 경우
					public void onClick(View v) {
						Toast.makeText(getApplicationContext(), "취소", 1000)
								.show();

						finish();
					}
				});

	}

}