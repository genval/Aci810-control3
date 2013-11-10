package com.example.aci810_control3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
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
	
	public void onClickSubmit(View view){
		Intent intent = new Intent(this,SubmitActivity.class);
		
		EditText editText = (EditText)findViewById(R.id.editText1);
		String helloWorld = editText.getText().toString();
		Switch swt = (Switch)findViewById(R.id.switch1);
		boolean swtvalue = swt.isChecked();
		RadioGroup rg= (RadioGroup)findViewById(R.id.radioGroup1);
		int r0 =  rg.getCheckedRadioButtonId();
		RadioButton rb0 = (RadioButton)findViewById(R.id.radio0);
		boolean rbut0 = rb0.isChecked();
		RadioButton rb1 = (RadioButton)findViewById(R.id.radio1);
		boolean rbut1 = rb1.isChecked();
		RadioButton rb2 = (RadioButton)findViewById(R.id.radio2);
		boolean rbut2 = rb2.isChecked();
		SeekBar sb = (SeekBar)findViewById(R.id.seekBar1);
		int seekB = sb.getProgress();
		
		SharedPreferences sharedPref = getSharedPreferences("preferences",Context.MODE_PRIVATE);
		
		SharedPreferences.Editor editor = sharedPref.edit();
		
		editor.putString(HELLO_WORLD, helloWorld);
		editor.putBoolean(SWITCH_VALUE, swtvalue);
		editor.putInt(RADIO_GROUP, r0);
		editor.putBoolean(RADIO_BUT0, rbut0);
		editor.putBoolean(RADIO_BUT1, rbut1);
		editor.putBoolean(RADIO_BUT2, rbut2);
		editor.putInt(SEEK_BAR, seekB);
		
		editor.commit();
		startActivity(intent);
	}

}
