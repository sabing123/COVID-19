package com.example.covid_19.ui.home;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.covid_19.API.LOC;
import com.example.covid_19.R;
import com.example.covid_19.model.Nepalidetails;
import com.google.gson.JsonObject;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private TextView text_conformed, text_death, text_recovered;
    private HomeViewModel homeViewModel;

//    for nepali details
        private TextView tvnepaltotal,tvnepalpositive,tvnepalnegative,tvisolation,
        tvnepalquarantined,tvnepalrecovered,tvnepalrdt,tvnepaldeaths;

    class Corona extends AsyncTask<String, Void, String> {// first String means Url is in string, Void mean nothing, Third String means return type will be in string


        @Override
        protected String doInBackground(String... address) {
//String... means multiple address can be send. It acts as array
            try {
                URL url = new URL(address[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                //Establish connection with address
                connection.connect();

                //retrieve data from url
                InputStream is = connection.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);

                //Retrieve data and return it as String
                int data = isr.read();
                String content = "";
                char ch;
                while (data != -1) {
                    ch = (char) data;
                    content = content + ch;
                    data = isr.read();
                }
                Log.i("Content", content);
                return content;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        text_conformed = root.findViewById(R.id.text_confirmed);
        text_recovered = root.findViewById(R.id.text_recovered);
       // text_death = root.findViewById(R.id.text_death);


        tvnepaltotal = root.findViewById(R.id.tvnepaltotal);
        tvisolation = root.findViewById(R.id.tvisolation);
        tvnepaldeaths = root.findViewById(R.id.tvnepaldeaths);
        tvnepalnegative = root.findViewById(R.id.tvnepalnegative);
        tvnepalpositive = root.findViewById(R.id.tvnepalpositive);
        tvnepalquarantined = root.findViewById(R.id.tvnepalquarantined);
        tvnepalrecovered = root.findViewById(R.id.tvnepalrecovered);
        tvnepalrdt = root.findViewById(R.id.tvnepalrdt);

        showdetails();

        shownepaldetail();
        return root;


    }

    private void shownepaldetail() {
        LOC loc = com.example.covid_19.URL.getInstance().create(LOC.class);
        final Call<Nepalidetails> nepalidetailsCall = loc.getnepal();
        nepalidetailsCall.enqueue(new Callback<Nepalidetails>() {
            @Override
            public void onResponse(Call<Nepalidetails> call, Response<Nepalidetails> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), "Failed to loading........" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                String total = "", positive = "", negative = "",
                        deaths = "", recovered = "", quarantined = "",
                        isolation = "", rdt = "";

                total += response.body().getTested_total();  tvnepaltotal.setText(total);
                positive += response.body().getTested_positive(); tvnepalpositive.setText(positive);
                negative += response.body().getTested_negative(); tvnepalnegative.setText(negative);
                deaths += response.body().getDeaths(); tvnepaldeaths.setText(deaths);
                recovered += response.body().getRecovered(); tvnepalrecovered.setText(recovered);
                quarantined += response.body().getQuarantined(); tvnepalquarantined.setText(quarantined);
                isolation += response.body().getIn_isolation(); tvisolation.setText(isolation);
                rdt += response.body().getTested_rdt(); tvnepalrdt.setText(rdt);


            }

            @Override
            public void onFailure(Call<Nepalidetails> call, Throwable t) {
                final ProgressDialog progressDialog = new ProgressDialog(getContext());
                progressDialog.setMessage("Loading...");
                progressDialog.show();

                Log.d("Error",t.getMessage());
            }
        });


    }

    private void showdetails() {
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        String details;
        String image;
        Corona corona = new Corona();
        try {
            details = corona.execute("https://covid19.mathdro.id/api?fbclid=IwAR0ClbfIuCJZrZqisIvTxXl7GROSEANVfMTw2WD5HIU23rR10jrO9VNSfiI").get();

            //First we will check data is retrieve successfully or not
            Log.i("contentData", details);

            //JSON
            JSONObject jsonObject = new JSONObject(details);

//            For confirmed Value
            String confirmed = jsonObject.getString("confirmed");
            String cvalue = "";
            JSONObject mainconfirmed = new JSONObject(confirmed);
            cvalue = mainconfirmed.getString("value");
            Log.i("value", confirmed);
            text_conformed.setText(cvalue);

            // For Recovered data
            String recovered = jsonObject.getString("recovered");
            String Rvalue = "";
            JSONObject mainrecovered = new JSONObject(recovered);
            Rvalue = mainrecovered.getString("value");
            Log.i("value", recovered);
            text_recovered.setText(Rvalue);


            // For Deaths data
            String deaths = jsonObject.getString("deaths");
            String dvalue = "";
            JSONObject maindeaths = new JSONObject(deaths);
            dvalue = maindeaths.getString("value");
            Log.i("value", deaths);
           // text_death.setText(dvalue);
            progressDialog.dismiss();

//            String image = jsonObject.getString("image");

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
