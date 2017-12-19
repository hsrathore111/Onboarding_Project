package com.example.himmat.onboarding_project;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager slider_viewpager;
    private LinearLayout mlayout;
    private Slider_Adapter sliderAdapter;

    private TextView[] mdots;
    private Button mnextbtn, mbackbtn;

    private int mcurrentpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbackbtn = (Button) findViewById(R.id.mbackbtn);
        mnextbtn = (Button) findViewById(R.id.mnextbtn);
        slider_viewpager = (ViewPager) findViewById(R.id.slider_viewpager);
        mlayout = (LinearLayout) findViewById(R.id.mlayout);
        sliderAdapter = new Slider_Adapter(this);
        slider_viewpager.setAdapter(sliderAdapter);
        addDotsIndicator(0);
        slider_viewpager.addOnPageChangeListener(viewlistner);
        mnextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             slider_viewpager.setCurrentItem(mcurrentpage+1);

            }
        });

       mbackbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
            slider_viewpager.setCurrentItem(mcurrentpage-1);
           }
       });
    }

    public void addDotsIndicator(int position) {

        mdots = new TextView[3];
        mlayout.removeAllViews();
        for (int i = 0; i < mdots.length; i++) {

            mdots[i] = new TextView(this);
            mdots[i].setText(Html.fromHtml("&#8226;"));
            mdots[i].setTextSize(35);
            mdots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            mlayout.addView(mdots[i]);
        }
        if (mdots.length > 0) {

            mdots[position].setTextColor(getResources().getColor(R.color.colorWhite));

        }

    }

    ViewPager.OnPageChangeListener viewlistner = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDotsIndicator(position);
            mcurrentpage = position;
            if (position == 0) {
                mnextbtn.setEnabled(true);
                mbackbtn.setEnabled(false);
                mbackbtn.setVisibility(View.INVISIBLE);
                mnextbtn.setText("next");
                mbackbtn.setText("");
            } else if (position == mdots.length-1) {

                mnextbtn.setEnabled(true);
                mbackbtn.setEnabled(true);
                mbackbtn.setVisibility(View.VISIBLE);
                mnextbtn.setText("finish");
                mbackbtn.setText("back");
            } else {

                mnextbtn.setEnabled(true);
                mbackbtn.setEnabled(true);
                mbackbtn.setVisibility(View.VISIBLE);
                mnextbtn.setText("next");
                mbackbtn.setText("back");
            }

        }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

   };
}