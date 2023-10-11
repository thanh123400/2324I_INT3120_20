package com.example.telephone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Intent whoYouGonnaCall = new Intent(Intent.ACTION_DIAL);
//        whoYouGonnaCall.setData(Uri.parse("tel:0942434289"));
//        startActivity(whoYouGonnaCall);
        Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:0363017112"));
        smsIntent.putExtra("sms_body", "Press send to send me");
        startActivity(smsIntent);


    }
}