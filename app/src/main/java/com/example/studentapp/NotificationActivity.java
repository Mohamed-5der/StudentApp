package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class NotificationActivity extends AppCompatActivity {
RecyclerView rv_notification;
ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        rv_notification=findViewById(R.id.rv_notification);
        back=findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        setupRvNotification();
    }
    public void setupRvNotification(){
        ArrayList<DataNotification> dataNotifications=new ArrayList<>();
        dataNotifications.add(new DataNotification("Mohamed khedr","3:30 pm","I love You"));
        dataNotifications.add(new DataNotification("Mohamed khedr","3:50 pm","I love You I love You I love You I love You I love You"));
        dataNotifications.add(new DataNotification("Mohamed khedr","3:40 Am",""));
        dataNotifications.add(new DataNotification("Mohamed khedr","3:30 pm","I love You"));
        RecyclerView.LayoutManager lm =new LinearLayoutManager(this);
        NotificationAdapter notificationAdapter =new NotificationAdapter(dataNotifications);
        rv_notification.setHasFixedSize(true);
        rv_notification.setLayoutManager(lm);
        rv_notification.setAdapter(notificationAdapter);

    }
}