package com.example.covid_19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_19.model.listofcountry;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    Context mContext;
    List<listofcountry> listList;

    public ListAdapter(Context mContext, List<listofcountry> listList) {
        this.mContext = mContext;
        this.listList = listList;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listlayout, parent, false);

        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        listofcountry listofcountry = listList.get(position);
        holder.etconname.setText(listofcountry.getCountry());
        holder.etconfirmedcases.setText(listofcountry.getTotalCases());
        holder.etrecoveredcases.setText(listofcountry.getTotalRecovered());
        holder.etdeathscases.setText(listofcountry.getTotalDeaths());
        holder.etactivecases.setText(listofcountry.getActiveCases());

    }

    @Override
    public int getItemCount() {
        return listList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        TextView etconname, etconfirmedcases, etrecoveredcases, etdeathscases,etactivecases,etincidentRatecases;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            etconname = itemView.findViewById(R.id.etcon);
            etconfirmedcases = itemView.findViewById(R.id.etcomcases);
            etrecoveredcases = itemView.findViewById(R.id.etreccases);
            etdeathscases = itemView.findViewById(R.id.etdeathscases);
            etactivecases = itemView.findViewById(R.id.etactivecases);
        }
    }
}
