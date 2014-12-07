package com.czheng035.myandroidpractices;

import com.google.android.gms.common.AccountPicker;

import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class GoogleAuthUtilSampleActivity extends Activity {
	private static final int REQUEST_CODE_PICK_ACCOUNT = 1000;
	private static final String SCOPE =
	        "oauth2:https://www.googleapis.com/auth/userinfo.profile";
	
	private String mEmail;

	private void pickUserAccount() {
	    String[] accountTypes = new String[]{"com.google"};
	    Intent intent = AccountPicker.newChooseAccountIntent(null, null,
	            accountTypes, false, null, null, null, null);
	    startActivityForResult(intent, REQUEST_CODE_PICK_ACCOUNT);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_google_auth_util_sample);
		pickUserAccount();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.google_auth_util_sample, menu);
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
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (requestCode == REQUEST_CODE_PICK_ACCOUNT) {
	        // Receiving a result from the AccountPicker
	        if (resultCode == RESULT_OK) {
	            mEmail = data.getStringExtra(AccountManager.KEY_ACCOUNT_NAME);
	            // With the account name acquired, go get the auth token
	            getUsername();
	            TextView textView = (TextView) findViewById(R.id.tx_message);
	            textView.setText(mEmail);
	        } else if (resultCode == RESULT_CANCELED) {
	            // The account picker dialog closed without selecting an account.
	            // Notify users that they must pick an account to proceed.
//	            Toast.makeText(this, R.string.pick_account, Toast.LENGTH_SHORT).show();
	        } else if ((requestCode == GetUsernameTask.REQUEST_CODE_RECOVER_FROM_PLAY_SERVICES_ERROR)
	                && resultCode == RESULT_OK) {
	            // Receiving a result that follows a GoogleAuthException, try auth again
	            getUsername();
	        }
	    }
	    // Later, more code will go here to handle the result from some exceptions...
	}
	
	private void getUsername() {
//	    if (mEmail == null) {
//	        pickUserAccount();
//	    } else {
//	        if (isDeviceOnline()) {
	            new GetUsernameTask(this, mEmail, SCOPE).execute();
//	        } else {
//	            Toast.makeText(this, R.string.not_online, Toast.LENGTH_LONG).show();
//	        }
//	    }
	}
}
