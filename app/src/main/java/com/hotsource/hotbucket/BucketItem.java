package com.hotsource.hotbucket;

import java.util.ArrayList;
import java.util.Date;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;
import android.widget.RatingBar;

public class BucketItem {
	// 하고싶은일,중요도,완료유무,완료날짜,사진
	public String title;
	private float star;
	private Boolean complete;
	private Date completdate;
	private Uri potouri;
	

	public BucketItem(String title, float star) {
		this.title = title;
		this.star = star;
		
		complete = false;
		completdate = null;
		potouri = null;
	}

	public void setcomplete(int i) { // 완료유무 바꿔주는 매소드
		if (i == 1) {
			this.complete = true;
		} else if (i == 0) {
			this.complete = false;
		}
	}

	public void setcompletedate(Date date) {
		this.completdate = date;
	}

	public void setUri(Uri uri) {
		this.potouri = uri;
	}
	
	public String getTitle(){
		return title;
	}
	
	public float getStar(){
		return star;
	}
	
	
	public Boolean getComplete(){
		return complete;
	}
	
	public Uri getUri(){
		return potouri;
	}
}
