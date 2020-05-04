package com.example.covid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import com.example.covid_19.ui.home.HomeFragment;

public class CheckingNetworkActivity extends AppCompatActivity {

    private Boolean wifiConnected = false;
    private Boolean mobileConnected = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checking_network);
        checkingNetwrokConnection();
    }

    private void checkingNetwrokConnection() {

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo !=null && networkInfo.isConnected()){
            wifiConnected = networkInfo.getType() == ConnectivityManager.TYPE_WIFI;
            mobileConnected = networkInfo.getType() == ConnectivityManager.TYPE_MOBILE;

            if(wifiConnected){
                Intent intent = new Intent(CheckingNetworkActivity.this, MainActivity.class);
                startActivity(intent);

            }
           else if(mobileConnected){
                Intent intent = new Intent(CheckingNetworkActivity.this, MainActivity.class);
                startActivity(intent);

            }
            else{
                Intent intent = new Intent(CheckingNetworkActivity.this, CheckingNetworkActivity.class);
                startActivity(intent);

            }


        }


    }
}
