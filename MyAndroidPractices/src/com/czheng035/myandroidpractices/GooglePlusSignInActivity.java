//package com.czheng035.myandroidpractices;
//
//import com.google.android.gms.common.ConnectionResult;
//import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
//import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
//import com.google.android.gms.plus.PlusClient;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.view.View.OnClickListener;
//
//public class GooglePlusSignInActivity extends Activity implements
//		OnClickListener, ConnectionCallbacks, OnConnectionFailedListener {
//	
//	private boolean mSignInClicked;
//	
//	private PlusClient mPlusClient;
//	private ConnectionResult mConnectionResult;
//
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_google_plus_sign_in);
//		findViewById(R.id.sign_in_button).setOnClickListener(this);
//	}
//
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.google_plus_sign_in, menu);
//		return true;
//	}
//
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		// Handle action bar item clicks here. The action bar will
//		// automatically handle clicks on the Home/Up button, so long
//		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
//		return super.onOptionsItemSelected(item);
//	}
//
//	@Override
//	public void onClick(View view) {
//		if (view.getId() == R.id.sign_in_button
//				&& !mGoogleApiClient.isConnecting()) {
//			mSignInClicked = true;
//			resolveSignInError();
//		}
//	}
//
//	@Override
//	public void onConnectionFailed(ConnectionResult arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void onConnected(Bundle arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void onConnectionSuspended(int arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//}
