package com.example.dbexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Diary extends Activity{
	EditText titleET, contentET;
	Button submitBT;
	MyDB dba;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.diary);
		
		dba = new MyDB(this);
		dba.open();
		titleET = (EditText)findViewById(R.id.diarydescriptionText);
		contentET = (EditText)findViewById(R.id.diarycontentText);
		submitBT = (Button)findViewById(R.id.submiButton);
		submitBT.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				try{
					saveItToDB();
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
			
		});
	}

	public void saveItToDB(){
		dba.insertdiary(titleET.getText().toString(), contentET.getText().toString());
		dba.close();
		titleET.setText("");
		contentET.setText("");
		Intent i = new Intent(Diary.this, DisplayDiaries.class);
		startActivity(i);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}

