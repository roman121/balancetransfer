package com.example.phonecall2;

import android.R.string;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      final EditText phn = (EditText) findViewById(R.id.phone);
    //  String a = phn.getText().toString();
      final EditText sec = (EditText) findViewById(R.id.seccode);
      final EditText bal = (EditText) findViewById(R.id.balance);
      //final String number = phn.getText().toString();
      //final String security = sec.getText().toString();
      //final String balance = bal.getText().toString();

      Button startBtn = (Button) findViewById(R.id.makeCall);
      startBtn.setOnClickListener(new View.OnClickListener() {
         public void onClick(View arg0) {
        
        	 
        	 makeCall(phn,sec,bal);
      }
   });

   }
   protected void makeCall(TextView phn, TextView sec, TextView bal) {
	   //String number = phn.getText().toString();
	  String mobno=  phn.getText().toString();
	  String security = sec.getText().toString();
	  long callnum = 422L;
      //Log.i("", "");
	  
      String balance=bal.getText().toString();
      
      String encodedHash = Uri.encode("#");
      String ussd = "*"+ callnum +"*" +security +"*" +mobno +"*" +balance+encodedHash;
      Intent phoneIntent = new Intent(Intent.ACTION_CALL);
      phoneIntent.setData(Uri.parse("tel:" + ussd ));

      try {
         startActivity(phoneIntent);
         finish();
         Log.i("Finished making a call...", "");
      } catch (android.content.ActivityNotFoundException ex) {
         Toast.makeText(MainActivity.this, 
         "Call faild, please try again later.", Toast.LENGTH_SHORT).show();
      }
   }
   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.main, menu);
      return true;
   }
}