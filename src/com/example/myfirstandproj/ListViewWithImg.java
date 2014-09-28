package com.example.myfirstandproj;

import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;



public class ListViewWithImg extends ActionBarActivity {
	
	String[] titles;
	String[] descriptions;
	int imageId;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		Log.d("DGH", "listViewWithImg activity onCreate() was called");
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view_with_img);
		
		Resources res = getResources();
		titles = res.getStringArray(R.array.listViewWithImg_weekdays);
		descriptions = res.getStringArray(R.array.listViewWithImg_weekdaysDesc);
		imageId = R.drawable.company_logo;
		
		ListView listView = (ListView) findViewById(R.id.listViewWithImg_ListView);
		
		Log.d("DGH", "listViewWithImg activity setAdapter() is about to be called");
		
		listView.setAdapter(new ListViewWithImgAdapter(this, titles, descriptions, imageId));
		
		Log.d("DGH", "listViewWithImg activity setAdapter() was called");
	}

	class ListViewWithImgAdapter extends ArrayAdapter<String>{
		
		Context context;
		String[] titles;
		String[] desc;
		int imageId;		
		
		
		ListViewWithImgAdapter(Context context, String[] titles, String[] desc, int imageId) {
			super(context, R.layout.listview_with_imgs_sublayout,R.id.listViewWithImag_rowTitle, titles);
			//super(context, R.layout.listview_with_imgs_sublayout);
			this.context = context;
			this.titles = titles;
			this.desc = desc;
			this.imageId = imageId;
			
			Log.d("DGH", "listViewWithImg activity listViewWithImagAdapter constructor finished");
						
		}
		
		class RowViewHolder{
			ImageView rowHolderImg;
			TextView rowHoldertitle;
			TextView rowHolderdesc;
			
			public RowViewHolder(View v) {
				rowHolderImg = (ImageView) v.findViewById(R.id.listViewWithImg_rowImg);
				rowHoldertitle = (TextView) v.findViewById(R.id.listViewWithImag_rowTitle);
				rowHolderdesc = (TextView) v.findViewById(R.id.listViewWithImag_rowDesc);
			}
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			Log.d("DGH", "GETVIEW() method was called for listViewWithImg activity");
			
			View rowView = convertView;
			RowViewHolder rowViewHolder =null;
			
			if(rowView == null){				
				LayoutInflater inflater = getLayoutInflater();
				//LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);			
				rowView = inflater.inflate(R.layout.listview_with_imgs_sublayout, parent,false);
				
				//tag the rowView  - save the holder object  before row is recycled.
				rowViewHolder = new RowViewHolder(rowView);
				rowView.setTag(rowViewHolder);
			}
			else{
				Log.d("DGH", "listViewWithImg - object recycling and views to be retrieved from holder object");
				//get the holder object
				rowViewHolder = (RowViewHolder) rowView.getTag();
			}
		
				
			rowViewHolder.rowHolderImg.setImageResource(imageId);
			rowViewHolder.rowHoldertitle.setText(titles[position]);
			rowViewHolder.rowHolderdesc.setText(desc[position]);
			
			return rowView;
		}
		
		
	}
	
}
