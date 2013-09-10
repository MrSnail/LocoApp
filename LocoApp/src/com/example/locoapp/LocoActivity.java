package com.example.locoapp;

import java.util.ArrayList;

import com.example.locoapp.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class LocoActivity extends Activity 
{
    ListView list;
    CustomAdapter adapter;
    public LocoActivity CustomListView = null;
    public ArrayList<ListModel> CustomListViewValuesArr = new ArrayList<ListModel>();
    
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_loco);
        
        CustomListView = this;
        setListData();
        Resources res = getResources();
        list = (ListView) findViewById( R.id.fullscreen_content );  // List defined in XML ( See Below )
         
        /**************** Create Custom Adapter *********/
        adapter = new CustomAdapter( CustomListView, CustomListViewValuesArr,res );
        list.setAdapter( adapter );

		final View contentView = findViewById(R.id.fullscreen_content);
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
