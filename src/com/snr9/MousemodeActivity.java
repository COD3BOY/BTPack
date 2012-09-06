package com.snr9;

import java.io.IOException;
import com.snr9.MyApplication;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MousemodeActivity extends Activity {


	int flag;
	private BluetoothSocket socket;
	BluetoothDevice device;

	byte[] backup = new byte[256000];
	
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
		setContentView(R.layout.mousemode);

		
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

					
					 * EditText name = (EditText)
					 * findViewById(R.id.editText1);
					 * name.setText(name.getText() + device.getName() +
					 * "\n");
					 

				}
			}
		};
        
		// Register the BroadcastReceiver
		IntentFilter filter = new IntentFilter(
				BluetoothDevice.ACTION_FOUND);
		registerReceiver(mReceiver, filter);
		
		

		Button connect = (Button) findViewById(R.id.button3);
		OnClickListener connectListener = new OnClickListener() {
			public void onClick(View v) { Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); vib.vibrate(50);
				

				try {

					mBluetoothAdapter.cancelDiscovery();
					BluetoothDevice device2 = mBluetoothAdapter
							.getRemoteDevice("00:15:83:07:CA:F8");
					
					 * name1.setText(name1.getText() +
					 * device2.getAddress().toString());
					 

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

					 name1.setText(name1.getText() + "Test2"); 
					socket.connect();

					ToggleButton notif = (ToggleButton) findViewById(R.id.toggleButton1);
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

		ImageButton up = (ImageButton) findViewById(R.id.imageButton1);
		OnClickListener upListener = new OnClickListener() {
			public void onClick(View v) { Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); vib.vibrate(50);


			try {
				socket.getOutputStream().write("screen-capture".getBytes());
				
			
				
			} catch (Exception e) {
				Context context = getApplicationContext();
				CharSequence text = "Failed to write to socket!";
				int duration = Toast.LENGTH_SHORT;

				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
			}
			
			
			
			try {
			     	byte[] testarray = new byte[256000];
			     	
			   int k;
			     if((k=socket.getInputStream().available())>0){
			     		
			     	
					socket.getInputStream().read(testarray);
					
					backup=testarray;
					
					Bitmap bmp=BitmapFactory.decodeByteArray(testarray,0,testarray.length);
					ImageView image = (ImageView) findViewById(R.id.imageView1);
					image.setImageBitmap(bmp);
					
					/*Context context = getApplicationContext();
					CharSequence text = "success!";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();*/
			     	}
			     else
			     {
			    	 Bitmap bmp=BitmapFactory.decodeByteArray(backup,0,backup.length);
						ImageView image = (ImageView) findViewById(R.id.imageView1);
						image.setImageBitmap(bmp);
			     }
			   
			} catch (Exception e1) {
				Context context = getApplicationContext();
				CharSequence text = "Errorr!";
				int duration = Toast.LENGTH_SHORT;

				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
			}
			
			
				try {
					socket.getOutputStream().write("up".getBytes());
				} catch (IOException e) {
					Context context = getApplicationContext();
					CharSequence text = "Failed to send data to socket!";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();
				}
			}

		};
		up.setOnClickListener(upListener);

		ImageButton dw = (ImageButton) findViewById(R.id.imageButton4);
		OnClickListener dwListener = new OnClickListener() {
			public void onClick(View v) { Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); vib.vibrate(50);


			try {
				socket.getOutputStream().write("screen-capture".getBytes());
				
			
				
			} catch (Exception e) {
				Context context = getApplicationContext();
				CharSequence text = "Failed to write to socket!";
				int duration = Toast.LENGTH_SHORT;

				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
			}
			
			
			
			try {
			     	byte[] testarray = new byte[256000];
			   int k;
			     if((k=socket.getInputStream().available())>0){
			     		
			     	
					socket.getInputStream().read(testarray);
					
					Bitmap bmp=BitmapFactory.decodeByteArray(testarray,0,testarray.length);
					ImageView image = (ImageView) findViewById(R.id.imageView1);
					image.setImageBitmap(bmp);
					
				/*	Context context = getApplicationContext();
					CharSequence text = "success!";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();*/
			     	}
			     
			} catch (Exception e1) {
				Context context = getApplicationContext();
				CharSequence text = "Errorr!";
				int duration = Toast.LENGTH_SHORT;

				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
			}
			
				try {
					socket.getOutputStream().write("dw".getBytes());
				} catch (IOException e) {
					Context context = getApplicationContext();
					CharSequence text = "Failed to send data to socket!";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();
				}
			}

		};
		dw.setOnClickListener(dwListener);

		ImageButton le = (ImageButton) findViewById(R.id.imageButton2);
		OnClickListener leListener = new OnClickListener() {
			public void onClick(View v) { Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); vib.vibrate(50);


			try {
				socket.getOutputStream().write("screen-capture".getBytes());
				
			
				
			} catch (Exception e) {
				Context context = getApplicationContext();
				CharSequence text = "Failed to write to socket!";
				int duration = Toast.LENGTH_SHORT;

				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
			}
			
			
			
			try {
			     	byte[] testarray = new byte[256000];
			   int k;
			     if((k=socket.getInputStream().available())>0){
			     		
			     	
					socket.getInputStream().read(testarray);
					
					Bitmap bmp=BitmapFactory.decodeByteArray(testarray,0,testarray.length);
					ImageView image = (ImageView) findViewById(R.id.imageView1);
					image.setImageBitmap(bmp);
					/*
					Context context = getApplicationContext();
					CharSequence text = "success!";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();*/
			     	}
			     
			} catch (Exception e1) {
				Context context = getApplicationContext();
				CharSequence text = "Errorr!";
				int duration = Toast.LENGTH_SHORT;

				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
			}
			
				try {
					socket.getOutputStream().write("le".getBytes());
				} catch (IOException e) {
					Context context = getApplicationContext();
					CharSequence text = "Failed to send data to socket!";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();
				}
			}

		};
		le.setOnClickListener(leListener);

		ImageButton ri = (ImageButton) findViewById(R.id.imageButton3);
		OnClickListener riListener = new OnClickListener() {
			public void onClick(View v) { Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); vib.vibrate(50);

			

			try {
				socket.getOutputStream().write("screen-capture".getBytes());
				
			
				
			} catch (Exception e) {
				Context context = getApplicationContext();
				CharSequence text = "Failed to write to socket!";
				int duration = Toast.LENGTH_SHORT;

				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
			}
			
			
			
			try {
			     	byte[] testarray = new byte[256000];
			   int k;
			     if((k=socket.getInputStream().available())>0){
			     		
			     	
					socket.getInputStream().read(testarray);
					
					Bitmap bmp=BitmapFactory.decodeByteArray(testarray,0,testarray.length);
					ImageView image = (ImageView) findViewById(R.id.imageView1);
					image.setImageBitmap(bmp);
					
					/*Context context = getApplicationContext();
					CharSequence text = "success!";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();*/
			     	}
			    
			} catch (Exception e1) {
				Context context = getApplicationContext();
				CharSequence text = "Errorr!";
				int duration = Toast.LENGTH_SHORT;

				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
			}
			
				try {
					socket.getOutputStream().write("ri".getBytes());
				} catch (IOException e) {
					Context context = getApplicationContext();
					CharSequence text = "Failed to send data to socket!";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();
				}
			}

		};
		ri.setOnClickListener(riListener);

		Button clk = (Button) findViewById(R.id.button2);
		OnClickListener clkListener = new OnClickListener() {
			public void onClick(View v) { Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); vib.vibrate(50);

				try {
					socket.getOutputStream().write("clk".getBytes());
				} catch (IOException e) {
					Context context = getApplicationContext();
					CharSequence text = "Failed to send data to socket!";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();
				}
			}

		};
		clk.setOnClickListener(clkListener);
		


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