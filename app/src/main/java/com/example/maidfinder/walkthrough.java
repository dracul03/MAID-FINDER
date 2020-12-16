package com.example.maidfinder;


import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class walkthrough extends AppCompatActivity {

    // creating object of ViewPager
    ViewPager mViewPager;
    LinearLayout dotslayout;

    // images array
    int[] images = {R.drawable.usrlogo, R.drawable.maplogo, R.drawable.protctlogo};
    int[] headings= {R.string.first_slide_title,R.string.second_slide_title, R.string.third_slide_title};
    int[] description={R.string.first_slide_desc,R.string.second_slide_desc,R.string.third_slide_desc};
    Button mskip;


    // Creating Object of ViewPagerAdapter
    ViewPagerAdapter mViewPagerAdapter;
    TextView[] dots;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrough);

        // Initializing the ViewPager Object
        mViewPager = (ViewPager)findViewById(R.id.viewPagerMain);
        mskip=findViewById(R.id.skip);
        dotslayout=findViewById(R.id.dts);

        mskip.setOnClickListener((View.OnClickListener) view -> {
            Intent intent=new Intent(walkthrough.this,choose.class);
            startActivity(intent);
            finish();
        });


        // Initializing the ViewPagerAdapter
        mViewPagerAdapter = new ViewPagerAdapter(walkthrough.this, images,headings,description);

        // Adding the Adapter to the ViewPager
        mViewPager.setAdapter(mViewPagerAdapter);
        addDots(0);
        mViewPager.addOnPageChangeListener(changeListener);

    }
    private void addDots(int position){
        dots=new TextView[3];
        dotslayout.removeAllViews();
        for(int i=0;i<dots.length;i++){
            dots[i]=new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);

            dotslayout.addView(dots[i]);
        }
        if(dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.design_default_color_primary_dark));
        }
    }
    ViewPager.OnPageChangeListener changeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}