package com.czheng035.myandroidpractices;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		findViewById(R.id.btn_dialog).setOnClickListener(this);
		findViewById(R.id.btn_barcode).setOnClickListener(this);
		findViewById(R.id.btn_googleplus_signin).setOnClickListener(this);
		findViewById(R.id.btn_google_auth_util).setOnClickListener(this);

		// Intent intent = new Intent(getApplicationContext(),
		// DialogTestActivity.class);
		// startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View view) {
		Intent intent = null;
		Context context = getApplicationContext();
		switch (view.getId()) {
		case R.id.btn_dialog:
			intent = new Intent(context,
					DialogExampleActivity.class);
			break;
		case R.id.btn_barcode:
			intent = new Intent(context,
					BarcodeExampleActivity.class);
			break;
		case R.id.btn_googleplus_signin:
			intent = new Intent(getApplicationContext(),
					GooglePlusSignInActivity.class);
			break;
		case R.id.btn_google_auth_util:
			intent = new Intent(context, GoogleAuthUtilSampleActivity.class);
			break;
		}
		if (intent != null)
			startActivity(intent);
	}
}
