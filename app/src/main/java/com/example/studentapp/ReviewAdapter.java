package com.example.studentapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewViewHolder> {

    ArrayList<DataReview> dataReviews ;

    public ReviewAdapter(ArrayList<DataReview> dataReviewas) {
        this.dataReviews = dataReviewas;
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_review , null , false);
        return new ReviewViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        DataReview dataReview = dataReviews.get(position);
        holder.onBind(dataReview);
    }

    @Override
    public int getItemCount() {
        return dataReviews.size();
    }
}
    class ReviewViewHolder extends RecyclerView.ViewHolder{
    TextView nameReview;
    ImageButton downloadReview;
    public ReviewViewHolder(@NonNull View itemView) {
        super(itemView);
        nameReview = itemView.findViewById(R.id.txt_nameReview);
        downloadReview = itemView.findViewById(R.id.btn_Download);
    }

    public void onBind(DataReview dataReview){
        nameReview.setText(dataReview.getName1());
        downloadReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
