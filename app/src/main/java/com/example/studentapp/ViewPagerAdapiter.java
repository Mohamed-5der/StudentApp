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
            R.string.body,
            R.string.body,
            R.string.body

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

        TextView slidertitle =  view.findViewById(R.id.texttitle);
        TextView sliderbody = (TextView) view.findViewById(R.id.body);



        slidertitle.setText(title[position]);
        sliderbody.setText(bodys[position]);


        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((LinearLayout)object);

    }
}
