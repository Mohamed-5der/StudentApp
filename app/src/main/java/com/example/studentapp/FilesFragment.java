package com.example.studentapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FilesFragment extends Fragment {
RecyclerView rv_review;
ReviewAdapter reviewAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_files, container, false);
        rv_review = v.findViewById(R.id.rv_review);
        setupRvReview();


        return v;
    }
    public void setupRvReview(){
        ArrayList<DataReview> dataReviews=new ArrayList<>();
        dataReviews.add(new DataReview("Review note"));
        dataReviews.add(new DataReview("Review note"));
        dataReviews.add(new DataReview("Review note"));
        dataReviews.add(new DataReview("Review note"));
        dataReviews.add(new DataReview("Review note"));
        dataReviews.add(new DataReview("Review note"));
        dataReviews.add(new DataReview("Review note"));
        reviewAdapter = new ReviewAdapter(dataReviews);
        RecyclerView.LayoutManager lm=new LinearLayoutManager(getActivity());
        rv_review.setLayoutManager(lm);
        rv_review.setAdapter(reviewAdapter);
        rv_review.setHasFixedSize(true);
    }
}