package com.tuwan.android.myapplication;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by gumenghao on 2018/5/14.
 */
public class FragAdapter extends FragmentPagerAdapter {
    private List<Fragment> listFragment;
    private Context context;

    public FragAdapter(FragmentManager fm, List<Fragment> listFragment, Context context) {
        super(fm);
        this.listFragment = listFragment;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }
}
