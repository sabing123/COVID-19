package com.example.covid_19;

public class StrictMode {

    public  static void StrictMode() {
        android.os.StrictMode.ThreadPolicy policy =
                new android.os.StrictMode.ThreadPolicy.Builder().permitAll().build();

        android.os.StrictMode.setThreadPolicy(policy);

    }
}
