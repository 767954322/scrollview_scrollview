package com.tuwan.android.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ViewPager vp_viewpager;
    private List<Fragment> listFragment = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp_viewpager = (ViewPager) findViewById(R.id.vp_viewpager);
        initList();
        vp_viewpager.setOffscreenPageLimit(3);
        vp_viewpager.setAdapter(new FragAdapter(getSupportFragmentManager(), listFragment, MainActivity.this));

    }

    private void initList() {
        listFragment.add(new FirstFragment(getSupportFragmentManager()));
        listFragment.add(new TwoFragment(getSupportFragmentManager()));
        listFragment.add(new ThreeFragment(getSupportFragmentManager()));
    }

}
