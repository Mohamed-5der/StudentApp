package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {
AnswerQuizAdapter answerQuizAdapter;
RecyclerView rv_Answer;
Button submit;
ImageButton back;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        rv_Answer = findViewById(R.id.rv_solveQuiz);
        submit = findViewById(R.id.btn_submit);
        back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        setupRvAnswerQuiz();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSureDialog();

            }
        });

    }
    public void setupRvAnswerQuiz(){
        ArrayList<Answer> dataAnswer = new ArrayList<>();
        dataAnswer.add(new Answer());
        dataAnswer.add(new Answer());
        dataAnswer.add(new Answer());
        dataAnswer.add(new Answer());
        answerQuizAdapter = new AnswerQuizAdapter(dataAnswer);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv_Answer.setLayoutManager(lm);
        rv_Answer.setAdapter(answerQuizAdapter);
        rv_Answer.setHasFixedSize(true);
        rv_Answer.setHasFixedSize(true);
    }
    public void showSureDialog(){
        final Dialog dialog = new Dialog(QuizActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.sure_submit);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();
        Button yes =dialog.findViewById(R.id.btn_yes);
        Button no =dialog.findViewById(R.id.btn_no);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                showSendAnswerDialog();

            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });

    }
    public void showSendAnswerDialog(){
        final Dialog dialog = new Dialog(QuizActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.sent_answer);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();
        Button quizAnswer =dialog.findViewById(R.id.btn_quizAnswer);

        quizAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizActivity.this,HomeFragment.class);
                startActivity(intent);
                dialog.dismiss();
                finish();

            }
        });


    }



}