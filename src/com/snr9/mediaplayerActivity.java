package com.snr9;



import java.io.IOException;
import com.snr9.MyApplication;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class mediaplayerActivity extends Activity {
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
    	MyApplication appSocket = ((MyApplication)getApplicationContext());
    	socket =  appSocket.getSocket();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mediaplayer);
        
/*
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

					EditText name = (EditText) findViewById(R.id.editText1);
					name.setText(name.getText() + device.getName()
							+ "\n");

				}
			}
		};
		// Register the BroadcastReceiver
		IntentFilter filter = new IntentFilter(
				BluetoothDevice.ACTION_FOUND);
		registerReceiver(mReceiver, filter);
		
		


        Button connect = (Button)findViewById(R.id.button3);
        OnClickListener connectListener = new OnClickListener() {
        public void onClick(View v) { Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); vib.vibrate(50);
        	
        	
        	try {
        		mBluetoothAdapter.cancelDiscovery();
				
				BluetoothDevice device2 = mBluetoothAdapter
						.getRemoteDevice("00:15:83:07:CA:F8");
				

				Method m;
				try {
					m = device2.getClass().getMethod("createRfcommSocket",
							new Class[] { int.class });
					socket = (BluetoothSocket) m.invoke(device2, 1);
				} catch (Exception e) {
					Context context = getApplicationContext();
					CharSequence text = "Failed to create socket!";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();
				}

				
				socket.connect();

			ToggleButton notif =  (ToggleButton) findViewById(R.id.toggleButton1);
			notif.setTextOn("Connected");
			notif.setChecked(true);

				

				
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
		*/
        



		ImageButton play = (ImageButton) findViewById(R.id.imageButton4);
		OnClickListener twoListener = new OnClickListener() {
			public void onClick(View v) { Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); vib.vibrate(50);
			
			
				try {
					socket.getOutputStream().write("vlcplay".getBytes());
				} catch (IOException e) {
					Context context = getApplicationContext();
					CharSequence text = "Failed to write to socket!";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();
				}
			}

		};
		play.setOnClickListener(twoListener);
		


		ImageButton pause = (ImageButton) findViewById(R.id.imageButton1);
		OnClickListener pauseListener = new OnClickListener() {
			public void onClick(View v) { Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); vib.vibrate(50);
			
			
				try {
					socket.getOutputStream().write("vlcpause".getBytes());
				} catch (IOException e) {
					Context context = getApplicationContext();
					CharSequence text = "Failed to write to socket!";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();
				}
			}

		};
		pause.setOnClickListener(pauseListener);
		


		ImageButton stop = (ImageButton) findViewById(R.id.imageButton5);
		OnClickListener stopListener = new OnClickListener() {
			public void onClick(View v) { Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); vib.vibrate(50);
			
			
				try {
					socket.getOutputStream().write("vlcstop".getBytes());
				} catch (IOException e) {
					Context context = getApplicationContext();
					CharSequence text = "Failed to write to socket!";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();
				}
			}

		};
		stop.setOnClickListener(stopListener);
		


		ImageButton previous = (ImageButton) findViewById(R.id.imageButton2);
		OnClickListener previousListener = new OnClickListener() {
			public void onClick(View v) { Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); vib.vibrate(50);
			
			
				try {
					socket.getOutputStream().write("vlcprevious".getBytes());
				} catch (IOException e) {
					Context context = getApplicationContext();
					CharSequence text = "Failed to write to socket!";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();
				}
			}

		};
		previous.setOnClickListener(previousListener);
		


		ImageButton next = (ImageButton) findViewById(R.id.imageButton3);
		OnClickListener nextListener = new OnClickListener() {
			public void onClick(View v) { Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); vib.vibrate(50);
			
			
				try {
					socket.getOutputStream().write("vlcnext".getBytes());
				} catch (IOException e) {
					Context context = getApplicationContext();
					CharSequence text = "Failed to write to socket!";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();
				}
			}

		};
		next.setOnClickListener(nextListener);



		ImageButton volumeup = (ImageButton) findViewById(R.id.imageButton7);
		OnClickListener volumeListener = new OnClickListener() {
			public void onClick(View v) { Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); vib.vibrate(50);
			
			
				try {
					socket.getOutputStream().write("vlcvolumeup".getBytes());
				} catch (IOException e) {
					Context context = getApplicationContext();
					CharSequence text = "Failed to write to socket!";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();
				}
			}

		};
		volumeup.setOnClickListener(volumeListener);
		


		ImageButton volumedown = (ImageButton) findViewById(R.id.imageButton8);
		OnClickListener volumedownListener = new OnClickListener() {
			public void onClick(View v) { Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); vib.vibrate(50);
			
			
				try {
					socket.getOutputStream().write("vlcvolumedown".getBytes());
				} catch (IOException e) {
					Context context = getApplicationContext();
					CharSequence text = "Failed to write to socket!";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();
				}
			}

		};
		volumedown.setOnClickListener(volumedownListener);
		
		
		ImageButton mousemode = (ImageButton) findViewById(R.id.ImageButton02);
		OnClickListener mmodeListener = new OnClickListener() {
			public void onClick(View v) { Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); vib.vibrate(50);

				Intent mouseScreen = new Intent(getApplicationContext(),
						MousemodeActivity.class);
				startActivity(mouseScreen);

			}

		};
		mousemode.setOnClickListener(mmodeListener);

		ImageButton keymode = (ImageButton) findViewById(R.id.ImageButton04);
		OnClickListener kmodeListener = new OnClickListener() {
			public void onClick(View v) { Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); vib.vibrate(50);

				Intent keyScreen = new Intent(getApplicationContext(),
						keyboardActivity.class);
				startActivity(keyScreen);

			}

		};
		keymode.setOnClickListener(kmodeListener);

		ImageButton appmode = (ImageButton) findViewById(R.id.ImageButton03);
		OnClickListener amodeListener = new OnClickListener() {
			public void onClick(View v) { Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); vib.vibrate(50);

				Intent appScreen = new Intent(getApplicationContext(),
						ApplicationActivity.class);
				startActivity(appScreen);

			}

		};
		appmode.setOnClickListener(amodeListener);

		ImageButton utilmode = (ImageButton) findViewById(R.id.ImageButton01);
		OnClickListener umodeListener = new OnClickListener() {
			public void onClick(View v) { Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); vib.vibrate(50);

				Intent utilScreen = new Intent(getApplicationContext(),
						utilitiesActivity.class);
				startActivity(utilScreen);

			}

		};
		utilmode.setOnClickListener(umodeListener);
		
	
		
		ImageButton exitmode = (ImageButton) findViewById(R.id.imageButton6);
		OnClickListener exitListener = new OnClickListener() {
			public void onClick(View v) { Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); vib.vibrate(50);


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

		};
		exitmode.setOnClickListener(exitListener);
        
           
        
        
    }
}