package com.example.myfirstandproj;

import android.support.v7.app.ActionBarActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;


public class Adapter extends ActionBarActivity implements OnItemClickListener   {
	
	ListView weekdaysListView;
	
	//define data source
	String[] weekdays = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adapter);
		
		//connect the listView object with the xml
		weekdaysListView = (ListView) findViewById(R.id.weekdaysListView);
		
		//create the adapter to read data from dat source		
		//use the layout 
		ArrayAdapter<String> arrayWeekAdp = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, weekdays); 
		
		//assign the listView to the adapter
		weekdaysListView.setAdapter(arrayWeekAdp);
		
		weekdaysListView.setOnItemClickListener(this);
		
		
	}

	@Override
	public void onItemClick(AdapterView<?> adpView, View rowView, int index, long id) {
		//as per layout the view is the textView, adpView is the listView
		
		TextView tempTextView = (TextView) rowView;
		Toast.makeText(this, "you clicked on "+tempTextView.getText()+" index ="+index, Toast.LENGTH_LONG).show();
		
		
		
	}

}
