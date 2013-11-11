package com.example.aci810_control3;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;


public class SubmitActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_submit);
		
		SharedPreferences sharedPref = getSharedPreferences("preferences",Context.MODE_PRIVATE);
		
		String helloWorld = sharedPref.getString(MainActivity.HELLO_WORLD, "not set");
		Boolean swtvalue = sharedPref.getBoolean(MainActivity.SWITCH_VALUE, false);
		Boolean radButton0 = sharedPref.getBoolean(MainActivity.RADIO_BUT0, false);
		Boolean radButton1 = sharedPref.getBoolean(MainActivity.RADIO_BUT1, false);
		Boolean radButton2 = sharedPref.getBoolean(MainActivity.RADIO_BUT2, false);
		int sbar = sharedPref.getInt(MainActivity.SEEK_BAR,0);  
		
		TextView hello = (TextView)findViewById (R.id.textView1);
		hello.setText(helloWorld);		
		Switch swt = (Switch)findViewById(R.id.switch2);
		swt.setChecked(swtvalue);		
		RadioButton rbut0 = (RadioButton)findViewById(R.id.radio01);
		rbut0.setChecked(radButton0);
		RadioButton rbut1 = (RadioButton)findViewById(R.id.radio12);
		rbut1.setChecked(radButton1);
		RadioButton rbut2 = (RadioButton)findViewById(R.id.radio23);
		rbut2.setChecked(radButton2);
		SeekBar sb = (SeekBar)findViewById(R.id.seekBar2);
		sb.setProgress(sbar);
				
		setupActionBar();		
		
	}

	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
