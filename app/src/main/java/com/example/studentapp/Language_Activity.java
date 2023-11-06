package com.example.studentapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Language_Activity extends AppCompatActivity {

   ImageButton ARI;
   ImageButton ENG;

   Button con;
   Button profile;
    private boolean isResume;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);


        Button confirm =findViewById(R.id.confirm);
        ARI= findViewById(R.id.ARI);
        ENG= findViewById(R.id.ENG);

        

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isResume==false){
                    Toast.makeText(Language_Activity.this,"Choose Language",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent =new Intent(Language_Activity.this,Onboarding_Activity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
        ARI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isResume){
                    isResume= true;
                    ARI.setImageDrawable(getResources().getDrawable(
                            R.drawable.chosen_circle
                    ));
                    ENG.setImageDrawable(getResources().getDrawable(
                            R.drawable.circle
                    ));
                }
                else {
                    isResume=false;
                    ARI.setImageDrawable(getResources().getDrawable(
                            R.drawable.circle
                    ));
                    ENG.setImageDrawable(getResources().getDrawable(
                            R.drawable.chosen_circle
                    ));
                }

            }
        });

        ENG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isResume) {
                    isResume = true;
                    ENG.setImageDrawable(getResources().getDrawable(
                            R.drawable.chosen_circle
                    ));
                    ARI.setImageDrawable(getResources().getDrawable(
                            R.drawable.circle
                    ));

                } else {
                    isResume = false;
                    ENG.setImageDrawable(getResources().getDrawable(
                            R.drawable.circle
                    ));
                    ARI.setImageDrawable(getResources().getDrawable(
                            R.drawable.chosen_circle
                    ));
                }
            }
        });

    }

}