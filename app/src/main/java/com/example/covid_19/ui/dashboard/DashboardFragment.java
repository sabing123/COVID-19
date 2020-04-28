package com.example.covid_19.ui.dashboard;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_19.API.LOC;
import com.example.covid_19.ListAdapter;
import com.example.covid_19.R;
import com.example.covid_19.URL;
import com.example.covid_19.model.listofcountry;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    ListAdapter listAdapter;
    List<listofcountry> listofcountries;
    RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        recyclerView = root.findViewById(R.id.recyclerview);
        listofcon();


        return root;
    }

    private void listofcon() {
        listofcountries = new ArrayList<>();
        LOC loc = URL.getInstance().create(LOC.class);
      Call<List<listofcountry>> listCall = loc.getList();
      listCall.enqueue(new Callback<List<listofcountry>>() {
          @Override
          public void onResponse(Call<List<listofcountry>> call, Response<List<listofcountry>> response) {
              if (!response.isSuccessful()) {
                  Toast.makeText(getContext(), "Error" + response.code(), Toast.LENGTH_SHORT).show();
                  return;
              }

              List<listofcountry> listofcountries1 = response.body();
              listAdapter = new ListAdapter(getContext(),listofcountries1);
              recyclerView.setAdapter(listAdapter);
              recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));


          }

          @Override
          public void onFailure(Call<List<listofcountry>> call, Throwable t) {
              Log.d("Error Message", "Error" + t.getLocalizedMessage());
              Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
          }
      });

    }
}
