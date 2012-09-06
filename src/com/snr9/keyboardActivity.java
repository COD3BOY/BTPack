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
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class keyboardActivity extends Activity {
    /** Called when the activity is first created. */
	private BluetoothSocket socket;
	BluetoothDevice device;

	String fromkeyboard="fromkeyboard-";
	BluetoothAdapter mBluetoothAdapter;
	
	@Override
    public void onBackPressed () {
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
        setContentView(R.layout.keyboard);
        

    /*	mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

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

        connect.setOnClickListener(connectListener);*/
		
        
/*
        EditText myEditText = (EditText) findViewById(R.id.editText1);
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(myEditText, InputMethodManager.SHOW_FORCED);

       
        
        InputMethodManager imm = (InputMethodManager)
          keyboardActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE);

        	if (imm != null){
        	    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
        	}

       */
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE); 

        final EditText myEditText = (EditText) findViewById(R.id.editText1);
        myEditText.addTextChangedListener(new TextWatcher() {
			
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
			}
			
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			public void afterTextChanged(Editable s) {
				
				try {
					socket.getOutputStream().write(((fromkeyboard)+myEditText.getText().toString()).toUpperCase().getBytes());
				} catch (IOException e) {
					Context context = getApplicationContext();
					CharSequence text = "Failed to write to socket!";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();
				}
				// TODO Auto-generated method stub
				
			}
		}); 
        
		ImageButton mousemode = (ImageButton) findViewById(R.id.imageButton3);
		OnClickListener mmodeListener = new OnClickListener() {
			public void onClick(View v) { Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); vib.vibrate(50);

				Intent mouseScreen = new Intent(getApplicationContext(),
						MousemodeActivity.class);
				startActivity(mouseScreen);

			}

		};
		mousemode.setOnClickListener(mmodeListener);

		ImageButton keymode = (ImageButton) findViewById(R.id.imageButton4);
		OnClickListener kmodeListener = new OnClickListener() {
			public void onClick(View v) { Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); vib.vibrate(50);

				Intent keyScreen = new Intent(getApplicationContext(),
						keyboardActivity.class);
				startActivity(keyScreen);

			}

		};
		keymode.setOnClickListener(kmodeListener);

		ImageButton appmode = (ImageButton) findViewById(R.id.imageButton1);
		OnClickListener amodeListener = new OnClickListener() {
			public void onClick(View v) { Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); vib.vibrate(50);

				Intent appScreen = new Intent(getApplicationContext(),
						ApplicationActivity.class);
				startActivity(appScreen);

			}

		};
		appmode.setOnClickListener(amodeListener);

		ImageButton utilmode = (ImageButton) findViewById(R.id.imageButton2);
		OnClickListener umodeListener = new OnClickListener() {
			public void onClick(View v) { Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); vib.vibrate(50);

				Intent utilScreen = new Intent(getApplicationContext(),
						utilitiesActivity.class);
				startActivity(utilScreen);

			}

		};
		utilmode.setOnClickListener(umodeListener);
		
		ImageButton exitmode = (ImageButton) findViewById(R.id.imageButton5);
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