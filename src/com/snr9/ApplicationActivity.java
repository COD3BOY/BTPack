package com.snr9;

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

public class ApplicationActivity extends Activity {
	
	


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
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	MyApplication appSocket = ((MyApplication)getApplicationContext());
    	socket =  appSocket.getSocket();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.application);
       
        

		ImageButton mousemode = (ImageButton) findViewById(R.id.ImageButton02);
		OnClickListener mmodeListener = new OnClickListener() {
			public void onClick(View v) { 
				Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
				vib.vibrate(50);		
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
		
		ImageButton browsermode = (ImageButton) findViewById(R.id.imageButton1);
		OnClickListener browserListener = new OnClickListener() {
			public void onClick(View v) { Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); vib.vibrate(50);

				Intent browserScreen = new Intent(getApplicationContext(),
						browserActivity.class);
				startActivity(browserScreen);

			}

		};
		browsermode.setOnClickListener(browserListener);
		
		ImageButton mediaplayermode = (ImageButton) findViewById(R.id.imageButton3);
		OnClickListener mediaListener = new OnClickListener() {
			public void onClick(View v) { Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); vib.vibrate(50);

				Intent mediaScreen = new Intent(getApplicationContext(),
						mediaplayerActivity.class);
				startActivity(mediaScreen);

			}

		};
		mediaplayermode.setOnClickListener(mediaListener);
		
		ImageButton mediamode = (ImageButton) findViewById(R.id.imageButton4);
		OnClickListener medListener = new OnClickListener() {
			public void onClick(View v) { Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); vib.vibrate(50);

				Intent mediaScreen = new Intent(getApplicationContext(),
						mediaplayerActivity.class);
				startActivity(mediaScreen);

			}

		};
		mediamode.setOnClickListener(medListener);
		
		ImageButton mediamod = (ImageButton) findViewById(R.id.imageButton5);
		OnClickListener meListener = new OnClickListener() {
			public void onClick(View v) { Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); vib.vibrate(50);

				Intent mediaScreen = new Intent(getApplicationContext(),
						mediaplayerActivity.class);
				startActivity(mediaScreen);

			}

		};
		mediamod.setOnClickListener(meListener);
		
		ImageButton presentation = (ImageButton) findViewById(R.id.imageButton2);
		OnClickListener presentationListener = new OnClickListener() {
			public void onClick(View v) { Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); vib.vibrate(50);

				Intent mediaScreen = new Intent(getApplicationContext(),
						presentationActivity.class);
				startActivity(mediaScreen);

			}

		};
		presentation.setOnClickListener(presentationListener);
        
    }
}