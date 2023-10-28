package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Onboarding_Activity extends AppCompatActivity {


    ViewPager msliderviewpager;
    LinearLayout mDotLayout;

    Button nextbtn, skipbtn;

    TextView[] dots;

    ViewPagerAdapiter viewPagerAdapiter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        nextbtn = findViewById(R.id.nextButton);
        skipbtn = findViewById(R.id.skipButton);

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (getitem(0)< 3 )
                    msliderviewpager.setCurrentItem(getitem(1),true);
                else {
                    Intent i = new Intent(Onboarding_Activity.this,LoginActivity.class);
                    startActivity(i);
                    finish();
                }


            }
        });

        skipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i = new Intent(Onboarding_Activity.this,LoginActivity.class);
                startActivity(i);
                finish();
            }
        });




        msliderviewpager = (ViewPager) findViewById(R.id.sliderViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.indicator_layout);

        viewPagerAdapiter = new ViewPagerAdapiter(this);


        msliderviewpager.setAdapter(viewPagerAdapiter);

        setUpindicator(0);
        msliderviewpager.addOnPageChangeListener(viewlistener);


    }

    public void setUpindicator(int position) {

        dots = new TextView[4];
        mDotLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {


            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.purple_200, getApplicationContext().getTheme()));
            mDotLayout.addView(dots[i]);
        }

        dots[position].setTextColor(getResources().getColor(R.color.purple_200, getApplicationContext().getTheme()));

    }

    ViewPager.OnPageChangeListener viewlistener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }


    };
    private int getitem(int i){

        return  msliderviewpager.getCurrentItem() + i ;

    }


}