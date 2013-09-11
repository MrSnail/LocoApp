package com.example.locoapp;

import java.util.ArrayList;

import com.example.locoapp.util.SystemUiHider;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.view.MenuItem;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class LocoActivity extends Activity 
{
	Button popup_but;
	ListView list;
	CustomAdapter adapter;
	public LocoActivity CustomListView = null;
	public ArrayList<ListModel> CustomListViewValuesArr = new ArrayList<ListModel>();

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);

		setContentView(R.layout.loco_control);
		CustomListView = this;
		setListData();
		Resources res = getResources();
		list = (ListView) findViewById( R.id.fullscreen_content );  // List defined in XML ( See Below )

		/**************** Create Custom Adapter *********/
		adapter = new CustomAdapter( CustomListView, CustomListViewValuesArr,res );
		list.setAdapter( adapter );

		final View contentView = findViewById(R.id.fullscreen_content);
		popup_but = (Button) findViewById(R.id.menu_button);
		final PopupMenu popup_cont = new PopupMenu(this, popup_but);
		popup_cont.getMenuInflater().inflate(R.menu.menu, popup_cont.getMenu());
		popup_but.setOnClickListener(new View.OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				popup_cont.show();
			}
		});

		popup_cont.setOnMenuItemClickListener(
				new PopupMenu.OnMenuItemClickListener() {
					@Override
					public boolean onMenuItemClick(MenuItem item) {
						switch (item.getItemId()) {
						case R.id.control:
							setContentView(R.layout.loco_control);
							break;
						case R.id.gait:
							popup_but = (Button) findViewById(R.id.menu_button);
							setContentView(R.layout.loco_gait);
							break;
						case R.id.logs:
							setContentView(R.layout.loco_logs);
							break;
						case R.id.profile:
							setContentView(R.layout.loco_profile);
							break;
						case R.id.options:
							setContentView(R.layout.loco_options);
							break;
						}
						return true;
					}
				});

	}



	/****** Function to set data in ArrayList *************/
	public void setListData()
	{
		for (int i = 0; i < 15; i++) 
		{
			final ListModel sched = new ListModel();    

			/******** Take Model Object in ArrayList **********/
			CustomListViewValuesArr.add( sched );
		}
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) 
	{
		super.onPostCreate(savedInstanceState);

		// Trigger the initial hide() shortly after the activity has been
		// created, to briefly hint to the user that UI controls
		// are available.
	}
}
