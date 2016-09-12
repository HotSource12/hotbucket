package com.hotsource.hotbucket;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * 탭 두번재 페이지 앨범 페이지
 * 
 */

public class SubPageTwoActivity extends Activity implements
		OnItemClickListener, OnItemLongClickListener {

	GridView gridview;
	BucketData bucketdb;
	ImageView imageview;

	int number = 100;// 디비에uri몇갠지셀꺼
	Uri[] mPotoItems = new Uri[number];

	Uri[] mpoto = new Uri[number];
	String[] bktodo = new String[number];
	Integer[] star = new Integer[number];
	String[] finpic = new String[number];
	String[] findate = new String[number];
	String[] memo = new String[number];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.subpagetwo);
		// 화면크기얻기
		Display display = ((WindowManager) getSystemService(WINDOW_SERVICE))
				.getDefaultDisplay();
		int displayWidth = display.getWidth();
		int displayHeight = display.getHeight();

		gridview = (GridView) findViewById(R.id.imgGridView);
		gridview.setAdapter(new gridAdapter(this, displayWidth));
		gridview.setOnItemClickListener(this);
		gridview.setOnItemLongClickListener(this);
		bucketdb = MainActivity.getDB();

	}

	public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		final String string = (String) arg0.getItemAtPosition(arg2).toString();

		AlertDialog diaBox = new AlertDialog.Builder(SubPageTwoActivity.this)
				.setTitle("삭제").setMessage("삭제하겠습니까?")
				.setIcon(R.drawable.ic_launcher)
				.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						Toast.makeText(getApplicationContext(),
								string + "를 삭제합니다.", 1000).show();
						bucketdb.deleteMember(string);

					}
				}).setNegativeButton("취소", null).create();
		diaBox.show();

		return false;
	}

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// >>블로그형식으로 넘어가야되.
		searchlist();
		Intent i = new Intent(SubPageTwoActivity.this, ClearBlogActivity.class);
		i.putExtra("pic", finpic[arg2]);
		i.putExtra("todo", bktodo[arg2]);
		i.putExtra("star", star[arg2]);
		i.putExtra("memo", memo[arg2]);
		i.putExtra("date", findate[arg2]);
		startActivity(i);
	}

	/**
	 * 
	 * 어뎁터
	 * 
	 */

	public class gridAdapter extends BaseAdapter {

		private Context mcontext;
		private int displayWidth;
		int size;

		public gridAdapter(Context mcontext, int displayWidth) {
			this.mcontext = mcontext;
			this.displayWidth = displayWidth;
			size = displayWidth / 3;

		}

		public int getCount() {
			// TODO 자동 생성된 메소드 스텁
			return mPotoItems.length;// 디비에 완료 리스트 가 몇개인지 를 반환

		}

		public Object getItem(int arg0) {
			// TODO 자동 생성된 메소드 스텁
			return arg0;
		}

		public long getItemId(int position) {
			// TODO 자동 생성된 메소드 스텁
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {

			if (convertView == null) {
				imageview = new ImageView(mcontext);

				imageview
						.setLayoutParams(new GridView.LayoutParams(size, size));
				imageview.setScaleType(ImageView.ScaleType.CENTER_CROP);
				imageview.setPadding(4, 4, 4, 4);

			} else {
				imageview = (ImageView) convertView;
				searchpicuri();// 디비서가져오쟈
			}
			imageview.setImageURI(mPotoItems[position]);

			return imageview;
		}
	}

	// 디비에서 가저오기
	public void searchpicuri() {
		int i = 0;
		Cursor _cursor = bucketdb.rawQuery(
				"select pic from bucketlist where fin = '1'", null);
		_cursor.moveToFirst();
		while (_cursor.isAfterLast() == false) {
			String stringuri = _cursor.getString(0);
			mPotoItems[i++] = Uri.parse(stringuri);
			_cursor.moveToNext();
		}
		_cursor.close();
	}

	public void searchlist() {
		int i = 0;
		Cursor _cursor = bucketdb.rawQuery(
				"select * from bucketlist where fin = '1'", null);
		_cursor.moveToFirst();
		while (_cursor.isAfterLast() == false) {
			bktodo[i] = _cursor.getString(0);
			findate[i] = _cursor.getString(1);
			finpic[i] = _cursor.getString(2);
			star[i] = _cursor.getInt(3);
			memo[i++] = _cursor.getString(4);
			_cursor.moveToNext();
		}
		_cursor.close();
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_BACK:
			String alertTitle = "종료";
			new AlertDialog.Builder(SubPageTwoActivity.this)
					.setTitle(alertTitle)
					.setMessage("종료 하시겠습니까?")
					.setIcon(R.drawable.ic_launcher)
					.setPositiveButton("예",
							new DialogInterface.OnClickListener() {

								public void onClick(DialogInterface dialog,
										int which) {
									// TODO Auto-generated method stub
									moveTaskToBack(true);
									finish();
									ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
									am.restartPackage(getPackageName());
								}
							}).setNegativeButton("아니요", null).show();
		}
		return true;
	}
}
