package com.example.dbexample;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	SharedPreferences myprefs;
	EditText userET, passwordET;
	Button loginBT;
	
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		myprefs = PreferenceManager.getDefaultSharedPreferences(this);
		final String username = myprefs.getString("username", null);
		final String password = myprefs.getString("password", null);
		
		if(username != null && password != null){
			setContentView(R.layout.activity_main);
			userET = (EditText)findViewById(R.id.usrText);
			passwordET = (EditText)findViewById(R.id.passwordText);
			loginBT = (Button)findViewById(R.id.loginButton);
			loginBT.setOnClickListener(new OnClickListener(){
				public void onClick(View v){
					try{
						if(username.equals(userET.getText().toString())
							&& password.equals(passwordET.getText().toString())){
							Toast.makeText(MainActivity.this, "login please!", Toast.LENGTH_SHORT).show();
							
							Intent i = new Intent(MainActivity.this, MyPreferences.class);
							startActivity(i);
						}else{
							Toast.makeText(MainActivity.this, "login, failed!", Toast.LENGTH_SHORT).show();
						}
					}catch (Exception e){
						e.printStackTrace();
					}
				}
			});
		}else{
			Intent i = new Intent(this, Diary.class);
			startActivity(i);
		}

	}


}

