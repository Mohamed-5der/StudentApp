package com.example.studentapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class MoreFragment extends Fragment {
    CardView profile,change,contact,terms,privecy,logout;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
       View v = inflater.inflate(R.layout.fragment_more, container, false);
       profile= v.findViewById(R.id.card_profile);
       change= v.findViewById(R.id.card_language);
       contact= v.findViewById(R.id.card_contact);
       terms= v.findViewById(R.id.card_terms);
       privecy= v.findViewById(R.id.card_privacy);
       logout= v.findViewById(R.id.card_logout);

       profile.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(getContext(),Profile_Activity.class);
               startActivity(intent);
           }
       });
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),Language_Activity.class);
                startActivity(intent);
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),Contact_Activity.class);
                startActivity(intent);
            }
        });
        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),Terms_Activity.class);
                startActivity(intent);
            }
        });
        privecy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),Privecy_Activity.class);
                startActivity(intent);
            }
        });
        logout  .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),Profile_Activity.class);
                startActivity(intent);
            }
        });


       return v;
    }

}