package com.snr9;

import java.lang.reflect.Method;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class InitialActivity extends Activity {

	

	/** Called when the activity is first created. */
	private BluetoothSocket socket;
	BluetoothDevice device;

	BluetoothAdapter mBluetoothAdapter;
	@Override
    public void  onBackPressed () {
		MyApplication appSocket = ((MyApplication)getApplicationContext());
    	socket =  appSocket.getSocket();
    	
    	try {
			socket.getOutputStream().write("exitapp".getBytes());
			
		
			
		} catch (Exception e) {
			Context context = getApplicationContext();
			CharSequence text = "Failed to write exit msg!";
			int duration = Toast.LENGTH_SHORT;

			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
		}
		
		
		
			finish();
    	
    	
    }
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		final MyApplication appSocket = ((MyApplication)getApplicationContext());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.initial);
		
	
		  

	      

		Button initial = (Button) findViewById(R.id.button1);
		OnClickListener initialListener = new OnClickListener() {
			public void onClick(View v) {
				Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); vib.vibrate(50);


				 
		    	mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

				if (!mBluetoothAdapter.isEnabled()) {
					Intent enableBtIntent = new Intent(
							BluetoothAdapter.ACTION_REQUEST_ENABLE);
					startActivityForResult(enableBtIntent, 1);
				}

				mBluetoothAdapter.startDiscovery();
				// Create a BroadcastReceiver for ACTION_FOUND
				final BroadcastReceiver mReceiver = new BroadcastReceiver() {
					public void onReceive(Context context, Intent intent) {
						String action = intent.getAction();
						// When discovery finds a device
						if (BluetoothDevice.ACTION_FOUND.equals(action)) {
							// Get the BluetoothDevice object from the Intent
							device = intent
									.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

							

						}
					}
				};
				// Register the BroadcastReceiver
				IntentFilter filter = new IntentFilter(
						BluetoothDevice.ACTION_FOUND);
				registerReceiver(mReceiver, filter);
				
				ToggleButton notif = (ToggleButton) findViewById(R.id.toggleButton1);
				notif.setTextOn("Proceed to connect..");
				notif.setChecked(true);
				
			}
		};

		initial.setOnClickListener(initialListener);
		
		
	

		Button connect = (Button) findViewById(R.id.button2);
		OnClickListener connectListener = new OnClickListener() {
			public void onClick(View v) {
				
				Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); vib.vibrate(50);




		    	try {
		    		mBluetoothAdapter.cancelDiscovery();
					
					BluetoothDevice device2 = mBluetoothAdapter
							.getRemoteDevice("00:15:83:07:CA:F8");//("00:21:86:3B:90:47");
					

					Method m;
					try {
						m = device2.getClass().getMethod("createRfcommSocket",
								new Class[] { int.class });
						socket = (BluetoothSocket) m.invoke(device2, 1);
						 appSocket.setSocket(socket);
					} catch (Exception e) {
						Context context = getApplicationContext();
						CharSequence text = "Failed to create socket!";
						int duration = Toast.LENGTH_SHORT;

						Toast toast = Toast.makeText(context, text, duration);
						toast.show();
					}

					
					socket.connect();


					ToggleButton connotif = (ToggleButton) findViewById(R.id.toggleButton2);
					connotif.setTextOn("Connected");
					connotif.setChecked(true);
					
					
					Context context = getApplicationContext();
					CharSequence text = "Connected to socket!";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();
				
					

					
				} catch (Exception e) {
					Context context = getApplicationContext();
					CharSequence text = "Failed to connect to socket!";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();
				}

				
			}
		};

		connect.setOnClickListener(connectListener);
		
		
		Button proceed = (Button) findViewById(R.id.button3);
		OnClickListener proceedListener = new OnClickListener() {
			public void onClick(View v) {
				 Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); vib.vibrate(50);

					Intent keyScreen = new Intent(getApplicationContext(),
							BTpackActivity.class);
					startActivity(keyScreen);
				
				
			}
		};

		proceed.setOnClickListener(proceedListener);
			
		

	}
}