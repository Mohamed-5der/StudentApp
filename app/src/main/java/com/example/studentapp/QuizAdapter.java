package com.example.studentapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuizAdapter extends RecyclerView.Adapter<QuizViewHolder> {

    ArrayList<DataQuiz> dataQuizzes ;
    AppCompatActivity activity ;

    public QuizAdapter(ArrayList<DataQuiz> dataQuizzes) {
        this.dataQuizzes = dataQuizzes;
    }

    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_quiz , null , false);
        activity = (AppCompatActivity) parent.getContext();
        return new QuizViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizViewHolder holder, int position) {
        DataQuiz dataQuiz = dataQuizzes.get(position);
        holder.onBind(dataQuiz , activity);
    }

    @Override
    public int getItemCount() {
        return dataQuizzes.size();
    }
}
    class QuizViewHolder extends RecyclerView.ViewHolder{
    TextView nameQuiz ,resultQuiz;
    ImageButton goQuiz;
    public QuizViewHolder(@NonNull View itemView) {
        super(itemView);
        nameQuiz = itemView.findViewById(R.id.txt_nameQuiz);
        resultQuiz = itemView.findViewById(R.id.txt_result);
        goQuiz = itemView.findViewById(R.id.btn_goQuiz);
    }

    public void onBind(DataQuiz dataQuiz ,  AppCompatActivity activity){
        nameQuiz.setText(dataQuiz.getName());
        resultQuiz.setText(dataQuiz.getResult());
        goQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(activity,QuizActivity.class);
                itemView.getContext().startActivity(intent);
            }
        });
    }
}
