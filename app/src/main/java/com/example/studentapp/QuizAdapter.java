package com.example.studentapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuizAdapter extends RecyclerView.Adapter<QuizViewHolder> {

    ArrayList<DataQuiz> dataQuizs ;

    public QuizAdapter(ArrayList<DataQuiz> dataQuizs) {
        this.dataQuizs = dataQuizs;
    }

    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_quiz , null , false);
        return new QuizViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizViewHolder holder, int position) {
        DataQuiz dataQuiz = dataQuizs.get(position);
        holder.onBind(dataQuiz);
    }

    @Override
    public int getItemCount() {
        return dataQuizs.size();
    }
}
    class QuizViewHolder extends RecyclerView.ViewHolder{
    TextView nameQuiz;
    ImageButton goQuiz;
    public QuizViewHolder(@NonNull View itemView) {
        super(itemView);
        nameQuiz = itemView.findViewById(R.id.txt_nameQuiz);
        goQuiz = itemView.findViewById(R.id.btn_goQuiz);
    }

    public void onBind(DataQuiz dataQuiz){
        nameQuiz.setText(dataQuiz.getName());
        goQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
