package com.example.myfirstandproj;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.Toast;

public class CheckBoxActivity extends ActionBarActivity implements OnClickListener {

	CheckBox earlyMorningChkBox, lateMorningChkBox;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_check_box);
		
		earlyMorningChkBox = (CheckBox) findViewById(R.id.earlyMorningChkBox);
		lateMorningChkBox = (CheckBox) findViewById(R.id.lateMorningChkBox);
		earlyMorningChkBox.setOnClickListener(this);
		lateMorningChkBox.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		CheckBox chkbox = (CheckBox) v;
		if(chkbox.getId()==R.id.earlyMorningChkBox){
		    if(chkbox.isChecked()){
		    	lateMorningChkBox.setChecked(false);
		    	Toast.makeText(this, "waking up early is Good habit", Toast.LENGTH_SHORT).show();
		    	
		    }
		}
		
		if(chkbox.getId()==R.id.lateMorningChkBox){
		    if(chkbox.isChecked()){
		    	earlyMorningChkBox.setChecked(false);
		    	Toast.makeText(this, "Try to Wake up early", Toast.LENGTH_SHORT).show();
		    	
		    }
		}
		
	}

}
