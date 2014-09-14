package com.example.myfirstandproj;

import java.io.File;
import java.util.ArrayList;
import java.util.zip.Inflater;

import org.apache.http.protocol.HTTP;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	private static final String APP_LOG_TAG ="DGH";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d(APP_LOG_TAG, "onCreate() was called");
		
		Button button2 = (Button)findViewById(R.id.ListenerButton);
		button2.setOnClickListener(this);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d(APP_LOG_TAG, "onPause() was called");
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d(APP_LOG_TAG, "onStart() was called");
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.d(APP_LOG_TAG, "onStop() was called");
	}
	
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.d(APP_LOG_TAG, "onRestart() was called");
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d(APP_LOG_TAG, "onResume() was called");
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		Log.d("DGH", "onConfigChanged() was called");
		if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
			Log.d(APP_LOG_TAG, "Welcome to the landscape mode");
		}
		
		if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
			Log.d(APP_LOG_TAG, "Welcome to the portrait mode");
		}
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Log.d("DGH", "onClick Listener was called");
		if(v.getId()==R.id.ListenerButton){
			Log.d(APP_LOG_TAG, "Button Listener was clicked and method was invoked via onClick listener");
		}
		
	}
	
	public void doSomething(View v){
		Log.d("DGH", "method doSomething() was called");		
		if(v.getId()==R.id.doSthBtn){
			Log.d(APP_LOG_TAG, "button doSomething was clicked");			
		}
		
	}
	
	public void goToActivityWelcomeScreen(View v) {
		Log.d(APP_LOG_TAG, "button to go to welcome activity was called");	
		Intent i = new Intent(this, WelcomeScreen.class);
		startActivity(i);
		
	}
	
	public void goToJavaActivity(View v){
		
		Log.d(APP_LOG_TAG, "button to go to Java activity was called");	
		Intent i = new Intent(this, JavaActivity.class);
		startActivity(i);
	}
	
	public void launchMap(View v){
		Intent intent = null;
		if(v.getId()==R.id.launchMap){
			intent = new Intent();
			intent.setAction(android.content.Intent.ACTION_VIEW);
			Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
			intent.setData(location);
			this.startActivity(intent);
		}	
		}
	public void viewWebpage(View v){
		Intent intent = null;		
		if(v.getId()==R.id.viewWebpageButton){
			Log.d(APP_LOG_TAG, "view webpage button was called");
			intent = new Intent();
			intent.setAction(android.content.Intent.ACTION_VIEW);
			Uri location = Uri.parse("http://www.android.com");
			intent.setData(location);
			startActivity(intent);
		}
	}
	
	public void sendEmail(View v){
		Intent intent = null;
		if(v.getId()==R.id.sendEmailButton){
			intent = new Intent();
			Log.d(APP_LOG_TAG,"Inside send Email() action");
			intent.setAction(android.content.Intent.ACTION_SEND);
			//Uri uri = Uri.parse(uriString)
			//intent.setData(data);
			String[] toEmail = {"appdgtech@gmail.com", "debashisgho@gmail.com"};
			intent.putExtra(Intent.EXTRA_EMAIL,toEmail);
			intent.putExtra(Intent.EXTRA_SUBJECT, "Email from android app");
			intent.putExtra(Intent.EXTRA_TEXT, "Hello ! how are you doing. This is a test email from the app");
			intent.setType(HTTP.PLAIN_TEXT_TYPE);
			Intent chooser = Intent.createChooser(intent, "Send Email");
			startActivity(chooser);				
			
		}
	}
	
	public void sendImage(View v){
		Intent intent = null;
		if(v.getId()==R.id.sendImage){
			Log.d(APP_LOG_TAG, "sendImage() method started");
			intent = new Intent();
			intent.setAction(android.content.Intent.ACTION_SEND);
			Uri uri = Uri.parse("android.resource://com.example.myfirstandproj/drawable/"+R.drawable.background);
			intent.setType("image/*");
			intent.putExtra(Intent.EXTRA_STREAM, uri);
			intent.putExtra(Intent.EXTRA_TEXT, "Hello ! Here is the image from the android app");
			Intent chooser = Intent.createChooser(intent, "Send Image using");
			startActivity(chooser);	
			
			
		}
	}
	
	public void sendMultipleImages(View v){
		Intent intent = null;
		if(v.getId()==R.id.SendImages){
			Log.d(APP_LOG_TAG, "sendMultipleImages() method started");
			intent = new Intent();
			intent.setAction(android.content.Intent.ACTION_SEND_MULTIPLE);
			
			//File fileDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
			
			// for some reason directory.list() method is not working, so working with the file name itself.
			
			File fileDir = new File(Environment.getExternalStorageDirectory().getPath());
			Log.d(APP_LOG_TAG, "External storage dir is :"+fileDir.toString());
					
			ArrayList<Uri> uris = new ArrayList<Uri>();
			uris.add(Uri.parse("file://"+fileDir.toString()+"/image1.jpg"));
			uris.add(Uri.parse("file://"+fileDir.toString()+"/image2.jpg"));
			
			intent.setType("image/*");
			intent.putExtra(Intent.EXTRA_STREAM, uris);
			intent.putExtra(Intent.EXTRA_TEXT, "Hello ! Here are the images from the android app");
			Intent chooser = Intent.createChooser(intent, "Send Image using");
			startActivity(chooser);	
			
			
		}
	}
	
	public void showToast(View v){
		Toast toast = Toast.makeText(this, "Hello ! How are you ?", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 20,20);
		toast.show();
		
	}
	
	public void showCustomToast(View v){
		Log.d(APP_LOG_TAG, "inside the showCustomToast() method");
		Toast toast = new Toast(this);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.setDuration(Toast.LENGTH_LONG);
		LayoutInflater inflater= this.getLayoutInflater();
		View toastView = inflater.inflate(R.layout.custom_toast, (ViewGroup)findViewById(R.id.custom_toast_root_id));
		toast.setView(toastView);
		toast.show();
	}
	
	public void goToActivityFrameLayout(View v) {
		Log.d(APP_LOG_TAG, "button to go to Frame Layout activity was called");	
		Intent i = new Intent(this, FrameLayoutActivity.class);
		startActivity(i);
		
	}
	
	public void goToActivityCustomFont(View v) {
		Log.d(APP_LOG_TAG, "button to go to Custom Font activity was called");	
		Intent i = new Intent(this, CustomFontActivity.class);
		startActivity(i);
		
	}
	
	public void goToActivityValidation(View v) {
		Log.d(APP_LOG_TAG, "button to go to Validation activity was called");	
		Intent i = new Intent(this, Validation.class);
		startActivity(i);
		
	}
	
	public void goToCheckBoxActivity(View v){
		
		Log.d(APP_LOG_TAG, "button to go to CheckBox activity was called");	
		Intent i = new Intent(this, CheckBoxActivity.class);
		startActivity(i);
	}
	
public void goToToggleBtnActivity(View v){
		
		Log.d(APP_LOG_TAG, "button to go to ToggleBtn activity was called");	
		Intent i = new Intent(this, ToggleBtn.class);
		startActivity(i);
	}
	



}
