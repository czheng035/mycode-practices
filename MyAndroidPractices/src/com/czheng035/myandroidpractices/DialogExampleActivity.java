package com.czheng035.myandroidpractices;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;

public class DialogExampleActivity extends Activity {
	ProgressDialog mProgressDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dialog_example);
		
		mProgressDialog = new ProgressDialog(this);
		mProgressDialog.setTitle("Downloading Image ...");
		mProgressDialog.setMessage("Download in progress ...");
		
		mProgressDialog.show();
	}
}
