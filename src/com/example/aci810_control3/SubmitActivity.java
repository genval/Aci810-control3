package com.example.aci810_control3;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.widget.RadioGroup;
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
		int radioGroup = sharedPref.getInt(MainActivity.RADIO_GROUP,0);
		Boolean radButton0 = sharedPref.getBoolean(MainActivity.RADIO_BUT0, false);
		Boolean radButton1 = sharedPref.getBoolean(MainActivity.RADIO_BUT1, false);
		Boolean radButton2 = sharedPref.getBoolean(MainActivity.RADIO_BUT2, false);
		
		TextView hello = (TextView)findViewById (R.id.textView1);
		hello.setText(helloWorld);
		
		Switch swt = (Switch)findViewById(R.id.switch2);
		swt.setChecked(swtvalue);
		
		RadioGroup rg = (RadioGroup)findViewById(R.id.radioGroup2);
		
		
		
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
}
