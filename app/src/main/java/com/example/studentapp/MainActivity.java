package com.example.studentapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    TextView namePage;
    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    MoreFragment moreFragment = new MoreFragment();
    FilesFragment filesFragment = new FilesFragment();
    AttendanceFragment attendanceFragment = new AttendanceFragment();
    QuizFragment quizFragment = new QuizFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        namePage=findViewById(R.id.txt_namePage);
        fragmentShow();


    }

    public void fragmentShow() {
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(
                new NavigationBarView.OnItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_home:
                                getSupportFragmentManager()
                                        .beginTransaction()
                                        .replace(R.id.container, homeFragment)
                                        .commit();
                                namePage.setText(R.string.home);
                                return true;
                            case R.id.action_attendance:
                                getSupportFragmentManager().beginTransaction().replace(R.id.container, attendanceFragment).commit();
                                namePage.setText(R.string.attendance);


                                return true;
                            case R.id.action_quiz:
                                getSupportFragmentManager().beginTransaction().replace(R.id.container, quizFragment).commit();
                                namePage.setText(R.string.quiz);
                                return true;
                            case R.id.action_files:
                                getSupportFragmentManager().beginTransaction().replace(R.id.container, filesFragment).commit();
                                namePage.setText(R.string.files);
                                return true;
                            case R.id.action_more:
                                getSupportFragmentManager().beginTransaction().replace(R.id.container, moreFragment).commit();
                                namePage.setText(R.string.more);
                                return true;

                        }
                        return false;
                    }
                });
    }

}