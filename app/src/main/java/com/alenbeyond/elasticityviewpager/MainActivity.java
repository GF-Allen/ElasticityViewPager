package com.alenbeyond.elasticityviewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager vpImage;
    private List<Integer> images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vpImage = (ViewPager) findViewById(R.id.vp_image);
        images = new ArrayList<>();
        images.add(R.mipmap.link1);
        images.add(R.mipmap.link1);
        images.add(R.mipmap.link2);
        images.add(R.mipmap.link1);
        images.add(R.mipmap.link1);
        images.add(R.mipmap.link2);
        images.add(R.mipmap.link1);
        vpImage.setAdapter(new MyAdapter(this,images));
    }

    static class MyAdapter extends PagerAdapter{

        private Context context;
        private List<Integer> data;

        public MyAdapter(Context context, List<Integer> data) {
            this.context = context;
            this.data = data;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = View.inflate(context, R.layout.viewpager_item, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_image);
            imageView.setImageResource(data.get(position));
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }

}
