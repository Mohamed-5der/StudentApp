package com.example.studentapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.QuizViewHolder> {
    @NonNull
    @Override
    public QuizAdapter.QuizViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=  LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_quiz,null,false);
        QuizViewHolder viewHolder=new QuizViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull QuizAdapter.QuizViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class QuizViewHolder extends RecyclerView.ViewHolder{
        TextView nameQuiz;
        ImageButton goQuiz;
        public QuizViewHolder(@NonNull View itemView) {
            super(itemView);
            nameQuiz=itemView.findViewById(R.id.txt_nameQuiz);
            goQuiz=itemView.findViewById(R.id.btn_goQuiz);
        }
    }
}
