package com.example.myfirstandproj;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class FrameLayoutActivity extends ActionBarActivity implements OnClickListener{
	
	ImageView appleImgView, googleImgView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_frame_layout);
		appleImgView = (ImageView) findViewById(R.id.appleImgView);
		googleImgView = (ImageView) findViewById(R.id.googleImgView);
		
		appleImgView.setOnClickListener(this);
		googleImgView.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.appleImgView){
			appleImgView.setVisibility(View.GONE);
			googleImgView.setVisibility(View.VISIBLE);
		}
		
		if(v.getId() == R.id.googleImgView){
			googleImgView.setVisibility(View.GONE);
			appleImgView.setVisibility(View.VISIBLE);			
		}
	}
	
	

}
