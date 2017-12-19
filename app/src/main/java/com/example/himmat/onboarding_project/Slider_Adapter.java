package com.example.himmat.onboarding_project;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Hi on 12/17/2017.
 */

public class Slider_Adapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;



    public Slider_Adapter(Context context){

    this.context=context;
    }

    //-----Array---//

    public int[] slider={
    R.drawable.ican_1,
            R.drawable.ican_2,
            R.drawable.ican_3
    };

    public String[] text={

            "EAT","SLIP","CODE"

    };



    @Override
    public int getCount() {
        return slider.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view ==(RelativeLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
    layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);


        View view=layoutInflater.inflate(R.layout.slider_layout,container,false);

        ImageView image=(ImageView)view.findViewById(R.id.imageid);

        TextView textid=(TextView)view.findViewById(R.id.textid);

        image.setImageResource(slider[position]);

        textid.setText(text[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((RelativeLayout)object);
    }
}

