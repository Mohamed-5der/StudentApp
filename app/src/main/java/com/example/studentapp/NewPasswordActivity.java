package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

public class NewPasswordActivity extends AppCompatActivity {
Button save;
ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password);
    save =findViewById(R.id.btn_save);
    back =findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    save.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            showContinueAsDialog();
        }
    });
    }
    public void showContinueAsDialog(){
                final Dialog dialog = new Dialog(NewPasswordActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.sucsessfully);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.show();
                Button tourist =dialog.findViewById(R.id.btn_home);
                tourist.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(NewPasswordActivity.this,LoginActivity.class);
                        startActivity(intent);
                        dialog.dismiss();
                        finish();
                    }
                });
     }


}