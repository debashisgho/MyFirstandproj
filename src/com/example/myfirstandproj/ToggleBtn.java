package com.example.myfirstandproj;

import android.support.v7.app.ActionBarActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ToggleButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class ToggleBtn extends ActionBarActivity implements OnCheckedChangeListener {
	
	ToggleButton toggleBtn;
	LinearLayout linearLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_toggle_btn);
		
		toggleBtn = (ToggleButton) findViewById(R.id.toggleBackGroundBtn);
		linearLayout = (LinearLayout) findViewById(R.id.LinearLayoutToggleBtn);
		
		toggleBtn.setOnCheckedChangeListener(this);
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if(isChecked){
			linearLayout.setBackgroundColor(Color.BLACK);
		}
		
		else {
			linearLayout.setBackgroundColor(Color.WHITE);
		}
	}

	
	
}
