package com.example.studentapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.studentapp.R;

public class ViewPagerAdapiter extends PagerAdapter {



    Context context;


    int title[] = {
            R.string.title,
            R.string.title,
            R.string.title
    };

    int bodys[] = {
            R.string.body1,
            R.string.body2,
            R.string.body3
    };

    public  ViewPagerAdapiter(Context context){

        this.context = context;

    }


    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout,container,false);

        TextView slidertitle = (TextView) view.findViewById(R.id.texttitle);
        TextView sliderbody1 = (TextView) view.findViewById(R.id.body1);
        TextView sliderbody2 = (TextView) view.findViewById(R.id.body2);
        TextView sliderbody3 = (TextView) view.findViewById(R.id.body3);


        slidertitle.setText(title[position]);
        sliderbody1.setText(bodys[position]);
        sliderbody2.setText(bodys[position]);
        sliderbody3.setText(bodys[position]);

        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((LinearLayout)object);

    }
}
