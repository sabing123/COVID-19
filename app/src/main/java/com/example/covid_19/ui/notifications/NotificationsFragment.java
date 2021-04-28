package com.example.covid_19.ui.notifications;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_19.API.LOC;
import com.example.covid_19.NewsAdapter;
import com.example.covid_19.R;
import com.example.covid_19.Response.JSONResponse;
import com.example.covid_19.model.AndroidVersion;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;



    private RecyclerView newsrecyclerView;
    private ArrayList<AndroidVersion> data;
    private NewsAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        //listofnews();
        newsrecyclerView = root.findViewById(R.id.newsrecyclerview);
        initnews();

        return root;
    }

    private void initnews() {

        newsrecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        newsrecyclerView.setLayoutManager(layoutManager);
        newsJSON();
//        adapter.notifyDataSetChanged();

    }

    private void newsJSON() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://corona.askbhunte.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LOC request = retrofit.create(LOC.class);
        Call<JSONResponse> call = request.getJSON();
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {

                if (!response.isSuccessful()) {
                    final ProgressDialog progressDialog = new ProgressDialog(getContext());
                    progressDialog.setMessage("Loading...");
                    progressDialog.show();
                    progressDialog.dismiss();
                    Toast.makeText(getContext(), "Error: API is not responding... " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                final ProgressDialog progressDialog = new ProgressDialog(getContext());
                progressDialog.setMessage("Loading...");
                progressDialog.show();

                JSONResponse jsonResponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                adapter = new NewsAdapter(data);
                newsrecyclerView.setAdapter(adapter);

                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                final ProgressDialog progressDialog = new ProgressDialog(getContext());
                progressDialog.setMessage("Loading...");
                progressDialog.show();

                Log.d("Error",t.getMessage());
            }
        });



    }


//
}
