package com.czheng035.myandroidpractices;

import java.io.IOException;

import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.GooglePlayServicesAvailabilityException;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.android.gms.common.GooglePlayServicesUtil;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

public class GetUsernameTask extends AsyncTask<Void, Void, String> {
	static final int REQUEST_CODE_RECOVER_FROM_PLAY_SERVICES_ERROR = 1001;

	Activity mActivity;
	String mScope;
	String mEmail;

	GetUsernameTask(Activity activity, String name, String scope) {
		this.mActivity = activity;
		this.mScope = scope;
		this.mEmail = name;
	}

	@Override
	protected String doInBackground(Void... params) {
		// TODO Auto-generated method stub
		try {
			String token = fetchToken();
			if (token != null) {
				// Insert the good stuff here.
				// Use the token to access the user's Google data.
				return token;
			}
		} catch (IOException e) {
			// The fetchToken() method handles Google-specific exceptions,
			// so this indicates something went wrong at a higher level.
			// TIP: Check for network connectivity before starting the
			// AsyncTask.

		}
		return null;
	}

	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		Context context = mActivity;
		CharSequence text = result;
		int duration = Toast.LENGTH_SHORT;
		TextView textView = (TextView) mActivity.findViewById(R.id.tx_message);
		textView.setText(result);
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}

	protected String fetchToken() throws IOException {
		try {
//			return GoogleAuthUtil.getToken(mActivity, mEmail, mScope);
			return GoogleAuthUtil.getAccountId(mActivity, mEmail);
		} catch (UserRecoverableAuthException userRecoverableException) {
			// GooglePlayServices.apk is either old, disabled, or not present
			// so we need to show the user some UI in the activity to recover.
			handleException(userRecoverableException);
		} catch (GoogleAuthException fatalException) {
			// Some other type of unrecoverable exception has occurred.
			// Report and log the error as appropriate for your app.
		}
		return null;
	}

	/**
	 * This method is a hook for background threads and async tasks that need to
	 * provide the user a response UI when an exception occurs.
	 */
	public void handleException(final Exception e) {
		// Because this call comes from the AsyncTask, we must ensure that the
		// following
		// code instead executes on the UI thread.
		mActivity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				if (e instanceof GooglePlayServicesAvailabilityException) {
					// The Google Play services APK is old, disabled, or not
					// present.
					// Show a dialog created by Google Play services that allows
					// the user to update the APK
					int statusCode = ((GooglePlayServicesAvailabilityException) e)
							.getConnectionStatusCode();
					Dialog dialog = GooglePlayServicesUtil.getErrorDialog(
							statusCode, mActivity,
							REQUEST_CODE_RECOVER_FROM_PLAY_SERVICES_ERROR);
					dialog.show();
				} else if (e instanceof UserRecoverableAuthException) {
					// Unable to authenticate, such as when the user has not yet
					// granted
					// the app access to the account, but the user can fix this.
					// Forward the user to an activity in Google Play services.
					Intent intent = ((UserRecoverableAuthException) e)
							.getIntent();
					mActivity.startActivityForResult(intent,
							REQUEST_CODE_RECOVER_FROM_PLAY_SERVICES_ERROR);
				}
			}
		});
	}
}
