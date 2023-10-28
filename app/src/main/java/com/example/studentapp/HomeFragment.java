package com.example.studentapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    RecyclerView rv_Quiz ,rv_review;
    ReviewAdapter reviewAdapter;
    QuizAdapter quizAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View v=  inflater.inflate(R.layout.fragment_home, container, false);
        rv_Quiz= v.findViewById(R.id.rv_quiz);
        rv_review= v.findViewById(R.id.rv_review);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRvQuiz();
        setupRvReview();
    }
    public void setupRvQuiz(){
        ArrayList<DataQuiz> data = new ArrayList<>();
        data.add(new DataQuiz("Quiz 1"));
        data.add(new DataQuiz("Quiz 2"));
        data.add(new DataQuiz("Quiz 3"));
        quizAdapter = new QuizAdapter(data);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(getActivity());
        rv_Quiz.setLayoutManager(lm);
        rv_Quiz.setAdapter(quizAdapter);
    }
    public void setupRvReview(){
        ArrayList<DataReview> data = new ArrayList<>();
        data.add(new DataReview("Review 1"));
        data.add(new DataReview("Review 2"));
        data.add(new DataReview("Review 3"));
        reviewAdapter = new ReviewAdapter(data);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(getActivity());
        rv_review.setLayoutManager(lm);
        rv_review.setAdapter(reviewAdapter);
    }


}