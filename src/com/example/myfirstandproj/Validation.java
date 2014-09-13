package com.example.myfirstandproj;

import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class Validation extends ActionBarActivity implements TextWatcher{
	
	EditText percentageEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_validation);
		
		percentageEditText = (EditText) findViewById(R.id.percentageEditText);
		
		//add text change listener for the percentage editTxt
		percentageEditText.addTextChangedListener(this);
	}

	@Override
	public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub
		Toast toast = Toast.makeText(this,"afterTextChanged() method was called", Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 20,20);
		toast.show();		
		
		if(s.toString().length()>0){
			if(Integer.parseInt(s.toString())>100){
				s.replace(0, 3, "100");
			}
		}
		
	
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO Auto-generated method stub
		
	}

	
}
