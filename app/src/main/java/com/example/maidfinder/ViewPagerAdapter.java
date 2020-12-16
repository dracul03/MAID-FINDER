package com.example.maidfinder;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Objects;

    class ViewPagerAdapter extends PagerAdapter {

        // Context object
        Context context;

        // Array of images
        int[] images;
        int[] headings;
        int[] description;

        // Layout Inflater
        LayoutInflater mLayoutInflater;


        // Viewpager Constructor
        public ViewPagerAdapter(Context context, int[] images,int[] headings,int[] description) {
            this.context = context;
            this.images = images;
            this.headings=headings;
            this.description=description;
            mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            // return the number of images
            return images.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == ((View) object);
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, final int position) {
            // inflating the item.xml
            View itemView = mLayoutInflater.inflate(R.layout.slide_layout, container, false);

            // referencing the image view from the item.xml file
            ImageView image= (ImageView) itemView.findViewById(R.id.imageView);
            TextView heading= (TextView)itemView.findViewById(R.id.heading);
            TextView desc=(TextView)itemView.findViewById(R.id.Description);

            // setting the image in the imageView
            image.setImageResource(images[position]);
            heading.setText(headings[position]);
            desc.setText(description[position]);

            // Adding the View
            Objects.requireNonNull(container).addView(itemView);

            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView((View) object);
        }
    }
