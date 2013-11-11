package com.example.aci810_control3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends Activity {
	
	public final static String HELLO_WORLD = "com.example.aci810-control3.HELLO_WORLD";
	public final static String SWITCH_VALUE = "com.example.aci810-control3.SWITCH_VALUE";
	public final static String RADIO_GROUP = "com.example.aci810-control3.RADIO_GROUP";
	public final static String RADIO_BUT0 = "com.example.aci810-control3.RADIO_BUT0";
	public final static String RADIO_BUT1 = "com.example.aci810-control3.RADIO_BUT1";
	public final static String RADIO_BUT2 = "com.example.aci810-control3.RADIO_BUT2";
	public final static String SEEK_BAR = "com.example.aci810-control3.SEEK_BAR";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onClickSiguiente(View view){
		Intent intent = new Intent(this,PrimeraActivity.class);
		EditText editText = (EditText)findViewById(R.id.editText1);
		String helloWorld = editText.getText().toString();
		Switch swt = (Switch)findViewById(R.id.switch1);
		boolean swtvalue = swt.isChecked();
		
		SharedPreferences sharedPref1 = getSharedPreferences("preferences1",Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPref1.edit();
		
		editor.putString(HELLO_WORLD, helloWorld);
		editor.putBoolean(SWITCH_VALUE, swtvalue);
	
		
		editor.commit();
		startActivity(intent);
	}

	

}
