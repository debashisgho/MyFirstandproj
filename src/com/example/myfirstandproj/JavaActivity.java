package com.example.myfirstandproj;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class JavaActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    LinearLayout ll = new LinearLayout(this);
	    TextView t = new TextView(this);
	    Button b = new Button(this);
	    
	    LinearLayout.LayoutParams llParms = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
	    LinearLayout.LayoutParams viewParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	    
	    ll.setLayoutParams(llParms);
	    t.setLayoutParams(viewParams);
	    b.setLayoutParams(viewParams);
	    
	    t.setText("welcome to acitivity written by java code");
	    b.setText("doNthg");
	    	    
	    ll.setOrientation(LinearLayout.HORIZONTAL);
	    ll.addView(t);
	    ll.addView(b);
	
		setContentView(ll);
	}
}
