package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    PagerAdapter adapter;
    List<ImageView> views = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ImageView image1 = new ImageView(this);
        image1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        image1.setBackgroundResource(R.drawable.one);
        ImageView image2 = new ImageView(this);
        image2.setBackgroundResource(R.drawable.two);
        ImageView image3 = new ImageView(this);
        image3.setBackgroundResource(R.drawable.threee);
        ImageView image4 = new ImageView(this);
        image4.setBackgroundResource(R.drawable.four);
        ImageView image5 = new ImageView(this);
        image5.setBackgroundResource(R.drawable.five);

        views.add(image1);
        views.add(image2);
        views.add(image3);
        views.add(image4);
        views.add(image5);

        adapter = new PagerAdapter(){
            @Override
            public int getCount() {
                return views.size();
            }
            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }
            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView(views.get(position));
            }
            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                container.addView(views.get(position));
                return views.get(position);
            }
        };

        MyFragment f1 = new MyFragment(1);
        MyFragment f2 = new MyFragment(2);
        MyFragment f3 = new MyFragment(3);
        MyFragment f4 = new MyFragment(4);
        MyFragment f5 = new MyFragment(5);

        List<Fragment> fList = new ArrayList<>();
        fList.add(f1);
        fList.add(f2);
        fList.add(f3);
        fList.add(f4);
        fList.add(f5);

        PagerAdapter adapter1 = new FragmentPagerAdapter(getSupportFragmentManager()){

            @Override
            public int getCount() {
                return 5;
            }

            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fList.get(position);
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return ""+position;
            }
        };

        binding.viewpager.setAdapter(adapter1);
        binding.viewpager.addOnAdapterChangeListener(new ViewPager.OnAdapterChangeListener() {
            @Override
            public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter oldAdapter, @Nullable PagerAdapter newAdapter) {

            }
        });
//
//        binding.tablayout.addTab(binding.tablayout.newTab().setText("1"));
//        binding.tablayout.addTab(binding.tablayout.newTab().setText("2"));
//        binding.tablayout.addTab(binding.tablayout.newTab().setText("3"));
//        binding.tablayout.addTab(binding.tablayout.newTab().setText("4"));
//        binding.tablayout.addTab(binding.tablayout.newTab().setText("5"));

        binding.tablayout.setupWithViewPager(binding.viewpager);
    }


}