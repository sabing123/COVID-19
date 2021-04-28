package com.example.covid_19;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_19.model.AndroidVersion;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private ArrayList<AndroidVersion> android;

    public NewsAdapter(ArrayList<AndroidVersion> android) {
        this.android = android;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.newslayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.newstitle.setText(android.get(position).getTitle());
        holder.newssource.setText(android.get(position).getSource());
        holder.newssummary.setText(android.get(position).getSummary());
        holder.newsUrl.setText(android.get(position).getUrl());
    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView newstitle, newssource, newssummary,newsUrl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            newstitle = itemView.findViewById(R.id.etnewstitle);
            newssource = itemView.findViewById(R.id.etnewssource);
            newssummary = itemView.findViewById(R.id.etnewssummary);
            newsUrl = itemView.findViewById(R.id.etnewsurl);

        }
    }
}
