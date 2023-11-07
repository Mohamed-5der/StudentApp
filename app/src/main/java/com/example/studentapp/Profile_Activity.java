package com.example.studentapp;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Profile_Activity extends AppCompatActivity {

    RelativeLayout edit;
    Button save;
    TextView gender;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        edit = findViewById(R.id.edit);
        gender =findViewById(R.id.txt_selectGender);
        save = findViewById(R.id.btn_save);


        gender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showContinueAsDialog();
            }
        });


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile_Activity.this,Edit_Password_Activity.class);
                startActivity(intent);
                finish();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }


    public void showDialog() {
        final Dialog dialog = new Dialog(Profile_Activity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.request_save_data);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();
        ImageButton close=dialog.findViewById(R.id.btn_close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }




    public void showContinueAsDialog(){
        final Dialog dialog = new Dialog(Profile_Activity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.gender_custom_dialog);
        dialog.show();
        dialog.setCanceledOnTouchOutside(true);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.getWindow().getAttributes().windowAnimations =R.style.DialoAnimation;
        LinearLayout male =dialog.findViewById(R.id.l_male);
        LinearLayout female =dialog.findViewById(R.id.l_female);
        ImageButton close=dialog.findViewById(R.id.btn_close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.dismiss();
            }
        });
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender.setText(R.string.male);
                dialog.dismiss();

            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender.setText(R.string.female);
                dialog.dismiss();
            }
        });

}
    }