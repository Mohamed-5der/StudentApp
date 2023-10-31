package com.example.studentapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class QuizFragment extends Fragment {
QuizAdapter quizAdapter;
RecyclerView rv_quizToday, rv_quizHistory;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_quiz, container, false);
        rv_quizToday = v.findViewById(R.id.rv_quiz_today);
        rv_quizHistory = v.findViewById(R.id.rv_quizHistory);
        setupRvQuizToday();
        setupRvQuizHistory();

        return v;

    }
    public void setupRvQuizToday(){
        ArrayList<DataQuiz> data = new ArrayList<>();
        data.add(new DataQuiz("Quiz 1",""));
        quizAdapter = new QuizAdapter(data);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(getActivity());
        rv_quizToday.setLayoutManager(lm);
        rv_quizToday.setAdapter(quizAdapter);
        rv_quizToday.setHasFixedSize(true);

    }
    public void setupRvQuizHistory(){
        ArrayList<DataQuiz> data = new ArrayList<>();
        data.add(new DataQuiz("Quiz 1","20_30"));
        data.add(new DataQuiz("Quiz 2","20_30"));
        data.add(new DataQuiz("Quiz 3","20_30"));
        data.add(new DataQuiz("Quiz 4","20_30"));
        data.add(new DataQuiz("Quiz 5","20_30"));
        data.add(new DataQuiz("Quiz 6","20_30"));
        data.add(new DataQuiz("Quiz 7","20_30"));
        quizAdapter = new QuizAdapter(data);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(getActivity());
        rv_quizHistory.setLayoutManager(lm);
        rv_quizHistory.setAdapter(quizAdapter);
        rv_quizHistory.setHasFixedSize(true);

    }

}