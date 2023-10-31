package com.example.studentapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnswerQuizAdapter extends RecyclerView.Adapter<AnswerViewHolder> {
    ArrayList<Answer> answers=new ArrayList<>();

    public AnswerQuizAdapter(ArrayList<Answer> answers) {
        this.answers=answers;
    }

    @NonNull
    @Override
    public AnswerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_solve_quiz,null,false);
        return new AnswerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AnswerViewHolder holder, int position) {
        Answer answer=answers.get(position);
        holder.onBind(answer);
    }

    @Override
    public int getItemCount() {
        return answers.size();
    }
}
class AnswerViewHolder extends RecyclerView.ViewHolder{
    RadioGroup answerRadioGroup;
    public AnswerViewHolder(@NonNull View itemView) {
        super(itemView);
        answerRadioGroup=itemView.findViewById(R.id.answerRG);

    }
    public void onBind(Answer answer){

        answerRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedRadioButton =itemView.findViewById(checkedId);
                String selectedAnswer = selectedRadioButton.getText().toString();
                Toast.makeText(itemView.getContext(), selectedAnswer, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
class Answer{
    public Answer() {
    }
}

