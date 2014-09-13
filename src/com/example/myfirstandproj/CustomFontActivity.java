package com.example.myfirstandproj;

import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;
import android.graphics.Typeface;
import android.os.Bundle;


public class CustomFontActivity extends ActionBarActivity {
	
	TextView customFontTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_custom_font);
		customFontTextView = (TextView) findViewById(R.id.customFontTextView);
		
		Typeface customFont = Typeface.createFromAsset(getAssets(), "font/sampleFont.ttf");
		
		customFontTextView.setTypeface(customFont);
		
	}

	
}
