package com.example.myfirstandproj;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d("DGH", "onCreate() was called");
		
		Button button2 = (Button)findViewById(R.id.button2);
		button2.setOnClickListener(this);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d("DGH", "onPause() was called");
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d("DGH", "onStart() was called");
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.d("DGH", "onStop() was called");
	}
	
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.d("DGH", "onRestart() was called");
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d("DGH", "onResume() was called");
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		Log.d("DGH", "onConfigChanged() was called");
		if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
			Log.d("DGH", "Welcome to the landscape mode");
		}
		
		if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
			Log.d("DGH", "Welcome to the portrait mode");
		}
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Log.d("DGH", "onClick Listener was called");
		if(v.getId()==R.id.button2){
			Log.d("DGH", "Button Listener was clicked and method was invoked via onClick listener");
		}
		
	}
	
	public void doSomething(View v){
		Log.d("DGH", "method doSomething() was called");		
		if(v.getId()==R.id.button1){
			Log.d("DGH", "button doSomething was clicked");			
		}
		
	}
	
	public void goToActivityB(View v) {
		Log.d("DGH", "button goToActivityB was called");	
		Intent i = new Intent(this, ActivityB.class);
		startActivity(i);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


}
